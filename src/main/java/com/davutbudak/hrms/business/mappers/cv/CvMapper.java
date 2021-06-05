package com.davutbudak.hrms.business.mappers.cv;

import com.davutbudak.hrms.entities.concretes.Technology;
import com.davutbudak.hrms.entities.concretes.cv.Cv;
import com.davutbudak.hrms.entities.concretes.cv.Education;
import com.davutbudak.hrms.entities.concretes.cv.Experience;
import com.davutbudak.hrms.entities.concretes.cv.KnownLanguage;
import com.davutbudak.hrms.entities.dtos.cv.*;
import com.davutbudak.hrms.entities.operations.cv.CvOperation;

import java.util.ArrayList;
import java.util.List;

public class CvMapper {
    public static CvForListDto cvToList(Cv cv) {
        List<Education> educations = CvOperation.getEducations(cv.getId());
        List<KnownLanguage> knownLanguages = CvOperation.getKnownLanguages(cv.getId());
        List<Experience> experiences = CvOperation.getExperiences(cv.getId());
        List<Technology> technologies = CvOperation.getTechnologies(cv.getId());

        List<EducationForListDto> educationForListDtoList = new ArrayList<>();
        List<KnownLanguageForListDto> knownLanguageForListDtoList = new ArrayList<>();
        List<ExperienceForListDto> experienceForListDtoList = new ArrayList<>();

        for (Education education : educations)
            educationForListDtoList.add(EducationMapper.educationToList(education));

        for (KnownLanguage knownLanguage : knownLanguages)
            knownLanguageForListDtoList.add(KnownLanguageMapper.knownLanguageToList(knownLanguage));

        for (Experience experience : experiences)
            experienceForListDtoList.add(ExperienceMapper.experienceToList(experience));

        CvForListDto cvForListDto = CvForListDto.builder()
                .id(cv.getId())
                .candidate(CvOperation.getCandidate(cv.getId()))
                .image(CvOperation.getImage(cv.getId()))
                .educations(educationForListDtoList)
                .languages(knownLanguageForListDtoList)
                .experiences(experienceForListDtoList)
                .technologies(technologies)
                .coverLetter(cv.getCoverLetter())
                .github(cv.getGithub())
                .linkedin(cv.getLinkedin())
                .build();

        educations.clear();
        knownLanguages.clear();
        experiences.clear();
        technologies.clear();

        educationForListDtoList.clear();
        knownLanguageForListDtoList.clear();
        experienceForListDtoList.clear();

        return cvForListDto;
    }

    public static Cv addToCv(CvForAddDto addDto) {
        Cv cv = Cv.builder()
                .id(addDto.getId())
                .candidateId(addDto.getCandidateId())
                .imageId(addDto.getImageId())
                .coverLetter(addDto.getCoverLetter())
                .github(addDto.getGithub())
                .linkedin(addDto.getLinkedin())
                .build();

        for (int educationId : addDto.getEducationIds())
            CvOperation.addEducation(cv.getId(), educationId);
        for (int knownLanguageId : addDto.getKnownLanguageIds())
            CvOperation.addKnownLanguage(cv.getId(), knownLanguageId);
        for (int experienceId : addDto.getExperienceIds())
            CvOperation.addExperience(cv.getId(), experienceId);
        for (int technologyId : addDto.getTechnologyIds())
            CvOperation.addTechnology(cv.getId(), technologyId);

        return cv;
    }
}
