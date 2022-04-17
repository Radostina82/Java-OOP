package p02_ExtendedDatabase;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {
    private static final Person[] PEOPLE = {new Person(1, "First"), new Person(2, "Second"), new Person(3, "Third")};
    private Database database;

    @Before
    public void setUp() throws OperationNotSupportedException {
        this.database = new Database(PEOPLE);
    }

    @Test
    public void testConstructorShouldCreateValidObject() {
        Person[] databaseElement = database.getElements();
        assertEquals(PEOPLE.length, databaseElement.length);
        for (int i = 0; i < databaseElement.length; i++) {
            assertEquals(PEOPLE[i], databaseElement[i]);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorShouldBeMoreThanSixteenElementThrow() throws OperationNotSupportedException {
        Person[] people = new Person[17];
        new Database(people);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorShouldBeLessThanSixteenElementThrow() throws OperationNotSupportedException {
        Person[] people = new Person[0];
        new Database(people);
    }
    @Test
    public void testAddSuccessElementInArray() throws OperationNotSupportedException {
        database.add(new Person(4, "Test"));
        assertEquals(PEOPLE.length+1, database.getElements().length);
        assertEquals(4, database.getElements()[3].getId());
        assertEquals("Test", database.getElements()[3].getUsername());
    }
    @Test(expected = OperationNotSupportedException.class)
    public void testAddThrowWhenParamNull() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveShouldThrowWithEmptyData() throws OperationNotSupportedException {
        for (Person person : database.getElements()) {
            database.remove();
        }
        database.remove();
    }
    @Test
    public void testRemoveLastElement() throws OperationNotSupportedException {
        database.remove();
        assertEquals(PEOPLE.length -1, database.getElements().length);
        assertEquals("Second", database.getElements()[1].getUsername());
        assertEquals(2, database.getElements()[1].getId());
    }
    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameThrowWithNullUser() throws OperationNotSupportedException {
        database.findByUsername(null);
    }
    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameThrowWhenDataIsEmpty() throws OperationNotSupportedException {
        database = new Database(null, null);
        database.findByUsername("First");
    }
    @Test (expected = OperationNotSupportedException.class)
    public void testFindByUsernameThrowIfSizeIsNotEqualsOne() throws OperationNotSupportedException {
        database = new Database();
        database.findByUsername("First");
    }
    @Test
    public void testFindByUsernameIsCorrect() throws OperationNotSupportedException {
        Person resultPerson = database.findByUsername("First");
        //username = "First", id = 1
        assertEquals(1, resultPerson.getId());
        assertEquals("First", resultPerson.getUsername());
    }
    @Test(expected = OperationNotSupportedException.class)
    public void  testFindByIdThrowWithEmptyData() throws OperationNotSupportedException {
        database = new Database(null, null);
        database.findById(1);
    }
    @Test (expected = OperationNotSupportedException.class)
    public void testFindByIdThrowIfSizeIsNotEqualsOne() throws OperationNotSupportedException {
        database = new Database();
        database.findById(1);
    }
    @Test
    public void testFindByIdReturnCorrectPerson() throws OperationNotSupportedException {
        Person resultPerson = database.findById(1);
        //username = "First", id = 1
        assertEquals(1, resultPerson.getId());
        assertEquals("First", resultPerson.getUsername());

        Person resultPerson2 = database.findById(2);
        assertEquals(2, resultPerson2.getId());
        assertEquals("Second", resultPerson2.getUsername());
    }
}