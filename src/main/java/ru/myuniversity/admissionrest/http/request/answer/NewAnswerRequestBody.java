package ru.myuniversity.admissionrest.http.request.answer;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.Nullable;

import java.util.List;

public class NewAnswerRequestBody {
    @JsonProperty("chosen_variants_ids") @Nullable
    private List<Integer> chosenVariantIds;

    @JsonProperty("answer") @Nullable
    private String textAnswer;

    @Nullable
    public List<Integer> getChosenVariantIds() {
        return chosenVariantIds;
    }

    @Nullable
    public String getTextAnswer() {
        return textAnswer;
    }
}
