package JDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;



public class CreateDatabase {
	public void createcustomerTable(){
		JDBC c=new JDBC();
		Connection conn= c.getConnection();
		Statement stat=null;
		try {
			stat = conn.createStatement();
		
	      String sql = "CREATE TABLE customer ("+
	    		  "id varchar(20) not null primary key,"+
	    		  "name varchar(30),"+
	    		  "password varchar(30));";
	      
		stat.executeUpdate(sql);
		stat.close();
		conn.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("customer has been created");
		}
	}
	public void createdriverTable(){
		JDBC c=new JDBC();
		Connection conn= c.getConnection();
		Statement stat=null;
		try {
			stat = conn.createStatement();
		
	      String sql = "CREATE TABLE driver("+
	    		  "id varchar(20) not null primary key,"+
	    		  "name varchar(30),"+
	    		  "password varchar(30),"+
	    		  "receipt float,"+
	    		  "car_id varchar(50));";
	      
		stat.executeUpdate(sql);
		stat.close();
		conn.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("driver has been created");
		}
	}
	public void createRootUserTable(){
		JDBC c=new JDBC();
		Connection conn= c.getConnection();
		Statement stat=null;
		try {
			stat = conn.createStatement();
		
	      String sql = "CREATE TABLE RootUser("+
	    		  "id varchar(20) not null primary key,"+
	    		  "name varchar(30),"+
	    		  "password varchar(30),"+
	    		  "administrator varchar(50));";
	      
		stat.executeUpdate(sql);
		stat.close();
		conn.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("RootUser has been created");
		}
	}
	public void createtransactionTable(){
		JDBC c=new JDBC();
		Connection conn= c.getConnection();
		Statement stat=null;
		try {
			stat = conn.createStatement();
		
	      String sql = "CREATE TABLE Transaction (" + 
	      		"id varchar(20) not null primary key," + 
	      		"duration varchar(30)," + 
	      		"date Date," + 
	      		"Money float,"+
	      		"car_id varchar(100),"+
	      		"driver_id varchar(100),"+
	      		"state varchar(100),"+
	      		"customer_id varchar(20));";
	      
		stat.executeUpdate(sql);
		stat.close();
		conn.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("transaction has been created");
		}
	}
	
	public void createcarTable(){
		JDBC c=new JDBC();
		Connection conn= c.getConnection();
		Statement stat=null;
		try {
			stat = conn.createStatement();
		
	      String sql = "CREATE TABLE car(" + 
	      		"id varchar(20) not null primary key," + 
	      		"type varchar(30)," + 
	      		"seat varchar(30)," + 
	      		"per_hour float,"+
	      		"per_week float);";
	      
		stat.executeUpdate(sql);
		stat.close();
		conn.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("car has been created");
		}
	}
	
}
