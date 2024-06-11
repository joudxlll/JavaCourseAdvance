import org.example.dao.DepartmentDAO;
import org.example.dao.JobDAO;
import org.example.dto.DepartmentFilterDto;
import org.example.dto.JobFilterDto;
import org.example.models.Department;
import org.example.models.Jobs;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestJobDao {

    @Mock
    JobFilterDto filter;

    @InjectMocks
    JobDAO dao;


    @Test
    public void testUpdateJob() throws SQLException, ClassNotFoundException {
        Jobs j2 = new Jobs(5, "Developer", 2000,3000);

        JobDAO dao = new JobDAO();

        Assertions.assertDoesNotThrow(() -> dao.updatejob(j2));

        dao.updatejob(j2);

        Jobs u = dao.selectjob(5);
        Assertions.assertEquals(u.getJob_id(), j2.getJob_id());
        Assertions.assertEquals(u.getJob_title(), j2.getJob_title());


    }



//    @Test
//    public void testSelectAllDepts() throws SQLException, ClassNotFoundException {
////        DepartmentDAO dao = new DepartmentDAO();
////        DepartmentFilterDto filter = new DepartmentFilterDto();
////        filter.setLocId(1500);
//
//        when(filter.getLocId()).thenReturn(1500);
//        when(filter.getLimit()).thenReturn(null);
//
//        Assertions.assertDoesNotThrow(() -> dao.selectAllDepts(filter));
//
//        ArrayList<Department> depts = dao.selectAllDepts(filter);
//
//        Assertions.assertNotNull(depts);
//        Assertions.assertTrue(depts.size() != 0);
//        for (Department d : depts) {
//            Assertions.assertEquals(1500, d.getLocationId());
//        }
//
//    }
}
