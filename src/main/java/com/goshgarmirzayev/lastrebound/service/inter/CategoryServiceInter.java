package com.goshgarmirzayev.lastrebound.service.inter;

import com.goshgarmirzayev.lastrebound.entity.Category;
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