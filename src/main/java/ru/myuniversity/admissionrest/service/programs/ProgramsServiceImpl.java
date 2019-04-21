package ru.myuniversity.admissionrest.service.programs;

import org.springframework.stereotype.Service;
import ru.myuniversity.admissionrest.model.programs.Program;
import ru.myuniversity.admissionrest.model.test.Test;

import java.util.Collections;
import java.util.List;

@Service
public class ProgramsServiceImpl implements ProgramsService {
    @Override
    public Program getProgram(int id) {
        // TODO: Repository
        return new Program(id, "CS Bachelor");
    }

    @Override
    public void deleteProgram(int id) {
        // TODO: Repository
    }

    @Override
    public void createProgram(Program newProgramInfo) {
        // TODO: Repository
    }

    @Override
    public List<Program> getPrograms() {
        // TODO: Repository
        return Collections.singletonList(new Program(1, "CS Bachelor"));
    }

    @Override
    public void updateProgram(int programId, List<Integer> tests, String title) {
        // TODO: Repository
    }

    @Override
    public List<Test> getProgramTests(int programId) {
        // TODO: Repository
        return Collections.singletonList(new Test(1, "English — Intermediate"));
    }
}
