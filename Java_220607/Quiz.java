package study0604;

import java.util.Scanner;

public class Quiz {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String id1=null, id2 = null;
		String passwd1=null, passwd2=null;
		int num=0;
		boolean run = true;
		
		while(run) {
			System.out.println("1.�α���");
			System.out.println("2.ȸ������");
			System.out.println("3.������");
			System.out.println("---------------");
			num = sc.nextInt();
			if(num==1) {
				if(id1==null&&passwd1==null) {
					System.out.println("ȸ�����Ժ��� ���ּ���.");
					continue;
				}
				System.out.print("���̵�: ");
				id2=sc.next();
				System.out.print("��й�ȣ: ");
				passwd2=sc.next();
				if(id1.equals(id2)&&passwd1.equals(passwd2)) {
					System.out.println("�α��μ���!");
				}else {
					System.out.println("�ٽ��Է����ּ���.");
				}
			}else if(num==2) {
				System.out.print("���̵�: ");
				id1=sc.next();
				System.out.print("��й�ȣ: ");
				passwd1=sc.next();
				System.out.println("ȸ������ ����!");
			}else if(num==3) {
				run=false;
				System.out.println("���α׷� ����!!");
			}
		}
		
	}

}