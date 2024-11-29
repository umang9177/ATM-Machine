package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {

    String PinNO;
    JLabel imageatm,text,text1;
    JButton back;
    int balance;
    BalanceEnquiry(String PinNo){
        this.PinNO = PinNo;

        setSize(550,550);
        setLocation(500,100);
        setUndecorated(true);
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("image/atm.png"));
        Image img2 = img1.getImage().getScaledInstance(800,650,Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        imageatm = new JLabel(img3);
        imageatm.setBounds(0,0,550,550);
        add(imageatm);

        back = new JButton("Back");
        back.setBounds(390, 250, 100, 20);
        back.setBackground(Color.white);
        back.setForeground(Color.black);
        back.addActionListener(this);
        imageatm.add(back);

        Connect conn = new Connect();
        try{
            ResultSet rs = conn.stmt.executeQuery("select * from bank where PinNo = '"+PinNo+"'");
            balance = 0;
            while(rs.next()) {
                if (rs.getString("Type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("Amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("Amount"));
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }

        text = new JLabel("Your Account balance is Rs "+ balance);
        text.setBounds(200, 150, 250, 20);
        text.setForeground(Color.WHITE);
        text.setBackground(Color.BLACK);
        imageatm.add(text);

        text1 = new JLabel("Thank You. Please Visit Again.");
        text1.setBounds(200, 175, 250, 20);
        text1.setForeground(Color.WHITE);
        text1.setBackground(Color.BLACK);
        imageatm.add(text1);

        getContentPane().setBackground(Color.WHITE);
    }

    public void actionPerformed (ActionEvent ae){
        if(ae.getSource() == back)
            setVisible(false);
        new Transactions(PinNO).setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("");

    }
}

