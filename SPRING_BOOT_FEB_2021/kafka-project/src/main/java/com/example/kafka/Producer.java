package com.example.kafka;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
    private static final String TOPIC = "users";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    
    @Autowired
    private KafkaTemplate<String, DevicePacket> kafkaTemplateDevicePacket;

    public void sendMessage(String message) {
    	logger.info(String.format("#### -> producing message -> %s ", message));
    	this.kafkaTemplate.send(TOPIC, message);
    }
    
    public void sendDevicePacket(ProducerRecord<String, DevicePacket> packet) {
    	// kafka configurations
		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092");
		props.put("group.id", "consumer-group-C1");
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "com.example.kafka.DevicePacketSerializer");

		KafkaProducer<String, DevicePacket> producer = new KafkaProducer<>(props);
		
    	logger.info(String.format("#### -> producing message -> %s ", packet));
    	Future<RecordMetadata> record = producer.send(packet);
    	try {
			System.out.println(record.get().offset());
			System.out.println(record.get().partition());
			System.out.println(record.get().topic());
			System.out.println(record.get().timestamp());
			System.out.println(record.get().checksum());
			
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
    	
    	
    	//this.kafkaTemplateDevicePacket.send(TOPIC, packet);
    	producer.close();
    }
}
