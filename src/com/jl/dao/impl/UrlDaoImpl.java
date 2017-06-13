package com.jl.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jl.bean.UrlBean;
import com.jl.dao.UrlDao;
import com.jl.utils.DbUtil;




public class UrlDaoImpl implements UrlDao{

	@Override
	public void update(UrlBean urlBean) {
		DbUtil dbutil= new DbUtil();
		Connection conn = dbutil.getConnection();
		String sql = "update urltbl set name = ?,url=?where id = ?";
		try {
			PreparedStatement  pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, urlBean.getName());
			pstmt.setString(2, urlBean.getUrl());
			pstmt.setInt(3,urlBean.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dbutil.close(conn);
		}
		
	}

	@Override
	public void delete(String[] s) {
		DbUtil dbutil= new DbUtil();
		Connection conn = dbutil.getConnection();
		String sql = "delete from urltbl where id=?";
		try {
			PreparedStatement  pstmt = conn.prepareStatement(sql);
			for(int i=0;i<s.length;i++){
				int id = Integer.parseInt(s[i]);
				pstmt.setInt(1, id);
				pstmt.executeUpdate();
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dbutil.close(conn);
		}
		
	}

	@Override
	public void save(UrlBean urlBean) {
		DbUtil dbUtil = new DbUtil();
		Connection conn = dbUtil.getConnection();
		String sql="insert into urltbl(name,url) values (?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, urlBean.getName());
			pstmt.setString(2, urlBean.getUrl());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dbUtil.close(conn);
		}
	

		
		
	}

	@Override
	public List list() {
		DbUtil dbUtil = new DbUtil();
		
		
		Connection conn = dbUtil.getConnection();
		String sql="select id,name,url from urltbl";
		List list = new ArrayList();
		try {
			Statement stmt=conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()){
			int id = rs.getInt(1);
			String name = rs.getString(2);
			String url = rs.getString(3);
			UrlBean  urlBean = new UrlBean();
			urlBean.setId(id);
			urlBean.setName(name);
			urlBean.setUrl(url);
			list.add(urlBean);
			
		}
		return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
				dbUtil.close(conn);
		}
		
		
		return null;
	}

	@Override
	public UrlBean get(int id) {
		DbUtil dbUtil = new DbUtil();
		
		
		Connection conn = dbUtil.getConnection();
		String sql="select id,name,url from urltbl where id=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, id);
				ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			
			String name = rs.getString(2);
			String url = rs.getString(3);
			UrlBean  urlBean = new UrlBean();
			urlBean.setId(id);
			urlBean.setName(name);
			urlBean.setUrl(url);
			return urlBean;
			
		}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
				dbUtil.close(conn);
		}
		return null;
	}



}
