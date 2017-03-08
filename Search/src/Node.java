import java.util.ArrayList;

public class Node {
	
	/**
	 * name of the node
	 */
	private String name;
	
	private ArrayList<Node> childnodes = new ArrayList<Node>();
	
	public Node(String name, Node... child) {
		
		this.name = name;
		
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

	public String toString() {
		return name;
	}
}
