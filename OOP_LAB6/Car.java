public class Car {
    private int id;
    private CarType type;
    private PassengerType passengers;
    private boolean isDining;
    private int consumption;

    public Car(int id, CarType type, PassengerType passengers, boolean isDining, int consumption) {
        this.id = id;
        this.type = type;
        this.passengers = passengers;
        this.isDining = isDining;
        this.consumption = consumption;
    }

    public int getId() { return id; }
    public CarType getType() { return type; }
    public PassengerType getPassengers() { return passengers; }
    public boolean isDining() { return isDining; }
    public int getConsumption() { return consumption; }

    public void setId(int id) { this.id = id; }
    public void setType(CarType type) { this.type = type; }
    public void setPassengers(PassengerType passengers) { this.passengers = passengers; }
    public void setDining(boolean dining) { isDining = dining; }
    public void setConsumption(int consumption) { this.consumption = consumption; }
}
