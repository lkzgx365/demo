package com.jackson.demo.demo.data.dao;


import com.jackson.demo.demo.data.po.TUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TUserDao {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(TUser record);

    TUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TUser record);

    List<TUser> selectListByCondition(Map<String, Object> paramMap);

    List<TUser> selectCountByCondition(Map<String, Object> paramMap);

    TUser selectByBusinessCode(Map<String, Object> name);

    int updateByBusinessCode(TUser record);
}