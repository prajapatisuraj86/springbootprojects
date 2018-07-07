package com.suraj.jpaintegration.course;

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

import com.suraj.jpaintegration.util.CommonUtility;

@RestController
@CrossOrigin
public class CourseController {
	
	private static final String CLASSNAME = "CourseController";
	private static final Logger logger = LogManager.getLogger(CourseController.class.getSimpleName());

	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/topics/{topicId}/courses")
	public List<Course> getAllCourses(@PathVariable("topicId") String topicId) {
		String strMethodName = "getAllCourses";
		logger.info(CommonUtility.getSampleLogger(CLASSNAME, strMethodName, "Started"));
		List<Course> lstCourses = courseService.getAllCourses(topicId);
		logger.info(CommonUtility.getSampleLogger(CLASSNAME, strMethodName, "Ended"));
		return lstCourses;
	}
	
	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Course getCourse(@PathVariable("topicId") String topicId, @PathVariable("id") String id) {
		String strMethodName = "getCourse";
		logger.info(CommonUtility.getSampleLogger(CLASSNAME, strMethodName, "Started"));
		Course course = courseService.getCourse(id);
		logger.info(CommonUtility.getSampleLogger(CLASSNAME, strMethodName, "Ended"));
		return course;
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable("topicId") String topicId) {
		String strMethodName = "addCourse";
		logger.info(CommonUtility.getSampleLogger(CLASSNAME, strMethodName, "Started"));
		courseService.addCourse(course, topicId);
		logger.info(CommonUtility.getSampleLogger(CLASSNAME, strMethodName, "Ended"));
	}
	
	
	@RequestMapping(method=RequestMethod.PUT, value = "/topics/{topicId}/courses")
	public void updateCourse(@RequestBody Course course, @PathVariable("topicId") String topicId) {
		String strMethodName = "updateCourse";
		logger.info(CommonUtility.getSampleLogger(CLASSNAME, strMethodName, "Started"));
		courseService.updateCourse(course, topicId);
		logger.info(CommonUtility.getSampleLogger(CLASSNAME, strMethodName, "Ended"));
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value = "topics/{topicId}/courses/{id}")
	public void deleteCourse(@PathVariable("topicId") String topicId, @PathVariable("id") String id) {
		String strMethodName = "deleteCourse";
		logger.info(CommonUtility.getSampleLogger(CLASSNAME, strMethodName, "Started"));
		courseService.deleteCourse(id);
		logger.info(CommonUtility.getSampleLogger(CLASSNAME, strMethodName, "Ended"));
	}
	
}

