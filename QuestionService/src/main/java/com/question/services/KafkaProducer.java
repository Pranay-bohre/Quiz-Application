package com.question.services;

import com.question.dto.QuestionResponseEvent;

public interface KafkaProducer {
	public void produceQuestionsByQuizId(QuestionResponseEvent responseEvent);
}
