package com.example.kafka;

public class DevicePacket {

	private String deviceId;
	private Double latitude;
	private Double longitude;

	public DevicePacket() {
	}
	
	public DevicePacket(String deviceId, Double latitude, Double longitude) {
		super();
		this.deviceId = deviceId;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

}
