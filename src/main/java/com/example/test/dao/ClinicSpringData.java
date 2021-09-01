/*this interface can be used with its built in methods using spring data*/
package com.example.aqarmisr.controller;

import org.springframework.data.jpa.repository.*;

public interface ClinicSpringData extends JpaRepository<Clinic,Long> {
/*this is  a sample of a method that can be created its a customized method
there are other spring data builtin methods like
findAll()
findById()
AND many other builtin methods
can be used at service class or controller class by autowiring or inject this interface in the used class
*/
   public List<Clinic> findPatientByName(String name);

}
