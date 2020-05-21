package org.dullbird.nacos.controller;


import org.dullbird.nacos.RequestBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年04月13日 12:43:00
 */
@RestController
@RequestMapping("/demo")
public class NacosDemoController{
    @Autowired
    private RequestBean requestBean;

    @GetMapping("/test1")
    public String test01() {
        return requestBean.toString();
    }
}
