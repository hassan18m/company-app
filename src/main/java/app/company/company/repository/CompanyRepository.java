package app.company.company.repository;

import app.company.company.controller.model.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, String> {
    Optional<Company> findByName(String name);
    List<Company> findByField(Field field);

    @Query("SELECT c FROM company c WHERE c.requiredExperience <= :experience")
    List<Company> findByRequiredExperience(@Param("experience") int experience);
}
