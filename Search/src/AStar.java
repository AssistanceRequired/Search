import java.util.ArrayList;

public class AStar extends PathFinder {

	private int gridsize;
	
	private Node[][] grid;
	
	public AStar(Node start, Node end, int gridsize) {
		
		super(start, end);
		
		this.grid = new Node[gridsize][gridsize];
		this.grid[super.startnode.getX()][startnode.getY()] = startnode;
		this.grid[goalnode.getX()][goalnode.getY()] = goalnode;
		
		for (int i = 0; i < gridsize; i++) {
			
			for (int j = 0; j < gridsize; j++) {
				
				if (this.grid[i][j] != startnode && this.grid[i][j] != goalnode) {
					
					grid[i][j] = new Node(i,j);
					grid[i][j].setDistanceWHuer(calcDist(grid[i][j]));
				}
			}
		}
		
		this.gridsize = gridsize; 
	}
	public ArrayList<Node> getChildren(Node current) {
		
	}
	
	public double calcDist(Node current) {
		
		return Math.sqrt(Math.pow((current.getX() - goalnode.getX()),2) 
				+ Math.pow(current.getY() - goalnode.getY(),2));
	}

	@Override
	boolean search() {
		// TODO Auto-generated method stub
		return false;
	}

}
