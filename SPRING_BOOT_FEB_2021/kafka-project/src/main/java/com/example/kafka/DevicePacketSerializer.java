package com.example.kafka;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DevicePacketSerializer implements Serializer<DevicePacket>{

	@Override
	public byte[] serialize(String topic, DevicePacket data) {
		byte[] serValue = null;
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			serValue = mapper.writeValueAsString(data).getBytes();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return serValue;
	}
}
