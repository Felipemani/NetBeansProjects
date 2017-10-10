/*
 * Our population class
 */
package tsp_GA;

/**
 *
 *
 */
public class Population {

    Tour[] tours;

    public Population(int populationSize, boolean initialise) {
        tours = new Tour[populationSize];
        
        if (initialise) { // To generate our initial tours population
            for (int i = 0; i < populationSize(); i++) {
                
                Tour newTour = new Tour();
                newTour.generateIndividual(); //call the function to generate
                saveTour(i, newTour);
            }
        }
    }
    
    public void saveTour(int index, Tour tour) {
        tours[index] = tour;
    }
    
    public Tour getTour(int index) {
        return tours[index];
    }

    // Gets the best tour in the population
    public Tour getFittest() {
        Tour fittest = tours[0];
        // Loop through individuals to find fittest
        for (int i = 1; i < populationSize(); i++) {
            if (fittest.getFitness() <= getTour(i).getFitness()) {
                fittest = getTour(i);
            }
        }
        return fittest;
    }

    public int populationSize() {
        return tours.length;
    }
}