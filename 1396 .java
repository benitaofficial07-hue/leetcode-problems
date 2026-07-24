import java.util.*;

class UndergroundSystem {

    // Stores passenger check-in information
    private Map<Integer, CheckIn> checkInMap;

    // Stores total travel time and trip count for each route
    private Map<String, RouteData> routeMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        routeMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckIn(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckIn checkIn = checkInMap.remove(id);

        String route = checkIn.station + "->" + stationName;
        int travelTime = t - checkIn.time;

        RouteData data = routeMap.getOrDefault(route, new RouteData());
        data.totalTime += travelTime;
        data.tripCount++;
        routeMap.put(route, data);
    }

    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "->" + endStation;
        RouteData data = routeMap.get(route);
        return (double) data.totalTime / data.tripCount;
    }

    // Helper class for check-in information
    static class CheckIn {
        String station;
        int time;

        CheckIn(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    // Helper class for route statistics
    static class RouteData {
        int totalTime = 0;
        int tripCount = 0;
    }
}
