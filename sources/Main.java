import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import java.net.URL;
import java.net.URLClassLoader;
import javax.swing.JOptionPane;

import java.awt.Component;
import java.io.File;
import java.net.MalformedURLException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class Main {
    public static GuiOptions optionsInstance;
    public static GUI2 Z;
    public static String line;
    public static ArrayList<String> testers;
    private static String[] KKLI;
    
    public static final void main(final String[] var0) throws NoSuchMethodException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, MalformedURLException, ClassNotFoundException {
        SEVERE();
        final GuiOptions i = Main.optionsInstance;
        GuiOptions.Z();
        KKLI();
        final gj var = MCUtils.AddWindow();
        Main.optionsInstance = new GuiOptions(var);
        Main.Z = new GUI2();
        Main.optionsInstance.setVisible(true);
        Main.Z.setVisible(false);
        new HBThread(Main.optionsInstance);
    }
    
    private static void KKLI() throws NoSuchMethodException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, MalformedURLException, ClassNotFoundException {
        final GuiOptions i = Main.optionsInstance;
        final File var0 = new File(GuiOptions.I(), "bin");
        if (!var0.exists()) {
            JOptionPane.showMessageDialog((Component)null, "Please run Minecraft at least one time before using MCCheat.", "MCCheat", 2);
            System.exit(0);
        }
        final File var2 = new File(var0, "natives");
        System.setProperty("net.java.games.input.librarypath", var2.getAbsolutePath());
        System.setProperty("org.lwjgl.librarypath", var2.getAbsolutePath());
        final URLClassLoader var3 = (URLClassLoader)ClassLoader.getSystemClassLoader();
        final Method var4 = URLClassLoader.class.getDeclaredMethod("addURL", new Class[] { URL.class });
        var4.setAccessible(true);
        final Field var5 = ClassLoader.class.getDeclaredField("package2certs");
        var5.setAccessible(true);
        final ConcurrentHashMap var6 = (ConcurrentHashMap)var5.get(var3);
        for (final File var10 : var0.listFiles()) {
            var4.invoke(var3, new Object[] { var10.toURL() });
        }
        var6.remove("");
        Class.forName("gj");
        var6.remove("");
        for (int var11 = 0; var11 < Main.KKLI.length; ++var11) {
            Class.forName(net.skidcode.gh.Type.class.getName());
        }
        var6.remove("");
    }
    
    private static void SEVERE() {
        BufferedReader var0 = null;
        try {
            final URL var2 = new URL("https://sites.google.com/view/mccheat-net/mccheat-net");
            var0 = new BufferedReader((Reader)new InputStreamReader(var2.openStream()));
            var0.close();
        }
        catch (IOException var3) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, (String)null, (Throwable)var3);
            try {
                var0.close();
            }
            catch (IOException var4) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, (String)null, (Throwable)var4);
            }
        }
        finally {
            try {
                var0.close();
            }
            catch (IOException var5) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, (String)null, (Throwable)var5);
            }
        }
    }
    
    static {
        Main.testers = (ArrayList<String>)new ArrayList();
        Main.KKLI = new String[] { "Direction", "GUI", "GUI$1", "GUI$2", "GUI$3", "GUI$4", "GUI$5", "GUI$6", "GUI$7", "GUI$8", "GUI$9", "GUI$10", "GUI$11", "GUI$12", "GUI$13", "GUI$14", "GUI$15", "GUI$16", "GUI$17", "GUI$18", "GUI$19", "GUI$20", "GUI$21", "GUI$22", "GUI2", "GUI2$1", "HBThread", "Item", "ItemDeleter", "ItemSet", "ItemSpawner", "Main", "MCThread", "MCUtils", "Status", "Teleport", "Type", "GUI3", "GUI3$1" };
    }
}
