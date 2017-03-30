import java.util.ArrayList;

public class Node implements Comparable<Node> {
	
	/**
	 * name of the node
	 */
	private String name;
	
	private int index;
	
	private int min = Integer.MAX_VALUE;
	
	private Node parent;
	
	private ArrayList<Node> childnodes = new ArrayList<Node>();
	
	public Node(String name, Node... child) {
		
		this.name = name;
		
		for (Node kid: child) {
			childnodes.add(kid);
		}
	}
	public Node(String name, int index, Node... child) {
		
		this.name = name;
		
		this.index = index;
		
		for (Node kid: child) {
			childnodes.add(kid);
		}
	}
	/**
	 * Paths that this node will lead to
	 * @return all children of this node
	 */
	public ArrayList<Node> getChildren() {
		
        return childnodes;
	}
	
	public boolean removeChild(Node n) {
		
        return false;
        
    }
	
	public int getDistance() {
		
		return min;
		
	}

	public void setDistance(int min) {
		
		this.min = min;
		
	}
			
	public Node getParent() {
		
		return parent;
		
	}
	
	public void setParent(Node parent) {
		
		this.parent = parent;
		
	}
	public int getIndex() {
		
		return index;
		
	}
	
	public String toString() {
		return name;
	}
	
	@Override
	public int compareTo(Node arg0) {
		
		return this.min - arg0.min;
	}
}
