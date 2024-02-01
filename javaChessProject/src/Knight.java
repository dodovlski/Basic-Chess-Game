public class Knight extends Piece {
    public Knight(int color, Square location) {
        super(color, location);
    }

    @Override
    public String toString() {
        return color == ChessBoard.WHITE ? "N" : "n";
    }

    @Override
    public boolean canMove(String to) {
        Square targetLocation = location.getBoard().getSquareAt(to);
        int rowDistance = Math.abs(targetLocation.rowDistance(location));
        int colDistance = Math.abs(targetLocation.colDistance(location));

        if ((rowDistance == 2 && colDistance == 1) || (rowDistance == 1 && colDistance == 2)) {
            return targetLocation.isEmpty() || targetLocation.getPiece().getColor() != color;
        } else {
            return false;
        }

    }

}