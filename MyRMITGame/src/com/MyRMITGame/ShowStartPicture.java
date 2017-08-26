package com.MyRMITGame;



public class ShowStartPicture implements Runnable{

	
private	int showstartpicture=0;
private boolean change=false;
	
	ShowStartPicture(int showstartpicture,boolean change){
		
		this.showstartpicture=showstartpicture;
		this.change = change;
		
		}
	
	public int getShowStartPicture(){
		
		return showstartpicture;
		
	}
	
	public void  setShowStartPicture(int showstartpicture){
		
		this.showstartpicture=showstartpicture;
		
		}
	
	public boolean getChange(){
		
		return change;
		
	}
	
	
	public void setChange(boolean change){
		
		this.change=change;
		
	}
	
	

	@Override
	public void run() {
		
		while(true){
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			  if(showstartpicture==1 && change==false){
				
				change=true;
			
		      }else if(showstartpicture==0){
				
				break;
				
				
			}
		  }
		}
	}
		

	
	
