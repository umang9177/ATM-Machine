package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {

    JLabel text, rePinText, pinText;
    JPasswordField pinTF, rePinTF;
    JButton change, back;
    String PinNo;
    PinChange(String PinNo) {

        this.PinNo = PinNo;
        setSize(550,550);
        setLocation(500, 100);
        setUndecorated(true);
        setVisible(true);
        setTitle("Welcome to ATM Machine");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);


        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("image/atm.png"));
        Image img2 = img1.getImage().getScaledInstance(800, 650, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel imageatm = new JLabel(img3);
        imageatm.setBounds(0, 0, 550, 550);
        add(imageatm);

        text = new JLabel("Change Your PIN");
        text.setBounds(200, 130, 500, 20);
        text.setFont(new Font("Railway", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        imageatm.add(text);

        pinText = new JLabel("New PIN:");
        pinText.setBounds(50, 170, 200, 20);
        pinText.setFont(new Font("Railway", Font.BOLD, 16));
        pinText.setForeground(Color.WHITE);
        imageatm.add(pinText);

        rePinText = new JLabel("Re-Enter your New PIN:");
        rePinText.setBounds(50, 200, 200, 20);
        rePinText.setFont(new Font("Railway", Font.BOLD, 16));
        rePinText.setForeground(Color.WHITE);
        imageatm.add(rePinText);

        pinTF = new JPasswordField();
        pinTF.setFont(new Font("Railway", Font.BOLD, 12));
        pinTF.setBounds(250, 170, 100, 20);
        imageatm.add(pinTF);

        rePinTF = new JPasswordField();
        rePinTF.setFont(new Font("Railway", Font.BOLD, 12));
        rePinTF.setBounds(250, 200, 100, 20);
        imageatm.add(rePinTF);

        change = new JButton("Change");
        change.setBounds(390, 240, 100, 20);
        change.setBackground(Color.white);
        change.setForeground(Color.black);
        change.addActionListener(this);
        imageatm.add(change);

        back = new JButton("Back");
        back.setBounds(390, 270, 100, 20);
        back.setBackground(Color.white);
        back.setForeground(Color.black);
        back.addActionListener(this);
        imageatm.add(back);


        getContentPane().setBackground(Color.WHITE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == change) {
            try {
                char[] pinChar = pinTF.getPassword();
                char[] rePinChar = rePinTF.getPassword();
                String nPin = new String(pinChar);
                String rePin = new String(rePinChar);


                if(nPin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter the new PIN.");
                }
                else if(rePin.equals("")){
                    JOptionPane.showMessageDialog(null,"No Input! Please enter the new PIN.");
                }
                else if (!nPin.equals(rePin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match.Please try again!");
                }

                Connect connect = new Connect();
                String query1 = "update bank set PinNo = '"+rePin+"' where PinNo = '"+PinNo+"'";
                String query2 = "update Login set PinNo = '"+rePin+"' where PinNo = '"+PinNo+"'";
                String query3 = "update SignUpForm3 set PinNo = '"+rePin+"' where PinNo = '"+PinNo+"'";

                connect.stmt.executeUpdate(query1);
                connect.stmt.executeUpdate(query2);
                connect.stmt.executeUpdate(query3);

                JOptionPane.showMessageDialog(null,"Your PIN change successfully.");

            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            setVisible(false);
            new Transactions("").setVisible(true);
        }
    }

    public static void main(String[] args) {
        new PinChange("");
    }
}

