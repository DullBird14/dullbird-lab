package org.dullbird.execl.demo;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年06月03日 14:42:00
 */
public class IndexEasyImportDemo {
    private static final Pattern pattern = Pattern.compile("\\d+");
    public static void main(String[] args) {
        ImportParams params = new ImportParams();
        long start = System.currentTimeMillis();
        List<Map> list = ExcelImportUtil.importExcel(
                new File("/Users/user01/Desktop/temp.xlsx"),
                Map.class, params);
        int count =0;
        Set<String> ids = new HashSet<>();
        for (Map map : list) {

            Object id = map.get("id");
            if (Objects.isNull(id)) {
                continue;
            }
            System.out.printf("===========================================\n");
//            System.out.printf("update pj_indicator_course_relation set `deleted`  = true where `indicator_tree_item_id` =%s;\n", id);
            Object courses = map.get("courses");
            if (Objects.isNull(courses)) {
                continue;
            }
            String content = courses.toString();
            Matcher matcher = pattern.matcher(content);
            while (matcher.find()) {
                ids.add(matcher.group());
                //sql---插入指标
//                System.out.printf("insert into `pg_norm`(`course_id`,`parent_id`,`name`,`ename`," +
//                                "`describe`,`norm_type`,`score_type`,`deleted`,`third_id`) " +
//                                "select %s,null,'%s','%s','20200605',1,null,0, %s from dual " +
//                                "WHERE NOT EXISTS(SELECT 1 from  pg_norm WHERE  `course_id` =%s and" +
//                                " `third_id` = %s);\n", matcher.group(), map.get("name"),
//                        map.get("ename"), id, matcher.group(), id);
                System.out.printf("INSERT INTO `pg_plan_and_norm_relation` (`evaluation_plan_id`,`norm_id`,`remark`,`deleted`) " +
                        "SELECT 6, id, '20200605', 0 from pg_norm where `course_id` =%s and `third_id` =%s;\n", matcher.group(), id);
            }
            count++;
        }
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(list.size());
        System.out.println(ReflectionToStringBuilder.toString(list.get(0)));
        System.out.println(count);
        System.out.println(ids);

    }
}
