package Interfaces.quackBehaviours;

import Interfaces.QuackBehaviour;

public class NoQuack implements QuackBehaviour {
    public void quack(){
        System.out.println("I don't quack!");
    }
}
