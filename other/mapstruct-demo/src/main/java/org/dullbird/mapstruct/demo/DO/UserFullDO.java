package org.dullbird.mapstruct.demo.DO;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年04月19日 22:36:00
 */
@Data
@Accessors(chain = true)
public class UserFullDO {
    /** 密码 **/
    private String password;
    /** 地址 **/
    private String address;

}
