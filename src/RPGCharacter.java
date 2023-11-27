public class RPGCharacter {
    private String name;
    private int lv;
    private double hp;
    private double mana;
    private double runSpeedBase;
    private double runSpeedMax;
    private double runSpeed;
    private equipment e1 = new equipment("nothing");
    private equipment e2 = new equipment("nothing");
    private double dmg;
    private double def;

    public RPGCharacter(String name, double r) {
        this.name = name;
        this.runSpeedBase = r;
        this.runSpeed = runSpeedBase;
        this.runSpeedMax = runSpeedBase;
        this.dmg = 0;
        this.def = 0;
        this.hp = 100;
        this.mana = 50;
    }
    public void setStat(equipment weapon, String eqType) {
        switch (eqType) {
            case "sword":
                runSpeed -= runSpeedBase * (0.1 + 0.04 * e1.swordLevel);
                dmg += dmg * (1 + 0.1 * e1.swordLevel);
                break;
            case "shield":
                runSpeed -= runSpeedBase * (0.1 + 0.08 * e2.shieldLevel);
                def += def * (1 + 0.05 * e2.shieldLevel);
                break;
            default:
                System.out.println("Invalid equipment type: " + eqType);
        }
    }

    public void equip(equipment weapon) {
        if (weapon != null) {
            if (weapon.getType().equals("sword")) {
                if (e1.getType().equals("nothing")) {
                    e1 = weapon;
                    System.out.println("You equipped the " + weapon.getName());
                } else {
                    System.out.println("You already have a sword equipped.");
                }
            } else if (weapon.getType().equals("shield")) {
                if (e2.getType().equals("nothing")) {
                    e2 = weapon;
                    System.out.println("You equipped the " + weapon.getName());
                } else {
                    System.out.println("You already have a shield equipped.");
                }
            } else {
                System.out.println("Invalid equipment type: " + weapon.getType());
            }
        } else {
            System.out.println("There is no weapon to equip.");
        }
    }
    void levelUp(){
        lv++;
        hp = 100 + 10*lv;
        mana = 50 +2*lv;
        runSpeedMax += runSpeedBase*(0.1+0.03*lv);
        updateStat();
    }
    void updateStat(){
        runSpeed = runSpeedMax;
        setStat(e1,"sword");
        setStat(e2,"shield");
    }
    void statusWindow(){
        System.out.println("_____________________________");
        System.out.println("        Name : "+name);
        System.out.println("          Lv : "+lv);
        System.out.println("       MaxHP : "+hp);
        System.out.println("        Mana : "+mana);
        System.out.println("    runSpeed : "+runSpeed);
        System.out.println("     dmg : "+dmg);
        System.out.println("     def : "+def);
        System.out.println("    _________________      ");
        System.out.print("    weapon 1 : "+e1.getType());
        if(!e1.getType().equals("nothing") && e1.getType().equals("sword")) System.out.println("(" +e1.getName()+" lv."+e1.getSwordLevel()+")");
        else System.out.println(" ");
        System.out.print("   weapon 2 : "+e2.getType());
        if(!e2.getType().equals("nothing") && e2.getType().equals("shield")) System.out.println("(" +e2.getName()+" lv."+e2.getShieldLevel()+")");
        else System.out.println(" ");
        System.out.println("_____________________________");
        System.out.println(" ");
    }
}