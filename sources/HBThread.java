
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.HttpURLConnection;
import java.net.URL;

public class HBThread implements Runnable {
    private boolean KKLI;
    private GuiOptions SEVERE;
    private long connect;
    private long currentTimeMillis;
    
    public HBThread(final GuiOptions paramGUI) {
        this.KKLI = false;
        this.SEVERE = paramGUI;
        this.disconnect();
    }
    
    public final void run() {
        while (this.KKLI) {
            if (this.SEVERE()) {
                this.KKLI();
            }
            if (this.connect()) {
                this.currentTimeMillis();
            }
            getInputStream(10000);
        }
    }
    
    private void KKLI() {
        try {
            final URL localURL = new URL("http://www.mccheat.net/mccheat/heartbeat.php");
            final HttpURLConnection localHttpURLConnection = (HttpURLConnection)localURL.openConnection();
            localHttpURLConnection.connect();
            localHttpURLConnection.getInputStream();
            localHttpURLConnection.disconnect();
            this.connect = System.currentTimeMillis();
            System.out.println("Sent..");
        }
        catch (IOException localIOException) {
            Logger.getLogger(HBThread.class.getName()).log(Level.SEVERE, (String)null, (Throwable)localIOException);
        }
    }
    
    private boolean SEVERE() {
        return System.currentTimeMillis() - this.connect >= 300000L;
    }
    
    private boolean connect() {
        return System.currentTimeMillis() - this.currentTimeMillis >= 60000L;
    }
    
    private void currentTimeMillis() {
        try {
            final URL localURL = new URL("http://www.mccheat.net/mccheat/users.php");
            final BufferedReader localBufferedReader = new BufferedReader((Reader)new InputStreamReader(localURL.openStream()));
            final String str = localBufferedReader.readLine().trim();
            this.SEVERE.f1I.setText(str);
            this.currentTimeMillis = System.currentTimeMillis();
        }
        catch (IOException localIOException) {
            Logger.getLogger(HBThread.class.getName()).log(Level.SEVERE, (String)null, (Throwable)localIOException);
        }
    }
    
    private void disconnect() {
        this.KKLI = true;
        new Thread((Runnable)this).start();
    }
    
    private static void getInputStream(final int paramInt) {
        try {
            Thread.sleep((long)paramInt);
        }
        catch (InterruptedException ex) {}
    }
}
