public class Queen extends Piece {

    public Queen(int color, Square location) {
        super(color, location);
    }

    @Override
    public String toString() {
        return color == ChessBoard.WHITE ? "Q" : "q";
    }

    @Override
    public boolean canMove(String to) {
        Square targetLocation = location.getBoard().getSquareAt(to);
        int rowDistance = targetLocation.rowDistance(location);
        int colDistance = targetLocation.colDistance(location);

        if (rowDistance == 0 || colDistance == 0 || Math.abs(rowDistance) == Math.abs(colDistance)) {
            return targetLocation.isEmpty() || targetLocation.getPiece().getColor() != color;
        } else {
            return false;
        }
    }

}