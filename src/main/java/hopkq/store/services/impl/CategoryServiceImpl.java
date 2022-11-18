package hopkq.store.services.impl;

import hopkq.store.entities.Category;
import hopkq.store.repositories.CategoryRepository;
import hopkq.store.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategory() {
        List<Category> listCategories = categoryRepository.getAllCategory();
        if (listCategories.isEmpty()) {
            return null;
        }
        return listCategories;
    }
}
