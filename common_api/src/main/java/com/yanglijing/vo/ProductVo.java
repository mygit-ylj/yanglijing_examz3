package com.yanglijing.vo;

import com.yanglijing.pojo.Paper;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName ProductVo
 * @Description: TODO
 * @Author :yanglijing
 * @Date 2019/11/18
 * @Version V1.0
 **/
@Data
public class ProductVo {
    private Integer paperId;
    private String incomepricePerson;
    private String remarks;
    private Integer backId;
    private Date startDate;
    private Date endDate;
    private String propName;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private Integer pageNum;
    private Integer pageSize;
}
