class Animal {
    public int weight =10;
    public void printWeight(){
        System.out.println("Animal Running");
    }
}

class Dog extends Animal{
    
    @Override
    public void printWeight(){
        System.out.println(weight);
    }
}

class SubInheriSuper{
    public static void main(String[] args) {
        Animal obj = new Dog(); 
        // when dog object created, Animal object also created and Animal's instance variables are created for the access of subclass object. Eg: weight.
        System.out.println(obj.weight);
        obj.printWeight();
    }
}