package hotelmanagementsystem;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;


  public class hotelReception extends JFrame  {
    JButton B1,B2,B3,B4,B5,B6,B7,B8,B9,B10,B11,B12;
    static JTable tb;
   
    
    hotelReception()
    {
        
    
    JButton B1=new JButton("NEW CUSTOMER FORM");
    B1.setBackground(Color.BLACK);
    B1.setForeground(Color.WHITE);
    B1.setBounds(10,30,200,30);
    add(B1);
    
    JButton B2=new JButton("ROOM");
    B2.setBackground(Color.BLACK);
    B2.setForeground(Color.WHITE);
    B2.setBounds(10,70,200,30);
    add(B2);
    
    JButton B3=new JButton("DEPARTMENT");
    B3.setBackground(Color.BLACK);
    B3.setForeground(Color.WHITE);
    B3.setBounds(10,110,200,30);
    add(B3);
    
    JButton B4=new JButton("ALL EMPLOYEE INFO");
    B4.setBackground(Color.BLACK);
    B4.setForeground(Color.WHITE);
    B4.setBounds(10,150,200,30);
    add(B4);
    /*B4.addActionListener(this);
    B4.setActionCommand(E);*/
    
    JButton B5=new JButton("CUSTOMER INFO");
    B5.setBackground(Color.BLACK);
    B5.setForeground(Color.WHITE);
    B5.setBounds(10,190,200,30);
    add(B5);
    
    JButton B6=new JButton("MANAGEMENT INFO");
    B6.setBackground(Color.BLACK);
    B6.setForeground(Color.WHITE);
    B6.setBounds(10,230,200,30);
    add(B6);
    
    JButton B7=new JButton("CHECK OUT");
    B7.setBackground(Color.BLACK);
    B7.setForeground(Color.WHITE);
    B7.setBounds(10,270,200,30);
    add(B7);
    
    JButton B8=new JButton("UDAPTE CHECK STATUS");
    B8.setBackground(Color.BLACK);
    B8.setForeground(Color.WHITE);
    B8.setBounds(10,310,200,30);
    add(B8);
    
    JButton B9=new JButton("UDAPTE ROOM STATUS");
    B9.setBackground(Color.BLACK);
    B9.setForeground(Color.WHITE);
    B9.setBounds(10,350,200,30);
    add(B9);
    
    JButton B10=new JButton("PICK UP SERVICE");
    B10.setBackground(Color.BLACK);
    B10.setForeground(Color.WHITE);
    B10.setBounds(10,390,200,30);
    add(B10);
    
    JButton B11=new JButton("SEARCH ROOM");
    B11.setBackground(Color.BLACK);
    B11.setForeground(Color.WHITE);
    B11.setBounds(10,430,200,30);
    add(B11);
    
    JButton B12=new JButton("LOGOUT");
    B12.setBackground(Color.BLACK);
    B12.setForeground(Color.WHITE);
    B12.setBounds(10,470,200,30);
    add(B12);
   
    
    
   ImageIcon i1=new ImageIcon("third.jpg");
   JLabel l1= new JLabel(i1);
   l1.setBounds(250,30,500,470);
   add(l1);
   
    
    
    setLayout(null);
    setBounds(530,200,800,570);
    setVisible(true);
    }
  
   /* public void actionPerformed(ActionEvent ae)
   {

    if(ae.getActionCpmmand().eqauls("E")){
      
      String [] colName = {"Name","Age","Gender","Job","Salary","Phone","Email"};
      DefaultTableModel model = new DefaultTableModel();
      model.setColumnIdentifiers(colName);

      tb = new JTable();
      tb.setModel(model); 
      tb.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
      tb.setFillsViewportHeight(true);
      JScrollPane scroll = new JScrollPane(tb);
      scroll.setHorizontalScrollBarPolicy(
      JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      scroll.setVerticalScrollBarPolicy(
      JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
      
     
      
      String id ="";
      String name ="";
      String age="";
      String  gender="";
      String salary ="";
      String phone  ="";
      String email ="";
      
      try
      {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost; DatabaseName = hms; user = sa;password = Babatounde1998");
        PreparedStatement ps = con.prepareStatement("select ID, Name, Gender, Salary, Phone, Email, from [addEmployeeDetails]");
      
        
        ResultSet rs = ps.executeQuery();
        
        while(rs.next())
        {
          id = rs.getString(1);
          name = rs.getString(2);
          age = rs.getString(3);
          gender= rs.getString(4);
          salary = rs.getString(5);
          phone = rs.getString(6);
          email = rs.getString(7);
          
          model.addRow(new Object[]{id,name,age,gender,salary,phone,email});
        }
        
      }
      catch(Exception e)
      {
        JOptionPane.showMessageDialog(null, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
      }
      
      add(scroll);
      
      setVisible(true);
    }*/
   

    public static void main(String[]args)
    
    {
      new hotelReception();
    }
   }

   
  

  