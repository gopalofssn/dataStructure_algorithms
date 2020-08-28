package FaceBook;

import java.util.ArrayList;
import java.util.List;

import com.self.gs.trees.SerializeandDeserializeBinaryTree297;
import com.self.gs.trees.TreeNode;

public class BSTIterator {
	List<Integer> sortedList = new ArrayList<Integer>();
	int index = 0;

	public BSTIterator(TreeNode root) {
		buildSortedList(root);
	}

	private void buildSortedList(TreeNode node) {
		if (node == null) {
			return;
		}
		buildSortedList(node.left);
		sortedList.add(node.val);
		buildSortedList(node.right);
	}

	/** @return the next smallest number */
	public int next() {
		return sortedList.get(index++);
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return index < sortedList.size();
	}
	
	public static void main(String}] args) {
		String str = "1,2,X,X"; //"1,2,3";//
		TreeNode root = SerializeandDeserializeBinaryTree297.deserialize(str);
		BSTIterator obj = new BSTIterator(root);
	    int param_1 = obj.next();
		boolean param_2 = obj.hasNext();
		System.err.println(param_1);
		System.err.println(param_2);
	}
}
