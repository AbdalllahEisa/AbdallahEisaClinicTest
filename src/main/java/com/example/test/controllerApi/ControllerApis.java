package com.example.test.controllerApi;

import com.example.test.dao.ClincDao;
import com.example.test.dao.Clinic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class ControllerApis {
    @Autowired
    ClincDao clinicDao;

    @GetMapping("getcurrentappointments")
    public List<Clinic> GetListOfTodaysAppointment(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String CurrentdateFormatting=formatter.format(LocalDate.now());
        LocalDate CurrentDate = LocalDate.parse(CurrentdateFormatting,formatter);
       List<Clinic>ListOfAppointment= clinicDao.getAllPatientAppointmentsToday(CurrentDate);
    return ListOfAppointment;
    }
    @GetMapping("getpreviousappointments")
    public List<Clinic> GetListOfPreviousAppointment(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String CurrentdateFormatting=formatter.format(LocalDate.now());
        LocalDate CurrentDate = LocalDate.parse(CurrentdateFormatting,formatter);
        List<Clinic>ListOfAppointment= clinicDao.getAllPatientAppointmentsHistory(CurrentDate);
        return ListOfAppointment;
    }
    @GetMapping("getappointmentsbyname")
    public List<Clinic> GetListOfAppointmentsByPatientName(@RequestParam("PatientName")String Name){

        List<Clinic>ListOfAppointment= clinicDao.getAllPatientAppointmentsByName(Name);
        return ListOfAppointment;
    }
    @GetMapping("getappointmentsbydate")
    public List<Clinic> GetListOfAppointmentsBydate(@ModelAttribute("clinic") Clinic clinic){
LocalDate DateOfReservation=clinic.getReserveDate();
        List<Clinic>ListOfAppointment= clinicDao.AllPatientAppointmentsByDate(DateOfReservation);
        return ListOfAppointment;
    }
    @PutMapping("cancellation")
    public void Appointmentcancellation(@RequestParam("id")long id, @ModelAttribute("cancellation")Clinic clinic){
      String ReasonOfCancelling=clinic.getCancellationReason();
       clinicDao.AppointmentCancellation(id,ReasonOfCancelling);

    }
    @PostMapping("addappointment")
    public void AddAppointment(@ModelAttribute("clinic") Clinic clinic){

    clinicDao.AddAppointment(clinic);
}


}
