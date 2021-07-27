package org.edwith.webbe.guestbook.servlet;

import org.edwith.webbe.guestbook.dao.GuestbookDao;
import org.edwith.webbe.guestbook.dto.Guestbook;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/guestbooks")
public class GuestbookListServlet extends HttpServlet {

	public GuestbookListServlet() {
		super();
	}
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8");
    	GuestbookDao guestbookdao=new GuestbookDao();
    	List<Guestbook> list=guestbookdao.getGuestbooks();
		PrintWriter out = response.getWriter();
		for(int i=0; i<list.size(); i++) {
			out.print("id:");
			out.print(list.get(i).getId()+"<br>");
			out.print("name:");
			out.print(list.get(i).getName()+"<br>");
			//out.print("");
			out.print(list.get(i).getContent()+"<br>");
			out.print("regdate:");
			out.print(list.get(i).getRegdate()+"<br>");
			out.print("<br>");
		}
		out.print("이름:"+"<input type=\"text\" id=\"name\"/><br>");
		out.print("내용:"+"<textarea name=\"content\" cols=\"50\" rows=\"5\"></textarea><br>");
		out.print("<input type=\"submit\" value=\"확인\">");
		
		/*
		out.print("<div class=\"guestbooks\">\r\n" + 
				"            <c:forEach var=\"guestbook\" items=\"${list}\">\r\n" + 
				"                <div class=\"guestbook\">\r\n" + 
				"                    <div> <label>id : </label> ${guestbook.id}</div>\r\n" + 
				"                    <div> <label>name : </label> ${guestbook.name}</div>\r\n" + 
				"                    <div> <p>${guestbook.content}</p></div>\r\n" + 
				"                    <div> <label>regdate : </label> ${guestbook.regdate}</div>\r\n" + 
				"                </div>\r\n" + 
				"            </c:forEach>\r\n" + 
				"        </div>\r\n" + 
				"\r\n" + 
				"        <br><br><br>\r\n" + 
				"\r\n" + 
				"        <form method=\"post\" action=\"guestbooks/write\">\r\n" + 
				"            이름 : <input type=\"text\" name=\"name\"><br>\r\n" + 
				"            내용 :\r\n" + 
				"            <textarea name=\"content\" cols=\"50\" rows=\"5\"></textarea><br>\r\n" + 
				"            <input type=\"submit\" value=\"확인\">\r\n" + 
				"        </form>");
		*/
		out.close();
    }

}
