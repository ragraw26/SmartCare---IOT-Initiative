/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.PatientWorkArea;

import Business.Enterprise.Enterprise;
import Business.Organization.PatientOrganization;
import Business.UserAccount.UserAccount;
import Business.VitalSign.VitalSign;
import Business.VitalSign.VitalSignHistory;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.SeriesException;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

/**
 *
 * @author Rajat
 */
public class PatientTrackMyHealthJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private PatientOrganization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private VitalSignHistory vitalHistory;

    /**
     * Creates new form PatientTrackMyHealthJPanel
     */
    public PatientTrackMyHealthJPanel(JPanel userProcessContainer, UserAccount userAccount, Enterprise enterprise) {
        initComponents();
        this.userAccount = userAccount;
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        DisplayGraph();
        DisplayGraph2();
        DisplayGraph3();
        DisplayGraph4();
    }

    public void DisplayGraph() {
        int count = 1;
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        vitalHistory = userAccount.getPatient().getVitalSignHistory();
        for (VitalSign vitalSign : vitalHistory.getVitalSignHistory()) {
            String str = String.valueOf(count);
            dataSet.addValue(vitalSign.getRespRate(), "Respiration Rate", str);
            count++;
        }
        JFreeChart chartFactory = ChartFactory.createAreaChart("Respiration Rate ", "Timestamp", "Respiration Rate", dataSet, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot plot = chartFactory.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.yellow);
        plot.setBackgroundPaint(Color.white);
        plot.setDomainGridlinePaint(Color.GREEN);
        ChartPanel chartPanel = new ChartPanel(chartFactory);
        jPanel2.removeAll();
        jPanel2.add(chartPanel, BorderLayout.CENTER);
        jPanel2.validate();
    }

    public void DisplayGraph2() {
        int count = 1;
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        vitalHistory = userAccount.getPatient().getVitalSignHistory();
        for (VitalSign vitalSign : vitalHistory.getVitalSignHistory()) {
            String str = String.valueOf(count);
            dataSet.addValue(vitalSign.getSysbloodPressure(), "Blood Pressure Rate", str);
            count++;
        }
        JFreeChart chartFactory = ChartFactory.createAreaChart("Blood Pressure", "Timestamp", "Blood Pressure", dataSet, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot plot = chartFactory.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.blue);
        plot.setBackgroundPaint(Color.white);
        ChartPanel chartPanel = new ChartPanel(chartFactory);
        jPanel3.removeAll();
        jPanel3.add(chartPanel, BorderLayout.CENTER);
        jPanel3.validate();
    }

    public void DisplayGraph3() {
        int count = 1;
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        vitalHistory = userAccount.getPatient().getVitalSignHistory();
        for (VitalSign vitalSign : vitalHistory.getVitalSignHistory()) {
            String str = String.valueOf(count);
            dataSet.addValue(vitalSign.getHeartRate(), "Hearth Rate", str);
            count++;
        }
        JFreeChart chartFactory = ChartFactory.createAreaChart("Hearth Rate", "Timestamp", "Health Rate", dataSet, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot plot = chartFactory.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.yellow);
        plot.setBackgroundPaint(Color.white);
        ChartPanel chartPanel = new ChartPanel(chartFactory);
        jPanel4.removeAll();
        jPanel4.add(chartPanel, BorderLayout.CENTER);
        jPanel4.validate();
    }

    public void DisplayGraph4() {
        int count = 1;
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        vitalHistory = userAccount.getPatient().getVitalSignHistory();
        for (VitalSign vitalSign : vitalHistory.getVitalSignHistory()) {
            String str = String.valueOf(count);
            dataSet.addValue(vitalSign.getWeight(), "Weight", str);
            count++;
        }
        JFreeChart chartFactory = ChartFactory.createAreaChart("Weight", "Timestamp", "Weight", dataSet, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot plot = chartFactory.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.blue);
        plot.setBackgroundPaint(Color.white);
        ChartPanel chartPanel = new ChartPanel(chartFactory);
        jPanel5.removeAll();
        jPanel5.add(chartPanel, BorderLayout.CENTER);
        jPanel5.validate();
    }

    /**
     * Starting point for the dynamic graph application.
     *
     * @param args ignored.
     */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/neu/edu/UserInterface/back_button_black.png"))); // NOI18N
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(767, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(jLabel14)
                .addContainerGap(597, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 775, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jLabel14MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel14;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
