package hotelmanagementsystem;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class AddDrivers extends JFrame implements ActionListener
{
    JTextField jtxt1, jtxt2, jtxt3, jtxt4, jtxt5;
    JComboBox comb1, comb2;
    JButton btn1, btn2;

    AddDrivers()
    {
        setLayout(null);
        setSize(900, 500);
        setLocationRelativeTo(null);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel name = new JLabel("NAME");
        name.setFont(new Font("Agency FB", Font.BOLD, 18));
        name.setBounds(60, 80, 120, 40);
        add(name);

        jtxt1 = new JTextField();
        jtxt1.setBounds(160, 90, 150, 20);
        add(jtxt1);

        JLabel age = new JLabel("AGE");
        age.setFont(new Font("Agency FB", Font.BOLD, 18));
        age.setBounds(60, 120, 120, 40);
        add(age);

        jtxt2 = new JTextField();
        jtxt2.setBounds(160, 130, 150, 20);
        add(jtxt2);

        JLabel gender = new JLabel("GENDER");
        gender.setFont(new Font("Agency FB", Font.BOLD, 18));
        gender.setBounds(60, 160, 120, 40);
        add(gender);

        String strg[] = {"Male","Female"};
        comb1 = new JComboBox(strg);
        comb1.setFont(new Font("Agency FB", Font.BOLD, 18));
        comb1.setBounds(160, 170, 150, 20);
        add(comb1);

        JLabel carCompany = new JLabel("CAR COMPANY");
        carCompany.setBounds(60, 200, 120, 40);
        carCompany.setFont(new Font("Agency FB", Font.BOLD, 18));
        add(carCompany);

        jtxt3 = new JTextField();
        jtxt3.setBounds(160, 210, 150, 20);
        add(jtxt3);

        JLabel carBrand = new JLabel("CAR BRAND");
        carBrand.setFont(new Font("Agency FB", Font.BOLD, 18));
        carBrand.setBounds(60, 240, 120, 40);
        add(carBrand);

        jtxt4 = new JTextField();
        jtxt4.setBounds(160, 250, 150, 20);
        add(jtxt4);

        JLabel available = new JLabel("AVAILABLE");
        available.setFont(new Font("Agency FB", Font.BOLD, 18));
        available.setBounds(60, 280, 120, 40);
        add(available);

        String strg1[] = {"Yes","No"};
        comb2 = new JComboBox(strg1);
        comb2.setFont(new Font("Agency FB", Font.BOLD, 18));
        comb2.setBounds(160, 290, 150, 20);
        add(comb2);

        JLabel location = new JLabel("LOCATION");
        location.setFont(new Font("Agency FB", Font.BOLD, 18));
        location.setBounds(60, 320, 120, 40);
        add(location);

        jtxt5 = new JTextField();
        jtxt5.setBounds(160, 330, 150, 20);
        add(jtxt5);

        btn1 = new JButton("ADD");
        btn1.setBackground(Color.BLACK);
        btn1.setForeground(Color.WHITE);
        btn1.setFont(new Font("Century Gothic", Font.ITALIC, 18));
        btn1.setBounds(60, 400, 120, 30);
        add(btn1);

        btn2 = new JButton("CLEAR");
        btn2.setBackground(Color.BLACK);
        btn2.setForeground(Color.WHITE);
        btn2.setFont(new Font("Century Gothic", Font.ITALIC, 18));
        btn2.setBounds(200, 400, 120, 30);
        add(btn2);

        btn1.addActionListener(this);
        btn2.addActionListener(this);

        btn1.setActionCommand("A");
        btn2.setActionCommand("C");

        ImageIcon img1 = new ImageIcon("fourth.jpg");
        Image img2 = img1.getImage().getScaledInstance(446,420, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel lbl1 = new JLabel(img1);
        lbl1.setBounds(400, 80, 400, 313);
        add(lbl1);

        JLabel lbl2 = new JLabel("Add Drivers");
        lbl2.setForeground(Color.BLACK);
        lbl2.setBounds(150, 25, 120, 40);
        lbl2.setFont(new Font("Agency FB", Font.BOLD, 30));
        add(lbl2);

        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    { 
        
        if(ae.getActionCommand().equals("C"))
        {
            jtxt1.setText("");
            jtxt2.setText("");
            jtxt3.setText("");
            jtxt4.setText("");
            jtxt5.setText("");
            
        }
        
        
        
        
        
        
        String name = jtxt1.getText();
        String age = jtxt2.getText();
        String CarCompany = jtxt3.getText();
        String CarBrand= jtxt4.getText();
        String Location = jtxt5.getText();
        
       String Gender=(String)comb1.getSelectedItem();
       String Available=(String)comb2.getSelectedItem();

        if(ae.getActionCommand().equals("A"))
        {
            if(jtxt1.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Name cannot be left empty","ERROR",
				JOptionPane.ERROR_MESSAGE);
			}
			else if(jtxt2.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Age cannot be empty","ERROR",
				JOptionPane.ERROR_MESSAGE);
			}
			else if(comb1.getSelectedItem().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Gender cannot be left empty","ERROR",
				JOptionPane.ERROR_MESSAGE);
			}
			else if(jtxt3.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Car Company cannot be left empty","ERROR",
				JOptionPane.ERROR_MESSAGE);
			}
            else if(jtxt4.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Car Brand cannot be left empty","ERROR",
				JOptionPane.ERROR_MESSAGE);
			}
            else if(comb2.getSelectedItem().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Location cannot be left empty","ERROR",
				JOptionPane.ERROR_MESSAGE);
			}
            else if(jtxt5.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Email cannot be left empty","ERROR",
				JOptionPane.ERROR_MESSAGE);
			}
			else
            {
            try
            {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-2I7EIN8;DatabaseName=hms;user = sa;password=Babatounde1998");
                PreparedStatement ps = con.prepareStatement("insert into [Drivers] values(?,?,?,?,?,?,?)");
               
            
                Random r= new Random();
             
    
                
                    
                ps.setString(1,jtxt1.getText().toString());
                ps.setString(2,jtxt2.getText().toString());
                ps.setString(3,comb1.getSelectedItem().toString());
                ps.setString(4,jtxt3.getText().toString());
                ps.setString(5,jtxt4.getText().toString());
                ps.setString(6,comb1.getSelectedItem().toString());
                ps.setString(7,jtxt5.getText().toString());
                
               
                   
                    
                    
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
        new AddDrivers();
    }
}