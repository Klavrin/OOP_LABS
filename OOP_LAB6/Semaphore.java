import java.util.List;

class Semaphore {
    private CarStation gasStation;
    private CarStation electricStation;

    public Semaphore(CarStation gasStation, CarStation electricStation) {
        this.gasStation = gasStation;
        this.electricStation = electricStation;
    }

    public void serveCar(String carJson) {
        String type = parseType(carJson);

        if (type.equalsIgnoreCase("gas")) gasStation.serve(parseId(carJson));
        else if (type.equalsIgnoreCase("electric")) electricStation.serve(parseId(carJson));
    }

    private String parseType(String json) {
        // very simple JSON parsing
        return json.split("\"type\":\"")[1].split("\"")[0];
    }

    private String parseId(String json) {
        return json.split("\"id\":\"")[1].split("\"")[0];
    }
}
