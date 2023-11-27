public class test {
        public static void main(String[] args) {
            RPGCharacter m = new RPGCharacter("Mind",1.0);
            RPGCharacter f = new RPGCharacter("Film",1.5);
            equipment r = new equipment("red","sword",1,150);
            equipment b = new equipment("blue","sword",1,170);
            equipment g = new equipment("green","shield",1,130);
            m.statusWindow();
            f.statusWindow();
            m.equip(r);
            m.statusWindow();
            m.equip(g);
            m.statusWindow();

            f.equip(r);
            f.equip(g);
            f.equip(b);
            f.statusWindow();

            f.levelUp();
            f.statusWindow();

            m.levelUp();
            m.statusWindow();
        }
    }

