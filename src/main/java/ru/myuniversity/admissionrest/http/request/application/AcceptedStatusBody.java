package ru.myuniversity.admissionrest.http.request.application;

import com.fasterxml.jackson.annotation.JsonTypeName;
import org.springframework.lang.Nullable;

@JsonTypeName("accepted")
public class AcceptedStatusBody extends ApplicationStatusBody {
    @Nullable
    private String comment;
    private int interviewer;

    @Nullable
    public String getComment() {
        return comment;
    }

    public int getInterviewer() {
        return interviewer;
    }

    @Override
    public void accept(ApplicationStatusBodyVisitor visitor) {
        visitor.visit(this);
    }
}
