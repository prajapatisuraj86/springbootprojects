package com.suraj.jpaintegration.course;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CourseService {
	
	@Autowired
	CourseRepository courseRepository;
	
	/*public List<Course> getAllTopic() {
		List<Course> topics = new ArrayList<>();
		Iterator<Course> iterator = courseRepository.findAll().iterator();
		while(iterator.hasNext()) {
			topics.add(iterator.next());
		}
		return topics;
	}
	
	public Course getTopic(String id) {
		return courseRepository.findOne(id);
	}
	
	public void addTopic(Course topic) {
		courseRepository.save(topic);
	}
	
	public void updateTopic(Course topic, String id) {
		courseRepository.save(topic);
	}
	
	public void deleteTopic(String id) {
		courseRepository.delete(id);
	}*/

}
