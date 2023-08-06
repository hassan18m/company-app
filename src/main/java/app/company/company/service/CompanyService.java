package app.company.company.service;

import app.company.company.controller.model.CompanyRequest;
import app.company.company.controller.model.CompanyResponse;
import app.company.company.repository.Company;
import app.company.company.repository.CompanyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    private static CompanyResponse entityToResponse(Company company) {
        return new CompanyResponse(
                company.getId(),
                company.getName(),
                company.getField()
        );
    }

    private static Company requestToEntity(CompanyRequest companyRequest) {
        Company company = new Company();
        company.setId(UUID.randomUUID().toString().substring(0, 6));
        company.setName(companyRequest.getName());
        company.setField(companyRequest.getField());
        return company;
    }
}
