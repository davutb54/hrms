package com.davutbudak.hrms.dataAccess.abstracts.cv;

import com.davutbudak.hrms.entities.concretes.Image;
import com.davutbudak.hrms.entities.concretes.Technology;
import com.davutbudak.hrms.entities.concretes.cv.Cv;
import com.davutbudak.hrms.entities.concretes.cv.Education;
import com.davutbudak.hrms.entities.concretes.cv.Experience;
import com.davutbudak.hrms.entities.concretes.cv.KnownLanguage;
import com.davutbudak.hrms.entities.concretes.users.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CvDao extends JpaRepository<Cv, Integer> {
    Cv getByCandidateId(int candidateId);

    @Query("from Cv as cv join CvExperience as cve on cv.id = cve.cvId join Experience as e on cve.experienceId = e.id order by e.startDate")
    List<Cv> getAllSortedByExperience();

    @Query("from Cv as cv join CvEducation as cve on cv.id = cve.cvId join Education as e on cve.educationId = e.id order by e.dateOfGraduation")
    List<Cv> getAllSortedByGraduate();

    @Query("select c from Candidate as c join Cv as cv on c.id = cv.candidateId where cv.id = :cvId")
    Candidate getCandidate(@Param("cvId") int cvId);

    @Query("select i from Image as i join Cv as cv on i.id = cv.imageId where cv.id = :cvId")
    Image getImage(@Param("cvId") int cvId);

    @Query("select e from Education as e join CvEducation as cve on e.id = cve.educationId where cve.cvId = :cvId")
    List<Education> getEducations(@Param("cvId") int cvId);

    @Query("select kl from KnownLanguage as kl join CvKnownLanguage as cvkl on kl.id = cvkl.knownLanguageId where cvkl.cvId = :cvId")
    List<KnownLanguage> getKnownLanguages(@Param("cvId") int cvId);

    @Query("select e from Experience as e join CvExperience as cve on e.id = cve.experienceId where cve.cvId= :cvId")
    List<Experience> getExperiences(@Param("cvId") int cvId);

    @Query("select t from Technology as t join CvTechnology as cvt on t.id = cvt.technologyId where cvt.cvId = :cvId")
    List<Technology> getTechnologies(@Param("cvId") int cvId);
}
