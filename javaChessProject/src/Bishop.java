public class Bishop extends Piece {

    public Bishop(int color, Square location) {
        super(color, location);
    }

    @Override
    public String toString() {
        return color == ChessBoard.WHITE ? "B" : "b";
    }

    public boolean canMove(String to) {
        Square targetLocation = location.getBoard().getSquareAt(to);
        int rowDistance = Math.abs(targetLocation.rowDistance(location));
        int colDistance = Math.abs(targetLocation.colDistance(location));

        if (rowDistance == colDistance) {
            for (int i = 1; i < rowDistance; i++) {

                if (!targetLocation.isEmpty()) {
                    return false;
                }
            }
            return targetLocation.isEmpty() || targetLocation.getPiece().getColor() != color;
        } else {
            return false;
        }
    }

}