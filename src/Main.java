//Main klassen som innehåller main metod
public class Main {
    public static void main(String[] args) {
        //Anropa Klasserna i main metoden
        GameMenu myGameMenu = new GameMenu();
        Game myGame = new Game();

        //Programmet avlutar när spelaren väljer "3", annars fortsätter programmet.
        while (myGameMenu.getMainOption() != 3){
            myGameMenu.mainMenu(myGame,myGameMenu);
        }
    }
}
