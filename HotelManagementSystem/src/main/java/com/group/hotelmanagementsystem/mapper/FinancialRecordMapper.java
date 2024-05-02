package com.group.hotelmanagementsystem.mapper;

import com.group.hotelmanagementsystem.entity.FinancialRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FinancialRecordMapper {
    int deleteByPrimaryKey(Integer financialRecordID);

    int insert(FinancialRecord record);

    int insertSelective(FinancialRecord record);

    FinancialRecord selectByPrimaryKey(Integer financialRecordID);

    int updateByPrimaryKeySelective(FinancialRecord record);

    int updateByPrimaryKey(FinancialRecord record);

    List<FinancialRecord> selectAll();

    int alterTable();
}