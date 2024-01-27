package bank.management.system;

import java.sql.*;        //Resultset
import javax.swing.*;     //JFRAME
import java.awt.*;        //IMAGE and size
import java.awt.event.*;  //EVENT Listener


public class Main extends JFrame implements ActionListener {
    static String cardnumber;
    JButton login,clear,signUp;
    JTextField cardTextField,pinTextField;
    Main(){

        //Adding Title and Data in Frame
        setLayout(null);
        setTitle("AUTOMATING TELLER MACHINE");



        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image i2=i1.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);//We can only add image icon to Jlabel. Jlabel label=new Jlabel(i2) is not possible because i2 is image.
        JLabel label=new JLabel(i3);//We converted i2 to Jlabel.
        add(label);
        label.setBounds(70,10,70,70);


        JLabel text=new JLabel("Welcome to ATM",JLabel.CENTER);
        add(text);
        text.setBounds(150,20,400,70);
        text.setFont(new Font("Osward",Font.BOLD,38));

        JLabel cardNo=new JLabel("Card No:");
        add(cardNo);
        cardNo.setBounds(150,120,200,70);
        cardNo.setFont(new Font("Raleway",Font.BOLD,20));

        cardTextField=new JTextField();
        add(cardTextField);
        cardTextField.setBounds(250,145,200,25);

        JLabel pin=new JLabel("PIN:");
        add(pin);
        pin.setBounds(195,180,200,70);
        pin.setFont(new Font("Raleway",Font.BOLD,20));

        pinTextField=new JPasswordField();
        add(pinTextField);
        pinTextField.setBounds(250,205,200,25);

        login=new JButton("Sign In");
        login.setBounds(250,250,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear=new JButton("Clear");
        clear.setBounds(400,250,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signUp=new JButton("SignUp");
        signUp.setBounds(300,300,150,30);
        signUp.setBackground(Color.BLACK);
        signUp.setForeground(Color.WHITE);
        signUp.addActionListener(this);
        add(signUp);

        // Frame Size and Location
        setSize(800,480);
        setVisible(true);
        setLocation(300,150);
        getContentPane().setBackground(Color.white);



    }
    public void actionPerformed(ActionEvent ae){
        String cardno=cardTextField.getText();
        String pin=pinTextField.getText();
        if(ae.getSource()==clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }
       else if(ae.getSource()==signUp){
           setVisible(false);
            new SignUpOne();
        }
       else if (ae.getSource()==login) {
        Conn conn=new Conn();
         cardnumber=cardTextField.getText();
        String pinnumber=pinTextField.getText();
        String query="select * from signin where cardno='"+cardnumber+"' and passwords='"+pinnumber+"'";
        try{
            ResultSet rs= conn.s.executeQuery(query);
            if(rs.next()){
                setVisible(false);
                new Options();
            }
            else{
                JOptionPane.showMessageDialog(null,"Incorrect CardNumber or Pin");
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        }
    }
    public static void main(String[] args) {

        Main obj=new Main();
    }
}