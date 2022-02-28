
import java.io.InputStream;
import javax.swing.JOptionPane;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.LayoutManager;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.util.ArrayList;

public class GUI3 {
    public static String line;
    public static ArrayList<String> testers;
    public static JPasswordField password;
    public static JLabel pas;
    public static JButton done;
    public static JFrame fram;
    
    public GUI3() {
        (GUI3.fram = new JFrame("Authorization")).setSize(240, 105);
        GUI3.fram.setResizable(false);
        GUI3.fram.setLayout((LayoutManager)null);
        GUI3.fram.setVisible(true);
        GUI3.password.setBounds(70, 15, 150, 20);
        GUI3.pas.setBounds(5, 15, 100, 20);
        GUI3.done.setBounds(70, 45, 100, 20);
        GUI3.fram.add((Component)GUI3.done);
        GUI3.fram.add((Component)GUI3.pas);
        GUI3.fram.add((Component)GUI3.password);
        GUI3.password.setEchoChar('*');
        GUI3.fram.setLocationRelativeTo((Component)null);
        GUI3.fram.setDefaultCloseOperation(3);
        GUI3.done.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent ev) {
                GUI3.getPassword();
            }
        });
    }
    
    public static final gj getPassword() {
        InputStream in = null;
        try {
            in = new URL("https://pastebin.com/raw/0bxF91Xx").openStream();
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
        catch (IOException e2) {
            e2.printStackTrace();
        }
        final BufferedReader r = new BufferedReader((Reader)new InputStreamReader(in));
        try {
            while ((GUI3.line = r.readLine()) != null) {
                GUI3.testers.add(GUI3.line);
            }
        }
        catch (IOException e3) {
            e3.printStackTrace();
        }
        if (GUI3.password.getText().equals(GUI3.testers.get(0))) {
            MCUtils.frame.setVisible(true);
            Main.optionsInstance.setVisible(true);
            GUI3.fram.setVisible(false);
        }
        else {
            JOptionPane.showMessageDialog((Component)null, "Incorrect password", "MCCheat", 2);
        }
        return null;
    }
    
    static {
        GUI3.testers = (ArrayList<String>)new ArrayList();
        GUI3.password = new JPasswordField();
        GUI3.pas = new JLabel("Password:");
        GUI3.done = new JButton("Login");
    }
}
