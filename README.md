# Find-the-Kth-element
Using Lomuto and Quick Select to find the median

	My solution is implemented with 3 classes;
	The Node class defines the type of data to be stored in an array which is node containing the name and population of a country
	The Partitioning class implements both Lumotu’s partitioning and Quick Select. This involves getting a value to consider as a pivot and then partition the array in a way that has all items less than the pivot on the left of the pivot and those greater than on the right. Then use Quick Select to recursively find the median from either the left partition of the right partition depending on the position of the median
	The MedianPopulation class is the main. It reads information from a file and stores the name and the population in a node which it then stores in an array of country nodes. It then calls the QuickSelect method of Partitioning class with the median value which is 27th item.

 Efficiency analysis 
	For partition, the main operation is comparison. In the array of n elements which is 53 for my case, there are n-1 comparisons (52).
	If after partitioning, if the median or any other position I am seeking is the pivot, then I just return the pivot as my answer which only happens in ϴ(n). This is my best case. This is also the case for the average case.
	For the worst case, this can be experienced when this algorithm is used to find the greatest population (53rd population) and the population is arranged in ascending order. Since all elements will be on the right side of the pivot for each stage, the problem reduces by one. Which is from n-1 (52) till we have just one element. This leads to the equation below,
(n-1)n/2
			Which is a ϴ(n^2 )
