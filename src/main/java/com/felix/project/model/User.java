package com.felix.project.model;

import cn.afterturn.easypoi.excel.annotation.Excel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "t_user")
@Entity
public class User {
    @Id
    @Excel(name = "用户id")
    @Column(name = "USER_ID")
    private Integer userId;
    @Excel(name = "用户名")
    @Column(name = "USERNAME")
    private String userName;
    @Excel(name = "密码")
    @Column(name = "PASSWORD")
    private String password;
    @Excel(name = "部门ID")
    @Column(name = "DEPT_ID")
    private String deptId;
    @Excel(name = "邮箱")
    @Column(name = "EMAIL")
    private String email;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
