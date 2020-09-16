import java.util.Scanner;

class List
{

    Node head;  // head of list

    /* Linked list Node*/
    static class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }

    Node reverse(Node head, int k)
    {
        Node current = head;
        Node next = null;
        Node prev = null;

        int count = 0;

        while (count < k && current != null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        if (next != null)
            head.next = reverse(next, k);


        return prev;
    }


    public void push(int new_data)
    {

        Node new_node = new Node(new_data);

        new_node.next = head;

        head = new_node;
//        tt=head;
    }

    void printList()
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    /* Driver program to test above functions */
    public static void main(String[] args)
    {
        List llist = new List();
        Scanner x=new Scanner(System.in);
        int n=x.nextInt();
        for(int i=0;i<n;i++)
        {
            llist.push(x.nextInt());
        }
        System.out.println("Enter k ");
        int k=x.nextInt();
        System.out.println("Given Linked List");
        llist.printList();


        llist.head = llist.reverse(llist.head, k);

        System.out.println("Reversed list");
        llist.printList();
    }
}