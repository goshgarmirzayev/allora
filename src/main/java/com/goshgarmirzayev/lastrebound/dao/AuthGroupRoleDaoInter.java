package com.goshgarmirzayev.lastrebound.dao;

import com.goshgarmirzayev.lastrebound.entity.AuthGroup;
import com.goshgarmirzayev.lastrebound.entity.AuthGroupRole;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
public interface AuthGroupRoleDaoInter extends CrudRepository<AuthGroupRole, Integer> {

    List<AuthGroupRole> findByGroupId(AuthGroup group);
}
