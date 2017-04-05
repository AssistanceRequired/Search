
import java.util.ArrayList;
import java.util.Stack;


import java.util.PriorityQueue;

public class AStar extends PathFinder{
	
	private Node [][] grid;
	private int size;
	
	
	public AStar(Node start, Node goal, int[][] graph, int size){
		super(start, goal, graph);
		this.grid = new Node [size][size];
		this.grid[start.getX()][start.getY()] = start;
		this.grid[goal.getX()][goal.getY()] = goal;
		this.size = size;
		
		//Populates the Grid with Nodes
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				if(grid[i][j] != start && grid[i][j] != goal){
					grid[i][j] = new Node(i,j);
					grid[i][j].setCost(calcDist(grid[i][j]));
				}
			}
		}
	}
	/**
	 * Uses our grid to determine the children
	 * we have from our current node.
	 * @param current Node
	 * @return a list of the children nodes
	 */
	private ArrayList<Node> getChildren(Node current){
		int x = current.getX();
		int y = current.getY();
		ArrayList<Node> children = new ArrayList<Node>();
		//Makes sure the current Node position is not on the "edges" of the Array.
		if (y < size-1) {
			if (adj[x][y+1]!=0){
				children.add(grid[x][y+1]);
			}
		}
		if (x < size-1) {
			if (adj[x+1][y] != 0){
				children.add(grid[x+1][y]);
			}
		}
		if (x > 0) {
			if (adj[x-1][y] != 0){
				children.add(grid[x-1][y]);
			}
		}
		if (y > 0) {
			if (adj[x][y-1] != 0){
				children.add(grid[x][y-1]);
			}
		}
		return children;
	}
	
	/**
	 * the distance to goalnode from current node
	 * @param current Node
	 * @return Euclidean/Heuristic distance from current to goal Node
	 */
	private double calcDist(Node current){
		
		return Math.sqrt(Math.pow(current.getX() - goalnode.getX(),2) + Math.pow(current.getY() - goalnode.getY(), 2));
	}

	@Override
	public boolean search() {
		
		if(this.startnode.equals(goalnode))
		{
			System.out.println("Goal Node Found!");
			System.out.println(startnode);
		}
		
		this.startnode.setDistance(0);
		PriorityQueue<Node> unexplored = new PriorityQueue<Node>();
		unexplored.add(startnode);
		ArrayList<Node> explored = new ArrayList<Node>();
		
		while (!unexplored.isEmpty()){
			
			Node current = unexplored.remove();
			if (current.equals(this.goalnode)) {
				explored.add(current);
				printPath(current);
				return true;
			}
			else{
				for (Node x : getChildren(current)) {
					
					if (!explored.contains(x) && !unexplored.contains(x)) {
						x.setDistance(current.getDistance() + 1);
						x.setCost(x.getDistance() + calcDist(x));
						x.setParent(current);
						unexplored.add(x);
					} else if (x.getDistance() > current.getDistance() + 1) {
						x.setDistance(current.getDistance() + 1);
						x.setCost(x.getDistance() + calcDist(x));
						x.setParent(current);
					}
				}
				explored.add(current);
			}
		}
		return false;
	}

	private void printPath(Node goal) {
		while (goal.getParent() != null){
			System.out.print(goal + " <--- ");
			goal = goal.getParent();
		}
		System.out.println(goal);
	}
	
}
