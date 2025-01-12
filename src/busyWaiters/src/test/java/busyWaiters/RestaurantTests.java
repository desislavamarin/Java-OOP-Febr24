package busyWaiters;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RestaurantTests {

    private static final String INVALID_CLIENT = "Invalid client!";

    @Rule
    public ExpectedException exceptionEx = ExpectedException.none();
    private Restaurant restaurant;

    @Before
    public void setUp() {
        restaurant = new Restaurant("Monkeys", 3);

        FullTimeWaiter fullTimeWaiter1 = new FullTimeWaiter("Peter", 4);
        FullTimeWaiter fullTimeWaiter2 = new FullTimeWaiter("Veselin", 6);
        FullTimeWaiter fullTimeWaiter3 = new FullTimeWaiter("Boris", 8);

        restaurant.addFullTimeWaiter(fullTimeWaiter1);
        restaurant.addFullTimeWaiter(fullTimeWaiter2);
        restaurant.addFullTimeWaiter(fullTimeWaiter3);
    }

    @Test (expected = NullPointerException.class)
    public void test_Constructor_ShouldThrow_When_Name_Null() {
        restaurant = new Restaurant(null, 10);
    }

    @Test (expected = NullPointerException.class)
    public void test_Constructor_ShouldThrow_When_Name_Empty() {
        restaurant = new Restaurant("", 10);
    }

    @Test (expected = NullPointerException.class)
    public void test_Constructor_ShouldThrow_When_Name_Blank() {
        restaurant = new Restaurant("   ", 10);
    }

    @Test
    public void test_Constructor_ShouldThrow_When_Name_Empty_Or_Blank() {
        exceptionEx.expect(NullPointerException.class);
        exceptionEx.expectMessage(INVALID_CLIENT);

        restaurant = new Restaurant("      ", 10);
        restaurant = new Restaurant("", 10);
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_Constructor_ShouldThrow_When_Capacity_Negative() {
        restaurant = new Restaurant("Monkeys", -50);
    }

    @Test
    public void test_Constructor_Should_Create_Correct_Object() {
        Assert.assertEquals("Monkeys", restaurant.getName());
        Assert.assertEquals(3, restaurant.getCapacity());
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_AddFullTimeWaiter_ShouldThrow_When_NoCapacity() {
        restaurant.addFullTimeWaiter(new FullTimeWaiter("Dimitar", 10));
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_AddFullTimeWaiter_ShouldThrow_When_Duplicated() {
        restaurant.addFullTimeWaiter(new FullTimeWaiter("Peter", 11));
    }

    @Test
    public void test_AddFullTimeWaiter_Should_Add_Correct() {
        Assert.assertEquals(3, restaurant.getCapacity());
    }

    @Test
    public void test_RemoveFullTimeWaiter_Remove_Successfully() {
        boolean isRemoved = restaurant.removeFullTimeWaiter("Boris");

        Assert.assertTrue(isRemoved);
        Assert.assertEquals(2, restaurant.getCount());
    }

    @Test
    public void test_RemoveFullTimeWaiter_Remove_NotSuccessfully() {
        boolean isRemoved = restaurant.removeFullTimeWaiter("Steli");

        Assert.assertFalse(isRemoved);
        Assert.assertEquals(3, restaurant.getCount());
    }

}
