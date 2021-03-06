package com.qxcmp.framework.finance;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 钱包消费记录实体
 * <p>
 * 用于记录用户钱包消费记录
 * <p>
 * 可用于记录余额、积分等各项数据变化
 *
 * @author Aaric
 */
@Entity
@Table
@Data
public class WalletRecord {

    @Id
    @GeneratedValue
    private Long id;

    private String userId;

    private String type;

    private int amount;

    private Date date;

    private String comments;

    /**
     * 查看消费详情对应的Url
     */
    private String url;
}
