
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

public class AuthGui {
    public static String line;
    public static ArrayList<String> testers;
    public static JPasswordField password;
    public static JLabel pas;
    public static JButton done;
    public static JFrame fram;
    
    public AuthGui() {
        (AuthGui.fram = new JFrame("Authorization")).setSize(240, 105);
        AuthGui.fram.setResizable(false);
        AuthGui.fram.setLayout((LayoutManager)null);
        AuthGui.fram.setVisible(true);
        AuthGui.password.setBounds(70, 15, 150, 20);
        AuthGui.pas.setBounds(5, 15, 100, 20);
        AuthGui.done.setBounds(70, 45, 100, 20);
        AuthGui.fram.add((Component)AuthGui.done);
        AuthGui.fram.add((Component)AuthGui.pas);
        AuthGui.fram.add((Component)AuthGui.password);
        AuthGui.password.setEchoChar('*');
        AuthGui.fram.setLocationRelativeTo((Component)null);
        AuthGui.fram.setDefaultCloseOperation(3);
        AuthGui.done.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent ev) {
                AuthGui.getPassword();
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
            while ((AuthGui.line = r.readLine()) != null) {
                AuthGui.testers.add(AuthGui.line);
            }
        }
        catch (IOException e3) {
            e3.printStackTrace();
        }
        if (AuthGui.password.getPassword().equals(AuthGui.testers.get(0))) {
            MCUtils.frame.setVisible(true);
            Main.optionsInstance.setVisible(true);
            AuthGui.fram.setVisible(false);
        }
        else {
            JOptionPane.showMessageDialog((Component)null, "Incorrect password", "MCCheat", 2);
        }
        return null;
    }
    
    static {
        AuthGui.testers = new ArrayList<String>();
        AuthGui.password = new JPasswordField();
        AuthGui.pas = new JLabel("Password:");
        AuthGui.done = new JButton("Login");
    }
}
