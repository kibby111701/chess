public class gameTest{

    public static void main(String[] args) {
        ChessGame bruh = new ChessGame();
        System.out.println(bruh);
        bruh.placeQueen(3, 7);
        System.out.println(bruh);
        bruh.maxInfluence();
        System.out.println(bruh);
    }
}