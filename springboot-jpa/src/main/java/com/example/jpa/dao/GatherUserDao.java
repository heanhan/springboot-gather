package com.example.jpa.dao;

import com.example.jpa.entity.GatherUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author by zhaojh0912
 * @Description TODO
 * @Date 2020/5/16 11:29 上午
 */
@Repository
public interface GatherUserDao extends JpaRepository<GatherUser,Long>, JpaSpecificationExecutor<GatherUser> {


}
