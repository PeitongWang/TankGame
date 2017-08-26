package com.MyRMITGame;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;



public class MyPanel extends JPanel implements KeyListener, Runnable{



	
/**
	 * 
	 */
private static final long serialVersionUID = -2555776011832328084L;
Image img1,img2,img3,img4,img5,img6,img7,img8,img9,img10,img11,img12,img13,img14,img15,img16,img17,img18,img19,img20,img21,img22,img23,img24,img25,img26;
MyRole myRole=null; //Because of being in the Panel
EnemyRole enemyRole=null;
ShowStartPicture startpicture=null;
AddEnemyRole addEnemyRole=null;
Interaction interaction=null;	  

   public MyPanel(){
   
	
	img1= Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/images/rmit1.gif"));
    img2=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/images/TankTop1.png"));
	img3=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/images/TankTop2.png"));
	img4=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/images/shot0.png"));
	img5=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/images/shot1.png"));
	img6=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/images/shot2.png"));
	img7=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/images/shot3.png"));
	img8=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/images/shell0.png"));
	img9=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/images/shell1.png"));
	img10=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/images/shell2.png"));
	img11=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/images/shell3.png"));
	img12=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/images/shell4.png"));
	img13=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/images/startPicture1.jpg"));
	img14=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/images/startPicture.jpg"));
	img15=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/images/enemy0.png"));
	img16=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/images/enemy1.png"));
	img17=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/images/enemy2.png"));
	img18=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/images/enemy3.png"));
	img19=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/images/bomb1.png"));
	img20=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/images/bomb2.png"));
	img21=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/images/bomb3.png"));
	img22=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/images/bomb4.png"));
	img23=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/images/bomb5.png"));
	img24=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/images/shot4.png"));
	img25=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/images/backGroundPicture.jpg"));
	img26=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/images/rmit2.png"));
	
	this.addKeyListener(this);
	this.setSize(800,800);
	this.setFocusable(true);
	

	
     startpicture = new ShowStartPicture(1,false);
	
	 Thread thr = new Thread(startpicture);
	
	  thr.start();
	  
	  
	 myRole=new MyRole(112,690,0,4,0,1,new ShowShot(0));
		
	 Thread thr1 = new Thread(myRole);
		
	  thr1.start(); 
	  
	  Thread thr2 =new Thread(myRole.getShowShot());
	  
	  thr2.start();
	  
	  addEnemyRole = new AddEnemyRole();
	  
	  Thread thr3 = new Thread(addEnemyRole);
	  
	  thr3.start();
	  

	  
	  }
   


  public void paint(Graphics g){
	
	super.paint(g);
	
	
	
	switch(startpicture.getShowStartPicture()){
	
	case 1:
	
     drawStartPicture(g);
	
	break;
	
	case 0:
		
	g.drawImage(img25, 0, 200, 890, 400, this);
	
	g.drawImage(img1, 0, 300, 890, 200,this);
	
	g.drawImage(img26, 420, 700, 70, 70,this);
	
	drawMyRole(myRole,g);
			
	drawMyShell(myRole,g);
	
	drawMyShot(myRole,g);
	
	drawEnemyRole(addEnemyRole,enemyRole, g);
	
	break;
	
	}
	
	}
	


