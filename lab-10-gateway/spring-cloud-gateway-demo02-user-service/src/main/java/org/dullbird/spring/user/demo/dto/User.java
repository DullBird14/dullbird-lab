package org.dullbird.spring.user.demo.dto;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年05月28日 23:51:00
 */
public class User {
    private Long id;
    private Integer age;
    private String name;

    public User(Long id, Integer age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
