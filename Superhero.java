import java.util.ArrayList;

public class Superhero implements Contract{

    //attributes
    private ArrayList<String> inventory;
    private String name;
    private SuperheroWeapon weapon;
    private int health;


    /**
     * Default constructor, only takes a name for the Superhero. 
     * @param name
     */
    public Superhero(String name){
        this.inventory = new ArrayList<String>();
        this.name = name;
        this.weapon = null;
        this.health = 100;
    }

    /**
     * Full constructor, creates a Superhero with an empty inventory.
     * @param name
     * @param weapon The Superhero's weapon (SuperheroWeapon.HAMMER, SHIELD, BOW_AND_ARROWS, LASSO, OTHER)
     * @param health 
     */
    public Superhero(String name, SuperheroWeapon weapon, int health){
        this.inventory = new ArrayList<String>();
        this.name = name;
        this.weapon = weapon;
        this.health = health;

    }

    /**
     * Allows the Superhero to pick up an object and add it to their inventory.
     * @param item The object to pick up.
     */
    public void grab(String item){
        inventory.add(item);
        System.out.println("You have grabbed a(n)" + item + ".");
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
     */
    public void examine(String item){
        int itemNum = 0;
        for (int i = 0; i <= this.inventory.size(); i++){
            if (this.inventory.get(i) == item){
            itemNum = itemNum + 1;
        }
        System.out.println("You have " + itemNum + item + "s in your inventory.");
        } 
    }

    public void use(String item){
    }

    public boolean walk(String direction){

    }

    boolean fly(int x, int y);
    Number shrink();
    Number grow();

    /**
     * Increases the Superhero's health by 10.
     */
    public void rest(){
        this.health = this.health + 10;
    }

    void undo();
}