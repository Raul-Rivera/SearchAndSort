/*
Name: Raul J. Rivera Ortiz
Course: CSC 122 001
Project #5
Project description:
		This is a great program than create a new file whith the name of the user, then ask for the size 
		of the array than will be created. Then create an unsorted array whith random numbers between 0 and 22.
		(I made the range 23 because is better for the user see the results, but the range can be change to
		any hight number. I am going to do it after show evidence, I will increace the range to 100.) Then, check 
		the array and start to sorted value to value. Then print the unsorted and sorted array,   
		(I did that for improve the vision of the arrays). Then print 4 random numbers
		between 0 and 22 (I can change that too), to compare with all values of the unsorted and sorted array.
		Then, print a messsage each time to show the numbers of serches in each array. At the end show how many 
		serches in total and the average of serches for both arrays. 
		NOTE: The resuls will be display in de comand prompt and in the new file created with the name of the user.
Purpose:
	1. Become familiar manipulating a file.
	2. Become familiar with exceptions in the code to throw a failure.   
	3. Become familiar with arrays.
	4. Become familiar sorting arrays.
	5. Entertain the user.
	
What the program does?:  

	The program ask for the name of user.
	Save the name of the user in the variable 'name'.
	Convert the username to a text document and assign it to another variable.
	
	Create a new instance in memory of the File class.
		If the File is new, will be created.
		Else print File Already exist.
		
	Provides method to write string directly to the file.
	Implements all of the print methods found in PrintStream .
	
	Creates a PrintStream which is connected to an file.
	Ask for the size of the array.
	Creating an array with name array.
	
	Loop for create a the array with random numbers.
	Create random numbers between 0 and 22.
	Create the array with unsorted numbers.
	
	Asign the values of the array in another with name unsortArray.
	Show the array with unsorted numbers. 
		
	Creating an array with name oldArray.
	Loop for copy the array to oldArray.
	Copy the array.
	
	Loop the number of times to go through the list.
	Create a temporary variable and asign the value off array 'j'.
	Asign value of array 'j+1' to array 'j', for make the swapp.
	Asign value of temp to array 'j+1', for make the swapp.
	Print a values of the array than will be swapp.
	
	Print the unsorted array.
	Print the sorted array.
	
	Loop for find 4 random numbers.
	Create a random number between 0 and 22.
	Loop to compare each value of the unsorted array with the random number.
	Loop to compare each value of the sorted array with the random number.
	
	Print the Total of searches in the Unsorted array.
	Print the Total of searches in the Sorted array.
	
	Print the average of searches in the Unsorted array. 
	Print the average of searches in the Sorted array. 
	
	NOTE: The resuls will be display in de comand prompt and in the new file created with the name of the user.
		
How you tested the program:
	First, I wrote my code on a Notepad++.
	Then, I save the file in a folder that I made and call it Java-projects.
	Then, I opened the Command Prompt and moved it to the same Path with the command: cd
	Then I compiled the file with the command: javac searchAndSort.java and
	a new file was created with the same name but with the class extension.
	Then I ran the program with the command: java searchAndSort 
	Then I check the new file created for the program called, Sebas.txt.  
	Then I open the new file in the directory Java-Proyects to check the records of the user.
		
Limitations if any in the program:
	No limitacions, but the program can be ajusted for the user for increace the range of the array and 
	the range of the random number called randomNum.
*/

import java.util.*;// for input keyboard
import java.io.*; // for file creation

