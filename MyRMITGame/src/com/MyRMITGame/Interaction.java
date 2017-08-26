package com.MyRMITGame;

public class Interaction implements Runnable {

	MyRole myRole=null;
	EnemyRole enemyRole =null;
	
	
	public Interaction(MyRole myRole, EnemyRole enemyRole){
		
		   this.myRole=myRole;
		
		   this.enemyRole=enemyRole;
		
	}
	
	
	
	public void enemyRoleDie(){
		
if(myRole.getMyShell()!=null  &&  myRole.getMyShell().getIsAlive()!=0 && enemyRole!=null){
		
if( myRole.getMyShell().getX()>=enemyRole.getX() &&
    myRole.getMyShell().getX()<=enemyRole.getX()+50 && 
    myRole.getMyShell().getY()>=enemyRole.getY() && 
    myRole.getMyShell().getY()<=enemyRole.getY()+50){
			
			
			myRole.getMyShell().setIsAlive(0);
			
			enemyRole.setIsAlive(0);
			
		}
		
	}
}	
	
	
	public void myRoleDie(){
		
	if(enemyRole!=null && enemyRole.getEnemyShell()!=null && enemyRole.getEnemyShell().getIsAlive()!=0 ){
		
	if( enemyRole.getEnemyShell().getX()>=myRole.getX() &&
	    enemyRole.getEnemyShell().getX()<=myRole.getX()+50 && 
	    enemyRole.getEnemyShell().getY()>=myRole.getY() && 
	    enemyRole.getEnemyShell().getY()<=myRole.getY()+50){
		
		enemyRole.getEnemyShell().setIsAlive(0);
						
			myRole.setIsAlive(0);
						
					}
					
		
	      }
		
	}



	@Override
	public void run(){

		while(true){
		
					try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(myRole.getIsAlive()==0 || enemyRole.getIsAlive()==0 || myRole==null || enemyRole==null)
				break;
			
			
           enemyRoleDie();
			myRoleDie();
			
			}
		
		}
	
	}
