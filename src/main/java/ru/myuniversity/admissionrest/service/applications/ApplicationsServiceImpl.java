package ru.myuniversity.admissionrest.service.applications;

import org.springframework.stereotype.Service;
import ru.myuniversity.admissionrest.model.applications.Application;
import ru.myuniversity.admissionrest.model.applications.ApplicationStatus;
import ru.myuniversity.admissionrest.model.applications.InitialStatus;

import java.util.Collections;
import java.util.List;

@Service
public class ApplicationsServiceImpl implements ApplicationsService {
    @Override
    public List<Application> getApplications(ApplicationStatus.StringKey statusFilter, String candidateNameFilter) {
        // TODO: implementation with repository
        return Collections.singletonList(new Application(1, 1, 1, Collections.singletonList(new InitialStatus())));
    }

    @Override
    public Application getApplication(int id) {
        // TODO: repository
        return new Application(id, 1, 1, Collections.singletonList(new InitialStatus()));
    }

    @Override
    public void setApplicationStatus(int applicationId, ApplicationStatus newStatus) {
        // TODO: implement
    }
}
