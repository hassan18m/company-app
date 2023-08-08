package app.company.company.service;

import app.company.company.controller.model.CompanyRequest;
import app.company.company.controller.model.CompanyResponse;
import app.company.company.controller.model.Field;
import app.company.company.repository.Company;
import app.company.company.repository.CompanyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CompanyService {
    private static final Logger logger = LoggerFactory.getLogger(CompanyService.class);
    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public CompanyResponse saveCompany(CompanyRequest companyRequest) {
        Company company = requestToEntity(companyRequest);
        companyRepository.save(company);
        logger.info("Persisted new company with data: {}", company);
        return entityToResponse(company);
    }

    public CompanyResponse findById(String id) {
        Company company = companyRepository.findById(id).orElseThrow(RuntimeException::new);
        return entityToResponse(company);
    }

    public CompanyResponse findByName(String name) {
        Company company = companyRepository.findByName(name).orElseThrow(RuntimeException::new);
        return entityToResponse(company);
    }

    public Company findByField(Field fieldName) {
        List<Company> companyList = companyRepository.findByField(fieldName).orElseThrow(RuntimeException::new);
        return companyList.stream()
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    private static CompanyResponse entityToResponse(Company company) {
        return new CompanyResponse(
                company.getId(),
                company.getName(),
                company.getField(),
                company.getRequiredExperience()
        );
    }

    private static Company requestToEntity(CompanyRequest companyRequest) {
        Company company = new Company();
        company.setId(UUID.randomUUID().toString().substring(0, 6));
        company.setName(companyRequest.getName());
        company.setField(companyRequest.getField());
        company.setRequiredExperience(companyRequest.getRequiredExperience());
        return company;
    }
}
