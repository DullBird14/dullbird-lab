package org.dullbird.mapstruct.demo.DO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年04月19日 21:27:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDO {
    /** 用户编号 **/
    private Integer id;
    /** 用户名 **/
    private String username;
    /** 密码 **/
    private String password;
}
