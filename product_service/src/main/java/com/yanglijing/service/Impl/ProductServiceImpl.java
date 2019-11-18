package com.yanglijing.service.Impl;

import com.yanglijing.pojo.BackPrice;
import com.yanglijing.repository.ProductRepository;
import com.yanglijing.service.ProductService;
import com.yanglijing.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ProductServiceImpl
 * @Description: TODO
 * @Author :yanglijing
 * @Date 2019/11/18
 * @Version V1.0
 **/
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Page<BackPrice> selectList(ProductVo productVo) {
        Specification<BackPrice> spec = new Specification<BackPrice>() {
            @Override
            public Predicate toPredicate(Root<BackPrice> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<>();

                if (productVo.getBackId()!=null){
                    Predicate p1 = cb.equal(root.get("paperId"), productVo.getBackId());
                    list.add(p1);
                }

                Predicate[] newArr = list.toArray(new Predicate[list.size()]);
                return cb.and(newArr);
            }
        };
        Page<BackPrice> page = productRepository.findAll(spec, PageRequest.of(productVo.getPageNum() - 1, productVo.getPageSize()));
        return page;
    }
}
