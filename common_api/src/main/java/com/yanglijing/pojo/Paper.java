package com.yanglijing.pojo;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @ClassName Paper
 * @Description: TODO
 * @Author :yanglijing
 * @Date 2019/11/18
 * @Version V1.0
 **/
@Entity
@Table(name = "paper")
@Data
public class Paper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paperId;
    private Integer UserId;
    private BigDecimal paperPrice;
    private String remarks;
}
