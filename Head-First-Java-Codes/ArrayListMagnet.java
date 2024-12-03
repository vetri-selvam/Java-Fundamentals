import java.util.ArrayList;

public class ArrayListMagnet{

    public static void printList(ArrayList<String> list){

        for (String element : list){

            System.out.print(element + " ");

        }
        System.out.println();

        
    }
    public static void main(String[] args) {


        // "a" refer to a new ArrayList Object that hold String objects
        ArrayList<String> a = new ArrayList<String>();

        // insert specific String elements (in other words, Objects) with specific positions
        a.add(0,"zero");
        a.add(1,"one");
        a.add(2,"two");
        a.add(3, "three");

        //call the static method printList
        printList(a);

        // if `a` refer to an ArrayList object that somewhere holds a String object/element "three", it goes inside
        if (a.contains("three")){
            // append at the end of the ArrayList
            a.add("four");        // inserted at the 4th index
        }
        printList(a);

        // remove the String object/element that is in index 2
        a.remove(2);

        // After one element removed, the arrayList will shrink, with change in index position by 1
        // for all the elements next to the removed elements.



        // if the index position of "four" is not equal to 4, it goes in
        if (a.indexOf("four") != 4){    // "four" is at index 3 after removal of one element at line 39. 3 != 4. goes in.
            a.add(4,"4.2"); // inserts "4.2" at index 4. 
         // a.add("4.2") also does same.
        }

        printList(a);

        if( a.contains("two")){
            a.add("2.2");
        }

        printList(a);
        
    }
}