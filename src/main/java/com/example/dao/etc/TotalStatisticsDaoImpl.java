package com.example.dao.etc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.mapper.etc.TotalStatisticsMapper;
import com.example.vo.etc.TotalStatisticsVO;

@Repository("totalDao")
public class TotalStatisticsDaoImpl implements TotalStatisticsDao {

	private TotalStatisticsMapper totalMapper;

	private TotalStatisticsVO totalVo;

	@Autowired
	public TotalStatisticsDaoImpl(TotalStatisticsMapper totalMapper) {
		this.totalMapper = totalMapper;
	}
	
	@Override
	public TotalStatisticsVO selectTotal() {
		return this.totalMapper.selectTotal();
	}

	@Override
	public void insertAndupdateTotal() {
		this.totalMapper.insertAndupdateTotal();

	}

}
