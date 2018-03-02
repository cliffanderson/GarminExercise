import java.util.ArrayList;
import java.util.List;

/*
 *  Cliff Anderson
 *  03/01/18
 *  Garmin Coding Exercise
 *
 *  Written and compiled under Java 1.8
 */


public class GarminExercise {

    private static Node buildGarminTree() {
        // Create nodes
        Node root = new Node("Start");
        Node A1 = new Node("A1");
        Node A2 = new Node("A2");
        Node B1 = new Node("B1");
        Node B2 = new Node("B2");
        Node C1 = new Node("C1");
        Node D1 = new Node("D1");
        Node E1 = new Node("E1");
        Node findMe = new Node("Find Me");

        // Build tree
        root.getChildren().add(A1);
        root.getChildren().add(A2);

        A1.getChildren().add(D1);

        D1.getChildren().add(E1);

        A2.getChildren().add(B1);
        A2.getChildren().add(B2);

        B1.getChildren().add(findMe);

        B2.getChildren().add(C1);

        return root;
    }

    private static Node findNodeByName(Node node, String targetName) {
        // Logging
        System.out.printf("findNodeByName()  node=%s  targetName=%s%n", node.getName(), targetName);

        // Did we find the right node?
        if(node.getName().equals(targetName)) {
            // Yes!
            return node;
        }

        // We are still searching for the right node
        // For each child node, make a recursive call
        for(Node n : node.getChildren()) {
            Node foundNode = findNodeByName(n, targetName);

            if(foundNode != null) {
                // If it's not null we are successful in finding the node
                return foundNode;
            }
        }

        // Return null because we didn't find the node
        return null;
    }

    public static void main(String[] args) {
        Node root = buildGarminTree();
        String targetName = "Find Me";

        Node foundNode = findNodeByName(root, targetName);

        System.out.printf("%n%nThe node with name %s %s found", targetName, (foundNode == null ? "was not" : "was"));

    }
}

class Node {

    private String name;
    private List<Node> children;

    public Node() {
        children = new ArrayList<>();
    }

    public Node(String name) {
        this();
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Node> getChildren() {
        return this.children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }
}
