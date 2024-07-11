import org.example.dao.DoctorsDAO;
import org.example.models.Doctors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TestDoctorsDAO {

//    @Mock
//    private Doctors doctors; // Mocking the Doctors model class

//    @InjectMocks
//    private DoctorsDAO dao; // The class under test

    @Mock
    private DoctorsDAO doctorsDAO; // Mocking the DoctorsDAO class

    @InjectMocks
    private Doctors doctors; // Mocking the Doctors model class

    @BeforeEach
    public void setUp() {
        // Initialize any setup required for the test
    }

//    @Test
//    public void testInsertDoc() throws SQLException, ClassNotFoundException {
//        // Prepare test data
//        Doctors testDoctor = new Doctors(1, "Dr. John Doe", "Cardiology", "johndoe@example.com", "password123", 123456789);
//
//        // Mock behavior of DatabaseConfig.getConnection() if necessary
//        // For simplicity, assuming DatabaseConfig.getConnection() is mocked or tested separately
//
//        // Mock PreparedStatement and Connection
//        // Here we are assuming that DatabaseConfig.getConnection() is mocked and returns a mock connection
//        // Mocking PreparedStatement and Connection behavior is a more advanced step if necessary
//
//        // Perform the DAO operation
//        Assertions.assertDoesNotThrow(() -> dao.insertDoc(testDoctor));
//
//        // Optionally verify mock interactions
//        // verify(mockedObject, times(1)).methodName(any());
//
//        // You may add additional assertions or verifications as needed
//    }




    @Test
    public void testSelectAllDoc() throws SQLException, ClassNotFoundException {
        // Prepare expected test data
        ArrayList<Doctors> expectedDoctors = new ArrayList<>();
        expectedDoctors.add(new Doctors(1, "Dr. Jane Smith", "Pediatrics", "janesmith@example.com", "pass123", 987654321));

        // Stub the behavior of doctorsDAO.selectAllDoc() directly
        when(doctorsDAO.selectAllDoc()).thenReturn(expectedDoctors);

        // Perform the DAO operation
        ArrayList<Doctors> result = doctorsDAO.selectAllDoc();

        // Assertions
        Assertions.assertEquals(expectedDoctors.size(), result.size());
        Assertions.assertEquals(expectedDoctors.get(0).getDoctor_id(), result.get(0).getDoctor_id());
        Assertions.assertEquals(expectedDoctors.get(0).getDoctor_name(), result.get(0).getDoctor_name());
        Assertions.assertEquals(expectedDoctors.get(0).getDoctor_specialty(), result.get(0).getDoctor_specialty());

        // Optionally verify mock interactions
        verify(doctorsDAO, times(1)).selectAllDoc();

        // You may add additional assertions or verifications as needed
    }
}
