package com.example.aqarmisr.controller;

import org.springframework.data.jpa.repository.*;

public interface ClinicSpringData extends JpaRepository<Clinic,Long> {

    List<Clinic> findPatientByName(String name);

}
