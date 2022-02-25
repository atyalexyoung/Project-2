import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ChessTest {



    // **************************************************************************************************
    // **************************************************************************************************

    // PAWN

    // **************************************************************************************************
    // **************************************************************************************************



    // ******************************************************************************
    // */

    // TESTING WHITE PAWN
    // VALID

    // *******************************************************************************



    // Tests pawn can move forward 1 from starting position
    @Test
    public void testWhitePawnForward1() {
        Pawn p = new Pawn(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[6][0] = p;
        Move move = new Move(6, 0, 5, 0);
        assertTrue(p.isValidMove(move, cp));

    }

    // tests if pawn can move forward 2 from starting position
    @Test
    public void testWhitePawnForward2() {
        Pawn p = new Pawn(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[6][0] = p;
        Move move = new Move(6, 0, 4, 0);
        assertTrue(p.isValidMove(move, cp));

    }

    // Tests pawn can move forward 1 from non-starting position
    @Test
    public void testWhitePawnForward() {
        Pawn p = new Pawn(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[5][6] = p;
        Move move = new Move(5, 6, 4, 6);
        assertTrue(p.isValidMove(move, cp));

    }

    // Tests if pawn can attack enemy player from diagonal
    @Test
    public void testWhitePawnDiagonal() {
        Pawn p = new Pawn(Player.WHITE);
        Pawn p1 = new Pawn(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[6][0] = p;
        cp[5][1] = p1;
        Move move = new Move(6, 0, 5, 1);
        assertTrue(p.isValidMove(move, cp));

    }

    // Tests if pawn can attack enemy player from other diagonal
    @Test
    public void testWhitePawnDiagonal2() {
        Pawn p = new Pawn(Player.WHITE);
        Pawn p1 = new Pawn(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[6][1] = p;
        cp[5][0] = p1;
        Move move = new Move(6, 1, 5, 0);
        assertTrue(p.isValidMove(move, cp));

    }



    // ************************************************************************

    // TESTING WHITE PAWN
    // INVALID

    // ************************************************************************* */



    // Tests if invalid pawn moves forward 3 from starting position
    @Test
    public void testInvalidWhitePawnForward3() {
        Pawn p = new Pawn(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[6][0] = p;
        Move move = new Move(6, 0, 3, 0);
        assertFalse(p.isValidMove(move, cp));

    }

    // Tests if invalid pawn moves OOB
    @Test
    public void testInvalidWhitePawnOOB() {
        Pawn p = new Pawn(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[1][0] = p;
        Move move = new Move(1, 0, -1, 0);
        assertFalse(p.isValidMove(move, cp));

    }

    // Tests if invalid pawn moves backwards
    @Test
    public void testInvalidWhitePawnBackwards() {
        Pawn p = new Pawn(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[6][0] = p;
        Move move = new Move(6, 0, 7, 0);
        assertFalse(p.isValidMove(move, cp));

    }

    // Tests if pawn will move if in starting position move 2 and enemy piece
    // forward 1 (skip over piece)
    @Test
    public void testInvalidWhitePawnObstacle() {
        Pawn p = new Pawn(Player.WHITE);
        Pawn p1 = new Pawn(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[6][0] = p;
        cp[5][0] = p1;
        Move move = new Move(6, 0, 4, 0);
        assertFalse(p.isValidMove(move, cp));

    }

    // Tests if valid move will be false if pawn moves 1 forward and a piece is
    // there
    @Test
    public void testInvalidWhitePawnObstacle2() {
        Pawn p = new Pawn(Player.WHITE);
        Pawn p1 = new Pawn(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[6][0] = p;
        cp[4][0] = p1;
        Move move = new Move(6, 0, 4, 0);
        assertFalse(p.isValidMove(move, cp));

    }

    @Test
    public void testBishop1() {
        Bishop b = new Bishop(Player.WHITE);
        Bishop b1 = new Bishop(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[7][2] = b;
        cp[0][2] = b1;
        Move move = new Move(7, 2, 4, 5);
        assertTrue(b.isValidMove(move, cp));
    }

 
    // Tests if invalid pawn moves diagonal if no enemy piece there
    @Test
    public void testInvalidWhitePawnDiagonal() {
        Pawn p = new Pawn(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[6][0] = p;
        Move move = new Move(6, 0, 5, 1);
        assertFalse(p.isValidMove(move, cp));

    }

    // Tests if invalid pawn moves diagonal if there is an allied piece there
    @Test
    public void testInvalidWhitePawnDiagonal2() {
        Pawn p = new Pawn(Player.WHITE);
        Pawn p1 = new Pawn(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[6][0] = p;
        cp[5][1] = p1;
        Move move = new Move(6, 0, 5, 1);
        assertFalse(p.isValidMove(move, cp));

    }



    // ******************************************************************************
    // */

    // TESTING BLACK PAWN
    // VALID

    // *******************************************************************************



    // Tests pawn can move forward 1 from starting position
    @Test
    public void testBlackPawnForward1() {
        Pawn p = new Pawn(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[1][0] = p;
        Move move = new Move(1, 0, 2, 0);
        assertTrue(p.isValidMove(move, cp));

    }

    // tests if pawn can move forward 2 from starting position
    @Test
    public void testBlackPawnForward2() {
        Pawn p = new Pawn(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[1][0] = p;
        Move move = new Move(1, 0, 3, 0);
        assertTrue(p.isValidMove(move, cp));

    }

    // Tests pawn can move forward 1 from non-starting position
    @Test
    public void testBlackPawnForward() {
        Pawn p = new Pawn(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[5][6] = p;
        Move move = new Move(5, 6, 6, 6);
        assertTrue(p.isValidMove(move, cp));

    }

    // Tests if pawn can attack enemy player from diagonal
    @Test
    public void testBlackPawnDiagonal() {
        Pawn p = new Pawn(Player.BLACK);
        Pawn p1 = new Pawn(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[1][0] = p;
        cp[2][1] = p1;
        Move move = new Move(1, 0, 2, 1);
        assertTrue(p.isValidMove(move, cp));

    }

    // Tests if pawn can attack enemy player from other diagonal
    @Test
    public void testBlackPawnDiagonal2() {
        Pawn p = new Pawn(Player.BLACK);
        Pawn p1 = new Pawn(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[1][1] = p;
        cp[2][0] = p1;
        Move move = new Move(1, 1, 2, 0);
        assertTrue(p.isValidMove(move, cp));

    }



    // ************************************************************************

    // TESTING BLACK PAWN
    // INVALID

    // ************************************************************************* */



    // Tests if invalid pawn moves forward 3 from starting position
    @Test
    public void testInvalidBlackPawnForward3() {
        Pawn p = new Pawn(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[1][0] = p;
        Move move = new Move(1, 0, 4, 0);
        assertFalse(p.isValidMove(move, cp));

    }

    // Tests if invalid pawn moves OOB
    @Test
    public void testInvalidBlackPawnOOB() {
        Pawn p = new Pawn(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[6][0] = p;
        Move move = new Move(6, 0, 8, 0);
        assertFalse(p.isValidMove(move, cp));

    }

    // Tests if invalid pawn moves backwards
    @Test
    public void testInvalidBlackPawnBackwards() {
        Pawn p = new Pawn(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[1][0] = p;
        Move move = new Move(1, 0, 0, 0);
        assertFalse(p.isValidMove(move, cp));

    }

    // Tests if pawn will move if in starting position move 2 and enemy piece
    // forward 1 (skip over piece)
    @Test
    public void testInvalidBlackPawnObstacle() {
        Pawn p = new Pawn(Player.BLACK);
        Pawn p1 = new Pawn(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[1][0] = p;
        cp[2][0] = p1;
        Move move = new Move(1, 0, 3, 0);
        assertFalse(p.isValidMove(move, cp));

    }

    // Tests if valid move will be false if pawn moves 1 forward and a piece is
    // there
    @Test
    public void testInvalidBlackPawnObstacle2() {
        Pawn p = new Pawn(Player.BLACK);
        Pawn p1 = new Pawn(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[1][0] = p;
        cp[3][0] = p1;
        Move move = new Move(1, 0, 3, 0);
        assertFalse(p.isValidMove(move, cp));

    }

    // Tests if invalid pawn moves diagonal if no enemy piece there
    @Test
    public void testInvalidBlackPawnDiagonal() {
        Pawn p = new Pawn(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[1][0] = p;
        Move move = new Move(1, 0, 2, 1);
        assertFalse(p.isValidMove(move, cp));

    }

    // Tests if invalid pawn moves diagonal if there is an allied piece there
    @Test
    public void testInvalidBlackPawnDiagonal2() {
        Pawn p = new Pawn(Player.WHITE);
        Pawn p1 = new Pawn(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[1][0] = p;
        cp[1][1] = p1;
        Move move = new Move(1, 0, 2, 1);
        assertFalse(p.isValidMove(move, cp));

    }








    // **************************************************************************************************
    // **************************************************************************************************

    // ROOK

    // **************************************************************************************************
    // **************************************************************************************************





    // ******************************************************************************************

    // TEST ROOK
    // VALID

    // ******************************************************************************************



    @Test
    public void testRook3() {// testing rook moving right with no pieces in way
        Rook r = new Rook(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[0][0] = r;
        Move move = new Move(0, 0, 6, 0);
        assertTrue(r.isValidMove(move, cp));
    }

    @Test
    public void testRook4() {// testing rook moving left with no pieces in way
        Rook r = new Rook(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[6][0] = r;
        Move move = new Move(6, 0, 0, 0);
        assertTrue(r.isValidMove(move, cp));
    }

    @Test
    public void testRook5() { // testing rook moving forward with no pieces in way
        Rook r = new Rook(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[0][0] = r;
        Move move = new Move(0, 0, 0, 6);
        assertTrue(r.isValidMove(move, cp));
    }

    @Test
    public void testRook6() { // testing rook moving forward with no pieces in way
        Rook r = new Rook(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[5][5] = r;
        Move move = new Move(5, 5, 5, 1);
        assertTrue(r.isValidMove(move, cp));
    }

    @Test
    public void testRook7() { // testing rook moving forward with no pieces in way
        Rook r = new Rook(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[5][5] = r;
        Move move = new Move(5, 5, 0, 5);
        assertTrue(r.isValidMove(move, cp));
    }

    @Test
    public void testRook8() { // testing rook moving forward with no pieces in way
        Rook r = new Rook(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[5][5] = r;
        Move move = new Move(5, 5, 1, 5);
        assertTrue(r.isValidMove(move, cp));
    }

    @Test
    public void testRook9() {// testing Black rook taking opposing White piece
        Rook r = new Rook(Player.BLACK);
        Rook r1 = new Rook(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[0][0] = r;
        cp[0][6] = r1;
        Move move = new Move(0, 0, 0, 6);
        assertTrue(r.isValidMove(move, cp));
    }

    @Test
    public void testRook17() { // testing rook moving forward with no pieces in way
        Rook r = new Rook(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[5][5] = r;
        Move move = new Move(5, 5, 5, 1);
        assertTrue(r.isValidMove(move, cp));
    }

    @Test
    public void testRook18() {// rook taking opposing piece with opposing piece behind opposing piece being
                              // taken
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
    public void testRook19() { // testing rook moving forward one place with no pieces in way
        Rook r = new Rook(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[5][5] = r;
        Move move = new Move(5, 5, 5, 6);
        assertTrue(r.isValidMove(move, cp));
    }

    @Test
    public void testRook20() { // testing rook moving forward one place with no pieces in way
        Rook r = new Rook(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[5][5] = r;
        Move move = new Move(5, 5, 6, 5);
        assertTrue(r.isValidMove(move, cp));
    }

    @Test
    public void testRook21() {// testing White rook taking opposing Black piece
        Rook r = new Rook(Player.WHITE);
        Rook r1 = new Rook(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[0][0] = r;
        cp[0][6] = r1;
        Move move = new Move(0, 0, 0, 6);
        assertTrue(r.isValidMove(move, cp));
    }







    // ******************************************************************************************

    // TEST ROOK
    // INVALID

    // ******************************************************************************************



    @Test
    public void testRook() {// testing rook moving out of bounds
        Rook r = new Rook(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[0][0] = r;
        Move move = new Move(0, 0, 9, 0);
        assertFalse(r.isValidMove(move, cp));
    }

    @Test
    public void testRook1() {// testing rook moving out of bounds
        Rook r = new Rook(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[0][0] = r;
        Move move = new Move(0, 0, 0, 9);
        assertFalse(r.isValidMove(move, cp));
    }

    @Test
    public void testRook2() {// testing rook moving out of bounds and illegal move
        Rook r = new Rook(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[0][0] = r;
        Move move = new Move(0, 0, 8, 8);
        assertFalse(r.isValidMove(move, cp));
    }


    @Test
    public void testRook10() {// testing rook Invalid move blocked by friendly piece
        Rook r = new Rook(Player.BLACK);
        Rook r1 = new Rook(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[0][0] = r;
        cp[0][4] = r1;
        Move move = new Move(0, 0, 0, 6);
        assertFalse(r.isValidMove(move, cp));
    }

    @Test
    public void testRook11() {// testing rook Invalid move blocked by opposing piece
        Rook r = new Rook(Player.BLACK);
        Rook r1 = new Rook(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[0][0] = r;
        cp[0][4] = r1;
        Move move = new Move(0, 0, 0, 6);
        assertFalse(r.isValidMove(move, cp));
    }

    @Test
    public void testRook12() {// testing rook Invalid move blocked by friendly piece at end position
        Rook r = new Rook(Player.BLACK);
        Rook r1 = new Rook(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[0][0] = r;
        cp[0][6] = r1;
        Move move = new Move(0, 0, 0, 6);
        assertFalse(r.isValidMove(move, cp));
    }

    @Test
    public void testRook13() {// testing rook Invalid move blocked by friendly piece and opposing piece
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
    public void testRook14() {// testing rook making Invalid move
        Rook r = new Rook(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[0][0] = r;
        Move move = new Move(0, 0, 3, 6);
        assertFalse(r.isValidMove(move, cp));
    }

    @Test
    public void testRook15() {// rook taking opposing piece with friendly piece in the way
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
    public void testRook16() {// rook taking opposing piece with opposing piece in the way
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




    // **************************************************************************************************
    // **************************************************************************************************

    // KING

    // **************************************************************************************************
    // **************************************************************************************************




    // ******************************************************************************************

    // TEST KING
    // VALID

    // ******************************************************************************************




    // ******************************************************************************************

    // TEST KING
    // INVALID

    // ******************************************************************************************










    // **************************************************************************************************
    // **************************************************************************************************

    // BISHOP

    // **************************************************************************************************
    // **************************************************************************************************



    // ******************************************************************************************

    // TEST BISHOP
    // VALID

    // ******************************************************************************************



    // ******************************************************************************************

    // TEST BISHOP
    // INVALID

    // ******************************************************************************************





    // **************************************************************************************************
    // **************************************************************************************************

    // KNIGHT

    // **************************************************************************************************
    // **************************************************************************************************



    // ******************************************************************************************

    // TEST KNIGHT
    // VALID

    // ******************************************************************************************


    @Test
    public void testKnight() {// testing knight basic moves
        Knight k = new Knight(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[3][3] = k;
        Move move = new Move(3, 3, 2, 1);
        assertTrue(k.isValidMove(move, cp));
    }

    @Test
    public void testKnight1() {// testing knight basic moves
        Knight k = new Knight(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[3][3] = k;
        Move move = new Move(3, 3, 1, 2);
        assertTrue(k.isValidMove(move, cp));
    }

    @Test
    public void testKnight2() {// testing knight basic moves
        Knight k = new Knight(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[3][3] = k;
        Move move = new Move(3, 3, 1, 4);
        assertTrue(k.isValidMove(move, cp));
    }

    @Test
    public void testKnight3() {// testing knight basic moves
        Knight k = new Knight(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[3][3] = k;
        Move move = new Move(3, 3, 2, 5);
        assertTrue(k.isValidMove(move, cp));
    }

    @Test
    public void testKnight4() {// testing knight basic moves
        Knight k = new Knight(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[3][3] = k;
        Move move = new Move(3, 3, 4, 5);
        assertTrue(k.isValidMove(move, cp));
    }

    @Test
    public void testKnight5() {// testing knight basic moves
        Knight k = new Knight(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[3][3] = k;
        Move move = new Move(3, 3, 5, 4);
        assertTrue(k.isValidMove(move, cp));
    }

    @Test
    public void testKnight6() {// testing knight basic moves
        Knight k = new Knight(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[3][3] = k;
        Move move = new Move(3, 3, 5, 2);
        assertTrue(k.isValidMove(move, cp));
    }

    @Test
    public void testKnight7() {// testing knight basic moves
        Knight k = new Knight(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[3][3] = k;
        Move move = new Move(3, 3, 4, 1);
        assertTrue(k.isValidMove(move, cp));
    }

    @Test
    public void testKnight11() {// testing knight taking opposing piece
        Knight k = new Knight(Player.WHITE);
        Knight k1 = new Knight(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[3][3] = k;
        cp[4][1] = k1;
        Move move = new Move(3, 3, 4, 1);
        assertTrue(k.isValidMove(move, cp));
    }

    @Test
    public void testKnight13() {// testing knight moving over pieces
        Knight k = new Knight(Player.WHITE);
        Knight k1 = new Knight(Player.WHITE);
        Knight k2 = new Knight(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[3][3] = k;
        cp[3][1] = k1;
        cp[4][2] = k2;
        Move move = new Move(3, 3, 4, 1);
        assertTrue(k.isValidMove(move, cp));
    }






    // ******************************************************************************************

    // TEST KNIGHT
    // INVALID

    // ******************************************************************************************




    @Test
    public void testKnight8() {// testing knight Invalid move
        Knight k = new Knight(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[3][3] = k;
        Move move = new Move(3, 3, 0, 2);
        assertFalse(k.isValidMove(move, cp));
    }

    @Test
    public void testKnight9() {// testing knight Invalid move
        Knight k = new Knight(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[3][3] = k;
        Move move = new Move(3, 3, 7, 4);
        assertFalse(k.isValidMove(move, cp));
    }

    @Test
    public void testKnight10() {// testing knight Invalid move
        Knight k = new Knight(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[3][3] = k;
        Move move = new Move(3, 3, 3, 1);
        assertFalse(k.isValidMove(move, cp));
    }

    @Test
    public void testKnight14() {// testing knight Invalid move Out of Bounds
        Knight k = new Knight(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[3][3] = k;
        Move move = new Move(3, 3, 8, 1);
        assertFalse(k.isValidMove(move, cp));
    }

    @Test
    public void testKnight15() {// testing knight Invalid move Out of Bounds
        Knight k = new Knight(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[3][3] = k;
        Move move = new Move(3, 3, 1, 8);
        assertFalse(k.isValidMove(move, cp));
    }

    @Test
    public void testKnight16() {// testing knight valid knight move Out of Bounds
        Knight k = new Knight(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[7][1] = k;
        Move move = new Move(7, 1, 3, 8);
        assertFalse(k.isValidMove(move, cp));
    }

    @Test
    public void testKnight12() {// testing knight moving to spot with friendly piece
        Knight k = new Knight(Player.WHITE);
        Knight k1 = new Knight(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[3][3] = k;
        cp[4][1] = k1;
        Move move = new Move(3, 3, 4, 1);
        assertFalse(k.isValidMove(move, cp));
    }





    // **************************************************************************************************
    // **************************************************************************************************

    // QUEEN

    // **************************************************************************************************
    // **************************************************************************************************



    // ******************************************************************************************

    // TEST QUEEN
    // VALID

    // ******************************************************************************************



    // ******************************************************************************************

    // TEST QUEEN
    // INVALID

    // ******************************************************************************************

}
