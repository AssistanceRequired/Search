
public abstract class PathFinder {
	
	Node startnode;
    Node goalnode;
    
    public PathFinder(Node start, Node end) {
	
    	this.startnode = start;
    	this.goalnode = end;
    }
	/**
     * @return true/false to continue/end the search
     */
    abstract boolean search();
    
}
