import java.util.Stack;


public class Main {

	public static void main(String[] args) {
		int xSource = 6;
		int ySource = 7;
		int xTarget = 0;
		int yTarget = 0;
		
		printShortestPath(xSource, ySource, xTarget, yTarget);

	}
	private static void printShortestPath(int xSource, int ySource, int xTarget, int yTarget){
		
		Graph g =new Graph();
		Node node = g.findShortestPath(xSource, ySource, xTarget, yTarget);
		Stack<Node> stack = new Stack<Node>();
		stack.push(node);
		int noOfSteps=0;
		while(node.getParentNode()!=null){
			stack.push(node.getParentNode());
			node = node.getParentNode();
			noOfSteps++;
		}
		System.out.println("Number of steps="+noOfSteps);
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
	}

}
