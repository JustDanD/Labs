public class Bread {
    private double size, cursize, instance = 100;

    public Bread(double size) {
        this.instance = 100;
        this.size = size;
        this.cursize = size;
    }

    void use(double step, Animals type) {
        switch (type) {
            case DUCK:
                if (step <= 0.6 * size) {
                    while (instance > 50) {
                        cursize = cursize - step;
                        instance = cursize / size * 100;
                    }
                    return;
                }
                else {
                    cursize = 0.5 * size; //Можно выкинуть эксепшн
                    instance = 50;
                }
                break;
            case BEAR:
                while (instance > 0) {
                    cursize = cursize - step;
                    instance = cursize / size * 100;
                }
                return;
        }
    }
    @Override
    public int hashCode () {
        return super.hashCode() + 25;
    }
    @Override
    public String toString() {
        return "Cur bread size:" + this.size + "; cursize:" + this.cursize + "instance:" + this.instance;
    }
    @Override
    public boolean equals( Object o) {
        if (o instanceof Bread) {
            if (this.hashCode() == ((Bread)o).hashCode() && (this.toString() == ((Bread)o).toString()))
                return true;
        }
        return false;
    }
}
