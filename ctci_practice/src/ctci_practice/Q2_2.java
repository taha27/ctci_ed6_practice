package ctci_practice;

/**
 * Return Kth to Last: Implement an algorithm to find 
 * the kth to last element of a singly linked list.
 * @author Taha
 *
 */
public class Q2_2 {
	
	//O(N) time and O(1) space
	private static LinkedListNode kthToLast(LinkedListNode head, int k) {
		LinkedListNode lagging = head;
		LinkedListNode leading = head;
		
		//move leading forward by k steps
		for(int i = 0; i < k; i++) {
			if(leading == null) return null;
			leading = leading.next;
		}
		
		while(leading!=null) {
			leading = leading.next;
			lagging = lagging.next;
		}
		
		return lagging;
	}
	
	public static void main(String[] args) {
		int[] array = {0, 1, 2, 3};
		
		//create a linked list using values from the array defined above
		LinkedListNode head = new LinkedListNode(array[0], null, null);
        LinkedListNode current = head;
        for (int i = 1; i < array.length; i++) {
            current = new LinkedListNode(array[i], null, current);
        }
        
        //test the return kth to last node function with varying k values
		for (int i = 0; i <= array.length + 1; i++) {
			LinkedListNode node = kthToLast(head, i);
			String nodeValue = (node == null) ? "null" : String.valueOf(node.data);
			System.out.println(i + ": " + nodeValue);
		}
	}
}
