import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ChessTest {

    @Test 
    public void testPawn()
    {
        Pawn p = new Pawn(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[6][0] = p;
        Move move = new Move(6, 0, 5, 0);
        assertTrue(p.isValidMove(move, cp));

    }


    @Test 
    public void testPawn2()
    {
        Pawn p = new Pawn(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[6][0] = p;
        Move move = new Move(6, 0, 3, 0);
        assertFalse(p.isValidMove(move, cp));

    }

    @Test 
    public void testPawn3()
    {
        Pawn p = new Pawn(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[1][0] = p;
        Move move = new Move(1, 0, -1, 0);
        assertFalse(p.isValidMove(move, cp));

    }

    //
    @Test 
    public void testPawn4()
    {
        Pawn p = new Pawn(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[6][0] = p;
        Move move = new Move(6, 0, 7, 0);
        assertFalse(p.isValidMove(move, cp));

    }


    @Test 
    public void testPawn5()
    {
        Pawn p = new Pawn(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[6][0] = p;
        Move move = new Move(6, 0, 4, 0);
        assertTrue(p.isValidMove(move, cp));

    }


    @Test 
    public void testPawn6()
    {
        Pawn p = new Pawn(Player.WHITE);
        Pawn p1 = new Pawn(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[6][0] = p;
        cp[5][1] = p1;
        Move move = new Move(6, 0, 5, 1);
        assertTrue(p.isValidMove(move, cp));

    }


    @Test 
    public void testPawn7()
    {
        Pawn p = new Pawn(Player.WHITE);
        Pawn p1 = new Pawn(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[6][0] = p;
        cp[5][1] = p1;
        Move move = new Move(6, 0, 5, 1);
        assertTrue(p.isValidMove(move, cp));

    }


    @Test 
    public void testPawn8()
    {
        Pawn p = new Pawn(Player.WHITE);
        Pawn p1 = new Pawn(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[6][0] = p;
        cp[5][0] = p1;
        Move move = new Move(6, 0, 4, 0);
        assertFalse(p.isValidMove(move, cp));

    }
    
    @Test 
    public void testPawn9()
    {
        Pawn p = new Pawn(Player.WHITE);
        Pawn p1 = new Pawn(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[6][0] = p;
        cp[4][0] = p1;
        Move move = new Move(6, 0, 4, 0);
        assertFalse(p.isValidMove(move, cp));

    }
    @Test
    public void testBishop1()
    {
        Bishop b = new Bishop(Player.WHITE);
        Bishop b1 = new Bishop(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[7][2] = b;
        cp[0][2] = b1;
        Move move = new Move(7, 2, 4, 5);
        assertTrue(b.isValidMove(move, cp));
    }
    @Test
    public void testRook()
    {// testing rook moving out of bounds
        Rook r = new Rook(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[0][0] = r;
        Move move = new Move(0, 0, 9, 0);
        assertFalse(r.isValidMove(move, cp));
    }
    @Test
    public void testRook1()
    {// testing rook moving out of bounds
        Rook r = new Rook(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[0][0] = r;
        Move move = new Move(0, 0, 0, 9);
        assertFalse(r.isValidMove(move, cp));
    }
    @Test
    public void testRook2()
    {// testing rook moving out of bounds and illegal move
        Rook r = new Rook(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[0][0] = r;
        Move move = new Move(0, 0, 8, 8);
        assertFalse(r.isValidMove(move, cp));
    }
    @Test
    public void testRook3()
    {// testing rook moving right with no pieces in way
        Rook r = new Rook(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[0][0] = r;
        Move move = new Move(0, 0, 6, 0);
        assertTrue(r.isValidMove(move, cp));
    }
    @Test
    public void testRook4()
    {// testing rook moving left with no pieces in way
        Rook r = new Rook(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[6][0] = r;
        Move move = new Move(6, 0, 0, 0);
        assertTrue(r.isValidMove(move, cp));
    }
    @Test
    public void testRook5()
    { //testing rook moving forward with no pieces in way
        Rook r = new Rook(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[0][0] = r;
        Move move = new Move(0, 0, 0, 6);
        assertTrue(r.isValidMove(move, cp));
    }
    @Test
    public void testRook6()
    { //testing rook moving forward with no pieces in way
        Rook r = new Rook(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[5][5] = r;
        Move move = new Move(5, 5, 5, 1);
        assertTrue(r.isValidMove(move, cp));
    }
    @Test
    public void testRook7()
    { //testing rook moving forward with no pieces in way
        Rook r = new Rook(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[5][5] = r;
        Move move = new Move(5, 5, 0, 5);
        assertTrue(r.isValidMove(move, cp));
    }
    @Test
    public void testRook8()
    { //testing rook moving forward with no pieces in way
        Rook r = new Rook(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[5][5] = r;
        Move move = new Move(5, 5, 1, 5);
        assertTrue(r.isValidMove(move, cp));
    }
    @Test
    public void testRook9()
    {//testing rook taking opposing piece
        Rook r = new Rook(Player.BLACK);
        Rook r1 = new Rook(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[0][0] = r;
        cp[0][6] = r1;
        Move move = new Move(0, 0, 0, 6);
        assertTrue(r.isValidMove(move, cp));
    }
    @Test
    public void testRook10()
    {//testing rook Invalid move blocked by friendly piece
        Rook r = new Rook(Player.BLACK);
        Rook r1 = new Rook(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[0][0] = r;
        cp[0][4] = r1;
        Move move = new Move(0, 0, 0, 6);
        assertFalse(r.isValidMove(move, cp));
    }
    @Test
    public void testRook11()
    {//testing rook Invalid move blocked by opposing piece
        Rook r = new Rook(Player.BLACK);
        Rook r1 = new Rook(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[0][0] = r;
        cp[0][4] = r1;
        Move move = new Move(0, 0, 0, 6);
        assertFalse(r.isValidMove(move, cp));
    }
    @Test
    public void testRook12()
    {//testing rook Invalid move blocked by friendly piece at end position
        Rook r = new Rook(Player.BLACK);
        Rook r1 = new Rook(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[0][0] = r;
        cp[0][6] = r1;
        Move move = new Move(0, 0, 0, 6);
        assertFalse(r.isValidMove(move, cp));
    }
    @Test
    public void testRook13()
    {//testing rook Invalid move blocked by friendly piece and opposing piece
        Rook r = new Rook(Player.BLACK);
        Rook r1 = new Rook(Player.BLACK);
        Rook r2 = new Rook(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[0][0] = r;
        cp[0][4] = r1;
        cp[0][2] = r2;
        Move move = new Move(0, 0, 0, 6);
        assertFalse(r.isValidMove(move, cp));
    }
    @Test
    public void testRook14()
    {//testing rook making Invalid move
        Rook r = new Rook(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[0][0] = r;
        Move move = new Move(0, 0, 3, 6);
        assertFalse(r.isValidMove(move, cp));
    }
    @Test
    public void testRook15()
    {//rook taking opposing piece with friendly piece in the way
        Rook r = new Rook(Player.BLACK);
        Rook r1 = new Rook(Player.BLACK);
        Rook r2 = new Rook(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[0][0] = r;
        cp[0][2] = r1;
        cp[0][5] = r2;
        Move move = new Move(0, 0, 0, 5);
        assertFalse(r.isValidMove(move, cp));
    }
    @Test
    public void testRook16()
    {//rook taking opposing piece with opposing piece in the way
        Rook r = new Rook(Player.BLACK);
        Rook r1 = new Rook(Player.WHITE);
        Rook r2 = new Rook(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[0][0] = r;
        cp[0][2] = r1;
        cp[0][5] = r2;
        Move move = new Move(0, 0, 0, 5);
        assertFalse(r.isValidMove(move, cp));
    }
    @Test
    public void testRook17()
    { //testing rook moving forward with no pieces in way
        Rook r = new Rook(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[5][5] = r;
        Move move = new Move(5, 5, 5, 1);
        assertTrue(r.isValidMove(move, cp));
    }
    @Test
    public void testRook18()
    {//rook taking opposing piece with opposing piece behind opposing piece being taken
        Rook r = new Rook(Player.BLACK);
        Rook r1 = new Rook(Player.WHITE);
        Rook r2 = new Rook(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[0][0] = r;
        cp[0][2] = r1;
        cp[0][3] = r2;
        Move move = new Move(0, 0, 0, 2);
        assertTrue(r.isValidMove(move, cp));
    }
    @Test
    public void testRook19()
    { //testing rook moving forward one place with no pieces in way
        Rook r = new Rook(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[5][5] = r;
        Move move = new Move(5, 5, 5, 6);
        assertTrue(r.isValidMove(move, cp));
    }
    @Test
    public void testRook20()
    { //testing rook moving forward one place with no pieces in way
        Rook r = new Rook(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[5][5] = r;
        Move move = new Move(5, 5, 6, 5);
        assertTrue(r.isValidMove(move, cp));
    }
}
