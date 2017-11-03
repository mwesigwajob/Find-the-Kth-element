/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package median.population;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
/**
 *
 * @author jobmwesigwa
 */
public class MedianPopulation {

    /**
     * @param args the command line arguments
     */

    //reading from the CSV file 
    public static void main(String[] args) {
        Node medianCountry;
        Partitioning pat = new Partitioning();
        long pop; //the population
        Node[] poptns = new Node[53]; //array to store all populations 
        int index=0; //counter to mark the line read and index of the population array

        String currentLine, name; //line read in and the name of the country
        String[] line; //array of the items in the line read in
        int median =0;
    
    
         try (BufferedReader myString = new BufferedReader(new InputStreamReader(new FileInputStream("country_data.csv"))))
      {  
        while ((currentLine = myString.readLine())!=null)
        {
          //spliting the line into an array  
          line = currentLine.split(",");

            if (index>0){
                //converting text to values
                pop=Long.parseLong(line[1]);
                name=line[0];
                Node country = new Node(name,pop);
                poptns[index-1]=country;
            }
            index++;
        }
        myString.close();

      }
      //catching any excemtions
      catch (Exception e){
        System.out.println("Error -Other Exception "+e.toString());
      }
         
      median = ((poptns.length/2) +1);
      medianCountry = (pat.QuickSelect(poptns, median));
      System.out.println("\n\n\t\t*******The country in the middle is  "+medianCountry.countryName+ ", with a population of "+medianCountry.population+" *******");

    }

}
