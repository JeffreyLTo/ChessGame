public class Rook extends Piece {

    private String type = "Rook";
    private String color;

    // Constructor for a rook
    public Rook(String color) {
        this.color = color;
    }

    // Method to get what type of piece this is.
    @Override
    String getType() {
        return type;
    }

    // Method to get what team this piece belongs to.
    String getColor() {return color;}

    // Method to handle how a rook should move. Not currently in use.
    @Override
    void move() {

    }
}
