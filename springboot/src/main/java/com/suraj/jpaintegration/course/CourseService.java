package com.suraj.jpaintegration.course;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suraj.jpaintegration.topic.TopicRepository;
import com.suraj.jpaintegration.topic.TopicService;
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
		return courseRepository.findByTopicId(topicId);
	}
	
	public Course getCourse(String id) {
		return courseRepository.findOne(id);
	}
	
	public void addCourse(Course course, String topicId) {
		String strMethodName = "addCourse";
		logger.info(CommonUtility.getSampleLogger(CLASSNAME, strMethodName, "Started"));
		course.setTopic(topicRepository.findOne(topicId));
		logger.info(CommonUtility.getSampleLogger(CLASSNAME, strMethodName, "Course is :"+course));
		courseRepository.save(course);
		logger.info(CommonUtility.getSampleLogger(CLASSNAME, strMethodName, "Ended"));
	}
	
	public void updateCourse(Course course, String topicId) {
		course.setTopic(topicRepository.findOne(topicId));
		courseRepository.save(course);
	}
	
	public void deleteCourse(String id) {
		courseRepository.delete(id);
	}

}
