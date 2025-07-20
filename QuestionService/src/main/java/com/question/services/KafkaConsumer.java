package com.question.services;

import com.question.dto.QuestionRequestEvent;

public interface KafkaConsumer {
	public void fetchQuestionsByQuizId(QuestionRequestEvent response);
}
