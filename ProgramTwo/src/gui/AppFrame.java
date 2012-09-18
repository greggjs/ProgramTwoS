/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import books.BookSearch;

/**
 *
 * @author Kyle
 */
public class AppFrame extends javax.swing.JFrame {

    String aFName, aMName, aLName, bTitle;
    int aBDay, aBMonth, aBYear, bPDay, bPMonth, bPYear;
    int actionPerformed;
    private static final int searchBook = 0, searchAuthor = 1, addBook = 2, addAuthor = 3, 
            modifyBook = 4, modifyAuthor = 5, searchKeyword = 6;
    
    /**
     * Creates new form AppFrame
     */
    public AppFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        bookTitleField = new javax.swing.JTextField();
        pubMonthField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        pubDayField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        pubYearField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        birthMonthField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        birthDayField = new javax.swing.JTextField();
        birthYearField = new javax.swing.JTextField();
        lastNameField = new javax.swing.JTextField();
        firstNameField = new javax.swing.JTextField();
        midNameField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        searchBooksButton = new javax.swing.JRadioButton();
        searchAuthorsButton = new javax.swing.JRadioButton();
        addBookButton = new javax.swing.JRadioButton();
        addAuthorButton = new javax.swing.JRadioButton();
        modifyBookButton = new javax.swing.JRadioButton();
        modifyAuthorButton = new javax.swing.JRadioButton();
        searchKeywordButton = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        outputBox = new javax.swing.JTextArea();
        goButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Book & Author Search");

        jLabel4.setText("Title");

        jLabel5.setText("Publish Date");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Book Information");

