import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ChessTest {









// **************************************************************************************************
// **************************************************************************************************


//                       PAWN


// **************************************************************************************************
// **************************************************************************************************


//****************************************************************************** */

//       TESTING WHITE PAWN
//       VALID

// *******************************************************************************




    // Tests pawn can move forward 1 from starting position
    @Test 
    public void testWhitePawnForward1()
    {
        Pawn p = new Pawn(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[6][0] = p;
        Move move = new Move(6, 0, 5, 0);
        assertTrue(p.isValidMove(move, cp));

    }


    // tests if pawn can move forward 2 from starting position
    @Test 
    public void testWhitePawnForward2()
    {
        Pawn p = new Pawn(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[6][0] = p;
        Move move = new Move(6, 0, 4, 0);
        assertTrue(p.isValidMove(move, cp));

    }

    
    // Tests pawn can move forward 1 from non-starting position
    @Test 
    public void testWhitePawnForward()
        {
        Pawn p = new Pawn(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[5][6] = p;
        Move move = new Move(5, 6, 4, 6);
        assertTrue(p.isValidMove(move, cp));

        }
    

    // Tests if pawn can attack enemy player from diagonal
    @Test 
    public void testWhitePawnDiagonal()
    {
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
    public void testWhitePawnDiagonal2()
    {
        Pawn p = new Pawn(Player.WHITE);
        Pawn p1 = new Pawn(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[6][1] = p;
        cp[5][0] = p1;
        Move move = new Move(6, 1, 5, 0);
        assertTrue(p.isValidMove(move, cp));

    }

    



    // ************************************************************************

    //       TESTING WHITE PAWN
    //       INVALID
    
    //************************************************************************* */




    // Tests if invalid pawn moves forward 3 from starting position
    @Test 
    public void testInvalidWhitePawnForward3()
    {
        Pawn p = new Pawn(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[6][0] = p;
        Move move = new Move(6, 0, 3, 0);
        assertFalse(p.isValidMove(move, cp));

    }


    // Tests if invalid pawn moves OOB
    @Test 
    public void testInvalidWhitePawnOOB()
    {
        Pawn p = new Pawn(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[1][0] = p;
        Move move = new Move(1, 0, -1, 0);
        assertFalse(p.isValidMove(move, cp));

    }


    // Tests if invalid pawn moves backwards
    @Test 
    public void testInvalidWhitePawnBackwards()
    {
        Pawn p = new Pawn(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[6][0] = p;
        Move move = new Move(6, 0, 7, 0);
        assertFalse(p.isValidMove(move, cp));

    }


    // Tests if pawn will move if in starting position move 2 and enemy piece forward 1 (skip over piece)
    @Test 
    public void testInvalidWhitePawnObstacle()
    {
        Pawn p = new Pawn(Player.WHITE);
        Pawn p1 = new Pawn(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[6][0] = p;
        cp[5][0] = p1;
        Move move = new Move(6, 0, 4, 0);
        assertFalse(p.isValidMove(move, cp));

    }


    // Tests if valid move will be false if pawn moves 1 forward and a piece is there
    @Test 
    public void testInvalidWhitePawnObstacle2()
    {
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
    public void testInvalidWhitePawnDiagonal()
    {
        Pawn p = new Pawn(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[6][0] = p;
        Move move = new Move(6, 0, 5, 1);
        assertFalse(p.isValidMove(move, cp));

    }


    // Tests if invalid pawn moves diagonal if there is an allied piece there
    @Test 
    public void testInvalidWhitePawnDiagonal2()
    {
        Pawn p = new Pawn(Player.WHITE);
        Pawn p1 = new Pawn(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[6][0] = p;
        cp[5][1] = p1;
        Move move = new Move(6, 0, 5, 1);
        assertFalse(p.isValidMove(move, cp));

    }




    
//****************************************************************************** */

//       TESTING BLACK PAWN
//       VALID

// *******************************************************************************





    // Tests pawn can move forward 1 from starting position
    @Test 
    public void testBlackPawnForward1()
    {
        Pawn p = new Pawn(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[1][0] = p;
        Move move = new Move(1, 0, 2, 0);
        assertTrue(p.isValidMove(move, cp));

    }


    // tests if pawn can move forward 2 from starting position
    @Test 
    public void testBlackPawnForward2()
    {
        Pawn p = new Pawn(Player.BLACK);        
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[1][0] = p;
        Move move = new Move(1, 0, 3, 0);
        assertTrue(p.isValidMove(move, cp));

    }


    // Tests pawn can move forward 1 from non-starting position
    @Test 
    public void testBlackPawnForward()
        {
        Pawn p = new Pawn(Player.BLACK);       
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[5][6] = p;
        Move move = new Move(5, 6, 6, 6);
        assertTrue(p.isValidMove(move, cp));

        }
    

    // Tests if pawn can attack enemy player from diagonal
    @Test 
    public void testBlackPawnDiagonal()
    {
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
    public void testBlackPawnDiagonal2()
    {
        Pawn p = new Pawn(Player.BLACK);        
        Pawn p1 = new Pawn(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[1][1] = p;
        cp[2][0] = p1;
        Move move = new Move(1, 1, 2, 0);
        assertTrue(p.isValidMove(move, cp));

    }

    



    // ************************************************************************

    //       TESTING BLACK PAWN
    //       INVALID
    
    //************************************************************************* */






    // Tests if invalid pawn moves forward 3 from starting position
    @Test 
    public void testInvalidBlackPawnForward3()
    {
        Pawn p = new Pawn(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[1][0] = p;
        Move move = new Move(1, 0, 4, 0);
        assertFalse(p.isValidMove(move, cp));

    }


    // Tests if invalid pawn moves OOB
    @Test 
    public void testInvalidBlackPawnOOB()
    {
        Pawn p = new Pawn(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[6][0] = p;
        Move move = new Move(6, 0, 8, 0);
        assertFalse(p.isValidMove(move, cp));

    }


    // Tests if invalid pawn moves backwards
    @Test 
    public void testInvalidBlackPawnBackwards()
    {
        Pawn p = new Pawn(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[1][0] = p;
        Move move = new Move(1, 0, 0, 0);
        assertFalse(p.isValidMove(move, cp));

    }


    // Tests if pawn will move if in starting position move 2 and enemy piece forward 1 (skip over piece)
    @Test 
    public void testInvalidBlackPawnObstacle()
    {
        Pawn p = new Pawn(Player.BLACK);        
        Pawn p1 = new Pawn(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[1][0] = p;
        cp[2][0] = p1;
        Move move = new Move(1, 0, 3, 0);
        assertFalse(p.isValidMove(move, cp));

    }


    // Tests if valid move will be false if pawn moves 1 forward and a piece is there
    @Test 
    public void testInvalidBlackPawnObstacle2()
    {
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
    public void testInvalidBlackPawnDiagonal()
    {
        Pawn p = new Pawn(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[1][0] = p;
        Move move = new Move(1, 0, 2, 1);
        assertFalse(p.isValidMove(move, cp));

    }


    // Tests if invalid pawn moves diagonal if there is an allied piece there
    @Test 
    public void testInvalidBlackPawnDiagonal2()
    {
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


    //                       ROOK


    // **************************************************************************************************
    // **************************************************************************************************


    // ******************************************************************************************

    //      TEST ROOK
    //      VALID

    // ******************************************************************************************







    // ******************************************************************************************

    //      TEST ROOK
    //      INVALID

    // ******************************************************************************************













    // **************************************************************************************************
    // **************************************************************************************************


    //                       KING


    // **************************************************************************************************
    // **************************************************************************************************


    // ******************************************************************************************

    //      TEST KING
    //      VALID

    // ******************************************************************************************







    // ******************************************************************************************

    //      TEST KING
    //      INVALID

    // ******************************************************************************************
















    // **************************************************************************************************
    // **************************************************************************************************


    //                       BISHOP


    // **************************************************************************************************
    // **************************************************************************************************


    // ******************************************************************************************

    //      TEST BISHOP
    //      VALID

    // ******************************************************************************************







    // ******************************************************************************************

    //      TEST BISHOP
    //      INVALID

    // ******************************************************************************************


















    // **************************************************************************************************
    // **************************************************************************************************


    //                       KNIGHT


    // **************************************************************************************************
    // **************************************************************************************************


    // ******************************************************************************************

    //      TEST KNIGHT
    //      VALID

    // ******************************************************************************************


    
    // Tests knight can move 3 forward and 2 right
    @Test 
    public void testWhiteKnight3F2R()
    {
        Knight p = new Knight(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[7][1] = p;
        Move move = new Move(7, 1, 4, 3);
        assertTrue(p.isValidMove(move, cp));

    }


    // Tests knight can move 3 forward and 2 left
    @Test 
    public void testWhiteKnight3F2L()
    {
        Knight p = new Knight(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[7][6] = p;
        Move move = new Move(7, 6, 4, 4);
        assertTrue(p.isValidMove(move, cp));

    }


    // Tests knight can move 3 back and 2 left
    @Test 
    public void testWhiteKnight3B2L()
    {
        Knight p = new Knight(Player.WHITE);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[4][3] = p;
        Move move = new Move(4, 3, 7, 1);
        assertTrue(p.isValidMove(move, cp));

    }


    // Tests knight can move 3 back and 2 right
    @Test 
    public void testWhiteKnight3B2R()
    {
        Knight p = new Knight(Player.WHITE);        
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[4][4] = p;
        Move move = new Move(4, 4, 7, 6);
        assertTrue(p.isValidMove(move, cp));

    }


    // Tests knight can move 2 forward and 3 right
    @Test 
    public void testWhiteKnight2F3R()
    {
        Knight p = new Knight(Player.WHITE);        
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[2][1] = p;
        Move move = new Move(2, 1, 4, 4);
        assertTrue(p.isValidMove(move, cp));

    }


    // Tests knight can move 2 forward and 3 left
    @Test 
    public void testWhiteKnight2F3L()
    {
        Knight p = new Knight(Player.WHITE);        
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[2][7] = p;
        Move move = new Move(2, 7, 4, 4);
        assertTrue(p.isValidMove(move, cp));

    }

            
    // Tests knight can move 2 back and 3 right
    @Test 
    public void testWhiteKnight2B3R()
    {
        Knight p = new Knight(Player.WHITE);        
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[4][4] = p;
        Move move = new Move(4, 4, 2, 7);
        assertTrue(p.isValidMove(move, cp));

    }


    // Tests knight can move 2 back  and 3 right
    @Test 
    public void testWhiteKnight2B3L()
    {
        Knight p = new Knight(Player.WHITE);        
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[4][4] = p;
        Move move = new Move(4, 4, 2, 1);
        assertTrue(p.isValidMove(move, cp));

    }


    // Tests if pawn will move if in starting position move 2 and enemy piece forward 1 (skip over piece)
    @Test 
    public void testWhiteKnightTakeEnemyPiece()
    {
        Knight p = new Knight(Player.WHITE);
        Knight p1 = new Knight(Player.BLACK);
        ChessPiece[][] cp = new ChessPiece[8][8];
        cp[7][1] = p;
        cp[4][3] = p1;
        Move move = new Move(7, 1, 4, 3);
        assertTrue(p.isValidMove(move, cp));

    }



    // ******************************************************************************************

    //      TEST KNIGHT
    //      INVALID

    // ******************************************************************************************



        // Tests pawn can move forward 1 from starting position
        @Test 
        public void testInvalidWhiteKnightHorizontal()
        {
            Knight p = new Knight(Player.WHITE);
            ChessPiece[][] cp = new ChessPiece[8][8];
            cp[7][1] = p;
            Move move = new Move(7, 1, 7, 3);
            assertFalse(p.isValidMove(move, cp));
    
        }
    
    
        // Tests pawn can move forward 1 from starting position
        @Test 
        public void testInvalidWhiteKnight2()
        {
            Knight p = new Knight(Player.WHITE);
            ChessPiece[][] cp = new ChessPiece[8][8];
            cp[7][6] = p;
            Move move = new Move(7, 6, 4, 3);
            assertFalse(p.isValidMove(move, cp));
    
        }
    
    
    
    
                // Tests pawn can move forward 1 from starting position
        @Test 
        public void testInvalidWhiteKnight3()
        {
            Knight p = new Knight(Player.WHITE);
            ChessPiece[][] cp = new ChessPiece[8][8];
            cp[4][3] = p;
            Move move = new Move(4, 3, 7, 1);
            assertFalse(p.isValidMove(move, cp));
    
        }
    
    
        // Tests pawn can move forward 1 from starting position
        @Test 
        public void testInvalidWhiteKnight4()
        {
            Knight p = new Knight(Player.WHITE);        
            ChessPiece[][] cp = new ChessPiece[8][8];
            cp[4][4] = p;
            Move move = new Move(4, 4, 7, 6);
            assertTrue(p.isValidMove(move, cp));
    
        }
    
    
        // Tests pawn can move forward 1 from starting position
        @Test 
        public void testInvalidWhiteKnight5()
        {
            Knight p = new Knight(Player.WHITE);        
            ChessPiece[][] cp = new ChessPiece[8][8];
            cp[2][1] = p;
            Move move = new Move(2, 1, 4, 4);
            assertTrue(p.isValidMove(move, cp));
    
        }
    
    
        // Tests pawn can move forward 1 from starting position
        @Test 
        public void testInvalidWhiteKnight6()
        {
            Knight p = new Knight(Player.WHITE);        
            ChessPiece[][] cp = new ChessPiece[8][8];
            cp[2][7] = p;
            Move move = new Move(2, 7, 4, 4);
            assertTrue(p.isValidMove(move, cp));
    
        }
    
    
    
    
        // Tests pawn can move forward 1 from starting position
        @Test 
        public void testInvalidWhiteKnight7()
        {
            Knight p = new Knight(Player.WHITE);        
            ChessPiece[][] cp = new ChessPiece[8][8];
            cp[4][4] = p;
            Move move = new Move(4, 4, 2, 7);
            assertTrue(p.isValidMove(move, cp));
    
        }
    
    
        // Tests pawn can move forward 1 from starting position
        @Test 
        public void testInvalidWhiteKnight8()
        {
            Knight p = new Knight(Player.WHITE);        
            ChessPiece[][] cp = new ChessPiece[8][8];
            cp[4][4] = p;
            Move move = new Move(4, 4, 2, 1);
            assertTrue(p.isValidMove(move, cp));
    
        }














    // **************************************************************************************************
    // **************************************************************************************************


    //                       QUEEN


    // **************************************************************************************************
    // **************************************************************************************************


    // ******************************************************************************************

    //      TEST QUEEN
    //      VALID

    // ******************************************************************************************







    // ******************************************************************************************

    //      TEST QUEEN
    //      INVALID

    // ******************************************************************************************






}
