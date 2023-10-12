public class Aircraft {
    protected int maxAmmo;
    protected int baseDamage;
    protected int currentAmmo;

    public Aircraft(int maxAmmo, int baseDamage) {
        this.maxAmmo = maxAmmo;
        this.baseDamage = baseDamage;
        this.currentAmmo = 0;
    }

    public int fight() {
        int damage = currentAmmo * baseDamage;
        currentAmmo = 0;
        return damage;
    }

    public int refillAmmo(int ammo) {
        int remainingAmmo;
        if (ammo >= maxAmmo - currentAmmo) {
            remainingAmmo = ammo - (maxAmmo - currentAmmo);
            currentAmmo = maxAmmo;
        } else {
            currentAmmo += ammo;
            remainingAmmo = 0;
        }
        return remainingAmmo;
    }

    public String getType() {
        return this.getClass().getSimpleName();
    }

    public String getStatus() {
        return "Type " + getType() + ", Ammo: " + currentAmmo + ", Base Damage: " + baseDamage +
                ", All Damage: " + (currentAmmo * baseDamage);
    }

    public boolean isPriority() {
        return false;
    }
}

class F16 extends Aircraft {
    public F16() {
        super(8, 30);
    }
}

class F35 extends Aircraft {
    public F35() {
        super(12, 50);
    }

    @Override
    public boolean isPriority() {
        return true;
    }

    public static void main(String[] args) {
        Aircraft f16 = new F16();
        Aircraft f35 = new F35();

        f16.refillAmmo(6);
        f35.refillAmmo(10);

        System.out.println(f16.getStatus());
        System.out.println(f35.getStatus());

        System.out.println("F16 damage: " + f16.fight());
        System.out.println("F35 damage: " + f35.fight());

        System.out.println(f16.getStatus());
        System.out.println(f35.getStatus());
    }
}
