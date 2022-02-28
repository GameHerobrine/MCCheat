package net.skidcode.gh;
public class Teleport {
    //private String KKLI;
    private double x;
    private double y;
    private double z;
    
    public Teleport(final String paramString, final double paramDouble1, final double paramDouble2, final double paramDouble3) {
        //this.KKLI = paramString;
        this.x = paramDouble1;
        this.y = paramDouble2;
        this.z = paramDouble3;
    }
    
    public final double I() {
        return this.x;
    }
    
    public final double Z() {
        return this.y;
    }
    
    public final double C() {
        return this.z;
    }
}
