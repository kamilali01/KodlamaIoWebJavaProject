package DAO;

import entities.Category;
import entities.Course;
import entities.Teacher;

public class JdbcDao implements ICategoryDao, ITeacherDao, ICourseDao {

    @Override
    public void add(Course course) {
        System.out.println("Jdbc ile eklendi: " + course.getName());
    }

    @Override
    public void add(Teacher teacher) {
        System.out.println("Jdbc ile eklendi: " + teacher.getName());
    }

    @Override
    public void add(Category category) {
        System.out.println("Jdbc ile eklendi: " + category.getName());
    }

}
