public class King extends Piece {

    private String type = "King";
    private String color;

    // Constru tor for a king piece.
    public King(String color) {
        this.color = color;
    }

    // Method to get type this piece is
    @Override
    String getType() {
        return type;
    }

    // Method to get what team this piece belongs to.
    String getColor() {return color;}

    //Method to store valid move for a King. Not currently in use.
    @Override
    void move() {

    }
}
