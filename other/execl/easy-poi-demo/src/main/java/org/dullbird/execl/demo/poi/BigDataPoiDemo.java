package org.dullbird.execl.demo.poi;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年06月10日 21:32:00
 */
public class BigDataPoiDemo {
    public static void main(String[] args) throws IOException, InvalidFormatException {
        //处理不了xls
        SXSSFWorkbook workbook = new SXSSFWorkbook(new XSSFWorkbook(new File("/Users/user01/workcontext/idea/learnSpace/mos-interview/src/main/resources/data/skus.xls")),2);
        SXSSFSheet sheetAt = workbook.getSheetAt(0);
        sheetAt.forEach(System.out::println);
    }
}
