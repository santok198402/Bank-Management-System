package bank.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class Signup2 extends JFrame implements ActionListener{
   public static Long random,balance= 0L;
   public static JButton Done;

    public static JPasswordField password_text_feild,repassword_text_feild;
    Signup2(){
        setLayout(null);

        Random rand = new Random();
        long upperbound = 1000000000L;
        random = rand.nextLong(upperbound);

        JLabel heading=new JLabel("SET PASSWORD");
        heading.setBounds(250,20,400,30);
        add(heading);
        heading.setFont(new Font("Osward",Font.BOLD,20));

        JLabel Acc=new JLabel("Your Card Number:    "+random);
        Acc.setBounds(100,100,500,30);
        add(Acc);
        Acc.setFont(new Font("Osward",Font.BOLD,15));

        JLabel password=new JLabel("Enter Password");
        password.setBounds(100,135,200,30);
        add(password);
        password.setFont(new Font("Osward",Font.BOLD,15));


         password_text_feild=new JPasswordField();
        add(password_text_feild);
        password_text_feild.setBounds(270,135,300,25);

        JLabel repassword=new JLabel("ReEnter Password");
        repassword.setBounds(100,170,200,30);
        add(repassword);
        repassword.setFont(new Font("Osward",Font.BOLD,15));


        repassword_text_feild=new JPasswordField();
        add(repassword_text_feild);
        repassword_text_feild.setBounds(270,170,300,25);


         Done=new JButton("Done");
        Done.setBounds(300,300,150,30);
        Done.setBackground(Color.BLACK);
        Done.setForeground(Color.WHITE);
        Done.addActionListener(this);
        add(Done);

        setSize(800,480);
        setVisible(true);
        setLocation(300,150);
        getContentPane().setBackground(Color.WHITE);
    }
    public void actionPerformed(ActionEvent ae){
        String pass1= String.valueOf(password_text_feild.getPassword());
        String pass2= String.valueOf(repassword_text_feild.getPassword());
        if(ae.getSource()==Done){
            try {
                if (pass1.equals(pass2)) {

                    Conn obj2 = new Conn();
                    String query = "insert into signin values('" + random + "','" + pass1 + "','" + SignUpOne.random + "','" +balance+ "')";
                    obj2.s.executeUpdate(query);
                    setVisible(false);
                    new Main();
                } else {
                    JOptionPane.showMessageDialog(null, "Password Does not match");
                }
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
    }
}

