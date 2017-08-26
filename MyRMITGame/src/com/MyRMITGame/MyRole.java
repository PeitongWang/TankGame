package com.MyRMITGame;


import java.util.ArrayList;

public class MyRole extends Roles implements Runnable{

	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private MyShell myShell=null;

	
	 ArrayList<MyShell> arr= new ArrayList<MyShell>();
	
	MyRole(int x,int y, int direct, int speed, int move, int isAlive, ShowShot showShot){
		
		super(x,y,direct,speed,move,isAlive,showShot);
		
		}
	



	
	public Shell getMyShell(){
		
		return myShell;
		
	}
	
	
	
	public void fight(){
		
		  if(arr.size()<5){
		
		switch(this.getDirect()){    
		
	  case 0:
		   
	    	this.getShowShot().setShow(1);
	     
	    	myShell=new MyShell(this.getX()+14,this.getY()-85,this.getDirect(),2,1);
	    		   
	        arr.add(myShell);
	                  
	      break;
		    
	  case 1:
				
		 this.getShowShot().setShow(1);
		  
		 myShell=  new MyShell(this.getX()-88, this.getY()+14,this.getDirect(),2,1);
					
		 arr.add(myShell);
			
	      break;
		    
				    
	  case 2:
		  
		  this.getShowShot().setShow(1);
		
		 myShell= new	MyShell(this.getX()+103, this.getY()+14,this.getDirect(),2,1);
			  
		 arr.add(myShell);	  
				  
		  break;
		    
		
	  case 3:
		  
		this.getShowShot().setShow(1);
				
		myShell=new MyShell(this.getX()+14, this.getY()+100,this.getDirect(),2,1);
				
		arr.add(myShell);
				
		 break;
				       
		}
		
		
		 Thread thr1 = new Thread(myShell);
		          
	      thr1.start();
		
	}
	
}
	
	
	
	public void moveUp(){
		
		
		  this.setY(this.getY()-this.getSpeed());
		   
	}
	
	public void moveLeft(){
		
		
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
		
		
	while(true){
		
		
		
		
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
			if(this.getIsAlive()==0)
				break;	
			
			
			
   if(this.getY()<20 && this.getDirect()==0){
		
		
		this.setMove(0);
		
		continue;
		
		
	}else if(this.getX()<25 && this.getDirect()==1){
        
		this.setMove(0);
		
		continue;
		
		
	}else if(this.getX()>810 && this.getDirect()==2){
		
		this.setMove(0);
		
		continue;
		
	}else if(this.getY()>700 && this.getDirect()==3){
		
		this.setMove(0);
		
		continue;
		
		
	}else if(this.getDirect()==0 && this.getMove()==1){
			
			moveUp();
			
		
	}else if(this.getDirect()==1 && this.getMove()==1){
			
			moveLeft();
			
			
	}else if(this.getDirect()==2 && this.getMove()==1){
			
			moveRight();
			
			
			
	}else if(this.getDirect()==3 && this.getMove()==1){
			
			moveDown();
			
			
	}else if(this.getMove()==0){
			
			continue;
			
		}
		
		
	 }
		
  }
    
}
