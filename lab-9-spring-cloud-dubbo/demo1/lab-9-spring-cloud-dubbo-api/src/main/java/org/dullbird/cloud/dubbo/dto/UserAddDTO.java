package org.dullbird.cloud.dubbo.dto;

import java.io.Serializable;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年04月18日 19:56:00
 */
public class UserAddDTO implements Serializable {
    private String name;
    private Integer gender;

    @Override
    public String toString() {
        return "UserAddDTO{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                '}';
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
