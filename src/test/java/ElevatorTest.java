import com.ignacioillanes.Elevator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class ElevatorTest {
    /*
    * 1. be on the first floor at the beginning
    * 2. check if elevator is occupied
    * 3. check if elevator is moving
    * 4. check if elevator is moving up
    * 5. check if elevator is moving down
    * 6. check whether if elevator is moving up, then the goal floor is higher than the current floor
    * 7. check whether if elevator is moving down, then the goal floor is lower than the current floor
     */

    @Test
    public void ensureElevatorIsOnFirstFloorAtBeginning() {
        Elevator elevator = new Elevator();
        assertEquals(1, elevator.getCurrentFloor());
    }

    @Test
    public void checkIfElevatorIsOccupied() {
        Elevator elevator = new Elevator();
        assertFalse(elevator.isOccupied());
    }

    @Test
    public void checkIfElevatorIsMoving() {
        Elevator elevator = new Elevator();
        assertFalse(elevator.isMoving());
    }

    @Test
    public void checkIfElevatorIsMovingUp() {
        Elevator elevator = new Elevator();
        assertEquals(Elevator.Direction.UP, elevator.getDirection());
    }

    @Test
    public void checkIfElevatorIsMovingDown() {
        Elevator elevator = new Elevator();

        assertEquals(Elevator.Direction.DOWN, elevator.getDirection());
    }

    @Test
    public void testElevator() throws Exception {
        Elevator elevator = new Elevator();
        assertEquals(1, elevator.getCurrentFloor());
        assertFalse(elevator.isOccupied());
        assertFalse(elevator.isMoving());
        assertEquals(Elevator.Direction.UP, elevator.getDirection());

        elevator.createPerson();
        elevator.createPerson();

        elevator.runElevator();
    }


}
