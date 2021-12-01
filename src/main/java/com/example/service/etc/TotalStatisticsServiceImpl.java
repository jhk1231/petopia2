package com.example.service.etc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.etc.TotalStatisticsDaoImpl;
import com.example.vo.etc.TotalStatisticsVO;


@Service("totalService")
public class TotalStatisticsServiceImpl implements TotalStatisticsService {

	@Autowired
	private TotalStatisticsDaoImpl totalDaoImpl;
	
	@Override
	public TotalStatisticsVO retrieve() {
		return this.totalDaoImpl.selectTotal();
	}

	@Override
	public void registerAndmodifyTotal() {
		this.totalDaoImpl.insertAndupdateTotal();

	}

}
