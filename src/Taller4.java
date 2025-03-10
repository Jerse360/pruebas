import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Taller4
{


    private JButton modifyButton;
    private JButton deleteButton;
    private JButton searchButton;
    private JButton viewButton;
    private JButton addButton;
    private JPanel main;
    private JButton reportButton;


    public void setCode(String code) {
        this.code = code;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setAmountBuy(int amountBuy) {
        this.amountBuy = amountBuy;
    }

    public void setUnitaryPrice(Double unitaryPrice) {
        this.unitaryPrice = unitaryPrice;
    }


    //Atributos

    String code, name, category;
    int stock, amountBuy;

    double unitaryPrice;

    ArrayList<Taller4> productList = new ArrayList<>();

    String [] vcode = new String [999];


    //Constructor de la clase
    public Taller4 (String code, String name, String category, int stock, int amountBuy, Double unitaryPrice)
    {
        this.code = code;
        this.name = name;
        this.category = category;
        this.stock = stock;
        this.amountBuy = amountBuy;
        this.unitaryPrice = unitaryPrice;

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addProduct();
            }
        });

        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showProduct();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                search();
            }
        });

        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modify();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delete();
            }
        });

        reportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {report();}
        });



    }

    //Metodos

    public void addProduct ()
    { boolean state = false;
        boolean active = true;
        int suma = productList.size();

        do {
        state = false;
         vcode[suma] = JOptionPane.showInputDialog("Enter the code");
        for (int i = 0; i < productList.size(); i++)
        {
            String y = (productList.get(i).code);

            if (vcode[i] == y) {
                state = true;
                if (state = true)
                {
                    JOptionPane.showMessageDialog(null,"Existing code");
                }

            }



        }

        if (state == false)
        {
            String op = vcode+"";
            code = op;
            name = JOptionPane.showInputDialog("Enter the name");
            category = JOptionPane.showInputDialog("Enter the category");
            stock = Integer.parseInt(JOptionPane.showInputDialog("Enter the stock"));
            amountBuy = Integer.parseInt(JOptionPane.showInputDialog("Enter the repurchase amount"));
            unitaryPrice = Double.parseDouble(JOptionPane.showInputDialog("Enter the unitary price"));

            Taller4 taller4 = new Taller4(code,name,category,stock,amountBuy,unitaryPrice);

            productList.add(taller4);
            vcode[suma] = op;

            active = false;
        }
    }while (active);




    }


    public void showProduct ()
    {
        for (int i = 0; i < productList.size(); i++)
        {

            System.out.println("Code: " + productList.get(i).code + "\nName " + productList.get(i).name + "\nCategory "
                    + productList.get(i).category + "\nStock " + productList.get(i).stock + "\nRepurchase amount " + productList.get(i).amountBuy + "\nUnitary price "
                    + productList.get(i).unitaryPrice);

            System.out.println(" ");




        }


    }



    public void search ()
    {boolean state = false;
        int x = Integer.parseInt(JOptionPane.showInputDialog("Enter the code of the product"));
        for (int i = 0; i < productList.size(); i++)
        {
            int y = Integer.parseInt(productList.get(i).code);
            if (x == y) {
                state = true;
                if (state = true) {
                    JOptionPane.showMessageDialog(null, "Code: " + productList.get(i).code + "\nName " + productList.get(i).name + "\nCategory "
                            + productList.get(i).category + "\nStock " + productList.get(i).stock + "\nRepurchase amount " + productList.get(i).amountBuy + "\nUnitary price "
                            + productList.get(i).unitaryPrice);
                }


            }


        }

        if (state == false)
        {

            JOptionPane.showMessageDialog(null,"Product not found");

        }


    }


    public void modify () {
        int x = Integer.parseInt(JOptionPane.showInputDialog("Enter the code of the product"));
        for (int i = 0; i < productList.size(); i++) {

            int y = Integer.parseInt(productList.get(i).code);
            if (x == y) {

                int cant = Integer.parseInt(JOptionPane.showInputDialog("Enter the new amount"));
                productList.get(i).setStock(cant);


            }
        }
    }

    public void delete ()
    {
        int x = Integer.parseInt(JOptionPane.showInputDialog("Enter the code of the product"));
        for (int i = 0; i < productList.size(); i++) {

            int y = Integer.parseInt(productList.get(i).code);
            if (x == y) {

                productList.remove(i);


            }
        }


    }

    public void report()
    {

    }



    //Main
    public static void main(String[] args) {
        Taller4 taller4 = new Taller4(null,null,null,0,0,0.0);
        JFrame frame = new JFrame("Inventory Management");
        frame.setContentPane(new Taller4(null,null,null,0,0,0.0).main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(350, 400);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
