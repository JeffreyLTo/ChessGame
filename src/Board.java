import javafx.scene.layout.GridPane;


public class Board extends GridPane {
    //Create the array of tiles for the board for management needs.
    Tile[][] tiles = new Tile[8][8];
    Tile[] validMoves;

    // Variable to hold what tile is currently active
    public Tile activeTile = null;
    // Variable to set the current turn;
    public Player activePlayer;
    // Players for chess game
    Player player1;
    Player player2;
    // Variable to hold valid move list
    public Move list;

    public Board() {

        // Create two players
        player1 = new Player("white");
        player2 = new Player("black");
        activePlayer = player1;
        // Create array of tiles
        for (int i = 0; i < tiles[0].length; i++) {
            for (int j = 0; j < tiles[1].length; j++) {
                // Decide what color each tile should be
                String color;
                if ((i + j) % 2 == 0) {
                    color = "black";
                } else {
                    color = "white";
                }
                Tile tile = new Tile(color, i, j);
                tiles[i][j] = tile;

                // Set styling of tile and assign button event handler.
                tile.setStyle("-fx-background-color: " + color + ";");
                tiles[i][j].setOnAction(e -> reactTile(tile.getXpos(), tile.getYpos()));
                tile.setPrefSize(75, 75);
                this.add(tile, i, j);

            }
        }

        // Add black pieces to the Tiles for start of the game.
        tiles[0][0].setPiece(new Rook("black"));
        tiles[1][0].setPiece(new Knight("black"));
        tiles[2][0].setPiece(new Bishop("black"));
        tiles[3][0].setPiece(new Queen("black"));
        tiles[4][0].setPiece(new King("black"));
        tiles[5][0].setPiece(new Bishop("black"));
        tiles[6][0].setPiece(new Knight("black"));
        tiles[7][0].setPiece(new Rook("black"));

        for(int i = 0; i < tiles[0].length; i++) {
            tiles[i][1].setPiece(new Pawn("black"));
        }

        //Add White Pieces to tiles for start of the game.
        for(int i = 0; i < tiles[0].length; i++) {
            tiles[i][6].setPiece(new Pawn("white"));
        }

        tiles[0][7].setPiece(new Rook("white"));
        tiles[1][7].setPiece(new Knight("white"));
        tiles[2][7].setPiece(new Bishop("white"));
        tiles[3][7].setPiece(new Queen("white"));
        tiles[4][7].setPiece(new King("white"));
        tiles[5][7].setPiece(new Bishop("white"));
        tiles[6][7].setPiece(new Knight("white"));
        tiles[7][7].setPiece(new Rook("white"));




    }
    // Method to handle tile click response. Will do different things depending on whether something has been
    // previously clicked etc. Also currently handles moving pieces from tile to tile if conditions are met.
    public void reactTile(int xpos, int ypos) {





        Tile clickTile = tiles[xpos][ypos];

        if(activeTile == null && clickTile.isOccupied() && activePlayer.getColor().equals(clickTile.getPiece().getColor())) {
            activeTile = clickTile;
            activeTile.setStyle("-fx-border-color: red;");

            // Pass tile coordinates and piece into move method. This will determine what moves will be valid
            list = new Move(clickTile.getPiece(), tiles, activeTile.getXpos(), activeTile.getYpos());


        }
        // This will allow the user to "reset" their move if they double click on a tile.
        else if(activeTile == clickTile) {
            activeTile.setStyle("-fx-border-color: black;");
            activeTile.setStyle("-fx-background-color: " + activeTile.getColor() + ";");
            activeTile = null;
        }
        // Method to assign new tile active tiles piece. then will also reset active tile and its styling
        else if(activeTile != null && activeTile.isOccupied() && list.isValidMove(activeTile, clickTile)) {

            // The following will check to see if the movement was a Pawns first.
            if(activeTile.getPiece() instanceof Pawn) {
                Pawn temp = (Pawn) activeTile.getPiece();
                temp.setFirst(false);
                activeTile.setPiece(temp);
            }
            clickTile.setPiece(activeTile.getPiece());
            activeTile.setStyle("-fx-border-color: black;");
            activeTile.setStyle("-fx-background-color: " + activeTile.getColor() + ";");
            activeTile.setPiece(null);
            activeTile = null;
            list = null;

            if(activePlayer.getColor().equals("white")) {
                activePlayer = player2;
            }
            else {
                activePlayer = player1;
            }
        }








    }




}


