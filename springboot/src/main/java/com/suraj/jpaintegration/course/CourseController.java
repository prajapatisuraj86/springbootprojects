package com.suraj.jpaintegration.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/topics/{topicId}/courses")
	public List<Course> getAllCourses(@PathVariable("topicId") String topicId) {
		return courseService.getAllCourses(topicId);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Course getCourse(@PathVariable("topicId") String topicId, @PathVariable("id") String id) {
		return courseService.getCourse(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable("topicId") String topicId) {
		courseService.addCourse(course, topicId);
	}
	
	
	@RequestMapping(method=RequestMethod.PUT, value = "/topics/{topicId}/courses")
	public void updateCourse(@RequestBody Course course, @PathVariable("topicId") String topicId) {
		courseService.updateCourse(course, topicId);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value = "topics/{topicId}/courses/{id}")
	public void deleteCourse(@PathVariable("topicId") String topicId, @PathVariable("id") String id) {
		courseService.deleteCourse(id);
	}
	
}

