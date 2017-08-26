package com.MyRMITGame;

import javax.swing.*;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;



public class MyFrame extends JFrame implements  ActionListener, Serializable{
     
	
	private static final long serialVersionUID = 1L;
	ActionEvent e = null;
	 JPanel jp1,jp2;
     MyPanel mp =null;
     JButton jb1,jb2;
     JLabel jlb1 =null;
     File musicFile;
     URI uri;
 	 URL url;
     
     MyFrame(){
    	 
         jb1=new JButton("Turn  on");
    	 jb2=new JButton("Turn  off");
    	 
    	 jb1.addActionListener(this);
    	 jb1.setActionCommand("jb1");
    	 jb2.addActionListener(this);
    	 jb2.setActionCommand("jb2");
	   
	     jp1=new JPanel();
    	 jp2=new JPanel();
    	 mp=new MyPanel();
    	 Thread thr=new Thread(mp);
    	 thr.start();
         mp.setBackground(Color.BLACK);
         jp1.setLayout(new GridLayout(3,1));
         jlb1=new JLabel(new ImageIcon("otherSources/light.png"));
         jp1.add(jlb1);
         jp1.add(jb1);
         jp1.add(jb2);
    	
         jp2.setLayout(new GridLayout(3,1));
    	 jp2.add(jp1); 
    	
    	 this.add(mp);
    	 this.add(jp2,BorderLayout.EAST);
	
	    
	     
	     this.setTitle("RMIT Defending War");
	     this.setIconImage(new ImageIcon("otherSources/rmitIcon.png").getImage());
	     this.setSize(1000,800);
	     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     this.setResizable(false);
	     this.setVisible(true);
	     
	     this.musicFile=new File("otherSources/WindyDay.wav");
			
			uri=musicFile.toURI();
			
			try {
				url=uri.toURL();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			AudioClip ad;
			
			ad=Applet.newAudioClip(url);
			
			ad.loop();
     }

     
    
   public void actionPerformed(ActionEvent e) {
	
	if(e.getActionCommand().equals("jb1")){
		
	   mp.setBackground(Color.ORANGE);
		
	   mp.requestFocus();
		
	}else if(e.getActionCommand().equals("jb2")){
		
		
	   mp.setBackground(Color.BLACK);
		
	   mp.requestFocus();
	}
	
	        
 }

}