class Box{
    private String boxName;
    private int size;

    public String getBoxName() {
        return boxName;
    }
    public void setBoxName(String boxNameArg) {
        boxName = boxNameArg;   // didn't use this.boxName for simplicity and correspond with the topics I've read so far in the book.
    }

    public int getSize() {
        return size;
    }
    public void setSize(int sizeArg) {
        size = sizeArg;
    }

}


public class equalsMethodTestDrive {
    public static void main(String[] args) {
        // create two  box objects with two references b1 and b2
        Box b1 = new Box();
        Box b2 = new Box();

        // setting both box objects name as same
        b1.setBoxName("PencilBox");
        b2.setBoxName("PencilBox");
        b1.setSize(0);
        b2.setSize(6);

        System.out.println(b1.getBoxName().equals(b2.getBoxName()));   
        
        // Note: cannot use .equals on primitive type.
        // For Instance
        // System.out.println(b1.getSize().equals(b2.getSize()));

        
    }    
}
