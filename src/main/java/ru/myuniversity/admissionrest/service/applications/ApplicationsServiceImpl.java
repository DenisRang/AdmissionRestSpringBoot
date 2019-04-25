package ru.myuniversity.admissionrest.service.applications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.myuniversity.admissionrest.entity.ProgramEntity;
import ru.myuniversity.admissionrest.entity.application.ApplicationEntity;
import ru.myuniversity.admissionrest.entity.application.ApplicationStatusEntity;
import ru.myuniversity.admissionrest.entity.application.ApplicationStatusToPojoMapper;
import ru.myuniversity.admissionrest.entity.application.InitialStatusEntity;
import ru.myuniversity.admissionrest.entity.user.CandidateEntity;
import ru.myuniversity.admissionrest.http.response.applications.ApplicationResponse;
import ru.myuniversity.admissionrest.model.applications.Application;
import ru.myuniversity.admissionrest.model.applications.ApplicationStatus;
import ru.myuniversity.admissionrest.model.applications.InitialStatus;
import ru.myuniversity.admissionrest.repository.ApplicationRepository;
import ru.myuniversity.admissionrest.repository.ApplicationStatusRepository;
import ru.myuniversity.admissionrest.repository.ProgramRepository;
import ru.myuniversity.admissionrest.repository.user.CandidateRepository;
import ru.myuniversity.admissionrest.repository.user.StaffRepository;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicationsServiceImpl implements ApplicationsService {
    private ApplicationRepository applicationRepository;
    private ApplicationStatusRepository applicationStatusRepository;
    private CandidateRepository candidateRepository;
    private StaffRepository staffRepository;
    private ProgramRepository programRepository;

    @Autowired
    public ApplicationsServiceImpl(ApplicationRepository applicationRepository,
                                   ApplicationStatusRepository applicationStatusRepository,
                                   CandidateRepository candidateRepository,
                                   StaffRepository staffRepository,
                                   ProgramRepository programRepository) {
        this.applicationRepository = applicationRepository;
        this.applicationStatusRepository = applicationStatusRepository;
        this.candidateRepository = candidateRepository;
        this.staffRepository = staffRepository;
        this.programRepository = programRepository;
    }

    @Override
    public List<Application> getApplications(ApplicationStatus.StringKey statusFilter, String candidateNameFilter, Integer candidateId) {
        return applicationRepository.findAll().stream()
                .map(applicationEntity -> {
                    List<ApplicationStatus> history = applicationStatusRepository.findAllByApplication(applicationEntity)
                            .stream()
                            .map(applicationStatusEntity -> ApplicationStatusToPojoMapper.map(applicationStatusEntity))
                            .collect(Collectors.toList());
                    return new Application(applicationEntity.getId(),
                            applicationEntity.getProgram().getId(),
                            applicationEntity.getCandidateEntity().getId(),
                            history);
                })
                .filter(application -> {
                    if (candidateId != null)
                        return application.getCandidateId() == candidateId;
                    else
                        return true;
                }).collect(Collectors.toList());
    }

    @Override
    public Application getApplication(int id) {
        ApplicationEntity applicationEntity=applicationRepository.findById(id).get();
        List<ApplicationStatus> history = applicationStatusRepository.findAllByApplication(applicationEntity)
                .stream()
                .map(applicationStatusEntity -> ApplicationStatusToPojoMapper.map(applicationStatusEntity))
                .collect(Collectors.toList());
        return new Application(applicationEntity.getId(),
                applicationEntity.getProgram().getId(),
                applicationEntity.getCandidateEntity().getId(),
                history);
    }

    @Override
    public void setApplicationStatus(int applicationId, ApplicationStatus newStatus) {
        ApplicationEntity applicationEntity=applicationRepository.findById(applicationId).get();

    }

    @Override
    public Application createApplication(Application application) {
        ProgramEntity programEntity = programRepository.findById(application.getProgramId()).get();
        CandidateEntity candidateEntity = candidateRepository.findById(application.getCandidateId()).get();
        ApplicationStatusEntity statusEntity = new InitialStatusEntity(null,null);

        ApplicationEntity applicationEntity = new ApplicationEntity(programEntity, candidateEntity, statusEntity);
        ApplicationEntity applicationEntityDb = applicationRepository.save(applicationEntity);
        application.setId(application.getId());
        application.setHistory(Arrays.asList(ApplicationStatusToPojoMapper.map(applicationEntityDb.getStatus())));
        return application;
    }
}
