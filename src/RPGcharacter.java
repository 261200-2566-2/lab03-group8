import java.text.DecimalFormat;

public class RPGcharacter {
    DecimalFormat df = new DecimalFormat("#.##");
    private int lv = 0; //starter Lv
    private int hp = 100; // 100 + 10*0
    private int mp = 50; //mana 50 + 2*0
    String name;
    private final double runSpeedBase;
    private double maxRunSpeed;
    private double runSpeed;
    private Weapon lh = new Weapon("nothing");
    private Weapon rh = new Weapon("nothing");;
    private double damStat = 0;
    private double defStat = 0;
    RPGcharacter(String name,double r){
        this.name = name;
        this.runSpeedBase = r;
        this.runSpeed = runSpeedBase;
        this.maxRunSpeed = runSpeedBase;
    }
     void LvUp(){
        lv++;
        hp = 100 + 10*lv; //charLv
        mp = 50 +2*lv; //charLv
        maxRunSpeed += runSpeedBase*(0.1+0.03*lv);
        updateStat();
    }
    void equipWeapon(Weapon eq,String hand){
        if( hand.equals("left" ) && lh.getType().equals("nothing")){
            lh = eq;
            setStat(eq);
        } else if(hand.equals("left" ) && !lh.getType().equals("nothing")){
            System.out.println("Left hand is full.");
        } else if( hand.equals("right" ) && rh.getType().equals("nothing")){
            rh = eq;
            setStat(eq);
        } else if(hand.equals("right" ) && !rh.getType().equals("nothing")){
            System.out.println("Right hand is full.");
        }
    }

    private void setStat(Weapon w){
        if(w.getType().equals("sword")) {
            runSpeed -=  runSpeedBase*(0.1+0.04*w.getLv()); //weaponLv
            damStat += w.getDamStat();
        }
        if(w.getType().equals("shield")) {
            runSpeed -= runSpeedBase*(0.1+0.08*w.getLv()); //weaponLv
            defStat += w.getDefStat();
        }
    }

    void removeWeapon(String hand){
        if(hand.equals("left")){
            lh = new Weapon("nothing");
        }
        if(hand.equals("right")){
            rh = new Weapon("nothing");
        }
        updateStat();
    }

    public void updateStat(){
        damStat =0;
        defStat =0;
        runSpeed = maxRunSpeed;
        setStat(lh); //left hand
        setStat(rh); //right hand
    }

    void statusWindow(){
        System.out.println("_____________________________");
        System.out.println("        Name : "+name);
        System.out.println("          Lv : "+lv);
        System.out.println("       MaxHP : "+hp);
        System.out.println("        Mana : "+mp);
        System.out.println("    runSpeed : "+df.format(runSpeed));
        System.out.println("     damStat : "+damStat);
        System.out.println("     defStat : "+defStat);
        System.out.println("    _________________      ");
        System.out.print("    leftHand : "+lh.getType());
        if(!lh.getType().equals("nothing")) System.out.println("(" +lh.getName()+" lv."+lh.getLv()+")");
        else System.out.println(" ");
        System.out.print("   rightHand : "+rh.getType());
        if(!rh.getType().equals("nothing")) System.out.println("(" +rh.getName()+" lv."+rh.getLv()+")");
        else System.out.println(" ");
        System.out.println("_____________________________");
        System.out.println(" ");
    }
}
