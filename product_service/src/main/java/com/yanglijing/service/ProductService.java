package com.yanglijing.service;

import com.yanglijing.pojo.BackPrice;
import com.yanglijing.vo.ProductVo;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @InterfaceName ProductService
 * @Description: TODO
 * @Author :lianweibo
 * @Date 2019/11/18
 * @Version V1.0
 **/
public interface ProductService {
    Page<BackPrice> selectList(ProductVo productVo);

    void deleteById(Integer backId);

    void deleteByIds(List<BackPrice> backPrice);

    void save(BackPrice backPrice);

    Object selectById(Integer backId);

    boolean update(BackPrice backPrice);
}
