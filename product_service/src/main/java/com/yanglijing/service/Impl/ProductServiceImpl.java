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

                if (productVo.getPaperId()!=null){
                    Predicate p1 = cb.equal(root.get("paper.paperId"), productVo.getPaperId());
                    list.add(p1);
                }
                if (productVo.getIncomepricePerson()!=null){
                    Predicate p2 = cb.like(root.get("incomepricePerson"), "%"+productVo.getIncomepricePerson()+"%");
                    list.add(p2);
                }
                if (productVo.getRemarks()!=null){
                    Predicate p3 = cb.like(root.get("remarks"), "%"+productVo.getRemarks()+"%");
                    list.add(p3);
                }
                if (productVo.getStartDate()!=null){
                    Predicate p4 = cb.greaterThanOrEqualTo(root.get("backCreated"), productVo.getStartDate());
                    list.add(p4);
                }
                if (productVo.getEndDate()!=null){
                    Predicate p5 = cb.lessThanOrEqualTo(root.get("backCreated"), productVo.getEndDate());
                    list.add(p5);
                }
                if (productVo.getPropName()!=null){
                    if (productVo.getMinPrice()!=null){
                        Predicate p6 = cb.ge(root.get(productVo.getPropName()), productVo.getMinPrice());
                        list.add(p6);
                    }
                    if (productVo.getMaxPrice()!=null){
                        Predicate p7 = cb.le(root.get(productVo.getPropName()), productVo.getMaxPrice());
                        list.add(p7);
                    }
                }
                Predicate[] newArr = list.toArray(new Predicate[list.size()]);
                return cb.and(newArr);
            }
        };
        Page<BackPrice> page = productRepository.findAll(spec, PageRequest.of(productVo.getPageNum() - 1, productVo.getPageSize()));
        return page;
    }

    @Override
    public void deleteById(Integer backId) {
        productRepository.deleteById(backId);
    }

    @Override
    public void deleteByIds(List<BackPrice> backPrice) {
        productRepository.delete((BackPrice) backPrice);
    }

    @Override
    public void save(BackPrice backPrice) {
        productRepository.save(backPrice);
    }

    @Override
    public Object selectById(Integer backId) {
        return productRepository.findById(backId);
    }

    @Override
    public boolean update(BackPrice backPrice) {
        return true;
    }
}
