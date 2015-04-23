package com.duanc.mapper.base;

import com.duanc.model.base.BaseuserAddress;
import com.duanc.model.base.BaseuserAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface userAddressMapper {
    int countByExample(BaseuserAddressExample example);

    int deleteByExample(BaseuserAddressExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BaseuserAddress record);

    int insertSelective(BaseuserAddress record);

    List<BaseuserAddress> selectByExample(BaseuserAddressExample example);

    BaseuserAddress selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BaseuserAddress record, @Param("example") BaseuserAddressExample example);

    int updateByExample(@Param("record") BaseuserAddress record, @Param("example") BaseuserAddressExample example);

    int updateByPrimaryKeySelective(BaseuserAddress record);

    int updateByPrimaryKey(BaseuserAddress record);
}