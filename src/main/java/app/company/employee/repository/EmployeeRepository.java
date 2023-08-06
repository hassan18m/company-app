package app.company.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    boolean existsByWorkEmail(String workEmail);

    boolean existsByPhoneNumber(String phoneNumber);

    Employee getEmployeeByWorkEmail(String email);
    void deleteById(String id);

}
