import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_tutorial
{
    private JPanel main;
    private JButton holaMundoButton;
    private JButton sumaButton;

    //Constructor
    public GUI_tutorial ()
    {
        holaMundoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Hola Mundo!");

            }
        });

        sumaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                suma();
            }
        });
    }

//METODOS

    public void suma ()
    {

        int x = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el primer numero"));
        int y = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el segundo numero"));

        x = x+y;

        JOptionPane.showMessageDialog(null, "El resultado de la suma es: " + x);

    }








    public static void main(String[] args) {
        JFrame frame = new JFrame("Tutorial");
        frame.setContentPane(new GUI_tutorial().main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(400, 400);
        frame.setResizable(false);
        frame.setVisible(true);


    }
}
