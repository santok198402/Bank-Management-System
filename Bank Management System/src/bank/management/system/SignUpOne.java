package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class SignUpOne extends JFrame implements ActionListener {
    public static Long random;
    JTextField name_TextField,fName_TextField,email_TextField,address_TextField,city_TextField,state_TextField,pinCode_TextField;
    JButton next;
    JRadioButton male,female,married,single;
    JDateChooser dateChooser;
     SignUpOne(){
        setLayout(null);

        Random rand = new Random();
        long upperbound = 10000;
        random = rand.nextLong(upperbound);

        JLabel heading=new JLabel("APPLICATION FORM NO:"+random);
        heading.setBounds(250,20,400,30);
        add(heading);
        heading.setFont(new Font("Osward",Font.BOLD,20));

        JLabel personal_Details=new JLabel("Page 1 : Personal Details");
        personal_Details.setBounds(300,60,400,30);
        add(personal_Details);
        personal_Details.setFont(new Font("Osward",Font.BOLD,15));

        JLabel Name=new JLabel("*Name:");
        Name.setBounds(100,100,100,30);
        add(Name);
        Name.setFont(new Font("Osward",Font.BOLD,15));

         name_TextField=new JTextField();
        name_TextField.setBounds(220,105,300,25);
        add(name_TextField);

        JLabel fName=new JLabel("Father Name:");
        fName.setBounds(100,140,400,30);
        add(fName);
        fName.setFont(new Font("Osward",Font.BOLD,15));

         fName_TextField=new JTextField();
        fName_TextField.setBounds(220,145,300,25);
        add(fName_TextField);

        JLabel dob=new JLabel("DOB:");
        dob.setBounds(100,180,400,30);
        add(dob);
        dob.setFont(new Font("Osward",Font.BOLD,15));

         dateChooser=new JDateChooser();
        dateChooser.setBounds(220,185,300,25);
        add(dateChooser);

        JLabel gender=new JLabel("Gender:");
        gender.setBounds(100,220,400,30);
        add(gender);
        gender.setFont(new Font("Osward",Font.BOLD,15));

         male=new JRadioButton("Male");
        male.setBounds(220,225,70,30);
        male.setBackground(Color.WHITE);
        add(male);
         female=new JRadioButton("Female");
        female.setBounds(350,225,70,30);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup gendergroup=new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);


        JLabel email=new JLabel("*Email:");
        email.setBounds(100,260,400,30);
        add(email);
        email.setFont(new Font("Osward",Font.BOLD,15));

         email_TextField=new JTextField();
        email_TextField.setBounds(220,265,300,25);
        add(email_TextField);

        JLabel marital=new JLabel("Marital Status:");
        marital.setBounds(100,300,400,30);
        add(marital);
        marital.setFont(new Font("Osward",Font.BOLD,15));

         married=new JRadioButton("Married");
        married.setBounds(220,305,70,30);
        married.setBackground(Color.WHITE);
        add(married);
         single=new JRadioButton("Single");
        single.setBounds(350,305,70,30);
        single.setBackground(Color.WHITE);
        add(single);

        ButtonGroup maritalGroup=new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(single);

        JLabel address=new JLabel("Address:");
        address.setBounds(100,340,400,30);
        add(address);
        address.setFont(new Font("Osward",Font.BOLD,15));

         address_TextField=new JTextField();
        address_TextField.setBounds(220,345,300,25);
        add(address_TextField);

        JLabel city=new JLabel("City:");
        city.setBounds(100,380,400,30);
        add(city);
        city.setFont(new Font("Osward",Font.BOLD,15));

         city_TextField=new JTextField();
        city_TextField.setBounds(220,385,300,25);
        add(city_TextField);

        JLabel state=new JLabel("State:");
        state.setBounds(100,420,400,30);
        add(state);
        state.setFont(new Font("Osward",Font.BOLD,15));

         state_TextField=new JTextField();
        state_TextField.setBounds(220,425,300,25);
        add(state_TextField);

        JLabel pinCode=new JLabel("PinCode:");
        pinCode.setBounds(100,460,400,30);
        add(pinCode);
        pinCode.setFont(new Font("Osward",Font.BOLD,15));

         pinCode_TextField=new JTextField();
        pinCode_TextField.setBounds(220,465,300,25);
        add(pinCode_TextField);

         next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Osward",Font.BOLD,15));
        next.setBounds(600,500,70,25);
        next.addActionListener(this);
        add(next);



        setSize(800,650);
        setLocation(300,50);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==next){
            setVisible(false);
            new Signup2();
        }
        String formno= ""+ random;
        String name=name_TextField.getText();
        String fname=fName_TextField.getText();
        String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(male.isSelected()){
            gender="Male";
        }
        else if(female.isSelected()){
           gender="Female";
        }
        String email=email_TextField.getText();
        String marital=null;
        if(married.isSelected()){
            marital="Married";
        }
        else if(single.isSelected()){
            marital="Single";
        }
        String addres=address_TextField.getText();
        String city=city_TextField.getText();
        String state=state_TextField.getText();
        String pin=pinCode_TextField.getText();
        try{
            if(name.equals("")|| email.equals("")){
                setVisible(true);
                JOptionPane.showMessageDialog(null,"Please fill the required feilds");
            }
            else{
                Conn obj=new Conn();
               String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+addres+"','"+city+"','"+pin+"','"+state+"')";
               obj.s.executeUpdate(query);

            }
        }
        catch (Exception e){
            System.out.println(e);
        }

    }

    public static void main(String[] args) {

        SignUpOne obj=new SignUpOne();
    }
}
