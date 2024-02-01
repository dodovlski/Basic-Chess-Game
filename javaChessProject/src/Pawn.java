public class Pawn extends Piece {
    private boolean initialLocation = true;

    public Pawn(int color, Square location) {
        super(color, location);
    }

    @Override
    public String toString() {
        return color == ChessBoard.WHITE ? "P" : "p";
    }

    @Override
    public boolean canMove(String to) {
        Square targetLocation = location.getBoard().getSquareAt(to);
        int rowDistance = targetLocation.rowDistance(location);

        boolean validMove = false;
        if (this.location.isAtSameColumn(targetLocation)) {
            if (color == ChessBoard.WHITE && rowDistance > 0 && rowDistance <= 2) {

                if (rowDistance == 2 && initialLocation) {
                    Square[] between = location.getBoard().getSquaresBetween(location, targetLocation);
                    validMove = targetLocation.isEmpty() && between[0].isEmpty();
                } else if (rowDistance == 1) {
                    validMove = targetLocation.isEmpty();
                }
            } else if (color == ChessBoard.BLACK && rowDistance < 0 && rowDistance >= -2) {

                if (rowDistance == -2 && initialLocation) {
                    Square[] between = location.getBoard().getSquaresBetween(location, targetLocation);
                    validMove = targetLocation.isEmpty() && between[0].isEmpty();
                } else if (rowDistance == -1) {
                    validMove = targetLocation.isEmpty();
                }
            }
        } else if (this.location.nextCol(targetLocation)) {
            if (color == ChessBoard.WHITE && rowDistance == 1) {
                validMove = !targetLocation.isEmpty() && targetLocation.getPiece().getColor() == ChessBoard.BLACK;
            } else if (color == ChessBoard.BLACK && rowDistance == -1) {
                validMove = !targetLocation.isEmpty() && targetLocation.getPiece().getColor() == ChessBoard.WHITE;
            }
        }

        return validMove;
    }

    @Override
    public void move(String to) {
        Square targetLocation = location.getBoard().getSquareAt(to);
        if (targetLocation.isAtLastRow(color)) {
            targetLocation.putNewQueen(color);
        } else {
            targetLocation.setPiece(this);
        }
        location.deletePrev();
        initialLocation = false;
        location = targetLocation;
        location.getBoard().isNextPlayer();

    }


}