public class searchAndSort{ //Open class searchAndSort.
    public static void main(String[]args) throws IOException { //Start main method.  
		
		Scanner console = new Scanner(System.in); //Initialize the Scanner.
        System.out.print("Please enter your name:"); //Ask the name of the user.
        String name = console.nextLine(); //Save the name of the player in the variable 'name'.
        String filename = name +".txt"; // Convert the username to a text document and assign it to another variable.
        
		File f = new File(filename); //Will create a new instance in memory of the File class.
        
		if (f.createNewFile()) { // If the File is new, will be created.
			System.out.println("File created: "+f.getName()); // Print File created...
		}
		else System.out.println("File Already exist"); // Else print File Already exist.
		System.out.println("Absolute Path: "+ f.getAbsolutePath()); //Print the path of the file
		System.out.println(); //Print a space between lines.
		
		FileWriter myWriter = new FileWriter(f); //Provides method to write string directly to the file.
		PrintWriter printRecord = new PrintWriter(myWriter); //This class implements all of the print methods found in PrintStream .
		
		printRecord.println("Hello "+ name +", welcome!"); //Print a message in the new file .
		printRecord.println("\nThis is the Record of your searches in the unsorted and sorted array:"); //Print a message in the new file.
		printRecord.println(); //Print a space between lines into the new file.
				
        PrintStream output = new PrintStream(f); //Creates a PrintStream which is connected to an file.
        Scanner consolenum = new Scanner(System.in); //Initialize the Scanner.
        System.out.print("Specify the size of the array to be created: "); //Ask for the size of the array.
				
        int amountofnum = consolenum.nextInt(); //Save the value of the array in a variable 'amountofnum'.
        int size = amountofnum; //Asign the value of 'amountofnum' to a variable 'size'.
        int [] array = new int [amountofnum]; //Creating an array with name array.
		
		printRecord.println("The size of the array you choose is: "+size); //Print a message in the new file.
		
        for(int i = 0; i < amountofnum; i++){ // Loop for create a the array with random numbers.
			Random r = new Random(); // Create random numbers.
			int random = r.nextInt(23); //Create random numbers between 0 and 22.
			array [i] = random; // Create the array with unsorted numbers. 
        } // Close the for loop.
			   
		int[] unsortArray = array; // Asign the values of the array in another with name unsortArray.
		System.out.println(); //Print a space between lines.
		System.out.println("The array with unsorted numbers is:"); // Print a message.
		System.out.println(Arrays.toString(array)); // Show the array with unsorted numbers.
		System.out.println(); //Print a space between lines.
		
		
		printRecord.println("The array with unsorted numbers is:"); // Print a message in the new file.
		printRecord.println(Arrays.toString(array)); // Show the array with unsorted numbers in the new file.
		printRecord.println(); //Print a space between lines into the new file.
		
		int[] oldArray = new int[array.length]; //Creating an array with name oldArray.
		for (int i=0; i<array.length; i++){ // Loop for copy the array to oldArray.
			oldArray[i] = array[i]; // Copy the array.
		} // Close the for loop.
		
		// Sort the array.
		int count = 0; //Create variable count with value 0.
		for (int i = 0;i< size-1; i++){ // Number of times to go through the list.
			for(int j = 0; j< size-1-i; j++) { // Goes through the list.
				if(array[j]> array [j+1]) { // Two items are in order.
					int temp = array[j]; //Create a temporary variable and asign the value off array 'j'.
					array[j] = array[j+1]; //Asign value of array 'j+1' to array 'j', for make the swapp.
					array[j+1] = temp; // Asign value of temp to array 'j+1', for make the swapp.
					System.out.print("Swapped "+ array[j] +" "+ array[j+1]); // Print a values of the array than will be swapp.
					System.out.println(Arrays.toString(array)); //Print the results array.
					
					printRecord.println("Swapped "+ array[j] +" "+ array[j+1]); // Print a values of the array than will be swapp in the new file.
					printRecord.println(Arrays.toString(array)); //Print the results array in the new file.
					
				}// Ends the if statement.
				count++; //Increment the value of count +1.
			} // Close the for loop.			
		}// Close the for loop.
		
		System.out.println(); //Print a space between lines.
		printRecord.println(); //Print a space between lines into the new file.
				
		System.out.println("The array with unsorted numbers was:"); // Print a message.
		System.out.println(Arrays.toString(oldArray)); //Print the unsorted array.
		System.out.println("The same array with sorted numbers is:"); // Print a message.
		System.out.println(Arrays.toString(array)); //Print the sorted array.
		
		printRecord.println("The array with unsorted numbers was:"); //Print a message in the new file.
		printRecord.println(Arrays.toString(oldArray)); //Print the unsorted array in the new file.
		printRecord.println("The same array with sorted numbers is:"); //Print a message in the new file.
		printRecord.println(Arrays.toString(array)); //Print the sorted array in the new file.
				
		double totalUnsorted = 0; //Create a variable to asign the sum of the serches in the unsorted array.
		double totalSorted = 0; //Create a variable to asign the sum of the serches in the sorted array.
		System.out.println(); //Print a space between lines.
		printRecord.println(); //Print a space between lines into the new file.
	
		for (int x=0; x<4; x++) { // Loop for find 4 random numbers.
			Random randomNumber = new Random(); //Create a random number.
			int randomNum = randomNumber.nextInt(23); //Create a random number between 0 and 22.
			System.out.println("A random number is: "+randomNum); //Print a message, the randon number.
			printRecord.println("A random number is: "+randomNum); //Print a message, the randon number in the new file.
			
			for (int i=0; i<size; i++) { // Loop to compare each value of the unsorted array with the random number.
				if (oldArray[i] == randomNum) { //Compare the values with the random number.
					totalUnsorted++; // Increment the value of totalUnsorted +1.
					break; //Stop the loop.
				} //Ends the if statement.
				else { //Else.
					totalUnsorted++; // Increment the value of totalUnsorted +1.
				} //Ends the else statement.
			} // Close the for loop.
			System.out.println("The total number of accumulated searches in the unsorted array is: "+totalUnsorted); // Print a message.
			printRecord.println("The total number of accumulated searches in the unsorted array is: "+totalUnsorted); // Print a message in the new file.
							
			for (int j=0; j<size; j++) { // Loop to compare each value of the sorted array with the random number.
				if (array[j] == randomNum) { //Compare the values with the random number.
					totalSorted++; // Increment the value of totalSorted +1.
					break; //Stop the loop.			
				} //Ends the if statement.
				else if (array[j] > randomNum){ //Else.
					break; //Stop the loop.					
				} //Ends the else statement.
				else { //Else.
					  totalSorted++; // Increment the value of totalSorted +1.
				} //Ends the else statement.		    
			} // Close the for loop.
			System.out.println("The total number of accumulated searches in the sorted array is: "+totalSorted); // Print a message.
			System.out.println(); //Print a space between lines.
			
			printRecord.println("The total number of accumulated searches in the sorted array is: "+totalSorted); // Print a message in the new file.
			printRecord.println(); //Print a space between lines into the new file.
			
		}		
		
		System.out.println("Total of searches in the Unsorted array is: "+totalUnsorted); // Print a message.
		System.out.println("Total of searches in the Sorted array is: "+totalSorted); // Print a message.
		System.out.println(); //Print a space between lines.
		System.out.println("The average in the Unsorted array is: "+(totalUnsorted/4)); // Print a message.
		System.out.println("The average in the Sorted array is: "+(totalSorted/4)); // Print a message.
		
		printRecord.println("Total of searches in the Unsorted array is: "+totalUnsorted); // Print a message in the new file.
		printRecord.println("Total of searches in the Sorted array is: "+totalSorted); // Print a message in the new file.
		printRecord.println(); //Print a space between lines into the new file.
		printRecord.println("The average in the Unsorted array is: "+(totalUnsorted/4)); // Print a message in the new file.
		printRecord.println("The average in the Sorted array is: "+(totalSorted/4)); // Print a message in the new file.
		
		printRecord.println(); //Print a space between lines into the new file.
		printRecord.println("Thanks "+name+", come back soon."); // Print a message in the new file.
		
		printRecord.close(); //Close printRecord.
		
	}// //Close method main.
} //Close class searchAndSort.

