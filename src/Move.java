public class Move {
    // Will hold the moves that are allowed for a particular piece
    Tile[] moveList;

    // move counters
    int i;
    int j;

    //Master constructor to create a move list object. Will create move list depending on what piece was passed in
    public Move(Piece p, Tile[][] board, int xpos, int ypos) {
        int counter = 0;

        // Create valid move list for pawns
        if (p instanceof Pawn) {
            Pawn temp = (Pawn) p;
            moveList = new Tile[5];

            //move list for a white pawn
            if (p.getColor().equals("white")) {
                // Forward movement
                if (ypos - 1 >= 0) {
                    if (!(board[xpos][ypos - 1].isOccupied())) {
                        moveList[counter] = board[xpos][ypos - 1];
                        counter++;
                    }
                }
                // First move check for additional movement
                if (temp.getFirst()) {
                    if (!(board[xpos][ypos - 2].isOccupied())) {
                        moveList[counter] = board[xpos][ypos - 2];
                        counter++;
                    }
                }

                //Check if left diagonal is occupied
                if ((xpos - 1 >= 0) && (ypos - 1 >= 0) && (board[xpos - 1][ypos - 1].isOccupied())) {
                    moveList[counter] = board[xpos - 1][ypos - 1];
                    counter++;
                }
                //Check if right diagonal is occupied
                if ((xpos + 1 < 8) && (ypos - 1 >= 0) && (board[xpos + 1][ypos - 1].isOccupied())) {
                    moveList[counter] = board[xpos + 1][ypos - 1];
                    counter++;
                }

            }
            //Movement for a black pawn
            if (p.getColor().equals("black")) {
                // Forward movement
                if (ypos + 1 < 8) {
                    if (!(board[xpos][ypos + 1].isOccupied())) {
                        moveList[counter] = board[xpos][ypos + 1];
                        counter++;
                    }
                }
                // First move check for additional movement
                if (temp.getFirst()) {
                    if (!(board[xpos][ypos + 2].isOccupied())) {
                        moveList[counter] = board[xpos][ypos + 2];
                        counter++;
                    }
                }

                //Check if left diagonal is occupied
                if ((xpos - 1 >= 0) && (ypos + 1 < 8) && (board[xpos - 1][ypos + 1].isOccupied())) {
                    moveList[counter] = board[xpos - 1][ypos + 1];
                    counter++;
                }
                //Check if right diagonal is occupied
                if ((xpos + 1 < 8) && (ypos + 1 < 8) && (board[xpos + 1][ypos + 1].isOccupied())) {
                    moveList[counter] = board[xpos + 1][ypos + 1];
                    counter++;
                }

            }


        }

        // Create valid move list for knights
        if (p instanceof Knight) {
            moveList = new Tile[8];
            // Top left move check
            if ((ypos + 2 < 8) && (xpos - 1 >= 0))
                moveList[counter] = board[xpos - 1][ypos + 2];
            counter++;

            if ((ypos + 1 < 8) && (xpos - 2 >= 0)) {
                moveList[counter] = board[xpos - 2][ypos + 1];
                counter++;
            }
            // Top right move check
            if ((ypos + 2 < 8) && (xpos + 1 < 8)) {
                moveList[counter] = board[xpos + 1][ypos + 2];
                counter++;
            }
            if ((ypos + 1 < 8) && (xpos + 2 < 8)) {
                moveList[counter] = board[xpos + 2][ypos + 1];
                counter++;
            }
            //Bottom left move check
            if ((ypos - 2 >= 0) && (xpos - 1 >= 0)) {
                moveList[counter] = board[xpos - 1][ypos - 2];
                counter++;
            }
            if ((ypos - 1 >= 0) && (xpos - 2 >= 0)) {
                moveList[counter] = board[xpos - 2][ypos - 1];
                counter++;
            }
            //Bottom right move check
            if ((ypos - 2 >= 0) && (xpos + 1 < 8)) {
                moveList[counter] = board[xpos + 1][ypos - 2];
                counter++;
            }
            if ((ypos - 1 >= 0) && (xpos + 2 < 8)) {
                moveList[counter] = board[xpos + 2][ypos - 1];
                counter++;
            }


        }

        //Create Valid move list for bishop
        if(p instanceof Bishop) {
            moveList = new Tile[20];

            //Top left movement check
            int i = xpos - 1;
            int j = ypos - 1;
            if((i >= 0) && (j >= 0)) {
                 while(i > 0 && j >0 && !(board[i][j].isOccupied())) {
                    moveList[counter] = board[i][j];
                    counter++;
                    i--; j--;
                }
                moveList[counter] = board[i][j];
                counter++;

            }


            // top right movement check
            i = xpos + 1;
            j = ypos - 1;
            if((i < 8) && (j >= 0)) {
                while(i < 7 && j > 0 && !(board[i][j].isOccupied())){
                    moveList[counter] = board[i][j];
                    counter++; i++; j--;
                }
                moveList[counter] = board[i][j];
                counter++;
            }


            //bottom left movement check
            i = xpos - 1;
            j = ypos + 1;
            if((i >= 0) && (j < 8)) {
                while(i > 0 && j < 7 && !(board[i][j].isOccupied())){
                    moveList[counter] = board[i][j];
                    counter++; i--; j++;
                }
                moveList[counter] = board[i][j];
                counter++;
            }


            //bottom right movement check
            i = xpos + 1;
            j = ypos + 1;
            if((i < 8) && (j < 8)) {
                while(i < 7 && j < 7 && !(board[i][j].isOccupied())){
                    moveList[counter] = board[i][j];
                    counter++; i++; j++;
                }
            moveList[counter] = board[i][j];
            }
        }

        //create move list for rook
        if(p instanceof Rook) {
            moveList = new Tile[20];

            //Vertical movement check
            // Moving up the board
            i = xpos;
            j = ypos - 1;
            if(j >= 0) {
                while(j > 0 && !(board[i][j].isOccupied())) {
                    moveList[counter] = board[i][j];
                    counter++; j--;
                }
                moveList[counter] = board[i][j];
                counter++;
            }

            // Moving down the board
            i = xpos;
            j = ypos + 1;
            if(j < 8) {
                while(j < 7 && !(board[i][j].isOccupied())) {
                    moveList[counter] = board[i][j];
                    counter++; j++;
                }
                moveList[counter] = board[i][j];
                counter++;
            }

            // Horizontal Movement
            // Moving left on the board
            i = xpos - 1;
            j = ypos;
            if(i >= 0) {
                while(i > 0 && !(board[i][j].isOccupied())) {
                    moveList[counter] = board[i][j];
                    counter++; i--;
                }
                moveList[counter] = board[i][j];
                counter++;
            }

            // Moving right on the board
            i = xpos + 1;
            j = ypos;
            if(i < 8) {
                while(i < 7 && !(board[i][j].isOccupied())) {
                    moveList[counter] = board[i][j];
                    counter++; i++;
                }
                moveList[counter] = board[i][j];
                counter++;
            }
        }

        //Create move list for Queen. A queen moves like a bishop and rook combined.
        // Reusing code for Bishop and Rook.
        if(p instanceof Queen) {
            moveList = new Tile[30];

            //Diagonal Movement. Movement.
            //Top left movement check
            int i = xpos - 1;
            int j = ypos - 1;
            if((i >= 0) && (j >= 0)) {
                while(i > 0 && j >0 && !(board[i][j].isOccupied())) {
                    moveList[counter] = board[i][j];
                    counter++;
                    i--; j--;
                }
                moveList[counter] = board[i][j];
                counter++;

            }

            // top right movement check
            i = xpos + 1;
            j = ypos - 1;
            if((i < 8) && (j >= 0)) {
                while(i < 7 && j > 0 && !(board[i][j].isOccupied())){
                    moveList[counter] = board[i][j];
                    counter++; i++; j--;
                }
                moveList[counter] = board[i][j];
                counter++;
            }

            //bottom left movement check
            i = xpos - 1;
            j = ypos + 1;
            if((i > 0) && (j < 8)) {
                while(i > 0 && j < 7 && !(board[i][j].isOccupied())){
                    moveList[counter] = board[i][j];
                    counter++; i--; j++;
                }
                moveList[counter] = board[i][j];
                counter++;
            }

            //bottom right movement check
            i = xpos + 1;
            j = ypos + 1;
            if((i < 8) && (j < 8)) {
                while(i < 7 && j < 7 && !(board[i][j].isOccupied())){
                    moveList[counter] = board[i][j];
                    counter++; i++; j++;
                }
                moveList[counter] = board[i][j];
            }

            //Vertical movement check
            // Moving up the board
            i = xpos;
            j = ypos - 1;
            if(j >= 0) {
                while(j > 0 && !(board[i][j].isOccupied())) {
                    moveList[counter] = board[i][j];
                    counter++; j--;
                }
                moveList[counter] = board[i][j];
                counter++;
            }

            // Moving down the board
            i = xpos;
            j = ypos + 1;
            if(j < 8) {
                while(j < 7 && !(board[i][j].isOccupied())) {
                    moveList[counter] = board[i][j];
                    counter++; j++;
                }
                moveList[counter] = board[i][j];
                counter++;
            }

            // Horizontal Movement
            // Moving left on the board
            i = xpos - 1;
            j = ypos;
            if(i >= 0) {
                while(i > 0 && !(board[i][j].isOccupied())) {
                    moveList[counter] = board[i][j];
                    counter++; i--;
                }
                moveList[counter] = board[i][j];
                counter++;
            }

            // Moving left on the board
            i = xpos + 1;
            j = ypos;
            if(i < 8) {
                while(i < 7 && !(board[i][j].isOccupied())) {
                    moveList[counter] = board[i][j];
                    counter++; i++;
                }
                moveList[counter] = board[i][j];
                counter++;
            }
        }

        //create move list for a king.
        if(p instanceof King) {
            moveList = new Tile[8];

            //move up 1 square
            if (ypos - 1 >= 0) {
                    moveList[counter] = board[xpos][ypos - 1];
                    counter++;
            }

            //move down 1 square
            if (ypos + 1 < 8) {
                moveList[counter] = board[xpos][ypos + 1];
                counter++;
            }

            //move left 1 square
            if (xpos - 1 >= 0) {
                moveList[counter] = board[xpos - 1][ypos];
                counter++;
            }

            //move right 1 square
            if (xpos + 1 < 8) {
                moveList[counter] = board[xpos + 1][ypos];
                counter++;
            }

            //move up-left 1 square
            if((xpos - 1 >= 0) && (ypos -1 >= 0)) {
                moveList[counter] = board[xpos -1][ypos -1];
                counter++;
            }

            //move down-right 1 square
            if((xpos +1 < 8) && (ypos +1 < 8)) {
                moveList[counter] = board[xpos +1][ypos +1];
                counter++;
            }
            //move up-right 1 square
            if((xpos + 1 < 8) && (ypos -1 >= 0)) {
                moveList[counter] = board[xpos + 1][ypos -1];
                counter++;
            }
            //move down-left 1 square
            if((xpos -1 >= 0) && (ypos + 1 < 8)) {
                moveList[counter] = board[xpos -1][ypos +1];
                counter++;
            }

        }

    }


    public boolean isValidMove(Tile active, Tile t) {
        for(Tile check : moveList ) {
            if(check != null) {
                if(t == check) {
                    if(!(check.isOccupied()) || !(check.getPiece().getColor().equals(active.getPiece().getColor())))
                    return true;
                }
            }
        }
        return false;
    }
}
