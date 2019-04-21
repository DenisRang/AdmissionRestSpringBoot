package ru.myuniversity.admissionrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.myuniversity.admissionrest.dao.TestDao;
import ru.myuniversity.admissionrest.http.request.TestsRequestBody;
import ru.myuniversity.admissionrest.http.request.answer.NewAnswerRequestBody;
import ru.myuniversity.admissionrest.http.request.question.QuestionRequestBody;
import ru.myuniversity.admissionrest.http.request.question.QuestionsRequestToPOJOMapper;
import ru.myuniversity.admissionrest.http.response.GradeResponse;
import ru.myuniversity.admissionrest.http.response.TestsResponseElement;
import ru.myuniversity.admissionrest.model.question.Question;
import ru.myuniversity.admissionrest.model.test.Test;
import ru.myuniversity.admissionrest.service.TestService;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class TestRestController {

    private TestDao testDao;

    @Autowired
    public TestRestController(TestDao testDao) {
        this.testDao = testDao;
    }

    @PostMapping("/tests")
    public Map<String, Integer> createTest(@RequestBody TestsRequestBody body) {
        int id = testDao.createTest(new Test(body.getTitle()));
        return Collections.singletonMap("test_id", id);
    }

    @GetMapping("/tests")
    public List<TestsResponseElement> getTests() {
        // retrieve tests and try to get grade for each test
        return testDao.getTests().stream()
                .map(test -> new TestsResponseElement(test, testDao.getTestGrade(test.getId())))
                .collect(Collectors.toList());
    }

    @PutMapping("/tests/{testId}")
    public void updateTest(@PathVariable int testId, @RequestBody TestsRequestBody body) {
        testDao.updateTest(new Test(testId, body.getTitle()));
    }

    @DeleteMapping("/tests/{testId}")
    public void deleteTest(@PathVariable int testId) {
        testDao.deleteTest(testId);
    }

    @PostMapping("/tests/{testId}/questions")
    public void createQuestion(@PathVariable int testId, @RequestBody QuestionRequestBody questionBody) {
        testDao.createQuestion(testId, QuestionsRequestToPOJOMapper.map(questionBody));
    }

    @GetMapping("/tests/{testId}/questions")
    public List<Question> getQuestions(@PathVariable int testId) {
        return testDao.getQuestions(testId);
    }

    @PutMapping("/tests/{testId}/questions/{questionId}")
    public void updateQuestion(@PathVariable int testId, @PathVariable int questionId, @RequestBody QuestionRequestBody questionBody) {
        testDao.updateQuestion(testId, constructQuestionToUpdate(questionId, questionBody));
    }

    @DeleteMapping("/tests/{testId}/questions/{questionId}")
    public void deleteQuestion(@PathVariable int testId, @PathVariable int questionId) {
        testDao.deleteQuestion(testId, questionId);
    }

    @PostMapping("/tests/{testId}/questions/{questionId}/answer")
    public void submitAnswer(@PathVariable int testId, @PathVariable int questionId, @RequestBody NewAnswerRequestBody answerBody) {
        if (answerBody.getTextAnswer() != null) {
            testDao.submitTextAnswer(testId, questionId, answerBody.getTextAnswer());
        } else if (answerBody.getChosenVariantIds() != null) {
            testDao.submitVariantsListAnswer(testId, questionId, answerBody.getChosenVariantIds());
        } else {
            System.out.println("Incorrect body");
        }
    }

    @PutMapping("/tests/{testId}/finish")
    public GradeResponse finishTestAttempt(@PathVariable int testId) {
        return new GradeResponse(testDao.finishTest(testId));
    }

    private Question constructQuestionToUpdate(int questionId, QuestionRequestBody questionBody) {
        Question result = QuestionsRequestToPOJOMapper.map(questionBody);
        result.setId(questionId);
        return result;
    }
}
