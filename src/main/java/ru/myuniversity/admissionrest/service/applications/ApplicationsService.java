package ru.myuniversity.admissionrest.service.applications;

import ru.myuniversity.admissionrest.model.applications.Application;
import ru.myuniversity.admissionrest.model.applications.ApplicationStatus;

import java.util.List;

public interface ApplicationsService {
    List<Application> getApplications(ApplicationStatus.StringKey statusFilter, String candidateNameFilter);
    Application getApplication(int id);
    void setApplicationStatus(int applicationId, ApplicationStatus newStatus);
    Application createApplication(Application newApplication);
}
