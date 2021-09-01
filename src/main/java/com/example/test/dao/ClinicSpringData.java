/*this interface can be used with its built in methods using spring data*/
package com.example.aqarmisr.controller;

import org.springframework.data.jpa.repository.*;

public interface ClinicSpringData extends JpaRepository<Clinic,Long> {

    List<Clinic> findPatientByName(String name);

}
