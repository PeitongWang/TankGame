package com.MyRMITGame;


import java.util.ArrayList;
import java.util.Random;

public class AddEnemyRole implements Runnable{

	
	 int[] xArray  = new int[]{100,300,500,700};
	 
	 int[] randomDirect = new int[]{0,1,2,3};
	
	 EnemyRole enemyRole=null;
	
	 ArrayList<EnemyRole> arr = new ArrayList<EnemyRole>();
	
	
	@Override
	public void run() {
		
		
		
		Random random = new Random();
	
		
		
		while(true){
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			if(arr.size()<4){
				
			int ranNum1=random.nextInt(4);
			
			enemyRole = new EnemyRole(xArray[ranNum1],21,3,2,1,1,new ShowShot(0));
			
			
			arr.add(enemyRole);
			Thread thr1 = new Thread(enemyRole);
			thr1.start();
			
			Thread thr2=new Thread(enemyRole.getShowShot());	
			thr2.start();
			
			}
			
			
		}
	}
 }
