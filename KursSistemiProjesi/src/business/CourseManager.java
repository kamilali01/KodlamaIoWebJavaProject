package business;

import java.util.ArrayList;
import java.util.List;

import DAO.ICourseDao;
import core.logging.ILogger;
import entities.Course;

public class CourseManager {
    private ILogger[] loggers;
    private ICourseDao courseDao;
     private List<Course> allCourses = new ArrayList<>();

    public CourseManager(ILogger[] loggers, ICourseDao courseDao) {
        this.loggers = loggers;
        this.courseDao = courseDao;
    }

    public void add(Course course) throws Exception
    {
        
        if(findCourse(course)){
            throw new Exception("Hata: Kurs ismi ayni olamaz");
        }
        if(course.getPrice()<0){
            throw new Exception("Hata: Fiyat 0-dan kucuk olamaz");
        }

        allCourses.add(course);
        courseDao.add(course);

        for (ILogger logger : loggers) {
            logger.log(course.getName());
        }

    }

    public boolean findCourse(Course course){

        for (Course currentCourse : allCourses) {
            if(currentCourse.getName().equals(course.getName())){
                return true;
            }
        }
        return false;

    }

}
