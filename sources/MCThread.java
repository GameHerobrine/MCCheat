import net.skidcode.gh.Direction;
import net.skidcode.gh.TimeStatus;

public class MCThread implements Runnable {
    private boolean running;
    private gj mainhook; /*BASECLASS*/
    private boolean invuln;
    private boolean oxygen;
    private boolean nofiredamage;
    private boolean fly;
    private boolean hover;
    private TimeStatus timeofday;
    private Direction movementDirection;
    
    public MCThread(final gj paramgj) {
        this.running = false;
        this.invuln = false;
        this.oxygen = false;
        this.nofiredamage = false;
        this.fly = false;
        this.hover = false;
        this.timeofday = TimeStatus.NORMAL;
        this.movementDirection = Direction.NONE;
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
                if (this.nofiredamage) {
                    this.mainhook.g.bg = 0;
                }
                if (!this.movementDirection.equals(Direction.NONE)) {
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
                if (this.timeofday.equals(TimeStatus.DAY)) {
                    if (tod % 24000L >= 12000L) {
                        this.mainhook.e.e = (tod / 24000L + 1L) * 24000L;
                    }
                }
                else if (this.timeofday.equals(TimeStatus.NIGHT) && tod % 24000L < 12000L) {
                    this.mainhook.e.e = (tod / 24000L + 1L) * 24000L + 16000L;
                }
            }
            sleep(10);
        }
    }
    
    public final void startthread() {
        this.running = true;
        new Thread((Runnable)this).start();
    }
    
    private static void sleep(final int paramInt) {
        try {
            Thread.sleep((long)paramInt);
        }
        catch (InterruptedException ex) {}
    }
    
    public final void toggleGodMode(final boolean paramBoolean) {
        if (paramBoolean) {
            this.invuln = true;
        }
        else {
            this.invuln = false;
        }
    }
    
    public final void toggleBreathUnderwater(final boolean paramBoolean) {
        if (paramBoolean) {
            this.oxygen = true;
        }
        else {
            this.oxygen = false;
        }
    }
    
    public final void toggleNoFireDamage(final boolean paramBoolean) {
        if (paramBoolean) {
            this.nofiredamage = true;
            System.out.println("true!!");
        }
        else {
            this.nofiredamage = false;
        }
    }
    
    public final void toggleFly(final boolean paramBoolean) {
        if (paramBoolean) {
            this.fly = true;
        }
        else {
            this.fly = false;
        }
    }
    
    public final void toggleHoverMode(final boolean paramBoolean) {
        if (paramBoolean) {
            this.hover = true;
        }
        else {
            this.hover = false;
        }
    }
    
    public final void setCurrentMovementDirection(final Direction paramDirection) {
        this.movementDirection = paramDirection;
    }
    
    public final void setTime(final TimeStatus paramStatus) {
        this.timeofday = paramStatus;
    }
    
    private boolean check() {
        return this.mainhook.e != null && this.mainhook.g != null && this.mainhook.g.e != null;
    }
}
