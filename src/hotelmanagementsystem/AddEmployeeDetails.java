package hotelmanagementsystem;


import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

 class AddEmployeeDetails extends JFrame implements ActionListener
{
    JTextField jtxt1, jtxt2, jtxt3, jtxt4, jtxt5;
    JRadioButton rad1, rad2;
    JComboBox comb1;
    JButton btn1, btn2; 
    
   
    AddEmployeeDetails()
    {   
        setTitle("EMPLOYEE DETAILS");
        setLayout(null);
        setSize(800, 500);
        //setLayout(new FlowLayout(FlowLayout.CENTER));
        setLocationRelativeTo(null);
       


        JLabel name = new JLabel("NAME");
        name.setFont(new Font("Agency FB", Font.BOLD, 17));
        name.setBounds(60, 30, 120, 40);
        add(name);

        jtxt1 = new JTextField();
        jtxt1.setBounds(120, 40, 150, 20);
        add(jtxt1);

        JLabel age = new JLabel("AGE");
        age.setFont(new Font("Agency FB", Font.BOLD, 17));
        age.setBounds(60, 70, 120, 40);
        add(age);

        jtxt2 = new JTextField();
        jtxt2.setBounds(120, 80, 150, 20);
        add(jtxt2);

        JLabel gender = new JLabel("GENDER");
        gender.setFont(new Font("Agency FB", Font.BOLD, 17));
        gender.setBounds(60, 110, 120, 40);
        add(gender);

        rad1 = new JRadioButton("Male");
        rad1.setFont(new Font("Agency FB", Font.BOLD, 17));
        rad1.setBounds(120, 120, 70, 20);
        add(rad1);

        rad2 = new JRadioButton("Female");
        rad2.setFont(new Font("Agency FB", Font.BOLD, 17));
        rad2.setBounds(200, 120, 70, 20);
        add(rad2);

        JLabel job = new JLabel("JOB");
        job.setFont(new Font("Agency FB", Font.BOLD, 17));
        job.setBounds(60, 150, 120, 40);
        add(job);

        String strg[] = {" ","Room Service","Waiter/Waitress","Manager","Accountant","Groom","Front Desk Clerks","Kitchen Staff"};
        comb1 = new JComboBox(strg);
        comb1.setFont(new Font("Agency FB", Font.BOLD, 17));
        comb1.setBounds(120, 160, 150, 20);
        add(comb1);


        JLabel salary = new JLabel("SALARY");
        salary.setFont(new Font("Agency FB", Font.BOLD, 17));
        salary.setBounds(60, 190, 120, 40);
        add(salary);

        jtxt3 = new JTextField();
        jtxt3.setBounds(120, 200, 150, 20);
        add(jtxt3);

        JLabel phone = new JLabel("PHONE");
        phone.setFont(new Font("Agency FB", Font.BOLD, 17));
        phone.setBounds(60, 230, 120, 40);
        add(phone);

        jtxt4 = new JTextField();
        jtxt4.setBounds(120, 240, 150, 20);
        add(jtxt4);


        JLabel email = new JLabel("EMAIL");
        email.setFont(new Font("Agency FB", Font.BOLD, 17));
        email.setBounds(60, 270, 120, 40);
        add(email);

        jtxt5 = new JTextField();
        jtxt5.setBounds(120, 280, 150, 20);
        add(jtxt5);

        btn1 = new JButton("Submit");
        btn1.setFont(new Font("Century Gothic", Font.ITALIC, 18));
        btn1.setBackground(Color.BLACK);
        btn1.setForeground(Color.WHITE);
        btn1.setBounds(120, 360, 150, 30);
        add(btn1);

        btn2 = new JButton("Back");
        btn2.setFont(new Font("Century Gothic", Font.ITALIC, 18));
        btn2.setBackground(Color.BLACK);
        btn2.setForeground(Color.WHITE);
        btn2.setBounds(120, 400, 150, 30);
        add(btn2);

        btn1.addActionListener(this);
        btn2.addActionListener(this);

        btn1.setActionCommand("S");
        btn2.setActionCommand("B");

        ImageIcon img1 = new ImageIcon("employee.jpg");
        Image img2 = img1.getImage().getScaledInstance(446,420, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel lbl1 = new JLabel(img1);
        lbl1.setBounds(350, 70, 400, 350);
        add(lbl1);

        JLabel lbl2 = new JLabel("ADD EMPLOYEE DETAILS");
        lbl2.setForeground(Color.BLUE);
        lbl2.setBounds(450, 30, 400, 30);
        lbl2.setFont(new Font("Agency FB", Font.BOLD, 30));
        add(lbl2);

        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {  
        String name = jtxt1.getText();
        String age = jtxt2.getText();
        String salary = jtxt3.getText();
        String phone = jtxt4.getText();
        String email = jtxt5.getText();
       
        String gender = null;
        
        if(rad1.isSelected()){
            gender="Male";
        }else if(rad2.isSelected()){
          gender="Female";
        }
        
       String Job=(String)comb1.getSelectedItem();
       
       

        if(ae.getActionCommand().equals("S"))
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
				JOptionPane.showMessageDialog(this,"Job cannot be left empty","ERROR",
				JOptionPane.ERROR_MESSAGE);
			}
			else if(jtxt3.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Salary cannot be left empty","ERROR",
				JOptionPane.ERROR_MESSAGE);
			}
            else if(jtxt4.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Phone cannot be left empty","ERROR",
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
                PreparedStatement ps = con.prepareStatement("insert into [AddEmployeeDetails] values(?,?,?,?,?,?,?)");
               
            
                Random r= new Random();
             
    
                
                    
                    ps.setString(1,jtxt1.getText().toString());
                    ps.setString(2,jtxt2.getText().toString());
                     ps.setString(3,gender);
                    ps.setString(4,comb1.getSelectedItem().toString());
                    ps.setString(5,jtxt3.getText().toString());
                    ps.setString(6,jtxt4.getText().toString());
                    ps.setString(7,jtxt5.getText().toString());
                   
                    
                    
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(this,"Employee Successful ADD","VALID",JOptionPane.INFORMATION_MESSAGE);
               
                
                
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(this,"Database Error, Please try again later"+e,"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }

        if(ae.getActionCommand().equals("B"))
        {
            HotelManagementSystemMENU hmsm = new HotelManagementSystemMENU();
            this.setVisible(false);
            hmsm.setVisible(true);
        }
    }

    public static void main(String[] args)
    {
        new AddEmployeeDetails();
    }
}