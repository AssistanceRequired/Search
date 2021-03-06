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
	
	private double cost = Double.MAX_VALUE;
	
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
	public Node(int x, int y) {
		
		this.posX = x;
		this.posY = y;
		this.name = "[" + x + "," + y + "]";
		
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
    public void addChildren(Node node) {
    	
    	childnodes.add(node);
    	
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
	
	public double getCost() {
		
		return this.cost;
	}
	
	public void setCost(double c){
		
		this.cost = c;
	}

	public void setX(int x) {
		
		posX = x;
		
	}
	public void setY(int y) {
		
		posY = y;
		
	}
	public int getX() {
		
		return posX;
		
	}
	public int getY() {
		
		return posY;
		
	}
	public Node getParent() {
		
		return this.parent;
		
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
		
		/*
		 * for dijkstra
		 */ 
		//return this.min - arg0.min;
		 
		return Double.compare(this.cost, arg0.getCost());
		
	}
}
