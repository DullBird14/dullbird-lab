package org.dullbird.nacos.controller;

import org.dullbird.nacos.RequestBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年04月13日 12:43:00
 */
@RestController
@RequestMapping("/demo")
public class NacosDemoController implements EnvironmentAware {
    @Autowired
    private RequestBean requestBean;

    @Autowired(required = false)
    private DataSource dataSource;
    private Environment environment;
    @GetMapping("/test1")
    public String test01() {
        ConfigurableEnvironment environment = (ConfigurableEnvironment) this.environment;
        return environment.getPropertySources().toString();
    }
    @GetMapping("/test02")
    public String test02() throws SQLException {
        PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement("select * from pg_config");
        boolean execute = preparedStatement.execute();
        ResultSet resultSet = preparedStatement.getResultSet();
        System.out.println(resultSet);
        while (resultSet.next()){
            System.out.println(resultSet.getString("key"));
        }
        return dataSource.toString();
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
