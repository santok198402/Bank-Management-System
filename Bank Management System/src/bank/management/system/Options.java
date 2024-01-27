package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Options extends JFrame implements ActionListener {
      JButton checkBalance,withdraw,deposite,Exit;
    Options(){
        setLayout(null);
        setTitle("Options");

       JLabel heading=new JLabel("Please select your transaction",JLabel.CENTER);
       add(heading);
       heading.setBounds(200,20,400,70);
       heading.setFont(new Font("Osward",Font.BOLD,20));
       heading.setForeground(Color.WHITE);

        checkBalance=new JButton("Check Balance");
       add(checkBalance);
       checkBalance.setBounds(150,150,130,30);
       checkBalance.setForeground(Color.black);
       checkBalance.setBackground(Color.white);
        checkBalance.addActionListener(this);

         withdraw=new JButton("Withdraw");
        add(withdraw);
        withdraw.setBounds(150,300,130,30);
        withdraw.setForeground(Color.black);
        withdraw.setBackground(Color.white);
        withdraw.addActionListener(this);

        deposite=new JButton("Deposite");
        add(deposite);
        deposite.setBounds(500,150,130,30);
        deposite.setForeground(Color.black);
        deposite.setBackground(Color.white);
        deposite.addActionListener(this);

         Exit=new JButton("Back");
        add(Exit);
        Exit.setBounds(500,300,130,30);
        Exit.setForeground(Color.black);
        Exit.setBackground(Color.white);
        Exit.addActionListener(this);


        setSize(800,480);
        setVisible(true);
        setLocation(300,150);
        getContentPane().setBackground(Color.black);
    }
    public void actionPerformed(ActionEvent ae){
       if(ae.getSource() == checkBalance){
           setVisible(false);
          new BalanceRemaining();
       }

       else if (ae.getSource()==withdraw) {
           setVisible(false);
           new WithdrawAmount();
       }
       else if (ae.getSource()==deposite) {
           setVisible(false);
           new DepositeMoney();
       } else if (ae.getSource()==Exit) {
           setVisible(false);
           new Main();

       }
    }
}
