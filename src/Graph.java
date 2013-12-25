import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
	private List<Node> nodes = new ArrayList<Node>();
	private ChessPiece chessPiece = new Knight();
	public Graph(){
		//init the nodes
		for(int i=0;i<=7;i++){
			for(int j=0;j<=7;j++){
				nodes.add(new Node(j,i));
			}
		}
		//set the adjacency list according to the carrier chess piece
		for(int i=0;i<=7;i++){
			for(int j=0;j<=7;j++){
				chessPiece.setConnectedNodes(j,i);
			}
		}
	}

	private Node getNode(int x, int y){
		return nodes.get(get1DIndex(x, y));
	}
	public Node findShortestPath(int xSource, int ySource, int xTarget, int yTarget){
		if(xSource<0||xSource>7||ySource<0||ySource>7||xTarget<0||xTarget>7||yTarget<0||yTarget>7)
			throw new IllegalArgumentException("Coordinates outside range");
		//Standard BFS with parent links
		Queue<Node> nodeQueue = new LinkedList<Node>();
		nodeQueue.add(getNode(xSource, ySource));
		Node dequedNode = null;
		boolean matchFound = false;
		while(!nodeQueue.isEmpty()){
			dequedNode = nodeQueue.poll();
			if(dequedNode.equals(new Node(xTarget, yTarget))){
				matchFound = true;
				break;
			}
			for(Node node:dequedNode.getConnectedNodes()){
				if(!node.isExplored()){
					node.setParentNode(dequedNode);
					nodeQueue.add(node);
				}
			}
			dequedNode.setExplored(true);
		}
		if(!matchFound){
			dequedNode = null;
		}
		return dequedNode;
	}
	private int get1DIndex(int x,int y){
		return ((y<<3)+x);
	}
	/*	private List<Node> getConnectedNodesForNode(int x,int y){
		return nodes.get(x+y<<3);
	}*/
	private class Knight implements ChessPiece {

		/**
		 * Initialize valid reachable nodes from current node
		 */
		public void setConnectedNodes(int x, int y){
			List<Node> connectedNodeList = new ArrayList<Node>();
			if(isValidNode(x+2, y+1)){
				connectedNodeList.add(getNode(x+2, y+1));				
			}
			if(isValidNode(x-2, y-1)){
				connectedNodeList.add(getNode(x-2, y-1));
			}
			if(isValidNode(x+2, y-1)){
				connectedNodeList.add(getNode(x+2, y-1));
			}
			if(isValidNode(x-2, y+1)){
				connectedNodeList.add(getNode(x-2, y+1));
			}
			if(isValidNode(x+1, y+2)){
				connectedNodeList.add(getNode(x+1, y+2));
			}
			if(isValidNode(x-1, y-2)){
				connectedNodeList.add(getNode(x-1, y-2));
			}
			if(isValidNode(x+1, y-2)){
				connectedNodeList.add(getNode(x+1, y-2));
			}
			if(isValidNode(x-1, y+2)){
				connectedNodeList.add(getNode(x-1, y+2));
			}
			getNode(x, y).setConnectedNodes(connectedNodeList);
		}
		
		private boolean isValidNode(int m,int n){
			boolean isValidNode = false;
			if(m>=0 && n>=0 && m<=7 && n<=7){
				isValidNode = true;
			}
			return isValidNode;
		}

	}
	
}
