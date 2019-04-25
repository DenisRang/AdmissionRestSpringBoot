package ru.myuniversity.admissionrest.service.applications;

import org.springframework.lang.Nullable;
import ru.myuniversity.admissionrest.model.applications.Application;
import ru.myuniversity.admissionrest.model.applications.ApplicationStatus;

import java.util.List;

public interface ApplicationsService {
    List<Application> getApplications(@Nullable ApplicationStatus.StringKey statusFilter, @Nullable String candidateNameFilter, @Nullable Integer candidateId);
    Application getApplication(int id);
    void setApplicationStatus(int applicationId, ApplicationStatus newStatus);
    Application createApplication(Application newApplication);
}
