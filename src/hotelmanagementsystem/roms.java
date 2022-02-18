package hotelmanagementsystem;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

 class AddRooms extends JFrame implements ActionListener
{
    JTextField t1, t2;
    JButton btn1, btn2,btn3;
    JComboBox comb1, comb2, comb3;
    
    AddRooms()
    {
        setLayout(null);
        setSize(750, 500);
        setLocationRelativeTo(null);
        
        JLabel roomNumber = new JLabel("Room Number");
        roomNumber.setFont(new Font("Agency FB", Font.BOLD, 18));
        roomNumber.setBounds(60, 100, 120, 40);
        add(roomNumber);
        
        t1 = new JTextField();
        t1.setBounds(160, 110, 150, 25);
        add(t1);
        
        JLabel available = new JLabel("Available");
        available.setFont(new Font("Agency FB", Font.BOLD, 18));
        available.setBounds(60, 160, 120, 40);
        add(available);
        
        String stg[] = {"Available", "Non-Available"};
        comb1 = new JComboBox(stg);
        comb1.setFont(new Font("Agency FB", Font.BOLD, 18));
        comb1.setBounds(160, 170, 150, 25);
        add(comb1);
        
        JLabel cleaningStatus = new JLabel("Cleaning Status");
        cleaningStatus.setFont(new Font("Agency FB", Font.BOLD, 18));
        cleaningStatus.setBounds(60, 210, 120, 40);
        add(cleaningStatus);
        
        String stg1[] = {"Cleaned", "Dirty"};
        comb2 = new JComboBox(stg1);
        comb2.setFont(new Font("Agency FB", Font.BOLD, 18));
        comb2.setBounds(160, 220, 150, 25 );
        add(comb2);
        
        JLabel price = new JLabel("Price");
        price.setFont(new Font("Agency FB", Font.BOLD, 18));
        price.setBounds(60, 270, 120, 40);
        add(price);
        
        t2 = new JTextField();
        t2.setBounds(160, 280, 150, 25);
        add(t2);
        
        JLabel bedType = new JLabel("Bed Type");
        bedType.setFont(new Font("Agency FB", Font.BOLD, 18));
        bedType.setBounds(60, 330, 120, 40);
        add(bedType);
        
        String stg2[] = {"Single Bed", "Two Beds"};
        comb3 = new JComboBox(stg2);
        comb3.setFont(new Font("Agency FB", Font.BOLD, 18));
        comb3.setBounds(160, 340, 150, 25);
        add(comb3);
        
        btn1 = new JButton("Add Room");
        btn1.setFont(new Font("Century Gothic", Font.ITALIC, 15));
        btn1.setBackground(Color.BLACK);
        btn1.setForeground(Color.WHITE);
        btn1.setBounds(60, 390, 120, 30);
        add(btn1);
        
        btn2 = new JButton("Cancel");
        btn2.setFont(new Font("Century Gothic", Font.ITALIC, 15));
        btn2.setBackground(Color.BLACK);
        btn2.setForeground(Color.WHITE);
        btn2.setBounds(200, 390, 120, 30);
        add(btn2);

        
        
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        
        btn1.setActionCommand("A");
        btn2.setActionCommand("C");
        
        ImageIcon img1 = new ImageIcon("roms.jpg");
        Image img2 = img1.getImage().getScaledInstance(446, 420, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel lbl1 = new JLabel(img1);
        lbl1.setBounds(330, 60, 400, 380);
        add(lbl1);
        
        JLabel lbl2 = new JLabel("Add Rooms");
        lbl2.setFont(new Font("Agency FB", Font.BOLD, 18));
        lbl2.setBounds(150, 30, 120, 40);
        add(lbl2);
        
        getContentPane().setBackground(Color.WHITE);
       
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getActionCommand().equals("C"))
        {
            t1.setText("");
            t2.setText("");
        }

        
     
       
       
        String Romm = t1.getText();
        String Price = t2.getText();
        
       
        
       String Availability=(String)comb1.getSelectedItem();
       String Cleaning=(String)comb2.getSelectedItem();
       String Bed=(String)comb3.getSelectedItem();
       
       

        if(ae.getActionCommand().equals("A"))
        {
            if(t1.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Room Number cannot be left empty","ERROR",
				JOptionPane.ERROR_MESSAGE);
			}
			else if(comb1.getSelectedItem().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Availability cannot be empty","ERROR",
				JOptionPane.ERROR_MESSAGE);
			}
			else if(comb2.getSelectedItem().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Cleaning Statut cannot be left empty","ERROR",
				JOptionPane.ERROR_MESSAGE);
			}
			else if(t2.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Price cannot be left empty","ERROR",
				JOptionPane.ERROR_MESSAGE);
			}
			else if(comb3.getSelectedItem().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Bed Type cannot be left empty","ERROR",
				JOptionPane.ERROR_MESSAGE);
			}
			else
            {
            try
            {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-2I7EIN8;DatabaseName=hms;user = sa;password=Babatounde1998");
                PreparedStatement ps = con.prepareStatement("insert into [rooms] values(?,?,?,?,?)");
               
            
                Random r= new Random();
             
    
                
                    
                    ps.setString(1,t1.getText().toString());
                    ps.setString(2,comb1.getSelectedItem().toString());
                     ps.setString(3,comb2.getSelectedItem().toString());
                     ps.setString(4,t2.getText().toString());
                     ps.setString(5,comb3.getSelectedItem().toString());
                   
                   
                    
                    
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(this,"Room Successful ADD","VALID",JOptionPane.INFORMATION_MESSAGE);
               
                
                
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(this,"Database Error, Please try again later"+e,"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
    
    
    public static void main(String[]args)
    {
        new AddRooms();
    }
            
}
