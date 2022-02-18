package hotelmanagementsystem;

import java.sql.*;
import java.util.Arrays;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class login extends JFrame implements ActionListener
{
    JLabel lbl1, lbl2;
    JTextField txt1;
    JPasswordField pwd;
    JButton btn1, btn2;

    login()
    {
        lbl1 = new JLabel("Username");
        lbl1.setFont(new Font("Agency FB", Font.BOLD, 18));
        lbl1.setBounds(40, 50, 100, 30);
        add(lbl1);

        lbl2 = new JLabel("Password");
        lbl2.setFont(new Font("Agency FB", Font.BOLD, 18));
        lbl2.setBounds(40, 100, 100, 30);
        add(lbl2);

        txt1 = new JTextField();
        txt1.setFont(new Font("Agency FB", Font.BOLD, 15));
        txt1.setBounds(150, 50, 150, 25);
        add(txt1);
        
        pwd = new JPasswordField();
        pwd.setFont(new Font("Agency FB", Font.BOLD, 15));
        pwd.setBounds(150, 100, 150, 25);
        add(pwd);

        btn1 = new JButton("Login");
        btn1.setFont(new Font("Century Gothic", Font.ITALIC, 17));
        btn1.setBackground(Color.BLACK);
        btn1.setForeground(Color.WHITE);
        btn1.setBounds(40, 200, 100, 35);
        add(btn1);
        
        btn2 = new JButton("Cancel");
        btn2.setFont(new Font("Century Gothic", Font.ITALIC, 17));
        btn2.setBackground(Color.BLACK);
        btn2.setForeground(Color.WHITE);
        btn2.setBounds(180, 200, 100, 35);
        add(btn2);
        
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        
        btn1.setActionCommand("L");
        btn2.setActionCommand("C");
        
        ImageIcon ii = new ImageIcon("login.jpg");
        Image img2 = ii.getImage().getScaledInstance(446,420, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel ll = new JLabel(ii);
        ll.setBounds(320, 30, 250, 250);
        add(ll);
        
        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setBounds(500, 200, 600, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getActionCommand().equals("C"))
        {
            txt1.setText("");
            pwd.setText("");
        }

        if(ae.getActionCommand().equals("L"))
        {
            char a[] = new char [] {};

            if(txt1.getText().equals(""))
            {
                JOptionPane.showMessageDialog(this,"Username cannot be left empty","ERROR",
                JOptionPane.ERROR_MESSAGE);
            }
            else if(Arrays.equals(pwd.getPassword(),a))
            {
                JOptionPane.showMessageDialog(this,"Password cannot be left empty","ERROR",
                JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                try
                    {
                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

                        Connection con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-2I7EIN8;DatabaseName=hms;user = sa;password=Babatounde1998");

                        PreparedStatement ps = con.prepareStatement("select UserName, Password from login where UserName = ? and Password=?");

                        String PWD = String.valueOf(pwd.getPassword());

                        ps.setString(1,txt1.getText());
                        ps.setString(2,PWD);

                        ResultSet rs = ps.executeQuery();

                        do
                        {
                                if(!(rs.next()))
                                {
                                    JOptionPane.showMessageDialog(this,"Login failed","ERROR",
                                    JOptionPane.ERROR_MESSAGE);
                                }
                                else if(txt1.getText().equals(rs.getString(1)) && PWD.equals(rs.getString(2)))
                                {
                                    JOptionPane.showMessageDialog(this,"Welcome "+txt1.getText(),
                                    "Authenticated",JOptionPane.INFORMATION_MESSAGE);

                                   HotelManagementSystemMENU hmsm = new HotelManagementSystemMENU();
                                    this.setVisible(false);
                                    hmsm.setVisible(true);
                                }
                        }while(rs.next());
                    }
                    catch(Exception e)
                    {
                        JOptionPane.showMessageDialog(this,"Database Error, please try again later"+e,
                        "ERROR",JOptionPane.ERROR_MESSAGE);
                    }
                    finally
                    {
                            txt1.setText("");
                            pwd.setText("");
                    }
            }
        }
    }

    public static void main(String[]args)
    {
        new login();
    }
}