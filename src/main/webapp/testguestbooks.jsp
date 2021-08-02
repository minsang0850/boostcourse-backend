<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="org.edwith.webbe.guestbook.dto.Guestbook" %>
<%@ page import="java.util.List" %>
<html>
    <head>
        <title>방명록</title>
        <style>
            .guestbooks {
                padding: 5px 0px 5px 5px;
                margin-bottom: 5px;
                border-bottom: 1px solid #efefef;
                font-size: 12px;
            }
        </style>
    </head>
    <body>
		
        <div class="guestbooks">
        <form method="get" action="http://localhost:8080/guestbook/guestbooks">
        <%
        List<Guestbook> list=(List<Guestbook>)request.getAttribute("list");
        %>
            <c:forEach var="guestbook" items="${list}">
                <div class="guestbook">
                    <div> <label>id : </label> ${guestbook.id}</div>
                    <div> <label>name : </label> ${guestbook.name}</div>
                    <div> <p>${guestbook.content}</p></div>
                    <div> <label>regdate : </label> ${guestbook.regdate}</div>
                </div>
            </c:forEach>
            </form>
        </div>

        <br><br><br>

        <form method="post" action="http://localhost:8080/guestbook/guestbooks/write">
            이름 : <input type="text" name="name"><br>
            내용 :
            <textarea name="content" cols="50" rows="5"></textarea><br>
            <input type="submit" value="확인">
        </form>
    </body>
</html>
