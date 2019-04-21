package ru.myuniversity.admissionrest.http.request.question;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import ru.myuniversity.admissionrest.http.request.question.QuestionRequestBody.ChecklistQuestionRequestBody;
import ru.myuniversity.admissionrest.http.request.question.QuestionRequestBody.RadioQuestionRequestBody;
import ru.myuniversity.admissionrest.http.request.question.QuestionRequestBody.TextQuestionRequestBody;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = TextQuestionRequestBody.class, name = "text"),
        @JsonSubTypes.Type(value = RadioQuestionRequestBody.class, name = "radio"),
        @JsonSubTypes.Type(value = ChecklistQuestionRequestBody.class, name = "checklist")
})
public abstract class QuestionRequestBody {
    private String description;
    private double weight;

    public String getDescription() {
        return description;
    }

    public double getWeight() {
        return weight;
    }

    abstract public void accept(QuestionRequestBodyVisitor visitor);

    @JsonTypeName("text")
    public static class TextQuestionRequestBody extends QuestionRequestBody {
        String answer;

        public String getAnswer() {
            return answer;
        }

        @Override
        public void accept(QuestionRequestBodyVisitor visitor) {
            visitor.visit(this);
        }
    }

    @JsonTypeName("radio")
    public static class RadioQuestionRequestBody extends VariantsListQuestionBody {
        @Override
        public void accept(QuestionRequestBodyVisitor visitor) {
            visitor.visit(this);
        }
    }

    @JsonTypeName("checklist")
    public static class ChecklistQuestionRequestBody extends VariantsListQuestionBody {
        @Override
        public void accept(QuestionRequestBodyVisitor visitor) {
            visitor.visit(this);
        }
    }
}
