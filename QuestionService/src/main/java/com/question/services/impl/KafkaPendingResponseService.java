package com.question.services.impl;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.stereotype.Service;

@Service
public class KafkaPendingResponseService {
    private final Map<String, CompletableFuture<List<Question>>> pendingResponses = new ConcurrentHashMap<String, CompletableFuture<List<Question>>>();

    public void storePendingResponse(String correlationId, CompletableFuture<List<Question>> future) {
        pendingResponses.put(correlationId, future);
    }

    public CompletableFuture<List<Question>> removePendingResponse(String correlationId) {
        return pendingResponses.remove(correlationId);
    }
}
