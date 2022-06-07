package study0604;

import java.util.Scanner;

public class VendingMachine 
{

	public static void main(String[] args) 
	{
		Menu menu = new Menu();
	}

}

class Menu
{
	Scanner sc = new Scanner(System.in);
	
	String m1,m2,m3,m4,m5,m6,selm;
	int m1p,m2p,m3p,m4p,m5p,m6p;
	int currentmoney=0,inputmoney;
	int sel;
	
	Menu()
	{
		while(true)
		{
			mainmenu();
			
			if(sel == 1)
			{
				in();
			}
			else if(sel == 2)
			{
				out();
			}
			else if(sel == 3)
			{
				choice();
			}
			else if(sel == 4)
			{
				System.out.println("프로그램 종료.");
				break;	
			}
		}
	}
	
	void mainmenu()
	{
		System.out.println("1.메뉴입력");
		System.out.println("2.화면보기");
		System.out.println("3.메뉴선택");
		System.out.println("4.종료");
		System.out.print("선택:");
		sel = sc.nextInt();
		System.out.println();	
	}
	
	void in()
	{
		System.out.print("1번 메뉴: ");
		m1 = sc.next();
		System.out.print("1번 메뉴가격: ");
		m1p = sc.nextInt();
		System.out.print("2번 메뉴: ");
		m2 = sc.next();
		System.out.print("2번 메뉴가격: ");
		m2p = sc.nextInt();
		System.out.print("3번 메뉴: ");
		m3 = sc.next();
		System.out.print("3번 메뉴가격: ");
		m3p = sc.nextInt();
		System.out.print("4번 메뉴: ");
		m4 = sc.next();
		System.out.print("4번 메뉴가격: ");
		m4p = sc.nextInt();
		System.out.print("5번 메뉴: ");
		m5 = sc.next();
		System.out.print("5번 메뉴가격: ");
		m5p = sc.nextInt();
		System.out.print("6번 메뉴: ");
		m6 = sc.next();
		System.out.print("6번 메뉴가격: ");
		m6p = sc.nextInt();
		System.out.println();
	}
	
	void out()
	{
		System.out.println("1번메뉴: "+m1);
		System.out.println("가격: "+m1p);
		
		System.out.println("2번메뉴: "+m2);
		System.out.println("가격: "+m2p);
		
		System.out.println("3번메뉴: "+m3);
		System.out.println("가격: "+m3p);
		
		System.out.println("4번메뉴: "+m4);
		System.out.println("가격: "+m4p);
		
		System.out.println("5번메뉴: "+m5);
		System.out.println("가격: "+m5p);
		
		System.out.println("6번메뉴: "+m6);
		System.out.println("가격: "+m6p);
		System.out.println();	
	}
	
	void choice()
	{
		System.out.println("금액을 투입하세요.");
		
		System.out.print("투입금액: ");
		
		inputmoney = sc.nextInt();
		currentmoney += inputmoney;
		
		System.out.println("현재금액: " +currentmoney);
		
		System.out.println("메뉴를 선택하세요.");
		
		System.out.print("메뉴선택: ");
		selm = sc.next();
		
		if(selm.equals("1"))
		{
			currentmoney -= m1p;
			System.out.println("선택메뉴: "+m1);
			System.out.println("반환금액: " +currentmoney);
			System.out.println();	
		}
		else if(selm.equals("2"))
		{
			currentmoney -= m2p;
			System.out.println("선택메뉴: "+m2);
			System.out.println("반환금액: " +currentmoney);
			System.out.println();	
		}
		else if(selm.equals("3"))
		{
			currentmoney -= m3p;
			System.out.println("선택메뉴: "+m3);
			System.out.println("반환금액: " +currentmoney);
			System.out.println();	
		}
		else if(selm.equals("4"))
		{
			currentmoney -= m4p;
			System.out.println("선택메뉴: "+m4);
			System.out.println("반환금액: " +currentmoney);
			System.out.println();	
		}
		else if(selm.equals("5"))
		{
			currentmoney -= m5p;
			System.out.println("선택메뉴: "+m5);
			System.out.println("반환금액: " +currentmoney);
			System.out.println();	
		}
		else if(selm.equals("6"))
		{
			currentmoney -= m6p;
			System.out.println("선택메뉴: "+m6);
			System.out.println("반환금액: " +currentmoney);
			System.out.println();	
		}
		
		if(currentmoney<0)
		{
			System.out.println("금액이 부족합니다!");
			System.out.println("부족한 금액: " +(-currentmoney));
			currentmoney = 0;
			System.out.println();	
		}
	}
}
