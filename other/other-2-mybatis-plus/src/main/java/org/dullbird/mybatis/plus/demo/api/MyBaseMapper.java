package org.dullbird.mybatis.plus.demo.api;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年04月11日 15:52:00
 */
public interface MyBaseMapper<T> extends BaseMapper {
    @Override
    default int deleteById(Serializable id) {
        throw new UnsupportedOperationException();
    };

    @Override
    default int delete(Wrapper wrapper) {
        throw new UnsupportedOperationException();
    };

    @Override
    default int deleteBatchIds(Collection idList){
        throw new UnsupportedOperationException();
    };
    @Override
    default List selectBatchIds(Collection idList){
        if (Objects.isNull(idList)) {
            throw new UnsupportedOperationException();
        }
        return this.selectBatchIds(idList);
    };

}
