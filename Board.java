import java.awt.Color;

public class Board{
    private Square[][] squares;
    private int rankCount;
    private int fileCount;

    public Board(int rankCount, int fileCount){
        this.rankCount = rankCount;
        this.fileCount = fileCount;
        squares = new Square[rankCount][fileCount];


        for (int row = 0; row < squares.length; row++){
            boolean isBlack = false;
            if (row % 2 == 0){
                isBlack = true;
            }

            for (int col = 0; col < squares[row].length; col++){
                int file = col + 1;
                int rank = rankCount - row;
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

    public void clearBoard(){
        for (int i = 0; i <= rankCount - 1; i++){
            for (int j = 0; j <= fileCount - 1; j++){
                if (squares[i][j].isHighlighted()){
                    squares[i][j].toggleHighlight();
                }
                
                if (squares[i][j].getColor().equals(Color.BLACK)){
                    squares[i][j].setPiece("@");
                }
                else{
                    squares[i][j].setPiece("#");
                }
            }
        }
    }

    public int getRankCount(){
        return this.rankCount;
    }

    public int getFileCount(){
        return this.fileCount;
    }
}