//import org.junit.Assert;
//import org.junit.Test;
//import main.type.*;
//
//import static org.mockito.Mockito.mock;
//
//public class OrderlyTest {
//
//    private Employee testEmployee = new Orderly();
//
//    // Getter Tests
//    @Test
//    public void getUsernameTest() {
//        testEmployee.setUsername("JDoe");
//        testEmployee.getUsername();
//
//        Assert.assertEquals("JDoe", testEmployee.getUsername());
//    }
//
//    @Test
//    public void getPasswordTest() {
//        testEmployee.setPassword("JohnDoe");
//        testEmployee.getPassword();
//
//        Assert.assertEquals("JohnDoe", testEmployee.getPassword());
//    }
//
//    @Test
//    public void getFirstNameTest() {
//        testEmployee.setFirstName("John");
//        testEmployee.getFirstName();
//
//
//        Assert.assertEquals("John", testEmployee.getFirstName());
//    }
//
//    @Test
//    public void getLastNameTest() {
//        testEmployee.setLastName("Doe");
//        testEmployee.getLastName();
//
//        Assert.assertEquals("Doe", testEmployee.getLastName());
//    }
//
//    // Setter Tests
//    @Test
//    public void setUsernameTest() {
//        testEmployee.setUsername("Chris");
//
//        testEmployee.setUsername("Jake");
//
//        Assert.assertEquals("Jake", testEmployee.getUsername());
//    }
//
//    @Test
//    public void setPasswordTest() {
//        testEmployee.setPassword("Chris");
//
//        testEmployee.setPassword("JakeLyndsey");
//
//        Assert.assertEquals("JakeLyndsey", testEmployee.getPassword());
//    }
//
//    @Test
//    public void setFirstNameTest() {
//        testEmployee.setFirstName("Chris");
//
//        testEmployee.setFirstName("Jake");
//
//        Assert.assertEquals("Jake", testEmployee.getFirstName());
//    }
//
//    @Test
//    public void setLastNameTest() {
//        testEmployee.setLastName("Carrferner");
//        testEmployee.setLastName("Lyndsey");
//
//        Assert.assertEquals("Lyndsey", testEmployee.getLastName());
//    }
//
//    @Test
//    public void viewPatientTest() {
//        Patient patient = mock(Patient.class);
//        testEmployee.viewPatient(patient);
//    }
//}
