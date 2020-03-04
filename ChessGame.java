public class ChessGame{

    private Board board;

    public ChessGame() {
        this.board = new Board();
    }

    public void placeRook(int rank, int file){
        if (board.getSquare(rank, file) != null){
            board.getSquare(rank, file).setPiece("r");

            for (int i = 1; i <= 8; i++){
                board.getSquare(rank, i).toggleHighlight();
            }

            for (int i = 1; i <= 8; i++){
                board.getSquare(i, file).toggleHighlight();
            }

        }
    }


    public void placeKnight(int rank, int file){
        if (board.getSquare(rank, file) != null){


            board.getSquare(rank, file).setPiece("k");

            for (int i = 1; i <= 8; i++){
                for (int j = 1; j <= 8; j++){
                    if (dist(rank, file, i, j) == Math.sqrt(5)){
                        board.getSquare(i, j).toggleHighlight();
                    }
                }
            }

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