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
				System.out.println("���α׷� ����.");
				break;	
			}
		}
	}
	
	void mainmenu()
	{
		System.out.println("1.�޴��Է�");
		System.out.println("2.ȭ�麸��");
		System.out.println("3.�޴�����");
		System.out.println("4.����");
		System.out.print("����:");
		sel = sc.nextInt();
		System.out.println();	
	}
	
	void in()
	{
		System.out.print("1�� �޴�: ");
		m1 = sc.next();
		System.out.print("1�� �޴�����: ");
		m1p = sc.nextInt();
		System.out.print("2�� �޴�: ");
		m2 = sc.next();
		System.out.print("2�� �޴�����: ");
		m2p = sc.nextInt();
		System.out.print("3�� �޴�: ");
		m3 = sc.next();
		System.out.print("3�� �޴�����: ");
		m3p = sc.nextInt();
		System.out.print("4�� �޴�: ");
		m4 = sc.next();
		System.out.print("4�� �޴�����: ");
		m4p = sc.nextInt();
		System.out.print("5�� �޴�: ");
		m5 = sc.next();
		System.out.print("5�� �޴�����: ");
		m5p = sc.nextInt();
		System.out.print("6�� �޴�: ");
		m6 = sc.next();
		System.out.print("6�� �޴�����: ");
		m6p = sc.nextInt();
		System.out.println();
	}
	
	void out()
	{
		System.out.println("1���޴�: "+m1);
		System.out.println("����: "+m1p);
		
		System.out.println("2���޴�: "+m2);
		System.out.println("����: "+m2p);
		
		System.out.println("3���޴�: "+m3);
		System.out.println("����: "+m3p);
		
		System.out.println("4���޴�: "+m4);
		System.out.println("����: "+m4p);
		
		System.out.println("5���޴�: "+m5);
		System.out.println("����: "+m5p);
		
		System.out.println("6���޴�: "+m6);
		System.out.println("����: "+m6p);
		System.out.println();	
	}
	
	void choice()
	{
		System.out.println("�ݾ��� �����ϼ���.");
		
		System.out.print("���Աݾ�: ");
		
		inputmoney = sc.nextInt();
		currentmoney += inputmoney;
		
		System.out.println("����ݾ�: " +currentmoney);
		
		System.out.println("�޴��� �����ϼ���.");
		
		System.out.print("�޴�����: ");
		selm = sc.next();
		
		if(selm.equals("1"))
		{
			currentmoney -= m1p;
			System.out.println("���ø޴�: "+m1);
			System.out.println("��ȯ�ݾ�: " +currentmoney);
			System.out.println();	
		}
		else if(selm.equals("2"))
		{
			currentmoney -= m2p;
			System.out.println("���ø޴�: "+m2);
			System.out.println("��ȯ�ݾ�: " +currentmoney);
			System.out.println();	
		}
		else if(selm.equals("3"))
		{
			currentmoney -= m3p;
			System.out.println("���ø޴�: "+m3);
			System.out.println("��ȯ�ݾ�: " +currentmoney);
			System.out.println();	
		}
		else if(selm.equals("4"))
		{
			currentmoney -= m4p;
			System.out.println("���ø޴�: "+m4);
			System.out.println("��ȯ�ݾ�: " +currentmoney);
			System.out.println();	
		}
		else if(selm.equals("5"))
		{
			currentmoney -= m5p;
			System.out.println("���ø޴�: "+m5);
			System.out.println("��ȯ�ݾ�: " +currentmoney);
			System.out.println();	
		}
		else if(selm.equals("6"))
		{
			currentmoney -= m6p;
			System.out.println("���ø޴�: "+m6);
			System.out.println("��ȯ�ݾ�: " +currentmoney);
			System.out.println();	
		}
		
		if(currentmoney<0)
		{
			System.out.println("�ݾ��� �����մϴ�!");
			System.out.println("������ �ݾ�: " +(-currentmoney));
			currentmoney = 0;
			System.out.println();	
		}
	}
}
