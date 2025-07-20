package com.quiz.services;

public interface KafkaProducer {
	
	public void requestQuestions(Long quizId, String correlationId);
	
}
