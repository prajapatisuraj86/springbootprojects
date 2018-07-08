package com.suraj.jpaintegration.topic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.suraj.jpaintegration.constant.BaseConstant;
import com.suraj.jpaintegration.response.CustomResponse;
import com.suraj.jpaintegration.response.ResponseStatus;
import com.suraj.jpaintegration.util.CommonUtility;



@Service
public class TopicService {
	
	private static final String CLASSNAME = "TopicService";
	private static final Logger logger = LogManager.getLogger(TopicService.class.getSimpleName());
	
	@Autowired
	TopicRepository topicRepository;
	
	@Cacheable(value = "topic.byId", key = "#id")
	public CustomResponse getAllTopic() {
		String strMethodName = "getAllTopic";
		logger.info(CommonUtility.getSampleLogger(CLASSNAME, strMethodName, "Started"));

		String strMessage = BaseConstant.GET_TOPIC_ERROR;
		CustomResponse response = new CustomResponse(strMessage, null, ResponseStatus.ERROR.toString());
		List<Topic> topics = new ArrayList<>();
		boolean bError = false;
		
		try {
			Iterator<Topic> iterator = topicRepository.findAll().iterator();
			while(iterator.hasNext()) {
				topics.add(iterator.next());
			}
		} catch(Exception e) {
			bError = true;
			logger.error(CommonUtility.getSampleLogger(CLASSNAME, strMethodName, strMessage + " Error is : "+e.getMessage()));
		}
		
		if(!bError) {
			response.setResObject(topics);
			response.setStrMessage(BaseConstant.GET_TOPIC_SUCCESS);
			response.setResponseStatus(ResponseStatus.SUCCESS.toString());
		}

		logger.info(CommonUtility.getSampleLogger(CLASSNAME, strMethodName, "Ended with :"+topics));
		return response;
	}
	
	public Topic getTopic(String id) {
		String strMethodName = "getTopic";
		Topic topic = null;
		logger.info(CommonUtility.getSampleLogger(CLASSNAME, strMethodName, "Started with Id:"+id));
		
		topic = topicRepository.findOne(id);
		
		logger.info(CommonUtility.getSampleLogger(CLASSNAME, strMethodName, "Ended with :"+topic));
		return topic;
	}
	
	public CustomResponse addTopic(Topic topic) {
		String strMethodName = "addTopic";
		logger.info(CommonUtility.getSampleLogger(CLASSNAME, strMethodName, "Started with :"+topic));
		
		String strMessage = BaseConstant.ADD_TOPIC_ERROR;
		CustomResponse response = new CustomResponse(strMessage, null, ResponseStatus.ERROR.toString());
		boolean bError = false;
		
		try {
			topicRepository.save(topic);			
		} catch (Exception e) {
			bError = true;
			logger.error(CommonUtility.getSampleLogger(CLASSNAME, strMethodName, strMessage + " Error is : "+e.getMessage()));
		}
		
		if(!bError) {
			response.setStrMessage(BaseConstant.ADD_TOPIC_SUCCESS);
			response.setResponseStatus(ResponseStatus.SUCCESS.toString());
		}
		
		logger.info(CommonUtility.getSampleLogger(CLASSNAME, strMethodName, "Ended"));
		return response;
	}
	
	public CustomResponse updateTopic(Topic topic, String id) {
		String strMethodName = "updateTopic";
		logger.info(CommonUtility.getSampleLogger(CLASSNAME, strMethodName, "Started with topic :"+topic));
		
		String strMessage = BaseConstant.UPDATE_TOPIC_ERROR;
		CustomResponse response = new CustomResponse(strMessage, null, ResponseStatus.ERROR.toString());
		boolean bError = false;
		
		try {
			topicRepository.save(topic);			
		} catch (Exception e) {
			bError = true;
			logger.error(CommonUtility.getSampleLogger(CLASSNAME, strMethodName, strMessage + " Error is : "+e.getMessage()));
		}
		
		if(!bError) {
			response.setStrMessage(BaseConstant.UPDATE_TOPIC_SUCCESS);
			response.setResponseStatus(ResponseStatus.SUCCESS.toString());
		}
		
		logger.info(CommonUtility.getSampleLogger(CLASSNAME, strMethodName, "Ended"));
		return response;
	}
	
	public CustomResponse deleteTopic(String id) {
		String strMethodName = "deleteTopic";
		logger.info(CommonUtility.getSampleLogger(CLASSNAME, strMethodName, "Started with id :"+id));
		
		String strMessage = BaseConstant.DELETE_TOPIC_ERROR;
		CustomResponse response = new CustomResponse(strMessage, null, ResponseStatus.ERROR.toString());
		boolean bError = false;
		
		try {
			topicRepository.delete(id);			
		} catch (Exception e) {
			bError = true;
			logger.error(CommonUtility.getSampleLogger(CLASSNAME, strMethodName, strMessage + " Error is : "+e.getMessage()));
		}
		
		if(!bError) {
			response.setStrMessage(BaseConstant.DELETE_TOPIC_SUCCESS);
			response.setResponseStatus(ResponseStatus.SUCCESS.toString());
		}
		
		logger.info(CommonUtility.getSampleLogger(CLASSNAME, strMethodName, "Ended"));
		return response;
	}

}
