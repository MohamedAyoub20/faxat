
import java.awt.Component;
import java.awt.Container;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Afroa extends javax.swing.JFrame {

    public Afroa(String afroaName) {

        initComponents();

        int day = getCurrentDate().getDayOfMonth();
        int month = getCurrentDate().getMonthValue();

        // add sourcePath
        jFileChooser1.setCurrentDirectory(new File("D:\\faxat\\الافرع\\" + afroaName + "\\" + month + "\\" + day + "\\"));
        setBounds(450, 150, 600, 400);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jFileChooser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooser1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private LocalDate getCurrentDate() {
        LocalDate date = LocalDate.now();
        return date;
    }

    public void open(Path destinationPath) {
        try {
            Desktop.getDesktop().open(destinationPath.toFile());
        } catch (IOException e1) {
            JOptionPane.showMessageDialog(
                    null,
                    "file openning fails: " + destinationPath.getFileName(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public void disableButton(final Container c, final String iconString) {

        int len = c.getComponentCount();
        for (int i = 0; i < len; i++) {
            Component comp = c.getComponent(i);
            if (comp instanceof JButton) {
                JButton b = (JButton) comp;
                Icon icon = b.getIcon();
                if (icon != null
                        && icon == UIManager.getIcon(iconString)) {
                    b.setEnabled(false);
                }
            } else if (comp instanceof Container) {
                disableButton((Container) comp, iconString);
            }
        }
    }


    private void jFileChooser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileChooser1ActionPerformed

        jFileChooser1.setFileFilter(new FileNameExtensionFilter("PDF", "pdf"));

        disableButton(jFileChooser1, "FileChooser.homeFolderIcon");
        disableButton(jFileChooser1, "FileChooser.newFolderIcon");

        Path sourcePath = jFileChooser1.getSelectedFile().toPath();

        open(sourcePath);

    }//GEN-LAST:event_jFileChooser1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser jFileChooser1;
    // End of variables declaration//GEN-END:variables
}
