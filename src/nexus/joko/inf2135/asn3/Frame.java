package nexus.joko.inf2135.asn3;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import nexus.joko.inf2135.asn3.model.Mesin;
import nexus.joko.inf2135.asn3.model.Mobil;

public class Frame extends javax.swing.JFrame {

    private final DefaultTableModel carModel;

    public Frame() {
        initComponents();

        carModel = (DefaultTableModel) carTable.getModel();
        showData(fetchData());
    }
    
    private List<Mobil> fetchData() {
        List<Mobil> result = new ArrayList<>();

        String name, fuel;
        int numberOfCylinders, cylinderCapacity, chairsAmount;

        try {
            carModel.setRowCount(0);

            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            String query = "SELECT name, fuel, number_of_cylinders, cylinder_capacity, chairs_amount FROM mobil";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                numberOfCylinders = resultSet.getInt("number_of_cylinders");
                cylinderCapacity = resultSet.getInt("cylinder_capacity");

                Mesin engine = new Mesin();
                engine.setJumlahSilinder(numberOfCylinders);
                engine.setKapasitasSilinder(cylinderCapacity);

                name = resultSet.getString("name");
                fuel = resultSet.getString("fuel");
                chairsAmount = resultSet.getInt("chairs_amount");

                Mobil car = new Mobil();
                car.setNama(name);
                car.setMesin(engine);
                car.setBahanBakar(fuel);
                car.setJumlahKursi(chairsAmount);

                result.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return result;
    }

    private void showData(List<Mobil> cars) {
        carModel.setRowCount(0);

        cars.forEach((car) -> {
            Object[] data = {
                car.getNama(),
                car.getBahanBakar(),
                car.getMesin().getJumlahSilinder(),
                car.getMesin().getJumlahSilinder(),
                car.getJumlahKursi()
            };
            carModel.addRow(data);
        });
    }

    private boolean saveData(Mobil car) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            String query = "INSERT INTO mobil(name, fuel, number_of_cylinders, cylinder_capacity, chairs_amount) VALUES(?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, car.getNama());
                statement.setString(2, car.getBahanBakar());
                statement.setInt(3, car.getMesin().getJumlahSilinder());
                statement.setInt(4, car.getMesin().getKapasitasSilinder());
                statement.setInt(5, car.getJumlahKursi());

                statement.executeUpdate();
            }

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        nameTextField = new javax.swing.JTextField();
        fuelTextField = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        nameLabel = new javax.swing.JLabel();
        fuelLabel = new javax.swing.JLabel();
        numberOfCylindersLabel = new javax.swing.JLabel();
        showButton = new javax.swing.JButton();
        cylinderCapacityLabel = new javax.swing.JLabel();
        chairsAmountLabel = new javax.swing.JLabel();
        numberOfCylindersSpinner = new javax.swing.JSpinner();
        cylinderCapacitySpinner = new javax.swing.JSpinner();
        chairsAmountSpinner = new javax.swing.JSpinner();
        scrollPanel = new javax.swing.JScrollPane();
        carTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        addButton.setText("Simpan");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        nameLabel.setText("Nama");

        fuelLabel.setText("Bahan Bakar");

        numberOfCylindersLabel.setText("Jumlah Silinder");

        showButton.setText("Tampil");
        showButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showButtonActionPerformed(evt);
            }
        });

        cylinderCapacityLabel.setText("Kapsitas Silinder");

        chairsAmountLabel.setText("Jumlah Kursi");

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(0, 171, Short.MAX_VALUE)
                        .addComponent(showButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(164, 164, 164))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(fuelLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameLabel)
                            .addComponent(numberOfCylindersLabel)
                            .addComponent(cylinderCapacityLabel)
                            .addComponent(chairsAmountLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(fuelTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                                .addComponent(nameTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(addButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(numberOfCylindersSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cylinderCapacitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chairsAmountSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fuelTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fuelLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numberOfCylindersLabel)
                    .addComponent(numberOfCylindersSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cylinderCapacityLabel)
                    .addComponent(cylinderCapacitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chairsAmountLabel)
                    .addComponent(chairsAmountSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(showButton))
                .addGap(15, 15, 15))
        );

        carTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama", "Bahan Bakar", "Jumlah Silinder", "Kapasitas Silinder", "Jumlah Kursi"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        scrollPanel.setViewportView(carTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(scrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showButtonActionPerformed
        showData(fetchData());
    }//GEN-LAST:event_showButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        String name = nameTextField.getText();
        String fuel = fuelTextField.getText();
        int numberOfCylinders = (int) numberOfCylindersSpinner.getValue();
        int cylinderCapacity = (int) cylinderCapacitySpinner.getValue();
        int chairsAmount = (int) chairsAmountSpinner.getValue();

        if (name.isBlank() || fuel.isBlank()) {
            JOptionPane.showMessageDialog(rootPane, "Tolong isi semua form", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Mesin engine = new Mesin();
        engine.setJumlahSilinder(numberOfCylinders);
        engine.setKapasitasSilinder(cylinderCapacity);

        Mobil car = new Mobil();
        car.setNama(name);
        car.setMesin(engine);
        car.setBahanBakar(fuel);
        car.setJumlahKursi(chairsAmount);

        if (saveData(car)) {
            JOptionPane.showMessageDialog(rootPane, "Data berhasil disimpan", "Info", JOptionPane.INFORMATION_MESSAGE);

            nameTextField.setText("");
            fuelTextField.setText("");
            numberOfCylindersSpinner.setValue(0);
            cylinderCapacitySpinner.setValue(0);
            chairsAmountSpinner.setValue(0);

            fetchData();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Data gagal disimpan", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_addButtonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Frame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTable carTable;
    private javax.swing.JLabel chairsAmountLabel;
    private javax.swing.JSpinner chairsAmountSpinner;
    private javax.swing.JLabel cylinderCapacityLabel;
    private javax.swing.JSpinner cylinderCapacitySpinner;
    private javax.swing.JLabel fuelLabel;
    private javax.swing.JTextField fuelTextField;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JLabel numberOfCylindersLabel;
    private javax.swing.JSpinner numberOfCylindersSpinner;
    private javax.swing.JScrollPane scrollPanel;
    private javax.swing.JButton showButton;
    // End of variables declaration//GEN-END:variables
}
