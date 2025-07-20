package com.question.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.question.entities.Question;
import com.question.services.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	
	@PostMapping
	public Question save(@RequestBody Question question) {
		 return questionService.save(question);
		
	}
	
	@GetMapping
	public List<Question> fetchAllQuestions() {
		return questionService.findAllQuestions();
	}
	
	@GetMapping(params = "quizId")
	public List<Question> fetchQuestionByQuizId(@RequestParam Long quizId) {
		System.out.println("quizId " + quizId);
		return questionService.findQuestionsByQuizId(quizId);
	}
	
	@GetMapping(params = "questionId")
	public Question fetchQuestion(@RequestParam Long questionId) {
		System.out.println("quizId " + questionId);
		return questionService.findQuestionById(questionId);
	}
	
}
