package com.davutbudak.hrms.entities.dtos.cv;

import com.davutbudak.hrms.entities.concretes.Language;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KnownLanguageForListDto {
    private int id;
    private Language language;
    private int level;
}
