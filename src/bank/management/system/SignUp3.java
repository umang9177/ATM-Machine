package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUp3 extends JFrame implements ActionListener {

    JLabel heading,acType,cardNo,num,pin,cardDetail,pDetail,pinNumber,service;
    JCheckBox c1,c2,c3,c4,c5,c6,c7,c8;
    JRadioButton savingAc,fdAc,currentAc,recurAcc;
    JButton submit,cancel;
    ButtonGroup btngrp;
    String formNo;

    SignUp3(String formNo){

        this.formNo = formNo;

        setSize(550,600);
        setLocation(500,125);
        setUndecorated(true);
        setVisible(true);
        setTitle("New Application Form : Page-3");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        heading = new JLabel("Page-3 : Account Details");
        heading.setFont(new Font("Railway",Font.BOLD,20));
        heading.setBounds(150,30,400,30);
        add(heading);

        acType = new JLabel("Account Type");
        acType.setFont(new Font("Railway",Font.BOLD,16));
        acType.setBounds(50,100,500,20);
        add(acType);

        savingAc = new JRadioButton("Saving Account");
        savingAc.setBounds(50,130,250,20);
        savingAc.setBackground(Color.WHITE);
        add(savingAc);

        currentAc = new JRadioButton("Current Account");
        currentAc.setBounds(50,150,250,20);
        currentAc.setBackground(Color.WHITE);
        add(currentAc);

        fdAc = new JRadioButton("Fixed Deposit Account");
        fdAc.setBounds(300,130,250,20);
        fdAc.setBackground(Color.WHITE);
        add(fdAc);

        recurAcc = new JRadioButton("Recurring Deposit Account");
        recurAcc.setBounds(300,150,250,20);
        recurAcc.setBackground(Color.WHITE);
        add(recurAcc);

        btngrp = new ButtonGroup();
        btngrp.add(savingAc);
        btngrp.add(currentAc);
        btngrp.add(fdAc);
        btngrp.add(recurAcc);

        cardNo = new JLabel("Card Number:");
        cardNo.setFont(new Font("Railway",Font.BOLD,16));
        cardNo.setBounds(50,200,200,20);
        add(cardNo);

        cardDetail = new JLabel("Your 16 Digit Card Number.");
        cardDetail.setFont(new Font("Railway",Font.BOLD,10));
        cardDetail.setBounds(50,220,500,14);
        add(cardDetail);

        num = new JLabel("XXXX-XXXX-XXXX-1234");
        num.setFont(new Font("Railway",Font.BOLD,16));
        num.setBounds(200,200,400,20);
        add(num);

        pin = new JLabel("PIN:");
        pin.setFont(new Font("Railway",Font.BOLD,16));
        pin.setBounds(50,250,100,20);
        add(pin);

        pinNumber = new JLabel("XXXX");
        pinNumber.setFont(new Font("Railway",Font.BOLD,16));
        pinNumber.setBounds(200,250,100,20);
        add(pinNumber);

        pDetail = new JLabel("Your 4 Digit Password.");
        pDetail.setFont(new Font("Railway",Font.BOLD,10));
        pDetail.setBounds(50,270,200,14);
        add(pDetail);

        service = new JLabel("Service Required:");
        service.setFont(new Font("Railway",Font.BOLD,16));
        service.setBounds(50,300,300,20);
        add(service);

        c1= new JCheckBox("ATM Card");
        c1.setFont(new Font("Railway",Font.BOLD,12));
        c1.setBounds(50,330,200,20);
        c1.setBackground(Color.WHITE);
        add(c1);

        c2= new JCheckBox("Mobile Banking");
        c2.setFont(new Font("Railway",Font.BOLD,12));
        c2.setBounds(300,330,200,20);
        c2.setBackground(Color.WHITE);
        add(c2);

        c3= new JCheckBox("Cheque Book");
        c3.setFont(new Font("Railway",Font.BOLD,12));
        c3.setBounds(50,360,200,20);
        c3.setBackground(Color.WHITE);
        add(c3);

        c4= new JCheckBox("Internet Banking");
        c4.setFont(new Font("Railway",Font.BOLD,12));
        c4.setBounds(300,360,200,20);
        c4.setBackground(Color.WHITE);
        add(c4);

        c5= new JCheckBox("E-mail & SMS Alert");
        c5.setFont(new Font("Railway",Font.BOLD,12));
        c5.setBounds(50,390,200,20);
        c5.setBackground(Color.WHITE);
        add(c5);

        c6= new JCheckBox("E-Statement");
        c6.setFont(new Font("Railway",Font.BOLD,12));
        c6.setBounds(300,390,200,20);
        c6.setBackground(Color.WHITE);
        add(c6);

        c7 = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge.");
        c7.setFont(new Font("Railway",Font.BOLD,10));
        c7.setBounds(50,450,500,16);
        c7.setBackground(Color.WHITE);
        add(c7);

        c8= new JCheckBox("None is required");
        c8.setFont(new Font("Railway",Font.BOLD,12));
        c8.setBounds(300,420,200,20);
        c8.setBackground(Color.WHITE);
        add(c8);

        submit = new JButton("Submit");
        submit.setFont(new Font("Railway",Font.BOLD,12));
        submit.setBounds(150,480,75,20);
        submit.setForeground(Color.white);
        submit.setBackground(Color.black);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Railway",Font.BOLD,12));
        cancel.setBounds(300,480,75,20);
        cancel.setForeground(Color.white);
        cancel.setBackground(Color.black);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.WHITE);
    }

    public void actionPerformed(ActionEvent ae){

        String acSelect = null;
        if(savingAc.isSelected()){
            acSelect ="Savings Account";
        } else if(fdAc.isSelected()){
            acSelect = "Fixed Deposit Account";
        }else if(currentAc.isSelected()) {
            acSelect = "Current Account";
        }else if(recurAcc.isSelected()) {
            acSelect = "Recurring Deposit Account";
        } else {
            acSelect = "";
        }

        Random random = new Random();
        String cardNo = "" + Math.abs((random.nextLong()%90000000L)) +50409360000L;

        String pinNo = "" + Math.abs((random.nextLong() % 9000L)+1000L);

        String facility = "";
        if(c1.isSelected()){
            facility = facility +"ATM Card";
        }
        if (c2.isSelected()){
            facility = facility +"Mobile Banking";
        }
        if (c3.isSelected()){
            facility = facility +"Cheque Book";
        }
        if (c4.isSelected()){
            facility = facility +"Internet Banking";
        }
        if (c5.isSelected()){
            facility = facility +"E-mail & SMS Alert";
        }
        if (c6.isSelected()){
            facility = facility +"E-Statement";
        }

        try{
            if (ae.getSource() == cancel){
                setVisible(false);
                new Login().setVisible(true);
            }else if(acSelect.equals("")){
                JOptionPane.showMessageDialog(null,"Account Type is required.");
            }else if(c7.isSelected()) {
                if(ae.getSource() == submit) {
                    Connect c = new Connect();
                    String query3 = "insert into SignUpForm3 values('" + formNo + "','" + acSelect + "','" + cardNo + "','" + pinNo + "','" + facility + "')";
                    String query4 = "insert into login values('" + formNo + "','" + cardNo + "','" + pinNo + "')";
                    c.stmt.executeUpdate(query3);
                    c.stmt.executeUpdate(query4);
                    setVisible(false);
                    new Login().setVisible(true);
                    JOptionPane.showMessageDialog(null, "Card Number:" + cardNo + "\n Pin: " + pinNo);

                }
            }else{

                JOptionPane.showMessageDialog(null,"Please select the checkbox.");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new SignUp3("");
    }
}
