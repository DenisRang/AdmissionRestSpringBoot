package ru.myuniversity.admissionrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.myuniversity.admissionrest.repository.question.QuestionRepository;
import ru.myuniversity.admissionrest.repository.TestRepository;
import ru.myuniversity.admissionrest.entity.question.QuestionEntity;
import ru.myuniversity.admissionrest.entity.question.QuestionEntityToPojoMapper;
import ru.myuniversity.admissionrest.entity.TestEntity;
import ru.myuniversity.admissionrest.model.question.Question;
import ru.myuniversity.admissionrest.model.question.QuestionPOJOToEntityMapper;
import ru.myuniversity.admissionrest.model.test.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TestServiceImpl implements TestService {
    private TestRepository testRepository;
    private QuestionRepository questionRepository;

    @Autowired
    public TestServiceImpl(TestRepository testRepository,
                           QuestionRepository questionRepository) {
        this.testRepository = testRepository;
        this.questionRepository = questionRepository;
    }

    @Override
    public int createTest(Test test) {
        TestEntity testEntity = new TestEntity(test.getTitle());
        return testRepository.save(testEntity).getId();
    }

    @Override
    public List<Test> getTests() {
        return testRepository.findAll()
                .stream()
                .map((testEntity) -> new Test(testEntity.getId(), testEntity.getTitle()))
                .collect(Collectors.toList());
    }

    @Override
    public Double getTestGrade(int testId) {
        return 0.0;
    }

    @Override
    public void updateTest(Test test) {
        Optional<TestEntity> optTestEntity = testRepository.findById(test.getId());
        if (optTestEntity.isPresent()) {
            TestEntity testEntity=optTestEntity.get();
            testEntity.setTitle(test.getTitle());
            testRepository.save(testEntity);
        }
    }

    @Override
    public void deleteTest(int testId) {
        testRepository.deleteById(testId);
    }

    @Override
    public void createQuestion(int testId, Question question) {
        Optional<TestEntity> testOptional = testRepository.findById(testId);
        if (testOptional.isPresent()) {
            TestEntity testEntity = testOptional.get();
            QuestionEntity questionEntity = QuestionPOJOToEntityMapper.map(question);
            questionEntity.setTest(testEntity);
            questionRepository.save(questionEntity);
        }
    }

    @Override
    public List<Question> getQuestions(int testId) {
        List<Question> questions = questionRepository.findQuestionsOfTest(testId)
                .stream()
                .map(QuestionEntityToPojoMapper::map)
                .collect(Collectors.toList());
        return questions;
    }

    @Override
    public void updateQuestion(int testId, Question question) {
        Optional<TestEntity> testOptional = testRepository.findById(testId);
        if (testOptional.isPresent()) {
            QuestionEntity questionEntity = QuestionPOJOToEntityMapper.map(question);
            questionEntity.setId(question.getId());
            questionEntity.setTest(testOptional.get());
            questionRepository.save(questionEntity);
        }
    }

    @Override
    public void deleteQuestion(int testId, int questionId) {
        questionRepository.deleteQuestionOfTestById(testId,questionId);
    }

    @Override
    public void submitTextAnswer(int testId, int questionId, String answer) {

    }

    @Override
    public void submitVariantsListAnswer(int testId, int questionId, List<Integer> chosenVariants) {

    }

    @Override
    public double finishTest(int testId) {
        return 0;
    }
}
