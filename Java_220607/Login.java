package study0604;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Login {

	public static void main(String[] args) {
		Login1 g = new Login1();
	}
}

class Login1 extends Frame implements ActionListener{
	//화면중앙배치용 변수 
	Dimension dimen, dimen1;  int xpos, ypos;
	
	//init용 화면 구현 레이아웃 변수들...
	Label lbTitle = new Label("로그인화면");
	Label lbId = new Label("아이디: ");	
	Label lbPw = new Label("패스워드: ");	
	
	TextField tfNum1 = new TextField(15);
	TextField tfNum2 = new TextField(15);
	
	Button btnlogin = new Button("로그인");
	Button btnregi = new Button("회원가입");
	
	//로또처리용변수
	int myNumber[] = new int[6];  //내가 입력한 숫자가 기록.
	int comNumber[] = new int[6];  //로또당첨번호
	
	Login1()
	{
		init();//화면구성		
		center();//중앙배치
		start();//이벤트
	}
	void center()
	{
		dimen = Toolkit.getDefaultToolkit().getScreenSize();
		dimen1 = this.getSize();
		xpos = (int) (dimen.getWidth() / 2 - dimen1.getWidth() / 2);
		ypos = (int) (dimen.getHeight() / 2 - dimen1.getHeight() / 2);
		this.setLocation(xpos, ypos);
	}
	void init()
	{
		this.setSize(500, 500);	
		this.setVisible(true);
		
		this.setLayout(null);
		
		Font font30 = new Font("SansSerif", Font.BOLD, 30);
		Font font20 = new Font("SansSerif", Font.BOLD, 20);
		Font font15 = new Font("SansSerif", Font.BOLD, 15);
		Font font10 = new Font("SansSerif", Font.BOLD, 10);
		
		//타이틀
		this.add(lbTitle);
		lbTitle.setBounds(170, 60, 300, 30);		
		lbTitle.setFont(font30);
		
		this.add(lbId);
		lbId.setBounds(100, 150, 100, 40);		
		lbId.setFont(font20);
		
		this.add(lbPw);
		lbPw.setBounds(100, 200, 100, 40);		
		lbPw.setFont(font20);
		
		this.add(tfNum1);
		tfNum1.setBounds(200, 150, 150, 40);		
		tfNum1.setFont(font15);
		
		this.add(tfNum2);
		tfNum2.setBounds(200, 200, 150, 40);		
		tfNum2.setFont(font15);
		
		this.add(btnlogin);
		btnlogin.setBounds(170, 300, 150, 50);		
		btnlogin.setFont(font15);
		this.add(btnregi);
		btnregi.setBounds(170, 370, 150, 50);		
		btnregi.setFont(font15);
		
	}
	void start()
	{
		btnlogin.addActionListener(this);
		btnregi.addActionListener(this);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btnregi)
		{
			Frame f = new Frame();
			f.setSize(500, 700);
			//가로,세로 500,700 사이즈의 윈도우창을 생성하는 코드
			
			f.setLayout(null);	
			
			Font font30 = new Font("SansSerif", Font.BOLD, 30);
			Font font20 = new Font("SansSerif", Font.BOLD, 20);
			Font font15 = new Font("SansSerif", Font.BOLD, 15);
			Font font10 = new Font("SansSerif", Font.BOLD, 10);
			
			Label lbTitle1 = new Label("회원가입화면");
			Label lbId1 = new Label("아이디");
			Label lbPw1 = new Label("패스워드");
			Label lbPwc1 = new Label("패스워드확인");
			Label lbName = new Label("이름");
			Label lbPhone = new Label("휴대전화");
			Label lbAddr = new Label("주소");
			TextField tfId1 = new TextField(15);
			TextField tfPw1 = new TextField(15);
			TextField tfPwc1 = new TextField(15);
			TextField tfName = new TextField(15);
			TextField tfPhone = new TextField(15);
			TextField tfAddr = new TextField(15);
			Button bt = new Button("가입하기");
			
			f.add(lbTitle1);
			lbTitle1.setBounds(150, 60, 300, 30);		
			lbTitle1.setFont(font30);
			
			f.add(lbId1);
			lbId1.setBounds(100, 120, 100, 30);		
			lbId1.setFont(font15);
			
			f.add(tfId1);
			tfId1.setBounds(100, 160, 200, 30);		
			tfId1.setFont(font15);
			
			f.add(lbPw1);
			lbPw1.setBounds(100, 200, 100, 30);		
			lbPw1.setFont(font15);
			
			f.add(tfPw1);
			tfPw1.setBounds(100, 240, 200, 30);		
			tfPw1.setFont(font15);
			
			f.add(lbPwc1);
			lbPwc1.setBounds(100, 280, 100, 30);		
			lbPwc1.setFont(font15);
			
			f.add(tfPwc1);
			tfPwc1.setBounds(100, 320, 200, 30);		
			tfPwc1.setFont(font15);
			
			f.add(lbName);
			lbName.setBounds(100, 360, 100, 30);		
			lbName.setFont(font15);
			
			f.add(tfName);
			tfName.setBounds(100, 400, 200, 30);		
			tfName.setFont(font15);
			
			f.add(lbPhone);
			lbPhone.setBounds(100, 440, 100, 30);		
			lbPhone.setFont(font15);
			
			f.add(tfPhone);
			tfPhone.setBounds(100, 480, 200, 30);		
			tfPhone.setFont(font15);
			
			f.add(lbAddr);
			lbAddr.setBounds(100, 520, 100, 30);		
			lbAddr.setFont(font15);
			
			f.add(tfAddr);
			tfAddr.setBounds(100, 560, 200, 30);		
			tfAddr.setFont(font15);
			
			f.add(bt);
			bt.setBounds(170, 600, 150, 50);		
			bt.setFont(font15);
			
			bt.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					f.setVisible(false);
				}
			});
			
			f.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					f.setVisible(false);
				}
			});
			
			f.setLocation(xpos+60, 550);
			f.setVisible(true);//화면에 윈도우창을 보여주는 코드
			
		}
		
		if(e.getSource()==btnlogin)
		{
			Frame f = new Frame();
			f.setSize(500, 500);
			//가로,세로 500,700 사이즈의 윈도우창을 생성하는 코드
			
			f.setLayout(null);	
			
			Font font30 = new Font("SansSerif", Font.BOLD, 30);
			Font font20 = new Font("SansSerif", Font.BOLD, 20);
			Font font15 = new Font("SansSerif", Font.BOLD, 15);
			Font font10 = new Font("SansSerif", Font.BOLD, 10);
			
			Label lbTitle1 = new Label("메인화면");
			
			Button bt1 = new Button("회원가입하기");
			Button bt2 = new Button("회원전체보기");
			Button bt3 = new Button("회원수정하기");
			Button bt4 = new Button("회원삭제하기");
			
			f.add(lbTitle1);
			lbTitle1.setBounds(150, 60, 300, 30);		
			lbTitle1.setFont(font30);
			
			f.add(bt1);
			bt1.setBounds(150, 120, 150, 50);		
			bt1.setFont(font15);
			f.add(bt2);
			bt2.setBounds(150, 180, 150, 50);		
			bt2.setFont(font15);
			f.add(bt3);
			bt3.setBounds(150, 240, 150, 50);		
			bt3.setFont(font15);
			f.add(bt4);
			bt4.setBounds(150, 300, 150, 50);		
			bt4.setFont(font15);
			
			bt1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Frame f = new Frame();
					f.setSize(500, 700);
					//가로,세로 500,700 사이즈의 윈도우창을 생성하는 코드
					
					f.setLayout(null);	
					
					Font font30 = new Font("SansSerif", Font.BOLD, 30);
					Font font20 = new Font("SansSerif", Font.BOLD, 20);
					Font font15 = new Font("SansSerif", Font.BOLD, 15);
					Font font10 = new Font("SansSerif", Font.BOLD, 10);
					
					Label lbTitle1 = new Label("회원가입화면");
					Label lbId1 = new Label("아이디");
					Label lbPw1 = new Label("패스워드");
					Label lbPwc1 = new Label("패스워드확인");
					TextField tfId1 = new TextField(15);
					TextField tfPw1 = new TextField(15);
					TextField tfPwc1 = new TextField(15);
					Button bt = new Button("가입하기");
					
					f.add(lbTitle1);
					lbTitle1.setBounds(150, 60, 300, 30);		
					lbTitle1.setFont(font30);
					
					f.add(lbId1);
					lbId1.setBounds(100, 120, 100, 30);		
					lbId1.setFont(font15);
					
					f.add(tfId1);
					tfId1.setBounds(100, 160, 200, 30);		
					tfId1.setFont(font15);
					
					f.add(lbPw1);
					lbPw1.setBounds(100, 200, 100, 30);		
					lbPw1.setFont(font15);
					
					f.add(tfPw1);
					tfPw1.setBounds(100, 240, 200, 30);		
					tfPw1.setFont(font15);
					
					f.add(lbPwc1);
					lbPwc1.setBounds(100, 280, 100, 30);		
					lbPwc1.setFont(font15);
					
					f.add(tfPwc1);
					tfPwc1.setBounds(100, 320, 200, 30);		
					tfPwc1.setFont(font15);
					
					f.add(bt);
					bt.setBounds(170, 600, 150, 50);		
					bt.setFont(font15);
					
					bt.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							f.setVisible(false);
						}
					});
					
					f.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent e) {
							f.setVisible(false);
						}
					});
					
					f.setVisible(true);//화면에 윈도우창을 보여주는 코드
					
				}
			});
			
			bt2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Frame f = new Frame();
					f.setSize(500, 700);
					//가로,세로 500,700 사이즈의 윈도우창을 생성하는 코드
					
					f.setLayout(null);	
					
					Font font30 = new Font("SansSerif", Font.BOLD, 30);
					Font font20 = new Font("SansSerif", Font.BOLD, 20);
					Font font15 = new Font("SansSerif", Font.BOLD, 15);
					Font font10 = new Font("SansSerif", Font.BOLD, 10);
					
					Label lbTitle2 = new Label("회원전체화면");
					
					f.add(lbTitle2);
					lbTitle2.setBounds(150, 60, 300, 30);		
					lbTitle2.setFont(font30);
					
					f.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent e) {
							f.setVisible(false);
						}
					});
					
					f.setVisible(true);//화면에 윈도우창을 보여주는 코드
					
				}
			});
			
			bt3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Frame f = new Frame();
					f.setSize(500, 700);
					//가로,세로 500,700 사이즈의 윈도우창을 생성하는 코드
					
					f.setLayout(null);	
					
					Font font30 = new Font("SansSerif", Font.BOLD, 30);
					Font font20 = new Font("SansSerif", Font.BOLD, 20);
					Font font15 = new Font("SansSerif", Font.BOLD, 15);
					Font font10 = new Font("SansSerif", Font.BOLD, 10);
					
					Label lbTitle3 = new Label("회원수정하기");
					
					f.add(lbTitle3);
					lbTitle3.setBounds(150, 60, 300, 30);		
					lbTitle3.setFont(font30);
					
					f.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent e) {
							f.setVisible(false);
						}
					});
					
					f.setVisible(true);//화면에 윈도우창을 보여주는 코드
					
				}
			});
			
			bt4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Frame f = new Frame();
					f.setSize(500, 700);
					//가로,세로 500,700 사이즈의 윈도우창을 생성하는 코드
					
					f.setLayout(null);	
					
					Font font30 = new Font("SansSerif", Font.BOLD, 30);
					Font font20 = new Font("SansSerif", Font.BOLD, 20);
					Font font15 = new Font("SansSerif", Font.BOLD, 15);
					Font font10 = new Font("SansSerif", Font.BOLD, 10);
					
					Label lbTitle4 = new Label("회원삭제하기");
					
					f.add(lbTitle4);
					lbTitle4.setBounds(150, 60, 300, 30);		
					lbTitle4.setFont(font30);
					
					f.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent e) {
							f.setVisible(false);
						}
					});
					
					f.setVisible(true);//화면에 윈도우창을 보여주는 코드
					
				}
			});
			
			f.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					f.setVisible(false);
				}
			});
			
			f.setLocation(xpos+60, 550);
			f.setVisible(true);//화면에 윈도우창을 보여주는 코드
			
		}
	}
			
}
		
	


