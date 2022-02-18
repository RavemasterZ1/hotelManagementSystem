package hotelmanagementsystem;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

 class HotelManagementSystemMENU extends JFrame implements ActionListener  {
    
    JMenuBar mb;
        JMenu m1,m2;
        JMenuItem i1,i2,i3,i4;
       
    
    HotelManagementSystemMENU()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mb= new JMenuBar();
        add(mb);
        m1= new JMenu ("Hotel CENTER");
        m2= new JMenu("Hotel ADMIN");
        mb.add(m1);
        mb.add(m2);
        i1= new JMenuItem ("Reception");
        i1.addActionListener(this);
        i2=new JMenuItem(" ADD EMPLOYEE");
        i2.addActionListener(this);
        i3= new JMenuItem("ADD ROOMS");
        i3.addActionListener(this);
        i4= new JMenuItem("ADD DRIVERS");
        i4.addActionListener(this);

        i2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                new AddEmployeeDetails().setVisible(true);
            }

        });

        i3.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                new AddRooms().setVisible(true);
            }

        });
        
        i4.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                new AddDrivers().setVisible(true);
            }

        });

        m1.add(i1);
        m2.add(i2);
        m2.add(i3);
        m2.add(i4);
        mb.setBounds(0,0,1950,30);
        setLayout(null);
        setBounds(0,0,1950,1000);
        
        
         ImageIcon ii= new ImageIcon("second.jpg");
        JLabel ll= new JLabel(ii);
        ll.setBounds(0, 0,  2480,1400);
        add(ll);
    
        JLabel i2= new JLabel("WELCOME TO JEK HOTEL");
        i2.setBounds(20,600,1000,70);
        i2.setForeground(Color.WHITE);
        i2.setFont(new Font("serif",Font.BOLD,40));
        ll.add(i2);
        
        setVisible(true);
    } 

     public void actionPerformed(ActionEvent ae)
    {
        if(ae.getActionCommand().equals("Reception")){
            new hotelReception().setVisible(true);}
        else if(ae.getActionCommand().equals("ADD EMPLOYEE")){
            new  AddEmployeeDetails().setVisible(true);}
       else if(ae.getActionCommand().equals(" ADD ROOMS"))
        { new AddRooms().setVisible(true);}
        else if(ae.getActionCommand().equals(" ADD DRIVERS")){
            new  AddDrivers().setVisible(true);}
         
                    
            
    }
    public static void main(String[]args)
    {
        new HotelManagementSystemMENU();
    }
 }

