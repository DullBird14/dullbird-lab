package org.dullbird.nacos;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年05月12日 22:43:00
 */
@Component
@RequestScope
public class RequestBean {
    private Long id;
    private String name;

    public RequestBean() {
        id = 1L;
        name = "zhangsan";
        System.out.println("====================");
    }

    @Override
    public String toString() {
        return "RequestBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
