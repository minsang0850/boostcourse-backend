package org.edwith.webbe.guestbook.servlet;

import org.edwith.webbe.guestbook.dao.GuestbookDao;
import org.edwith.webbe.guestbook.dto.Guestbook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/guestbooks/write")
public class GuestbookWriteServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8");
    	String name=request.getParameter("name");
    	String content=request.getParameter("content");
    	Guestbook guestbook=new Guestbook(name,content);
    	GuestbookDao guestbookdao=new GuestbookDao();
    	guestbookdao.addGuestbook(guestbook);
    	/* 구글링으로 추가해준 코드 */
    	response.sendRedirect("http://localhost:8080/guestbook/guestbooks");
    	
    }

}
