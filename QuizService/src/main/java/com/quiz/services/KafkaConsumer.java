package com.quiz.services;

import com.quiz.dto.QuestionResponseEvent;

public interface KafkaConsumer {
	public void consume(QuestionResponseEvent response);
}
