package com.jl.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jl.bean.UrlBean;
import com.jl.dao.impl.UrlDaoImpl;

@WebServlet("/CollectionServlet")
public class CollectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CollectionServlet() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("action");
		System.out.println(method);
		if(method!=null&&method.equals("save")){
			save(request, response);
		}else if(method!=null&&method.equals("list")){
			list(request, response);
		}else if(method!=null&&method.equals("get")){
			get(request, response);
		}else if(method!=null&&method.equals("update")){
			update(request, response);
		}else if(method!=null&&method.equals("delete")){
			delete(request, response);
		}else{
			
		}
	}
	
	
	protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String url = request.getParameter("url");
		UrlBean urlBean = new UrlBean();
		urlBean.setName(name);
		urlBean.setUrl(url);
		UrlDaoImpl urlDaoImpl = new UrlDaoImpl();
		urlDaoImpl.save(urlBean);
		List list = urlDaoImpl.list();
		request.setAttribute("list", list);
		request.getRequestDispatcher("Login.jsp").forward(request, response);
	}
	
	
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UrlDaoImpl urlDaoImpl = new UrlDaoImpl();
		List list = urlDaoImpl.list();
		request.setAttribute("list", list);
		request.getRequestDispatcher("Login.jsp").forward(request, response);
	}
	
	
	protected void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UrlDaoImpl urlDaoImpl = new UrlDaoImpl();
		int id = Integer.parseInt(request.getParameter("id"));
		UrlBean urlBean = urlDaoImpl.get(id);
		request.setAttribute("urlBean", urlBean);
		request.getRequestDispatcher("UrlEdit.jsp").forward(request, response);
	}
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UrlDaoImpl urlDaoImpl = new UrlDaoImpl();
	
		
		UrlBean urlBean = new UrlBean();
		urlBean.setId(Integer.parseInt(request.getParameter("id")));
		urlBean.setName(request.getParameter("name"));
		urlBean.setUrl(request.getParameter("url"));
		urlDaoImpl.update(urlBean);
		list(request, response);
	}
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] ids = request.getParameterValues("ids");
		UrlDaoImpl urlDaoImpl = new UrlDaoImpl();
		urlDaoImpl.delete(ids);
		list(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
