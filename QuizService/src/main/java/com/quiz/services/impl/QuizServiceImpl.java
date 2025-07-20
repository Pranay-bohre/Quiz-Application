package com.quiz.services.impl;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.dto.Question;
import com.quiz.dto.QuestionRequestEvent;
import com.quiz.entities.Quiz;
import com.quiz.repositories.QuizRepository;
import com.quiz.services.KafkaConsumer;
import com.quiz.services.KafkaProducer;
import com.quiz.services.QuizService;

@Service
public class QuizServiceImpl implements QuizService{
	
	private QuizRepository quizRepository;
	
	@Autowired
	private KafkaConsumer kafkaConsumer;
	
	@Autowired
	private KafkaProducer kafkaProducer;
	
	@Autowired
    private KafkaPendingResponseService pendingService;

	public QuizServiceImpl(QuizRepository quizRepository) {
		super();
		this.quizRepository = quizRepository;
	}

	@Override
	public Quiz add(Quiz quiz) {
		// TODO Auto-generated method stub
//		System.out.println(quiz.getTitle());
		return quizRepository.save(quiz);
	}

	@Override
	public List<Quiz> get() {
		// TODO Auto-generated method stub
		return quizRepository.findAll();
	}

	@Override
	public Quiz get(Long id) {
		// TODO Auto-generated method stub
		return quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz not found!"));
	}
	
	public List<Question> requestOperations(Long quizId) throws Exception {
        String correlationId = UUID.randomUUID().toString();
        CompletableFuture<List<Question>> future = new CompletableFuture<>();
        pendingService.storePendingResponse(correlationId, future);

        kafkaProducer.requestQuestions(quizId, correlationId);
        
        System.out.println("Questions-----------------------------------------------------------");
        System.out.println(future);
        // Optional: timeout after 5 seconds
        return future.get(5, TimeUnit.SECONDS);
    }

}
