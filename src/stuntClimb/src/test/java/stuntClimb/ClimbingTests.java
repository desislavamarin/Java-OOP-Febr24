package stuntClimb;

import org.junit.Before;
import org.junit.Test;

public class ClimbingTests {

    private Climbing climbing;

    @Before
    public void setUp(){
        climbing = new Climbing("Everest", 10);

        RockClimber rockClimber1 = new RockClimber("Peter", 250);
        RockClimber rockClimber2 = new RockClimber("Stefan", 350);
        RockClimber rockClimber3 = new RockClimber("Ivan", 500);

        climbing.addRockClimber(rockClimber1);
        climbing.addRockClimber(rockClimber2);
        climbing.addRockClimber(rockClimber3);
    }

    @Test (expected = NullPointerException.class)
    public void test_Constructor_ShouldThrow_When_Name_Invalid() {
        climbing = new Climbing(null, 10);
    }

}
