package com.learning.kafka_consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.learning.dto.Student;


@Service
public class KafkaMessageListener {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@KafkaListener(topics = "student-topic-2", groupId = "kafka-consumer-group-2")
	public void consume(Student student) {
		
		logger.info("consumer consume the message: {}", student.toString());

	}

//	@KafkaListener(topics = "kafka-topic-1", groupId = "kafka-consumer-group-1")
//	public void consume1(String message) {
//		
//		logger.info("consumer1 consume the message: {}", message);
//
//	}
//	
//	@KafkaListener(topics = "kafka-topic-1", groupId = "kafka-consumer-group-1")
//	public void consume2(String message) {
//		
//		logger.info("consumer2 consume the message: {}", message);
//
//	}
//	
//	@KafkaListener(topics = "kafka-topic-1", groupId = "kafka-consumer-group-1")
//	public void consume3(String message) {
//		
//		logger.info("consumer3 consume the message: {}", message);
//
//	}
//		
//	@KafkaListener(topics = "kafka-topic-1", groupId = "kafka-consumer-group-1")
//	public void consume4(String message) {
//		
//		logger.info("consumer4 consume the message: {}", message);
//
//	}

}
