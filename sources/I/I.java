package I;

import javax.swing.UIManager;
import java.lang.reflect.Field;
import java.io.File;
import sun.misc.Unsafe;

public class I {
    private static Unsafe KKLI;
    
    public static final File getMinecraftDir() {
        final String var0 = System.getProperty("os.name", "").toLowerCase();
        final String var2 = System.getProperty("user.home", ".");
        if (var0.contains("win")) {
            final String var3 = System.getenv("APPDATA");
            return (var3 != null) ? new File(var3, ".minecraft") : new File(var2, ".minecraft");
        }
        return var0.contains("mac") ? new File(var2, "Library/Application Support/minecraft") : new File(var2, ".minecraft/");
    }
    
    private static Unsafe KKLI() {
        try {
            final Field var0 = Unsafe.class.getDeclaredField("theUnsafe");
            var0.setAccessible(true);
            return (Unsafe)var0.get(Unsafe.class);
        }
        catch (SecurityException var2) {
            throw new RuntimeException((Throwable)var2);
        }
        catch (NoSuchFieldException var3) {
            throw new RuntimeException((Throwable)var3);
        }
        catch (IllegalArgumentException var4) {
            throw new RuntimeException((Throwable)var4);
        }
        catch (IllegalAccessException var5) {
            throw new RuntimeException((Throwable)var5);
        }
    }
    
    public static final boolean Z() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            return true;
        }
        catch (Exception var1) {
            System.out.println("Okay, I won't have a native L&F.");
            return false;
        }
    }
    
    static {
        I.KKLI = KKLI();
    }
}
