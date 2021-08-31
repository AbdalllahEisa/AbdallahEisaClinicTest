package com.example.test.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface ClincDao {



    public void AddAppointment(Clinic clinic);
    public List<Clinic>getAllPatientAppointmentsToday(LocalDate CurrentDate);
    public List<Clinic>getAllPatientAppointmentsHistory(LocalDate PreviouseDate);
    public List<Clinic>getAllPatientAppointmentsByName(String Name);
    public List<Clinic>AllPatientAppointmentsByDate(LocalDate date);
    public void AppointmentCancellation(long id,String ReasonOfCancellation);


}
