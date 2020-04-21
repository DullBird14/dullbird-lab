package org.dullbird.mapstruct.demo.BO;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年04月19日 22:27:00
 */
@Data
@Accessors(chain = true)
public class UserDetailBO {
    private Integer userId;
    private String username;
    private String address;
}
