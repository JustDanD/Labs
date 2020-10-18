package Attacks;

import ru.ifmo.se.pokemon.*;

public class WakeUpSlap extends PhysicalMove {
    public WakeUpSlap() {
        super(Type.FIGHTING, 70, 100);
    }

    @Override
    protected double calcBaseDamage(Pokemon att, Pokemon def) {
       if (def.getCondition() == Status.SLEEP)
           return 2 * super.calcBaseDamage(att, def);
       else
           return super.calcBaseDamage(att, def);
    }

    @Override
    protected String describe() {
        return super.describe() + " используя Wake-Up Slap";
    }
}
