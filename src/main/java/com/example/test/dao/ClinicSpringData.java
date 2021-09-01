/*this interface can be used with its built in methods using spring data*/
package com.example.aqarmisr.controller;

import org.springframework.data.jpa.repository.*;

public interface ClinicSpringData extends JpaRepository<Clinic,Long> {
/*this is  a sample of a method that can be created customized method
there are other spring data builtin methods like
findAll()
findById()
AND many other builtin methods
*/
   public List<Clinic> findPatientByName(String name);

}
