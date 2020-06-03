package org.dullbird.execl.demo;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.util.PoiPublicUtil;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年06月03日 14:42:00
 */
public class EasyImportDemo {
    public static void main(String[] args) {
        ImportParams params = new ImportParams();
        long start = System.currentTimeMillis();
        List<Map> list = ExcelImportUtil.importExcel(
                new File("/Users/user01/Desktop/课程目标execl.xlsx"),
                Map.class, params);
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(list.size());
        System.out.println(ReflectionToStringBuilder.toString(list.get(0)));
    }
}
