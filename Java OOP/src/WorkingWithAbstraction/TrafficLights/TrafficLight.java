package WorkingWithAbstraction.TrafficLights;



public class TrafficLight {
    private Light light;

    public TrafficLight(Light light) {
        this.light = light;
    }

    public void changeColor() {
        if (this.light == Light.RED) {
            this.light = Light.GREEN;
        } else if (this.light == Light.GREEN) {
            this.light = Light.YELLOW;
        } else if (this.light == Light.YELLOW) {
            this.light = Light.RED;
        }
    }

    public Light getColor() {
        return light;
    }
}
