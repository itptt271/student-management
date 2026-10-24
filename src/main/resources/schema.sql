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

CREATE TABLE IF NOT EXISTS attendance (
    id          INTEGER PRIMARY KEY AUTOINCREMENT,
    student_id  INTEGER NOT NULL REFERENCES students(id),
    session_id  INTEGER NOT NULL REFERENCES class_sessions(id),
    status      TEXT    NOT NULL CHECK (status IN ('PRESENT', 'LATE', 'EARLY_LEAVE', 'ABSENT', 'OFFICIAL_ABSENCE')),
    UNIQUE (student_id, session_id)
);