package com.goshgarmirzayev.allora.service.inter;

import com.goshgarmirzayev.allora.entity.Category;
//import com.goshgarmirze.allora.entity.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryServiceInter {
List<Category> findAll();
Category findById(Integer id);
Category save(Category vCategory);
int deleteById(Integer id);
}