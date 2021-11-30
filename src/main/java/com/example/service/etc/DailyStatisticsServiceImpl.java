package com.example.service.etc;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.etc.DailyStatisticsDao;
import com.example.vo.etc.DailyStatisticsVO;


@Service("dailyService")
public class DailyStatisticsServiceImpl implements DailyStatisticsService {

	@Autowired
	private DailyStatisticsDao dailyDao;
	
	@Override
	public DailyStatisticsVO retrieve(int dailyNo) {
		return this.dailyDao.selectDaily(dailyNo);
	}

	@Override
	public List<DailyStatisticsVO> retrieveList() {
		return this.dailyDao.selectList();
	}

	@Override
	public void registerDaily(DailyStatisticsVO dailyVo) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar calendar1 = Calendar.getInstance();
		
		String strToday = sdf.format(calendar1.getTime());
		
		this.dailyDao.insertDaily(dailyVo);

	}

	@Override
	public void modifyDaily(String dailyDate) {
		this.dailyDao.updateDaily(dailyDate);

	}

}
