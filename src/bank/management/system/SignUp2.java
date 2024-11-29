package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SignUp2 extends JFrame implements ActionListener {

    JLabel heading,religion,catag,income,edq,occup,pan,adhar,existingAcc,senior;
    JComboBox religF,catF,edF,incomeF,occuF;
    JRadioButton citizenY,citizenN,exAcntY,exAcntN;
    ButtonGroup seniCiti,exAcnt;
    JTextField panTF,aadharTF;
    JButton next2;
    String formNo;

    SignUp2(String formNo){

        this.formNo = formNo;
        setSize(550,500);
        setLocation(500,125);
        setUndecorated(true);
        setVisible(true);
        setTitle("New Application Form : Page-2");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        heading = new JLabel("Page 2: Additional Details");
        heading.setFont(new Font("Railway",Font.BOLD,20));
        heading.setBounds(150,20,400,30);
        add(heading);

        religion = new JLabel("Religion:");
        religion.setFont(new Font("Railway",Font.BOLD,18));
        religion.setBounds(50,70,100,25);
        add(religion);

        catag = new JLabel("Catagory:");
        catag.setFont(new Font("Railway",Font.BOLD,18));
        catag.setBounds(50,100,100,25);
        add(catag);

        income = new JLabel("Income:");
        income.setFont(new Font("Railway",Font.BOLD,18));
        income.setBounds(50,130,100,25);
        add(income);

        edq = new JLabel("Educational Qualification:");
        edq.setFont(new Font("Railway",Font.BOLD,18));
        edq.setBounds(50,160,300,25);
        add(edq);

        occup = new JLabel("Occupation:");
        occup.setFont(new Font("Railway",Font.BOLD,18));
        occup.setBounds(50,190,200,25);
        add(occup);

        pan = new JLabel("PAN Number:");
        pan.setFont(new Font("Railway",Font.BOLD,18));
        pan.setBounds(50,220,200,25);
        add(pan);

        adhar = new JLabel("Aadhar Card Number:");
        adhar.setFont(new Font("Railway",Font.BOLD,18));
        adhar.setBounds(50,250,300,25);
        add(adhar);

        senior = new JLabel("Senior Citizen:");
        senior.setFont(new Font("Railway",Font.BOLD,18));
        senior.setBounds(50,280,300,25);
        add(senior);

        existingAcc = new JLabel("Existing Account:");
        existingAcc.setFont(new Font("Railway",Font.BOLD,18));
        existingAcc.setBounds(50,310,300,25);
        add(existingAcc);


        String reli[] = {"Select Religion","Hindu","Jain","Parsi","Christian","Muslim","Sikh"};
        String cat[] ={"Select Catagory","General","SC","ST","OBC","Other"};
        String income[]= {"Select Income","Less than 2,50,000","2,50,000 - 5,00,000","5,00,000-10,00,000","More than 10,00,000"};
        String occu[] = {"Select Occupation","Salaried","Businessman","Unemployed","Self-Employed"};
        String edQ[] = {"Select Qualification","PhD","Graduate","Diploma","10th Pass","Non-Graduate"};


        religF= new JComboBox(reli);
        catF = new JComboBox(cat);
        incomeF = new JComboBox(income);
        occuF = new JComboBox(occu);
        edF = new JComboBox(edQ);

        religF.setBounds(300,70,150,20);
        catF.setBounds(300,100,150,20);
        incomeF.setBounds(300,130,150,20);
        occuF.setBounds(300,190,150,20);
        edF.setBounds(300,160,150,20);

        add(religF);
        add(catF);
        add(incomeF);
        add(occuF);
        add(edF);

        citizenY = new JRadioButton("Yes");
        citizenY.setBounds(300,280,75,20);
        citizenY.setBackground(Color.WHITE);
        add(citizenY);

        citizenN = new JRadioButton("No");
        citizenN.setBounds(375,280,75,20);
        citizenN.setBackground(Color.WHITE);
        add(citizenN);

        exAcntY = new JRadioButton("Yes");
        exAcntY.setBounds(300,310,75,20);
        exAcntY.setBackground(Color.WHITE);
        add(exAcntY);

        exAcntN = new JRadioButton("No");
        exAcntN.setBounds(375,310,75,20);
        exAcntN.setBackground(Color.WHITE);
        add(exAcntN);

        seniCiti = new ButtonGroup();
        seniCiti.add(citizenN);
        seniCiti.add(citizenY);

        exAcnt = new ButtonGroup();
        exAcnt.add(exAcntN);
        exAcnt.add(exAcntY);

        panTF = new JTextField();
        panTF.setBounds(300,220,150,20);
        panTF.setFont(new Font("Railway", Font.PLAIN,16));
        add(panTF);

        aadharTF = new JTextField();
        aadharTF.setBounds(300,250,150,20);
        aadharTF.setFont(new Font("Railway",Font.PLAIN,16));
        add(aadharTF);

        next2 = new JButton("Next");
        next2.setBackground(Color.BLACK);
        next2.setForeground(Color.WHITE);
        next2.setFont(new Font("Railway",Font.BOLD,12));
        next2.setBounds(375,365,70,20);
        next2.addActionListener(this);
        add(next2);


        getContentPane().setBackground(Color.WHITE);
    }

    public void actionPerformed(ActionEvent ae){

        String sReligion = religF.getSelectedItem().toString();
        String sCatagory = catF.getSelectedItem().toString();
        String sIncome = incomeF.getSelectedItem().toString();
        String sEduQua = edF.getSelectedItem().toString();
        String sOccup = occuF.getSelectedItem().toString();
        String sAadhar = aadharTF.getText();
        String sPan = panTF.getText();

        String seniCiti = null;
        if (citizenY.isSelected()){
            seniCiti = "Yes";
        }
        else if (citizenN.isSelected()){
            seniCiti = "No";
        }

        String exAcc = null;
        if (exAcntY.isSelected()){
            exAcc = "Yes";
        } else if (exAcntN.isSelected()){
            exAcc = "No";
        }
        try{
            // to be continued from here
            if(religion.equals("")){
                JOptionPane.showMessageDialog(null,"Religion is Required.");
            }
            if(sCatagory.equals("")){
                JOptionPane.showMessageDialog(null,"Catagory is Required.");
            }
            if(income.equals("")){
                JOptionPane.showMessageDialog(null,"Income is Required.");
            }
            else{
                Connect c = new Connect();
                String query2 = "insert into SignUpForm2 values('"+formNo+"','"+sReligion+"','"+sCatagory+"','"+sIncome+"','"+sEduQua+"','"+sOccup+"','"+sAadhar+"','"+sPan+"','"+seniCiti+"','"+exAcc+"')";
                c.stmt.executeUpdate(query2);
            }

            setVisible(false);
            new SignUp3(formNo).setVisible(true);

        }catch(Exception e){
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        new SignUp2("");
    }
}

