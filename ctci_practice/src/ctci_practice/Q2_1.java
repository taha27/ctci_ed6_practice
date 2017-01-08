package ctci_practice;

import java.util.*;
/**
 * Code to remove duplicates from an unsorted linked list.
 * @author Taha
 *
 */
public class Q2_1 {
	
	//O(1) time, O(X) space where X is the number of unique nodes
	private static void deleteDups(LinkedListNode n) {
		Set<Integer> uniqueNodeVals = new HashSet<Integer>();
		
		if(n == null || n.next == null) return;
		
		LinkedListNode previous = n;
		while(n != null) {
			int nodeData = n.data;
			if(uniqueNodeVals.contains(nodeData)) {
				previous.next = n.next;
			} else {
				uniqueNodeVals.add(nodeData);
				previous = n;
			}
			n=n.next;
		}
	}
	
	// O(1) space but O(N^2) time
	private static void deleteDupsNoBuffer(LinkedListNode n) {
		LinkedListNode current = n;
		while(current != null) {
			LinkedListNode runner = current;
			
			//iterate following nodes to find dupes of current
			while(runner.next != null) {
				if(runner.next.data == current.data) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			
			current = current.next;
		}
	}
	
	public static void main(String[] args) {
		LinkedListNode first = new LinkedListNode(0, null, null); //AssortedMethods.randomLinkedList(1000, 0, 2);
		LinkedListNode head = first;
		LinkedListNode second = first;
		for (int i = 1; i < 8; i++) {
			second = new LinkedListNode(i % 3, null, null);
			first.setNext(second);
			second.setPrevious(first);
			first = second;
		}
		first.setNext(null);
		System.out.println(head.printForward());
		deleteDups(head);
		System.out.println(head.printForward());
	}

}
