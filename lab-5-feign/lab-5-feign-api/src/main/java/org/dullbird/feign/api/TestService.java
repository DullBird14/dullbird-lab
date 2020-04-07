package org.dullbird.feign.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年04月06日 22:21:00
 */
public interface TestService {
    @GetMapping("/echo")
    String echo(@RequestParam("name") String name);
}
