import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.AffineTransform;

public class Ship extends Prop{
	
	Point[] pts = getOriginalPts();
	double rotationAngle;
	Point origin;
	
	public Ship(int x, int y) {
		super(x, y, 20,20,new Polygon(new int[] {x + 8, x - 8, x}, new int[] {y - 8, y - 8, y + 12}, 3));
		rotationAngle = 0.0;
		origin = new Point(x,y);
		// TODO Auto-generated constructor stub
	}

	public void setMoveVec() {
		if(rotationAngle == 0.0) {
			this.yVel = -10;
			this.xVel = 0;
		}
		else {
			this.yVel = -10 * Math.sin(Math.toRadians(rotationAngle+90));
			this.xVel = 10 * Math.cos(Math.toRadians(rotationAngle+90));
		}
		
	}
	
	public void move() {
		getCenter().x += xVel;
		getCenter().y += yVel;
		for(Point pt : pts) {
			pt.x += xVel;
			pt.y += yVel;
		}
		super.setPoly(polygonize());
	}
	
	public void rotateShip(double inc) {
		rotatePointMatrix(getOriginalPts(), rotationAngle + inc, pts);
		Polygon polytemp = polygonize();
		rotationAngle += inc;
		if(rotationAngle >= 360) {
			rotationAngle %= 360;
		}
		if(rotationAngle < 0) {
			rotationAngle = 360 + rotationAngle;
		}
		setMoveVec();
		super.setPoly(polytemp);
	
	}
	
	public void rotatePointMatrix(Point[] original, double angle, Point[] fin){

        /* We get the original points of the polygon we wish to rotate
         *  and rotate them with affine transform to the given angle. 
         *  After the operation is complete the points are stored to the 
         *  array given to the method.
        */
        AffineTransform.getRotateInstance(Math.toRadians(angle), getCenter().x, getCenter().y).transform(original,0,fin,0,3);


    }
	
	public Polygon polygonize() {
		Polygon tempPoly = new Polygon();

        for(int  i=0; i < pts.length; i++){
            tempPoly.addPoint(pts[i].x, pts[i].y);
       }

       return tempPoly;
	}
	
	
	
	public Point[] getOriginalPts() {
		Point[] origin;
		origin = new Point[3];
		origin[0] = new Point((int)getCenter().x + 8,(int)getCenter().y - 8);
		origin[1] = new Point((int)getCenter().x - 8,(int)getCenter().y - 8);
		origin[2] = new Point((int)getCenter().x, (int)getCenter().y + 12);
		return origin;
	}
}
