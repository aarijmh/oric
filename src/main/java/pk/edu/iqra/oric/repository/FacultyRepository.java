package pk.edu.iqra.oric.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pk.edu.iqra.oric.domain.Campus;
import pk.edu.iqra.oric.domain.Faculty;

import java.util.List;

public interface FacultyRepository extends CrudRepository<Faculty,Integer> {

    @Query("select f.campus from Faculty f where f.id = ?1")
    Campus findCampusOfFaculty(Integer facultyId);


    @Query(" from Faculty faculty " +
            " left join fetch faculty.campus campus " +
            " where campus.university.id = (select u.university.id from User u where  u.id = ?1)")
    List<Faculty> findFacultiesOfUniversityAdmin(Integer administratorId);

    @Query("from Faculty f where f.campus.id = ?1")
    List<Faculty> findFacultiesByCampus(Integer campusId);

    @Query("from Faculty f left join fetch f.campus campus where f.id = ?1")
    Faculty getFacultyById(Integer facultyId);
}
