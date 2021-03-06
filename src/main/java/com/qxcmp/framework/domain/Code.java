package com.qxcmp.framework.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 平台码实体
 * <p>
 * 当用户执行某些操作的时候，需要提供相应的码
 * <p>
 * 该实体存放这些码，并记录生成时间，会定期从数据库中删除
 *
 * @author aaric
 */
@Entity
@Table
@Data
public class Code {

    /**
     * 平台码唯一ID，由平台生成
     * <p>
     * 生成算法为获得UUID，然后进行SHA-256哈希，最后转换为Base64编码
     */
    @Id
    private String id;

    /**
     * 平台码所关联的用户主键
     * <p>
     * 在获取平台码进行相关操作的时候，通过本字段获取对应的用户信息
     */
    private String userId;

    /**
     * 平台码类型
     * <p>
     * 用于区分不同的平台操作
     *
     * @see Type
     */
    @Enumerated
    private Type type;

    /**
     * 平台码创建日期
     * <p>
     * 用于判定平台码是否过期
     */
    private Date dateCreated = new Date();

    /**
     * 平台码是否已经被使用
     */
    private boolean disabled;

    /**
     * 默认平台码的类型
     */
    public enum Type {

        /**
         * 激活码
         * <p>
         * 用于邮箱注册激活账户使用
         */
        ACTIVATE,

        /**
         * 重置码
         * <p>
         * 用户找回密码使用
         */
        PASSWORD,
    }
}
