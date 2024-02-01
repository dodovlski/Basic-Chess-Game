public abstract class Piece {
    protected int color;
    protected Square location;

    public Piece(int color, Square location) {
        this.color = color;
        this.location = location;
    }

    public abstract String toString();

    public abstract boolean canMove(String to);

    public void move(String to){
        Square targetLocation = location.getBoard().getSquareAt(to);
        targetLocation.setPiece(this);
        location.deletePrev();
        location = targetLocation;
        location.getBoard().isNextPlayer();
    }

    public int getColor() {
        return color;
    }
}