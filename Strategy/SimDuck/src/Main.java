import Interfaces.quackBehaviours.NormalQuack;

public class Main {
    public static void main(String[] args){
        Duck mallardDuck = new MallardDuck();
        mallardDuck.doQuackBehaviour();
        mallardDuck.setQuackBehaviour(new NormalQuack());
//        mallardDuck.doQuackBehaviour();
        mallardDuck.quackBehaviour.quack();
        mallardDuck.display();
    }
}