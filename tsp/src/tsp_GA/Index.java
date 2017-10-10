/*
 * 
 */
package tsp_GA;

/**
 *
 *
 */
public class Index {

    public static void main(String[] args) {

        for(int x = 0 ; x < 15; x++){ // To create our citys
            City city = new City(x);
            TourManager.addCity(city); 
        }

        // Initialize population
        //Due to the super-linear growth in convergence time,
        //it is generally infeasible to have population sizes large than
        //the dimensionality for d >= 100. For lower dimensional problems,
        //it is useful to have p > d to improve diversity.
        //For high dimensional problems, p ~= 0.5d seems to be the most effective. 

        Population pop = new Population(100, true);
        System.out.println("Melhor distância apartir da geração randômica: " + pop.getFittest().getDistance());

        // Evolve population for 1000 generations (D*10)
        pop = GeneticAlgorithm.evolvePopulation(pop);
        for (int i = 0; i < 1000; i++) {
            pop = GeneticAlgorithm.evolvePopulation(pop);
        }

        System.out.println("Melhor distância apartir da aplicação do Algoritmo Genérico: " + pop.getFittest().getDistance());
        System.out.println("Caminho da melhor distância:");
        System.out.println(pop.getFittest());
    }
}