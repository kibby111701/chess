import java.awt.Color;

public class Board{
    private Square[][] squares;

    public Board(){
        squares = new Square[8][8];
        boolean isBlack = false;

        for (int row = 0; row < squares.length; row++){
            
            if (row % 2 == 0){
                isBlack = true;
            }

            for (int col = 0; col < squares[row].length; col++){
                int file = col + 1;
                int rank = 8 - row;
                Color color = Color.WHITE;
                if (isBlack){
                    color = Color.BLACK;
                }


                squares[row][col] = new Square(rank, file, color);
                isBlack = !isBlack;
            }
        }
    }

    public Square getSquare(int rank, int file){
        return squares[squares.length - rank][file - 1];
    }
}