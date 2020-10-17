package Attacks;

import ru.ifmo.se.pokemon.*;

public class Facade extends PhysicalMove {
    public Facade() {
        super(Type.NORMAL, 70, 100);
    }

    @Override
    protected double calcCriticalHit(Pokemon att, Pokemon def) {
        if (def.getCondition() == Status.BURN | def.getCondition() == Status.PARALYZE | def.getCondition() == Status.POISON)
            return 2;
        else
            return super.calcCriticalHit(att, def);
    }
}
