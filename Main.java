import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Busqueda de estudiantes");
        frame.setContentPane(new form1().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,200);
        frame.pack();
        frame.setVisible(true);

        System.out.println("Cedula ingresada: " + consultaTxt.getTxt());
        }
    }
