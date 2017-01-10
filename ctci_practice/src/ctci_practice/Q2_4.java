package ctci_practice;

/**
 * Partition: Write code to partition a linked list around a value 
 * x, such that all nodes less than x come before all nodes greater 
 * than or equal to x. If x is contained within the list the values 
 * of x only need to be after the elements less than x (see below). 
 * The partition element x can appear anywhere in the "right partition"; 
 * it does not need to appear between the left and right partitions.
 * @author Taha
 *
 */
public class Q2_4 {

	public static LinkedListNode partition(LinkedListNode node, int x) {
		LinkedListNode head = node;
		LinkedListNode tail = node;
		
		//iterate through all the nodes in the linked list
		while (node != null) {
			LinkedListNode next = node.next;
			
			//Insert node at head of linked list if its value is lower
			if (node.data < x) {
				node.next = head;
				head = node;
			//Insert node at tail of linked list if its value is equal or higher
			} else {
				tail.next = node;
				tail = node;
			}	
			node = next;
		}
		tail.next = null;
		
		return head;
	}
	
	public static void main(String[] args) {
		int length = 20;
		
		//create a linked list
		LinkedListNode[] nodes = new LinkedListNode[length];
		
		//assign the linked list node values
		for (int i = 0; i < length/2; i++) {
			nodes[i] = new LinkedListNode(i, null, null);
		}
		for (int i = length/2; i < length; i++) {
          nodes[i] = new LinkedListNode(length - i - 1, null, null);
        }
		
		//set the linked list node pointers correctly
		for (int i = 0; i < length - 1; i++) {
			nodes[i].setNext(nodes[i + 1]);
		}
		
		//print the created linked list
		LinkedListNode head = nodes[0];
		System.out.println(head.printForward());
		
		//partition and then print the linked list
		LinkedListNode h = partition(head, 4);
		System.out.println(h.printForward());
	}

}
