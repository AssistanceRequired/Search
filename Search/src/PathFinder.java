
public abstract class PathFinder {
	
	Node startnode;
    Node goalnode;
    int[][] adj;
    
    public PathFinder(Node start, Node end) {
	
    	this.startnode = start;
    	this.goalnode = end;
    }
    
    public PathFinder(Node start, Node end, int[][] adj) {
    	
    	this.startnode = start;
    	this.goalnode = end;
    	this.adj = adj;
    	
    }
	/**
     * @return true/false to continue/end the search
     */
    abstract boolean search();
    
}
