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
	
	private int posX;
	
	private int posY;
	
	private double costWheur;
	
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
	 /*
     * Adds children/connecting Nodes to the Node.
     */
    public void setChildren(ArrayList<Node> kids) {
    	
    	this.childnodes = kids;
    	
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
	/**
	 * 
	 * @param min
	 */
	public void setDistanceWHuer(int min) {
		
		this.costWheur = min;
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
		
		return (int)(this.costWheur - arg0.costWheur);
		
	}
}
