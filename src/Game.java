import java.util.ArrayList;
import java.util.Objects;

//klassen Game som jämför resultatet av spelet
public class Game {
    //Anropar olika variabler

    private ArrayList<String> resultList = new ArrayList<>();
    // matchResult - tre olika resultat "Oavgjort, Vann, Förlorade"
    // computersResult - datorns val "Sten, Sax, Påse"
    // playersResult - spelarens val "Sten, Sax, Påse"
    private String matchResult, computersResult, playersResult;
    private int computersChoice;

    //Olika get och set metoder
    public ArrayList<String> getResultList() {
        return resultList;
    }

    public void setMatchResult(String matchResult) {
        this.matchResult = matchResult;
    }

    public String getMatchResult() {
        return matchResult;
    }

    public void setComputersChoice(int computersChoice) {
        this.computersChoice = (int) (1 + Math.random() * 3);
    }

    public int getComputersChoice() {
        return computersChoice;
    }

    public void setComputersResult(String computersResult) {
        this.computersResult = computersResult;
    }

    public String getComputersResult() {
        return computersResult;
    }

    public void setPlayersResult(String playersResult) {
        this.playersResult = playersResult;
    }

    public String getPlayersResult() {
        return playersResult;
    }

    //Metoden jämför spelarens val och datorns val.
    public void gameResult(GameMenu myGameMenu) {
        //Anropa metoden för att läsa in datorns val varje gång
        setComputersChoice((int) (1 + Math.random() * 3));

        if(myGameMenu.getPlayersChoice()== getComputersChoice()) {
            setMatchResult("Oavgjort");
            if (getComputersChoice() == 1) {
                setPlayersResult("Sten");
                setComputersResult("Sten");}
            else if (getComputersChoice() == 2) {
                setPlayersResult("Sax");
                setComputersResult("Sax");}
            else if (getComputersChoice() == 3) {
                setPlayersResult("Påse");
                setComputersResult("Påse");}
        }
        else if(myGameMenu.getPlayersChoice()==1 && getComputersChoice()==2) {
            setPlayersResult("Sten");
            setMatchResult("Vann");
            setComputersResult("Sax");}
        else if(myGameMenu.getPlayersChoice()==1 && getComputersChoice()==3) {
            setPlayersResult("Sten");
            setMatchResult("Förlorade");
            setComputersResult("Påse");}
        else if(myGameMenu.getPlayersChoice()==2 && getComputersChoice()==1) {
            setPlayersResult("Sax");
            setMatchResult("Förlorade");
            setComputersResult("Sten");}
        else if(myGameMenu.getPlayersChoice()==2 && getComputersChoice()==3) {
            setPlayersResult("Sax");
            setMatchResult("Vann");
            setComputersResult("Påse");}
        else if(myGameMenu.getPlayersChoice()==3 && getComputersChoice()==1) {
            setPlayersResult("Påse");
            setMatchResult("Vann");
            setComputersResult("Sten");}
        else if(myGameMenu.getPlayersChoice()==3 && getComputersChoice()==2) {
            setPlayersResult("Påse");
            setMatchResult("Förlorade");
            setComputersResult("Sax");}

        //Arraylisten håller alla resultaten av spelet
        resultList.add(getMatchResult());
}
    //Metoden skriver ut ett meddelande av spelets resultat till spelaren
    public void showGameResult(GameMenu myGameMenu){
        //Anropa metoden för att kontrollera resultat av spelet
        gameResult(myGameMenu);
        if (Objects.equals(getMatchResult(), "Oavgjort")){
            System.out.println("Oavgjort! Du Gjorde Samma Val Som Datorn!");
            System.out.println("Spelaren: " + getPlayersResult() + "\nDatorn: " + getComputersResult());
        }
        else if (Objects.equals(getMatchResult(),"Vann")){
            System.out.println("Du Vann! Bra Jobbat!");
            System.out.println("Spelaren: " + getPlayersResult() + "\nDatorn: " + getComputersResult());
        }
        else if (Objects.equals(getMatchResult(),"Förlorade")){
            System.out.println("Tyvärr! Du Förlorade!");
            System.out.println("Spelaren: " + getPlayersResult() + "\nDatorn: " + getComputersResult());
        }
    }

    //Metoden skriver ut alla resultaten av spelet (när spelaren väljer "Historik" i Main Menu)
    public void resultHistory() {

        //Om det är i början av spelet, finns det inget resultat i Arraylisten,
        // då skriver ut programmet ett meddelande till spelaren.
        if (getResultList().isEmpty()) {
            System.out.println("Ingen historia! Börja spela en ny match.");
        } else {
            System.out.println("Showing history: ");
            for (int i = 0; i < getResultList().size(); i++) {
                System.out.println(getResultList().get(i));
            }
        }
    }
}
