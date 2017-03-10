import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch extends PathFinder {
    
    public BreadthFirstSearch(Node start, Node end) {
    	
    	super(start,end);
    	
    }
    /**
     * algorithm using queues and slowly popping them off until the city we want is found
     * @return false/true
     */
    public boolean search() {
    	
    	
    	if (super.startnode.equals(super.goalnode)) {
    		System.out.println("Goal Node Found!");
            System.out.println(super.startnode);
    	}
    	
    	Queue<Node> queue = new LinkedList<Node>();
    	ArrayList<Node> explored = new ArrayList<>();
    	queue.add(super.startnode);
    	
    	while(!queue.isEmpty()) {
    		
    		Node current = queue.remove();
    		
    		if (current.equals(super.goalnode)) {
    			explored.add(current);
    			System.out.println(queue);
    			System.out.println(explored);
                return true;
    		} else {
                 if (current.getChildren().isEmpty()) {
                     return false;
                 } else {
                	 /**
                	  * checks and avoids any path that was already taken
                	  */
                	 for (int i = 0; i < current.getChildren().size(); i ++) {
                		 if (!queue.contains(current.getChildren().get(i))) {
                			 queue.add(current.getChildren().get(i));
                		 }
                	 }
                	 //queue.addAll(current.getChildren());
                 }
            }
            explored.add(current);
        }
    	return false;
    }
}
