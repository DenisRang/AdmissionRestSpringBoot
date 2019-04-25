package ru.myuniversity.admissionrest.model.programs;

/**
 * A model representing a program of INU.
 */
public class Program {
    /**
     * Identifier of a program.
     */
    private int id;

    /**
     * Title of a program.
     */
    private String title;

    public Program(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public Program(String title) {
        this.title = title;
        this.id = -1;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
