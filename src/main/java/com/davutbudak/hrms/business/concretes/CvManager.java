package com.davutbudak.hrms.business.concretes;

import com.davutbudak.hrms.business.abstracts.CvService;
import com.davutbudak.hrms.business.constants.Messages;
import com.davutbudak.hrms.business.mappers.cv.CvMapper;
import com.davutbudak.hrms.core.utilities.results.DataResult;
import com.davutbudak.hrms.core.utilities.results.Result;
import com.davutbudak.hrms.core.utilities.results.SuccessDataResult;
import com.davutbudak.hrms.core.utilities.results.SuccessResult;
import com.davutbudak.hrms.dataAccess.abstracts.cv.CvDao;
import com.davutbudak.hrms.entities.concretes.cv.Cv;
import com.davutbudak.hrms.entities.dtos.cv.CvForAddDto;
import com.davutbudak.hrms.entities.dtos.cv.CvForListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CvManager implements CvService {
    private final CvDao cvDao;

    @Autowired
    public CvManager(CvDao cvDao) {
        this.cvDao = cvDao;
    }

    @Override
    public DataResult<CvForListDto> getByCandidate(int candidateId) {
        Cv cv = cvDao.getByCandidateId(candidateId);

        return new SuccessDataResult<>(CvMapper.cvToList(cv), Messages.CV_SUCCESS_GET_CV_BY_CANDIDATE);
    }

    @Override
    public DataResult<List<CvForListDto>> getAllSortedByExperience() {
        List<Cv> cvs = cvDao.getAllSortedByExperience();
        List<CvForListDto> cvForListDtoList = new ArrayList<>();

        for (Cv cv : cvs)
            cvForListDtoList.add(CvMapper.cvToList(cv));

        return new SuccessDataResult<>(cvForListDtoList, Messages.CV_SUCCESS_GET_ALL_SORTED_BY_EXPERIENCE);
    }


    @Override
    public DataResult<List<CvForListDto>> getAllSortedByGraduate() {
        List<Cv> cvs = cvDao.getAllSortedByGraduate();
        List<CvForListDto> cvForListDtoList = new ArrayList<>();

        for (Cv cv : cvs)
            cvForListDtoList.add(CvMapper.cvToList(cv));

        return new SuccessDataResult<>(cvForListDtoList, Messages.CV_SUCCESS_GET_ALL_SORTED_BY_GRADUATE);
    }

    @Override
    public Result add(CvForAddDto addDto) {
        Cv cv = CvMapper.addToCv(addDto);

        cvDao.save(cv);
        return new SuccessResult(Messages.CV_SUCCESS_ADDED);
    }
}
