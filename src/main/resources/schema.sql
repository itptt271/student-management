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

CREATE TABLE IF NOT EXISTS class_sessions (
    id          INTEGER PRIMARY KEY AUTOINCREMENT,
    course_id   INTEGER NOT NULL REFERENCES courses(id),
    session_no  INTEGER NOT NULL,
    date        TEXT    NOT NULL,
    UNIQUE (course_id, session_no)
);