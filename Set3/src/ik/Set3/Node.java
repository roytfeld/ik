package ik.Set3;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {
    private List<Node<T>> children = new ArrayList<Node<T>>();
    private Node<T> parent = null;
    public Node<T> left = null;
    public Node<T> right = null;
    public int data;
    private T nodedata = null;

    public Node(int data) {
        this.data = data;
    }
    public Node(T data) {
        this.nodedata = data;
    }

    public Node(int data, Node<T> parent) {
        this.data = data;
        this.parent = parent;
    }
    public Node(T data, Node<T> parent) {
        this.nodedata = data;
        this.parent = parent;
    }

    public List<Node<T>> getChildren() {
        return children;
    }

    public void setParent(Node<T> parent) {
        parent.addChild(this);
        this.parent = parent;
    }

    public void addChild(T data) {
        Node<T> child = new Node<T>(data);
        child.setParent(this);
        this.children.add(child);
    }

    public void addChild(Node<T> child) {
        child.setParent(this);
        this.children.add(child);
    }

    public T getData() {
        return this.nodedata;
    }

    public void setData(T data) {
        this.nodedata = data;
    }

    public boolean isRoot() {
        return (this.parent == null);
    }

    public boolean isLeaf() {
        return this.children.size() == 0;
    }

    public void removeParent() {
        this.parent = null;
    }
}
