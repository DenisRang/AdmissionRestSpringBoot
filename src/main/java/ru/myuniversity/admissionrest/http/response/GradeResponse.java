package ru.myuniversity.admissionrest.http.response;

public class GradeResponse {
    private double grade;

    public GradeResponse(double grade) {
        this.grade = grade;
    }

    public double getGrade() {
        return grade;
    }
}
