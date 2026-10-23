CREATE TABLE IF NOT EXISTS students (
    id          INTEGER PRIMARY KEY AUTOINCREMENT,
    student_no  TEXT    NOT NULL UNIQUE,
    name        TEXT    NOT NULL,
    class_name  TEXT    NOT NULL
);

CREATE TABLE IF NOT EXISTS courses (
    id              INTEGER PRIMARY KEY AUTOINCREMENT,
    name            TEXT    NOT NULL,
    teacher_name    TEXT    NOT NULL,
    class_name      TEXT    NOT NULL,
    total_sessions  INTEGER NOT NULL,
    UNIQUE (name, class_name)
);
