package com.yanglijing.service;

import com.yanglijing.pojo.BackPrice;
import com.yanglijing.vo.ProductVo;
import org.springframework.data.domain.Page;

/**
 * @InterfaceName ProductService
 * @Description: TODO
 * @Author :lianweibo
 * @Date 2019/11/18
 * @Version V1.0
 **/
public interface ProductService {
    Page<BackPrice> selectList(ProductVo productVo);
}
