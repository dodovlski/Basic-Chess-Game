public class Rook extends Piece {

    public Rook(int color, Square location) {
        super(color, location);
    }

    @Override
    public String toString() {
        return color == ChessBoard.WHITE ? "R" : "r";
    }

    @Override
    public boolean canMove(String to) {
        Square targetLocation = location.getBoard().getSquareAt(to);
        int rowDistance = targetLocation.rowDistance(location);
        int colDistance = targetLocation.colDistance(location);

        if (rowDistance == 0 || colDistance == 0) {
            return targetLocation.isEmpty() || targetLocation.getPiece().getColor() != color;
        } else {
            return false;
        }
    }
}