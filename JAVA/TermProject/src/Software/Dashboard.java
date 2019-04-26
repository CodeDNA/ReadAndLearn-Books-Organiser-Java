/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Software;

import Database.Books;
import Models.Book;
import Models.User;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Titan
 */
public class Dashboard extends javax.swing.JFrame {
    Connection conn;

    String currentUser = "84650e5a-fe33-464f-a2b1-b865d1b64279";
    private Color wrapperBackgroundColor,OptionPaneBgColor, optionPaneLabelColor, mouseEnteredColor;
    
    public Dashboard() throws SQLException {
        initComponents();
        conn = Database.DatabaseHandler.getConnection();
        OptionPaneBgColor = Color.decode("#595858");
        optionPaneLabelColor = Color.WHITE;
        wrapperBackgroundColor =Color.decode("#666666");
        mouseEnteredColor = Color.GRAY;
        
        lblWelcomeHeading.setText("Welcome "+ User.currentUser.getFirstName());
        
        //displayBooksRead();
        //displayWishlist();
        //setDefaults(01);
    }
    
    
    public ArrayList<Book> BookList() throws SQLException
    {
        PreparedStatement pstBookList;
        ArrayList<Book> booksList = new ArrayList<>();
        String query = "SELECT * from books B, booksread BR where BR.UserId = ? and B.BookId=BR.BookId";
        
        pstBookList = conn.prepareStatement(query);
        pstBookList.setString(1, currentUser);
        ResultSet result = pstBookList.executeQuery();
        
        Book book;
        
        while(result.next())
        {
            book = new Book(result.getString("BookId"), result.getString("BookName") , result.getString("Author")
                            ,result.getString("Professor") ,result.getString("BookDescription") ,result.getString("DateAdded"));
            booksList.add(book);
        }
        return booksList;
    }
    
    public void displayBooksRead() throws SQLException
    {
        
        ArrayList<Book> list = BookList();
        
        DefaultTableModel model = (DefaultTableModel) tableBooksRead.getModel();
        model.getDataVector().removeAllElements();
        Object[] row = new Object[5];
        for(int i=0; i<list.size(); i++)
        {
            row[0] = list.get(i).getBookName();
            row[1] = list.get(i).getAuthor();
            row[2] = list.get(i).getDateAdded();
            row[3] = list.get(i).getProfessor();
            row[4] = list.get(i).getBookId();
            model.addRow(row);
        }  
       
    }
    
    
    public ArrayList<Book> Wishlist() throws SQLException
    {
        String userId = "84650e5a-fe33-464f-a2b1-b865d1b64279";
        PreparedStatement pstWishlist;
        ArrayList<Book> wishlist = new ArrayList<>();
        String query = "select B.BookName,B.Author,W.DateAdded from books B, Wishlist W where W.UserId = ? and B.BookId = W.BookId";
        pstWishlist = conn.prepareStatement(query);
        pstWishlist.setString(1,userId);
        ResultSet result = pstWishlist.executeQuery();
        Book book;
        
        while(result.next())
        {
            book = new Book();            
            book.setBookName(result.getString("BookName"));           
            book.setAuthor(result.getString("Author"));
            book.setDateAdded(result.getString("DateAdded"));
            wishlist.add(book);
        }
        return wishlist;
    }
    
    public void displayWishlist() throws SQLException
    {
        ArrayList<Book> list = Wishlist();
        
        DefaultTableModel model = (DefaultTableModel) tableWishlist.getModel();
        model.getDataVector().removeAllElements();
        
        Object[] row = new Object[3];
        for(int i=0; i<list.size(); i++)
        {
            row[0] = list.get(i).getBookName();
            row[1] = list.get(i).getAuthor();
            row[2] = list.get(i).getDateAdded();
            model.addRow(row);
        }
    }
    
    
    
    
    private void setDefaults(int user) {
        //checkUser(01);
        setPanelBackgrounds();
        setOptionPaneBackgroundColor();
        setOptionPaneLabelColors();
                       
    }
    
