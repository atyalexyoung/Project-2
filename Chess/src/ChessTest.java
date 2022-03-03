import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
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

    // Tests pawn can move forward 1 from starting position
    @Test
    public void testWhitePawnForward4() {
        Pawn p = new Pawn(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[4][6] = p;
        Move move = new Move(4, 6, 5, 6);
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
        // Tests if pawn can attack enemy player from other diagonal
        @Test
        public void testWhitePawnDiagonal3() {
            ChessModel model = new ChessModel();
            Pawn p = new Pawn(Player.WHITE);
            Pawn p1 = new Pawn(Player.BLACK);
            model.board[4][4] = p;
            model.board[3][3] = p1;
            Move move = new Move(4, 4, 3, 3);
            assertTrue(model.isValidMove(move));
            assertTrue(model.isValidMove(move));
            model.move(move);
            
            
            assertEquals(p,model.pieceAt(3, 3) );
            
    
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


    //                       BISHOP


    // **************************************************************************************************
    // *************************************************************************************************





    // ******************************************************************************************

    //      TEST BISHOP
    //      VALID

    // ******************************************************************************************



    // Tests Bishop Move + 2 rows and + 2 columns
    @Test
    public void testBishopIncRowCol()
    { //basic forward move 2 spots
        Bishop b = new Bishop(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[2][0] = b;
        Move move = new Move(2, 0, 4, 2);
        assertTrue(b.isValidMove(move, cp));
    }


    // Tests Bishop move -2 rows and -2 columns
    @Test
    public void testBishopDecRowCol()
    { //basic backward move one spot
        Bishop b = new Bishop(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[4][2] = b;
        Move move = new Move(4, 2, 2, 0);
        assertTrue(b.isValidMove(move, cp));
    }


    // Tests Bishop move -3 rows and -3 columns
    @Test
    public void testBishopDecRowCol2()
    { //basic backward move 2 spots
        Bishop b = new Bishop(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[5][3] = b;
        Move move = new Move(5, 3, 2, 0);
        assertTrue(b.isValidMove(move, cp));
    }


    // Tests Bishop move -2 rows and -2 columns and take enemy piece
    @Test
    public void testBishopDecTake()
    { //taking opposing piece
        Bishop b = new Bishop(Player.BLACK);
        Bishop b1 = new Bishop(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[4][2] = b;
        cp[2][0] = b1;
        Move move = new Move(4, 2, 2, 0);
        assertTrue(b.isValidMove(move, cp));
    }


    // Tests Bishop move +1 rows and +1 columns
    @Test
    public void testBishopIncRowCol2()
    { //moving single space
        Bishop b = new Bishop(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[2][0] = b;
        Move move = new Move(2, 0, 3, 1);
        assertTrue(b.isValidMove(move, cp));
    }

    
    // Tests Bishop move -1 rows and -1 columns
    @Test
    public void testBishopDecRowCol3()
    { //moving single space 
        Bishop b = new Bishop(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[3][1] = b;
        Move move = new Move(3, 1, 2, 0);
        assertTrue(b.isValidMove(move, cp));
    }


    // Tests Bishop move +5 rows and +5 columns
    @Test
    public void testBishopIncRowCol3()
    { //moves across board
        Bishop b = new Bishop(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[2][0] = b;
        Move move = new Move(2, 0, 7, 5);
        assertTrue(b.isValidMove(move, cp));
    }


    // Tests Bishop allied piece block 
    @Test
    public void testBishopTake()
    { //taking opposing piece with friendly piece one place away
        Bishop b = new Bishop(Player.BLACK);
        Bishop b1 = new Bishop(Player.WHITE);
        Bishop b2 = new Bishop(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[4][2] = b;
        cp[4][1] = b2;
        cp[2][0] = b1;
        Move move = new Move(4, 2, 2, 0);
        assertTrue(b.isValidMove(move, cp));
    }


    // Tests Bishop move -2 rows and +2 columns
    @Test
    public void testBishopDecRowIncCol()
    { //basic move 2 spots
        Bishop b = new Bishop(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[4][2] = b;
        Move move = new Move(4, 2, 2, 4);
        assertTrue(b.isValidMove(move, cp));
    }


    // Tests Bishop move +2 rows and -2 columns
    @Test
    public void testBishopIncRowDecCol()
    { //basic move 2 spots up right
        Bishop b = new Bishop(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[4][2] = b;
        Move move = new Move(4, 2, 6, 0);
        assertTrue(b.isValidMove(move, cp));
    }

    
    // Tests Bishop taking opposing piece with allied piece one place past
    @Test
    public void testBishopTake2()
    { //taking opposing piece with friendly piece one place past piece being taken
        Bishop b = new Bishop(Player.BLACK);
        Bishop b1 = new Bishop(Player.WHITE);
        Bishop b2 = new Bishop(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[2][0] = b;
        cp[4][2] = b1;
        cp[5][3] = b2;
        Move move = new Move(2, 0, 4, 2);
        assertTrue(b.isValidMove(move, cp));
    }


    // Tests Bishop moving to spot with allied piece one place past
    @Test
    public void testBishop()
    { //moving to spot with friednly piece one place past
        Bishop b = new Bishop(Player.BLACK);
        Bishop b2 = new Bishop(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[2][0] = b;
        cp[5][3] = b2;
        Move move = new Move(2, 0, 4, 2);
        assertTrue(b.isValidMove(move, cp));
    }


    // Tests Bishop moving to spot with allied piece one place past
    @Test
    public void testBishop2()
    { //moving to spot with friednly piece one place past
        Bishop b = new Bishop(Player.BLACK);
        Bishop b2 = new Bishop(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[3][1] = b;
        cp[5][3] = b2;
        Move move = new Move(5, 3, 4, 2);
        assertTrue(b2.isValidMove(move, cp));
    }


    // Tests Bishop moving to spot with friednly piece one place past

    @Test
    public void testBishop3()
    { //moving to spot with friednly piece one place past
        Bishop b = new Bishop(Player.WHITE);
        Bishop b2 = new Bishop(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[3][1] = b;
        cp[6][0] = b2;
        Move move = new Move(6, 0, 4, 2);
        assertTrue(b2.isValidMove(move, cp));
    }



    // ******************************************************************************************

    //      TEST BISHOP
    //      INVALID

    // ******************************************************************************************


    // tests bishop invalid ally in way +rows +columns
    @Test
    public void testBishopInvalidBlock()
    { //move with friendly piece in way
        Bishop b = new Bishop(Player.BLACK);
        Bishop b1 = new Bishop(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[2][0] = b;
        cp[4][2] = b1;
        Move move = new Move(2, 0, 5, 3);
        assertFalse(b.isValidMove(move, cp));
    }


    // tests bishop invalid enemy in way +rows +columns
    @Test
    public void testBishopInvalidBlock2()
    { //move with enemy piece in way
        Bishop b = new Bishop(Player.BLACK);
        Bishop b1 = new Bishop(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[2][0] = b;
        cp[4][2] = b1;
        Move move = new Move(2, 0, 5, 3);
        assertFalse(b.isValidMove(move, cp));
    }


    // tests bishop invalid horizontal move
    @Test
    public void testBishopInvalidHorizontal()
    { //Illegal move
        Bishop b = new Bishop(Player.BLACK);
        Bishop b1 = new Bishop(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[2][0] = b;
        cp[4][2] = b1;
        Move move = new Move(2, 0, 2, 1);
        assertFalse(b.isValidMove(move, cp));
    }


    // tests bishop invalid move random +rows +columns
    @Test
    public void testBishopInvalid()
    { //Illegal move
        Bishop b = new Bishop(Player.BLACK);
        Bishop b1 = new Bishop(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[2][0] = b;
        cp[4][2] = b1;
        Move move = new Move(2, 0, 6, 1);
        assertFalse(b.isValidMove(move, cp));
    }


    // tests bishop invalid allied piece in the way 
    @Test
    public void testBishopInvalidBlock3()
    { //taking opposing piece with opposing piece in the way
        Bishop b = new Bishop(Player.BLACK);
        Bishop b1 = new Bishop(Player.WHITE);
        Bishop b2 = new Bishop(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[4][2] = b;
        cp[3][1] = b2;
        cp[2][0] = b1;
        Move move = new Move(4, 2, 2, 0);
        assertFalse(b.isValidMove(move, cp));
    }


    // tests bishop move OOB
    @Test
    public void testBishopInvalidOOB()
    { //moves across board to OOB position
        Bishop b = new Bishop(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[2][0] = b;
        Move move = new Move(2, 0, 8, 6);
        assertFalse(b.isValidMove(move, cp));
    }


    // Tests bishop invalid vertical move
    @Test
    public void testBishopInvalidVertical()
    { //Illegal move
        Bishop b = new Bishop(Player.BLACK);
        Bishop b1 = new Bishop(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[2][0] = b;
        cp[4][2] = b1;
        Move move = new Move(2, 0, 4, 0);
        assertFalse(b.isValidMove(move, cp));
    }


    // Tests bishop moving to spot with friendly piece one place away
    @Test
    public void testBishopInvalidBlock4()
    {
        Bishop b = new Bishop(Player.WHITE);
        Bishop b2 = new Bishop(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[3][1] = b;
        cp[4][2] = b2;
        Move move = new Move(3, 1, 6, 4);
        assertFalse(b2.isValidMove(move, cp));
    }


    


    // **************************************************************************************************
    // **************************************************************************************************


    //                       Rook


    // **************************************************************************************************
    // **************************************************************************************************


    // ******************************************************************************************

    //      TEST Rook
    //      VALID

    // ******************************************************************************************


    // Tests if rook will move backwards
    @Test
    public void testRookBackwards() {
        Rook r = new Rook(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[6][0] = r;
        Move move = new Move(6, 0, 0, 0);
        assertTrue(r.isValidMove(move, cp));
    }


    // Tests if rook will move right
    @Test
    public void testRookRight() {
        Rook r = new Rook(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[0][0] = r;
        Move move = new Move(0, 0, 0, 6);
        assertTrue(r.isValidMove(move, cp));
    }


    // Tests if rook will move left
    @Test
    public void testRookLeft() {
        Rook r = new Rook(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[5][5] = r;
        Move move = new Move(5, 5, 5, 1);
        assertTrue(r.isValidMove(move, cp));
    }


    // Tests if rook will move forward with no pieces in way
    @Test
    public void testRookForward2() {
        Rook r = new Rook(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[5][5] = r;
        Move move = new Move(5, 5, 0, 5);
        assertTrue(r.isValidMove(move, cp));
    }


    // Tests if rook will move forward with no pieces in the way
    @Test
    public void testRookForward3() {
        Rook r = new Rook(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[5][5] = r;
        Move move = new Move(5, 5, 1, 5);
        assertTrue(r.isValidMove(move, cp));
    }


    // testing Black rook taking opposing White piece
    @Test
    public void testRookTakePiece() {
        Rook r = new Rook(Player.BLACK);
        Rook r1 = new Rook(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[0][0] = r;
        cp[0][6] = r1;
        Move move = new Move(0, 0, 0, 6);
        assertTrue(r.isValidMove(move, cp));
    }


    // testing rook moving forward with no pieces in way
    @Test
    public void testRook17() {
        Rook r = new Rook(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[5][5] = r;
        Move move = new Move(5, 5, 5, 1);
        assertTrue(r.isValidMove(move, cp));
    }


    // rook taking opposing piece with opposing piece behind opposing piece being taken
    @Test
    public void testRookTaken() {
                              
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


    // testing rook moving forward one place with no pieces in way
    @Test
    public void testRookForward4() {
        Rook r = new Rook(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[5][5] = r;
        Move move = new Move(5, 5, 5, 6);
        assertTrue(r.isValidMove(move, cp));
    }


    // testing rook moving forward one place with no pieces in way
    @Test
    public void testRookForward5() {
        Rook r = new Rook(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[5][5] = r;
        Move move = new Move(5, 5, 6, 5);
        assertTrue(r.isValidMove(move, cp));
    }


    // testing White rook taking opposing Black piece
    @Test
    public void testRookTakePiece2() {
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


    // testing rook moving out of bounds
    @Test
    public void testRookInvalidOOB() {// testing rook moving out of bounds
        Rook r = new Rook(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[0][0] = r;
        Move move = new Move(0, 0, 9, 0);
        assertFalse(r.isValidMove(move, cp));
    }


    // testing rook moving out of bounds
    @Test
    public void testRookInvalidOOB2() {// testing rook moving out of bounds
        Rook r = new Rook(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[0][0] = r;
        Move move = new Move(0, 0, 0, 9);
        assertFalse(r.isValidMove(move, cp));
    }


    // testing rook moving out of bounds and illegal move
    @Test
    public void testRookInvalidOOB3() {// testing rook moving out of bounds and illegal move
        Rook r = new Rook(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[0][0] = r;
        Move move = new Move(0, 0, 8, 8);
        assertFalse(r.isValidMove(move, cp));
    }


    // testing rook Invalid move blocked by friendly piece
    @Test
    public void testRookInvalidBlock() {// testing rook Invalid move blocked by friendly piece
        Rook r = new Rook(Player.BLACK);
        Rook r1 = new Rook(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[0][0] = r;
        cp[0][4] = r1;
        Move move = new Move(0, 0, 0, 6);
        assertFalse(r.isValidMove(move, cp));
    }


    // testing rook Invalid move blocked by opposing piece
    @Test
    public void testRookInvalidBlock2() {// testing rook Invalid move blocked by opposing piece
        Rook r = new Rook(Player.BLACK);
        Rook r1 = new Rook(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[0][0] = r;
        cp[0][4] = r1;
        Move move = new Move(0, 0, 0, 6);
        assertFalse(r.isValidMove(move, cp));
    }


    // testing rook Invalid move blocked by friendly piece at end position
    @Test
    public void testRookInvalidBlock3() {// testing rook Invalid move blocked by friendly piece at end position
        Rook r = new Rook(Player.BLACK);
        Rook r1 = new Rook(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[0][0] = r;
        cp[0][6] = r1;
        Move move = new Move(0, 0, 0, 6);
        assertFalse(r.isValidMove(move, cp));
    }


    // testing rook Invalid move blocked by friendly piece and opposing piece
    @Test
    public void testRookInvalidBlock4() {// testing rook Invalid move blocked by friendly piece and opposing piece
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


    // testing rook making Invalid move
    @Test
    public void testRookInvalid() {// testing rook making Invalid move
        Rook r = new Rook(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[0][0] = r;
        Move move = new Move(0, 0, 3, 6);
        assertFalse(r.isValidMove(move, cp));
    }


    // rook taking opposing piece with friendly piece in the way
    @Test
    public void testRookInvalidBlock5() {// rook taking opposing piece with friendly piece in the way
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


    // rook taking opposing piece with opposing piece in the way
    @Test
    public void testRookInvalidBlock6() {// rook taking opposing piece with opposing piece in the way
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


    // Tests King can move rows -1
    @Test
    public void testKingForward() {
        King p = new King(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[6][0] = p;
        Move move = new Move(6, 0, 5, 0);
        assertTrue(p.isValidMove(move, cp));

    }


    // Tests King can move columns +1
    @Test
    public void testKingRight() {
        King p = new King(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[6][0] = p;
        Move move = new Move(6, 0, 6, 1);
        assertTrue(p.isValidMove(move, cp));

    }


    // Tests King can move rows +1
    @Test
    public void testKingLeft() {
        King p = new King(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[6][0] = p;
        Move move = new Move(6, 0, 7, 0);
        assertTrue(p.isValidMove(move, cp));

    }


    // Tests King can move columns -1
    public void testKingBack() {
        King p = new King(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[6][4] = p;
        Move move = new Move(6, 4, 6, 3);
        assertTrue(p.isValidMove(move, cp));

    }


    // Tests King can move rows+1 columns+1
    public void testKingDiagIncRowsCols() {
        King p = new King(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[6][4] = p;
        Move move = new Move(6, 4, 7, 5);
        assertTrue(p.isValidMove(move, cp));

    }


    // Tests King can move rows+1 columns-1
    public void testKingDiagIncRowsDecCols() {
        King p = new King(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[6][4] = p;
        Move move = new Move(6, 4, 7, 3);
        assertTrue(p.isValidMove(move, cp));

    }


    // Tests King can move rows-1 columns+1
    public void testKingDiagDecRowsIncCols() {
        King p = new King(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[6][4] = p;
        Move move = new Move(6, 4, 5, 5);
        assertTrue(p.isValidMove(move, cp));

    }


    // Tests King can move rows-1 columns-1
    public void testKingDiagDecRowsCols() {
        King p = new King(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[6][4] = p;
        Move move = new Move(6, 4, 5, 3);
        assertTrue(p.isValidMove(move, cp));

    }


    // Tests pawn can move forward 1 from starting position
    @Test
    public void testKingForwardTakePiece() {
        King p = new King(Player.WHITE);
        Pawn p1 = new Pawn(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[6][0] = p;
        cp[5][0] = p1;
        Move move = new Move(6, 0, 5, 0);
        assertTrue(p.isValidMove(move, cp));

    }



    // ******************************************************************************************

    // TEST KING
    // INVALID

    // ******************************************************************************************




    // Tests King invalid moving multiple spaces in row
    @Test
    public void testKingMultiRow() {
        King p = new King(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[6][0] = p;
        Move move = new Move(6, 0, 4, 0);
        assertFalse(p.isValidMove(move, cp));

    }


    // Tests King invalid moving multiple spaces diagonally
    @Test
    public void testKingMultiDiag() {
        Pawn p = new Pawn(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[6][6] = p;
        Move move = new Move(6, 6, 4, 4);
        assertFalse(p.isValidMove(move, cp));

    }


    // Tests King invalid moving multiple spaces in column
    @Test
    public void testKingMultiCol() {
        King p = new King(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[6][6] = p;
        Move move = new Move(6, 6, 6, 3);
        assertFalse(p.isValidMove(move, cp));

    }







    // **************************************************************************************************
    // **************************************************************************************************

    // KNIGHT

    // **************************************************************************************************
    // **************************************************************************************************



    // ******************************************************************************************

    // TEST KNIGHT
    // VALID

    // ******************************************************************************************


    // testing knight -1 row -2 column
    @Test
    public void testKnight() {// testing knight basic moves
        Knight k = new Knight(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[3][3] = k;
        Move move = new Move(3, 3, 2, 1);
        assertTrue(k.isValidMove(move, cp));
    }


    // testing knight -2 row -1 column
    @Test
    public void testKnight1() {// testing knight basic moves
        Knight k = new Knight(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[3][3] = k;
        Move move = new Move(3, 3, 1, 2);
        assertTrue(k.isValidMove(move, cp));
    }


    // testing knight -2 row +1 column
    @Test
    public void testKnight2() {// testing knight basic moves
        Knight k = new Knight(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[3][3] = k;
        Move move = new Move(3, 3, 1, 4);
        assertTrue(k.isValidMove(move, cp));
    }


    // testing knight -1 row +2 column
    @Test
    public void testKnight3() {// testing knight basic moves
        Knight k = new Knight(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[3][3] = k;
        Move move = new Move(3, 3, 2, 5);
        assertTrue(k.isValidMove(move, cp));
    }


    // testing knight +1 row +2 column
    @Test
    public void testKnight4() {// testing knight basic moves
        Knight k = new Knight(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[3][3] = k;
        Move move = new Move(3, 3, 4, 5);
        assertTrue(k.isValidMove(move, cp));
    }


    // testing knight +2 row +1 column
    @Test
    public void testKnight5() {// testing knight basic moves
        Knight k = new Knight(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[3][3] = k;
        Move move = new Move(3, 3, 5, 4);
        assertTrue(k.isValidMove(move, cp));
    }


    // testing knight +2 row -1 column
    @Test
    public void testKnight6() {// testing knight basic moves
        Knight k = new Knight(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[3][3] = k;
        Move move = new Move(3, 3, 5, 2);
        assertTrue(k.isValidMove(move, cp));
    }


    // testing knight +1 row -2 column
    @Test
    public void testKnight7() {// testing knight basic moves
        Knight k = new Knight(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[3][3] = k;
        Move move = new Move(3, 3, 4, 1);
        assertTrue(k.isValidMove(move, cp));
    }


    // testing knight +1 row -2 column
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


    // testing knight moving over pieces
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



    // testing knight Invalid move
    @Test
    public void testKnightInvalid() {// testing knight Invalid move
        Knight k = new Knight(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[3][3] = k;
        Move move = new Move(3, 3, 0, 2);
        assertFalse(k.isValidMove(move, cp));
    }


    // testing knight Invalid move
    @Test
    public void testKnightInvalid2() {// testing knight Invalid move
        Knight k = new Knight(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[3][3] = k;
        Move move = new Move(3, 3, 7, 4);
        assertFalse(k.isValidMove(move, cp));
    }


    // testing knight Invalid move
    @Test
    public void testKnightInvalid3() {// testing knight Invalid move
        Knight k = new Knight(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[3][3] = k;
        Move move = new Move(3, 3, 3, 1);
        assertFalse(k.isValidMove(move, cp));
    }


    // testing knight Invalid move Out of Bounds
    @Test
    public void testKnightInvalidOOB() {// testing knight Invalid move Out of Bounds
        Knight k = new Knight(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[3][3] = k;
        Move move = new Move(3, 3, 8, 1);
        assertFalse(k.isValidMove(move, cp));
    }


    // testing knight Invalid move Out of Bounds
    @Test
    public void testKnightInvalidOOB2() {// testing knight Invalid move Out of Bounds
        Knight k = new Knight(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[3][3] = k;
        Move move = new Move(3, 3, 1, 8);
        assertFalse(k.isValidMove(move, cp));
    }


    // testing knight invalid move Out of Bounds
    @Test
    public void testKnightInvalidOOB3() {// testing knight valid knight move Out of Bounds
        Knight k = new Knight(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[7][1] = k;
        Move move = new Move(7, 1, 3, 8);
        assertFalse(k.isValidMove(move, cp));
    }


    // testing knight moving to spot with friendly piece
    @Test
    public void testKnightInvalidBlock() {// testing knight moving to spot with friendly piece
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




    // Tests Queen Move + 2 rows and + 2 columns
    @Test
    public void testQueenDiagIncRowsCols()
    { //basic forward move 2 spots
        Queen b = new Queen(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[2][0] = b;
        Move move = new Move(2, 0, 4, 2);
        assertTrue(b.isValidMove(move, cp));
    }

    
    // Tests Queen move - 2 rows and -2 columns
    @Test
    public void testQueenDiagDecRowsCols()
    { //basic backward move one spot
        Queen b = new Queen(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[4][2] = b;
        Move move = new Move(4, 2, 2, 0);
        assertTrue(b.isValidMove(move, cp));
    }


    // Tests Queen move -3 rows and -3 columns
    @Test
    public void testQueenDiagDecRowsCols2()
    { //basic backward move 2 spots
        Queen b = new Queen(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[5][3] = b;
        Move move = new Move(5, 3, 2, 0);
        assertTrue(b.isValidMove(move, cp));
    }


    // Tests queen move -2 rows and -2 columns and take enemy piece
    @Test
    public void testQueenDiagDecRowsColsTakePiece()
    { //taking opposing piece
        Queen b = new Queen(Player.BLACK);
        Queen b1 = new Queen(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[4][2] = b;
        cp[2][0] = b1;
        Move move = new Move(4, 2, 2, 0);
        assertTrue(b.isValidMove(move, cp));
    }


    // Tests Queen move +1 rows and +1 columns
    @Test
    public void testQueenDiagIncRowsCols2()
    { //moving single space
        Queen b = new Queen(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[2][0] = b;
        Move move = new Move(2, 0, 3, 1);
        assertTrue(b.isValidMove(move, cp));
    }


    // Tests Queen move -1 rows and -1 columns
    @Test
    public void testQueenDiagDecRowsCols3()
    { //moving single space 
        Queen b = new Queen(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[3][1] = b;
        Move move = new Move(3, 1, 2, 0);
        assertTrue(b.isValidMove(move, cp));
    }


    // Tests Queen move +5 rows and +5 columns
    @Test
    public void testQueenDiagIncRowsCols3()
    { //moves across board
        Queen b = new Queen(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[2][0] = b;
        Move move = new Move(2, 0, 7, 5);
        assertTrue(b.isValidMove(move, cp));
    }


    // Test Queen take piece with allied 1 position away
    @Test
    public void testQueenDiagTakePiece()
    { //taking opposing piece with friendly piece one place away
        Queen b = new Queen(Player.BLACK);
        Queen b1 = new Queen(Player.WHITE);
        Queen b2 = new Queen(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[4][2] = b;
        cp[4][1] = b2;
        cp[2][0] = b1;
        Move move = new Move(4, 2, 2, 0);
        assertTrue(b.isValidMove(move, cp));
    }


    // Tests Queen move -2 rows and +2 columns
    @Test
    public void testQueenDiagDecRowsIncCols()
    { //basic move 2 spots
        Queen b = new Queen(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[4][2] = b;
        Move move = new Move(4, 2, 2, 4);
        assertTrue(b.isValidMove(move, cp));
    }


    // Tests Queen move +2 rows and -2 columns
    @Test
    public void testQueenDiagIncRowsDecCols()
    { //basic move 2 spots up right
        Queen b = new Queen(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[4][2] = b;
        Move move = new Move(4, 2, 6, 0);
        assertTrue(b.isValidMove(move, cp));
    }


    // Tests Queen take Piece with allied piece 1 position away
    @Test
    public void testQueenDiag()
    { //taking opposing piece with friendly piece one place past piece being taken
        Queen b = new Queen(Player.BLACK);
        Queen b1 = new Queen(Player.WHITE);
        Queen b2 = new Queen(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[2][0] = b;
        cp[4][2] = b1;
        cp[5][3] = b2;
        Move move = new Move(2, 0, 4, 2);
        assertTrue(b.isValidMove(move, cp));
    }


    // Tests Queen Move with allied piece 1 position away
    @Test
    public void testQueenDiag2()
    { //moving to spot with friednly piece one place past
        Queen b = new Queen(Player.BLACK);
        Queen b2 = new Queen(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[2][0] = b;
        cp[5][3] = b2;
        Move move = new Move(2, 0, 4, 2);
        assertTrue(b.isValidMove(move, cp));
    }


    // Tests Queen move with allied piece 1 position away
    @Test
    public void testQueenDiag3()
    { //moving to spot with friednly piece one place past
        Queen b = new Queen(Player.BLACK);
        Queen b2 = new Queen(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[3][1] = b;
        cp[5][3] = b2;
        Move move = new Move(5, 3, 4, 2);
        assertTrue(b2.isValidMove(move, cp));
    }


    // Tests Queen move with allied piece 1 postion away
    @Test
    public void testQueenDiag4()
    { //moving to spot with friednly piece one place past
        Queen b = new Queen(Player.BLACK);
        Queen b2 = new Queen(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[3][1] = b;
        cp[6][0] = b2;
        Move move = new Move(6, 0, 4, 2);
        assertTrue(b2.isValidMove(move, cp));
    }


    // Tests if queen will move backwards
    @Test
    public void testQueenBackwards() {
        Queen b = new Queen(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[6][0] = b;
        Move move = new Move(6, 0, 0, 0);
        assertTrue(b.isValidMove(move, cp));
    }


    // Tests if queen will move right
    @Test
    public void testQueenRight() {
        Queen r = new Queen(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[0][0] = r;
        Move move = new Move(0, 0, 0, 6);
        assertTrue(r.isValidMove(move, cp));
    }


    // Tests if queen will move left
    @Test
    public void testQueenLeft() {
        Queen r = new Queen(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[5][5] = r;
        Move move = new Move(5, 5, 5, 1);
        assertTrue(r.isValidMove(move, cp));
    }


    // Tests if queen will move forward with no pieces in way
    @Test
    public void testQueenForward2() {
        Queen r = new Queen(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[5][5] = r;
        Move move = new Move(5, 5, 0, 5);
        assertTrue(r.isValidMove(move, cp));
    }


    // Tests if queen will move forward with no pieces in the way
    @Test
    public void testQueenForward3() {
        Queen r = new Queen(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[5][5] = r;
        Move move = new Move(5, 5, 1, 5);
        assertTrue(r.isValidMove(move, cp));
    }


    // testing Black queen taking opposing White piece
    @Test
    public void testQueenTakePiece() {
        Queen r = new Queen(Player.BLACK);
        Queen r1 = new Queen(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[0][0] = r;
        cp[0][6] = r1;
        Move move = new Move(0, 0, 0, 6);
        assertTrue(r.isValidMove(move, cp));
    }


    // testing queen moving forward with no pieces in way
    @Test
    public void testQueen() {
        Queen r = new Queen(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[5][5] = r;
        Move move = new Move(5, 5, 5, 1);
        assertTrue(r.isValidMove(move, cp));
    }


    // tests queen taking opposing piece with opposing piece behind opposing piece being taken
    @Test
    public void testQueenTaken() {
                              
        Queen r = new Queen(Player.BLACK);
        Queen r1 = new Queen(Player.WHITE);
        Queen r2 = new Queen(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[0][0] = r;
        cp[0][2] = r1;
        cp[0][3] = r2;
        Move move = new Move(0, 0, 0, 2);
        assertTrue(r.isValidMove(move, cp));
    }


    // testing queen moving forward one place with no pieces in way
    @Test
    public void testQueenForward() {
        Queen r = new Queen(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[5][5] = r;
        Move move = new Move(5, 5, 5, 6);
        assertTrue(r.isValidMove(move, cp));
    }


    // testing queen moving forward one place with no pieces in way
    @Test
    public void testQueenForward4() {
        Queen r = new Queen(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[5][5] = r;
        Move move = new Move(5, 5, 6, 5);
        assertTrue(r.isValidMove(move, cp));
    }


    // testing White queen taking opposing Black piece
    @Test
    public void testQueenTakePiece2() {
        Queen r = new Queen(Player.BLACK);
        Queen r1 = new Queen(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[0][0] = r;
        cp[0][6] = r1;
        Move move = new Move(0, 0, 0, 6);
        assertTrue(r.isValidMove(move, cp));
    }



    // ******************************************************************************************

    // TEST QUEEN
    // INVALID

    // ******************************************************************************************





     // test queen invalid ally in way +rows +columns
     @Test
     public void testQueenInvalidObstacle()
     { //move with friendly piece in way
        Queen b = new Queen(Player.BLACK);
        Queen b1 = new Queen(Player.WHITE);
         ChessPiece[][] cp = new ChessPiece[8][8];
         cp[2][0] = b;
         cp[4][2] = b1;
         Move move = new Move(2, 0, 5, 3);
         assertFalse(b.isValidMove(move, cp));
     }
 

     // test queen invalid enemy in way +rows +columns
     @Test
     public void testQueenInvalidObstacle2()
     { //move with enemy piece in way
        Queen b = new Queen(Player.BLACK);
        Queen b1 = new Queen(Player.WHITE);
         ChessPiece[][] cp = new ChessPiece[8][8];
         cp[2][0] = b;
         cp[4][2] = b1;
         Move move = new Move(2, 0, 5, 3);
         assertFalse(b.isValidMove(move, cp));
     }
 
 
     // test queen invalid move random +rows +columns
     @Test
     public void testQueenInvalidMove()
     { //Illegal move
        Queen b = new Queen(Player.BLACK);
        Queen b1 = new Queen(Player.WHITE);
         ChessPiece[][] cp = new ChessPiece[8][8];
         cp[2][0] = b;
         cp[4][2] = b1;
         Move move = new Move(2, 0, 6, 1);
         assertFalse(b.isValidMove(move, cp));
     }
 

     // test queen invalid allied piece in the way 
     @Test
     public void testQueenInvalidObstacle3()
     { //taking opposing piece with opposing piece in the way
        Queen b = new Queen(Player.BLACK);
        Queen b1 = new Queen(Player.WHITE);
        Queen b2 = new Queen(Player.WHITE);
         ChessPiece[][] cp = new ChessPiece[8][8];
         cp[4][2] = b;
         cp[3][1] = b2;
         cp[2][0] = b1;
         Move move = new Move(4, 2, 2, 0);
         assertFalse(b.isValidMove(move, cp));
     }


     // test queen OOB
     @Test
     public void testQueenOOB()
     { //moves across board to OOB position
        Queen b = new Queen(Player.WHITE);
         ChessPiece[][] cp = new ChessPiece[8][8];
         cp[2][0] = b;
         Move move = new Move(2, 0, 8, 6);
         assertFalse(b.isValidMove(move, cp));
     }
 

     // Tests queen invalid move
    @Test
    public void testQueenInvalid()
    { //moving to spot with friednly piece one place away
        Queen b = new Queen(Player.BLACK);
        Queen b2 = new Queen(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[3][1] = b;
        cp[4][2] = b2;
        Move move = new Move(3, 1, 6, 4);
        assertFalse(b2.isValidMove(move, cp));
    }
 

    // testing queen moving out of bounds
    @Test
    public void testQueeninvalidOOB() {// testing queen moving out of bounds
        Rook r = new Rook(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[0][0] = r;
        Move move = new Move(0, 0, 9, 0);
        assertFalse(r.isValidMove(move, cp));
    }


    // testing queen moving out of bounds
    @Test
    public void testQueenInvalidOOB2() {// testing queen moving out of bounds
        Rook r = new Rook(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[0][0] = r;
        Move move = new Move(0, 0, 0, 9);
        assertFalse(r.isValidMove(move, cp));
    }


    // testing queen moving out of bounds and illegal move
    @Test
    public void testQueenInvalidOOB3() {// testing queen moving out of bounds and illegal move
        Rook r = new Rook(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[0][0] = r;
        Move move = new Move(0, 0, 8, 8);
        assertFalse(r.isValidMove(move, cp));
    }


    // testing queen Invalid move blocked by friendly piece
    @Test
    public void testQueenInvalidBlock() {// testing queen Invalid move blocked by friendly piece
        Rook r = new Rook(Player.BLACK);
        Rook r1 = new Rook(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[0][0] = r;
        cp[0][4] = r1;
        Move move = new Move(0, 0, 0, 6);
        assertFalse(r.isValidMove(move, cp));
    }


    // testing queen Invalid move blocked by opposing piece
    @Test
    public void testQueenInvalidBlock2() {// testing queen Invalid move blocked by opposing piece
        Rook r = new Rook(Player.BLACK);
        Rook r1 = new Rook(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[0][0] = r;
        cp[0][4] = r1;
        Move move = new Move(0, 0, 0, 6);
        assertFalse(r.isValidMove(move, cp));
    }


    // testing queen Invalid move blocked by friendly piece at end position
    @Test
    public void testQueenInvalidBlock3() {// testing queen Invalid move blocked by friendly piece at end position
        Rook r = new Rook(Player.BLACK);
        Rook r1 = new Rook(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[0][0] = r;
        cp[0][6] = r1;
        Move move = new Move(0, 0, 0, 6);
        assertFalse(r.isValidMove(move, cp));
    }


    // testing queen Invalid move blocked by friendly piece and opposing piece
    @Test
    public void testQueenInvalidBlock4() {// testing queen Invalid move blocked by friendly piece and opposing piece
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


    // testing queen making Invalid move
    @Test
    public void testQueenInvalid2() {// testing queen making Invalid move
        Rook r = new Rook(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[0][0] = r;
        Move move = new Move(0, 0, 3, 6);
        assertFalse(r.isValidMove(move, cp));
    }


    // queen taking opposing piece with friendly piece in the way
    @Test
    public void testQueenInvalidBlock5() {// queen taking opposing piece with friendly piece in the way
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


    // queen taking opposing piece with opposing piece in the way
    @Test
    public void testQueenInvalidBlock6() {// queen taking opposing piece with opposing piece in the way
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








    // ***************************************************************************************************************************
    //*****************************************************************************************************************************



    //      CHESSMODEL TESTS


    
    // ***************************************************************************************************************************
    //****************************************************************************************************************************





    // ***************************************************************************************************************************


    //       IN CHECK TESTS
    //       VALID


    //****************************************************************************************************************************
    

    // Tests if White king is in check
    @Test
    public void testinCheckfromPawnWK()
    { //moving to spot with friednly piece one place away
        King b = new King(Player.WHITE);
        Pawn b2 = new Pawn(Player.BLACK);
        ChessModel model = new ChessModel();
        Player p = Player.WHITE;
        model.setPiece(5, 5, b);
        model.setPiece(4, 4, b2);
        assertTrue(model.inCheck(p));
    }


    // Tests if black King is in check
    @Test
    public void testinCheckfromPawnBK()
    { //moving to spot with friednly piece one place away
        King b = new King(Player.BLACK);
        Pawn b2 = new Pawn(Player.WHITE);
        ChessModel model = new ChessModel();
        Player p = Player.BLACK;
        model.setPiece(4, 4, b);
        model.setPiece(5, 5, b2);
        assertTrue(model.inCheck(p));
    }

/*
    @Test
    public void testinCheckfromRookWK()
    { //moving to spot with friednly piece one place away
        King b = new King(Player.WHITE);
        Queen b2 = new Queen(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[3][1] = b;
        cp[4][2] = b2;
        Move move = new Move(3, 1, 6, 4);
        assertFalse(b2.isValidMove(move, cp));
    }



    @Test
    public void testinCheckfromRookBK()
    { //moving to spot with friednly piece one place away
        King b = new King(Player.WHITE);
        Queen b2 = new Queen(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[3][1] = b;
        cp[4][2] = b2;
        Move move = new Move(3, 1, 6, 4);
        assertFalse(b2.isValidMove(move, cp));
    }



    @Test
    public void testinCheckfromBishopWK()
    { //moving to spot with friednly piece one place away
        King b = new King(Player.WHITE);
        Queen b2 = new Queen(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[3][1] = b;
        cp[4][2] = b2;
        Move move = new Move(3, 1, 6, 4);
        assertFalse(b2.isValidMove(move, cp));
    }



    @Test
    public void testinCheckfromBishopBK()
    { //moving to spot with friednly piece one place away
        King b = new King(Player.WHITE);
        Queen b2 = new Queen(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[3][1] = b;
        cp[4][2] = b2;
        Move move = new Move(3, 1, 6, 4);
        assertFalse(b2.isValidMove(move, cp));
    }



    @Test
    public void testinCheckfromKnightWK()
    { //moving to spot with friednly piece one place away
        King b = new King(Player.WHITE);
        Queen b2 = new Queen(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[3][1] = b;
        cp[4][2] = b2;
        Move move = new Move(3, 1, 6, 4);
        assertFalse(b2.isValidMove(move, cp));
    }



    @Test
    public void testinCheckfromKnightBK()
    { //moving to spot with friednly piece one place away
        King b = new King(Player.WHITE);
        Queen b2 = new Queen(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[3][1] = b;
        cp[4][2] = b2;
        Move move = new Move(3, 1, 6, 4);
        assertFalse(b2.isValidMove(move, cp));
    }


*/




    // ***************************************************************************************************************************


    //       isComplete TESTS
    //       VALID


    //****************************************************************************************************************************


    // Tests if White king is in check
    @Test
    public void testIsComplete()
    { //moving to spot with friednly piece one place away
        King k = new King(Player.WHITE);
        Bishop br = new Bishop(Player.BLACK);
        Pawn wp = new Pawn(Player.WHITE);
        Pawn wp2 = new Pawn(Player.WHITE);
        Pawn wp3 = new Pawn(Player.WHITE);
        Bishop wp4 = new Bishop(Player.WHITE);
        ChessModel model = new ChessModel();
        Player p = Player.WHITE;
        model.setPiece(4, 0, k);
        model.setPiece(5, 0, wp);
        model.setPiece(3, 0, wp2);
        model.setPiece(5, 1, wp3);
        model.setPiece(4, 1, wp4);
        model.setPiece(2, 2, br);


        
        assertTrue(model.isComplete());
    }


        // Tests if White king is in check
        @Test
        public void testIsComplete2()
        { //moving to spot with friednly piece one place away
            Pawn k = new Pawn(Player.WHITE);
            Rook br = new Rook(Player.WHITE);
            Queen bq = new Queen(Player.WHITE);
            Rook br2 = new Rook(Player.WHITE);
            
            
            ChessModel model = new ChessModel();
            model.setNextPlayer();
            model.setPiece(0, 4, k);
            model.setPiece(4,0,bq);
            model.setPiece(3, 0, br);
            model.setPiece(5, 0, br2);
    
            assertTrue(model.isComplete());
        }
/*
        // Tests if White king is in check
        @Test
        public void testIsComplete3()
        { //moving to spot with friednly piece one place away
            ChessModel model = new ChessModel();
            for(int x = 0; x<8;x++){
                for(int y = 0; y<8; y++){
                    if(model.pieceAt(x,y) != null){
                       model.board[x][y] = null;
                    }
                }
            }
            King kb = new King(Player.BLACK);
            King k = new King(Player.WHITE);
            Queen q = new Queen(Player.BLACK);
            Rook r = new Rook(Player.BLACK);
            
            model.setPiece(7, 7, k);
            model.setPiece(1,6, q);
            model.setPiece(6,1,r);
            model.setPiece(1, 1, kb);
    
            assertTrue(model.isComplete());
        }

*/
    // ***************************************************************************************************************************


    //       isComplete TESTS
    //       INVALID


    //****************************************************************************************************************************


    // Tests if White king is in check
    @Test
    public void testInvalidIsComplete()
    { //moving to spot with friednly piece one place away
        King k = new King(Player.WHITE);
        Bishop br = new Bishop(Player.BLACK);
        Pawn wp = new Pawn(Player.WHITE);
        Pawn wp2 = new Pawn(Player.WHITE);
        Pawn wp3 = new Pawn(Player.WHITE);
        Pawn wp4 = new Pawn(Player.WHITE);
        ChessModel model = new ChessModel();
        Player p = Player.WHITE;
        model.setPiece(4, 0, k);
        model.setPiece(5, 0, wp);
        model.setPiece(3, 0, wp2);
        model.setPiece(5, 1, wp3);
        model.setPiece(4, 1, wp4);
        model.setPiece(2, 2, br);


        
        assertFalse(model.isComplete());
    }




    // check if is complete is false but pieces are in the wrong location


        // Tests pawn can move forward 1 from starting position
        @Test
        public void testWhitePawnForward1000() {
            ChessModel model = new ChessModel();
            Pawn p = new Pawn(Player.BLACK);
            Move move = new Move(6, 0, 5, 0);
            model.move(move);
            assertEquals(model.pieceAt(5,0).type(), p.type());
            assertEquals(model.currentPlayer(),Player.BLACK);
    
        }


            // check if is complete is false but pieces are in the wrong location


        // Tests pawn can move forward 1 from starting position
        @Test
        public void testWhitePawnForward10001() {
            ChessModel model = new ChessModel();
            Pawn p = new Pawn(Player.WHITE);
            Move move = new Move(6, 4, 4, 4);
            model.move(move);
            assertEquals(model.pieceAt(4,4).type(), p.type());
            assertEquals(model.currentPlayer(), Player.BLACK);
    
        }










    // ***************************************************************************************************************************


    //       Move() TESTS
    //       VALID


    //****************************************************************************************************************************




            // Tests pawn move to end and become a
            @Test
            public void testMove()
            { //moving to spot with friednly piece one place away
                
                ChessModel model = new ChessModel();

                for(int x = 0; x<8;x++){
                    for(int y = 0; y<8; y++){
                        if(model.pieceAt(x,y) != null){
                           model.board[x][y] = null;
                        }
                    }
                }
                Pawn pawn = new Pawn(Player.WHITE);
                Pawn bp = new Pawn(Player.BLACK);
                Queen queen = new Queen(Player.WHITE);
                model.setPiece(1, 1, pawn);
                model.setPiece(0, 0, bp);


                Move move = new Move(1,1,0,0);
                model.move(move);
                assertEquals(model.pieceAt(0, 0).type(), queen.type());
                assertEquals(model.pieceAt(0, 0).player(), queen.player());
                assertEquals(model.currentPlayer(), Player.BLACK);

            } 


                        // Tests pawn move to end and become a
            @Test
            public void testMove2()
            { //moving to spot with friednly piece one place away
                
                ChessModel model = new ChessModel();

                for(int x = 0; x<8;x++){
                    for(int y = 0; y<8; y++){
                        if(model.pieceAt(x,y) != null){
                           model.board[x][y] = null;
                        }
                    }
                }
                Pawn pawn = new Pawn(Player.BLACK);
                Queen queen = new Queen(Player.BLACK);
                model.setPiece(6, 0, pawn);
                model.setNextPlayer();

                Move move = new Move(6,0,7,0);
                model.move(move);
                assertEquals(model.pieceAt(7, 0).type(), queen.type());
                assertEquals(model.pieceAt(7, 0).player(), queen.player());

            } 



            // Tests pawn move to end and become a
            @Test
            public void testMove3()
            { //moving to spot with friednly piece one place away
                
                ChessModel model = new ChessModel();
                Pawn p = new Pawn(Player.WHITE);
                Move move = new Move(6,0,5,0);
                model.move(move);
                assertEquals(model.pieceAt(5, 0).type(), p.type());;
            } 


            // Tests rook move is updated
            @Test
            public void testMove4()
            { //moving to spot with friednly piece one place away
                
                ChessModel model = new ChessModel();

                for(int x = 0; x<8;x++){
                    for(int y = 0; y<8; y++){
                        if(model.pieceAt(x,y) != null){
                           model.board[x][y] = null;
                        }
                    }
                }
                Rook rook = new Rook(Player.BLACK);
                model.setPiece(6, 0, rook);
                model.setNextPlayer();

                Move move = new Move(6,0,3,0);
                model.move(move);
                assertEquals(model.pieceAt(3, 0).type(), rook.type());
                assertEquals(model.pieceAt(3, 0).player(), rook.player());
                assertEquals(rook, model.pieceAt(3,0));

            } 
            @Test
            public void testMove5()
            { //moving to spot with friednly piece one place away
                
                ChessModel model = new ChessModel();


                //white move
                Move move = new Move(6,5,4,5);
                model.move(move);
                assertEquals(model.currentPlayer(),Player.BLACK);


                // black
                Move m1 = new Move(1,6,3,6);
                model.move(m1);
                assertEquals(model.currentPlayer(),Player.WHITE);


                // white move
                Move move2 = new Move(3,6,4,6);
                model.move(move2);
                assertEquals(model.currentPlayer(),Player.BLACK);

                // black move
                Move m3 = new Move(0,1,2,0);
                model.move(m3);
                assertEquals(model.currentPlayer(),Player.WHITE);


                //white move
                Move move4 = new Move(4,6,5,6);
                model.move(move4);
                assertEquals(model.currentPlayer(),Player.BLACK);
  

            } 













/*

        // Tests pawn does not become queen after move
            @Test
            public void testMove5()
            { //moving to spot with friednly piece one place away
                
                ChessModel model = new ChessModel();

                for(int x = 0; x<8;x++){
                    for(int y = 0; y<8; y++){
                        if(model.pieceAt(x,y) != null){
                           model.board[x][y] = null;
                        }
                    }
                }
                Pawn pawn = new Pawn(Player.WHITE);
                Queen queen = new Queen(Player.WHITE);
                model.setPiece(2, 0, pawn);


                Move move = new Move(2,0,1,0);
                model.move(move);
                assertEquals(model.pieceAt(1, 0).type(), pawn.type());
                assertEquals(model.pieceAt(1, 0).player(), pawn.player());

            




            */




        
    




}
