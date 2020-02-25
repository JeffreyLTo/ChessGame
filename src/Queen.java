public class Queen extends Piece {

    private String type = "Queen";
    private String color;

    //Constructor for a queen piece
    public Queen(String color) {
        this.color = color;
    }

    // Method to get type of piece this is.
    @Override
    String getType() {
        return type;
    }

    // Method to get what team this piece belongs to.
    String getColor() {return color;}

    // Method to handle how a queen piece can move. Not currently in use.
    @Override
    void move() {

    }
}
