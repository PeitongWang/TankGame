package com.MyRMITGame;



public class MyShell extends Shell implements Runnable{

	

	public MyShell(int x, int y, int shelldirect, int speed, int isAlive) {
		
		
		super(x, y, shelldirect, speed, isAlive);
		
	}
	

	@Override
	public void run() {
		
		while(true){
			
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
	if(this.getX()+40<0 || this.getX()>900 || this.getY()+40<0 || this.getY()>900)	{
			
			  this.setIsAlive(0);
		
			  break;
		}
			
			
			
			switch(this.getShellDirect()){
			
			case 0:
				
				this.setY(this.getY()-this.getSpeed());
				
				break;
				
			case 1:
				
			this.setX(this.getX()-this.getSpeed());
				
				break;
				
			case 2:
				
			this.setX(this.getX()+this.getSpeed());
				
				break;
				
			case 3:
			
			   this.setY(this.getY()+this.getSpeed());   
			    
			    break;
			
			
			}
			
		}
		
	}
}
