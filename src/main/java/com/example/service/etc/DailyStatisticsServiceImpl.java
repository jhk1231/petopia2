package com.example.service.etc;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.etc.DailyStatisticsDao;
import com.example.vo.etc.DailyStatisticsVO;


@Service("dailyService")
public class DailyStatisticsServiceImpl implements DailyStatisticsService {

	@Autowired
	private DailyStatisticsDao dailyDao;
	
	@Override
	public DailyStatisticsVO retrieve() {
		return this.dailyDao.selectDaily();
	}

	@Override
	public ArrayList<DailyStatisticsVO> retrieveList() {
		return this.dailyDao.selectList();
	}

	@Override
	public void registerAndmodifyDaily() {
		
		this.dailyDao.insertAndupdateDaily();

	}


}