/*

Command Prompt:(range 23, size array=10)

Microsoft Windows [Version 10.0.19041.867]
(c) 2020 Microsoft Corporation. All rights reserved.

C:\Users\Owner>cd Java-projects

C:\Users\Owner\Java-projects>javac searchAndSort.java

C:\Users\Owner\Java-projects>java searchAndSort
Please enter your name:Sebas
File created: Sebas.txt
Absolute Path: C:\Users\Owner\Java-projects\Sebas.txt

Specify the size of the array to be created: 10

The array with unsorted numbers is:
[20, 21, 20, 20, 18, 6, 20, 1, 4, 18]

Swapped 20 21[20, 20, 21, 20, 18, 6, 20, 1, 4, 18]
Swapped 20 21[20, 20, 20, 21, 18, 6, 20, 1, 4, 18]
Swapped 18 21[20, 20, 20, 18, 21, 6, 20, 1, 4, 18]
Swapped 6 21[20, 20, 20, 18, 6, 21, 20, 1, 4, 18]
Swapped 20 21[20, 20, 20, 18, 6, 20, 21, 1, 4, 18]
Swapped 1 21[20, 20, 20, 18, 6, 20, 1, 21, 4, 18]
Swapped 4 21[20, 20, 20, 18, 6, 20, 1, 4, 21, 18]
Swapped 18 21[20, 20, 20, 18, 6, 20, 1, 4, 18, 21]
Swapped 18 20[20, 20, 18, 20, 6, 20, 1, 4, 18, 21]
Swapped 6 20[20, 20, 18, 6, 20, 20, 1, 4, 18, 21]
Swapped 1 20[20, 20, 18, 6, 20, 1, 20, 4, 18, 21]
Swapped 4 20[20, 20, 18, 6, 20, 1, 4, 20, 18, 21]
Swapped 18 20[20, 20, 18, 6, 20, 1, 4, 18, 20, 21]
Swapped 18 20[20, 18, 20, 6, 20, 1, 4, 18, 20, 21]
Swapped 6 20[20, 18, 6, 20, 20, 1, 4, 18, 20, 21]
Swapped 1 20[20, 18, 6, 20, 1, 20, 4, 18, 20, 21]
Swapped 4 20[20, 18, 6, 20, 1, 4, 20, 18, 20, 21]
Swapped 18 20[20, 18, 6, 20, 1, 4, 18, 20, 20, 21]
Swapped 18 20[18, 20, 6, 20, 1, 4, 18, 20, 20, 21]
Swapped 6 20[18, 6, 20, 20, 1, 4, 18, 20, 20, 21]
Swapped 1 20[18, 6, 20, 1, 20, 4, 18, 20, 20, 21]
Swapped 4 20[18, 6, 20, 1, 4, 20, 18, 20, 20, 21]
Swapped 18 20[18, 6, 20, 1, 4, 18, 20, 20, 20, 21]
Swapped 6 18[6, 18, 20, 1, 4, 18, 20, 20, 20, 21]
Swapped 1 20[6, 18, 1, 20, 4, 18, 20, 20, 20, 21]
Swapped 4 20[6, 18, 1, 4, 20, 18, 20, 20, 20, 21]
Swapped 18 20[6, 18, 1, 4, 18, 20, 20, 20, 20, 21]
Swapped 1 18[6, 1, 18, 4, 18, 20, 20, 20, 20, 21]
Swapped 4 18[6, 1, 4, 18, 18, 20, 20, 20, 20, 21]
Swapped 1 6[1, 6, 4, 18, 18, 20, 20, 20, 20, 21]
Swapped 4 6[1, 4, 6, 18, 18, 20, 20, 20, 20, 21]

The array with unsorted numbers was:
[20, 21, 20, 20, 18, 6, 20, 1, 4, 18]
The same array with sorted numbers is:
[1, 4, 6, 18, 18, 20, 20, 20, 20, 21]

A random number is: 6
The total number of accumulated searches in the unsorted array is: 6.0
The total number of accumulated searches in the sorted array is: 3.0

A random number is: 11
The total number of accumulated searches in the unsorted array is: 16.0
The total number of accumulated searches in the sorted array is: 6.0

A random number is: 17
The total number of accumulated searches in the unsorted array is: 26.0
The total number of accumulated searches in the sorted array is: 9.0

A random number is: 5
The total number of accumulated searches in the unsorted array is: 36.0
The total number of accumulated searches in the sorted array is: 11.0

Total of searches in the Unsorted array is: 36.0
Total of searches in the Sorted array is: 11.0

The average in the Unsorted array is: 9.0
The average in the Sorted array is: 2.75

C:\Users\Owner\Java-projects>dir
 Volume in drive C has no label.
 Volume Serial Number is 9242-0A43

 Directory of C:\Users\Owner\Java-projects

03/31/2021  09:26 PM    <DIR>          .
03/31/2021  09:26 PM    <DIR>          ..
02/04/2021  01:02 AM             1,279 Diamond.class
02/04/2021  01:06 AM            11,880 Diamond.java
03/15/2021  12:38 AM             3,742 GameRecord.class
03/15/2021  12:44 AM            14,333 GameRecord.java
03/06/2021  12:45 AM             2,405 GameRopasc.class
02/16/2021  05:49 PM             1,984 GameRps.class
02/16/2021  01:45 AM             3,735 GameRps.java
01/20/2021  11:17 PM               417 Hello.class
08/16/2019  10:35 AM               119 Hello.java
01/22/2021  07:20 PM               573 HelloWorld.class
01/22/2021  07:18 PM             3,692 HelloWorld.java
03/10/2021  12:39 PM               686 MyName.class
03/10/2021  12:39 PM               483 MyName.java
02/15/2021  03:09 PM             1,032 RandomNum.class
02/15/2021  03:08 PM               779 RandomNum.java
03/15/2021  12:40 AM               418 Raul.txt
03/05/2021  02:32 PM             1,917 RecordTest.class
02/24/2021  11:55 AM             1,005 RecordTest.java
03/31/2021  09:26 PM             4,109 searchAndSort.class         (java compile)
03/31/2021  09:08 PM            13,332 searchAndSort.java          (java file)
03/31/2021  09:27 PM             2,921 Sebas.txt                   (new file created by the program)
01/29/2021  11:59 PM               591 Stars.class
01/29/2021  11:59 PM               274 Stars.java
              23 File(s)         71,706 bytes
               2 Dir(s)  921,571,287,040 bytes free

C:\Users\Owner\Java-projects>

*/

