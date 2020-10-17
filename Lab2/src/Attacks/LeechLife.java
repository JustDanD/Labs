package Attacks;

import ru.ifmo.se.pokemon.*;

public class LeechLife extends PhysicalMove {
    public LeechLife() {
        super(Type.BUG, 80, 100);
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        p.setStats(p.getStat(Stat.HP) - 0.5 * (p.getStat(Stat.HP) - p.getHP()),
                      p.getStat(Stat.ATTACK),
                      p.getStat(Stat.DEFENSE),
                      p.getStat(Stat.SPECIAL_ATTACK),
                      p.getStat(Stat.SPECIAL_DEFENSE),
                      p.getStat(Stat.SPEED));
        p.restore();
    }
}
