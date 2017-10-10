/*
 */
package tsp_GA;

/**
 *
 *
 */
import java.util.ArrayList;
import java.util.Collections;

public class Tour{

    private ArrayList tour = new ArrayList<City>();
    private double fitness = 0;
    private int distance = 0;
    
    // Constructs a blank tour
    public Tour(){
        for (int i = 0; i < TourManager.numberOfCities(); i++) {
            tour.add(null);
        }
    }
    
    public Tour(ArrayList tour){
        this.tour = tour;
    }

    // Creates a random individual
    public void generateIndividual() {
        for (int cityIndex = 0; cityIndex < TourManager.numberOfCities(); cityIndex++) {
          setCity(cityIndex, TourManager.getCity(cityIndex)); // set cities in one tour
        }
        Collections.shuffle(tour); // Randomly reorder the tour
    }

    public City getCity(int tourPosition) {
        return (City)tour.get(tourPosition);
    }

    // Sets a city in a certain position within a tour
    public void setCity(int tourPosition, City city) {
        tour.set(tourPosition, city);
        // If the tours been altered we need to reset the fitness and distance
        fitness = 0;
        distance = 0;
    }
    
    // Gets the tours fitness
    public double getFitness() {
        if (fitness == 0) {
            fitness = 1/(double)getDistance();
        }
        return fitness;
    }
    
    // Gets the total distance of the tour selected tour
    public int getDistance(){
        if (distance == 0) {
            int tourDistance = 0;
            for (int cityIndex=0; cityIndex < tourSize(); cityIndex++) {
                City fromCity = getCity(cityIndex);
                City destinationCity;
                
                if(cityIndex+1 < tourSize()){ // Check if it isnt our tour's last city
                    destinationCity = getCity(cityIndex+1);  //if it is set our tour's final destination city to our starting city
                }
                else{
                    destinationCity = getCity(0);
                }
                tourDistance += CitiesDistance.getValue(fromCity.getLocation(), destinationCity.getLocation());
            }
            distance = tourDistance;
        }
        return distance;
    }

    public int tourSize() {
        return tour.size();
    }
    
    public boolean containsCity(City city){
        return tour.contains(city);
    }
    
    @Override
    public String toString() {
        String geneString = "";
        for (int i = 0; i < tourSize(); i++) {
            geneString += 1 + getCity(i).getLocation()+"-";
        }
        return geneString;
    }
}