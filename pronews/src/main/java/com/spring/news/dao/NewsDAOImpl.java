package com.spring.news.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.DataAccessException;

import com.spring.news.vo.NewsVO;

public class NewsDAOImpl implements NewsDAO{

	private SqlSession sqlSession;
	
	public void setSqlSession (SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List selectAllNewsList() throws DataAccessException {
		List<NewsVO> newssList = null;
		newssList = sqlSession.selectList("mapper.news.selectAllNewsList");
		return newssList;
	}
	
	@Override
	public int insertNews(NewsVO newsVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.news.insertNews",newsVO);
		return result;
	}
	
	@Override
	public int deleteNews(int aid) throws DataAccessException {
		int result = sqlSession.delete("mapper.news.deleteNews",aid);
		return result;
	}
	
	@Override
	public NewsVO selectNewsById(int aid) throws DataAccessException {
		NewsVO newsVO = (NewsVO) sqlSession.selectOne("mapper.news.selectNewsById", aid);
		return newsVO;
	}
	
	@Override
	public int updateNews(NewsVO newsVO) throws DataAccessException {
		int result = sqlSession.update("mapper.news.updateNews", newsVO);
		return result;
	}

}