    private String checkUser(int userType) {
        
        String user;        
        if(userType == 1) //if the user is professor
        user = "Student";        
        if(userType == 2) //user is admin
        user = "Professor";        
        else user = "Admin";          
        return user;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        buttonGroup1 = new javax.swing.ButtonGroup();
        PanelHeadingBanner = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        PanelLeftOptionWraper = new javax.swing.JPanel();
        OptionPanel2 = new javax.swing.JPanel();
        lblOptionPane2 = new javax.swing.JLabel();
        OptionPanel4 = new javax.swing.JPanel();
        lblOptionPane4 = new javax.swing.JLabel();
        OptionPanel5 = new javax.swing.JPanel();
        lblOptionPane5 = new javax.swing.JLabel();
        OptionPanel1 = new javax.swing.JPanel();
        lblOptionPane1 = new javax.swing.JLabel();
        layeredPanelRightBackground = new javax.swing.JLayeredPane();
        panelWelcome = new javax.swing.JPanel();
        lblWelcomeHeading = new javax.swing.JLabel();
        panelBooksRead = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableBooksRead = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        panelWishlist = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableWishlist = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        panelManageReadables = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableBooksAddedByMe = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        panelAssignRoles = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        panelOtherSettings = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        PanelHeadingBanner.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Read And Learn");

        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelHeadingBannerLayout = new javax.swing.GroupLayout(PanelHeadingBanner);
        PanelHeadingBanner.setLayout(PanelHeadingBannerLayout);
        PanelHeadingBannerLayout.setHorizontalGroup(
            PanelHeadingBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHeadingBannerLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelHeadingBannerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        PanelHeadingBannerLayout.setVerticalGroup(
            PanelHeadingBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHeadingBannerLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(2, 2, 2)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelLeftOptionWraper.setBackground(new java.awt.Color(153, 153, 153));
        PanelLeftOptionWraper.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        OptionPanel2.setBackground(new java.awt.Color(51, 51, 51));

        lblOptionPane2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblOptionPane2.setForeground(new java.awt.Color(255, 255, 255));
        lblOptionPane2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOptionPane2.setText("Wishlist");
        lblOptionPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOptionPane2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblOptionPane2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblOptionPane2MouseExited(evt);
            }
        });

