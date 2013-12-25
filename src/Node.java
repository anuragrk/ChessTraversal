import java.util.ArrayList;
import java.util.List;


public class Node {
	private final int x;
	private final int y;
	private List<Node> connectedNodes = new ArrayList<Node>();
	private boolean isExplored = false;
	private Node parentNode;
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	public void connectNode(Node node){
		this.connectedNodes.add(node);
	}

	public void setConnectedNodes(List<Node> connectedNodes) {
		this.connectedNodes = connectedNodes;
	}
	
	public List<Node> getConnectedNodes() {
		return connectedNodes;
	}

	@Override
	public boolean equals(Object obj) {
		Node node = (Node)obj;
		return node.x == this.x && node.y == this.y;
	}

	public boolean isExplored() {
		return isExplored;
	}

	public void setExplored(boolean isExplored) {
		this.isExplored = isExplored;
	}

	public Node getParentNode() {
		return parentNode;
	}

	public void setParentNode(Node parentNode) {
		this.parentNode = parentNode;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "("+x+","+y+")";
	}
	
}
