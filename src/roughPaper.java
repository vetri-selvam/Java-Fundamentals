class Animal {

    public void run(){
        System.out.println("ANimal Running");
    }
}

class Dog extends Animal{
    @Override
    public void run(){
        System.out.println("Dog Running");
    }
}

class roughPaper{
    public static void main(String[] args) {
        Animal obj = new Dog();

        obj.run();
    }
}