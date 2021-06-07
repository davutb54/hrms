package com.davutbudak.hrms.business.concretes;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.davutbudak.hrms.business.abstracts.ImageService;
import com.davutbudak.hrms.business.constants.Messages;
import com.davutbudak.hrms.core.utilities.results.Result;
import com.davutbudak.hrms.core.utilities.results.SuccessResult;
import com.davutbudak.hrms.dataAccess.abstracts.ImageDao;
import com.davutbudak.hrms.entities.concretes.Image;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;

@Service
public class ImageManager implements ImageService {
    private final ImageDao imageDao;
    private static Cloudinary cloudinary;

    @Autowired
    public ImageManager(ImageDao imageDao) {
        this.imageDao = imageDao;
    }

    @SneakyThrows
    @Override
    public Result add(Image image, MultipartFile multipartFile) {
        File file = writeFile(multipartFile);
        String publicId = image.getPublicId();

        Map map = getCloudinary().uploader().upload(file, ObjectUtils.asMap("public_id", publicId, "resource_type", "image"));
        image.setUrl(map.get("url").toString());

        file.delete();

        return new SuccessResult(Messages.IMAGE_SUCCESS_IMAGE_ADDED);
    }

    private Cloudinary getCloudinary() {
        if (cloudinary == null) {
            cloudinary = new Cloudinary(ObjectUtils.asMap(
                    "cloud_name", "davutbudak",
                    "api_key", "987633839987616",
                    "api_secret", "cyHa_U-c3f_DRMzgKIdrptsgV10"));
        }

        return cloudinary;
    }

    @SneakyThrows
    private File writeFile(MultipartFile multipartFile){
        File file = new File(multipartFile.getOriginalFilename());
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(multipartFile.getBytes());
        fileOutputStream.close();
        return file;
    }
}
