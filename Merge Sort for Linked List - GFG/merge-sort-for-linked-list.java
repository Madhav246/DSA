//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new Solution().mergeSort(head);
		     printList(head);
		    System.out.println();
        }
    }
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}



// } Driver Code Ends

class Solution {
public Node mergeSort(Node head) {
    if (head == null || head.next == null) return head;

    Node fast = head;
    Node slow = head;
    
    // Find the mid-point of the list
    while (fast.next != null && fast.next.next != null) { // iterate at least once
        slow = slow.next;
        fast = fast.next.next;
    }

    // Split the list
    Node second = slow.next;
    slow.next = null;
    
    // Sort each half
    head = mergeSort(head);
    second = mergeSort(second);
    
    // Merge
    return merge(head, second);
}

private Node merge(Node first, Node second) {
    Node result = new Node(0);
    Node head = result;
    
    while (first != null && second != null) {
        if (first.data < second.data) {
            result.next = first;
            first = first.next; // move forward
        } else {
            result.next = second;
            second = second.next;
        }            
        result = result.next;
    }
    if (first != null) {
        result.next = first;
        result = result.next;
    }
    if (second != null) {
        result.next = second;
        result = result.next;
    }
    return head.next;
 }
}