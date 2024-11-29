package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.ResultSet;
import java.util.Date;


public class FastCash extends JFrame implements ActionListener {

    JLabel text;
    JButton deposit,cashWd,back,opt1,opt2,opt3,opt4,opt5,opt6;
    String PinNo;

    FastCash(String PinNO){
        this.PinNo = PinNO;

        setSize(550,550);
        setLocation(500,100);
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);


        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("image/atm.png"));
        Image img2 = img1.getImage().getScaledInstance(800,650,Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel imageatm = new JLabel(img3);
        imageatm.setBounds(0,0,550,550);
        add(imageatm);

        text = new JLabel("Select withdrawl amount");
        text.setBounds(170,130,500,20);
        text.setFont(new Font("Railway",Font.BOLD,16));
        text.setForeground(Color.WHITE);
        imageatm.add(text);

        opt1 = new JButton("Rs 100");
        opt1.setBounds(50,180,100,20);
        opt1.setBackground(Color.white);
        opt1.setForeground(Color.black);
        opt1.addActionListener(this);
        imageatm.add(opt1);

        opt2 = new JButton("Rs 500");
        opt2.setBounds(50,210,100,20);
        opt2.setBackground(Color.white);
        opt2.setForeground(Color.black);
        opt2.addActionListener(this);
        imageatm.add(opt2);

        opt3 = new JButton("Rs 1000");
        opt3.setBounds(50,210,100,20);
        opt3.setBackground(Color.white);
        opt3.setForeground(Color.black);
        opt3.addActionListener(this);
        imageatm.add(opt3);

        opt4 = new JButton("Rs 2000");
        opt4.setBounds(370,180,130,20);
        opt4.setBackground(Color.white);
        opt4.setForeground(Color.black);
        opt4.addActionListener(this);
        imageatm.add(opt4);

        opt5 = new JButton("Rs 5000");
        opt5.setBounds(370,210,130,20);
        opt5.setBackground(Color.white);
        opt5.setForeground(Color.black);
        opt5.addActionListener(this);
        imageatm.add(opt5);

        opt6 = new JButton("Rs 10000");
        opt6.setBounds(370,240,130,20);
        opt6.setBackground(Color.white);
        opt6.setForeground(Color.black);
        opt6.addActionListener(this);
        imageatm.add(opt6);

        back = new JButton("Back");
        back.setBounds(370,270,130,20);
        back.setBackground(Color.white);
        back.setForeground(Color.black);
        back.addActionListener(this);
        imageatm.add(back);

        getContentPane().setBackground(Color.WHITE);
    }

    public void actionPerformed (ActionEvent ae){

        if(ae.getSource() == back){
            setVisible(false);
            new Transactions(PinNo).setVisible(true);
        }else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Connect conn = new Connect();
            try{
                ResultSet rs = conn.stmt.executeQuery("select * from bank where PinNo = '"+PinNo+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("Type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("Amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("Amount"));
                    }
                }
                if(ae.getSource() != back && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance.");
                    return;
                }

                Date date = new Date();
                String query = "insert into bank values('"+PinNo+"','"+date+"','Withdraw','"+amount+"')";
                conn.stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs"+amount+"debited successfully.");
                setVisible(false);
                new Transactions(PinNo).setVisible(true);
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        new FastCash("");
    }
}

