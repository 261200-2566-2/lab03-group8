public class Weapon {
    private final String type;
    private String name;
    private double damStatBase = 0;
    private double defStatBase = 0;
    private int lv=0;
    Weapon(String name,String type,double stat){
        this.name = name;
        this.type = type;
        if(type.equals("sword")) damStatBase = stat;
        if(type.equals("shield")) defStatBase = stat;
    }
    Weapon(String type){
        this("",type,0);
    }
    String getType(){
        return type;
    }
     void lvUp(RPGcharacter p){ //character who use
        lv++;
        p.updateStat();//update character's status
     }
    double getDefStat(){
        //calculate stat base on defStatBase and lv
        return defStatBase*(1+0.05*this.lv);
    }
    double getDamStat(){
        //calculate stat base on damStatBase and lv
        return damStatBase*(1+0.1*this.lv);
    }
    String getName(){
        return name;
    }
    int getLv(){
        return lv;
    }
}
