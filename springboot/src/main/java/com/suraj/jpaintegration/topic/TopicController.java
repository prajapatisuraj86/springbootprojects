package com.suraj.jpaintegration.topic;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.suraj.jpaintegration.course.CourseController;
import com.suraj.jpaintegration.response.CustomResponse;
import com.suraj.jpaintegration.util.CommonUtility;

@RestController
@CrossOrigin
public class TopicController {
	
	private static final String CLASSNAME = "CourseController";
	private static final Logger logger = LogManager.getLogger(CourseController.class.getSimpleName());

	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics")
	public CustomResponse getAllTopic() {
		String strMethodName = "getAllTopic";
		logger.info(CommonUtility.getSampleLogger(CLASSNAME, strMethodName, "Started"));
		CustomResponse response = topicService.getAllTopic();
		logger.info(CommonUtility.getSampleLogger(CLASSNAME, strMethodName, "Ended"));
		return response;
	}
	
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id) {
		String strMethodName = "getTopic";
		logger.info(CommonUtility.getSampleLogger(CLASSNAME, strMethodName, "Started"));
		Topic topic = topicService.getTopic(id);
		logger.info(CommonUtility.getSampleLogger(CLASSNAME, strMethodName, "Ended"));
		return topic;
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/topics")
	public void addTopic(@RequestBody Topic topic) {
		String strMethodName = "addTopic";
		logger.info(CommonUtility.getSampleLogger(CLASSNAME, strMethodName, "Started"));
		topicService.addTopic(topic);
		logger.info(CommonUtility.getSampleLogger(CLASSNAME, strMethodName, "Ended"));
	}
	
	
	@RequestMapping(method=RequestMethod.PUT, value = "/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		String strMethodName = "updateTopic";
		logger.info(CommonUtility.getSampleLogger(CLASSNAME, strMethodName, "Started"));
		topicService.updateTopic(topic, id);
		logger.info(CommonUtility.getSampleLogger(CLASSNAME, strMethodName, "Ended"));
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value = "/topics/{id}")
	public CustomResponse deleteTopic(@PathVariable String id) {
		String strMethodName = "deleteTopic";
		logger.info(CommonUtility.getSampleLogger(CLASSNAME, strMethodName, "Started"));
		CustomResponse response = topicService.deleteTopic(id);
		logger.info(CommonUtility.getSampleLogger(CLASSNAME, strMethodName, "Ended"));
		return response;
	}
	
}

