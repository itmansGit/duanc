package com.duanc.mapper.base;

import com.duanc.model.base.BaseBrand;
import com.duanc.model.base.BaseBrandExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BrandMapper {
    int countByExample(BaseBrandExample example);

    int deleteByExample(BaseBrandExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BaseBrand record);

    int insertSelective(BaseBrand record);

    List<BaseBrand> selectByExample(BaseBrandExample example);

    BaseBrand selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BaseBrand record, @Param("example") BaseBrandExample example);

    int updateByExample(@Param("record") BaseBrand record, @Param("example") BaseBrandExample example);

    int updateByPrimaryKeySelective(BaseBrand record);

    int updateByPrimaryKey(BaseBrand record);
}