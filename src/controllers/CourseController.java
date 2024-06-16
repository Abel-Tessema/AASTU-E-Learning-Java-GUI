package controllers;

import exceptions.CoursesFetchException;
import models.Course;
import services.CourseService;

import java.util.List;

public class CourseController {
    private final CourseService courseService = new CourseService();
    private List<Course> courses;

    public String fetchAllCourses() {
        try {
            this.courses = courseService.fetchAllCourses();
            return "";
        } catch (CoursesFetchException e) {
            return e.getMessage();
        }
    }

    public List<Course> getCourses() {
        return courses;
    }
}
