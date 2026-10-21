package com.thinh.studentmanagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record StudentRequest(

    @NotBlank(message = "学籍番号は必須です")
    @Size(max = 20, message = "学籍番号は20文字以内で入力してください")
    String studentNo,

    @NotBlank(message = "氏名は必須です")
    @Size(max = 50, message = "氏名は50文字以内で入力してください")
    String name,

    @NotBlank(message = "クラスは必須です")
    String className
) {
}