        javax.swing.GroupLayout OptionPanel2Layout = new javax.swing.GroupLayout(OptionPanel2);
        OptionPanel2.setLayout(OptionPanel2Layout);
        OptionPanel2Layout.setHorizontalGroup(
            OptionPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OptionPanel2Layout.createSequentialGroup()
                .addComponent(lblOptionPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        OptionPanel2Layout.setVerticalGroup(
            OptionPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblOptionPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
        );

        PanelLeftOptionWraper.add(OptionPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 420, -1));

        OptionPanel4.setBackground(new java.awt.Color(51, 51, 51));

        lblOptionPane4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblOptionPane4.setForeground(new java.awt.Color(255, 255, 255));
        lblOptionPane4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOptionPane4.setText("Manage Readables");
        lblOptionPane4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOptionPane4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblOptionPane4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblOptionPane4MouseExited(evt);
            }
        });

        javax.swing.GroupLayout OptionPanel4Layout = new javax.swing.GroupLayout(OptionPanel4);
        OptionPanel4.setLayout(OptionPanel4Layout);
        OptionPanel4Layout.setHorizontalGroup(
            OptionPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblOptionPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );
        OptionPanel4Layout.setVerticalGroup(
            OptionPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblOptionPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        PanelLeftOptionWraper.add(OptionPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, -1, -1));

        OptionPanel5.setBackground(new java.awt.Color(51, 51, 51));

        lblOptionPane5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblOptionPane5.setForeground(new java.awt.Color(255, 255, 255));
        lblOptionPane5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOptionPane5.setText("Admin");
        lblOptionPane5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOptionPane5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblOptionPane5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblOptionPane5MouseExited(evt);
            }
        });

        javax.swing.GroupLayout OptionPanel5Layout = new javax.swing.GroupLayout(OptionPanel5);
        OptionPanel5.setLayout(OptionPanel5Layout);
        OptionPanel5Layout.setHorizontalGroup(
            OptionPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblOptionPane5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        OptionPanel5Layout.setVerticalGroup(
            OptionPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblOptionPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        PanelLeftOptionWraper.add(OptionPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 420, -1));

        OptionPanel1.setBackground(new java.awt.Color(51, 51, 51));

        lblOptionPane1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblOptionPane1.setForeground(new java.awt.Color(255, 255, 255));
        lblOptionPane1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOptionPane1.setText("Books Read");
        lblOptionPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOptionPane1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblOptionPane1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblOptionPane1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout OptionPanel1Layout = new javax.swing.GroupLayout(OptionPanel1);
        OptionPanel1.setLayout(OptionPanel1Layout);
        OptionPanel1Layout.setHorizontalGroup(
            OptionPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblOptionPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );
        OptionPanel1Layout.setVerticalGroup(
            OptionPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OptionPanel1Layout.createSequentialGroup()
                .addComponent(lblOptionPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        PanelLeftOptionWraper.add(OptionPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 102));

        layeredPanelRightBackground.setLayout(new java.awt.CardLayout());

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, panelBooksRead, org.jdesktop.beansbinding.ELProperty.create("${background}"), panelWelcome, org.jdesktop.beansbinding.BeanProperty.create("background"));
        bindingGroup.addBinding(binding);

        lblWelcomeHeading.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lblWelcomeHeading.setForeground(new java.awt.Color(255, 255, 255));
        lblWelcomeHeading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWelcomeHeading.setText("Welcome");

        javax.swing.GroupLayout panelWelcomeLayout = new javax.swing.GroupLayout(panelWelcome);
        panelWelcome.setLayout(panelWelcomeLayout);
        panelWelcomeLayout.setHorizontalGroup(
            panelWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelWelcomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblWelcomeHeading, javax.swing.GroupLayout.DEFAULT_SIZE, 936, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelWelcomeLayout.setVerticalGroup(
            panelWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelWelcomeLayout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(lblWelcomeHeading)
                .addGap(479, 479, 479))
        );

        layeredPanelRightBackground.add(panelWelcome, "card8");

        panelBooksRead.setBackground(new java.awt.Color(102, 0, 0));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, panelBooksRead, org.jdesktop.beansbinding.ELProperty.create("${background}"), jScrollPane4, org.jdesktop.beansbinding.BeanProperty.create("background"));
        bindingGroup.addBinding(binding);

        tableBooksRead.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tableBooksRead.setForeground(new java.awt.Color(255, 255, 255));
        tableBooksRead.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title", "Author", "Completed On", "Added By", "BookId"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, panelBooksRead, org.jdesktop.beansbinding.ELProperty.create("${background}"), tableBooksRead, org.jdesktop.beansbinding.BeanProperty.create("background"));
        bindingGroup.addBinding(binding);

        tableBooksRead.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableBooksReadMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tableBooksRead);
        if (tableBooksRead.getColumnModel().getColumnCount() > 0) {
            tableBooksRead.getColumnModel().getColumn(4).setMinWidth(0);
            tableBooksRead.getColumnModel().getColumn(4).setPreferredWidth(0);
            tableBooksRead.getColumnModel().getColumn(4).setMaxWidth(0);
        }

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, panelBooksRead, org.jdesktop.beansbinding.ELProperty.create("${background}"), jPanel1, org.jdesktop.beansbinding.BeanProperty.create("background"));
        bindingGroup.addBinding(binding);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Books Read By Me");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel5)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelBooksReadLayout = new javax.swing.GroupLayout(panelBooksRead);
        panelBooksRead.setLayout(panelBooksReadLayout);
        panelBooksReadLayout.setHorizontalGroup(
            panelBooksReadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 956, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelBooksReadLayout.setVerticalGroup(
            panelBooksReadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBooksReadLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        layeredPanelRightBackground.add(panelBooksRead, "card2");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, panelBooksRead, org.jdesktop.beansbinding.ELProperty.create("${background}"), panelWishlist, org.jdesktop.beansbinding.BeanProperty.create("background"));
        bindingGroup.addBinding(binding);

        tableWishlist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title", "Author", "Date Added"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, panelWishlist, org.jdesktop.beansbinding.ELProperty.create("${background}"), tableWishlist, org.jdesktop.beansbinding.BeanProperty.create("background"));
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tableBooksRead, org.jdesktop.beansbinding.ELProperty.create("${foreground}"), tableWishlist, org.jdesktop.beansbinding.BeanProperty.create("foreground"));
        bindingGroup.addBinding(binding);

        jScrollPane2.setViewportView(tableWishlist);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, panelBooksRead, org.jdesktop.beansbinding.ELProperty.create("${background}"), jPanel2, org.jdesktop.beansbinding.BeanProperty.create("background"));
        bindingGroup.addBinding(binding);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("My Wishlist");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel7)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelWishlistLayout = new javax.swing.GroupLayout(panelWishlist);
        panelWishlist.setLayout(panelWishlistLayout);
        panelWishlistLayout.setHorizontalGroup(
            panelWishlistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 956, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelWishlistLayout.setVerticalGroup(
            panelWishlistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelWishlistLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        layeredPanelRightBackground.add(panelWishlist, "card3");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, panelBooksRead, org.jdesktop.beansbinding.ELProperty.create("${background}"), panelManageReadables, org.jdesktop.beansbinding.BeanProperty.create("background"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, panelBooksRead, org.jdesktop.beansbinding.ELProperty.create("${background}"), jPanel3, org.jdesktop.beansbinding.BeanProperty.create("background"));
        bindingGroup.addBinding(binding);

        tableBooksAddedByMe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title", "Date Added"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, panelBooksRead, org.jdesktop.beansbinding.ELProperty.create("${background}"), tableBooksAddedByMe, org.jdesktop.beansbinding.BeanProperty.create("background"));
        bindingGroup.addBinding(binding);

        jScrollPane1.setViewportView(tableBooksAddedByMe);
        if (tableBooksAddedByMe.getColumnModel().getColumnCount() > 0) {
            tableBooksAddedByMe.getColumnModel().getColumn(0).setResizable(false);
            tableBooksAddedByMe.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Books Added By Me");

        jPanel4.setBackground(new java.awt.Color(102, 0, 0));

        jButton3.setText("Add Book");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton4.setText("Delete Book");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(639, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(176, 176, 176)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout panelManageReadablesLayout = new javax.swing.GroupLayout(panelManageReadables);
        panelManageReadables.setLayout(panelManageReadablesLayout);
        panelManageReadablesLayout.setHorizontalGroup(
            panelManageReadablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelManageReadablesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelManageReadablesLayout.setVerticalGroup(
            panelManageReadablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelManageReadablesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        layeredPanelRightBackground.add(panelManageReadables, "card5");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, panelBooksRead, org.jdesktop.beansbinding.ELProperty.create("${background}"), panelAssignRoles, org.jdesktop.beansbinding.BeanProperty.create("background"));
        bindingGroup.addBinding(binding);

        jLabel6.setText("assign roles");

        javax.swing.GroupLayout panelAssignRolesLayout = new javax.swing.GroupLayout(panelAssignRoles);
        panelAssignRoles.setLayout(panelAssignRolesLayout);
        panelAssignRolesLayout.setHorizontalGroup(
            panelAssignRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAssignRolesLayout.createSequentialGroup()
                .addContainerGap(452, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(448, 448, 448))
        );
        panelAssignRolesLayout.setVerticalGroup(
            panelAssignRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAssignRolesLayout.createSequentialGroup()
                .addGap(281, 281, 281)
                .addComponent(jLabel6)
                .addContainerGap(429, Short.MAX_VALUE))
        );

        layeredPanelRightBackground.add(panelAssignRoles, "card6");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, panelBooksRead, org.jdesktop.beansbinding.ELProperty.create("${background}"), panelOtherSettings, org.jdesktop.beansbinding.BeanProperty.create("background"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout panelOtherSettingsLayout = new javax.swing.GroupLayout(panelOtherSettings);
        panelOtherSettings.setLayout(panelOtherSettingsLayout);
        panelOtherSettingsLayout.setHorizontalGroup(
            panelOtherSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 956, Short.MAX_VALUE)
        );
        panelOtherSettingsLayout.setVerticalGroup(
            panelOtherSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 724, Short.MAX_VALUE)
        );

        layeredPanelRightBackground.add(panelOtherSettings, "card7");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelHeadingBanner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelLeftOptionWraper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(layeredPanelRightBackground))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelHeadingBanner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelLeftOptionWraper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(layeredPanelRightBackground)))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        AdvancedSearch advanceSearch;
        
            advanceSearch = new  AdvancedSearch();
            advanceSearch.pack();
            advanceSearch.setLocationRelativeTo(null); //This will place the CreateAccount form at the center
            advanceSearch.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void lblOptionPane1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOptionPane1MouseEntered
        OptionPanel1.setBackground(mouseEnteredColor);
    }//GEN-LAST:event_lblOptionPane1MouseEntered

    private void lblOptionPane1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOptionPane1MouseExited
        OptionPanel1.setBackground(OptionPaneBgColor);
    }//GEN-LAST:event_lblOptionPane1MouseExited

    private void lblOptionPane2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOptionPane2MouseEntered
        OptionPanel2.setBackground(mouseEnteredColor);
    }//GEN-LAST:event_lblOptionPane2MouseEntered

    private void lblOptionPane4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOptionPane4MouseEntered
        OptionPanel4.setBackground(mouseEnteredColor);
    }//GEN-LAST:event_lblOptionPane4MouseEntered

    private void lblOptionPane5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOptionPane5MouseEntered
        OptionPanel5.setBackground(mouseEnteredColor);
    }//GEN-LAST:event_lblOptionPane5MouseEntered

    private void lblOptionPane2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOptionPane2MouseExited
        OptionPanel2.setBackground(OptionPaneBgColor);
    }//GEN-LAST:event_lblOptionPane2MouseExited

    private void lblOptionPane4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOptionPane4MouseExited
        OptionPanel4.setBackground(OptionPaneBgColor);
    }//GEN-LAST:event_lblOptionPane4MouseExited

    private void lblOptionPane5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOptionPane5MouseExited
        OptionPanel5.setBackground(OptionPaneBgColor);
    }//GEN-LAST:event_lblOptionPane5MouseExited

    private void lblOptionPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOptionPane1MouseClicked
