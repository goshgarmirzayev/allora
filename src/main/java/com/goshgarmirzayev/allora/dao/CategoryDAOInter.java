package com.goshgarmirzayev.allora.dao;
import com.goshgarmirzayev.allora.entity.Category;
//import com.goshgarmirze.allora.entity.entity.Category;
import org.springframework.data.repository.CrudRepository;
import javax.transaction.Transactional;
@Transactional
public interface CategoryDAOInter extends CrudRepository<Category, Integer> {

}