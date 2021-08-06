/*

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//import frames.customer.MainMenuDesign;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;



public class Statistics extends JFrame {
    private JPanel panelBackground;
    private JPanel myPanel;

    private JButton btnBack;

    private JLabel lblGraphs;
    private JLabel lblTitle;
    private JLabel lblBankBalance;
    private JLabel lblCurrentInventory;
    private JLabel lblTotalAssets;
    private JLabel lblYearlySales;
    private JLabel lblYearlypurchases;
    private JLabel lblMonthlySales;
    private JLabel lblMonthlyPurchases;






    private JComboBox cbbGraphs;


    private JTextField textBankBalance;
    private JTextField textCurrentInventory;
    private JTextField textTotalAssets;
    private JTextField textYearlySales;
    private JTextField textYearlypurchases;
    private JTextField textMonthlySales;
    private JTextField textMonthlyPurchases;




    private GridBagConstraints constraints;

    ArrayList<String> categories = new ArrayList<String>();



    public Statistics ()

    {
        //Frame details
        super("T1Tech! -Statistics");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1200, 700);
        setLocationRelativeTo(null);
        panelBackground = new JPanel();
        panelBackground.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panelBackground);
        panelBackground.setBackground(new Color(20,50,75));
        GridBagLayout gbl_panelBackground = new GridBagLayout();
        panelBackground.setLayout(gbl_panelBackground);

        //Panel
        myPanel = new JPanel();
        myPanel.setBorder(null);
        myPanel.setBackground(new Color(240, 255, 255));
        GridBagLayout gbl_myPanel = new GridBagLayout();
        gbl_myPanel.columnWidths = new int[]{50, 125, 50, 50, 50, 50, 0,50,50,50,50,50,50,50};
        gbl_myPanel.rowHeights = new int[]{20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20};
        myPanel.setLayout(gbl_myPanel);

        //Constraints
        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.EAST;
        constraints.gridx=0;
        constraints.gridy=0;
        panelBackground.add(myPanel,constraints);

        //###############################################################################

        GridBagConstraints gbc_lbl = new GridBagConstraints();
        gbc_lbl.anchor = GridBagConstraints.NORTHWEST;
        gbc_lbl.gridx = 0;
        gbc_lbl.gridy = 0;


        //Graphing Panel

        JPanel graphingPanel = new JPanel();
        constraints.anchor = GridBagConstraints.SOUTHWEST;
        constraints.insets = new Insets(0,0,5,5);
        constraints.fill = GridBagConstraints.BOTH;
        addComponent(graphingPanel,6,1,8,11);



//Title Label
        lblTitle = new JLabel("Statistics");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 24));
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(0,0,5,5);
        addComponent(lblTitle,1,1,2,1);



//Graphs label
        lblGraphs = new JLabel("Graphs:");
        lblGraphs.setFont(new Font("Tahoma", Font.BOLD, 15));
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(0,0,5,5);
        addComponent(lblGraphs,3,2,2,1);

        cbbGraphs = new JComboBox();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.EAST;
        constraints.insets = new Insets(0, 0, 5, 5);
        addComponent(cbbGraphs, 3, 4,2,1);



        //###############################################################################

        //Add Summary Data



        //Bank Balance
        lblBankBalance = new JLabel("Current balance");
        lblBankBalance.setFont(new Font("Tahoma", Font.BOLD, 14));
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(0, 0, 5, 5);
        constraints.anchor = GridBagConstraints.SOUTH;
        addComponent(lblBankBalance,3,10,1,1);

        textBankBalance = new JTextField("");
        textBankBalance.setFont(new Font("Tahoma", Font.PLAIN, 14));
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(0, 0, 5, 5);
        constraints.anchor = GridBagConstraints.SOUTH;
        textBankBalance.setEditable(false);
        addComponent(textBankBalance,3,11,2,1);

        //inventory value
        lblCurrentInventory = new JLabel("Current inventory value");
        lblCurrentInventory.setFont(new Font("Tahoma", Font.BOLD, 14));
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(0, 0, 5, 5);
        constraints.anchor = GridBagConstraints.SOUTH;
        addComponent(lblCurrentInventory,5,10,1,1);

        textCurrentInventory = new JTextField("");
        textCurrentInventory.setFont(new Font("Tahoma", Font.PLAIN, 14));
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(0, 0, 5, 5);
        constraints.anchor = GridBagConstraints.SOUTH;
        textCurrentInventory.setEditable(false);
        addComponent(textCurrentInventory,5,11,2,1);

        //Total assets
        lblTotalAssets = new JLabel("Total assets");
        lblTotalAssets.setFont(new Font("Tahoma", Font.BOLD, 14));
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(0, 0, 5, 5);
        constraints.anchor = GridBagConstraints.SOUTH;
        addComponent(lblTotalAssets,7,10,1,1);

        textTotalAssets = new JTextField("");
        textTotalAssets.setFont(new Font("Tahoma", Font.PLAIN, 14));
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(0, 0, 5, 5);
        constraints.anchor = GridBagConstraints.SOUTH;
        textTotalAssets.setEditable(false);
        addComponent(textTotalAssets,7,11,2,1);

        //year to date sales
        lblYearlySales = new JLabel("Year-to-date sales");
        lblYearlySales.setFont(new Font("Tahoma", Font.BOLD, 14));
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(0, 0, 5, 5);
        constraints.anchor = GridBagConstraints.SOUTH;
        addComponent(lblYearlySales,9,10,1,1);

        textYearlySales = new JTextField("");
        textYearlySales.setFont(new Font("Tahoma", Font.PLAIN, 14));
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(0, 0, 5, 5);
        constraints.anchor = GridBagConstraints.SOUTH;
        textYearlySales.setEditable(false);
        addComponent(textYearlySales,9,11,2,1);

        //year to date purchases
        lblYearlypurchases = new JLabel("Year-to-date purchases");
        lblYearlypurchases.setFont(new Font("Tahoma", Font.BOLD, 14));
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(0, 0, 5, 5);
        constraints.anchor = GridBagConstraints.SOUTH;
        addComponent(lblYearlypurchases,11,10,1,1);

        textYearlypurchases = new JTextField("");
        textYearlypurchases.setFont(new Font("Tahoma", Font.PLAIN, 14));
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(0, 0, 5, 5);
        constraints.anchor = GridBagConstraints.SOUTH;
        textYearlypurchases.setEditable(false);
        addComponent(textYearlypurchases,11,11,2,1);

        //Month to date sales
        lblMonthlySales = new JLabel("Month-to-date sales");
        lblMonthlySales.setFont(new Font("Tahoma", Font.BOLD, 14));
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(0, 0, 5, 5);
        constraints.anchor = GridBagConstraints.SOUTH;
        addComponent(lblMonthlySales,13,10,1,1);

        textMonthlySales = new JTextField("");
        textMonthlySales.setFont(new Font("Tahoma", Font.PLAIN, 14));
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(0, 0, 5, 5);
        constraints.anchor = GridBagConstraints.SOUTH;
        textMonthlySales.setEditable(false);
        addComponent(textMonthlySales,13,11,2,1);

        //Month to date purchases
        lblMonthlyPurchases = new JLabel("Month-to-date purchases");
        lblMonthlyPurchases.setFont(new Font("Tahoma", Font.BOLD, 14));
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(0, 0, 5, 5);
        constraints.anchor = GridBagConstraints.SOUTH;
        addComponent(lblMonthlyPurchases,15,10,1,1);

        textMonthlyPurchases = new JTextField("");
        textMonthlyPurchases.setFont(new Font("Tahoma", Font.PLAIN, 14));
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(0, 0, 5, 5);
        constraints.anchor = GridBagConstraints.SOUTH;
        textMonthlyPurchases.setEditable(false);
        addComponent(textMonthlyPurchases,15,11,2,1);

        //Back button
        btnBack = new JButton("Back");
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(0, 0, 5, 5);
        addComponent(btnBack,18,11,2,1);

        btnBack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //  MainMenuDesign running= new MainMenuDesign();
                //running.setVisible(true);
                dispose();
            }
        });





        //###############################################################################

        //Visibility


        setContentPane(panelBackground);
        panelBackground.add(myPanel);

        setVisible(true);
    }

    //###############################################################################

    //Main Method

    public static void main (String[]args)
    {
        Statistics a = new Statistics();
    }

    //###############################################################################       


    public void addComponent(Component component, int row, int column, int width,int height ){
        constraints.gridx=column;
        constraints.gridy=row;
        constraints.gridwidth=width;
        constraints.gridheight=height;
        myPanel.add(component,constraints);





    }


}

 */