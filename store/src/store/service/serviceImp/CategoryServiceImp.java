package store.service.serviceImp;

import java.util.List;

import store.dao.CategoryDao;
import store.dao.daoImp.CategoryDaoImp;
import store.domain.Category;
import store.service.CategoryService;

public class CategoryServiceImp implements CategoryService{

    @Override
    public List<Category> getAllCats() throws Exception {
        CategoryDao CategoryDao=new CategoryDaoImp();
        return CategoryDao.getAllCats();
    }

}
