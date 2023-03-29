public class LinkedList {
  Node head; 
  static class Node {
    SpiceMix data;
    Node next;

    Node(SpiceMix d)
    {
      data = d;
      next = null;
    }
  }
  
  public static LinkedList insert(LinkedList list, SpiceMix data)
  {
    Node new_node = new Node(data);
    new_node.next = null;

    if (list.head == null) {
      list.head = new_node;
    }
    else {
        Node last = list.head;
        while (last.next != null) {
          last = last.next;
        }
      last.next = new_node;
    }
    return list;
  }
  
  Node reverse(Node node)
  {
    Node prev = null;
    Node current = node;
    Node next = null;
    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    node = prev;
    return node;
  }
  
  public String printList(LinkedList list)
  {
    head = list.reverse(head);
    String list1 = "";
    Node currNode = list.head;
    while (currNode != null) {
      list1 = list1 + currNode.data.toString();
      list1 += "\n";
      currNode = currNode.next;
    }
    return list1;
  }
}
