import java.util.ArrayList;
import java.util.Stack;

public class DepthFirstSearch extends PathFinder {
	
	public DepthFirstSearch(Node start, Node end) {
		
		super(start,end);
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
		
		Stack<Node> stack = new Stack<Node>();
		ArrayList<Node> visitednodes = new ArrayList<Node>();
		stack.add(startnode);
		
		while (!stack.isEmpty()) {
			Node current = stack.pop();
			if (current.equals(super.goalnode)) {
				visitednodes.add(current);
				System.out.println(visitednodes);
		        System.out.println("Goal node found");
		        return true;
			} else {
				visitednodes.add(current);
				for (int i = 0; i < current.getChildren().size(); i ++) {
					if (!stack.contains(current.getChildren().get(i))) 
						stack.add(current.getChildren().get(i));
				}
			}
		}
		return false;
	}

}
