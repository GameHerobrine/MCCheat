package net.skidcode.gh;
public class Teleport {
    private double x;
    private double y;
    private double z;
    
    public Teleport(final String paramString, final double paramDouble1, final double paramDouble2, final double paramDouble3) {
        this.x = paramDouble1;
        this.y = paramDouble2;
        this.z = paramDouble3;
    }
    
    public final double getX() {
        return this.x;
    }
    
    public final double getY() {
        return this.y;
    }
    
    public final double getZ() {
        return this.z;
    }
}
