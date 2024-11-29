package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Withdraw extends JFrame implements ActionListener {

    JLabel amt,imageatm;
    JTextField amtTF;
    JButton withdraw, back;
    String PinNo;

    Withdraw(String PinNO) {

        this.PinNo = PinNO;

        setSize(550,550);
        setLocation(500,100);
        setUndecorated(true);
        setVisible(true);
        setLayout(null);

        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("image/atm.png"));
        Image img2 = img1.getImage().getScaledInstance(800, 650, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        imageatm = new JLabel(img3);
        imageatm.setBounds(0, 0, 550, 550);
        add(imageatm);

        amt = new JLabel("Enter Amount to be Withdraw:");
        amt.setFont(new Font("Railway", Font.BOLD, 16));
        amt.setBounds(150, 150, 250, 20);
        amt.setForeground(Color.WHITE);
        imageatm.add(amt);

        amtTF = new JTextField();
        amtTF.setFont(new Font("Railway", Font.BOLD, 16));
        amtTF.setBounds(150, 175, 230, 20);
        imageatm.add(amtTF);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(390, 230, 100, 20);
        withdraw.setBackground(Color.white);
        withdraw.setForeground(Color.black);
        withdraw.addActionListener(this);
        imageatm.add(withdraw);

        back = new JButton("Back");
        back.setBounds(390, 260, 100, 20);
        back.setBackground(Color.white);
        back.setForeground(Color.black);
        back.addActionListener(this);
        imageatm.add(back);

        getContentPane().setBackground(Color.WHITE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == withdraw) {
            String number = amtTF.getText();
            Date date = new Date();
            int balance = 0;
            if (number.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount to withdraw");
            }else if(Integer.parseInt(number)< 0){
                JOptionPane.showMessageDialog(null,"Invalid amount.");
            }
            else {
                try {
                    Connect connect = new Connect();
                    String query = "insert into bank values('"+PinNo+"','"+date+"','Withdraw','"+number+"')";
                    connect.stmt.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Rs"+number+" withdrawed successfully in your account.");
                    setVisible(false);
                    new Transactions(PinNo).setVisible(true);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
        if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(PinNo).setVisible(true);
        }

    }

    public static void main (String[]args){
        new Withdraw("");
    }
}


