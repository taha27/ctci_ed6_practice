package ctci_practice;

public class Q2_6 {
  
    private static LinkedListNode reverse(LinkedListNode node) {
        if(node == null || node.next == null) return node;
      
        LinkedListNode head = null;
        
        //iterate through all values in the linked list
        while(node != null) {
            LinkedListNode n = new LinkedListNode(node.data);
            //assign the head node to the next pointer of node n
            n.next = head;
            //assign current node to head
            head = n;
            //move to the next node of the linked list
            node = node.next;
        }
        return head;
    }
    
    /* Note: This method could be made more efficient by comparing 
     * the first half of the list against the second half instead 
     * of making a copy and comparing all elements against each other
     */
	private static boolean isEqual(LinkedListNode headA, LinkedListNode headB) {
	    //iterate through the linked lists while they both have valid values
		while(headA != null && headB != null) {
		    //check if the corresponding nodes have the same values
			if(headA.data != headB.data) return false;
			headA = headA.next;
			headB = headB.next;
		}
		//check and return if both lists are now null
		return (headA == null && headB == null);
	}
	
	private static boolean isPalindrome(LinkedListNode head) {
	    //create a copy of the original linked list but in the opposite order
        LinkedListNode reversed = reverse(head);
        return isEqual(head, reversed);
    }
	
	public static void main(String[] args) {
		int length = 9;
		//create a palindromic linked list
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
        //set the head of the linked list
		LinkedListNode head = nodes[0];
		//print the linked list
		System.out.println(head.printForward());
		//check if the linked list is palindromic
		System.out.println(isPalindrome(head));
		
		//change a linked list node value so that it is no longer palindromic
		nodes[0].data = 5;
		//check if the linked list is palindromic
        System.out.println(isPalindrome(head));
	}

}
