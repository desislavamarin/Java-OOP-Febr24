package archeologicalExcavations;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExcavationTests {

    private static final String EXPECTED_NAME = "Excavation";
    private static final int EXPECTED_CAPACITY = 10;
    private static final int EXPECTED_COUNT = 0;
    private static final Archaeologist ARCHAELOGIST =
            new Archaeologist("Peter", 100);

    private Excavation excavation;

    @Before
    public void setUp() {
        excavation = new Excavation(EXPECTED_NAME, EXPECTED_CAPACITY);
    }

    @Test (expected = NullPointerException.class)
    public void test_Constructor_ShouldThrow_When_Empty_Name() {
         excavation = new Excavation("", EXPECTED_CAPACITY);
    }

    @Test (expected = NullPointerException.class)
    public void test_Constructor_ShouldThrow_When_Name_Null() {
        excavation = new Excavation(null, EXPECTED_CAPACITY);
    }

    @Test (expected = NullPointerException.class)
    public void test_Constructor_ShouldThrow_When_Name_Blank() {
        excavation = new Excavation("   ", EXPECTED_CAPACITY);
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_Constructor_ShouldThrow_When_Capacity_Negative() {
        excavation = new Excavation(EXPECTED_NAME, -10);
    }

    @Test
    public void test_Should_Create_CorrectObject() {
        int actualCapacity = excavation.getCapacity();
        String actualName = excavation.getName();
        int actualCount = excavation.getCount();

        Assert.assertEquals(EXPECTED_CAPACITY, actualCapacity);
        Assert.assertEquals(EXPECTED_NAME, actualName);
        Assert.assertEquals(EXPECTED_COUNT, actualCount);
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_AddArchaeologist_Should_Throw_When_NoCapacity(){
/*        Archaeologist archaeologist1 = Mockito.mock(Archaeologist.class);
        Archaeologist archaeologist2 = Mockito.mock(Archaeologist.class);

        Mockito.when(archaeologist1.getName()).equals("Peter");*/

        Archaeologist archaeologist2 = new Archaeologist("Ivan", 5);

        excavation = new Excavation(EXPECTED_NAME, 1);

        excavation.addArchaeologist(ARCHAELOGIST);
        excavation.addArchaeologist(archaeologist2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_AddArchaeologist_Should_Throw_When_Duplicated() {

        excavation.addArchaeologist(ARCHAELOGIST);
        excavation.addArchaeologist(ARCHAELOGIST);
    }

    @Test
    public void test_AddArchaeologist_Should_Add_Successfully() {

        excavation.addArchaeologist(ARCHAELOGIST);

        int actualCount = excavation.getCount();

        Assert.assertEquals(1, actualCount);
    }

    @Test
    public void test_RemoveArchaeologist_Should_Remove_Successfully(){
        excavation.addArchaeologist(ARCHAELOGIST);

        boolean isRemoved = excavation.removeArchaeologist("Peter");

        Assert.assertTrue(isRemoved);
    }

    @Test
    public void test_RemoveArchaeologist_Should_NotRemove(){
        boolean isRemoved = excavation.removeArchaeologist("Peter");

        Assert.assertFalse(isRemoved);
    }
}
