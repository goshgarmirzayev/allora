package com.goshgarmirzayev.allora.service.impl;
import com.goshgarmirzayev.allora.dao.CategoryDAOInter;
import com.goshgarmirzayev.allora.entity.Category;
import com.goshgarmirzayev.allora.service.inter.CategoryServiceInter;
//import com.goshgarmirze.allora.entity.entity.Category;
import org.springframework.stereotype.Service;
import java.util.List;
//import com.goshgarmirze.allora.entity.dao.CategoryDAOInter;
//import com.goshgarmirze.allora.entity.service.inter.CategoryServiceInter;
import org.springframework.beans.factory.annotation.Autowired;@Service 
public class CategoryServiceImpl implements CategoryServiceInter {

@Autowired
CategoryDAOInter aCategoryDaoInter;
@Override
public List<Category> findAll() {
return (List<Category>)aCategoryDaoInter.findAll();
}
@Override
public Category findById(Integer id) {
return aCategoryDaoInter.findById(id).get();
}
@Override
public Category save(Category vCategory) {
 return aCategoryDaoInter.save(vCategory);
}
@Override
public int deleteById(Integer id) {aCategoryDaoInter.deleteById(id);
 return 0;
}
}