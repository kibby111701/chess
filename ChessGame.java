import java.util.*;

public class ChessGame{

    private Board board;

    public ChessGame() {
        this.board = new Board();
    }

    public int placeRook(int rank, int file){
        int influence = 0;
        
        if (board.getSquare(rank, file) != null){
            board.getSquare(rank, file).setPiece("r");

            for (int i = 1; i <= 8; i++){
                if (i != file){
                    board.getSquare(rank, i).toggleHighlight();
                    influence += 1;
                }
            }

            for (int i = 1; i <= 8; i++){
                if (i != rank){
                    board.getSquare(i, file).toggleHighlight();
                    influence += 1;
                }
            }

        }
        System.out.println(influence);
        return influence;
    }


    public int placeKnight(int rank, int file){
        int influence = 0;
        
        if (board.getSquare(rank, file) != null){

            board.getSquare(rank, file).setPiece("k");

            for (int i = 1; i <= 8; i++){
                for (int j = 1; j <= 8; j++){
                    if (dist(rank, file, i, j) == Math.sqrt(5)){
                        board.getSquare(i, j).toggleHighlight();
                        influence += 1;
                    }
                }
            }
        }
        System.out.println(influence);
        return influence;
    }

    public int placeBishop(int rank, int file){
        int influence = 0;

        if (board.getSquare(rank, file) != null){
            board.getSquare(rank, file).setPiece("b");

            for (int i = 1; i <= 8; i++){
                for (int j = 1; j <= 8; j++){
                    int rankDist = Math.abs(rank - i);
                    int fileDist = Math.abs(file - j);

                    if (rankDist == fileDist && i != rank){
                        board.getSquare(i, j).toggleHighlight();
                        influence += 1;
                    }
                }
            }
        }
        System.out.println(influence);
        return influence;
    }

    public int placeQueen(int rank, int file){
        int influence = 0;

        if (board.getSquare(rank, file) != null){
            board.getSquare(rank, file).setPiece("q");

            for (int i = 1; i <= 8; i++){
                for (int j = 1; j <= 8; j++){
                    int rankDist = Math.abs(rank - i);
                    int fileDist = Math.abs(file - j);

                    if (rankDist == fileDist && i != rank){
                        board.getSquare(i, j).toggleHighlight();
                        influence += 1;
                    }
                }
            }

            for (int i = 1; i <= 8; i++){
                if (i != file){
                    board.getSquare(rank, i).toggleHighlight();
                    influence += 1;
                }
            }

            for (int i = 1; i <= 8; i++){
                if (i != rank){
                    board.getSquare(i, file).toggleHighlight();
                    influence += 1;
                }
            }

        }
        return influence;
    }

    public void maxInfluence(){
        int maxInfluence = 0;
        ArrayList<Square> maxes = new ArrayList<Square>();
        for (int row = 1; row <= 8; row++){
            for (int col = 1; col <= 8; col++){
                board.clearBoard();
                int influence = placeQueen(row, col);
                if (influence >= maxInfluence){
                    maxes.add(board.getSquare(row, col));
                }
            }
        }
        while (maxes.size() > 4){
            maxes.remove(0);
        }

        for (int squares = 0; squares < maxes.size(); squares++){
            maxes.get(squares).toggleHighlight();
        }

    }

    public double dist(int r1, int f1, int r2, int f2){
        int x = Math.abs(f1-f2);
        int y = Math.abs(r1-r2);

        double dist = Math.sqrt((x*x) + (y*y));
        return dist;
    }

    public String toString(){
        String textBoard = "";
        for (int i = 1; i <= 8; i++){
            for (int j = 1; j <= 8; j++){
                textBoard = textBoard + board.getSquare(i, j).getPiece() + " ";
            }
            textBoard = textBoard + "\n";
        }
        return textBoard;
    }
}