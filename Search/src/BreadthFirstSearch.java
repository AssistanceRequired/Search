import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

	Node startnode;
    Node goalnode;
    
    public BreadthFirstSearch(Node start, Node end) {
    	
    	this.startnode = start;
    	this.goalnode = end;
    }
    /**
     * algorithm using queues and slowly popping them off until the city we want is found
     * @return false/true
     */
    public boolean search() {
    	
    	
    	if (this.startnode.equals(this.goalnode)) {
    		System.out.println("Goal Node Found!");
            System.out.println(startnode);
    	}
    	
    	Queue<Node> queue = new LinkedList<Node>();
    	ArrayList<Node> explored = new ArrayList<>();
    	queue.add(this.startnode);
    	//explored.add(this.startnode);
    	
    	while(!queue.isEmpty()) {
    		
    		Node current = queue.remove();
    		
    		if (current.equals(this.goalnode)) {
    			explored.add(current);
    			System.out.println(queue);
    			System.out.println(explored);
                return true;
    		} else {
                 if (current.getChildren().isEmpty())
                     return false;
                 else
                	 queue.addAll(current.getChildren());
            }
            explored.add(current);
        }
    	return false;
    }
}
