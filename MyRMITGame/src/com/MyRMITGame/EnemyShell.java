package com.MyRMITGame;

public class EnemyShell extends Shell implements Runnable {



	
	public EnemyShell(int x, int y, int shelldirect, int speed, int isAlive) {
		
		
		super(x, y, shelldirect, speed, isAlive);
		
	}

	@Override
	public void run() {
		
		while(true){
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			if(this.getX()+40<0 || this.getX()>900 || this.getY()+40<0 || this.getY()>900)	{
				
				  this.setIsAlive(0);
			
				  break;
			}
			
			
			
			   if(this.getShellDirect()==0){
				
				this.setY(this.getY()-this.getSpeed());
				
				}else if(this.getShellDirect()==1){
					
				this.setX(this.getX()-this.getSpeed());
					
			    }else if(this.getShellDirect()==2){
				 
				 this.setX(this.getX()+this.getSpeed());
				 
				 
			    }else if(this.getShellDirect()==3){
				 
				 
				this.setY(this.getY()+this.getSpeed());
				 
				 
			    }else if(this.getIsAlive()==0){
				 
				 

				 
			 }
			
			
		}
		
	}
	
}
