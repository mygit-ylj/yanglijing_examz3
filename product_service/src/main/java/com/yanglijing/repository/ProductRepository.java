package com.yanglijing.repository;

import com.yanglijing.pojo.BackPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @InterfaceName ProductRepository
 * @Description: TODO
 * @Author :lianweibo
 * @Date 2019/11/18
 * @Version V1.0
 **/
public interface ProductRepository extends JpaRepository<BackPrice,Integer>, JpaSpecificationExecutor<BackPrice> {
    BackPrice update(BackPrice backPrice);
}
