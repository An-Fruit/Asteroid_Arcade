import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.AffineTransform;

public class Ship extends Prop{
	
	Point[] pts = getOriginalPts();
	double rotationAngle;
	double angleAccel;
	double angleDecay;
	double velDecay;
	int normalVec;
	public Ship(int x, int y) {
		super(x, y, 0,0,new Polygon(new int[] {x + 8, x - 8, x}, new int[] {y - 8, y - 8, y + 12}, 3));
		rotationAngle = 0.0;
		angleAccel = 0.0;
		normalVec = 20;
		velDecay = .9;
		angleDecay = .9;
	}
	
	public void accelRotate(double temp) {
		angleAccel += temp;
	}
	public void accelMove(double temp) {
		if(normalVec + temp <= 20) {
			normalVec += temp;
		}
		else normalVec = 20;
	}
	public void decayVel() {
		normalVec *= velDecay;
		setMoveVec();
	}
	public void decayAngle() {
		angleAccel *= angleDecay;
	}
	
	public void setMoveVec() {
//		if(rotationAngle == 0.0) {
//			this.yVel = normalVec;
//			this.xVel = 0;
//		}
//		else {
			this.yVel = normalVec * Math.sin(Math.toRadians(rotationAngle+90));
			this.xVel = normalVec * Math.cos(Math.toRadians(rotationAngle+90));
//		}
		
	}
	
	public double[] getMoveVec() {
		double[] arr = new double[] {10 * Math.cos(Math.toRadians(rotationAngle+90)), 10 * Math.sin(Math.toRadians(rotationAngle+90))};
		return arr;
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
	
	public void rotateShip() {
		
		rotatePointMatrix(getOriginalPts(), rotationAngle + angleAccel, pts);
		Polygon polytemp = polygonize();
		super.setPoly(polytemp);
		rotationAngle += angleAccel;
		if(rotationAngle >= 360) {
			rotationAngle %= 360;
		}
		if(rotationAngle < 0) {
			rotationAngle = 360 + rotationAngle;
		}
		setMoveVec();
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
