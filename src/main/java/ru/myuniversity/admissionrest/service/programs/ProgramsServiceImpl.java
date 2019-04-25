package ru.myuniversity.admissionrest.service.programs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.myuniversity.admissionrest.entity.ProgramEntity;
import ru.myuniversity.admissionrest.entity.TestEntity;
import ru.myuniversity.admissionrest.model.programs.Program;
import ru.myuniversity.admissionrest.model.test.Test;
import ru.myuniversity.admissionrest.repository.ProgramRepository;
import ru.myuniversity.admissionrest.repository.TestRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProgramsServiceImpl implements ProgramsService {
    private ProgramRepository programRepository;
    private TestRepository testRepository;

    @Autowired
    public ProgramsServiceImpl(ProgramRepository programRepository, TestRepository testRepository) {
        this.programRepository = programRepository;
        this.testRepository = testRepository;
    }

    @Override
    public Program getProgram(int id) {
        Optional<ProgramEntity> optional = programRepository.findById(id);
        if (optional.isPresent()) {
            ProgramEntity programEntity = optional.get();
            return new Program(programEntity.getId(), programEntity.getTitle());
        }
        return null;
    }

    @Override
    public void deleteProgram(int id) {
        programRepository.deleteById(id);
    }

    @Override
    public Program createProgram(Program newProgramInfo) {
        ProgramEntity programEntity = programRepository.save(new ProgramEntity(newProgramInfo.getTitle(), null));
        return new Program(programEntity.getId(), programEntity.getTitle());
    }

    @Override
    public List<Program> getPrograms() {
        return programRepository.findAll()
                .stream()
                .map(programEntity -> new Program(programEntity.getId(), programEntity.getTitle()))
                .collect(Collectors.toList());
    }

    @Override
    public void updateProgram(int programId, List<Integer> tests, String title) {
        Optional<ProgramEntity> optProgramEntity = programRepository.findById(programId);
        if (optProgramEntity.isPresent()) {
            ProgramEntity programEntity = optProgramEntity.get();
            programEntity.setTitle(title);
            List<TestEntity> testEntities = new ArrayList<>();
            Optional<TestEntity> optTestEntity = null;
            for (Integer testId : tests) {
                optTestEntity = testRepository.findById(testId);
                if (optTestEntity.isPresent()) {
                    testEntities.add(optTestEntity.get());
                }
            }
            programEntity.setTests(testEntities);
            programRepository.save(programEntity);
        }
    }

    @Override
    public List<Test> getProgramTests(int programId) {
        Optional<ProgramEntity> optProgramEntity = programRepository.findById(programId);
        if (optProgramEntity.isPresent()) {
            return optProgramEntity.get()
                    .getTests()
                    .stream()
                    .map(testEntity -> new Test(testEntity.getId(), testEntity.getTitle()))
                    .collect(Collectors.toList());
        }
        return null;
    }
}
