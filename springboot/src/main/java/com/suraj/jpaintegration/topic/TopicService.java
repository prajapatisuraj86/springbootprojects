package com.suraj.jpaintegration.topic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.suraj.jpaintegration.util.CommonUtility;



@Service
public class TopicService {
	
	private static final String CLASSNAME = "TopicService";
	private static final Logger logger = LogManager.getLogger(TopicService.class.getSimpleName());
	
	@Autowired
	TopicRepository topicRepository;
	
	@Cacheable(value = "topic.byId", key = "#id")
	public List<Topic> getAllTopic() {
		String strMethodName = "getAllTopic";
		logger.info(CommonUtility.getSampleLogger(CLASSNAME, strMethodName, "Started"));
		
		List<Topic> topics = new ArrayList<>();
		Iterator<Topic> iterator = topicRepository.findAll().iterator();
		while(iterator.hasNext()) {
			topics.add(iterator.next());
		}
		logger.info(CommonUtility.getSampleLogger(CLASSNAME, strMethodName, "Ended with :"+topics));
		return topics;
	}
	
	public Topic getTopic(String id) {
		String strMethodName = "getTopic";
		Topic topic = null;
		logger.info(CommonUtility.getSampleLogger(CLASSNAME, strMethodName, "Started with Id:"+id));
		topic = topicRepository.findOne(id);
		logger.info(CommonUtility.getSampleLogger(CLASSNAME, strMethodName, "Ended with :"+topic));
		return topic;
	}
	
	public void addTopic(Topic topic) {
		String strMethodName = "addTopic";
		logger.info(CommonUtility.getSampleLogger(CLASSNAME, strMethodName, "Started with :"+topic));
		topicRepository.save(topic);
		logger.info(CommonUtility.getSampleLogger(CLASSNAME, strMethodName, "Ended"));
	}
	
	public void updateTopic(Topic topic, String id) {
		String strMethodName = "updateTopic";
		logger.info(CommonUtility.getSampleLogger(CLASSNAME, strMethodName, "Started with topic :"+topic));
		topicRepository.save(topic);
		logger.info(CommonUtility.getSampleLogger(CLASSNAME, strMethodName, "Ended"));
	}
	
	public void deleteTopic(String id) {
		String strMethodName = "deleteTopic";
		logger.info(CommonUtility.getSampleLogger(CLASSNAME, strMethodName, "Started with id :"+id));		
		topicRepository.delete(id);
		logger.info(CommonUtility.getSampleLogger(CLASSNAME, strMethodName, "Ended"));
	}

}
