package ctci_practice;

/**
 * Delete Middle Node: Implement an algorithm to delete a 
 * node in the middle (i.e., any node but the first and 
 * last node, not necessarily the exact middle) of a singly 
 * linked list, given only access to that node.
 * @author Taha
 *
 */
public class Q2_3 {
	
	/* Note: this problem cannot be solved if the 
	 * node to be deleted is the last node in the LL.
	 * Consider marking it as a dummy (using special val)
	 */
	
	private static void deleteMiddleNode(LinkedListNode node) {
	    //check if the node is null or the last node
		if(node == null || node.next == null) {
			return;
		}
		
		//set this node's value to that of the next node
		node.data = node.next.data;
		//set this node's next pointer value to that of the next node's
		node.next = node.next.next;
	}
	
	public static void main(String[] args) {
  	    int[] array = {0, 1, 2, 3, 4, 5, 6};
        
        //create a linked list using values from the array defined above
        LinkedListNode head = new LinkedListNode(array[0], null, null);
        LinkedListNode current = head;
        for (int i = 1; i < array.length; i++) {
            current = new LinkedListNode(array[i], null, current);
        }
        //print the linked list
		System.out.println(head.printForward());
		
		//delete the third node
		deleteMiddleNode(head.next.next);
		
		//print the linked list
		System.out.println(head.printForward());
	}
}
