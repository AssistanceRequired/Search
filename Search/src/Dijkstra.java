import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstra extends PathFinder {
	
	public Dijkstra (Node start, Node end, int[][] adj) {
		
		super(start, end, adj);
		
	}

	public boolean search() {
		
		if (super.startnode.equals(super.goalnode)) {
    		System.out.println("Goal Node Found!");
            System.out.println(super.startnode);
    	}
		
		this.startnode.setDistance(0);
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
					
					// what occurs when we are moving to a new city
					if (!priority.contains(n) && !visitednodes.contains(n)) {
						//updates the minimum distance of priority queue
						n.setDistance(current.getDistance() + super.adj[current.getIndex()][n.getIndex()]);
						n.setParent(current);
						priority.add(n);
						
					} else if (n.getDistance() > current.getDistance() + super.adj[current.getIndex()][n.getIndex()]) {
						//shorter path has been found and updating the nodes for cities we have already moved to
						n.setDistance(current.getDistance() + super.adj[current.getIndex()][n.getIndex()]);
						n.setParent(current);
					}
				}
				visitednodes.add(current);
			}
		}
		return false;
	}
	/**
	 * moving backwards to find the path we took to get to goal node
	 * @param goal
	 */
	private void printPath(Node goal){
		while (goal.getParent() != null) {
			System.out.print(goal + "<--");
			goal = goal.getParent();
		}
		System.out.println(goal);
	}
}
