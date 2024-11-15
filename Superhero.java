import java.util.ArrayList;

public class Superhero implements Contract{

    private ArrayList<String> inventory;
    private String name;
    private SuperheroWeapon weapon;
    private int health;
    private Number size; 
    private boolean moving;

    /**
     * Default constructor, only takes a name for the Superhero. 
     * @param name The Superhero's name.
     */
    public Superhero(String name){
        this.inventory = new ArrayList<String>();
        this.name = name;
        this.weapon = null;
        this.health = 100;
        this.size = 5;
        this.moving = false;
    }

    /**
     * Full constructor, creates a Superhero with an empty inventory.
     * @param name The Superhero's name.
     * @param weapon The Superhero's weapon (SuperheroWeapon.HAMMER, SHIELD, BOW_AND_ARROWS, LASSO, OTHER)
     * @param health An integer between 0 and 100 to represent the Superhero's health.
     * @param size A number between 1 and 10 to represent the Superhero's size.
     */
    public Superhero(String name, SuperheroWeapon weapon, int health, Number size){
        this.inventory = new ArrayList<String>();
        this.name = name;
        this.weapon = weapon;
        this.moving = false;
        if (health >= 0 & health <= 100){
            this.health = health;
        } else{
            throw new RuntimeException("Health must be between 0 and 100.");
        }
        if (size.intValue() >= 1 & size.intValue() <= 10){
            this.size = size;
        } else{
            throw new RuntimeException("Size must be between 1 and 10.");
        }

    }

    /**
     * Allows the Superhero to pick up an object and add it to their inventory.
     * @param item The object to pick up.
     */
    public void grab(String item){
        inventory.add(item);
        System.out.println("You have grabbed a(n) " + item + ".");
    }

    /**
     * Allows the Superhero to drop an item and remove it from their inventory.
     * @param item The object to drop.
     * @return The object that was removed from the inventory.
     */
    public String drop(String item){
        if (inventory.contains(item)){
            inventory.remove(item);
            System.out.println("You have dropped " + item + ". It is no longer in your inventory.");
            return item;
        } else{
            throw new RuntimeException(item + " is not in your inventory.");
        }

    }

    /**
     * Examines the Superhero's inventory to determine how many of an object they are holding.
     * @param item The object to count in the inventory.
     */
    public void examine(String item){
        int itemNum = 0;
        for (int i = 0; i < this.inventory.size(); i++){
            if (this.inventory.get(i) == item){
            itemNum = itemNum + 1;
            }
        }
        System.out.println("You have " + itemNum + " " + item + "(s) in your inventory.");   
    }

    /**
     * Uses an object in the Superhero's inventory. This action removes the object from the inventory.
     * @param item The object to use.
     */
    public void use(String item){
        if (this.inventory.contains(item)){
            System.out.println("You used a " + item + ". It is no longer in your inventory.");
            this.inventory.remove(item);
        } else{
            throw new RuntimeException(item + " is not in your inventory.");
        }
    }

    /**
     * Makes the Superhero start walking in a given direction.
     * @param direction The direction to walk in.
     */
    public boolean walk(String direction){
        System.out.println("You are walking " + direction + ".");
        this.moving = true;
        return this.moving;
    }

    /**
     * Makes the Superhero fly.
     * @param x The speed the Superhero is flying.
     * @param y The height at which the Superhero is flying.
     */
    public boolean fly(int x, int y){
        System.out.println("You are flying at " + x + "mph. Your height is " + y + " feet.");
        this.moving = true;
        return this.moving;
    }


    /**
     * Shrinks the Superhero's size by 1.
     */
    public Number shrink(){
        if (this.health > 5){
            if (this.size.intValue() > 1){
                this.size = this.size.intValue() - 1;
                this.health = this.health - 5;
                return this.size;
            } else{
                throw new RuntimeException("You are already as small as you can shrink.");
            }
        } else{
            throw new RuntimeException("You need to rest before you can shrink.");
        }

    }
    
    /**
     * Grows the Superhero's size by 1.
     */
    public Number grow(){
        if (this.health > 5){
            if (this.size.intValue() < 10){
                this.size = this.size.intValue() + 1;
                this.health = this.health - 5;
                return this.size;
            } else{
                throw new RuntimeException("You are already as large as you can grow.");
            }
        } else{
            throw new RuntimeException("You need to rest before you can grow.");
        }

    }

    /**
     * Increases the Superhero's health by 10.
     */
    public void rest(){
        if (this.health <= 90){
            this.health = this.health + 10;
        }
        System.out.println("You have rested. Your health is now " + this.health + ".");
    }

    /**
     * Resets the Superhero's health, size, and moving status to default values.
     */
    public void undo(){
        this.health = 100;
        this.size = 5;
        this.moving = false;
        System.out.println("Your health is now " + this.health + ", your size is now " + this.size + ", and you are not moving.");
    }

    /**
     * Tests the class's methods.
     * @param args
     */
    public static void main(String[] args) {
        //test constructors
        Superhero spiderman = new Superhero("Spiderman");
        Superhero ironMan = new Superhero("Iron Man", SuperheroWeapon.HAMMER, 5, 2);
        System.out.println(spiderman.health);
        System.out.println(ironMan.weapon);

        //test .grab()
        spiderman.grab("spider");
        spiderman.grab("spider");
        spiderman.grab("water");
        spiderman.grab("computer");
        System.out.println(spiderman.inventory);

        //test .drop()
        spiderman.drop("water");
        try{
            spiderman.drop("water");
        } catch(Exception e){
            System.out.println(e);
        }
        System.out.println(spiderman.inventory);

        //test .examine()
        spiderman.examine("spider");
        spiderman.examine("computer");
        spiderman.examine("water");
        System.out.println(spiderman.inventory);

        //test .use()
        spiderman.use("spider");
        System.out.println(spiderman.inventory);
        try{ 
            spiderman.use("water");
        } catch(Exception e){
            System.out.println(e);
        }
        
        //test .walk()
        System.out.println(spiderman.moving);
        spiderman.walk("south");
        System.out.println(spiderman.moving);
        
        //test .fly()
        spiderman.fly(2, 2);

        //test .shrink()
        System.out.println(spiderman.health);
        System.out.println(spiderman.size);
        spiderman.shrink();
        System.out.println(spiderman.health);
        System.out.println(spiderman.size);
        try{
            ironMan.shrink();
        } catch(Exception e){
            System.out.println(e);
        }
        spiderman.shrink();
        spiderman.shrink();
        spiderman.shrink();
        try{
            spiderman.shrink();
        } catch(Exception e){
            System.out.println(e);
        }

        // test .rest()
        System.out.println(ironMan.health);
        ironMan.rest();
        System.out.println(spiderman.health);
        spiderman.rest();
        spiderman.rest();
        spiderman.rest();

        //test .grow()
        System.out.println(spiderman.size);
        spiderman.grow();

        //test .undo()
        System.out.println(spiderman.health);
        System.out.println(spiderman.size);
        System.out.println(spiderman.moving);
        spiderman.undo();


    }
}