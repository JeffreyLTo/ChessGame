import javafx.scene.control.Button;
import javafx.scene.paint.Color;


public class Tile extends Button {

    private String color;
    private int xpos;
    private int ypos;
    private boolean occupied = false;
    private Piece piece;

    // Constructor for a tile piece, will assign a color, x and y position.
    public Tile(String color, int xpos, int ypos) {
        super();
        this.color = color;
        this.xpos = xpos;
        this.ypos = ypos;

    }

    // Method to get xposition of this tile
    public int getXpos() {
        return xpos;
    }

    // Method to get yposition of this tile
    public int getYpos() {
        return ypos;
    }

    // Method to get color of this tile/
    public String getColor() {
        return color;
    }

    // Method to see whether this tile is occupied by a piece
    public boolean isOccupied() {
        return occupied;
    }

    // Method to get what piece is on the tile.
    public Piece getPiece() {

        return this.piece;
    }

    // Method to set new piece onto a tile
    public void setPiece(Piece p) {
        this.piece = p;

        // Check if piece passed to tile is null (no piece) to change occupied status.
        if(piece == null) {
            occupied = false;
        } else {
            occupied = true;
        }
        // Update Labels for Tiles depending on what Piece is there
        if(piece == null) {
            this.setText("");
        } else {
            this.setText(piece.getType());
            if (piece.getColor().equals("white")) {
                this.setTextFill(Color.BLUE);
            } else {
                this.setTextFill(Color.GREEN);
            }
        }


    }

   
    public void movePiece(Piece p, int xcoor, int ycoor) {

    }

}
