interface Animal {

    abstract public void run();

    public static void jog(){
        System.out.println("jogging");
    }
}

class Canine {
    public void eat(){
        System.out.println("EATING");
    }
}

class Dog extends Canine implements Animal{
    @Override
    public void run(){
        System.out.println("Dog Running");
    }
}

class roughPaper{
    public static void main(String[] args) {
        Canine obj = new Dog();
        

        ((Animal)obj).run();  // how can I overcome this error obj.run(); ?
        Animal.jog();
        obj.eat();

        
    }
}