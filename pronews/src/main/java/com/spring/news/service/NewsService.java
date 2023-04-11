package com.spring.news.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.news.vo.NewsVO;

public interface NewsService {

	public List listNews() throws DataAccessException;
	public int addNews(NewsVO newsVO) throws DataAccessException;
	public int removeNews(int aid) throws DataAccessException;
	public NewsVO modNews(int aid) throws DataAccessException;
	public int updateNews(NewsVO newsVO) throws DataAccessException;
}
