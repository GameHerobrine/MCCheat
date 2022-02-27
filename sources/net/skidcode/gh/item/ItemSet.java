package net.skidcode.gh.item;
public class ItemSet {
    private int[] I;
    
    public ItemSet(final String paramString, final int[] paramArrayOfInt) {
        this.I = paramArrayOfInt;
    }
    
    public final int[] I() {
        return this.I;
    }
}
