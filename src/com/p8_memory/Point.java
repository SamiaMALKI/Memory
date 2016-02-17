package com.p8_memory;

/**
 *
 * @author Ludovic GREMY
 */
public class Point {

    private int x;
    private int y;

    public Point (int p_x, int p_y) {
        x   = p_x;
        y   = p_y;
    }
    public void setPoint (int p_x, int p_y) {
        x   = p_x;
        y   = p_y;
    }
    public int getX ()
    {
    	
    	return x;
    }
    
    public int getY ()
    {
    	
    	return y;
    }
}
