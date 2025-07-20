package com.quiz.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Question {
 private Long id;
 private String question;
 private Long quizId;

 public Question() {} // ✅ Required by Jackson

 // ✅ Getters and Setters
}
