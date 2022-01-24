import net.skidcode.gh.Direction;
import net.skidcode.gh.Status;

public class MCThread implements Runnable {
    private boolean running;
    private gj mainhook; /*BASECLASS A126*/
    private boolean invuln;
    private boolean oxygen;
    private boolean KKLI;
    private boolean fly;
    private boolean hover;
    private Status timeofday;
    private Direction movement;
    
    public MCThread(final gj paramgj) {
        this.running = false;
        this.invuln = false;
        this.oxygen = false;
        this.KKLI = false;
        this.fly = false;
        this.hover = false;
        this.timeofday = Status.C;
        this.movement = Direction.NONE;
        this.mainhook = paramgj;
    }
    
    public void mo() {
    }
    
    public final void run() {
        while (this.running) {
            if (this.check()) {
                final long tod = this.mainhook.e.e;
                if (this.fly) {
                    this.mainhook.g.aH = true;
                    this.mainhook.g.aU = 0.0f;
                }
                if (this.hover) {
                    this.mainhook.g.aA = 0.0;
                }
                if (this.invuln) {
                	System.out.println("activated");
                    this.mainhook.g.J = 20;
                    this.mainhook.g.L = 0;
                    this.mainhook.g.O = 0;
                }
                if (this.oxygen) {
                    this.mainhook.g.bk = 300;
                }
                if (this.KKLI) {
                    this.mainhook.g.bg = 0;
                }
                if (!this.movement.equals(Direction.NONE)) {
                    final bq g = this.mainhook.g;
                    g.az *= 1.1;
                    final bq g2 = this.mainhook.g;
                    g2.aB *= 1.1;
                    if (this.mainhook.g.az < -0.7) {
                        this.mainhook.g.az = -0.7;
                    }
                    if (this.mainhook.g.az > 0.7) {
                        this.mainhook.g.az = 0.7;
                    }
                    if (this.mainhook.g.aB < -0.7) {
                        this.mainhook.g.aB = -0.7;
                    }
                    if (this.mainhook.g.aB > 0.7) {
                        this.mainhook.g.aB = 0.7;
                    }
                }
                if (this.timeofday.equals(Status.I)) {
                    if (tod % 24000L >= 12000L) {
                        this.mainhook.e.e = (tod / 24000L + 1L) * 24000L;
                    }
                }
                else if (this.timeofday.equals(Status.Z) && tod % 24000L < 12000L) {
                    this.mainhook.e.e = (tod / 24000L + 1L) * 24000L + 16000L;
                }
            }
            D(10);
        }
    }
    
    public final void startthread() {
        this.running = true;
        new Thread((Runnable)this).start();
    }
    
    private static void D(final int paramInt) {
        try {
            Thread.sleep((long)paramInt);
        }
        catch (InterruptedException ex) {}
    }
    
    public final void I(final boolean paramBoolean) {
        if (paramBoolean) {
            this.invuln = true;
        }
        else {
            this.invuln = false;
        }
    }
    
    public final void Z(final boolean paramBoolean) {
        if (paramBoolean) {
            this.oxygen = true;
        }
        else {
            this.oxygen = false;
        }
    }
    
    public final void C(final boolean paramBoolean) {
        if (paramBoolean) {
            this.KKLI = true;
        }
        else {
            this.KKLI = false;
        }
    }
    
    public final void B(final boolean paramBoolean) {
        if (paramBoolean) {
            this.fly = true;
        }
        else {
            this.fly = false;
        }
    }
    
    public final void D(final boolean paramBoolean) {
        if (paramBoolean) {
            this.hover = true;
        }
        else {
            this.hover = false;
        }
    }
    
    public final void I(final Direction paramDirection) {
        this.movement = paramDirection;
    }
    
    public final void I(final Status paramStatus) {
        this.timeofday = paramStatus;
    }
    
    private boolean check() {
        return this.mainhook.e != null && this.mainhook.g != null && this.mainhook.g.e != null;
    }
    
    public void a(final String paramString) {
    }
}
