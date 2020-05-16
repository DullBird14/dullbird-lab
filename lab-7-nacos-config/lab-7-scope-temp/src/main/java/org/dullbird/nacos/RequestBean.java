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
    public RequestBean() {
        System.out.println("====================");
    }
}
