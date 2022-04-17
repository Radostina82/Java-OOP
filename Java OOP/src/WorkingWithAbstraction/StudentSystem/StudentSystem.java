package WorkingWithAbstraction.StudentSystem;

import Input.Reader;

public class StudentSystem {
    private final CommandHandler handler;
    private boolean isWorking;


    public StudentSystem() {
        this.handler = new CommandHandler();
    }

    public void start() {
        this.isWorking = true;
        while (isWorking) {
            String result = handler.handleCommand(Reader.readStringArray("\\s+"));
            if (result!= null && !result.equals("Exit")){
                System.out.println(result);
            }
            isWorking= !"Exit".equals(result);
        }
    }
}