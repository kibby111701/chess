import java.awt.Color;

public class Board{
    private Square[][] squares;

    public Board(){
        squares = new Square[8][8];


        for (int row = 0; row < squares.length; row++){
            boolean isBlack = false;
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

    // public void clearBoard(){
    //     for (int i = 0; i <= 7; i++){
    //         for (int j = 0; j <= 7; j++){
    //             if squares[i][j]
    //         }
    //     }
    // }
}