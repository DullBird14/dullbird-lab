package org.dullbird.mybatis.plus.demo.po;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年04月08日 23:33:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
//    @TableLogic
    private Boolean deleted;
}