//Sebas- notepad (new file created by the program)

/*

Hello Sebas, welcome!

This is the Record of your searches in the unsorted and sorted array:

The size of the array you choose is: 10
The array with unsorted numbers is:
[20, 21, 20, 20, 18, 6, 20, 1, 4, 18]

Swapped 20 21
[20, 20, 21, 20, 18, 6, 20, 1, 4, 18]
Swapped 20 21
[20, 20, 20, 21, 18, 6, 20, 1, 4, 18]
Swapped 18 21
[20, 20, 20, 18, 21, 6, 20, 1, 4, 18]
Swapped 6 21
[20, 20, 20, 18, 6, 21, 20, 1, 4, 18]
Swapped 20 21
[20, 20, 20, 18, 6, 20, 21, 1, 4, 18]
Swapped 1 21
[20, 20, 20, 18, 6, 20, 1, 21, 4, 18]
Swapped 4 21
[20, 20, 20, 18, 6, 20, 1, 4, 21, 18]
Swapped 18 21
[20, 20, 20, 18, 6, 20, 1, 4, 18, 21]
Swapped 18 20
[20, 20, 18, 20, 6, 20, 1, 4, 18, 21]
Swapped 6 20
[20, 20, 18, 6, 20, 20, 1, 4, 18, 21]
Swapped 1 20
[20, 20, 18, 6, 20, 1, 20, 4, 18, 21]
Swapped 4 20
[20, 20, 18, 6, 20, 1, 4, 20, 18, 21]
Swapped 18 20
[20, 20, 18, 6, 20, 1, 4, 18, 20, 21]
Swapped 18 20
[20, 18, 20, 6, 20, 1, 4, 18, 20, 21]
Swapped 6 20
[20, 18, 6, 20, 20, 1, 4, 18, 20, 21]
Swapped 1 20
[20, 18, 6, 20, 1, 20, 4, 18, 20, 21]
Swapped 4 20
[20, 18, 6, 20, 1, 4, 20, 18, 20, 21]
Swapped 18 20
[20, 18, 6, 20, 1, 4, 18, 20, 20, 21]
Swapped 18 20
[18, 20, 6, 20, 1, 4, 18, 20, 20, 21]
Swapped 6 20
[18, 6, 20, 20, 1, 4, 18, 20, 20, 21]
Swapped 1 20
[18, 6, 20, 1, 20, 4, 18, 20, 20, 21]
Swapped 4 20
[18, 6, 20, 1, 4, 20, 18, 20, 20, 21]
Swapped 18 20
[18, 6, 20, 1, 4, 18, 20, 20, 20, 21]
Swapped 6 18
[6, 18, 20, 1, 4, 18, 20, 20, 20, 21]
Swapped 1 20
[6, 18, 1, 20, 4, 18, 20, 20, 20, 21]
Swapped 4 20
[6, 18, 1, 4, 20, 18, 20, 20, 20, 21]
Swapped 18 20
[6, 18, 1, 4, 18, 20, 20, 20, 20, 21]
Swapped 1 18
[6, 1, 18, 4, 18, 20, 20, 20, 20, 21]
Swapped 4 18
[6, 1, 4, 18, 18, 20, 20, 20, 20, 21]
Swapped 1 6
[1, 6, 4, 18, 18, 20, 20, 20, 20, 21]
Swapped 4 6
[1, 4, 6, 18, 18, 20, 20, 20, 20, 21]

The array with unsorted numbers was:
[20, 21, 20, 20, 18, 6, 20, 1, 4, 18]
The same array with sorted numbers is:
[1, 4, 6, 18, 18, 20, 20, 20, 20, 21]

A random number is: 6
The total number of accumulated searches in the unsorted array is: 6.0
The total number of accumulated searches in the sorted array is: 3.0

A random number is: 11
The total number of accumulated searches in the unsorted array is: 16.0
The total number of accumulated searches in the sorted array is: 6.0

A random number is: 17
The total number of accumulated searches in the unsorted array is: 26.0
The total number of accumulated searches in the sorted array is: 9.0

A random number is: 5
The total number of accumulated searches in the unsorted array is: 36.0
The total number of accumulated searches in the sorted array is: 11.0

Total of searches in the Unsorted array is: 36.0
Total of searches in the Sorted array is: 11.0

The average in the Unsorted array is: 9.0
The average in the Sorted array is: 2.75

Thanks Sebas, come back soon.

*/

