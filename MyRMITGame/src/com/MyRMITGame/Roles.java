package com.MyRMITGame;

import java.io.Serializable;

public class Roles implements Serializable {

 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
private int x=0;
 private int y=0;
 private int direct=0;
 private int speed=0;
 private int  move=0;
 private int isAlive=0;
 private ShowShot showShot=null;
 
	
 Roles(int x, int y,int direct,int speed,int move, int isAlive, ShowShot showShot){
		
		this.x=x;
		this.y=y;
		this.direct=direct;
		this.speed=speed;
		this.move=move;
		this.isAlive=isAlive;
		this.showShot=showShot;
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
	
	
	public int getDirect(){
		
		return direct;
	}
	
	public void setDirect(int direct){
		
		this.direct=direct;
		
	}
	
	public int getSpeed(){
		
		return speed;
		
	}
	
	
    public void setSpeed(int speed){
	
	this.speed=speed;
	
}
	
	public int getMove(){
		
		return move;
		
		
	}
	

	public void setMove(int move){
		
		this.move=move;
		
	}
	
	
	public void setIsAlive(int isAlive){
		
		
		this.isAlive=isAlive;
		
		
	}
	
	
	public int getIsAlive(){
		
		
		return isAlive;
		
		
		
	}
	
	
	
	public ShowShot getShowShot(){
		
		return showShot;
		
	}
	
	
	
	public void setShowShot(ShowShot showShot){
		
		this.showShot=showShot;
		
	}
	
	
	
	
	
}
