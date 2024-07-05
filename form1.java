import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class form1 {
    public JPanel mainPanel;
    private JButton okBtn;
    private JTextField consultaTxt;
    private JLabel resultadoTxt;

    public form1() {
        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Datos de conexión a la base de datos
                String url = "jdbc:mysql://localhost:3306/estudiantes";
                String user = "root";
                String password = "**";

                try (Connection connection = DriverManager.getConnection(url, user, password)) {
                    System.out.println("Conectando a la base de datos");

                    // Consulta SQL utilizando PreparedStatement para evitar inyecciones SQL
                    String query = "SELECT * FROM estudiante WHERE cedula = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setString(1, consultaTxt.getText());

                    ResultSet resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {
                        String nombre = resultSet.getString("nombre");
                        System.out.println(nombre);
                        resultadoTxt.setText(nombre);
                    } else {
                        resultadoTxt.setText("No encontrado");
                    }
                } catch (SQLException e1) {
                    System.out.println(e1);
                    resultadoTxt.setText("Error en la conexión");
                }
            }
        });
    }

    public static void main(String[] args) {
        // Configurar y mostrar el JFrame principal
        JFrame frame = new JFrame("Buscador de Estudiantes");
        frame.setContentPane(new form1().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}