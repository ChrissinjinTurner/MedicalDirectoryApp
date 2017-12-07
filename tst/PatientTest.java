import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;

public class PatientTest {

    HashMap<String, Date> hashMap = new HashMap<String, Date>();
    Date date = new Date(117, 3, 23);
    private Doctor doctor = mock(Doctor.class);
    private Nurse nurse = mock(Nurse.class);
  
    private Patient patient = new Patient(1, "John", "Snow", "M", "812-34-2334", "10/17/97", 120.0, 70.0,
            doctor, nurse, "Alive", hashMap, date);

    // Getter Tests
    @Test
    public void getIdTest(){
        Assert.assertEquals(1, patient.getId());
    }

    @Test
    public void getFirstNameTest() {
        Assert.assertEquals("John", patient.getFirstName());
    }

    @Test
    public void getLastNameTest() {
        Assert.assertEquals("Snow", patient.getLastName());
    }

    @Test
    public void getGenderTest() {
        Assert.assertEquals("M", patient.getGender());
    }

    @Test
    public void getSSNTest() {
        Assert.assertEquals("812-34-2334", patient.getSSN());
    }

    @Test
    public void getWeightTest() {
        Assert.assertEquals(120.0, patient.getWeight(), .001);
    }

    @Test
    public void getHeightTest() {
        Assert.assertEquals(70.0, patient.getHeight(), .001);
    }

    @Test
    public void getDoctorTest() {
        Assert.assertEquals(doctor.getId(), patient.getDoctor().getId());
    }

    @Test
    public void getNurseTest() {
        Assert.assertEquals(nurse.getId(), patient.getNurse().getId());
    }

    @Test
    public void getCurrentConditionTest() {
        Assert.assertEquals("Alive", patient.getCurrentCondition());
    }

    @Test
    public void getDateRegisteredTest() {

        Assert.assertEquals(new Date(117, 3, 23), patient.getDateRegistered());
    }

    // Setter Tests
    @Test
    public void setFirstNameTest() {
        patient.setFirstName("Chris");

        Assert.assertEquals("Chris", patient.getFirstName());
    }

    @Test
    public void setLastNameTest() {
        patient.setLastName("Carferner");

        Assert.assertEquals("Carferner", patient.getLastName());
    }

    @Test
    public void setGenderTest() {
        patient.setGender("F");

        Assert.assertEquals("F", patient.getGender());
    }

    @Test
    public void setSSNTest() {
        patient.setSSN("123-45-6789");

        Assert.assertEquals("123-45-6789", patient.getSSN());
    }

    @Test
    public void setWeightTest() {
        patient.setWeight(200.0);

        Assert.assertEquals(200.0, patient.getWeight(), .001);
    }

    @Test
    public void setHeightTest() {
        patient.setHeight(68.0);

        Assert.assertEquals(68.0, patient.getHeight(), .001);
    }

    /**
     * idk what to do
     */
    @Test
    public void setDoctorTest() {
        patient.setDoctor(doctor);
        //verify(patient).setDoctor(doctor);

        patient.setDoctor(doctor);

        Assert.assertEquals(0, patient.getDoctor().getId());
    }

    /**
     * idk what to do
     */
    @Test
    public void setNurseTest() {
        patient.setNurse(nurse);
        //verify(patient).setNurse(nurse);

        patient.setNurse(nurse);

        Assert.assertEquals(0, patient.getNurse().getId());
    }

    @Test
    public void setCurrentConditionTest() {
        patient.setCurrentCondition("Healthy");

        Assert.assertEquals("Healthy", patient.getCurrentCondition());
    }
}
