package com.udemy.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.udemy.converter.CourseConverter;
import com.udemy.entity.Course;
import com.udemy.model.CourseModel;
import com.udemy.repository.CourseJpaRepository;
import com.udemy.services.CourseService;

@Service("courseServiceImpl")
public class CourseServiceImpl implements CourseService {

	private static final Log LOG = LogFactory.getLog(CourseServiceImpl.class);

	@Autowired
	@Qualifier("courseJpaRepository")
	private CourseJpaRepository courseJpaRepository;

	@Autowired
	@Qualifier("courseConverter")
	private CourseConverter courseConverter;

	@Override
	public List<CourseModel> listAllCourses() {
		LOG.info("Call: " + "listAllCourses()");
		List<Course> listCourse = courseJpaRepository.findAll();
		List<CourseModel> listCourseModel = new ArrayList<CourseModel>();
		int listCourseSize = listCourse.size();

		for (int i = 0; i < listCourseSize; i++) {

			listCourseModel.add(courseConverter.entity2model(listCourse.get(i)));
		}

		return listCourseModel;
	}

	@Override
	public Course addCourse(CourseModel courseModel) {
		LOG.info("Call: " + "addCourse()");
		return courseJpaRepository.save(courseConverter.model2entity(courseModel));
	}

	@Override
	public int removeCourse(int id) {
		LOG.info("Call: " + "removeCourse()");
		courseJpaRepository.delete(id);
		return 0;
	}

	@Override
	public Course updateCourse(CourseModel courseModel) {
		LOG.info("Call: " + "updateCourse()");
		int id = courseModel.getId();
		LOG.info("Call: " + "removeCourse()");
		courseJpaRepository.delete(id);
		return courseJpaRepository.save(courseConverter.model2entity(courseModel));
	}

}
