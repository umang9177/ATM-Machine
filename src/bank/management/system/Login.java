package bank.management.system;
import  javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JButton logIn,clear,signUp,exit;
    JTextField cardTF;
    JPasswordField pinTF;

    Login(){

        setTitle("Automated Teller Machine");
        setLayout(null);
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("image/logo2.png"));
        Image img2 = img1.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel label = new JLabel(img1);
        label.setBounds(20,15,200,100);
        add(label);
        setSize(600,400);
        setUndecorated(true);
        setVisible(true);
        setLocation(475,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel text = new JLabel("Welcome to ATM Machine");
        text.setFont(new Font("ARIEL",Font.BOLD,25));
        text.setBounds(170,45,350,40);
        add(text);

        JLabel cardNo = new JLabel("Card No:");
        cardNo.setFont(new Font("ARIEL",Font.BOLD,16));
        cardNo.setBounds(125,100,200,100);
        add(cardNo);

        JLabel pin = new JLabel("PIN No:");
        pin.setFont(new Font("ARIEL",Font.BOLD,16));
        pin.setBounds(125,135,200,100);
        add(pin);

        cardTF = new JTextField();
        cardTF.setBounds(215,140,175,20);
        add(cardTF);

        pinTF = new JPasswordField();
        pinTF.setBounds(215,175,175,20);
        add(pinTF);

        logIn = new JButton("Log In");
        logIn.setBounds(215,200,80,20);
        logIn.setBackground(Color.BLACK);
        logIn.setForeground(Color.WHITE);
        logIn.addActionListener(this);
        add(logIn);

        clear = new JButton("Clear");
        clear.setBounds(310,200,80,20);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signUp = new JButton("SignUp");
        signUp.setBounds(215,225,80,20);
        signUp.setBackground(Color.BLACK);
        signUp.setForeground(Color.WHITE);
        signUp.addActionListener(this);
        add(signUp);

        exit = new JButton("Exit");
        exit.setBounds(310,225,80,20);
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.WHITE);
        exit.addActionListener(this);
        add(exit);

        getContentPane().setBackground(Color.WHITE); // keep it on last row to be able to see all the content
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == logIn) {

            Connect conn = new Connect();
            String cardNo = cardTF.getText();
            char[] passwordChar = pinTF.getPassword(); // to read from password field,where use of getText is depricated.
            String pinNo = new String(passwordChar);
            String query = "select * from login where CardNo = '" + cardNo + "' and PinNo = '" + pinNo + "'";

            try {
                ResultSet rs = conn.stmt.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Transactions(pinNo).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card No or PIN.");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == clear) {
                cardTF.setText("");
                pinTF.setText("");
            } else if (ae.getSource() == signUp) {
                setVisible(false);
                new SignUp1().setVisible(true);
            } else if (ae.getSource() == exit) {
                System.exit(0);
            }

        }

        public static void main (String[]args){
            new Login();
        }
    }
