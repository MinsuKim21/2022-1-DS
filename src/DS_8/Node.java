package DS_8;

public class Node <Key extends Comparable<Key>, Value>{
    private Key id;
    private Value name;
    private int height;
    private Node left, right;

    public Node(Key newId, Value newName, int newHt){
        id = newId;
        name = newName;
        height = newHt;
        left = right = null;
    }

    public int getHeight() {return height;}

    public Key getKey() {return id;}
    public Value getValue() {return name;}
    public Node getLeft(){return left;}
    public Node getRight() { return right;}

    public void setKey(Key newId){id = newId;}
    public void setValue(Value newName){name = newName;}
    public void setLeft(Node newLeft){left = newLeft;}
    public void setRight(Node newRight){ right = newRight;}

    public void setHeight(int newHeight) {height = newHeight;}
}
