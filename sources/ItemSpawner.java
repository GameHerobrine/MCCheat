public class ItemSpawner {
    private gj gjInstance; /*BASECLASS*/
    
    public ItemSpawner(final gj var1) {
        this.gjInstance = var1;
    }
    
    public final void spawnItemToNextFreeSlot(final int var1, final int var2, final int var3) {
        final int var4 = this.getNextFreeSlot();
        if (var4 != -1) {
            if (var2 == 0) {
                this.gjInstance.g.e.a[var4] = new fp(var1, var3, var2);
            }
            else {
                this.gjInstance.g.e.a[var4] = new fp(var1, 1, var2 - 1);
            }
        }
    }
    
    public final void spawnItemToSpecificSlot(final int var1, final int var2, final int var3, int var4) {
        var4 = 3 - var4;
        if (var2 == 0) {
        	
            this.gjInstance.g.e.b[var4] = new fp(var1, var3, var2); /*ItemStack instance*/
        }
        else {
            this.gjInstance.g.e.b[var4] = new fp(var1, 1, var2 - 1); /*ItemStack instance*/
        }
    }
    
    public final int getNextFreeSlot() {
        fp var1 = null;
        for (int var2 = 0; var2 < 36; ++var2) {
            var1 = this.gjInstance.g.e.a[var2];
            if (var1 == null) {
                return var2;
            }
        }
        return -1;
    }
}
