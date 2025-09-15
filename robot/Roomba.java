package robot;

import kareltherobot.*;

public class Roomba implements Directions {

	// Main method to make this self-contained
	public static void main(String[] args) {
		// LEAVE THIS ALONE!!!!!!
		String worldName = "robot/finalTestWorld2024.wld";

		Roomba cleaner = new Roomba();
		int totalBeepers = cleaner.cleanRoom(worldName, 26, 101);
		System.out.println("Roomba cleaned up a total of " + totalBeepers + " beepers.");

	}

	// declared here so it is visible in all the methods!
	private Robot roomba;

	// You will need to add many variables!!


	public int cleanRoom(String worldName, int startX, int startY) {

		// A new Robot should be constructed and assigned to the global (instance) variable named roomba that is declared above.
        // Make sure it starts at startX and startY location.

		World.readWorld(worldName);
		World.setDelay(0);
		World.setVisible(true);

     roomba = new Robot(startX, startY, East, 0);
		/** This section will have all the logic that takes the Robot to every location
		 * and cleans up all piles of beepers. Think about ways you can break this
		 * large, complex task into smaller, easier to solve problems.
		 */
		//to track # of beepers in the biggest pile and its location 
        int maxBeepers = 0;
        int maxBeepersX = 0;
        int maxBeepersY = 0; 


		int totalBeepers = 0; // Need to move this somewhere else.
		// the line below causes a null pointer exception
		// what is that and why are we getting it?

		//area and number of piles
        int area = 0;
        int pileCount = 0;
        //whether to stop moving or continue looping
        boolean keepCleaning = true;
        while(keepCleaning == true){
            while(roomba.frontIsClear()){
                int pileSize = 0;
                while(roomba.nextToABeeper()){
                    roomba.pickBeeper();
                    totalBeepers += 1;
                    pileSize += 1;
                    //number of piles
                    if(pileSize == 1){
                        pileCount += 1;
                    }
                }
        //finding the biggest pile
                if(pileSize > maxBeepers){
                    maxBeepers = pileSize;
                    maxBeepersX = roomba.street();
                    maxBeepersY = roomba.avenue();
                }
    
                roomba.move();
                area++;
            }
			if(roomba.facingEast()){
                roomba.turnLeft();
                if(roomba.frontIsClear()){
                    roomba.move();
                    roomba.turnLeft();
                }
                else{
                    keepCleaning = false;
                }
            }
            else{
                //turning right
                roomba.turnLeft();
                roomba.turnLeft();
                roomba.turnLeft();
                if(roomba.frontIsClear){
                    roomba.move();
                roomba.turnLeft();
                roomba.turnLeft();
                roomba.turnLeft();
                }
                else{
                    keepCleaning = false;
                }
            }
        }
		System.out.println(pileCount);
		System.out.println("Area: " + area);
        System.out.println("Max Beepers: " + maxBeepers + " in the pile at (" + maxBeepersX + ", " + maxBeepersY + ")");
        System.out.println("Number of piles: "+ pileCount);
        System.out.println("Average pile size: " + ((double)totalBeepers/pileCount));
        System.out.println("Percent dirty: " + 100 * ((double)pileCount/area) + "%");
        return totalBeepers;



	
        // This method should return the total number of beepers cleaned up.
		
	}
}

//hghghg