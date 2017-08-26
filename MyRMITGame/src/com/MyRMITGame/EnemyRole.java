package com.MyRMITGame;


import java.util.ArrayList;
import java.util.Random;

public class EnemyRole extends Roles implements Runnable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1199821934149463115L;


	private EnemyShell enemyShell=null;
	
	ArrayList<EnemyShell> arr =new ArrayList<EnemyShell>(); 
	

	
	EnemyRole(int x, int y,int direct,int speed,int move,int isAlive, ShowShot showShot){
		
		super(x, y,direct,speed,move,isAlive,showShot);
		
		
   }
	
	public EnemyShell getEnemyShell(){
		
		return enemyShell;
		
	}
	
	
	public void fight(){
		
	switch(this.getDirect()){
	
case 0: 
	
    this.getShowShot().setShow(1);
    
	
	enemyShell=new EnemyShell(this.getX()+14, this.getY()-50,this.getDirect(),1,1);
	
	Thread thr1= new Thread(enemyShell);
	thr1.start();
	
	arr.add(enemyShell);
	
     break;
	
case 1:
	
	this.getShowShot().setShow(1);
	
	enemyShell=new EnemyShell(this.getX()-50, this.getY()+14,this.getDirect(),1,1);
	
   Thread thr2= new Thread(enemyShell);
	
   thr2.start();
	
	arr.add(enemyShell);
	
	break;
	
case 2:
	
	this.getShowShot().setShow(1);
	
	enemyShell=new EnemyShell(this.getX()+80, this.getY()+14,this.getDirect(),1,1);
	
	Thread thr3= new Thread(enemyShell);
	
	thr3.start();
	
	arr.add(enemyShell);
	
	break;
	
case 3:
	
	this.getShowShot().setShow(1);
	
	enemyShell=new EnemyShell(this.getX()+14, this.getY()+80,this.getDirect(),1,1);
	
	Thread thr4= new Thread(enemyShell);
	
	thr4.start();
	
	arr.add(enemyShell);
	
	break;
	
	}
		
}
	
	
	public void  moveUp(){
		  
		this.setY(this.getY()-this.getSpeed());  
		  
		 }
	
	
	
	
	public void  moveLeft(){
		  
	     this.setX(this.getX()-this.getSpeed());  
		  
		}
	
	
	
	public void moveRight(){
		
		
		this.setX(this.getX()+this.getSpeed());
		
		
	    }
	  
	
	
	
	
	public void moveDown(){
		
		
		this.setY(getY()+this.getSpeed());
		
		
	}
	
	
	
	
	@Override
	public void run() {
		
		Random ran = new Random();
	
		int randomDirect =ran.nextInt(4);
		int randomFight = ran.nextInt(100);
		
		
		while(true){
				
			
		try {
					Thread.sleep(60);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
			//System.out.println(this.getX()+" "+this.getY());
			 
	  	
			if(this.getIsAlive()==0)
				break;
			
			    
			this.setMove(1);
			this.setDirect(randomDirect);	
				
			
		 if(this.getY()<20 && this.getDirect()==0){
			
			
			this.setMove(0);
			
			randomDirect =ran.nextInt(4);
			
			this.setDirect(randomDirect);
			
		     continue;
			
			
		}else if(this.getX()<25 && this.getDirect()==1){
	        
			this.setMove(0);
			
			randomDirect =ran.nextInt(4);
			this.setDirect(randomDirect);
			continue;
			
			
		}else if(this.getX()>810 && this.getDirect()==2){
			
			this.setMove(0);
			
			randomDirect =ran.nextInt(4);
			this.setDirect(randomDirect);
			continue;
			
		}else if(this.getY()>700 && this.getDirect()==3){
			
			this.setMove(0);
			
			randomDirect =ran.nextInt(4);
			this.setDirect(randomDirect);
		    continue;
			
			
		}else if(this.getDirect()==0 && this.getMove()==1){
				
			       moveUp();
			   randomFight=ran.nextInt(30);
			   if(randomFight==1){
				fight();
				}
			
			
		}else if(this.getDirect()==1 && this.getMove()==1){
				
                   moveLeft();
				randomFight=ran.nextInt(30);
				if(randomFight==1){
					fight();
					}
				
		}else if(this.getDirect()==2 && this.getMove()==1){
				
			       moveRight();
				randomFight=ran.nextInt(30);
				if(randomFight==1){
					fight();
					}
				
				
		}else if(this.getDirect()==3 && this.getMove()==1){
				
		           moveDown();
				randomFight=ran.nextInt(30);
				if(randomFight==1){
					fight();
					}
				
		}else if(this.getMove()==0){
			
			    randomFight=ran.nextInt(30);
			    if(randomFight==1){
				    fight();
				    }
				 }
			 }
	      } 
	    }
