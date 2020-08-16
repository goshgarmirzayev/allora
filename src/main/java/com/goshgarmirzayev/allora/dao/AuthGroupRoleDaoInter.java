package com.goshgarmirzayev.allora.dao;

import com.goshgarmirzayev.allora.entity.AuthGroup;
import com.goshgarmirzayev.allora.entity.AuthGroupRole;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
public interface AuthGroupRoleDaoInter extends CrudRepository<AuthGroupRole, Integer> {

    List<AuthGroupRole> findByGroupId(AuthGroup group);
}
