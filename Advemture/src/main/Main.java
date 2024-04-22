package main;

import javax.swing.JFrame;

public class Main {
   public static void main(String[] args) {
	
	   JFrame window = new JFrame(); //tao 1 Frame moi
	   //thiet lap hanh dong mac dinh kho dong cua so
	   window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   window.setResizable(false);//khong cho phep thay doi kich thuoc cua cua so
	   window.setTitle("BoomGame");//title
	   
	   GamePanel gamePanel = new GamePanel();
	   window.add(gamePanel);
	   
	   window.pack();
	   
       window.setLocationRelativeTo(null);//dat vi tri cua so la o giua man hinh
       window.setVisible(true);//khong hien thi cua so ngay lap tuc
       
       gamePanel.setupGame();
       gamePanel.startGameThread();
       
}
}

