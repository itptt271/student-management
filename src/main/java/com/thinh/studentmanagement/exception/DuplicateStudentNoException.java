package com.thinh.studentmanagement.exception;

public class DuplicateStudentNoException extends RuntimeException {
    public DuplicateStudentNoException(String sudentNo) {
        super("この学籍番号は既に登録されています: " + sudentNo);
    }
}
