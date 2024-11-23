class Dog {
    private int Age = 100;
    private String Name;

    void setName(String dogName) {
        Name = dogName;
    }

    String getName() {
        return Name;
    }

    void setAge(int dogAge) {
        Age = dogAge;
    }

    int getAge() {
        return Age;
    }
}

public class ObjInArray {
    public static void main(String[] args) {
        Dog[] d1 = new Dog[4];

        d1[0] = new Dog();
        d1[1] = new Dog();

        d1[0].setAge(1);
        d1[1].setAge(5);

        System.out.println(d1[0].getAge() + " and " + d1[1].getAge());

    }
}
