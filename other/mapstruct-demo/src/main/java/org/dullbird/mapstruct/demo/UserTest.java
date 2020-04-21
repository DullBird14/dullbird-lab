package org.dullbird.mapstruct.demo;

import org.dullbird.mapstruct.demo.BO.UserBO;
import org.dullbird.mapstruct.demo.BO.UserDetailBO;
import org.dullbird.mapstruct.demo.DO.UserDO;
import org.dullbird.mapstruct.demo.DO.UserFullDO;
import org.dullbird.mapstruct.demo.convert.UserConvert;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年04月19日 21:34:00
 */
public class UserTest {
    public static void main(String[] args) {
        UserDO userDO1 = UserDO.builder()
                .id(1)
                .username("张三")
                .password("abc123")
                .build();
        UserDO userDO2 = UserDO.builder()
                .id(1)
                .username("张三")
                .password("abc123")
                .build();
        UserBO convert = UserConvert.INSTANCE.convert(userDO1);
        System.out.println(convert);
        ArrayList<UserDO> userDOS = new ArrayList<>();
        userDOS.add(userDO1);
        userDOS.add(userDO2);
        List<UserBO> userBOS = UserConvert.INSTANCE.convertList(userDOS);
        System.out.println(userBOS);
        UserDetailBO userDetailBO = UserConvert.INSTANCE.convertDetail(userDO1);
        System.out.println(userDetailBO);
        userDetailBO.setAddress("zhejiang hangzhou");
        UserFullDO userFullDO = UserConvert.INSTANCE.convertMix(convert, userDetailBO);
        System.out.println(userFullDO);

    }
}
