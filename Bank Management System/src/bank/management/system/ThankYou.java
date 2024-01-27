package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThankYou extends JFrame implements ActionListener {
    JButton Done;
    ThankYou(){
        setLayout(null);
        JLabel SignUp_successfull=new JLabel("Thank you");
        SignUp_successfull.setBounds(150,20,400,30);
        add(SignUp_successfull);
        SignUp_successfull.setFont(new Font("Osward",Font.BOLD,20));

        JLabel ThankYou=new JLabel("Thank You");
        ThankYou.setBounds(130,170,400,50);
        add(ThankYou);
        ThankYou.setFont(new Font("Osward",Font.BOLD,40));

          Done=new JButton("Done");
        Done.setBounds(300,300,150,30);
        Done.setBackground(Color.BLACK);
        Done.setForeground(Color.WHITE);
        Done.addActionListener(this);
        add(Done);


        setSize(500,500);
        setVisible(true);
        setLocation(400,150);
        getContentPane().setBackground(Color.WHITE);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==Done){
            new Main();
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        ThankYou obj=new ThankYou();
    }
}
