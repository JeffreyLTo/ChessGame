public class Pawn extends Piece {

    private String type = "Pawn";
    private String color;
    private boolean firstMove = true;

    //Constructor for a pawn.
    public Pawn(String color){
        this.color = color;
    }
    @Override

    // Method to get type this piece is.
    String getType() {
        return type;
    }

    // Method to get what team this piece belongs to.
    String getColor() {return color;}

    //Method to get first move status of the pawn
    boolean getFirst() {return firstMove;}

    void setFirst(boolean first) { firstMove = first;}

    // Method to determine how a pawn moves. not in use
    @Override
    void move() {
    }
}
