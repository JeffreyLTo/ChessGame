public abstract class Piece {
    String color;
    String type;

    // Abstract class to represent a board game piece.

    abstract String getType();

    abstract String getColor();
    abstract void move();

}
