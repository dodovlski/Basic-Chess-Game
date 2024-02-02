import java.util.Scanner;

public class Main {
    // Date Updated
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        ChessBoard board = new ChessBoard();
        board.printBoard();

        while (!board.isGameEnded()) {
            System.out.println("It is " + (board.isWhitePlaying() ? "White" : "Black") + "'s turn");
            Piece piece;

            do {
                System.out.print("Enter the location of the piece:");
                String from = reader.next();
                piece = board.getPieceAt(from);
            } while (piece == null
                    || piece.getColor() != (board.isWhitePlaying() ? ChessBoard.WHITE : ChessBoard.BLACK));

            String to;
            do {
                System.out.print("Enter the new location of the piece:");
                to = reader.next();
                if (!piece.canMove(to)) {
                    System.out.println("Invalid move!!! Enter a valid move:");
                }
            } while (!piece.canMove(to));

            piece.move(to);
            board.printBoard();
        }
        System.out.println(board.isWhitePlaying() ? "Black" : "White" + " wins!");

        reader.close();
    }
}