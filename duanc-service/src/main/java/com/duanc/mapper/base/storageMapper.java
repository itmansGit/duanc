package com.duanc.mapper.base;

import com.duanc.model.base.Basestorage;
import com.duanc.model.base.BasestorageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface storageMapper {
    int countByExample(BasestorageExample example);

    int deleteByExample(BasestorageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Basestorage record);

    int insertSelective(Basestorage record);

    List<Basestorage> selectByExample(BasestorageExample example);

    Basestorage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Basestorage record, @Param("example") BasestorageExample example);

    int updateByExample(@Param("record") Basestorage record, @Param("example") BasestorageExample example);

    int updateByPrimaryKeySelective(Basestorage record);

    int updateByPrimaryKey(Basestorage record);
}