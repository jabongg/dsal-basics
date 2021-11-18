package com.example.kafka;

import java.util.Set;

import org.apache.kafka.common.Cluster;

public interface TopicPartitionAssignor extends org.apache.kafka.clients.consumer.ConsumerPartitionAssignor{
	Subscription subscription(Set<String> topics);

	@Override
	GroupAssignment assign(Cluster metadata, GroupSubscription groupSubscription) ;

	@Override
	public String name();
}
