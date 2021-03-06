package com.example.kafka;

import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerGroupMetadata;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

	private final Logger logger = LoggerFactory.getLogger(Producer.class);

	@KafkaListener(topics = "users", groupId = "group_id")
	public void consume(String message) throws IOException {
		logger.info(String.format("#### -> Consumed message -> %s", message));

//		
		// kafka configurations
		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092");
		props.put("group.id", "consumer-group-C1");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "com.example.kafka.DevicePacketDeserializer");
		//props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		//props.put("value.serializer", "com.example.kafka.DevicePacketSerializer");
		props.put("partition.assignment.strategy", "org.apache.kafka.clients.consumer.RoundRobinAssignor");

		KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);

		consumer.subscribe(Collections.singletonList("users"));
//		ConsumerGroupMetadata consumerGrpMetaData = consumer.groupMetadata();
//		System.out.println(consumerGrpMetaData.groupId() + " " + consumerGrpMetaData.memberId() + " "
//				+ consumerGrpMetaData.generationId());
//
//		try {
//			while (true) {
//				
//				ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
//				for (ConsumerRecord<String, String> record : records) {
//					System.out.println(record.topic());
//					System.out.println(record.partition());
//					System.out.println(record.offset());
//					System.out.println(record.key());
//					System.out.println(record.value());
//
//					logger.info(String.format("#### -> Consumed message -> %s", message));
//				}
//			}
//		} finally {
//			consumer.close();
//		}
//

	}

	@KafkaListener(topics = "users", groupId = "group_id")
	public void consume(ConsumerRecord<String, DevicePacket> packet) throws IOException {
		
		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092");
		props.put("group.id", "consumer-group-C1");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "com.example.kafka.DevicePacketDeserializer");

		KafkaConsumer<String, DevicePacket> consumer = new KafkaConsumer<>(props);
		consumer.subscribe(Collections.singletonList("users"));

		ConsumerRecords<String, DevicePacket> records = consumer.poll(Duration.ofMillis(1000));
		for (ConsumerRecord<String, DevicePacket> record : records) {
			DevicePacket devicePacket = record.value();
			System.out.println(devicePacket.getDeviceId());
			System.out.println(devicePacket.getLatitude());
			System.out.println(devicePacket.getLongitude());
			System.out.println(record.topic());
		} 
		
		consumer.close();
//		logger.info(String.format("#### -> Consumed message -> %s",
//				packet.getDeviceId() + " " + packet.getLatitude() + " " + packet.getLongitude()));
	}
}