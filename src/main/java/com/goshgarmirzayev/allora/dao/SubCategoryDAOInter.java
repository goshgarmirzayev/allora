package com.goshgarmirzayev.allora.dao;
import com.goshgarmirzayev.allora.entity.SubCategory;
import org.springframework.data.repository.CrudRepository;
import javax.transaction.Transactional;
@Transactional
public interface SubCategoryDAOInter extends CrudRepository<SubCategory, Integer> {

}