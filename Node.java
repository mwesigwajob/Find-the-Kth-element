/**
 *
 * @author jobmwesigwa
 * This class is for a node that is to keep track of the country name and the population as well.
 */

public class Node {
  public String countryName; //the country name
  public long population; //population of the country
  
  /**
   * @param name the name of the country
   * @param pop the population of the country
   * This is the contructor of the class node
   * */
  public Node(String name,long pop){
    countryName=name;
    population = pop;
  }

}