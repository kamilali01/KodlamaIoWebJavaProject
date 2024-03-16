package business;

import java.util.ArrayList;
import java.util.List;

import DAO.ICategoryDao;
import core.logging.ILogger;
import entities.Category;

public class CategoryManager {
    private ILogger[] loggers;
    private ICategoryDao categoryDao;
     private List<Category> allCategories = new ArrayList<>();

    public CategoryManager(ILogger[] loggers, ICategoryDao categoryDao) {
        this.loggers = loggers;
        this.categoryDao = categoryDao;
    }

    public void add(Category category) throws Exception {
        if (findCategory(category)) {
            throw new Exception("Hata: Kateqori ismi ayni olamaz");
        }

        allCategories.add(category);
        categoryDao.add(category);

        for (ILogger logger : loggers) {
            logger.log(category.getName());
        }
        
    }

    public boolean findCategory(Category category) {
        for (Category existingCategory : allCategories) {
            if(existingCategory.getName().equals(category.getName())){
                return true;
            }
        }
        return false;
    }

}
