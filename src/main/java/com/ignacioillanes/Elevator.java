package com.ignacioillanes;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Elevator {


    private int currentFloor;
    public int getCurrentFloor() {
        return currentFloor;
    }

    private boolean isOccupied;
    public boolean isOccupied() {
        return isOccupied;
    }

    private boolean isMoving;

    public boolean isMoving() {
        return isMoving;
    }

    private boolean isDoorClosed;

    public boolean isDoorClosed() {
        return isDoorClosed;
    }

    public enum Direction {
        UP, DOWN
    }

    private Direction direction;

    public Direction getDirection() {
        return direction;
    }

    public Elevator() {
        this.currentFloor = 1;
        this.isOccupied = false;
        this.isMoving = false;
        this.isDoorClosed = true;
        this.direction = Direction.UP;
    }

    List<Queue<Integer>> floors = new ArrayList<Queue<Integer>>(3);
    Queue<Integer> elevatorQueue = new PriorityQueue<>();


    public void createPerson(){
        // generate a random number between 1 - 3
        // add that number to the floor queue
        // add the floors index to elevator queue
        int floorToBeAdded = (int) (Math.random() * 3) + 1;
        while(floorToBeAdded == currentFloor){
            floorToBeAdded = (int) (Math.random() * 3) + 1;
        }
        int floorIndex = floorToBeAdded - 1;
        floors.get(floorIndex).add(floorToBeAdded);
        elevatorQueue.add(floorIndex);
    }

    public void moveUp(int floor){
        while(currentFloor < floor){
            currentFloor++;
            System.out.println("Elevator is moving up to floor " + currentFloor);
        }
    }

    public void moveDown(int floor){
        while(currentFloor > floor){
            currentFloor--;
            System.out.println("Elevator is moving down to floor " + currentFloor);
        }
    }

    public void openDoor(){
        System.out.println("Elevator is opening door");
        isDoorClosed = false;
    }

    public void closeDoor(){
        System.out.println("Elevator is closing door");
        isDoorClosed = true;
    }

    public void runElevator() throws Exception{
        if(elevatorQueue.isEmpty()){
            throw new Exception("No one is waiting for the elevator");
        }
        while (!elevatorQueue.isEmpty()) {
            int floorIndex = elevatorQueue.poll();
            Queue<Integer> floorQueue = floors.get(floorIndex);
            while (!floorQueue.isEmpty()) {
                int floor = floorQueue.poll();
                if (floor > currentFloor) {
                    moveUp(floor);
                } else if (floor < currentFloor) {
                    moveDown(floor);
                }
                openDoor();
                closeDoor();
            }
        }
    }

}
