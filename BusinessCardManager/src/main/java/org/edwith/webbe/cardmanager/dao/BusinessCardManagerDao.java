package org.edwith.webbe.cardmanager.dao;

import org.edwith.webbe.cardmanager.dto.BusinessCard;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BusinessCardManagerDao {
	private static String dburl = "jdbc:mysql://localhost:3306/connectdb?serverTimezone=Asia/Seoul&useSSL=false";
	private static String dbUser = "connectuser";
	private static String dbpasswd = "connect123!@#";
    public List<BusinessCard> searchBusinessCard(String keyword){
    	List<BusinessCard> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql="SELECT * FROM businesscard where name = '"+keyword+"'";
		System.out.println(sql);
		try(Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)){
			
			try(ResultSet rs = ps.executeQuery()){
				
				while(rs.next()) {
					String name=rs.getString(1);
					String phone=rs.getString(2);
					String companyName=rs.getString(3);
					Date createDate=rs.getDate(4);
					BusinessCard businesscard=new BusinessCard(name,phone,companyName);
					businesscard.setCreateDate(createDate);
					list.add(businesscard);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return list;
    }

    public BusinessCard addBusinessCard(BusinessCard businessCard){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql="INSERT INTO businesscard(name, phone, companyName, createDate) VALUES (?, ?, ?, ?)";
		
		try(Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)){
			java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
			businessCard.setCreateDate(sqlDate);
			ps.setString(1, businessCard.getName());
			ps.setString(2, businessCard.getPhone());
			ps.setString(3, businessCard.getCompanyName());
			ps.setDate(4, (Date) businessCard.getCreateDate());
			ps.executeUpdate();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return businessCard;
    }
}
