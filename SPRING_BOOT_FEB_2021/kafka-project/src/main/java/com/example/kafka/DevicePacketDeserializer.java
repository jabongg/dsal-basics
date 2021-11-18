package com.example.kafka;

import java.io.IOException;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DevicePacketDeserializer implements Deserializer<DevicePacket> {

	@Override
	public DevicePacket deserialize(String topic, byte[] data) {
		 ObjectMapper mapper = new ObjectMapper();
		 DevicePacket devicePacket = null;
		 
		 try {
			devicePacket = mapper.readValue(data,	 DevicePacket.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return devicePacket;
	}

} 