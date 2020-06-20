package org.dullbird.itext.demo.css;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年06月19日 14:35:00
 */
public class TestThreeDemo {
    public static void main(String[] args) {
        try{
            String outputFile = "/Users/user01/temp2.pdf";
            Map<String,Object> variables = new HashMap<String,Object>();

            List<User> userList = new ArrayList<User>();

            User tom = new User("Tom",19,1);
            User amy = new User("Amy",28,0);
            User leo = new User("Leo",23,1);

            userList.add(tom);
            userList.add(amy);
            userList.add(leo);

            variables.put("title", "User List");
            variables.put("userList", userList);

            String htmlStr = HtmlGenerator.generate("sample.ftl", variables);

            OutputStream out = new FileOutputStream(outputFile);
            PdfGenerator.generate(htmlStr, out);

        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