        bookTitleField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookTitleFieldActionPerformed(evt);
            }
        });

        pubMonthField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pubMonthFieldActionPerformed(evt);
            }
        });

        jLabel1.setText("/");

        pubDayField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pubDayFieldActionPerformed(evt);
            }
        });

        jLabel2.setText("/");

        pubYearField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pubYearFieldActionPerformed(evt);
            }
        });

        jLabel3.setText("Name");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Author Information");

        jLabel8.setText("Birthday");

        birthMonthField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                birthMonthFieldActionPerformed(evt);
            }
        });

        jLabel9.setText("/");

        birthDayField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                birthDayFieldActionPerformed(evt);
            }
        });

        birthYearField.setText(" ");
        birthYearField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                birthYearFieldActionPerformed(evt);
            }
        });

        lastNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastNameFieldActionPerformed(evt);
            }
        });

        firstNameField.setText(" ");
        firstNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameFieldActionPerformed(evt);
            }
        });

        midNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                midNameFieldActionPerformed(evt);
            }
        });

        jLabel10.setText("/");

        jLabel11.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel11.setText("Last Name");

        jLabel12.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel12.setText("First Name");

        jLabel13.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel13.setText("Middle Name");

        jLabel14.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel14.setText("Month");

        jLabel15.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel15.setText("Day");

        jLabel16.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel16.setText("Year");

        jLabel17.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel17.setText("Month");

        jLabel18.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel18.setText("Day");

        jLabel19.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel19.setText("Year");

        buttonGroup1.add(searchBooksButton);
        searchBooksButton.setText("Search Books");
        searchBooksButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBooksButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(searchAuthorsButton);
        searchAuthorsButton.setText("Search Authors");
        searchAuthorsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchAuthorsButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(addBookButton);
        addBookButton.setText("Add Book");
        addBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBookButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(addAuthorButton);
        addAuthorButton.setText("Add Author");
        addAuthorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAuthorButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(modifyBookButton);
        modifyBookButton.setText("Modify Book");
        modifyBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyBookButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(modifyAuthorButton);
        modifyAuthorButton.setText("Modify Author");
        modifyAuthorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyAuthorButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(searchKeywordButton);
        searchKeywordButton.setText("Search By Keyword");
        searchKeywordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchKeywordButtonActionPerformed(evt);
            }
        });

        outputBox.setColumns(20);
        outputBox.setRows(5);
        jScrollPane1.setViewportView(outputBox);

        goButton.setText("Go");
        goButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(44, 44, 44)
                                .addComponent(bookTitleField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel17)
                                    .addComponent(pubMonthField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(pubDayField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(jLabel19))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(pubYearField, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(midNameField)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(birthMonthField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(birthDayField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(birthYearField, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel16))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(searchBooksButton)
                            .addComponent(searchAuthorsButton))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(addBookButton)
                                .addGap(10, 10, 10)
                                .addComponent(modifyBookButton)
                                .addGap(18, 18, 18)
                                .addComponent(searchKeywordButton))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(addAuthorButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(modifyAuthorButton)))))
                .addContainerGap())
            .addComponent(goButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel4))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(midNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(bookTitleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(birthMonthField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(birthDayField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(birthYearField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(pubMonthField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(pubDayField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(pubYearField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchBooksButton)
                    .addComponent(modifyBookButton)
                    .addComponent(addBookButton)
                    .addComponent(searchKeywordButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchAuthorsButton)
                    .addComponent(addAuthorButton)
                    .addComponent(modifyAuthorButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(goButton))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bookTitleFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookTitleFieldActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_bookTitleFieldActionPerformed

    private void pubMonthFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pubMonthFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pubMonthFieldActionPerformed

    private void birthMonthFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_birthMonthFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_birthMonthFieldActionPerformed

    private void searchAuthorsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchAuthorsButtonActionPerformed
        // TODO add your handling code here:
        actionPerformed = searchAuthor;
    }//GEN-LAST:event_searchAuthorsButtonActionPerformed

    private void goButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goButtonActionPerformed
        // TODO add your handling code here:
     //   String aFName, aMName, aLName, bTitle;
     //   int aBDay, aBMonth, aBYear, bPDay, bPMonth, bPYear;        

        switch (actionPerformed) {
            case searchAuthor :
                
                break;
            case searchBook :
                
                break;
            case addBook :
                
                break;
            case addAuthor :
                
                break;
            case modifyBook :
                
                break;
            case modifyAuthor :
                
                break;
            case searchKeyword :
                
                break;
        }
    }//GEN-LAST:event_goButtonActionPerformed

    private void searchBooksButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBooksButtonActionPerformed
        // TODO add your handling code here:
        actionPerformed = searchBook;
    }//GEN-LAST:event_searchBooksButtonActionPerformed

    private void addBookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBookButtonActionPerformed
        // TODO add your handling code here:
        actionPerformed = addBook;
    }//GEN-LAST:event_addBookButtonActionPerformed

    private void addAuthorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAuthorButtonActionPerformed
        // TODO add your handling code here:
        actionPerformed = addAuthor;
    }//GEN-LAST:event_addAuthorButtonActionPerformed

    private void modifyBookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyBookButtonActionPerformed
        actionPerformed = modifyBook;
        // TODO add your handling code here:
    }//GEN-LAST:event_modifyBookButtonActionPerformed

    private void modifyAuthorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyAuthorButtonActionPerformed
        actionPerformed = modifyAuthor;
        // TODO add your handling code here:
    }//GEN-LAST:event_modifyAuthorButtonActionPerformed

    private void searchKeywordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchKeywordButtonActionPerformed

        actionPerformed = searchKeyword;        
        // TODO add your handling code here:
    }//GEN-LAST:event_searchKeywordButtonActionPerformed

    private void pubDayFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pubDayFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pubDayFieldActionPerformed

    private void pubYearFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pubYearFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pubYearFieldActionPerformed

    private void lastNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastNameFieldActionPerformed

    private void firstNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstNameFieldActionPerformed

    private void midNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_midNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_midNameFieldActionPerformed

    private void birthDayFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_birthDayFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_birthDayFieldActionPerformed

    private void birthYearFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_birthYearFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_birthYearFieldActionPerformed

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
            java.util.logging.Logger.getLogger(AppFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AppFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton addAuthorButton;
    private javax.swing.JRadioButton addBookButton;
    private javax.swing.JTextField birthDayField;
    private javax.swing.JTextField birthMonthField;
    private javax.swing.JTextField birthYearField;
    private javax.swing.JTextField bookTitleField;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JButton goButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JTextField midNameField;
    private javax.swing.JRadioButton modifyAuthorButton;
    private javax.swing.JRadioButton modifyBookButton;
    private javax.swing.JTextArea outputBox;
    private javax.swing.JTextField pubDayField;
    private javax.swing.JTextField pubMonthField;
    private javax.swing.JTextField pubYearField;
    private javax.swing.JRadioButton searchAuthorsButton;
    private javax.swing.JRadioButton searchBooksButton;
    private javax.swing.JRadioButton searchKeywordButton;
    // End of variables declaration//GEN-END:variables
}
