/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package median.population;

import java.util.Arrays;

/**
 *
 * @author jobmwesigwa
 * The class does the partitioning and then uses quick select to find the item
 */
public class Partitioning {
  
  Node temp;// for swapping
  int l=0, r; //l for left boundary and r fro the right boundary
  int s; // end of less than portion 
  long p =0; //the pivot 
  int counter = 0; //Keeps track of the rounds 
  /*
   * @param items the array contating the items 
   * @param k the position to be found 
   * @return the midean.
   * */
  
  public Node QuickSelect(Node[] items,int k){
    
    System.out.println("\n\n \t\t\t******* ROUND " + (counter+1) + " *******\n");
    System.out.println("Before partitioning the Data  \n");
    counter ++;
    
    //Displaying the unpartitioned items in the array
    for (int i=0;i<items.length; i++)
      System.out.print(items [i].population + " | ");
    
    p = items[l].population;
    s = 0; //last index of the less than partition 
    r = items.length-1;
    
    //Going through the array to move all the items less than the pivot to the left 
    //and  those greater than the pivot to the right
    for (int i = l+1;i<=r;i++){
      if (items[i].population<p)
      {
        s = s+1;
        
        //swapping the min into the less than partition
        temp = items[i];
        items[i]=items[s];
        items[s] =temp;
      }
    }
    
    //swapping the pivot with the last least items 
    temp = items[l];
    items[l]=items[s];
    items[s]=temp;
    
    System.out.println("\n\nAfter partitioning and our pivot is  " + items[s].population+"\n");
    
    //The partitioned array of items
    for (int i=0;i<items.length; i++)
        System.out.print(items [i].population + " | ");
    
    //base case, when the pivot is the required item 
    if (s == k-1)
      return items[s];
    
    //When the required position is less than the position of the pivot
    else if (s>(k-1))
      return QuickSelect(Arrays.copyOfRange(items, l, s),k);
    
    //When the required position is greater than the position of the pivot
    else
      return QuickSelect(Arrays.copyOfRange(items, s+1, r+1),k-1-s);
  }
}
