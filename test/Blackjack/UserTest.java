/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blackjack;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author karnb
 */
public class UserTest {
    
    public UserTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }


//    /**
//     * Test of Hit_Stand method, of class User.
//     */
    @Test
    public void testStandBad() {
        System.out.println("Stand Bad Test");
        String hitter = "";
        boolean expResult = false;
        boolean result = User.Hit_Stand(hitter);
        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
    }
    @Test
    public void testStandBoundary() {
        System.out.println("Stand Boundary Test");
        String hitter = "S";
        boolean expResult = false;
        boolean result = User.Hit_Stand(hitter);
        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
    }
    
    @Test
    public void testStandGood() {
        System.out.println("Stand Good Test");
        String hitter = "stand";
        boolean expResult = true;
        boolean result = User.Hit_Stand(hitter);
        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
    }
    
    @Test
    public void testHitGood() {
        System.out.println("Hit Good Test");
        String hitter = "hit";
        boolean expResult = true;
        boolean result = User.Hit_Stand(hitter);
        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
    }
    
    @Test
    public void testHitBad() {
        System.out.println("Hit Bad Test");
        String hitter = "";
        boolean expResult = false;
        boolean result = User.Hit_Stand(hitter);
        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
    }
    
    @Test
    public void testHitBoundary() {
        System.out.println("Hit Boundary Test");
        String hitter = "H";
        boolean expResult = false;
        boolean result = User.Hit_Stand(hitter);
        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
    }
  


    /**
     * Test of yes_no method, of class User.
     */
    @Test
    public void testYesGood() {
        System.out.println("Yes Good Test");
        String answer = "yes";
        boolean expResult = true;
        boolean result = User.yes_no(answer);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
    @Test
    public void testYesBad() {
        System.out.println("Yes Bad Test");
        String answer = "";
        boolean expResult = false;
        boolean result = User.yes_no(answer);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
    @Test
    public void testYesBoundary() {
        System.out.println("Yes Boundary Test");
        String answer = "y";
        boolean expResult = false;
        boolean result = User.yes_no(answer);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
    @Test
    public void testNoGood() {
        System.out.println("No Good Test");
        String answer = "no";
        boolean expResult = true;
        boolean result = User.yes_no(answer);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
    @Test
    public void testNoBad() {
        System.out.println("No Bad Test");
        String answer = "";
        boolean expResult = false;
        boolean result = User.yes_no(answer);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
    @Test
    public void testNoBoundary() {
        System.out.println("No Boundary Test");
        String answer = "n";
        boolean expResult = false;
        boolean result = User.yes_no(answer);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }


    
}
