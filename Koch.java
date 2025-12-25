/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.

        
		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
		// and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		/*curve(Integer.parseInt(args[0]),
			  Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		      Double.parseDouble(args[3]), Double.parseDouble(args[4]));
		*/

		
		// Tests the snowflake function:
		// Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		snowFlake(Integer.parseInt(args[0]));
		
	}

	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). 
	public static void curve(int n, double x1, double y1, double x2, double y2) {
		StdDraw.line(x1, y1, x2, y2);
		//// Write the rest of your code below.
	}

    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. 
	public static void snowFlake(int n) {
		// A little tweak that makes the drawing look better
		StdDraw.setYscale(0, 1.1);
		StdDraw.setXscale(0, 1.1);
		// Draws a Koch snowflake of depth n
		//// Write the rest of your code below. /* */
/** Gets n, x1, y1, x2, y2,
 *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
/** Gets n, x1, y1, x2, y2,
 *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
public static void curve(int n, double x1, double y1, double x2, double y2) {

    // Base case: draw the segment
    if (n == 0) {
        StdDraw.line(x1, y1, x2, y2);
        return;
    }

    // A = 1/3 point, B = 2/3 point
    double ax = x1 + (x2 - x1) / 3.0;
    double ay = y1 + (y2 - y1) / 3.0;

    double bx = x1 + 2.0 * (x2 - x1) / 3.0;
    double by = y1 + 2.0 * (y2 - y1) / 3.0;

    // C = vertex of equilateral triangle on the middle third (LEFT of direction p1->p2)
    // Given formula in the handout (outside L):
    double cx = (x1 + x2) / 2.0 + (Math.sqrt(3) / 6.0) * (y1 - y2);
    double cy = (y1 + y2) / 2.0 + (Math.sqrt(3) / 6.0) * (x2 - x1);

    // Recurse on 4 segments
    curve(n - 1, x1, y1, ax, ay);
    curve(n - 1, ax, ay, cx, cy);
    curve(n - 1, cx, cy, bx, by);
    curve(n - 1, bx, by, x2, y2);
}

/** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
public static void snowFlake(int n) {
    // A little tweak that makes the drawing look better
    StdDraw.setYscale(0, 1.1);
    StdDraw.setXscale(0, 1.1);

    // Base equilateral triangle
    double x1 = 0.2, y1 = 0.2;
    double x2 = 0.9, y2 = 0.2;
    double x3 = (x1 + x2) / 2.0;
    double y3 = y1 + (x2 - x1) * Math.sqrt(3) / 2.0;

    // IMPORTANT: draw in CLOCKWISE order so the "left side" bumps go OUTWARD
    curve(n, x1, y1, x3, y3);
    curve(n, x3, y3, x2, y2);
    curve(n, x2, y2, x1, y1);
}

	}