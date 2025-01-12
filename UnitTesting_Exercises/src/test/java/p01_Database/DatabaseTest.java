package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    private Database database;

    @Before
    public void setUp() throws OperationNotSupportedException {
        database = new Database(1,2, 3, 4, 5);
    }

    //Test Constructor
    //Constructor should create correct object
    //Constructor should throw when elements greater than 16
    //Constructor should throw when elements smaller than 1


    @Test
    public void test_Constructor_Should_Create_Correct_Object() {
        //AAA pattern
        //Arrange (done in setUp())
        Integer[] expectedArray = {1, 2, 3, 4, 5};
        //Act
        Integer[] actualArray = database.getElements();
        //Assert
        Assert.assertArrayEquals(expectedArray, actualArray);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void test_Constructor_Should_Throw_When_Elements_Greater_Than16() throws OperationNotSupportedException {
        Integer[] elements = new Integer[17];
        database = new Database(elements);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void test_Constructor_Should_Throw_When_Elements_Smaller_Than16() throws OperationNotSupportedException {
        database = new Database();
    }

    @Test (expected = OperationNotSupportedException.class)
    public void test_Add_Should_Throw_When_Element_Null() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void test_Add_Should_Add_Element_OnTheLast_Position() throws OperationNotSupportedException {
        database.add(15);

        Integer[] elements = database.getElements();
        int size = elements.length;

        Assert.assertEquals(Integer.valueOf(15), elements[size - 1]);
    }

    @Test
    public void test_Add_Should_Increase_Elements_Count() throws OperationNotSupportedException {
        database.add(15);

        Integer[] elements = database.getElements();
        int size = elements.length;

        Assert.assertEquals(6, size);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void test_Remove_Should_Throw_When_EmptyDatabase() throws OperationNotSupportedException {
        database = new Database();
        database.remove();
    }

    @Test
    public void test_Remove_Should_Remove_Successfully() throws OperationNotSupportedException {
        Integer[] elements = database.getElements();
        Integer removedElement = elements[elements.length - 1];

        database.remove();

        int actualSize = database.getElements().length;
        int expectedSize = 4;

        Assert.assertEquals(expectedSize, actualSize);
        Assert.assertEquals(Integer.valueOf(5), removedElement);
    }


}
