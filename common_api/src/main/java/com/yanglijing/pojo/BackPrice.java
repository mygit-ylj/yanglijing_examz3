package com.yanglijing.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName BackPrice
 * @Description: TODO
 * @Author :yanglijing
 * @Date 2019/11/18
 * @Version V1.0
 **/
@Entity
@Table(name = "backPrice")
@Data
public class BackPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer backId;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date backCreated;
    private BigDecimal backPrice;
    private String incomepricePerson;
    private BigDecimal yuPrice;
    private BigDecimal paperPrice;
    private String remarks;
    @ManyToOne
    @JoinColumn(name = "paperId")
    private Paper paper;
}
