package study0604;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class TodayList {

	public static void main(String[] args) throws SQLException {
		Today today = new Today();
	}
}

class Today {
	//디비 접속 정보 
	Connection conn = null;
	String url = "jdbc:mysql://127.0.0.1:3306/study?useUnicode=true&characterEncoding=utf8";
	String id = "root";// ID
	String pass = "qwer";// 비밀번호	
	
	//디비 데이타 삽입용
	PreparedStatement pstmt = null;	
		
	//디비 조회용
	Statement stmt = null;
	ResultSet rs = null;
	
	Scanner sc = new Scanner(System.in);
	
	String input;
	int sel;
	int cnt=1;
			
	public Today() throws SQLException 
	{
		while(true)
		{
			this.main();
			
			if(sel == 1)
			{
				insert();
			}
			else if(sel == 2)
			{
				output();
			}
			else if(sel == 3)
			{
				System.out.println("프로그램 종료.");
				break;	
			}
		}
		
	}

	public void main() {
		
		System.out.println("1.오늘할일입력");
		System.out.println("2.기록보기");
		System.out.println("3.종료");
		System.out.print("선택:");
		sel = sc.nextInt();
		System.out.println();	
	}

	void insert() {
		
		System.out.print("입력: ");
		input = sc.next();
		System.out.println();
		
		String memo = input;

		try {
			//디비 연결
			conn = DriverManager.getConnection(url, id, pass);
			//삽입될때 쿼리문
			String query = "insert into today values (null, ?, NOW())";

			//쿼리문 수행
			pstmt = conn.prepareStatement(query);	
			
			//pstmt에 삽입될 변수값을 탑재
			pstmt.setString(1, memo);	
			pstmt.executeUpdate();
			
		} catch (SQLException e1) {			
		}	
		
	}
	
	void output() throws SQLException {

		String memo = input;
		
		try {
			//디비 연결
			conn = DriverManager.getConnection(url, id, pass);
			//디비에연결
			stmt = conn.createStatement();
			//디비에서 조회한 모든 데이타를 가져와서 rs에 저장
			rs = stmt.executeQuery("select * from today");
			
			while (rs.next()) {
				System.out.println(cnt+"번 "+rs.getString("date") + ":" + rs.getString("memo"));
				cnt++;
			}
			
			System.out.println();
			
		} catch (SQLException e1) {			
		}
		
		rs.close();
		
	}
}
	