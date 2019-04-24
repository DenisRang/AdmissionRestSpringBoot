package ru.myuniversity.admissionrest.service.programs;

import org.springframework.lang.Nullable;
import ru.myuniversity.admissionrest.model.programs.Program;
import ru.myuniversity.admissionrest.model.test.Test;

import java.util.List;

public interface ProgramsService {
    Program getProgram(int id);
    void deleteProgram(int id);
    void updateProgram(int programId, @Nullable List<Integer> tests, @Nullable String title);
    List<Test> getProgramTests(int programId);
    Program createProgram(Program newProgramInfo);
    List<Program> getPrograms();
}
