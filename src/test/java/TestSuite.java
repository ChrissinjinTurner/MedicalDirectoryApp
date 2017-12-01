import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AdminTest.class,
        DoctorTest.class,
        EmployeeTest.class,
        NurseTest.class,
        OrderlyTest.class,
        PatientTest.class
})
public class TestSuite {
}
