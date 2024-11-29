package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {

    JFrame frame;
    JLabel text;
    JButton deposit,fastCash,pinChange,cashWd,miniStmnt,balInq,exit;
    String PinNo;

    Transactions(String PinNO){
        this.PinNo = PinNO;

        setSize(550,550);
        setLocation(500,100);
        setUndecorated(true);
        setVisible(true);
        setTitle("Welcome to ATM Machine");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);


        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("image/atm.png"));
        Image img2 = img1.getImage().getScaledInstance(800,650,Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel imageatm = new JLabel(img3);
        imageatm.setBounds(0,0,550,550);
        add(imageatm);

        text = new JLabel("Please select your Transaction");
        text.setBounds(150,130,500,20);
        text.setFont(new Font("Railway",Font.BOLD,16));
        text.setForeground(Color.WHITE);
        imageatm.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(50,180,100,20);
        deposit.setBackground(Color.white);
        deposit.setForeground(Color.black);
        deposit.addActionListener(this);
        imageatm.add(deposit);

        fastCash = new JButton("FastCash");
        fastCash.setBounds(50,210,100,20);
        fastCash.setBackground(Color.white);
        fastCash.setForeground(Color.black);
        fastCash.addActionListener(this);
        imageatm.add(fastCash);

        pinChange = new JButton("Pin Change");
        pinChange.setBounds(50,240,100,20);
        pinChange.setBackground(Color.white);
        pinChange.setForeground(Color.black);
        pinChange.addActionListener(this);
        imageatm.add(pinChange);

        cashWd = new JButton("Cash Withdrawl");
        cashWd.setBounds(370,180,130,20);
        cashWd.setBackground(Color.white);
        cashWd.setForeground(Color.black);
        cashWd.addActionListener(this);
        imageatm.add(cashWd);

        miniStmnt = new JButton("Mini Statement");
        miniStmnt.setBounds(370,210,130,20);
        miniStmnt.setBackground(Color.white);
        miniStmnt.setForeground(Color.black);
        miniStmnt.addActionListener(this);
        imageatm.add(miniStmnt);

        balInq = new JButton("Balance Enquiry");
        balInq.setBounds(370,240,130,20);
        balInq.setBackground(Color.white);
        balInq.setForeground(Color.black);
        balInq.addActionListener(this);
        imageatm.add(balInq);

        exit = new JButton("Exit");
        exit.setBounds(370,270,130,20);
        exit.setBackground(Color.white);
        exit.setForeground(Color.black);
        exit.addActionListener(this);
        imageatm.add(exit);

        getContentPane().setBackground(Color.WHITE);
    }

    public void actionPerformed (ActionEvent ae){

        if(ae.getSource() == exit){
            setVisible(false);
            new Login().setVisible(true);
            //System.exit(0);
        }else if(ae.getSource() == deposit){
            setVisible(false);
            new Deposit(PinNo).setVisible(true);
        }else if(ae.getSource() == cashWd){
            setVisible(false);
            new Withdraw(PinNo).setVisible(true);
        }else if(ae.getSource() == fastCash){
            setVisible(false);
            new FastCash(PinNo).setVisible(true);
        }
        else if(ae.getSource() == pinChange){
            setVisible(false);
            new PinChange(PinNo).setVisible(true);
        }else if(ae.getSource() == balInq){
            setVisible(false);
            new BalanceEnquiry(PinNo).setVisible(true);
        }else if(ae.getSource() == miniStmnt){

            new MiniStatement(PinNo).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Transactions("");
    }
}


