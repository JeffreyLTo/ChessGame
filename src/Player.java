/*
    Player: Class that will handle an instance of player. Mainly will be used to decide what turn it is and whether
    the tile that is clicked is valid for that player. Currently not in use since turns have not been implemented.

 */

public class Player {



    private String color;

    public Player(String color) {
        this.color = color;
    }

    public String getColor() {return this.color;}
}
