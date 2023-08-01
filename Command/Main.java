import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Command Interface
interface Command {
    void execute();
    void undo();
}

// ConcreteCommand for turning the light on
class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOn();
    }

    public void undo() {
        light.turnOff();
    }
}

// ConcreteCommand for turning the light off
class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOff();
    }

    public void undo() {
        light.turnOn();
    }
}

// Receiver
class Light {
    private String name;

    public Light(String name) {
        this.name = name;
    }

    public void turnOn() {
        System.out.println(name + " Light is ON");
    }

    public void turnOff() {
        System.out.println(name + " Light is OFF");
    }
}

// Invoker
class RemoteControl {
    private List<Command> onCommands;
    private List<Command> offCommands;
    private Stack<Command> undoStack;
    private Stack<Command> redoStack;

    public RemoteControl() {
        onCommands = new ArrayList<>();
        offCommands = new ArrayList<>();
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands.add(slot, onCommand);
        offCommands.add(slot, offCommand);
    }

    public void pressOnButton(int slot) {
        onCommands.get(slot).execute();
        undoStack.push(onCommands.get(slot));
    }

    public void pressOffButton(int slot) {
        offCommands.get(slot).execute();
        undoStack.push(offCommands.get(slot));
    }

    public void pressUndoButton() {
        if (!undoStack.isEmpty()) {
            Command commandToUndo = undoStack.pop();
            commandToUndo.undo();
            redoStack.push(commandToUndo);
        }
    }

    public void pressRedoButton() {
        if (!redoStack.isEmpty()) {
            Command commandToRedo = redoStack.pop();
            commandToRedo.execute();
            undoStack.push(commandToRedo);
        }
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        Light livingRoomLight = new Light("Living Room");

        Command livingRoomLightOn = new LightOnCommand(livingRoomLight);
        Command livingRoomLightOff = new LightOffCommand(livingRoomLight);

        RemoteControl remote = new RemoteControl();
        remote.setCommand(0, livingRoomLightOn, livingRoomLightOff);

        remote.pressOnButton(0); // Turns the living room light on
        remote.pressUndoButton(); // Undoes the previous command (turns the living room light off)
        remote.pressRedoButton(); // Redoes the previous command (turns the living room light on)
    }
}

