package com.example.dao.etc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.mapper.etc.DailyStatisticsMapper;
import com.example.vo.etc.DailyStatisticsVO;


@Repository("dailyDao")
public class DailyStatisticsDaoImpl implements DailyStatisticsDao {

	private DailyStatisticsMapper dailyMapper;
	
	@Autowired
	public DailyStatisticsDaoImpl(DailyStatisticsMapper dailyMapper) {
		this.dailyMapper = dailyMapper;
	}
	
	@Override
	public DailyStatisticsVO selectDaily(int dailyNo) {
		return this.dailyMapper.selectDaily(dailyNo);
	}

	@Override
	public List<DailyStatisticsVO> selectList() {
		return this.dailyMapper.selectList();
	}

	@Override
	public void insertDaily(DailyStatisticsVO dailyVo) {
		this.dailyMapper.insertDaily(dailyVo);

	}

	@Override
	public void updateDaily(String dailyDate) {
		this.dailyMapper.updateDaily(dailyDate);

	}

}
