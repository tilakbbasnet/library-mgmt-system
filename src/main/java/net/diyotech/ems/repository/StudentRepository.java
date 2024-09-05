package net.diyotech.ems.repository;

import net.diyotech.ems.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // NATIVE QUERY
    // SELECT * FROM STUDENT WHERE GENDER='FEMALE'

    @Query(value = "SELECT * FROM STUDENT WHERE GENDER='Male'", nativeQuery = true)
    public List<Student> getMaleStudents();

    /*@Query(value = "SELECT * FROM STUDENT WHERE ADDRESS=:state", nativeQuery = true)
    List<Student> getStudentsByState(String state);*/

    //Query Methods
    public List<Student> findByAddress(String address);

    public List<Student> findByAddressAndGender(String address, String gender);
}
