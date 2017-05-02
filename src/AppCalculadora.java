import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by hoffsilva on 02/05/17.
 */
public class AppCalculadora extends JFrame {

    public double getValue1() {
        return value1;
    }

    public void setValue1(double value1) {
        this.value1 = value1;
    }

    public double getValue2() {
        return value2;
    }

    public void setValue2(double value2) {
        this.value2 = value2;
    }

    double value1 = 0;
    double value2 = 0;

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    String operator = "";


    public AppCalculadora() {

        initComponents();

    }

    private void initComponents(){
        // I find it easier to create a panel and SET it as the content pane
        JPanel gui = new JPanel(new BorderLayout(5,5));
        // add some padding to the main GUI
        gui.setBorder(new EmptyBorder(4,4,4,4));

        // not needed if only a single compoinent is to be added!
        //JPanel panelScreen = new JPanel(new GridLayout(0,1));

        // add some constraints to make the output field bigger.
        // if it is intended to be single line, a JTextField should be used.
        JTextArea screen = new JTextArea(1,25);
        gui.add(screen, BorderLayout.NORTH);
        //panelScreen.add(screen);

        JFrame frame = new JFrame("CALCULATOR");
        frame.setContentPane(gui);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // add padding around the buttons
        JPanel panelButtons = new JPanel(new GridLayout(6,3,4,4));

        JButton oneButton = new JButton("1");
        panelButtons.add(oneButton);
        oneButton.addActionListener((ActionEvent event) -> {
            screen.append("1");
        });

        JButton twoButton = new JButton("2");
        panelButtons.add(twoButton);
        twoButton.addActionListener((ActionEvent event) -> {
            screen.append("2");
        });

        JButton threeButton = new JButton("3");
        panelButtons.add(threeButton);
        threeButton.addActionListener((ActionEvent event) -> {
            screen.append("3");
        });

        JButton fourButton = new JButton("4");
        panelButtons.add(fourButton);
        fourButton.addActionListener((ActionEvent event) -> {
            screen.append("4");
        });

        JButton fiveButton = new JButton("5");
        panelButtons.add(fiveButton);
        fiveButton.addActionListener((ActionEvent event) -> {
            screen.append("5");
        });

        JButton sixButton = new JButton("6");
        panelButtons.add(sixButton);
        sixButton.addActionListener((ActionEvent event) -> {
            screen.append("6");
        });

        JButton sevenButton = new JButton("7");
        panelButtons.add(sevenButton);
        sevenButton.addActionListener((ActionEvent event) -> {
            screen.append("7");
        });

        JButton eightButton = new JButton("8");
        panelButtons.add(eightButton);
        eightButton.addActionListener((ActionEvent event) -> {
            screen.append("8");
        });

        JButton nineButton = new JButton("9");
        panelButtons.add(nineButton);
        nineButton.addActionListener((ActionEvent event) -> {
            screen.append("9");
        });

        JButton zeroButton = new JButton("0");
        panelButtons.add(zeroButton);
        zeroButton.addActionListener((ActionEvent event) -> {
            screen.append("0");
        });

        JButton commaButton = new JButton(",");
        panelButtons.add(commaButton);
        commaButton.addActionListener((ActionEvent event) -> {
            screen.append(".");
        });

        JButton sum = new JButton("+");
        panelButtons.add(sum);
        sum.addActionListener((ActionEvent event) -> {
            setValue1(Double.parseDouble(screen.getText()));
            System.out.print(getValue1());
            setOperator("+");
            screen.setText("");
        });

        JButton sub = new JButton("-");
        panelButtons.add(sub);
        sub.addActionListener((ActionEvent event) -> {
            setValue1(Double.parseDouble(screen.getText()));
            System.out.print(getValue1());
            setOperator("-");
            screen.setText("");
        });

        JButton divide = new JButton("/");
        panelButtons.add(divide);
        divide.addActionListener((ActionEvent event) -> {
            setValue1(Double.parseDouble(screen.getText()));
            System.out.print(getValue1());
            setOperator("/");
            screen.setText("");
        });

        JButton mult = new JButton("*");
        panelButtons.add(mult);
        mult.addActionListener((ActionEvent event) -> {
            setValue1(Double.parseDouble(screen.getText()));
            System.out.print(getValue1());
            setOperator("*");
            screen.setText("");
        });

        JButton equal = new JButton("=");
        panelButtons.add(equal);
        equal.addActionListener((ActionEvent event) -> {
            setValue2(Double.parseDouble(screen.getText()));
            screen.setText(performCalc(getValue1(), getValue2(), getOperator()));
        });

        JButton clear = new JButton("C");
        panelButtons.add(clear);
        clear.addActionListener((ActionEvent event) -> {
            screen.setText("");
        });

        //frame.getContentPane().add(new JSeparator(), BorderLayout.CENTER);

        // Add the buttons to the CENTER and they will
        // fill whatever space they are provided.
        gui.add(panelButtons, BorderLayout.CENTER);
        //frame.setBounds(50, 50, 500, 500);
        //frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }

    public String performCalc(double value1, double value2, String operator) {

        String retorno = "";

        if (operator.equals("+")) {
            double sum = value1 + value2;
            retorno = (""+ sum);
        } else if (operator.equals("-")) {
            double sub = value1 - value2;
            retorno =  (""+ sub);
        } else if (operator.equals("*")) {
            double mult = value1 * value2;
            retorno =  (""+ mult);
        } else if (operator.equals("/")) {
            try {
                double divide = value1 / value2;
                retorno = ("" + divide);
            } catch (Exception e) {
                retorno =  e.getMessage();
            }
        }

        return retorno;
    }


    public static void main(String[] args) {
        // TODO code application logic here
        EventQueue.invokeLater(()->{
            AppCalculadora app = new AppCalculadora();
            app.setVisible(true);
        });

    }

}
