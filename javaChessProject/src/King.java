public class King extends Piece {
    public King(int color, Square location) {
        super(color, location);
    }

    @Override
    public String toString() {
        return color == ChessBoard.WHITE ? "K" : "k";
    }

    @Override
    public boolean canMove(String to) {
        Square targetLocation = location.getBoard().getSquareAt(to);
        int rowDistance = Math.abs(targetLocation.getRow() - location.getRow());
        int colDistance = Math.abs(targetLocation.getCol() - location.getCol());

        if ((rowDistance == 1 && colDistance == 0) || (rowDistance == 0 && colDistance == 1) || (rowDistance == 1 && colDistance == 1)) {
            return targetLocation.isEmpty() || targetLocation.getPiece().getColor() != color;
        } else {
            return false;
        }
    }
}
