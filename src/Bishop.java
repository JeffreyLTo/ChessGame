public class Bishop extends Piece {

    private String type = "Bishop";
    private String color;

    // Constructor to create a new bishop and assign a team color
    public Bishop(String color) {
        this.color = color;
    }

    @Override

    // Method to get the type of piece that this object is.
    String getType() {
        return type;
    }
    // Method to get color that this piece belongs to.
    String getColor() {return color;}

    // Method to eventually hold valid moves for a bishop, currently not in use.
    @Override
    void move() {

    }
}
