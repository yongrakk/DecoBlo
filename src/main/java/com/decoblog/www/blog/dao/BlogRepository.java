package com.decoblog.www.blog.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.decoblog.www.blog.vo.Menu;
import com.decoblog.www.user.vo.User;
import com.decoblog.www.blog.vo.Block;
import com.decoblog.www.blog.vo.BlockTemplate;

@Repository
public class BlogRepository {
	@Autowired
	SqlSession session;

	/**
	 * 전체 메뉴 가져오기
	 * @return DB에 등록된 메뉴
	 */
	public ArrayList<HashMap<String, ArrayList<Menu>>> selectMenu() {
		BlogMapper mapper = session.getMapper(BlogMapper.class);
		ArrayList<HashMap<String, ArrayList<Menu>>> result = mapper.selectMenu();
		return result;
	}
	
	/**
	 * 메뉴 타이틀 수정
	 * @return 성공 여부
	 */
	public int updateMenu(Menu menu) {
		BlogMapper mapper = session.getMapper(BlogMapper.class);
		int result = mapper.updateMenu(menu);
		
		return result;
	}
	
	/*
	 * 블록 썸네일 가져오기
	 * */
	public List<Integer> selectThumnail(String tmpType){
		BlogMapper mapper = session.getMapper(BlogMapper.class);
		List<Integer> blockNoList= mapper.selectThumnail(tmpType);
		return blockNoList;
	}
	
	/*블록 코드 가져오기*/
	public String selectBlockContent(int blockTemplateNo) {
		BlogMapper mapper = session.getMapper(BlogMapper.class);
		String blockContent = mapper.selectBlockContent(blockTemplateNo);
		return blockContent;
	}
	/*블록 가져오기 */
	public List<Block> selectBlockList(Menu menu){
		BlogMapper mapper = session.getMapper(BlogMapper.class);
		List<Block> blockList = mapper.selectBlockList(menu);
		return blockList;
	}
	/*블록 입력하기*/
	public int insertBlock(Block block) {
		BlogMapper mapper = session.getMapper(BlogMapper.class);
		int result = mapper.insertBlock(block);
		return result;
	}
	/*블록 Seq 한자리씩 미루기*/
	public int updateBlockSeq(int blockSeq) {
		BlogMapper mapper = session.getMapper(BlogMapper.class);
		int result = mapper.updateBlockSeq(blockSeq);
		return result;
	}
	/*블록 삭제*/
	public int deleteBlock(int blockSeq) {
		BlogMapper mapper = session.getMapper(BlogMapper.class);
		int result = mapper.deleteBlock(blockSeq);
		return result;
	}
}
