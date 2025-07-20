package com.quiz.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.quiz.config.KafkaConfig;
import com.quiz.dto.QuestionRequestEvent;
import com.quiz.services.KafkaProducer;

@Service
public class KafkaProducerImpl implements KafkaProducer {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;
    
    @Value("${kafka.topics.question-request}")
    private String questionRequestTopic;

    @Override
    public void requestQuestions(Long quizId, String correlationId) {
        QuestionRequestEvent event = new QuestionRequestEvent();
        event.setQuizId(quizId);
        event.setCorrelationId(correlationId);

        kafkaTemplate.send(questionRequestTopic, event);
    }
}
