/*
 * City class
 */
package tsp_GA;

/**
 *
 *
 */
public class City {
    int x;

    public City(int x){
        this.x = x;
    }

    public int getLocation(){
        return this.x;
    }

    @Override
    public String toString(){
        return String.valueOf(getLocation());
    }
}