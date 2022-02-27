
public class ItemDeleter {
    private gj gjInstance; /*BASECLASS*/
    
    public ItemDeleter(final gj paramgi) {
        this.gjInstance = paramgi;
    }
    
    public final void clearInventory() { 
        for (int i = 0; i < 36; ++i) {
            this.gjInstance.g.e.a[i] = null;
        }
    }
}
