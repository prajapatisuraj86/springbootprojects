package com.suraj.jpaintegration.course;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suraj.jpaintegration.topic.TopicRepository;
import com.suraj.jpaintegration.util.CommonUtility;



@Service
public class CourseService {
	
	private static final String CLASSNAME = "CourseService";
	private static final Logger logger = LogManager.getLogger(CourseService.class.getSimpleName());
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	TopicRepository topicRepository;
	
	public List<Course> getAllCourses(String topicId) {
		String strMethodName = "getAllCourses";
		logger.info(CommonUtility.getSampleLogger(CLASSNAME, strMethodName, "Started with :"+topicId));
		
		List<Course> lstCourses = courseRepository.findByTopicId(topicId);
		
		logger.info(CommonUtility.getSampleLogger(CLASSNAME, strMethodName, "Ended with :"+lstCourses));
		return lstCourses;
	}
	
	public Course getCourse(String id) {
		String strMethodName = "getCourse";
		logger.info(CommonUtility.getSampleLogger(CLASSNAME, strMethodName, "Started with Course Id :"+id));
		
		Course course = courseRepository.findOne(id);
		
		logger.info(CommonUtility.getSampleLogger(CLASSNAME, strMethodName, "Ended with :"+course));
		return course;
	}
	
	public void addCourse(Course course, String topicId) {
		String strMethodName = "addCourse";
		logger.info(CommonUtility.getSampleLogger(CLASSNAME, strMethodName, "Started with course :"+course+ " and Topic Id :"+topicId));
		
		course.setTopic(topicRepository.findOne(topicId));
		logger.info(CommonUtility.getSampleLogger(CLASSNAME, strMethodName, "Course is :"+course));
		courseRepository.save(course);
		
		logger.info(CommonUtility.getSampleLogger(CLASSNAME, strMethodName, "Ended"));
	}
	
	public void updateCourse(Course course, String topicId) {
		String strMethodName = "updateCourse";
		logger.info(CommonUtility.getSampleLogger(CLASSNAME, strMethodName, "Started with course :"+course+ " and Topic Id :"+topicId));
		
		course.setTopic(topicRepository.findOne(topicId));
		courseRepository.save(course);
		
		logger.info(CommonUtility.getSampleLogger(CLASSNAME, strMethodName, "Ended"));
	}
	
	public void deleteCourse(String id) {
		String strMethodName = "deleteCourse";
		logger.info(CommonUtility.getSampleLogger(CLASSNAME, strMethodName, "Started with Course Id :"+id));
		
		courseRepository.delete(id);
		
		logger.info(CommonUtility.getSampleLogger(CLASSNAME, strMethodName, "Ended"));
	}

}
