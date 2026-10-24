INSERT OR IGNORE INTO students (student_no, name, class_name) VALUES
    ('255P001', '青木 翔太', 'IT 2年'),
    ('255P002', 'グエン ヴァン アン', 'IT 2年'),
    ('255P005', 'ファン トゥアン ティン', 'IT 2年');

INSERT OR IGNORE INTO courses (name, teacher_name, class_name, total_sessions) VALUES
    ('JAVA', 'A先生', 'IT 2年', 5),
    ('日本語', 'B先生', 'IT 2年', 6),
    ('実践学習', 'C先生', 'IT 2年', 7);

INSERT OR IGNORE INTO class_sessions (course_id, session_no, date) VALUES
    (1, 1, '2026-04-09'),
    (2, 3, '2026-04-12'),
    (3, 4, '2026-04-25');

INSERT OR IGNORE INTO attendance (student_id, session_id, status) VALUES
    (1, 1, 'PRESENT'),
    (1, 2, 'ABSENT'),
    (1, 3, 'PRESENT'),
    (2, 1, 'LATE'),
    (2, 2, 'PRESENT'),
    (2, 3, 'PRESENT'),
    (3, 1, 'PRESENT'),
    (3, 2, 'OFFICIAL_ABSENCE'),
    (3, 3, 'PRESENT');