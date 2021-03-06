package com.example.kafka;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/kafka")
public class KafkaController {

	private final Producer producer;
	
	@Autowired
	KafkaController(Producer producer) {
		this.producer = producer;
	}
	
	@PostMapping("/publish")
	public void produceMessage(@RequestParam("message") String message) {
		this.producer.sendMessage(message);
	}
	
	@PostMapping("/devicePacket")
	public void sendDevicePacket(@RequestBody DevicePacket packet) {
		ProducerRecord<String, DevicePacket> record = new ProducerRecord<>("users", packet);
		this.producer.sendDevicePacket(record);
	}
}
