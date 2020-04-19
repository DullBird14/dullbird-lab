package org.dullbird.cloud.dubbo.dto;

import java.io.Serializable;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年04月18日 19:54:00
 */
public class UserDTO implements Serializable {

    /**
     * 用户编号
     */
    private Integer id;
    private String name;
    private Integer gender;

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }
}
