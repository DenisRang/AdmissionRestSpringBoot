package ru.myuniversity.admissionrest.service;

import org.springframework.lang.Nullable;
import ru.myuniversity.admissionrest.model.question.Question;
import ru.myuniversity.admissionrest.model.test.Attempt;
import ru.myuniversity.admissionrest.model.test.QuestionAttempt;
import ru.myuniversity.admissionrest.model.test.Test;

import java.util.List;

/**
 * A service for performing Tests module related business logic actions.
 * Provides API for creating and modifying {@link Test} instances (for moderators), and
 * for passing them (for candidates).
 */
public interface TestService {
    //Tests composition
    /**
     * Creates and saves in some data storage a {@link Test}.
     * @param test Test model to create.
     * @return A identifier of a newly created test.
     */
    int createTest(Test test);

    /**
     * Retrieve a list of available tests.
     * @return all tests available in the database.
     */
    List<Test> getTests();

    /**
     * Retrieves a grade for a test with given identifier.
     * @param testId identifier of a test to get grade for.
     * @return {@code null} if no attempts for this test are found for current user, or a 0-100 floating point grade
     * value otherwise.
     */
    @Nullable
    Double getTestGrade(int testId);

    /**
     * Update a test in some data storage.
     * @param test updated test to save.
     */
    void updateTest(Test test);

    /**
     * Deletes the test at a given identifier.
     * @param testId identifier of a test to delete.
     */
    void deleteTest(int testId);

    /**
     * Creates a question with given info in a test with given identifier.
     * @param testId identifier of a test to add question to.
     * @param question information about a question.
     */
    void createQuestion(int testId, Question question);

    List<Question> getQuestions(int testId);

    void updateQuestion(int testId, Question question);

    void deleteQuestion(int testId, int questionId);

    //Tests passing
    Attempt getQuestionAttempts( int userId, int testId);

    void submitTextAnswer( int userId, int testId, int questionId, String answer);

    void submitVariantsListAnswer(int userId, int testId, int questionId, List<Integer> chosenVariants);

    double finishTest( int userId, int testId);

}
