import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.AffineTransform;

public class Ship extends Prop{
	
	Point[] pts = getOriginalPts();
	double rotationAngle;
	
	public Ship(int x, int y) {
		super(x, y, 0,0,new Polygon(new int[] {x + 8, x - 8, x}, new int[] {y - 8, y - 8, y + 12}, 3));
		rotationAngle = 0.0;
	}

	public void setMoveVec() {
		if(rotationAngle == 0.0) {
			this.yVel = 20;
			this.xVel = 0;
		}
		else {
			this.yVel = 20 * Math.sin(Math.toRadians(rotationAngle+90));
			this.xVel = 20 * Math.cos(Math.toRadians(rotationAngle+90));
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
	
	public void paintComponent(Graphics g) {
		g.setColor(new Color(255,100,255));
		g.drawPolygon(bBox);
		
	}
	
	public void Inbounds() {
		if (center.x>1000) {
			center.x -= 1000;
			for(Point pt : pts) {
				pt.x -=1000;
			}
			super.setPoly(polygonize());
		}
		else if( center.x<0) {
			center.x += 1000;
			for(Point pt : pts) {
				pt.x +=1000;
			}
			super.setPoly(polygonize());
		}
		
		if (center.y>=1000) {
			center.y -= 1000;
			for(Point pt : pts) {
				pt.y -=1000;
			}
			super.setPoly(polygonize());
		}
		else if( center.y<=0) {
			center.y += 1000;
			for(Point pt : pts) {
				pt.y +=1000;
			}
			super.setPoly(polygonize());
		}
	}
}