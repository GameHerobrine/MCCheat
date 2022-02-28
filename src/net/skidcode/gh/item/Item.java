package net.skidcode.gh.item;
import net.skidcode.gh.Type;

public class Item {
    private String KKLI;
    private int I;
    private Type Z;
    
    public Item(final String paramString, final int paramInt, final Type paramType) {
        this.KKLI = paramString;
        this.I = paramInt;
        this.Z = paramType;
    }
    
    public final String I() {
        return this.KKLI;
    }
    
    public final int Z() {
        return this.I;
    }
    
    public final Enum C() {
        return this.Z;
    }
}
