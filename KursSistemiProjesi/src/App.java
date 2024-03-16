import DAO.HibernateDao;
import DAO.JdbcDao;
import business.CategoryManager;
import business.CourseManager;
import business.TeacherManager;
import core.logging.DatabaseLogger;
import core.logging.FileLogger;
import core.logging.ILogger;
import core.logging.MailLogger;
import entities.Category;
import entities.Course;
import entities.Teacher;

public class App {
    public static void main(String[] args) throws Exception {

        ILogger[] loggers = new ILogger[] { new DatabaseLogger(), new FileLogger(), new MailLogger() };

        Teacher teacher = new Teacher(0, "Engin", "Demirog", 35);
        TeacherManager teacherManager = new TeacherManager(loggers, new JdbcDao());
        teacherManager.add(teacher);

        System.out.println("-----------------TEACHER-----------------");

        Category category1 = new Category(0, "Programlama");
        Category category2 = new Category(1, "Data analiz");
        CategoryManager categoryManager = new CategoryManager(loggers, new HibernateDao());
        categoryManager.add(category1);
        categoryManager.add(category2);

        System.out.println("-----------------Category-----------------");

        Course course1 = new Course(0, "C#", 100, "Aciklama", 1);
        Course course2 = new Course(1, "Java", 200, "Aciklama", 1);
        CourseManager courseManager = new CourseManager(loggers, new JdbcDao());
        courseManager.add(course1);
        courseManager.add(course2);
        System.out.println("-----------------Category-----------------");

    }
}
