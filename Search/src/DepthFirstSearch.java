
public class DepthFirstSearch extends PathFinder {
	
	public DepthFirstSearch(Node start, Node end) {
		
		super(start,end);
	}
	
	public boolean search() {
		
		if (this.startnode.equals(this.goalnode)) {
    		System.out.println("Goal Node Found!");
            System.out.println(startnode);
    	}
		
	}

}
