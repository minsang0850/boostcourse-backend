package org.edwith.webbe.guestbook.dao;

import org.edwith.webbe.guestbook.dto.Guestbook;
import org.edwith.webbe.guestbook.util.DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GuestbookDao {
    public List<Guestbook> getGuestbooks(){
        List<Guestbook> list = new ArrayList<>();
        DBUtil dbutil=new DBUtil();
        String sql="SELECT * FROM guestbook";
        try(Connection conn=dbutil.getConnection();
        		PreparedStatement ps = conn.prepareStatement(sql)){

    		try(ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					Long id=rs.getLong(1);
					String name=rs.getString(2);
					String content=rs.getString(3);
					Date regdate=rs.getDate(4);
					Guestbook guestbook=new Guestbook(id,name,content,regdate);
					list.add(guestbook);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
        return list;
    }

    public void addGuestbook(Guestbook guestbook){
    	String sql="INSERT INTO guestbook(id, name, content, regdate) VALUES (id, ?, ?, ?)";
    	String sql2="SELECT COUNT(*) FROM guestbook";
    	DBUtil dbutil=new DBUtil();
    	Long count=0L;
    	try(Connection conn = dbutil.getConnection();
    			PreparedStatement ps = conn.prepareStatement(sql2)){
    			ResultSet rs=null;
    			rs=ps.executeQuery();
    			count=rs.getLong(1);
    	}catch(Exception ex) {
			ex.printStackTrace();
		}
		try(Connection conn = dbutil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			java.util.Date date=new java.util.Date();
			java.sql.Date sqlDate=new java.sql.Date(date.getTime());
			guestbook.setId(count+1);
			//ps.setLong(1, guestbook.getId());
			ps.setString(1, guestbook.getName());
			ps.setString(2, guestbook.getContent());
			ps.setDate(3,sqlDate);
			ps.executeUpdate();
			ps.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
    }
}
