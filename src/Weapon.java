public class Weapon {
    private final String type;
    private String name;
    private double damStat = 0;
    private double defStat = 0;
    Weapon(String name,String type,double stat){
        this.name = name;
        this.type = type;
        if(type.equals("sword")) damStat = stat;
        if(type.equals("shield")) defStat = stat;
    }
    Weapon(String type){
        this("",type,0);
    }
    String getType(){
        return type;
    }
    double getDefStat(){
        return defStat;
    }
    double getDamStat(){
        return damStat;
    }
    String getName(){
        return name;
    }
}
