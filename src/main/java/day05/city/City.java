package day05.city;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class City {
    private String name;
    private long fullArea;
    private List<Building> buildings = new ArrayList<>();

    public City(String name, long fullArea) {
        this.name = name;
        this.fullArea = fullArea;
    }

    public void addBuilding(Building building) {
        if (building.getArea() > fullArea-getCityArea()) {
            throw new IllegalArgumentException("City can't be larger than " + fullArea);
        }
        buildings.add(building);
    }

    public Building findHighestBuilding() {
//        if (buildings.size() > 0) {
//            Building highestBuilding = buildings.get(0);
//            for (Building building : buildings) {
//                if (building.getLevels() > highestBuilding.getLevels()) {
//                    highestBuilding = building;
//                }
//            }
//            return highestBuilding;
//        }
//        throw new IllegalStateException("There is no building in this town yet");

        return buildings.stream().max(Comparator.comparing(o -> o.getLevels())).orElseThrow(() -> new IllegalArgumentException("There is no building in this town yet"));
    }

    public List<Building> findBuildingsByStreet(String street) {
        List<Building> result = new ArrayList<>();
//        for (Building building : buildings) {
//            if (building.getAddress().getStreet().equals(street)) {
//                result.add(building);
//            }
//        }
//        return result;

        return buildings.stream().filter(o -> o.getAddress().getStreet().equals(street)).collect(Collectors.toList());
    }

    public boolean isThereBuildingWithMorePeopleThan(int numberOfPeople) {
//        for (Building building : buildings) {
//            if (building.calculateNumberOfPeopleCanFit()>numberOfPeople) {
//                return true;
//            }
//        }
//        return false;

        return buildings.stream().anyMatch(o -> o.calculateNumberOfPeopleCanFit()>numberOfPeople);
    }

    private long getCityArea() {
        long result = 0;
        for (Building building : buildings) {
            result += building.getArea();
        }
        return result;
    }
    public String getName() {
        return name;
    }

    public long getFullArea() {
        return fullArea;
    }

    public List<Building> getBuildings() {
        return buildings;
    }
}
