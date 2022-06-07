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
	//��� ���� ���� 
	Connection conn = null;
	String url = "jdbc:mysql://127.0.0.1:3306/study?useUnicode=true&characterEncoding=utf8";
	String id = "root";// ID
	String pass = "qwer";// ��й�ȣ	
	
	//��� ����Ÿ ���Կ�
	PreparedStatement pstmt = null;	
		
	//��� ��ȸ��
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
				System.out.println("���α׷� ����.");
				break;	
			}
		}
		
	}

	public void main() {
		
		System.out.println("1.���������Է�");
		System.out.println("2.��Ϻ���");
		System.out.println("3.����");
		System.out.print("����:");
		sel = sc.nextInt();
		System.out.println();	
	}

	void insert() {
		
		System.out.print("�Է�: ");
		input = sc.next();
		System.out.println();
		
		String memo = input;

		try {
			//��� ����
			conn = DriverManager.getConnection(url, id, pass);
			//���Եɶ� ������
			String query = "insert into today values (null, ?, NOW())";

			//������ ����
			pstmt = conn.prepareStatement(query);	
			
			//pstmt�� ���Ե� �������� ž��
			pstmt.setString(1, memo);	
			pstmt.executeUpdate();
			
		} catch (SQLException e1) {			
		}	
		
	}
	
	void output() throws SQLException {

		String memo = input;
		
		try {
			//��� ����
			conn = DriverManager.getConnection(url, id, pass);
			//��񿡿���
			stmt = conn.createStatement();
			//��񿡼� ��ȸ�� ��� ����Ÿ�� �����ͼ� rs�� ����
			rs = stmt.executeQuery("select * from today");
			
			while (rs.next()) {
				System.out.println(cnt+"�� "+rs.getString("date") + ":" + rs.getString("memo"));
				cnt++;
			}
			
			System.out.println();
			
		} catch (SQLException e1) {			
		}
		
		rs.close();
		
	}
}
	