//        JOptionPane.showMessageDialog(null, "Books Read", "Clicked", JOptionPane.INFORMATION_MESSAGE);
        layeredPanelRightBackground.removeAll();
        layeredPanelRightBackground.add(panelBooksRead);
        layeredPanelRightBackground.repaint();
        layeredPanelRightBackground.revalidate();
        try {
            displayBooksRead();
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblOptionPane1MouseClicked

    private void lblOptionPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOptionPane2MouseClicked
        layeredPanelRightBackground.removeAll();
        layeredPanelRightBackground.add(panelWishlist);
        layeredPanelRightBackground.repaint();
        layeredPanelRightBackground.revalidate();
    }//GEN-LAST:event_lblOptionPane2MouseClicked

    private void lblOptionPane4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOptionPane4MouseClicked
        layeredPanelRightBackground.removeAll();
        layeredPanelRightBackground.add(panelManageReadables);
        layeredPanelRightBackground.repaint();
        layeredPanelRightBackground.revalidate();
    }//GEN-LAST:event_lblOptionPane4MouseClicked

    private void lblOptionPane5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOptionPane5MouseClicked
        layeredPanelRightBackground.removeAll();
        layeredPanelRightBackground.add(panelAssignRoles);
        layeredPanelRightBackground.repaint();
        layeredPanelRightBackground.revalidate();
    }//GEN-LAST:event_lblOptionPane5MouseClicked

    private void tableBooksReadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableBooksReadMouseClicked
        
        JOptionPane.showMessageDialog(null, "Click ok to open this book/readable", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
        System.out.println("Exactly clicked values : "+tableBooksRead.getValueAt(tableBooksRead.getSelectedRow(), 4));
        
        //redirect to the View Book Page with the book Id sent
        
        //redirect to the view book page
    }//GEN-LAST:event_tableBooksReadMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        AddBook addbook = new AddBook();
        addbook.pack();
        addbook.setLocationRelativeTo(null);
        addbook.setVisible(true);
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       DeleteBook del = new DeleteBook();
       del.pack();
       del.setLocationRelativeTo(null);
       del.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Dashboard().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel OptionPanel1;
    private javax.swing.JPanel OptionPanel2;
    private javax.swing.JPanel OptionPanel4;
    private javax.swing.JPanel OptionPanel5;
    private javax.swing.JPanel PanelHeadingBanner;
    private javax.swing.JPanel PanelLeftOptionWraper;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLayeredPane layeredPanelRightBackground;
    private javax.swing.JLabel lblOptionPane1;
    private javax.swing.JLabel lblOptionPane2;
    private javax.swing.JLabel lblOptionPane4;
    private javax.swing.JLabel lblOptionPane5;
    private javax.swing.JLabel lblWelcomeHeading;
    private javax.swing.JPanel panelAssignRoles;
    private javax.swing.JPanel panelBooksRead;
    private javax.swing.JPanel panelManageReadables;
    private javax.swing.JPanel panelOtherSettings;
    private javax.swing.JPanel panelWelcome;
    private javax.swing.JPanel panelWishlist;
    private javax.swing.JTable tableBooksAddedByMe;
    private javax.swing.JTable tableBooksRead;
    private javax.swing.JTable tableWishlist;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    private void setOptionPaneBackgroundColor() {
        OptionPanel1.setBackground(OptionPaneBgColor);
        OptionPanel2.setBackground(OptionPaneBgColor);
        //OptionPanel3.setBackground(OptionPaneBgColor);
        OptionPanel4.setBackground(OptionPaneBgColor);
        OptionPanel5.setBackground(OptionPaneBgColor);
        //OptionPanel6.setBackground(OptionPaneBgColor);
    }

    private void setOptionPaneLabelColors() {        
        lblOptionPane1.setForeground(optionPaneLabelColor);
        //lblOptionPane3.setForeground(optionPaneLabelColor);
        lblOptionPane2.setForeground(optionPaneLabelColor);
        lblOptionPane4.setForeground(optionPaneLabelColor);
        lblOptionPane5.setForeground(optionPaneLabelColor);
        //lblOptionPane6.setForeground(optionPaneLabelColor);
    }

    private void setPanelBackgrounds() {
        
       PanelLeftOptionWraper.setBackground(wrapperBackgroundColor);
       layeredPanelRightBackground.setBackground(wrapperBackgroundColor);
       PanelHeadingBanner.setBackground(wrapperBackgroundColor);
    }

    private void populateBooksRead() throws SQLException {
         displayBooksRead();       
        
    }
    
   

    

}
