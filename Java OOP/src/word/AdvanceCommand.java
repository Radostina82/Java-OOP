package word;

import java.util.ArrayList;
import java.util.List;

public class AdvanceCommand extends CommandImpl{
    public AdvanceCommand(StringBuilder text) {
        super(text);
    }
    @Override
    protected List<Command> initCommands() {
        List<Command> commands = new ArrayList<>();
        CutTransform cutTransform = new CutTransform();
        commands.add(new Command("cut", cutTransform));
        commands.add(new Command("paste", new PasteTransform(cutTransform)));

        return commands;
    }
}
