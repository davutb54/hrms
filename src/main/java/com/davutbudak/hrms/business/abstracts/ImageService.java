package com.davutbudak.hrms.business.abstracts;

import com.davutbudak.hrms.core.utilities.results.Result;
import com.davutbudak.hrms.entities.concretes.Image;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    Result add(Image image, MultipartFile multipartFile);
}
