import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MockAnnotationsTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private StudentDataObject studentDataObject;

    @Mock
    private InstructorDataObject instructorDataObject;

    @Mock
    private ClassDataObject classDataObject;

    @InjectMocks
    private ClientBusinessObjectImpl clientBusinessObjectImpl;

    @Captor
    ArgumentCaptor<Class> classArgumentCaptor;

    @Test
    public void testStudentsByClass() {
        // Given
        Student studentJM = new Student("Joy Ma", "Spanish");
        Student studentJH = new Student("Julio Hernandez", "Algebra");
        Student studentJJ = new Student("Jenny Jones", "Calculus");
        List<Student> allStudents = Arrays.asList(studentJM, studentJH, studentJJ);

        given(studentDataObject.getAllStudents()).willReturn(allStudents);

        // When
        List<Student> mathStudents = clientBusinessObjectImpl.getAllStudentsBySubject("math");

        //Then
        assertThat(mathStudents.size(), is(2));
        assertThat(mathStudents, hasItems(studentJJ, studentJH));
    }

    @Test
    public void testMarkInactive() {

        // Given
        Class geometry = new Class("Geometry", "Summer 2022");
        Class envSci = new Class("Environmental Science", "Fall 2022");
        Class compLit = new Class("Comparative Literature", "Spring 2023");
        List<Class> allClasses = Arrays.asList(geometry, envSci, compLit);

        given(classDataObject.getAllClasses()).willReturn(allClasses);

        // When
        clientBusinessObjectImpl.markCurrentClassesInactive();

        // Then
        verify(classDataObject).markInactive(geometry);

        verify(classDataObject, Mockito.never()).markInactive(envSci);

        verify(classDataObject, Mockito.never()).markInactive(compLit);

        verify(classDataObject, Mockito.times(1)).markInactive(geometry);

    }

    @Test
    public void testMarkInactive_argumentCaptor() {
        // Given
        Class geometry = new Class("Geometry", "Summer 2022");
        Class envSci = new Class("Environmental Science", "Fall 2022");
        Class compLit = new Class("Comparative Literature", "Spring 2023");
        List<Class> allClasses = Arrays.asList(geometry, envSci, compLit);

        given(classDataObject.getAllClasses()).willReturn(allClasses);

        // When
        clientBusinessObjectImpl.markCurrentClassesInactive();

        // Then
        verify(classDataObject).markInactive(classArgumentCaptor.capture());

        assertEquals(geometry, classArgumentCaptor.getValue());
    }
}
