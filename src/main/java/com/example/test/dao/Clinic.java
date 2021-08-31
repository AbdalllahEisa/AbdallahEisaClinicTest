package com.example.test.dao;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="clinic")
public class Clinic {

    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name="id")
    long Id;
    @Column(name="patient_name")
    String PatientName;
    @Column(name="patient_cancellation")
    String PatientCancellation;
    @Column(name="cancellation_reason")
    String CancellationReason;
    @Column(name="reserve_date")
    LocalDate ReserveDate;


    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getPatientName() {
        return PatientName;
    }

    public void setPatientName(String patientName) {
        PatientName = patientName;
    }

    public String getPatientCancellation() {
        return PatientCancellation;
    }

    public void setPatientCancellation(String patientCancellation) {
        PatientCancellation = patientCancellation;
    }

    public String getCancellationReason() {
        return CancellationReason;
    }

    public void setCancellationReason(String cancellationReason) {
        CancellationReason = cancellationReason;
    }

    public LocalDate getReserveDate() {
        return ReserveDate;
    }

    public void setReserveDate(LocalDate reserveDate) {
        ReserveDate = reserveDate;
    }
}
