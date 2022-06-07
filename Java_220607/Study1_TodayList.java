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
	
	int input;
	
	Todays()
	{
		while(true)
		{
			System.out.println("1.오늘할일입력");
			System.out.println("2.기록보기");
			System.out.println("3.종료");
			System.out.print("선택:");   input = sc.nextInt();
			
			if(input == 1) 		{  todayMemo();}
			else if(input == 2) {  showMemo();}
			else if(input == 3) {
				System.out.println("프로그램 종료!");
				break;			
			}
			
		}
	}
	void todayMemo()
	{
		//오늘할일 내용
		String memo;
		System.out.print("입력:");   
		memo = sc.nextLine();
		memo = sc.nextLine();	
	
		
		// 현재 날짜,시간       
		//2022-06-07 11:32:49 디비 테이블에 삽입이 원할하게 맞춤
		LocalDateTime now = LocalDateTime.now();		 
		String today = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		System.out.println("현재시간:"+today); 

		insert(memo, today);
		
		
	}
	void showMemo()
	{
		
		
		
		//디비에서 정보를 가져와서 텍스트에이리어에 뿌려주기				
				try {
					//디비 접속을 위한 conn변수 생성
					conn = DriverManager.getConnection(url, id, pass);
					//디비에연결
					stmt = conn.createStatement();
					//디비에서 조회한 모든 데이타를 가져와서 rs에 저장
					String query= "select * from today";
					rs = stmt.executeQuery(query);
					//디비에서 조회한 모든데이타가 저장된 r의 값을 한줄씩 체크해서 없을때까지 반복
					
					int cnt=1;
					while (rs.next()) {
						//한줄씩 반복하면서 result.에 누적해서 저장
						//getString은 테이블의 컬럼명 기준으로 데이타를 가져올수 있음.
						System.out.println("--------"+ cnt+"번 메모------------");
						System.out.println("날짜 = " + rs.getString("date"));
						System.out.println("메모 = " + rs.getString("memo"));
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
			//디비 연결
			conn = DriverManager.getConnection(url, id, pass);
			//삽입될때 쿼리문
			String query = "insert into today values (null, ?, ?)";

			//쿼리문 수행
			pstmt = conn.prepareStatement(query);	
			
			//pstmt에 삽입될 변수값을 탑재
			pstmt.setString(1, memo);
			pstmt.setString(2, today);		
			pstmt.executeUpdate();
		} catch (SQLException e1) {			
		}	

	}

}