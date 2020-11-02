package Attacks;

import ru.ifmo.se.pokemon.*;

public class LeechLife extends PhysicalMove {
    public LeechLife() {
        super(Type.BUG, 80, 100);
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        int heal = (int)(-0.5 * (p.getStat(Stat.HP)  - p.getHP()));
        p.setMod(Stat.HP, heal);
    }

    @Override
    protected String describe() {
        return super.describe() + " используя Leech Life";
    }
}
