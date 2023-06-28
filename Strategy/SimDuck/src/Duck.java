import Interfaces.QuackBehaviour;
import Interfaces.quackBehaviours.NoQuack;

public abstract class Duck {
    QuackBehaviour quackBehaviour;
    public Duck(){
        this.quackBehaviour = new NoQuack();
    }
    public void setQuackBehaviour(QuackBehaviour qb){
        this.quackBehaviour = qb;
    }
    public void doQuackBehaviour(){
        quackBehaviour.quack();
    }
    abstract void display();
}
