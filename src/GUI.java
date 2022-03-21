import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    JFrame frame = new JFrame("Client control");
    JPanel main = new JPanel();

    JPanel ipRow = new JPanel();
    JTextField ipField = new JTextField(15);
    JButton ipButton = new JButton("Connect");

    JPanel primesRow = new JPanel();
    JTextField primesMinField = new JTextField(10);
    JTextField primesMaxField = new JTextField(10);
    JButton primesButton = new JButton("Primes");

    JPanel distRow1 = new JPanel();
    JTextField lat1Field = new JTextField(10);
    JTextField lon1Field = new JTextField(10);

    JPanel distRow2 = new JPanel();
    JTextField lat2Field = new JTextField(10);
    JTextField lon2Field = new JTextField(10);
    JButton distButton = new JButton("Distance");

    JPanel handleRow = new JPanel();
    JTextField handle1Field = new JTextField(10);//string
    JTextField handle2Field = new JTextField(50);//string
    JTextField handle3Field = new JTextField(10);//double
    JTextField handle4Field = new JTextField(10);//int
    JButton handleButton = new JButton("Task");


    JPanel infoRow = new JPanel();
    JButton infoButton = new JButton("Show");
    JButton testButton = new JButton("Test");

    public GUI(){
        ipButton.addActionListener(buttonListener);
        primesButton.addActionListener(buttonListener);
        distButton.addActionListener(buttonListener);
        handleButton.addActionListener(buttonListener);
        infoButton.addActionListener(buttonListener);
        testButton.addActionListener(buttonListener);

        GridLayout verticalLayout = new GridLayout(0,1);
        main.setLayout(verticalLayout);

        ipRow.add(ipField);
        ipRow.add(ipButton);

        primesRow.add(primesMinField);
        primesRow.add(primesMaxField);
        primesRow.add(primesButton);
        main.add(primesRow);

        distRow1.add(lat1Field);
        distRow1.add(lon1Field);
        main.add(distRow1);

        distRow2.add(lat2Field);
        distRow2.add(lon2Field);
        distRow2.add(distButton);
        main.add(distRow2);

        handleRow.add(handle1Field);
        handleRow.add(handle2Field);
        handleRow.add(handle3Field);
        handleRow.add(handle4Field);
        handleRow.add(handleButton);
        main.add(handleRow);

        infoRow.add(infoButton);
        infoRow.add(testButton);
        main.add(infoRow);

        frame.add(main);
        frame.pack();
        frame.setVisible(true);
    }

    private ActionListener buttonListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Object src = e.getSource();
            try {
                if (src.equals(ipButton)) {
                    KlientRPC.connect(ipField.getText());
                } else if (src.equals(primesButton)) {
                    KlientRPC.primes(Integer.parseInt(primesMinField.getText()),Integer.parseInt(primesMaxField.getText()));
                } else if (src.equals(distButton)) {
                    KlientRPC.dist(Double.parseDouble(lat1Field.getText()),Double.parseDouble(lon1Field.getText()),Double.parseDouble(lat2Field.getText()),Double.parseDouble(lon2Field.getText()));
                } else if (src.equals(handleButton)) {
                    KlientRPC.task(handle1Field.getText(),handle2Field.getText(),Double.parseDouble(handle3Field.getText()),Integer.parseInt(handle4Field.getText()));
                } else if (src.equals(infoButton)) {
                    KlientRPC.show();
                } else if (src.equals(testButton)) {
                    KlientRPC.demo();
                } else {
                    throw new IllegalArgumentException("Unrecognized button");
                }
            } catch(Exception ex){
                System.err.println("Failed to process input");
                ex.printStackTrace();
            }
        }
    };
}


