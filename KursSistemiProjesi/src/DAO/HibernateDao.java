package DAO;

import entities.Category;
import entities.Course;
import entities.Teacher;

public class HibernateDao implements ICategoryDao, ITeacherDao, ICourseDao {

    @Override
    public void add(Course course) {
        System.out.println("Hibernate ile eklendi: " + course.getName());
    }

    @Override
    public void add(Teacher teacher) {
        System.out.println("Hibernate ile eklendi: " + teacher.getName());
    }

    @Override
    public void add(Category category) {
        System.out.println("Hibernate ile eklendi: " + category.getName());
    }

}
