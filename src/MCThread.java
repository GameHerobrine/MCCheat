import net.skidcode.gh.Direction;
import net.skidcode.gh.Status;

public class MCThread implements Runnable {
    private boolean running;
 public static kq mainhook; /*BASECLASS A126*/
    private boolean invuln;
    private boolean oxygen;
    private boolean KKLI;
    private boolean fly;
    private boolean hover;
    private Status timeofday;
    private Direction movement;
    
    public MCThread(final kq paramgj) {
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
                final long tod = this.mainhook.f.f;
                if (this.fly) {
                    this.mainhook.h.aX = true;
               this.mainhook.h.bk = 0.0f;
 //mainhook.func_6272_a(new nd(mainhook.g.b, mainhook.g.b.craftingInventory));

                    
                 
                    
                }
                if (this.hover) {
                  this.mainhook.h.aQ = 0.0;
                }
                if (this.invuln) {
             ///   	System.out.println("activated");
                this.mainhook.h.Y = 20;
                   this.mainhook.h.ad = 0;
                  this.mainhook.h.aa = 0;

                }
                if (this.oxygen) {

            //   this.mainhook.h.bp = 1000F; //STEP
          mainhook.h.bz = 300;
                }
                if (this.KKLI) {
               this.mainhook.h.bC = true;
                }
                if (!this.movement.equals(Direction.NONE)) {
                 final dc player = this.mainhook.h;
              player.aP *= 1.1;
                   final dc player2 = this.mainhook.h;  //alpha 1.2.6: az = motionX
                player2.aR *= 1.1;
                   if (this.mainhook.h.aP < -0.7) {
                      this.mainhook.h.aP = -0.7;
                  }
                   if (this.mainhook.h.aP > 0.7) {
                       this.mainhook.h.aP = 0.7;
                   }
                   if (this.mainhook.h.aR < -0.7) {
                       this.mainhook.h.aR = -0.7;
                   }
                   if (this.mainhook.h.aR > 0.7) {
                       this.mainhook.h.aR = 0.7;
                  }
                }
                if (this.timeofday.equals(Status.I)) {
                 
              
                 this.mainhook.h.aI.a(0);
                    
                }
                   else if (this.timeofday.equals(Status.Z) && tod % 24000L < 12000L) {

                this.mainhook.h.aI.a(0);
                this.mainhook.f.a(0);
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
        return this.mainhook.f != null && this.mainhook.h != null && this.mainhook.h.aI != null;
    }
    
    public void a(final String paramString) {
    }
}
