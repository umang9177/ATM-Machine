package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame {
    String PinNO;
    int bal1;
    MiniStatement(String PinNo){

        this.PinNO = PinNo;

        setSize(350, 400);
        setLocation(10, 10);
        setVisible(true);
        setLayout(null);

        JLabel bank = new JLabel("State Bank of Baroda");
        bank.setBounds(80,20,200,20);
        bank.setFont(new Font("Railway",Font.BOLD,14));
        add(bank);

        JLabel card= new JLabel();
        card.setBounds(20,60,200,20);
        card.setFont(new Font("Railway",Font.BOLD,12));
        add(card);

        JLabel mini = new JLabel();
        mini.setBounds(20,70,300,200);
        mini.setFont(new Font("Railway",Font.BOLD,10));
        add(mini);

        JLabel balance = new JLabel();
        balance.setBounds(20,250,300,12);
        add(balance);

        try{
            Connect connect = new Connect();
            ResultSet rs = connect.stmt.executeQuery("select * from login where PinNo ='"+PinNo+"'");
            while(rs.next()){
                card.setText("Card No : "+ rs.getString("CardNo").substring(0,4)+"XXXXXXXX"+rs.getString("CardNo").substring(12));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        // try block to print last 5 transections
        try{
            Connect connect = new Connect();
            //int bal = 0;
            ResultSet rs = connect.stmt.executeQuery("select * from bank where PinNo = '"+PinNo+"' order by date desc limit 5");
            int bal = 0;
            while(rs.next()){
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("Type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("Amount") + "<br><br><html>");

                if(rs.getString("Type").equals("Deposit")){
                    bal += Integer.parseInt(rs.getString("Amount"));
                }else{
                    bal -= Integer.parseInt(rs.getString("Amount"));
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }

        // try block to print total balance in ministatement
        try{
            Connect connect = new Connect();
            bal1 = 0;
            ResultSet rs = connect.stmt.executeQuery("select * from bank where PinNo = '"+PinNo+"'");
            while(rs.next()){
                if(rs.getString("Type").equals("Deposit")){
                    bal1 += Integer.parseInt(rs.getString("Amount"));
                }else{
                    bal1 -= Integer.parseInt(rs.getString("Amount"));
                }
            }
            balance.setText("Your account balance is Rs" + bal1);
        }catch (Exception e){
            System.out.println(e);
        }
        getContentPane().setBackground(Color.WHITE);
    }

    public static void main(String[] args) {
        new MiniStatement("");
    }
}

