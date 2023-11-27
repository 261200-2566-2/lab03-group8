
public class Test {
    public static void main(String[] args) {
        RPGcharacter m = new RPGcharacter("Mind",1.0);
        RPGcharacter f = new RPGcharacter("film",1.5);
        Weapon r = new Weapon("red","sword",150);
        Weapon b = new Weapon("blue","sword",170);
        Weapon g = new Weapon("green","shield",130);
        m.statusWindow();
        f.statusWindow();
        m.equipWeapon(r,"left");
        m.statusWindow();
        m.equipWeapon(g,"left");
        m.equipWeapon(g,"right");
        m.statusWindow();

        f.equipWeapon(r,"left");
        f.equipWeapon(g,"left");
        f.equipWeapon(b,"right");
        f.statusWindow();

        m.removeWeapon("left");
        m.statusWindow();

        f.removeWeapon("right");
        f.statusWindow();

        //m.LvUp();
        m.removeWeapon("right");
        m.statusWindow();

        f.LvUp();
        f.statusWindow();

        m.LvUp();
        m.statusWindow();

        r.lvUp(f);
        r.lvUp(f);
        r.lvUp(f);
        f.statusWindow();
    }
}