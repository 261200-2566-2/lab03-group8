public class equipment {
    String type;
    String name;
    private double dmg;
    private double def;
    int swordLevel;
    int shieldLevel;
    public equipment(String name,String type,int level,int stat) {
        this.type = type;
        this.name = name;
        if(type.equals("sword")) {
            swordLevel = level;
            dmg = stat;
        }
        if(type.equals("shield")) {
            shieldLevel = level;
            def = stat;
        }
    }
    equipment(String type){
        this("",type,0,0);
    }
    int getSwordLevel(){
        return swordLevel;
    }
    int getShieldLevel(){
        return shieldLevel;
    }
    String getType(){
        return type;
    }
    double getDef(){
        return def;
    }
    double getDmg(){
        return dmg;
    }
    String getName(){
        return name;
    }
}
