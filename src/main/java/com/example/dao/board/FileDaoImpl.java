package com.example.dao.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.mapper.board.FileMapper;
import com.example.vo.board.FileVO;

@Repository("fileDao")
public class FileDaoImpl implements FileDao {

	@Autowired
	private FileMapper fileMapper;
	
	@Override
	public FileVO selectFile(int fileNo) {
		return fileMapper.selectFile(fileNo);
	}
	
	
	@Override
	public List<FileVO> selectFileList(int articleNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertFile(FileVO fileVO) {
		this.fileMapper.insertFile(fileVO);
	}

	@Override
	public void updateFile(FileVO file) {
		// TODO Auto-generated method stub

	}

}
