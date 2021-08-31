package com.example.test.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public class ClinicDaoImplementaion implements ClincDao{
    @Autowired
    EntityManager entityManager;

    @Override
    @Transactional
    public void AddAppointment(Clinic clinic) {
        entityManager.merge(clinic);
    }

    @Override
    @Transactional
    public List<Clinic> getAllPatientAppointmentsToday(LocalDate CurrentDate) {

        TypedQuery<Clinic> query = entityManager.createQuery(" from Clinic  where date= :date ORDER BY id desc" ,
                Clinic.class);
        query.setParameter("date", CurrentDate);

        List<Clinic> CurrentDateAppointmentList = query.getResultList();


        return CurrentDateAppointmentList;
    }

    @Override
    @Transactional
    public List<Clinic> getAllPatientAppointmentsHistory(LocalDate PreviouseDate) {
        TypedQuery<Clinic> query = entityManager.createQuery(" from Clinic  where date< :date ORDER BY id desc" ,
                Clinic.class);
        query.setParameter("date", PreviouseDate);

        List<Clinic> PreviousDateAppointmentList = query.getResultList();


        return PreviousDateAppointmentList;
    }

    @Override
    @Transactional
    public List<Clinic> getAllPatientAppointmentsByName(String Name) {
        Query result=entityManager.createQuery("from Clinic where  PatientName LIKE '%"+Name+"%'");
        List<Clinic> PatientByName= result.getResultList();

        return PatientByName;
    }

    @Override
    @Transactional
    public List<Clinic> AllPatientAppointmentsByDate(LocalDate date) {
        TypedQuery<Clinic> query = entityManager.createQuery(" from Clinic  where date= :date ORDER BY id desc" ,
                Clinic.class);
        query.setParameter("date", date);

        List<Clinic> getAppointmentByDateList = query.getResultList();


        return getAppointmentByDateList;
    }

    @Override
    @Transactional
    public void AppointmentCancellation(long id, String ReasonOfCancellation) {
        Query result=entityManager.createQuery("update Clinic set CancellationReason='"+ReasonOfCancellation+"'  where id="+id);
        result.executeUpdate();
    }
}
