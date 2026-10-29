package com.thinh.studentmanagement.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CourseRequest(
        @NotBlank(message = "科目名は必須です") @Size(max = 50, message = "科目名は50文字以内で入力してください") String name,
        @NotBlank(message = "担当教員名は必須です") @Size(max = 50, message = "担当教員名は50文字以内で入力してください") String teacherName,
        @NotBlank(message = "クラスは必須です") String className,
        @NotNull(message = "授業回数は必須です") @Min(value = 1, message = "授業回数は1以上で入力してください") Integer totalSessions) {
}
