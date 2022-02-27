package net.skidcode.gh.item;
import net.skidcode.gh.Type;

public class Item {
    private String name;
    private int itemID;
    private Type type;
    
    public Item(final String paramString, final int paramInt, final Type paramType) {
        this.name = paramString;
        this.itemID = paramInt;
        this.type = paramType;
    }
    
    public final String getName() {
        return this.name;
    }
    
    public final int getItemID() {
        return this.itemID;
    }
    
    public final Type getType() {
        return this.type;
    }
}
