package com.dongql.mybatis.tenant.entity;


import com.dongql.mybatis.tenant.annotations.MultiTenant;
import com.dongql.mybatis.tenant.annotations.MultiTenantColumn;
import com.dongql.mybatis.tenant.annotations.MultiTenantType;
import com.dongql.mybatis.tenant.enums.Gender;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 用户表，共享表实现多租户
 * Created by dongql on 10/01/2016.
 */
@Entity
@MultiTenant(type = MultiTenantType.COLUMN)
@MultiTenantColumn
public class UserPassword implements Serializable {

    @Id
    private Long uid;

    private String password;
    private Gender salt;

    @Override
    public String toString() {
        return uid + ">" + password + ":" + salt;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Gender getSalt() {
        return salt;
    }

    public void setSalt(Gender salt) {
        this.salt = salt;
    }
}