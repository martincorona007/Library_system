package Hilo;

import Formularios.Login;

public class Hilo extends Thread{
 int seg;
 //Thread tiempo=new Thread();
 	public void run() {
 		
			for(seg=15;seg<=100;seg++) {
				Login.progressBar.setValue(seg);
		try {
				Thread.sleep(50);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
 	}
}
}