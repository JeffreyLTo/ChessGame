public class Knight extends Piece {

    private String type = "Knight";
    private String color;

    // Constructor for a knight piece
    public Knight(String color) {
        this.color = color;
    }

    // Method to get what type of piece this is.
    @Override
    String getType() {
        return type;
    }

    // Method to get what team this piece belongs to
    String getColor() {return color;}

    // Method to handle how a knight will move. not currently in use
    @Override
    void move() {


    }
}
