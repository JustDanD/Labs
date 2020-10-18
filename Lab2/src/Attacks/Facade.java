package Attacks;

import ru.ifmo.se.pokemon.*;

public class Facade extends PhysicalMove {
    public Facade() {
        super(Type.NORMAL, 70, 100);
    }

    @Override
    protected double calcBaseDamage(Pokemon att, Pokemon def) {
        if (def.getCondition() == Status.BURN | def.getCondition() == Status.PARALYZE | def.getCondition() == Status.POISON)
            return 2 * super.calcBaseDamage(att, def);
        else
            return super.calcBaseDamage(att, def);
    }
    @Override
    protected String describe() {
        return super.describe() + " используя Facade";
    }
}
