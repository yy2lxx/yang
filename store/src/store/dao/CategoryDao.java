package store.dao;

import store.domain.Category;

import java.util.List;

public interface CategoryDao {
    List<Category> getAllCats()throws Exception;
}
