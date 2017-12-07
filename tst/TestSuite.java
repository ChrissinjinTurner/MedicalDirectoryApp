import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        DoctorTest.class,
        EmployeeTest.class,
        NurseTest.class,
        OrderlyTest.class,
        PatientTest.class
})
public class TestSuite {
}
