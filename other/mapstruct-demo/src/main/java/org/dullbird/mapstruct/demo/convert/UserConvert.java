package org.dullbird.mapstruct.demo.convert;

import org.dullbird.mapstruct.demo.BO.UserBO;
import org.dullbird.mapstruct.demo.BO.UserDetailBO;
import org.dullbird.mapstruct.demo.DO.UserDO;
import org.dullbird.mapstruct.demo.DO.UserFullDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年04月19日 21:28:00
 */
@Mapper
public interface UserConvert {
    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

    UserBO convert(UserDO userDO);
    /**
     * 集合转换
     */
    List<UserBO> convertList(List<UserDO> userDO);

    /**
     * 一旦配置了Mappings，就不会自动根据名字去填充了
     */
    @Mappings({
            @Mapping(source = "id", target = "userId")
    })
    UserDetailBO convertDetail(UserDO userDO);

    @Mappings({
            @Mapping(source = "userBO.password", target = "password"),
            @Mapping(source = "userDetailBO.address", target = "address")
    })
    UserFullDO convertMix(UserBO userBO, UserDetailBO userDetailBO);
}
