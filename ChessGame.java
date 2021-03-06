import java.util.*;

public class ChessGame{

    private Board board;
    private int numRanks;
    private int numFiles;

    public ChessGame() {
        this.board = new Board(10,25);
        numRanks = board.getRankCount();
        numFiles = board.getFileCount();
    }

    public int placeRook(int rank, int file){
        int influence = 0;
        
        if (board.getSquare(rank, file) != null){
            board.getSquare(rank, file).setPiece("r");

            for (int i = 1; i <= numFiles; i++){
                if (i != file){
                    board.getSquare(rank, i).toggleHighlight();
                    influence += 1;
                }
            }

            for (int i = 1; i <= numRanks; i++){
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

            for (int i = 1; i <= numRanks; i++){
                for (int j = 1; j <= numFiles; j++){
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

            for (int i = 1; i <= numRanks; i++){
                for (int j = 1; j <= numFiles; j++){
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

            for (int i = 1; i <= numRanks; i++){
                for (int j = 1; j <= numFiles; j++){
                    int rankDist = Math.abs(rank - i);
                    int fileDist = Math.abs(file - j);

                    if (rankDist == fileDist && i != rank){
                        board.getSquare(i, j).toggleHighlight();
                        influence += 1;
                    }
                }
            }

            for (int i = 1; i <= numFiles; i++){
                if (i != file){
                    board.getSquare(rank, i).toggleHighlight();
                    influence += 1;
                }
            }

            for (int i = 1; i <= numRanks; i++){
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
        
        for (int row = 1; row <= numRanks; row++){
            for (int col = 1; col <= numFiles; col++){
                board.clearBoard();
                int influence = placeQueen(row, col);
                if (influence >= maxInfluence){
                    maxes.add(board.getSquare(row, col));
                    maxInfluence = influence;
                }
            }
        }
        board.clearBoard();

        while (maxes.size() > 4){
            maxes.remove(0);
        }

        for (int squares = 0; squares < maxes.size(); squares++){
            Square currentSquare = maxes.get(squares);
            currentSquare.toggleHighlight();
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
        for (int i = 1; i <= numRanks; i++){
            for (int j = 1; j <= numFiles; j++){
                textBoard = textBoard + board.getSquare(i, j).getPiece() + " ";
            }
            textBoard = textBoard + "\n";
        }
        return textBoard;
    }
}