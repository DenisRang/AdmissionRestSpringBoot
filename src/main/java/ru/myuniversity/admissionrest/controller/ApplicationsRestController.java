package ru.myuniversity.admissionrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import ru.myuniversity.admissionrest.http.request.application.ApplicationStatusBody;
import ru.myuniversity.admissionrest.http.request.application.ApplicationStatusBodyToPojoMapper;
import ru.myuniversity.admissionrest.http.request.application.ApplicationStatusName;
import ru.myuniversity.admissionrest.http.response.applications.ApplicationListResponseItem;
import ru.myuniversity.admissionrest.http.response.applications.ApplicationResponse;
import ru.myuniversity.admissionrest.http.response.programs.ProgramResponse;
import ru.myuniversity.admissionrest.http.response.users.UserResponse;
import ru.myuniversity.admissionrest.model.applications.Application;
import ru.myuniversity.admissionrest.model.applications.ApplicationStatus;
import ru.myuniversity.admissionrest.model.applications.ApplicationStatusPojoToResponseMapper;
import ru.myuniversity.admissionrest.service.applications.ApplicationsService;
import ru.myuniversity.admissionrest.service.programs.ProgramsService;
import ru.myuniversity.admissionrest.service.users.UsersService;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ApplicationsRestController {
    private ApplicationsService applicationsService;
    private UsersService usersService;
    private ProgramsService programsService;

    @Autowired
    public ApplicationsRestController(ApplicationsService applicationsService, UsersService usersService, ProgramsService programsService) {
        this.applicationsService = applicationsService;
        this.usersService = usersService;
        this.programsService = programsService;
    }

    @PutMapping("/applications/{applicationId}")
    public void setApplicationStatus(@PathVariable int applicationId, @RequestBody ApplicationStatusBody newStatusBody) {
        applicationsService.setApplicationStatus(applicationId, ApplicationStatusBodyToPojoMapper.map(newStatusBody));
    }

    @GetMapping("/applications/{applicationId}")
    public ApplicationResponse getApplication(@PathVariable int applicationId) {
        Application application = applicationsService.getApplication(applicationId);
        return new ApplicationResponse(
                application.getId(),
                new UserResponse(usersService.getUser(application.getCandidateId())),
                Collections.emptyList(),
                application.getHistory().stream().map(ApplicationStatusPojoToResponseMapper::map).collect(Collectors.toList())
            );
    }

    @GetMapping("/applications")
    public List<ApplicationListResponseItem> getApplications(@RequestParam @Nullable String candidate, @RequestParam @Nullable ApplicationStatusName status) {
        ApplicationStatus.StringKey statusKey = null;
        if (status != null) statusKey = status.toPojoStatus();

        List<Application> applications = applicationsService.getApplications(statusKey, candidate);
        return applications.stream()
                .map(pojoApplication -> new ApplicationListResponseItem(
                        pojoApplication.getId(),
                        new ProgramResponse(programsService.getProgram(pojoApplication.getProgramId())),
                        new UserResponse(usersService.getUser(pojoApplication.getCandidateId())),
                        ApplicationStatusPojoToResponseMapper.map(pojoApplication.getStatus())
                ))
                .collect(Collectors.toList());
    }
}
