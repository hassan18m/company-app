package app.company.employee.controller;

import app.company.employee.controller.exceptions.NotFoundException;
import app.company.employee.controller.model.EmployeeRequest;
import app.company.employee.controller.model.EmployeeResponse;
import app.company.global_exceptions.ErrorResponse;
import app.company.employee.repository.DuplicateDataException;
import app.company.employee.service.EmployeeService;
import app.company.employee.service.InvalidOccupationException;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("/api/employee")
public class EmployeeController {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<?> insertEmployee(@RequestBody @Valid EmployeeRequest employeeRequest) {
        logger.info("Received new employee post request with data: {}", employeeRequest);
        try {
            return ResponseEntity.ok(employeeService.saveEmployee(employeeRequest));
        } catch (DuplicateDataException e) {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setErrorCode(ErrorResponse.CLIENT_ERROR_CODE);
            errorResponse.setErrorMessage("Duplicate data was found on the request");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
        } catch (NotFoundException e) {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setErrorCode(ErrorResponse.COMPANY_ERROR_CODE);
            errorResponse.setErrorMessage("Company with requested requirements not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        } catch (InvalidOccupationException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getEmployeeByEmail(@RequestParam("email") String email) {
        logger.info("Request received with email: {}", email);
        try {
            return ResponseEntity.ok(employeeService.getEmployeeByEmail(email));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable("id") String id) {
        logger.info("Request received with id: {}", id);
        try {
            EmployeeResponse employee = employeeService.getById(id);
            return ResponseEntity.ok(employee);
        } catch (NotFoundException e) {
            logger.info(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Return an empty body for 404 response
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") String employeeId) {
        logger.info("Received employee delete request with id: {}", employeeId);
        try {
            employeeService.deleteEmployeeById(employeeId);
            return ResponseEntity.noContent().build();
        } catch (NotFoundException e) {
            logger.info("Employee with ID {} not found in our DB", employeeId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PatchMapping("/email/{id}")
    public ResponseEntity<?> updateEmail(@PathVariable("id") String id, @RequestParam String newEmail) {
        logger.info("Received employee patch request with id: {} to new email: {}", id, newEmail);
        try {
            return ResponseEntity.ok(employeeService.updateEmail(id, newEmail));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


}