     public void drawStartPicture(Graphics g){
	
  if(startpicture.getShowStartPicture()==1 && startpicture.getChange()==false){
		
		 g.drawImage(img13, 0, 0, 890,820, this);
		
	  }else if(startpicture.getShowStartPicture()==1 && startpicture.getChange()==true){
		
		 g.drawImage(img14, 0, 0, 890,820, this);
		
		 }else if(startpicture.getShowStartPicture()==0){
			
			startpicture=null; 
	   }
	   
	   
	 }


public void drawMyRole(MyRole myRole ,Graphics g){
	
	if(myRole.getIsAlive()!=0){
	
	
	 g.setColor(Color.CYAN);
	    
	     switch(myRole.getDirect()){    
	
      case 0:
    	
    	
    		   
    		   g.fill3DRect(myRole.getX(),myRole.getY() , 10, 50, false);
    		   g.fill3DRect(myRole.getX()+10, myRole.getY()+5, 30, 40, true);
	           g.fill3DRect(myRole.getX()+40, myRole.getY(),10, 50, false);
	           g.drawImage(img2, myRole.getX()+14,myRole.getY()+15, 20, 20,this);
	           g.fill3DRect(myRole.getX()+23, myRole.getY()-20, 2, 37,true);
    	   
  
	                break;
	    
	  case 1:
			
		
			   g.fill3DRect(myRole.getX(),myRole.getY() , 50, 10, false);
			   g.fill3DRect(myRole.getX()+5, myRole.getY()+10, 40, 30, true);
			   g.fill3DRect(myRole.getX(), myRole.getY()+40,50, 10, false);
			   g.drawImage(img2, myRole.getX()+15,myRole.getY()+14, 20, 20,this);
			   g.fill3DRect(myRole.getX()-23, myRole.getY()+22, 40, 2,true);
			
			
				    break;
	    
			    
	  case 2:
			
			
			
		       g.fill3DRect(myRole.getX(),myRole.getY() , 50, 10, false);
			   g.fill3DRect(myRole.getX()+5, myRole.getY()+10, 40, 30, true);
			   g.fill3DRect(myRole.getX(), myRole.getY()+40,50, 10, false);
			   g.drawImage(img2, myRole.getX()+15,myRole.getY()+14, 20, 20,this);
			   g.fill3DRect(myRole.getX()+32, myRole.getY()+23, 40, 2,true);
			 
			    
                    break;
	    
			
			
	 case 3:
			
			  
			
			    g.fill3DRect(myRole.getX(),myRole.getY() , 10, 50, false);
			    g.fill3DRect(myRole.getX()+10, myRole.getY()+5, 30, 40, true);
			    g.fill3DRect(myRole.getX()+40, myRole.getY(),10, 50, false);
			    g.drawImage(img2, myRole.getX()+14,myRole.getY()+15, 20, 20,this);
			    g.fill3DRect(myRole.getX()+23, myRole.getY()+33, 2, 37,true);
			  
			
			        break;
			       
	    }
	    
	 }
}


     public void drawMyShot(MyRole myRole, Graphics g){
	
	   
    	  if(myRole.getDirect()==0 && myRole.getShowShot().getShow()==1){
    	 
                 g.drawImage(img4, myRole.getX()+14, myRole.getY()-45, 20,35, this);
                 
    	  }else if(myRole.getDirect()==1 && myRole.getShowShot().getShow()==1){
    		  
    	
                 g.drawImage(img5, myRole.getX()-50, myRole.getY()+14, 35,20, this);
                 
    	 }else if(myRole.getDirect()==2 && myRole.getShowShot().getShow()==1){
                	   
                 g.drawImage(img6, myRole.getX()+65, myRole.getY()+14, 35,20, this);
                 
    	  }else if(myRole.getDirect()==3 && myRole.getShowShot().getShow()==1){
                	   
                 g.drawImage(img7, myRole.getX()+14, myRole.getY()+60, 20,35, this);
    	     
    	   }	   
                     
        }




        public void drawMyShell(MyRole myRole ,Graphics g){
	  
	  
          for(int i=0; i<myRole.arr.size(); i++){	
        	
    	    MyShell shellrecord =myRole.arr.get(i);
        	
        	if(shellrecord!=null && shellrecord.getIsAlive()==1){
        		
        		if(shellrecord.getShellDirect()==0){
        		
        		 g.drawImage(img8, shellrecord.getX(), shellrecord.getY(), 20,35, this);
        		
        		 
        		 
        		}else if(shellrecord.getShellDirect()==1){
        			
        		g.drawImage(img9, shellrecord.getX(),shellrecord.getY(), 35,20, this);
        		 
        		
        			
        		}else if(shellrecord.getShellDirect()==2){
        			
        		g.drawImage(img10,shellrecord.getX(), shellrecord.getY(), 35,20, this);
        		
        	
        		
        		}else if(shellrecord.getShellDirect()==3){
        			
        		g.drawImage(img11, shellrecord.getX(),shellrecord.getY(), 20,35, this);
        			
        	
        		}
        		
        	 }else if(shellrecord.getIsAlive()==0){
        	    	
        	    	myRole.arr.remove(i);
        	    	
        	    }
	   
        	  
	      }
                   
        }
        
        
     
        
    public void drawEnemyRole(AddEnemyRole addEnemyRole,EnemyRole enemyRole,Graphics g){
        	
        
          for(int i=0; i<addEnemyRole.arr.size();i++){
        		
        	     enemyRole=addEnemyRole.arr.get(i);
        	     
        	     drawEnemyShot(enemyRole,g);
        		
        	     drawEnemyShell(enemyRole,g);

        	     interaction = new Interaction(myRole, enemyRole);
        	     
        	    new Thread(interaction).start();
        	
        	     try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	     
        	    if( enemyRole!=null && enemyRole.getIsAlive()!=0){
        		
        		if( enemyRole.getDirect()==0){
        			
        		   
         g.drawImage(img15,  enemyRole.getX(),  enemyRole.getY(), 50, 60,this);  
        			 
         }else if( enemyRole.getDirect()==1){
        			  
         g.drawImage(img16,  enemyRole.getX(),  enemyRole.getY(), 60, 50,this);  
        			
         }else if( enemyRole.getDirect()==2){
        	
         g.drawImage(img17,  enemyRole.getX(),  enemyRole.getY(), 60,50 ,this);  
        		   
         }else if( enemyRole.getDirect()==3){
    
         g.drawImage(img18,  enemyRole.getX(), enemyRole.getY(), 50, 60,this);  
        	    
          }
        
       }else if(enemyRole.getIsAlive()==0){
    	   
    	   addEnemyRole.arr.remove(i);
    	   
    	 for(int j=0; j<5; j++){
    	   
    	
    		 if(j==0){
    		 g.drawImage(img19, enemyRole.getX(), enemyRole.getY(), 50, 50,this);
    	   
         }else if(j==1){
    		 
        g.drawImage(img20, enemyRole.getX(), enemyRole.getY(), 50, 50,this);
    		  
    }else if(j==2){
    		  
    		  g.drawImage(img21, enemyRole.getX(), enemyRole.getY(), 50, 50,this);
    		  
    }else if(j==3){
    		
    	g.drawImage(img22, enemyRole.getX(), enemyRole.getY(), 50, 50,this);
    		  
    }else if(j==4){
    		  g.drawImage(img23, enemyRole.getX(), enemyRole.getY(), 50, 50,this);
    		  
   
    	  }
    		 
    		 try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
   
    	   
    	 }
    	   
    	 }
      
     }

    	   
    	   
    	    }
          
          
          
