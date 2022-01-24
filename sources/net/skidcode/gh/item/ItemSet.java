package net.skidcode.gh.item;
public class ItemSet {
    private String KKLI;
    private int[] I;
    
    public ItemSet(final String paramString, final int[] paramArrayOfInt) {
        this.KKLI = paramString;
        this.I = paramArrayOfInt;
    }
    
    public final int[] I() {
        return this.I;
    }
}
