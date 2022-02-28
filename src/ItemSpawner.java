public class ItemSpawner {
    private kq KKLI;
    
    public ItemSpawner(final kq var1) {
        this.KKLI = var1;
    }
    
    public final void I(final int var1, final int var2, final int var3) {
        final int var4 = this.KKLI();
        if (var4 != -1) {
            if (var2 == 0) {
               this.KKLI.h.c.a[var4] = new iz(var1, var3, var2);
            }
            else {
             this.KKLI.h.c.a[var4] = new iz(var1, 1, var2 - 1);
            }
        }
    }
    
    public final void I(final int var1, final int var2, final int var3, int var4) {
        var4 = 3 - var4;
        if (var2 == 0) {
          this.KKLI.h.c.a[var4] = new iz(var1, var3, var2);
        }
        else {
        this.KKLI.h.c.a[var4] = new iz(var1, 1, var2 - 1);
        }
    }
    
    public final int KKLI() {
        iz var1 = null;
        for (int var2 = 0; var2 < 36; ++var2) {
            var1 = this.KKLI.h.c.a[var2];
            if (var1 == null) {
                return var2;
            }
        }
        return -1;
    }
}
