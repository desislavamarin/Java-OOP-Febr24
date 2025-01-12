package p02_ExtendedDatabase;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private static final Person PERSON1 = Mockito.mock(Person.class);
    private static final Person PERSON2 = Mockito.mock(Person.class);
    private static final Person PERSON3 = Mockito.mock(Person.class);
    private static final Person[] EXPECTED_PEOPLE = {PERSON1, PERSON2, PERSON3};
    private Database database;

    @Before
    public void setUp() throws OperationNotSupportedException {
        database = new Database(EXPECTED_PEOPLE);
    }

    @After
    public void tearDown() {
        Mockito.reset(PERSON1, PERSON2, PERSON3);
    }

    @Test
    public void test_Constructor_Should_Create_Correct_Object() {
        Person[] actualPerson = database.getElements();

        Assert.assertArrayEquals(EXPECTED_PEOPLE, actualPerson);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void test_Constructor_Should_Throw_When_Elements_Greater_Than16() throws OperationNotSupportedException {
        database = new Database(new Person[20]);
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
        Person mockedPerson = Mockito.mock(Person.class);
        database.add(mockedPerson);

        Person[] people = database.getElements();
        int actualCount = people.length;

        Assert.assertEquals(mockedPerson, people[actualCount - 1]);
    }

    @Test
    public void test_Add_Should_Increase_Elements_Count() throws OperationNotSupportedException {
        Person mockedPerson = Mockito.mock(Person.class);
        database.add(mockedPerson);

        Person[] people = database.getElements();
        int actualCount = people.length;

        Assert.assertEquals(4, actualCount);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void test_Remove_Should_Throw_When_EmptyDatabase() throws OperationNotSupportedException {
        database = new Database();
        database.remove();
    }

    @Test
    public void test_Remove_Should_Remove_Successfully() throws OperationNotSupportedException {
        Person removedPerson = database.getElements()[2];

        database.remove();

        Assert.assertEquals(PERSON3, removedPerson);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void test_findByUsername_Should_Throw_When_Username_Null() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void test_findByUsername_Should_Throw_When_Username_NotPresent() throws OperationNotSupportedException {
        database.findByUsername("Peter");
    }

    @Test (expected = OperationNotSupportedException.class)
    public void test_findByUsername_Should_Throw_When_Username_Duplicated() throws OperationNotSupportedException {
        Mockito.when(PERSON1.getUsername()).thenReturn("Ivan");
        Mockito.when(PERSON2.getUsername()).thenReturn("Ivan");

        database.findByUsername("Ivan");


    }

    @Test
    public void test_findByUsername_Should_Return_CorrectPerson() throws OperationNotSupportedException {
        Mockito.when(PERSON1.getUsername()).thenReturn("Ivan");

        Person actualPerson = database.findByUsername("Ivan");

        Assert.assertEquals(PERSON1, actualPerson);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void test_findById_Should_Throw_When_Id_Duplicated() throws OperationNotSupportedException {
        Mockito.when(PERSON1.getId()).thenReturn(1);
        Mockito.when(PERSON2.getId()).thenReturn(1);

        database.findById(1);
    }

    @Test
    public void test_findById_Should_Return_CorrectPerson() throws OperationNotSupportedException {
        Mockito.when(PERSON1.getId()).thenReturn(1);

        Person actualPerson = database.findById(1);

        Assert.assertEquals(PERSON1, actualPerson);
    }
}
