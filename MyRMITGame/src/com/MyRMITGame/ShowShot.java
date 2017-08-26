package com.MyRMITGame;



public class ShowShot implements Runnable{


	
	private int show=0;
	
	
	ShowShot(int show){
		
		this.show=show;
		
		
		
	}
	
	
	public int getShow(){
		
		return show;
		
		}
	
	

	public void setShow(int show){
		
		this.show = show;
		
	}
	
	
public void run() {
		
		
		while(true){
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(show==1){
				
		       show=0;	
			
			}else{
				
			continue;
				
			}
		}
	}
	
}
