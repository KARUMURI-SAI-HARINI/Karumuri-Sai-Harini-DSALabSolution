package LabAssignment;

import java.util.ArrayList;
import java.util.List;

public class FindTheLongestPath {
	
	static class Node{
		int data;
		Node left,right;
		
		Node(int data){
			this.data=data;
			this.left = this.right=null;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(100);
		root.left= new Node(20);
		root.right=new Node(130);
		root.left.left = new Node(10);
		root.left.right = new Node(50);
		root.right.left= new Node(110);
		root.right.right= new Node(140);
		root.left.left.left = new Node(5);
		
		List<Integer> output =findLongestPath(root);
		System.out.print(output.get(output.size()-1));
		for(int i=output.size()-2;i>=0;i--) {
			System.out.print("->"+output.get(i));
		}
		//System.out.println(output);
	}
	
	private static List<Integer> findLongestPath(Node root){
		if(root==null) {
			return new ArrayList<Integer>();
		}
		
		List<Integer> leftPath =findLongestPath(root.left);
		List<Integer> rightPath =findLongestPath(root.right);
		
		if(rightPath.size()<leftPath.size()) {
			leftPath.add(root.data);
		}
		else {
			rightPath.add(root.data);
		}
		if(leftPath.size()>rightPath.size()) {
			return leftPath;
		}
		else {
			return rightPath;
		}
	}
}
