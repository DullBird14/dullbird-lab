package org.dullbird.feign.api.dto;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年04月06日 22:54:00
 */
public class DemoDTO {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "DemoDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
