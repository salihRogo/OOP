package Week13.Lab.Task5;

interface TrafficLightState {
    void transitionToRed();
    void transitionToGreen();
    void transitionToYellow();
}

class RedLightState implements TrafficLightState {
    public void transitionToRed() {
        System.out.println("The light is already red");
    }
    public void transitionToGreen() {
        System.out.println("The light is now green");
    }
    public void transitionToYellow() {
        System.out.println("The light is now yellow");
    }
}

class YellowLightState implements TrafficLightState {
    public void transitionToRed() {
        System.out.println("The light is now red");
    }
    public void transitionToGreen() {
        System.out.println("The light is now green");
    }
    public void transitionToYellow() {
        System.out.println("The light is already yellow");
    }
}

class GreenLightState implements TrafficLightState {
    public void transitionToRed() {
        System.out.println("The light is now red");
    }
    public void transitionToGreen() {
        System.out.println("The light is already green");
    }
    public void transitionToYellow() {
        System.out.println("The light is now yellow");
    }
}

class TrafficLightContext {
    private TrafficLightState state;

    public TrafficLightContext(TrafficLightState state) {
        this.state = state;
    }

    public TrafficLightState getState() {
        return state;
    }

    public void setState(TrafficLightState state) {
        this.state = state;
    }

    public void transitionToRed() {
        this.state.transitionToRed();
    }
    public void transitionToGreen() {
        this.state.transitionToGreen();
    }
    public void transitionToYellow() {
        this.state.transitionToYellow();
    }
}

class TrafficLightController {
    public static void main(String[] args) {
        TrafficLightContext context = new TrafficLightContext(new RedLightState());
        context.transitionToRed();

    }
}
