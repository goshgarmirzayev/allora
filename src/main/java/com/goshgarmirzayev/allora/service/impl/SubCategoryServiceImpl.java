package com.goshgarmirzayev.allora.service.impl;
import com.goshgarmirzayev.allora.entity.SubCategory;
import org.springframework.stereotype.Service;
import java.util.List;
import com.goshgarmirzayev.allora.dao.SubCategoryDAOInter;
import com.goshgarmirzayev.allora.service.inter.SubCategoryServiceInter;
import org.springframework.beans.factory.annotation.Autowired;@Service 
public class SubCategoryServiceImpl implements SubCategoryServiceInter{

@Autowired
SubCategoryDAOInter aSubCategoryDaoInter;
@Override
public List<SubCategory> findAll() {
return (List<SubCategory>)aSubCategoryDaoInter.findAll();
}
@Override
public SubCategory findById(Integer id) {
return aSubCategoryDaoInter.findById(id).get();
}
@Override
public SubCategory save(SubCategory vSubCategory) {
 return aSubCategoryDaoInter.save(vSubCategory);
}
@Override
public int deleteById(Integer id) {aSubCategoryDaoInter.deleteById(id);
 return 0;
}
}