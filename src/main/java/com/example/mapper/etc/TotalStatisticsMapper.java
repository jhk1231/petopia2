package com.example.mapper.etc;

import org.apache.ibatis.annotations.Mapper;

import com.example.vo.etc.TotalStatisticsVO;

@Mapper()
public interface TotalStatisticsMapper {

	TotalStatisticsVO selectTotal();

	void insertAndupdateTotal();
}
