public class Square {
    private final int row;
    private final int col;
    private final ChessBoard board;
    private Piece piece;


    public Square(int row, int col, ChessBoard board) {
        this.row = row;
        this.col = col;
        this.board = board;
    }

    @Override
    public String toString() {
        if (piece == null) {
            return " ";
        } else {
            return piece.toString();
        }
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public void deletePrev() {
        this.piece = null;
    }

    public boolean isEmpty() {
        return piece == null;
    }


    public boolean isAtSameColumn(Square s) {
        return this.col == s.getCol();
    }

    public boolean nextCol(Square s) {
        return Math.abs(col - s.getCol()) == 1;

    }

    public int rowDistance(Square s) {
        return s.getRow() - row;
    }

    public int colDistance(Square s) {
        return Math.abs(col - s.getCol());
    }

    public ChessBoard getBoard() {
        return board;
    }

    //////////////////////////////////////////////////////////////////
    public void putNewQueen(int color) {
        setPiece(new Queen(color, this));
    }

    public boolean isAtLastRow(int color) {
        if (color == ChessBoard.WHITE) {
            return row == 0;
        } else {
            return row == 7;
        }
    }
    //////////////////////////////////////////////////////////////////


}
