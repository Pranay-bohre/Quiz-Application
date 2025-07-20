package com.question.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.question.services.KafkaProducer;
import com.question.config.KafkaConfig;
import com.question.dto.QuestionRequestEvent;
import com.question.dto.QuestionResponseEvent;

@Service
public class QuestionKafkaProducer implements KafkaProducer{
	@Value("${kafka.topics.question-response}")
    private String questionResponseTopic;

	@Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void produceQuestionsByQuizId(QuestionResponseEvent responseEvent) {

        kafkaTemplate.send(questionResponseTopic, responseEvent);
    }

}
