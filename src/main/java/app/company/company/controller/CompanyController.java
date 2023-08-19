package app.company.company.controller;

import app.company.company.controller.model.CompanyRequest;
import app.company.company.controller.model.CompanyResponse;
import app.company.company.controller.model.Field;
import app.company.company.repository.Company;
import app.company.company.service.CompanyService;
import app.company.employee.controller.exceptions.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company")
public class CompanyController {
    private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);
    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    public ResponseEntity<CompanyResponse> insertCompany(@RequestBody CompanyRequest companyRequest) {
        logger.info("Received new company post request with data: {}", companyRequest);
        CompanyResponse companyResponse = companyService.saveCompany(companyRequest);
        return ResponseEntity.ok(companyResponse);
    }

    @GetMapping("{id}")
    public ResponseEntity<CompanyResponse> getCompanyById(@PathVariable("id") String id) {
        logger.info("Received company get request with id: {}", id);
        return ResponseEntity.ok(companyService.findById(id));
    }

    @GetMapping
    public ResponseEntity<CompanyResponse> getCompanyByName(@RequestParam("name") String name) {
        logger.info("Received company get request with name: {}", name);
        return ResponseEntity.ok(companyService.findByName(name));
    }

    @GetMapping("/field")
    public ResponseEntity<Company> getCompanyByField(@RequestParam("name") Field fieldName) {
        logger.info("Received company get request with field: {}", fieldName.name());
        return ResponseEntity.ok(companyService.findByField(fieldName));
    }

    @GetMapping("/experience")
    public ResponseEntity<List<Company>> getCompaniesByRequiredExperience(@RequestParam("required") int experience) {
        return ResponseEntity.ok(companyService.findByRequiredExperience(experience));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> removeCompanyById(@PathVariable("id") String id) {
        logger.info("Received new company delete request with id: {}", id);
        try {
            companyService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
