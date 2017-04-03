import java.util.ArrayList;
import java.util.PriorityQueue;

public class AStar extends PathFinder {

	private int gridsize;
	
	private Node[][] grid;
	
	public AStar(Node start, Node end, int[][] map, int gridsize) {
		
		super(start, end, map);
		
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
	/**
	 * we are using a custom grid for this search for easy visuals of heuristic. 0 represents a blocked path.
	 * getCHildren is implemented here as we search instead of adding all children at once.
	 * @param current
	 * @return
	 */
	public ArrayList<Node> getChildren(Node current) {
		/*
		 *first if-statement checks for corner
		 *second if checks to see if road is blocked
		 */
		if (current.getY() < gridsize - 1) {
			
			if (adj[current.getX()][current.getY()+1] != 0) {
				
				current.addChildren(grid[current.getX()][current.getY()+1]);
				
			}
		}
		if (current.getX() < gridsize - 1) {
			
			if (adj[current.getX()+1][current.getY()] != 0) {
				
				current.addChildren(grid[current.getX()+1][current.getY()]);
				
			}
		}
		if (current.getX() > 0) {
			
			if (adj[current.getX()-1][current.getY()] != 0) {
				
				current.addChildren(grid[current.getX()-1][current.getY()]);
				
			}
		}
		if (current.getY() > 0) {
			
			if (adj[current.getX()][current.getY()-1] != 0) {
				
				current.addChildren(grid[current.getX()][current.getY()-1]);
				
			}
		}
		
		return current.getChildren();
	}
	
	public double calcDist(Node current) {
		
		return Math.sqrt(Math.pow((current.getX() - goalnode.getX()),2) 
				+ Math.pow(current.getY() - goalnode.getY(),2));
	}

	@Override
	boolean search() {
		
		if (super.startnode.equals(super.goalnode)) {
    		System.out.println("Goal Node Found!");
            System.out.println(super.startnode);
    	}
		
		PriorityQueue<Node> priority = new PriorityQueue<Node>();
		priority.add(startnode);
		
		ArrayList<Node> visitednodes = new ArrayList<Node>();
		
		while (!priority.isEmpty()) {
			
			Node current = priority.remove();
			
			//found the node
			if (current.equals(super.goalnode)) {
				
				visitednodes.add(current);
				printPath(current);
				return true;
				
			} else {
				
				/**
				 * uses the greedy algorithm to get through the cheapest child node before moving on. 
				 * If the path continues to be cheaper than the next path in the queue then we can keep checking
				 * until we find a path that is more expensive or we found our goalnode
				 */
				for (Node n : current.getChildren()) {
					
					// what occurs when we are moving to a new city so we don't need to add/compound the distance
					if (!priority.contains(n) && !visitednodes.contains(n)) {
						//updates the minimum distance of priority queue
						n.setDistance(current.getDistance() + super.adj[current.getIndex()][n.getIndex()]);
						n.setDistanceWHuer(n.getDistance() + calcDist(n));
						n.setParent(current);
						priority.add(n);
						
					} else if (n.getDistanceWHuer() > current.getDistance() + super.adj[current.getIndex()][n.getIndex()] + calcDist(n)) {
						//shorter path has been found and updating the nodes for cities we have already moved to
						n.setDistance(current.getDistance() + super.adj[current.getIndex()][n.getIndex()]);
						n.setDistanceWHuer(n.getDistance() + calcDist(n));
						//n.setParent(current);
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * moving backwards to find the path we took to get to goal node
	 * @param goal
	 */
	public void printPath(Node goal) {
		
		while(goal.getParent() != null) {
			System.out.println(goal.getX() + "," + goal.getY() + " <-- to ");
			goal = goal.getParent();
		}
		System.out.println("From" + goal.getX() + "," + goal.getY());
	}

}
