package org.fishe.education.web.controller;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import org.fishe.education.business.CourseBean;
import org.fishe.education.domain.Course;

/**
 *
 * @author leguman
 */
@ManagedBean
@RequestScoped
public class CourseMBean {

    @EJB
    private CourseBean courseBean;

    private List<Course> courses;

    @ManagedProperty(value = "#{param.id}")
    private Integer id;

    private Course course;

    public List<Course> getCourses() {
        if (courses == null) {
            courses = courseBean.findAll();
        }
        return courses;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Course getCourse() {
        return this.course;
    }

    @PostConstruct
    public void load() {
        if (id != null) {
            this.course = courseBean.find(id);
        } else {
            this.course = courseBean.create();
        }
    }

    public String save() {
        courseBean.save(this.course);
        return "courses";
    }

    public String remove() {
        courseBean.remove(this.course.getId());
        return "courses";
    }

}
