public class ChessBoard {
    public static int WHITE = 0;
    public static int BLACK = 1;
    private final Square[][] board;
    private boolean whitePlaying;


    public ChessBoard() {
        board = new Square[8][8];
        whitePlaying = true;
        initialize();
    }


    public boolean isWhitePlaying() {
        return whitePlaying;
    }

    public void isNextPlayer() {
        whitePlaying = !whitePlaying;
    }

    public boolean isGameEnded() {
        int white_pieces = 0;
        int black_pieces = 0;
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = board[row][col].getPiece();
                if (piece != null) {
                    if (piece.getColor() == WHITE) {
                        white_pieces++;
                    } else {
                        black_pieces++;
                    }
                }
            }
        }
        return white_pieces == 0 || black_pieces == 0;
    }

    public Piece getPieceAt(String location) {
        return getSquareAt(location).getPiece();
    }

    public Square getSquareAt(String location) {
        int col = location.charAt(0) - 'a';
        int row = 8 - (location.charAt(1) - '0');
        return board[row][col];
    }

    public Square[] getSquaresBetween(Square location, Square targetLocation) {
        int row_diff = targetLocation.getRow() - location.getRow();
        int col_diff = targetLocation.getCol() - location.getCol();
        int rowDir = row_diff > 0 ? 1 : -1;
        int colDir = col_diff > 0 ? 1 : -1;

        int difference = Math.max(Math.abs(row_diff), Math.abs(col_diff)) - 1;
        Square[] between = new Square[difference];

        for (int i = 0; i < difference; i++) {
            int row = location.getRow() + rowDir * (i + 1);
            int col = location.getCol() + colDir * (i);

            if (row >= 0 && row < 8 && col >= 0 && col < 8) {

                between[i] = board[row][col];
            }
        }
        return between;
    }


    public void printBoard() {
        System.out.println();
        System.out.println("             ✞ঔৣ\u06DD \uD835\uDE72̷\uD835\uDE77̷\uD835\uDE74̷\uD835\uDE82̷\uD835\uDE82̷ \uD835\uDE76̷\uD835\uDE70̷\uD835\uDE7C̷\uD835\uDE74̷ \u06DDঔৣ✞\n");
        System.out.println("      A     B     C     D     E     F     G     H");
        System.out.println("   -------------------------------------------------");
        for (int row = 0; row < 8; ++row) {
            System.out.print(8 - row + " ");
            for (int col = 0; col < 8; ++col) {
                System.out.print(" |  " + board[row][col].toString() + " ");
            }
            System.out.print(" | " + (8 - row));
            System.out.println();
            System.out.println("   -------------------------------------------------");
        }
        System.out.println("      A     B     C     D     E     F     G     H");
    }

    private void initialize() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                board[row][col] = new Square(row, col, this);
            }
        }
        board[7][0].setPiece(new Rook(WHITE, board[7][0]));
        board[7][1].setPiece(new Knight(WHITE, board[7][1]));
        board[7][2].setPiece(new Bishop(WHITE, board[7][2]));
        board[7][3].setPiece(new Queen(WHITE, board[7][3]));
        board[7][4].setPiece(new King(WHITE, board[7][4]));
        board[7][5].setPiece(new Bishop(WHITE, board[7][5]));
        board[7][6].setPiece(new Knight(WHITE, board[7][6]));
        board[7][7].setPiece(new Rook(WHITE, board[7][7]));
        for (int col = 0; col < 8; col++) {
            board[6][col].setPiece(new Pawn(WHITE, board[6][col]));
        }
        board[0][0].setPiece(new Rook(BLACK, board[0][0]));
        board[0][1].setPiece(new Knight(BLACK, board[0][1]));
        board[0][2].setPiece(new Bishop(BLACK, board[0][2]));
        board[0][3].setPiece(new Queen(BLACK, board[0][3]));
        board[0][4].setPiece(new King(BLACK, board[0][4]));
        board[0][5].setPiece(new Bishop(BLACK, board[0][5]));
        board[0][6].setPiece(new Knight(BLACK, board[0][6]));
        board[0][7].setPiece(new Rook(BLACK, board[0][7]));
        for (int col = 0; col < 8; col++) {
            board[1][col].setPiece(new Pawn(BLACK, board[1][col]));
        }
    }
}
