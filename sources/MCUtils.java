import java.awt.event.WindowListener;
import net.minecraft.client.Minecraft;
import net.minecraft.client.MinecraftApplet;

import java.awt.Dimension;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Frame;
import javax.swing.JFrame;
import java.util.ArrayList;

public class MCUtils {
    public static String line;
    public static ArrayList<String> testers;
    public static GUI3 gui;
    public static JFrame frame;
    
    public static final gj addWindowListener() {
        final Frame var3 = new Frame("Minecraft");
        final Canvas var4 = new Canvas();
        var3.setLayout((LayoutManager)new BorderLayout());
        var3.add((Component)var4, "Center");
        var4.setPreferredSize(new Dimension(854, 480));
        var3.pack();
        var3.setLocationRelativeTo((Component)null);
        final gj var5 = new gj((Component)var3, var4, (MinecraftApplet)null, 854, 480, false, var3);
        final Thread var6 = new Thread((Runnable)var5, "Minecraft main thread");
        var6.setPriority(10);
        var5.l = false;
        var5.j = "www.minecraft.net";
        var3.setVisible(true);
        var3.addWindowListener((WindowListener)new gn((Minecraft)var5, var6));
        var6.start();
        return var5;
    }
    
    public static final gj AddWindow() {
        final boolean flag = false;
        final String s3 = "PlayerName";
        MCUtils.frame = new JFrame("Minecraft");
        final Canvas canvas = new Canvas();
        MCUtils.frame.setLayout((LayoutManager)new BorderLayout());
        MCUtils.frame.add((Component)canvas, "Center");
        canvas.setPreferredSize(new Dimension(854, 480));
        MCUtils.frame.pack();
        MCUtils.frame.setLocationRelativeTo((Component)null);
        final gj minecraftimpl = new gj((Component)MCUtils.frame, canvas, (MinecraftApplet)null, 854, 480, flag, (Frame)MCUtils.frame);
        final Thread thread = new Thread((Runnable)minecraftimpl, "Minecraft main thread");
        thread.setPriority(10);
        minecraftimpl.l = false;
        minecraftimpl.j = "www.minecraft.net";
        if (s3 != null && "555" != null) {
            minecraftimpl.i = new ea(s3, "555");
        }
        else {
            minecraftimpl.i = new ea(new StringBuilder().append("PlayerName").append(System.currentTimeMillis() % 1000L).toString(), "");
        }
        if ("" != null) {
            final String[] as = "".split(":");
        }
        MCUtils.frame.setVisible(true);
        MCUtils.frame.addWindowListener((WindowListener)new gn((Minecraft)minecraftimpl, thread));
        thread.start();
        return minecraftimpl;
    }
    
    static {
        MCUtils.testers = (ArrayList<String>)new ArrayList();
    }
}
