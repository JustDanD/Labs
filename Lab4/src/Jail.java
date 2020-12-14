import java.util.ArrayList;

public class Jail {
    private Object[] prisoners;
    private int maxPris = 100, curcnt;

    public Jail() {
        this.prisoners = new Object[maxPris];
        this.curcnt = 0;
    }

    public int getCurcnt() {
        return curcnt;
    }

    public int getMaxPris() {
        return maxPris;
    }

    public Object[] getPrisoners() {
        return prisoners;
    }
    public Object getPrisoner( int i ) {
        if (i > 0 && i <= curcnt)
         return prisoners[i];
        else
            return null;
    }
    public boolean addPrisoner( Object pris) {
        if (curcnt < maxPris) {
            prisoners[curcnt] = pris;
            return true;
        }
        return false;
    }
}
