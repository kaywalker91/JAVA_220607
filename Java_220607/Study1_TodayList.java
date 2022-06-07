package study0604;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Study1_TodayList {

	public static void main(String[] args) {
		Todays t = new Todays();

	}

}

class Todays{
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
	
	int input;
	
	Todays()
	{
		while(true)
		{
			System.out.println("1.���������Է�");
			System.out.println("2.��Ϻ���");
			System.out.println("3.����");
			System.out.print("����:");   input = sc.nextInt();
			
			if(input == 1) 		{  todayMemo();}
			else if(input == 2) {  showMemo();}
			else if(input == 3) {
				System.out.println("���α׷� ����!");
				break;			
			}
			
		}
	}
	void todayMemo()
	{
		//�������� ����
		String memo;
		System.out.print("�Է�:");   
		memo = sc.nextLine();
		memo = sc.nextLine();	
	
		
		// ���� ��¥,�ð�       
		//2022-06-07 11:32:49 ��� ���̺� ������ �����ϰ� ����
		LocalDateTime now = LocalDateTime.now();		 
		String today = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		System.out.println("����ð�:"+today); 

		insert(memo, today);
		
		
	}
	void showMemo()
	{
		
		
		
		//��񿡼� ������ �����ͼ� �ؽ�Ʈ���̸�� �ѷ��ֱ�				
				try {
					//��� ������ ���� conn���� ����
					conn = DriverManager.getConnection(url, id, pass);
					//��񿡿���
					stmt = conn.createStatement();
					//��񿡼� ��ȸ�� ��� ����Ÿ�� �����ͼ� rs�� ����
					String query= "select * from today";
					rs = stmt.executeQuery(query);
					//��񿡼� ��ȸ�� ��絥��Ÿ�� ����� r�� ���� ���پ� üũ�ؼ� ���������� �ݺ�
					
					int cnt=1;
					while (rs.next()) {
						//���پ� �ݺ��ϸ鼭 result.�� �����ؼ� ����
						//getString�� ���̺��� �÷��� �������� ����Ÿ�� �����ü� ����.
						System.out.println("--------"+ cnt+"�� �޸�------------");
						System.out.println("��¥ = " + rs.getString("date"));
						System.out.println("�޸� = " + rs.getString("memo"));
						System.out.println("--------------------------------");
						cnt++;
							
					}				
					
					rs.close();
				} catch (SQLException error) {
					System.err.println("error = " + error.toString());			
				}	
	}
	
	
	
	void insert(String memo, String today) {		
		
		try {
			//��� ����
			conn = DriverManager.getConnection(url, id, pass);
			//���Եɶ� ������
			String query = "insert into today values (null, ?, ?)";

			//������ ����
			pstmt = conn.prepareStatement(query);	
			
			//pstmt�� ���Ե� �������� ž��
			pstmt.setString(1, memo);
			pstmt.setString(2, today);		
			pstmt.executeUpdate();
		} catch (SQLException e1) {			
		}	

	}

}