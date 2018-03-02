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

    public static void main(String[] args) {
        System.out.println("Hello World!");
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
