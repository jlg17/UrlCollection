package com.jl.dao;

import java.util.List;

import com.jl.bean.UrlBean;

public interface UrlDao {
	public void update(UrlBean urlBean);
	public void delete(String[] s);
	public void save(UrlBean urlBean);
	public List list();
	public UrlBean get(int id);
}
