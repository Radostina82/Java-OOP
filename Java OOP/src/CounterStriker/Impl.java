package CounterStriker;

import CounterStriker.common.ExceptionMessages;

public class Impl extends ExceptionMessages {
    private String name;
    private int bulletsCount;

    private void setName(String name) {
        this.name = name;
    }
}
