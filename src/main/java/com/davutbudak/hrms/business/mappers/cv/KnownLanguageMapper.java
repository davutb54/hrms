package com.davutbudak.hrms.business.mappers.cv;

import com.davutbudak.hrms.entities.concretes.cv.KnownLanguage;
import com.davutbudak.hrms.entities.dtos.cv.KnownLanguageForListDto;
import com.davutbudak.hrms.entities.operations.cv.KnownLanguageOperation;

public class KnownLanguageMapper {
    public static KnownLanguageForListDto knownLanguageToList(KnownLanguage knownLanguage){
        return KnownLanguageForListDto.builder()
                .id(knownLanguage.getId())
                .language(KnownLanguageOperation.getLanguage(knownLanguage.getId()))
                .level(knownLanguage.getLevel())
                .build();
    }
}
