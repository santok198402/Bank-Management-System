package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceRemaining extends JFrame implements ActionListener {
    JButton back;
    BalanceRemaining(){
        setLayout(null);
        setTitle("Balance");

        Conn conn=new Conn();

        String query="select balance from signin where cardno='"+Main.cardnumber+"'";
        try {
            ResultSet rs = conn.s.executeQuery(query);
            if (rs.next()) {
                JLabel heading=new JLabel("Your Balance is : "+rs.getString("balance"));
                add(heading);
                heading.setBounds(200,200,500,50);
                heading.setFont(new Font("Osward",Font.BOLD,20));
                heading.setForeground(Color.WHITE);
            } else {
                JOptionPane.showMessageDialog(null, "Sorry some error occured");
            }
        }
        catch (Exception e){
            System.out.println("Sorry some error occured");
        }
        back=new JButton("back");
        back.setBounds(500,370,100,40);
        back.addActionListener(this);
        add(back);


        // Frame Size and Location
        setSize(800,480);
        setVisible(true);
        setLocation(300,150);
        getContentPane().setBackground(Color.black);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Options();
        }
    }
}
