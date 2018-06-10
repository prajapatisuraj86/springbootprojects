package com.suraj.jpaintegration.topic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class TopicService {
	
	@Autowired
	TopicRepository topicRepository;
	
	public List<Topic> getAllTopic() {
		List<Topic> topics = new ArrayList<>();
		Iterator<Topic> iterator = topicRepository.findAll().iterator();
		while(iterator.hasNext()) {
			topics.add(iterator.next());
		}
		return topics;
	}
	
	public Topic getTopic(String id) {
		return topicRepository.findOne(id);
	}
	
	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}
	
	public void updateTopic(Topic topic, String id) {
		topicRepository.save(topic);
	}
	
	public void deleteTopic(String id) {
		topicRepository.delete(id);
	}

}
