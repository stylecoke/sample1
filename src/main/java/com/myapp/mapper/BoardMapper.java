package com.myapp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.myapp.vo.BoardVO;

@Mapper
public interface BoardMapper {
	
	public List<BoardVO> list();
	
	public int delete(BoardVO boardVO);
	
	public int update(BoardVO boardVO);
	
	public void insert(BoardVO boardVO);
	
	public BoardVO select(int seq);
	
	public int updateCount(int seq);
	
}
