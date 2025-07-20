package com.question.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.question.dto.QuestionRequestEvent;
import com.question.dto.QuestionResponseEvent;
import com.question.entities.Question;
import com.question.repositories.QuestionRepository;
import com.question.services.KafkaProducer;
import com.question.services.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService{
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private QuestionKafkaProducer kafkaProducer;

	@Override
	public Question save(Question question) {
		// TODO Auto-generated method stub
		return questionRepository.save(question);
		
	}

	@Override
	public Question findQuestionById(Long id) {
		// TODO Auto-generated method stub
		return questionRepository.findById(id).orElseThrow(() -> new RuntimeException("Question Not Found by " + id));
	}

	@Override
	public List<Question> findQuestionsByQuizId(Long quizId) {
		// TODO Auto-generated method stub
		return questionRepository.findByQuizId(quizId);
	}

	@Override
	public List<Question> findAllQuestions() {
		// TODO Auto-generated method stub
		return questionRepository.findAll();
	}
	
	public void fetchAllQuestionByQuizIdKafka(QuestionRequestEvent requestEvent) {
		Long quizId = requestEvent.getQuizId();
        String correlationId = requestEvent.getCorrelationId();
        
        List<Question> questions = findQuestionsByQuizId(quizId);
        
        QuestionResponseEvent responseEvent = new QuestionResponseEvent();
        
        responseEvent.setCorrelationId(correlationId);
        responseEvent.setQustions(questions);
		kafkaProducer.produceQuestionsByQuizId(responseEvent);
	}

}
