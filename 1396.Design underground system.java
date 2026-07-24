import java.util.*;

class UndergroundSystem {

    class CheckIn {
        String station;
        int time;

        CheckIn(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    class Route {
        int totalTime;
        int count;

        Route(int totalTime, int count) {
            this.totalTime = totalTime;
            this.count = count;
        }
    }

    HashMap<Integer, CheckIn> checkInMap;
    HashMap<String, Route> travelMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        travelMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckIn(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckIn data = checkInMap.get(id);

        String route = data.station + "-" + stationName;
        int travelTime = t - data.time;

        Route r = travelMap.getOrDefault(route, new Route(0, 0));
        r.totalTime += travelTime;
        r.count++;

        travelMap.put(route, r);
    }

    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "-" + endStation;
        Route r = travelMap.get(route);

        return (double) r.totalTime / r.count;
    }
}
