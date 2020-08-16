package com.goshgarmirzayev.lastrebound.service.impl;
import com.goshgarmirzayev.lastrebound.dao.CategoryDAOInter;
import com.goshgarmirzayev.lastrebound.entity.Category;
import com.goshgarmirzayev.lastrebound.service.inter.CategoryServiceInter;
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