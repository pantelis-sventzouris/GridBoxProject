package gr.pantelis;

public class Grid
{
	private int k;							//create a k*k grid
	private double xmin,ymin,xmax,ymax;		//define the boundaries of a grid (xmin,ymin),(xmax,ymax)
	private double x,y,xk,yk;				//x-axis, y-axis of grid and gridbox
	private GridBox[][] box;				//define the 2-dimensional GridBox array
	
	
	//constructor. parameters: k*k gridboxes, boundaries of the grid as coordinates
	public Grid(int k, double xmin, double ymin, double xmax, double ymax)
	{
		this.k = k;
		box = new GridBox[k][k];
		this.xmin = xmin;
		this.ymin = ymin;
		this.xmax = xmax;
		this.ymax = ymax;
		
		this.x = xmax-xmin;
		this.y = ymax-ymin;
		
		this.xk = x/k;
		this.yk = y/k; 
		
		//create k*k new GridBox objects
		for(int i=0; i<k; i++)
		{
			for(int j=0; j<k; j++)
			{				
				box[i][j] = new GridBox(xk,yk,i,j);
			}
		}
	}
	
	//finds to which gridbox a point(x,y) belongs
	public GridBox findGridBox(double x, double y)
	{
		//normalize the coordinates
		x = Math.abs(x - xmin);
		y = Math.abs(y - ymin);
		
		int gridX = (int) Math.floor(x/xk);
		int gridY = (int) Math.floor(y/yk);
		
		return box[gridX][gridY];
	}
	
	//checks if two points (x1,y1) (x2,y2) belong to the same gridbox
	public boolean isInOneGridBox(double x1, double y1, double x2, double y2)
	{
		return findGridBox(x1,y1)==findGridBox(x2,y2);
	}
	
	//tests the app
	public static void main(String[] argv)
	{
		Grid grid = new Grid(10,0,0,10,10);		//define the max k*k gridboxes and the boundaries of the grid
		double centerx = grid.box[0][0].getCenterX();
		double centery = grid.box[0][0].getCenterY();		
		System.out.println("("+centerx+","+centery+")"); //displays the center coordinates of4 gridbox00
		
		
		boolean test = grid.isInOneGridBox(7.3, 4.7, 7.8, 4.9);		
		System.out.println(test);	//displays true if two points belong to the same gridbox	
	}
}
