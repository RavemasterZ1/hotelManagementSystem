package hotelmanagementsystem;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

 class hotelManagementSystem extends JFrame implements ActionListener {
    hotelManagementSystem()
    {
        setBounds(300,200,1280,720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ImageIcon ii= new ImageIcon("first.jpg");
        JLabel ll= new JLabel(ii);
        ll.setBounds(0, 0,  1280,720);
        add(ll);
    
        JLabel l2= new JLabel("Hotel Management System");
        l2.setBounds(20,600,1000,70);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("serif",Font.BOLD,40));
        ll.add(l2);
    
        JButton b1= new JButton("NEXT");
     b1.setForeground(Color.BLACK);
     b1.setBackground(Color.WHITE);
     b1.setBounds(1030,620,100,30);
     b1.addActionListener(this);
     ll.add(b1);
    
    setLayout(null);
    setVisible(true);
    
    while(true)
      {
    l2.setVisible(false);
    try{
        Thread.sleep(500);
    }catch(Exception e){}
    
    l2.setVisible(true);
    try{
        Thread.sleep(500);
    
    }catch(Exception e){}
    
      }
    }
    
      
    public void actionPerformed(ActionEvent ae)
    {
    new login().setVisible(true);
    this.setVisible(false);
    }
    public static void main(String[] args) 
    {
       new hotelManagementSystem();
    }

  
    }
    
    

