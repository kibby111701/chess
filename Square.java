import java.awt.Color;

public class Square{

    private int rank, file;
    private Color color = Color.BLACK;
    private boolean isHighlighted = false;
    private String piece = null;

    public Square(int rank, int file, Color color){
        this.rank = rank;
        this.file = file;
        this.color = color;
        if (color.equals(Color.BLACK)){
            this.piece = "@";
        }else{
            this.piece = "#";
        }
    }

    public void toggleHighlight(){
        this.isHighlighted = !this.isHighlighted;
        if (isHighlighted && !piece.equals("r") && !piece.equals("b") && !piece.equals("q")){
            this.piece = "*";
        }
    }

    public boolean isHighlighted(){
        return this.isHighlighted;
    }

    public int getRank() {return this.rank;}
    public int getFile() {return this.file;}
    public Color getColor() {return this.color;}

    public String getPiece() {return this.piece;}
    public void setPiece(String piece){
        //piece is one of ["p","r","b","k","q", or "k"]
        this.piece = piece;
    }


}