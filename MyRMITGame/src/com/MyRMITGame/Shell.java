package com.MyRMITGame;



public class Shell{
	

private	int x=0;
private	int y=0;
private	int shelldirect=0;
private	int speed=0;
private	int isAlive=0;
	
	public Shell(int x, int y, int shelldirect, int speed, int isAlive){
		
		this.x=x;
		this.y=y;
		this.shelldirect=shelldirect;
		this.speed=speed;
		this.isAlive=isAlive;
		
		}
	
	
	public void setX(int x){
		
		this.x=x;
		
		
	}
	
	public int getX(){
		
		return x;
		
		}
	
	public void setY(int y){
		
		this.y=y;
		
	}
	
	public int getY(){
		
		return y;
		
	}
	
	
	public int getIsAlive(){
		
		
		return isAlive;
		
	
	}
	
	
	public void setIsAlive(int isAlive){
		
		
		this.isAlive=isAlive;
		
		
	}
	
	
public void setShellDirect(int shelldirect){
	
	this.shelldirect=shelldirect;
	
	
}
	
	
	public int getShellDirect(){
		
		
		return shelldirect;
	}

	
	public void setSpeed(int speed){
		
		this.speed=speed;
		
	}
	
	
	public int getSpeed(){
		
		return speed;
	}
	
	

}
	


