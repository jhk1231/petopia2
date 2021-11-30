package com.example.dao.etc;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.mapper.etc.DailyStatisticsMapper;
import com.example.vo.etc.DailyStatisticsVO;

@Repository("dailyDao")
public class DailyStatisticsDaoImpl implements DailyStatisticsDao {

	private DailyStatisticsMapper dailyMapper;

	private DailyStatisticsVO dailyVo;

	@Autowired
	public DailyStatisticsDaoImpl(DailyStatisticsMapper dailyMapper) {
		this.dailyMapper = dailyMapper;
	}

	@Override
	public DailyStatisticsVO selectDaily() {
		dailyVo = dailyMapper.selectDaily();
		dailyVo.setDailyDate((dailyVo.getDailyDate().split(" ")[0]));
		return dailyVo;
	}

	@Override
	public ArrayList<DailyStatisticsVO> selectList() {
		ArrayList<DailyStatisticsVO> dailyVo = dailyMapper.selectList();
		for (DailyStatisticsVO dailyStatisticsVO : dailyVo) {
			dailyStatisticsVO.setDailyDate((dailyStatisticsVO.getDailyDate().split(" ")[0]));

		}
		return dailyVo;
	}

	@Override
	public void insertAndupdateDaily() {
		this.dailyMapper.insertAndupdateDaily();

	}

}
