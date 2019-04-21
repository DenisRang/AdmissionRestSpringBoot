package ru.myuniversity.admissionrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.myuniversity.admissionrest.http.request.programs.ChangeProgramRequestBody;
import ru.myuniversity.admissionrest.http.response.programs.ProgramDetailedResponse;
import ru.myuniversity.admissionrest.http.response.programs.ProgramResponse;
import ru.myuniversity.admissionrest.service.programs.ProgramsService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ProgramsRestController {
    private ProgramsService programsService;

    @Autowired
    public ProgramsRestController(ProgramsService programsService) {
        this.programsService = programsService;
    }

    @GetMapping("/programs")
    public List<ProgramResponse> getPrograms() {
        return programsService.getPrograms().stream().map(ProgramResponse::new).collect(Collectors.toList());
    }

    @DeleteMapping("/programs/{programId}")
    public void deleteProgram(@PathVariable int programId) {
        programsService.deleteProgram(programId);
    }

    @GetMapping("/programs/{programId}")
    public ProgramDetailedResponse getProgram(@PathVariable int programId) {
        return new ProgramDetailedResponse(
                programsService.getProgram(programId),
                programsService.getProgramTests(programId)
        );
    }

    @PutMapping("/programs/{programId}")
    public void updateProgram(@PathVariable int programId, @RequestBody ChangeProgramRequestBody changeProgramRequestBody) {
        programsService.updateProgram(programId, changeProgramRequestBody.getTests(), changeProgramRequestBody.getTitle());
    }
}
