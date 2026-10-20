CREATE TABLE IF NOT EXISTS students (
    id          INTEGER PRIMARY KEY AUTOINCREMENT,
    student_no  TEXT    NOT NULL UNIQUE,
    name        TEXT    NOT NULL,
    class_name  TEXT    NOT NULL
);