 public void drawEnemyShot(EnemyRole enemyRole ,Graphics g){
	   
	   
	   if( enemyRole.getDirect()==0 && enemyRole.getShowShot().getShow()==1){
        
		   g.drawImage(img24,enemyRole.getX(), enemyRole.getY()-38, 50, 50,this);
	   
	   }else if(enemyRole.getDirect()==1 && enemyRole.getShowShot().getShow()==1){
	   
		   g.drawImage(img24, enemyRole.getX()-38, enemyRole.getY()+2, 50, 50,this);	   
	   
	   }else if(enemyRole.getDirect()==2 && enemyRole.getShowShot().getShow()==1){
	   
		   g.drawImage(img24,enemyRole.getX()+48, enemyRole.getY()+2, 50, 50,this);   
	   
	   }else if(enemyRole.getDirect()==3 && enemyRole.getShowShot().getShow()==1){
	   
		   g.drawImage(img24,enemyRole.getX(), enemyRole.getY()+50, 50, 50,this);
	   }
   }
        
  
     public void drawEnemyShell(EnemyRole enemyRole,Graphics g){
    	
      
    	    for(int i=0; i<enemyRole.arr.size(); i++){
    	 
    		 EnemyShell enemyShell=enemyRole.arr.get(i);
    		 
    		 if(enemyShell != null && enemyShell.getIsAlive()==1){
    		 
    	g.drawImage(img12,  enemyShell.getX(),  enemyShell.getY(),20,20,this);
    	
    		   }else if(enemyShell.getIsAlive()==0){
    			   
    			   enemyRole.arr.remove(i);
    			   
    		   }
    		 
    		 }

     }
     
     
    
  public void keyPressed(KeyEvent e) {
	
	  if(e.getExtendedKeyCode()==KeyEvent.VK_ENTER){
		  
		
		 this.startpicture.setShowStartPicture(0); 
		  
		  
	  }else if(e.getKeyCode()==KeyEvent.VK_UP){
			 
		     myRole.setDirect(0);
			 myRole.setMove(1);
			 
		 }else if(e.getKeyCode()==KeyEvent.VK_LEFT){
			 
			 myRole.setDirect(1);
			 myRole.setMove(1);
			 
			 
		 }else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			 
			 myRole.setDirect(2);
			 myRole.setMove(1);
			 
		 }else if(e.getKeyCode()==KeyEvent.VK_DOWN){
	
			 myRole.setDirect(3);
			 myRole.setMove(1);
			
			 
		 }else if(e.getKeyCode()==KeyEvent.VK_A && myRole.arr.size()<5){
			    
			 
       		   myRole.fight();
			 
		 }
			     repaint();
      }
	
	
	





@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}




@Override
public void keyReleased(KeyEvent e) {

	if(e.getKeyCode()==KeyEvent.VK_UP){
    	
    	myRole.setMove(0);
    	
    }else if(e.getKeyCode()==KeyEvent.VK_LEFT){
    	
    	myRole.setMove(0);
    	
    }else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
    	
    	myRole.setMove(0);
    	
    }else if(e.getKeyCode()==KeyEvent.VK_DOWN){
    	
    	myRole.setMove(0);
    	
    }
 
            repaint();
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
		
		
	    repaint();
		
	}
 }

}
