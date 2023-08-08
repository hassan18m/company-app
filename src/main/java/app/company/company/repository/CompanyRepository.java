package app.company.company.repository;

import app.company.company.controller.model.Field;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, String> {
    Optional<Company> findByName(String name);

    Optional<List<Company>> findByField(Field fieldName);

    List<Company> findByRequiredExperience(int experience);
}
