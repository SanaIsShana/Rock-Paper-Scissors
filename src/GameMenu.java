import java.util.Scanner;

//Klassen GameMenu som visar spelaren menyn av spelet
public class GameMenu {
    //Skaffar olika variabler
    private Scanner gameScanner = new Scanner(System.in);
    // mainOption - när man väljer från Main Meny
    // playersChoice - när spelaren väljer "Sten,Sax,Påse"
    // afterMatchOption - när spelaren väljer från den tredje menyn
    private int mainOption, playersChoice, afterMatchOption;

    //olika get och set metoder.
    public Scanner getGameScanner() {
        return gameScanner;
    }

    public void setMainOption(int mainOption) {
        this.mainOption = mainOption;
    }

    public int getMainOption() {
        return mainOption;
    }

    public void setPlayersChoice(int playersChoice) {
        this.playersChoice = playersChoice;
    }

    public int getPlayersChoice() {
        return playersChoice;
    }

    public void setAfterMatchOption(int afterMatchOption) {
        this.afterMatchOption = afterMatchOption;
    }

    public int getAfterMatchOption() {
        return afterMatchOption;
    }

    //metoden som visar MainMenu för spelaren
    public void mainMenu(Game myGame, GameMenu myGameMenu){
        //Skriver ut den första menyn och läser in spelarens val
        System.out.println("1.Ny Match 2.Historik 3.Avsluta Spelet");
        //läser in spelarens val
        setMainOption(gameScanner.nextInt());
        switch (getMainOption()){
            case 1:
                //Anropar metoden som skriver ut den andra meny (Players Choice Menu)
                playersChoiceMenu(myGameMenu, myGame);
                break;
                //Anropar objektet myGames metod som skriver ut alla resultaten av spelet
            case 2:
                myGame.resultHistory();
                break;
            case 3:
                System.out.println("Spelet avslutar.");
                System.exit(0);
                break;
        }
    }

    //metoden visar den andra menyn för spelaren
    public void playersChoiceMenu(GameMenu myGameMenu, Game myGame){
        //Läser in spelarens val
        System.out.println("Vad väljer du?\n1.Sten 2.Sax 3.Påse");
        setPlayersChoice(gameScanner.nextInt());

        //Anropar metoden som jämföra spelarens val med datorns val
        myGame.showGameResult(myGameMenu);
        //Skriver ut den tredje menyn
        afterMatchMenu(myGame,myGameMenu);
    }

    //metod för den tredje menyn
    public void afterMatchMenu(Game myGame, GameMenu myGameMenu){
        //Läser in spelarens val
        System.out.println("1.Meny 2.Kör igen 3.Avsluta Spelet");
        setAfterMatchOption(gameScanner.nextInt());
        switch (getAfterMatchOption()){
            case 1:
                //Metoden skriver ut den första meny (Main Menu)
                mainMenu(myGame, myGameMenu);
                break;
            case 2:
                //Metoden skriver ut Players Choice Menu
                playersChoiceMenu(myGameMenu, myGame);
                break;
            case 3:
                System.out.println("Spelet avslutar.");
                System.exit(0);
                break;
        }
    }
}
