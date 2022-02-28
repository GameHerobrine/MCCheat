import java.awt.event.WindowListener;
import net.minecraft.client.Minecraft;
import net.minecraft.client.MinecraftApplet;

import java.awt.Dimension;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTextField;

public class MCUtils {
    public static String line;
    public static ArrayList<String> testers;
    public static GUI3 gui;
    public static JFrame frame;
    public static         JTextField F = new JTextField();
    public static final gj addWindowListener() {
        final Frame var3 = new Frame("Minecraft");
        final Canvas var4 = new Canvas();
        var3.setLayout((LayoutManager)new BorderLayout());
        var3.add((Component)var4, "Center");
        var4.setPreferredSize(new Dimension(854, 480));
        var3.pack();
        var3.setLocationRelativeTo((Component)null);
        final kq var5 = new kq((Component)var3, var4, (MinecraftApplet)null, 854, 480, false, var3);
        final Thread var6 = new Thread((Runnable)var5, "Minecraft main thread");
        var6.setPriority(10);
    //    var5.l = false;
      //  var5.j = "www.minecraft.net";
        var3.setVisible(true);
        //var3.addWindowListener((WindowListener)new gn((Minecraft)var5, var6));
        var6.start();
     //   return var5;
        return null;
    }
    public static void Nick(){
        JFrame f = new JFrame("f");
        f.setSize(200, 200);
        f.setVisible(true);
        JButton b = new JButton("B");
        b.setBounds(0, 0, 200, 20);
        f.add(b);
F.setBounds(0, 0, 200, 50);
f.add(F);
b.addActionListener((ActionEvent e) -> {
    

       
    });
    }
    public static final kq AddWindow(String var0, String var1, String var2) {
     boolean var3 = false;
		Frame var5 = new Frame("Minecraft");
		Canvas var6 = new Canvas();
		var5.setLayout(new BorderLayout());
		var5.add(var6, "Center");
		var6.setPreferredSize(new Dimension(854, 480));
		var5.pack();
		var5.setLocationRelativeTo((Component)null);
		kq var7 = new kq(var5, var6, (MinecraftApplet)null, 854, 480, var3, var5);
		Thread var8 = new Thread(var7, "Minecraft main thread");
		var8.setPriority(10);
		//var7.minecraftUri = "www.minecraft.net";
		if(var0 != null && var1 != null) {
			var7.k = new gr(var0, var1);
		} else {
			var7.k = new gr("Player" + System.currentTimeMillis() % 1000L, "");
		}

		if(var2 != null) {
			String[] var9 = var2.split(":"); //
		//	var7.a(var9[0], Integer.parseInt(var9[1]));
		}

		var5.setVisible(true);
		var5.addWindowListener(new kj(var7, var8));
		var8.start();
        return var7;
	}
}
