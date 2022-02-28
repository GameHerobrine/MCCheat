
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle;
import java.awt.Component;
import java.awt.LayoutManager;
import javax.swing.GroupLayout;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;

public class GUI2 extends JFrame {
    private JLabel KKLI;
    private JButton LEADING;
    private static GUI2 instance;
    public GUI2() {
        this.KKLI();
    }
    
    private void KKLI() {
    	instance = this;
        this.KKLI = new JLabel();
        this.LEADING = new JButton();
        this.setTitle("MCCheat");
        this.setAlwaysOnTop(true);
        this.setResizable(false);
        this.KKLI.setFont(new Font("Tahoma", 1, 11));
        this.KKLI.setText("MCCheat Forever");
        this.LEADING.setText("Show");
        this.LEADING.addActionListener(new ActionListener() {

            public final void actionPerformed(ActionEvent var1) {
            	Main.optionsInstance.setVisible(true);
                Main.Z.setVisible(false);
            }
        });

        final GroupLayout var1 = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout((LayoutManager)var1);
        var1.setHorizontalGroup((GroupLayout.Group)var1.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup((GroupLayout.Group)var1.createSequentialGroup().addGap(45, 45, 45).addComponent((Component)this.KKLI).addGap(57, 57, 57)).addGroup(GroupLayout.Alignment.TRAILING, (GroupLayout.Group)var1.createSequentialGroup().addContainerGap().addComponent((Component)this.LEADING, -2, 197, -2).addContainerGap()));
        var1.setVerticalGroup((GroupLayout.Group)var1.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup((GroupLayout.Group)var1.createSequentialGroup().addContainerGap().addComponent((Component)this.KKLI).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent((Component)this.LEADING).addContainerGap(-1, 32767)));
        this.pack();
    }

}
