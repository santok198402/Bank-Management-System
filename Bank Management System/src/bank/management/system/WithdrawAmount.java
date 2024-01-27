package bank.management.system;

import java.sql.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WithdrawAmount extends JFrame implements ActionListener {

    JButton submit,back;
    JTextField amount;
    WithdrawAmount(){
        setLayout(null);
        setTitle("Options");

        JLabel heading=new JLabel("Enter the amount to be withdrawn");
        add(heading);
        heading.setBounds(200,20,400,70);
        heading.setFont(new Font("Osward",Font.BOLD,20));
        heading.setForeground(Color.WHITE);

         amount=new JTextField();
        add(amount);
        amount.setBounds(200,200,400,40);

         submit=new JButton("submit");
        submit.setBounds(500,300,100,40);
        submit.addActionListener(this);
        add(submit);

        back=new JButton("back");
        back.setBounds(500,370,100,40);
        back.addActionListener(this);
        add(back);

        setSize(800,480);
        setVisible(true);
        setLocation(300,150);
        getContentPane().setBackground(Color.black);
    }
   public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            try{
                Conn conn=new Conn();
                String query1="select balance from signin where cardno='"+Main.cardnumber+"'";
                ResultSet rs1= conn.s.executeQuery(query1);
                long balance=0;
                if(rs1.next()) {
                     balance = Integer.parseInt(rs1.getString("balance"));
                }
                if(balance>Integer.parseInt(amount.getText()) && Integer.parseInt(amount.getText())>0){
                    balance-=Integer.parseInt(amount.getText());

                    String query2="update signin set balance='"+balance+"' where cardno='"+Main.cardnumber+"'";
                    conn.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, "You have successfully withdrawn"+amount.getText());
                }
                else{
                    JOptionPane.showMessageDialog(null, "You dont have enough balance or you have entered a wrong value");
                }
            }
            catch (Exception e){
                System.out.println(e);
            }
        } else if (ae.getSource()==back) {
            setVisible(false);
            new Options();
        }
   }
}
