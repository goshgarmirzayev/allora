package com.goshgarmirzayev.allora.service.inter;

import com.goshgarmirzayev.allora.entity.SubCategory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SubCategoryServiceInter {
    List<SubCategory> findAll();

    SubCategory findById(Integer id);

    SubCategory save(SubCategory vSubCategory);

    int deleteById(Integer id);
}