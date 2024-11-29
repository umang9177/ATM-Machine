package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public  class SignUp1 extends JFrame implements ActionListener {

    long random;
    JLabel heading, personalInfo, name, fname, lastName, dob, gender, marital, address, city, state, pincode, email;
    JTextField nameTF, fNameTF, lastNameTF, emailTF, addressTF, cityTF, stateTF, pincodeTF;
    JRadioButton male, female, otherGen;
    JRadioButton married, unmarried, other;
    JButton next;
    ButtonGroup genderGroup, marGroup;
    JComboBox comboBoxDate, comboBoxMonth, comboBoxYear;


    SignUp1() {

        setSize(800, 550);
        setLocation(400, 150);
        setUndecorated(true);
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        Random ran = new Random();
        long random = Math.abs((ran.nextLong() % 9000L) + 1000L); // for generating random number
        heading = new JLabel("New Application Form No :" + random);
        heading.setFont(new Font("Railway", Font.BOLD, 20));
        heading.setBounds(260, 20, 600, 40);
        add(heading);

        personalInfo = new JLabel("Page-1: Personal Information");
        personalInfo.setFont(new Font("ARIEL",Font.BOLD,18));
        personalInfo.setBounds(275,55,400,20);
        add(personalInfo);

        name = new JLabel("Name: ");
        name.setFont(new Font("Railway", Font.BOLD, 20));
        name.setBounds(100, 110, 100, 30);
        add(name);

        fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Railway", Font.BOLD, 20));
        fname.setBounds(100, 140, 200, 30);
        add(fname);

        lastName = new JLabel("Last Name: ");
        lastName.setFont(new Font("Railway", Font.BOLD, 20));
        lastName.setBounds(100, 170, 200, 30);
        add(lastName);

        dob = new JLabel("Date Of Birth:");
        dob.setFont(new Font("Railway", Font.BOLD, 20));
        dob.setBounds(100, 200, 150, 30);
        add(dob);

        email = new JLabel("Email:");
        email.setFont(new Font("Railway", Font.BOLD, 20));
        email.setBounds(100, 230, 200, 30);
        add(email);

        gender = new JLabel("Gender:");
        gender.setFont(new Font("Railway", Font.BOLD, 20));
        gender.setBounds(100, 260, 200, 30);
        add(gender);

        marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Railway", Font.BOLD, 20));
        marital.setBounds(100, 290, 200, 30);
        add(marital);

        address = new JLabel("Address:");
        address.setFont(new Font("Railway", Font.BOLD, 20));
        address.setBounds(100, 320, 200, 30);
        add(address);

        city = new JLabel("City:");
        city.setFont(new Font("Railway", Font.BOLD, 20));
        city.setBounds(100, 350, 200, 30);
        add(city);

        state = new JLabel("State:");
        state.setFont(new Font("Railway", Font.BOLD, 20));
        state.setBounds(100, 380, 200, 30);
        add(state);

        pincode = new JLabel("Pincode:");
        pincode.setFont(new Font("Railway", Font.BOLD, 20));
        pincode.setBounds(100, 410, 200, 30);
        add(pincode);

        nameTF = new JTextField();
        nameTF.setFont(new Font("Railway", Font.PLAIN, 18));
        nameTF.setBounds(275, 115, 325, 25);
        add(nameTF);

        fNameTF = new JTextField();
        fNameTF.setFont(new Font("Railway", Font.PLAIN, 18));
        fNameTF.setBounds(275, 145, 325, 25);
        add(fNameTF);

        lastNameTF = new JTextField();
        lastNameTF.setFont(new Font("Railway", Font.PLAIN, 18));
        lastNameTF.setBounds(275, 175, 325, 25);
        add(lastNameTF);

        emailTF = new JTextField();
        emailTF.setFont(new Font("Railway", Font.PLAIN, 18));
        emailTF.setBounds(275, 235, 325, 25);
        add(emailTF);

        addressTF = new JTextField();
        addressTF.setFont(new Font("Railway", Font.PLAIN, 18));
        addressTF.setBounds(275, 325, 325, 25);
        add(addressTF);

        cityTF = new JTextField();
        cityTF.setFont(new Font("Railway", Font.PLAIN, 18));
        cityTF.setBounds(275, 355, 325, 25);
        add(cityTF);

        stateTF = new JTextField();
        stateTF.setFont(new Font("Railway", Font.PLAIN, 18));
        stateTF.setBounds(275, 385, 325, 25);
        add(stateTF);

        pincodeTF = new JTextField();
        pincodeTF.setFont(new Font("Railway", Font.PLAIN, 18));
        pincodeTF.setBounds(275, 415, 325, 25);
        add(pincodeTF);

        String days[] = {"Select Date", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        String months[] = {"Select Month", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        String years[] = {"Select Year", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980"};

        comboBoxDate = new JComboBox(days);
        comboBoxMonth = new JComboBox(months);
        comboBoxYear = new JComboBox(years);

        comboBoxDate.setBounds(275, 205, 105, 25);
        comboBoxMonth.setBounds(385, 205, 105, 25);
        comboBoxYear.setBounds(495, 205, 105, 25);

        add(comboBoxDate);
        add(comboBoxMonth);
        add(comboBoxYear);

        // radio button for gender

        male = new JRadioButton("Male");
        male.setBounds(300, 265, 100, 25);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(400, 265, 100, 25);
        female.setBackground(Color.WHITE);
        add(female);

        otherGen = new JRadioButton("Other");
        otherGen.setBounds(500, 265, 100, 25);
        otherGen.setBackground(Color.WHITE);
        add(otherGen);

        genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(otherGen);

        // radio button for marital status

        married = new JRadioButton("Married");
        married.setBounds(300, 295, 100, 25);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(400, 295, 100, 25);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        other = new JRadioButton("Other");
        other.setBounds(500, 295, 100, 25);
        other.setBackground(Color.WHITE);
        add(other);

        marGroup = new ButtonGroup();
        marGroup.add(married);
        marGroup.add(unmarried);
        marGroup.add(other);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Railway", Font.BOLD, 12));
        next.setBounds(530, 455, 70, 20);
        next.addActionListener(this);
        add(next);


        getContentPane().setBackground(Color.white);


    }


    @Override
    public void actionPerformed(ActionEvent ae) {

        String formNo = String.valueOf(random); // to convert from long to string
        String name = nameTF.getText();
        String fName = fNameTF.getText();
        String lastName = lastNameTF.getText();
        String dob = comboBoxDate.getSelectedItem().toString() + "-" + comboBoxMonth.getSelectedItem().toString() + "-" + comboBoxYear.getSelectedItem().toString();
        String email = emailTF.getText();
        String address = addressTF.getText();
        String pincode = pincodeTF.getText();
        String city = cityTF.getText();
        String state = stateTF.getText();

        String gender = null;
        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        } else if (other.isSelected()) {
            gender = "Other";
        }

        String marStatus = null;
        if (married.isSelected()) {
            marStatus = "Married";
        } else if (unmarried.isSelected()) {
            marStatus = "Unmarried";
        } else if (other.isSelected()) {
            marStatus = "Other";
        }

        if (ae.getSource() == next) {

            //  setVisible(false);
            //new SignUpTwo().setVisible(true);
            //}

            try {
                if (name.equals("")) {
                    JOptionPane.showMessageDialog(null, "Name is Required.");
                } else if (gender.equals("")) {
                    JOptionPane.showMessageDialog(null, "Gender is required.");
                } else if (pincode.equals("")) {
                    JOptionPane.showMessageDialog(null, "Pincode is required.");
                } else if (city.equals("")) {
                    JOptionPane.showMessageDialog(null, "City is required.");
                } else if (state.equals("")) {
                    JOptionPane.showMessageDialog(null, "State is required.");
                } else if (email.equals("")) {
                    JOptionPane.showMessageDialog(null, "E-Mail is required.");
                } else if (comboBoxDate.equals("Select Date")) {
                    JOptionPane.showMessageDialog(null, "Please Select Date.");
                } else if (comboBoxMonth.equals("Select Month")) {
                    JOptionPane.showMessageDialog(null, "Please Select Month.");
                } else if (comboBoxMonth.equals(comboBoxMonth.getSelectedItem() == "February" && comboBoxDate.getSelectedItem() == "30")) {
                    JOptionPane.showMessageDialog(null, "Please Select Correct Date.");
                } else if (comboBoxMonth.equals(comboBoxMonth.getSelectedItem() == "February" && comboBoxDate.getSelectedItem() == "31")) {
                    JOptionPane.showMessageDialog(null, "Please Select Correct Date.");
                } else if (comboBoxYear.equals("Select Year")) {
                    JOptionPane.showMessageDialog(null, "Please Select Year.");
                } else {
                    Connect c = new Connect();
                    String query = "insert into SignUpForm1 values('"+formNo+"','" + name + "','" + fName + "','" + lastName + "','" + dob + "','" + gender + "','" + marStatus + "','" + email + "','" + address + "','" + city + "','" + state + "','" + pincode + "')";
                    c.stmt.executeUpdate(query);

                    setVisible(false); // this will take us to form 2 after filling all required details and clicking next
                    new SignUp2(formNo).setVisible(true);
                }
            } catch (Exception e) {

                System.out.println(e);
            }

        }
    }

        public static void main (String[]args){
            SignUp1 sg1 = new SignUp1();
        }

}