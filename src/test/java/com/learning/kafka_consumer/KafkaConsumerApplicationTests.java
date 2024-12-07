package com.learning.kafka_consumer;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.awaitility.Awaitility;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.kafka.KafkaContainer;
import org.testcontainers.utility.DockerImageName;

import com.learning.dto.Student;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Testcontainers
class KafkaConsumerApplicationTests {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Container
	static KafkaContainer kafkaContainer = new KafkaContainer(DockerImageName.parse("apache/kafka"));

	@DynamicPropertySource
	static void initKafkaProps(DynamicPropertyRegistry registry) {
		registry.add("spring.kafka.bootstrap-servers", kafkaContainer::getBootstrapServers);
	}

//	@Test
//	void contextLoads() {
//	}

	@Autowired
	KafkaTemplate<String, Object> kafkaTemplate;

	@Test
	void testConsumeEvents() {
		logger.info("testConsumeEvents started....");
		kafkaTemplate.send("student-topic-2", new Student(1, "chandra", "GMR", "Hyd"));
		logger.info("testConsumeEvents execution ended....");
		Awaitility.await().pollInterval(Duration.ofSeconds(3)).atMost(10, TimeUnit.SECONDS).untilAsserted(() -> {
			//assert statement
		});
	}

}
