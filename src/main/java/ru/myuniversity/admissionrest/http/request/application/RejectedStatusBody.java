package ru.myuniversity.admissionrest.http.request.application;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("rejected")
public class RejectedStatusBody extends ApplicationStatusBody {
    private boolean fixable;
    private String reason;

    public boolean isFixable() {
        return fixable;
    }

    public String getReason() {
        return reason;
    }

    @Override
    public void accept(ApplicationStatusBodyVisitor visitor) {
        visitor.visit(this);
    }
}
