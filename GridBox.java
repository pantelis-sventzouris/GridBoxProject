package gr.pantelis;

//essential class for describing each gridbox as an object
public class GridBox
{
	private double xmin,ymin,xmax,ymax; //x,y coordinates of a gridbox
	
	public GridBox(double xk, double yk, int i, int j)
	{
		xmin = i * xk;			//xmin of a gridbox
		ymin = j * yk;			//ymin of a gridbox
		xmax = (i+1) * xk;		//xmax of a gridbox
		ymax = (j+1) * yk;		//ymax of a gridbox
	}
	
	//gets xmin
	public double getXmin()
	{
		return xmin;
	}
	
	//gets ymin
	public double getYmin()
	{
		return ymin;
	}
	
	//gets xmax
	public double getXmax()
	{
		return xmax;
	}
	
	//gets ymax
	public double getYmax()
	{
		return ymax;
	}
	
	//gets x-coordinate of gridbox center
	public double getCenterX()
	{
		return (xmin+xmax)/2;
	}
	
	//gets y-coordinate of gridbox center
	public double getCenterY()
	{
		return (ymin+ymax)/2;
	}
	
	//gets gridbox area
	public double getArea()
	{
		return (xmax-xmin)*(ymax-ymin);
	}
	
	//gets diagon (distance between (xmin,ymin) and (xmax,ymax))
	public double getDiagonalDistance()
	{
		double x = xmax-xmin;
		double y = ymax-ymin;
		
		double x2 = Math.pow(x, 2);
		double y2 = Math.pow(y, 2);
		
		double distance = Math.sqrt(x2+y2);
		
		return distance;
	}
}