// Command prompt: (range 100, size array=20): 

/*

C:\Users\Owner\Java-projects>javac searchAndSort.java

C:\Users\Owner\Java-projects>java searchAndSort
Please enter your name:Sebas
File Already exist
Absolute Path: C:\Users\Owner\Java-projects\Sebas.txt

Specify the size of the array to be created: 20

The array with unsorted numbers is:
[46, 12, 1, 27, 21, 35, 95, 89, 89, 48, 43, 51, 31, 78, 95, 19, 90, 94, 25, 66]

Swapped 12 46[12, 46, 1, 27, 21, 35, 95, 89, 89, 48, 43, 51, 31, 78, 95, 19, 90, 94, 25, 66]
Swapped 1 46[12, 1, 46, 27, 21, 35, 95, 89, 89, 48, 43, 51, 31, 78, 95, 19, 90, 94, 25, 66]
Swapped 27 46[12, 1, 27, 46, 21, 35, 95, 89, 89, 48, 43, 51, 31, 78, 95, 19, 90, 94, 25, 66]
Swapped 21 46[12, 1, 27, 21, 46, 35, 95, 89, 89, 48, 43, 51, 31, 78, 95, 19, 90, 94, 25, 66]
Swapped 35 46[12, 1, 27, 21, 35, 46, 95, 89, 89, 48, 43, 51, 31, 78, 95, 19, 90, 94, 25, 66]
Swapped 89 95[12, 1, 27, 21, 35, 46, 89, 95, 89, 48, 43, 51, 31, 78, 95, 19, 90, 94, 25, 66]
Swapped 89 95[12, 1, 27, 21, 35, 46, 89, 89, 95, 48, 43, 51, 31, 78, 95, 19, 90, 94, 25, 66]
Swapped 48 95[12, 1, 27, 21, 35, 46, 89, 89, 48, 95, 43, 51, 31, 78, 95, 19, 90, 94, 25, 66]
Swapped 43 95[12, 1, 27, 21, 35, 46, 89, 89, 48, 43, 95, 51, 31, 78, 95, 19, 90, 94, 25, 66]
Swapped 51 95[12, 1, 27, 21, 35, 46, 89, 89, 48, 43, 51, 95, 31, 78, 95, 19, 90, 94, 25, 66]
Swapped 31 95[12, 1, 27, 21, 35, 46, 89, 89, 48, 43, 51, 31, 95, 78, 95, 19, 90, 94, 25, 66]
Swapped 78 95[12, 1, 27, 21, 35, 46, 89, 89, 48, 43, 51, 31, 78, 95, 95, 19, 90, 94, 25, 66]
Swapped 19 95[12, 1, 27, 21, 35, 46, 89, 89, 48, 43, 51, 31, 78, 95, 19, 95, 90, 94, 25, 66]
Swapped 90 95[12, 1, 27, 21, 35, 46, 89, 89, 48, 43, 51, 31, 78, 95, 19, 90, 95, 94, 25, 66]
Swapped 94 95[12, 1, 27, 21, 35, 46, 89, 89, 48, 43, 51, 31, 78, 95, 19, 90, 94, 95, 25, 66]
Swapped 25 95[12, 1, 27, 21, 35, 46, 89, 89, 48, 43, 51, 31, 78, 95, 19, 90, 94, 25, 95, 66]
Swapped 66 95[12, 1, 27, 21, 35, 46, 89, 89, 48, 43, 51, 31, 78, 95, 19, 90, 94, 25, 66, 95]
Swapped 1 12[1, 12, 27, 21, 35, 46, 89, 89, 48, 43, 51, 31, 78, 95, 19, 90, 94, 25, 66, 95]
Swapped 21 27[1, 12, 21, 27, 35, 46, 89, 89, 48, 43, 51, 31, 78, 95, 19, 90, 94, 25, 66, 95]
Swapped 48 89[1, 12, 21, 27, 35, 46, 89, 48, 89, 43, 51, 31, 78, 95, 19, 90, 94, 25, 66, 95]
Swapped 43 89[1, 12, 21, 27, 35, 46, 89, 48, 43, 89, 51, 31, 78, 95, 19, 90, 94, 25, 66, 95]
Swapped 51 89[1, 12, 21, 27, 35, 46, 89, 48, 43, 51, 89, 31, 78, 95, 19, 90, 94, 25, 66, 95]
Swapped 31 89[1, 12, 21, 27, 35, 46, 89, 48, 43, 51, 31, 89, 78, 95, 19, 90, 94, 25, 66, 95]
Swapped 78 89[1, 12, 21, 27, 35, 46, 89, 48, 43, 51, 31, 78, 89, 95, 19, 90, 94, 25, 66, 95]
Swapped 19 95[1, 12, 21, 27, 35, 46, 89, 48, 43, 51, 31, 78, 89, 19, 95, 90, 94, 25, 66, 95]
Swapped 90 95[1, 12, 21, 27, 35, 46, 89, 48, 43, 51, 31, 78, 89, 19, 90, 95, 94, 25, 66, 95]
Swapped 94 95[1, 12, 21, 27, 35, 46, 89, 48, 43, 51, 31, 78, 89, 19, 90, 94, 95, 25, 66, 95]
Swapped 25 95[1, 12, 21, 27, 35, 46, 89, 48, 43, 51, 31, 78, 89, 19, 90, 94, 25, 95, 66, 95]
Swapped 66 95[1, 12, 21, 27, 35, 46, 89, 48, 43, 51, 31, 78, 89, 19, 90, 94, 25, 66, 95, 95]
Swapped 48 89[1, 12, 21, 27, 35, 46, 48, 89, 43, 51, 31, 78, 89, 19, 90, 94, 25, 66, 95, 95]
Swapped 43 89[1, 12, 21, 27, 35, 46, 48, 43, 89, 51, 31, 78, 89, 19, 90, 94, 25, 66, 95, 95]
Swapped 51 89[1, 12, 21, 27, 35, 46, 48, 43, 51, 89, 31, 78, 89, 19, 90, 94, 25, 66, 95, 95]
Swapped 31 89[1, 12, 21, 27, 35, 46, 48, 43, 51, 31, 89, 78, 89, 19, 90, 94, 25, 66, 95, 95]
Swapped 78 89[1, 12, 21, 27, 35, 46, 48, 43, 51, 31, 78, 89, 89, 19, 90, 94, 25, 66, 95, 95]
Swapped 19 89[1, 12, 21, 27, 35, 46, 48, 43, 51, 31, 78, 89, 19, 89, 90, 94, 25, 66, 95, 95]
Swapped 25 94[1, 12, 21, 27, 35, 46, 48, 43, 51, 31, 78, 89, 19, 89, 90, 25, 94, 66, 95, 95]
Swapped 66 94[1, 12, 21, 27, 35, 46, 48, 43, 51, 31, 78, 89, 19, 89, 90, 25, 66, 94, 95, 95]
Swapped 43 48[1, 12, 21, 27, 35, 46, 43, 48, 51, 31, 78, 89, 19, 89, 90, 25, 66, 94, 95, 95]
Swapped 31 51[1, 12, 21, 27, 35, 46, 43, 48, 31, 51, 78, 89, 19, 89, 90, 25, 66, 94, 95, 95]
Swapped 19 89[1, 12, 21, 27, 35, 46, 43, 48, 31, 51, 78, 19, 89, 89, 90, 25, 66, 94, 95, 95]
Swapped 25 90[1, 12, 21, 27, 35, 46, 43, 48, 31, 51, 78, 19, 89, 89, 25, 90, 66, 94, 95, 95]
Swapped 66 90[1, 12, 21, 27, 35, 46, 43, 48, 31, 51, 78, 19, 89, 89, 25, 66, 90, 94, 95, 95]
Swapped 43 46[1, 12, 21, 27, 35, 43, 46, 48, 31, 51, 78, 19, 89, 89, 25, 66, 90, 94, 95, 95]
Swapped 31 48[1, 12, 21, 27, 35, 43, 46, 31, 48, 51, 78, 19, 89, 89, 25, 66, 90, 94, 95, 95]
Swapped 19 78[1, 12, 21, 27, 35, 43, 46, 31, 48, 51, 19, 78, 89, 89, 25, 66, 90, 94, 95, 95]
Swapped 25 89[1, 12, 21, 27, 35, 43, 46, 31, 48, 51, 19, 78, 89, 25, 89, 66, 90, 94, 95, 95]
Swapped 66 89[1, 12, 21, 27, 35, 43, 46, 31, 48, 51, 19, 78, 89, 25, 66, 89, 90, 94, 95, 95]
Swapped 31 46[1, 12, 21, 27, 35, 43, 31, 46, 48, 51, 19, 78, 89, 25, 66, 89, 90, 94, 95, 95]
Swapped 19 51[1, 12, 21, 27, 35, 43, 31, 46, 48, 19, 51, 78, 89, 25, 66, 89, 90, 94, 95, 95]
Swapped 25 89[1, 12, 21, 27, 35, 43, 31, 46, 48, 19, 51, 78, 25, 89, 66, 89, 90, 94, 95, 95]
Swapped 66 89[1, 12, 21, 27, 35, 43, 31, 46, 48, 19, 51, 78, 25, 66, 89, 89, 90, 94, 95, 95]
Swapped 31 43[1, 12, 21, 27, 35, 31, 43, 46, 48, 19, 51, 78, 25, 66, 89, 89, 90, 94, 95, 95]
Swapped 19 48[1, 12, 21, 27, 35, 31, 43, 46, 19, 48, 51, 78, 25, 66, 89, 89, 90, 94, 95, 95]
Swapped 25 78[1, 12, 21, 27, 35, 31, 43, 46, 19, 48, 51, 25, 78, 66, 89, 89, 90, 94, 95, 95]
Swapped 66 78[1, 12, 21, 27, 35, 31, 43, 46, 19, 48, 51, 25, 66, 78, 89, 89, 90, 94, 95, 95]
Swapped 31 35[1, 12, 21, 27, 31, 35, 43, 46, 19, 48, 51, 25, 66, 78, 89, 89, 90, 94, 95, 95]
Swapped 19 46[1, 12, 21, 27, 31, 35, 43, 19, 46, 48, 51, 25, 66, 78, 89, 89, 90, 94, 95, 95]
Swapped 25 51[1, 12, 21, 27, 31, 35, 43, 19, 46, 48, 25, 51, 66, 78, 89, 89, 90, 94, 95, 95]
Swapped 19 43[1, 12, 21, 27, 31, 35, 19, 43, 46, 48, 25, 51, 66, 78, 89, 89, 90, 94, 95, 95]
Swapped 25 48[1, 12, 21, 27, 31, 35, 19, 43, 46, 25, 48, 51, 66, 78, 89, 89, 90, 94, 95, 95]
Swapped 19 35[1, 12, 21, 27, 31, 19, 35, 43, 46, 25, 48, 51, 66, 78, 89, 89, 90, 94, 95, 95]
Swapped 25 46[1, 12, 21, 27, 31, 19, 35, 43, 25, 46, 48, 51, 66, 78, 89, 89, 90, 94, 95, 95]
Swapped 19 31[1, 12, 21, 27, 19, 31, 35, 43, 25, 46, 48, 51, 66, 78, 89, 89, 90, 94, 95, 95]
Swapped 25 43[1, 12, 21, 27, 19, 31, 35, 25, 43, 46, 48, 51, 66, 78, 89, 89, 90, 94, 95, 95]
Swapped 19 27[1, 12, 21, 19, 27, 31, 35, 25, 43, 46, 48, 51, 66, 78, 89, 89, 90, 94, 95, 95]
Swapped 25 35[1, 12, 21, 19, 27, 31, 25, 35, 43, 46, 48, 51, 66, 78, 89, 89, 90, 94, 95, 95]
Swapped 19 21[1, 12, 19, 21, 27, 31, 25, 35, 43, 46, 48, 51, 66, 78, 89, 89, 90, 94, 95, 95]
Swapped 25 31[1, 12, 19, 21, 27, 25, 31, 35, 43, 46, 48, 51, 66, 78, 89, 89, 90, 94, 95, 95]
Swapped 25 27[1, 12, 19, 21, 25, 27, 31, 35, 43, 46, 48, 51, 66, 78, 89, 89, 90, 94, 95, 95]

The array with unsorted numbers was:
[46, 12, 1, 27, 21, 35, 95, 89, 89, 48, 43, 51, 31, 78, 95, 19, 90, 94, 25, 66]
The same array with sorted numbers is:
[1, 12, 19, 21, 25, 27, 31, 35, 43, 46, 48, 51, 66, 78, 89, 89, 90, 94, 95, 95]

A random number is: 33
The total number of accumulated searches in the unsorted array is: 20.0
The total number of accumulated searches in the sorted array is: 7.0

A random number is: 14
The total number of accumulated searches in the unsorted array is: 40.0
The total number of accumulated searches in the sorted array is: 9.0

A random number is: 89
The total number of accumulated searches in the unsorted array is: 48.0
The total number of accumulated searches in the sorted array is: 24.0

A random number is: 21
The total number of accumulated searches in the unsorted array is: 53.0
The total number of accumulated searches in the sorted array is: 28.0

Total of searches in the Unsorted array is: 53.0
Total of searches in the Sorted array is: 28.0

The average in the Unsorted array is: 13.25
The average in the Sorted array is: 7.0

C:\Users\Owner\Java-projects>

*/