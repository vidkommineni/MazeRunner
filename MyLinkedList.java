
import java.util.LinkedList;
import java.util.*;
public class MyLinkedList<T>
{
    private ListNode head;
    private ListNode tail;
    private int size;
    public MyLinkedList()
    {
        head = null;
    }

    //I think this might have an error
    public MyLinkedList(T... vals){
        head = new ListNode (vals[0]);
        ListNode current = head.next;
        for(int i = 1; i < vals.length; i++){
            if(i == vals.length-1){
                tail = new ListNode(vals[i]);   
            }
            else{
             current = new ListNode(vals[i]);
             current = current.next;
             
            }
        }
    }

    public MyLinkedList(T val)
    {
        head = new ListNode (val);
        tail = new ListNode(val);
    }

    private class ListNode
    {
        T val;
        ListNode next;

        public ListNode(T val) {this.val = val;}
        
        //check if necessary. Only added it bc it was on the example
        public T getValue() { return this.val;}

        @Override
        public String toString() {
            return "" + this.val;
        }
    }

    //3
    public void add(T newVal)
    {
        if(head == null)
        {
            head = new ListNode(newVal);   
            tail = head;

        }
        else{
            /*ListNode current = head;
            ListNode temp = new ListNode(newVal);
            while(current.next != null)
            {
            current = current.next;
            }
            current.next = temp;
            //head = temp;
            //System.out.println(current);
             */
            //ListNode current = tail.next;
            ListNode temp = new ListNode(newVal);
            //current = temp;

            tail.next = temp;
            tail = tail.next;
        }
        size++;
    }

    //4
    public boolean contains(T target){
        //boolean isThere = false;
        ListNode current = head;

        while(current != null){
            if(target == current.val)
            {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    //5
    public T get(int index){
        ListNode current = head;
        int length = 0;
        int indexVal = 0;
        while(current != null)
        {
            if(length == index){
                return current.val;   
            }
            else{
                current = current.next;
                length++;
            }

        }

        throw new IndexOutOfBoundsException() ;
    }

    //6
    public int indexOf(T target){
        ListNode current = head;
        int length = 0;
        int indexVal = 0;
        while(current != null)
        {
            if(current.val == target){
                return length;   
            }
            else{
                current = current.next;
                length++;
            }
        }

        return -1;
    }

    //7
    //The Dew

    //8
    public void set(T newVal, int index){
        ListNode current = head;
        int length = 0;

        while(current != null){
            if(length == index)
            {
                current.val = newVal;   
                current = current.next;
                break;
            }

            else{
                current = current.next;
                length++;
            }
        }

    }

    //9 Check again
    public int size(){
        /*
        ListNode current = head;
        int size = 0;

        while(current != null){
        size++;
        current = current.next;
        }
         */
        return size;
    }

    //9a
    public int sizeRecursive(ListNode current){
        if(current == null){
            return 0;
        }
        else{
            return 1 + sizeRecursive(current.next);

        }
    }

    //10 check!!
    public boolean isEmpty(){
        ListNode current = head;
        return current == null;
    }

    //11 Check this too
    public T remove(int index){
        ListNode current = head;
        int length = 0;
        T removed = null;
        while(current != null){

            //current = current.next;
            if(index == 0)
            {

                removed = head.val;
                //current = (current.next).next;
                head = head.next;
                size--;
                return removed;

            }
            else if (length == index -1){
                removed = current.next.val;
                current.next = current.next.next;
                size--;
                return removed;
            }
            current = current.next;
            length++;
        }

        return removed;
    }

    //12
    public void add(T newVal, int index){
        ListNode current = head;
        int length = 0;
        while(current != null){

            if(length == index){
                current.val = newVal;
                current = current.next;
                size++;
                tail = tail.next;
                size++;
                break;
            }
            else{
                length ++;
                current = current.next;
            }
        }
    }

    public String toString()
    {
        if(head == null){
            return "[]";   
        }

        else {
            ListNode current = head;
            String print = "[";

            while(current != null)
            {
                print += current;
                if (current.next != null) {
                    print += ", ";
                }
                current = current.next;
            }
            print += "]";

            return print;
        }

    }
}