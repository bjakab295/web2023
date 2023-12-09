package com.example.web2023.service.impl;

import com.example.web2023.entity.SubDTO;
import com.example.web2023.repo.SubRepo;
import com.example.web2023.service.SubService;
import com.example.web2023.uito.SubUITO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SubServiceImpl implements SubService {
    @Autowired
    private SubRepo subRepo;
    @Override
    public List<SubUITO> getAllSub() {
        List<SubUITO> subUITOList = new ArrayList<>();
        List<SubDTO> subDTOList = subRepo.findAll();

        subDTOList.forEach(dto -> {
            SubUITO tempUITO = new SubUITO();

            BeanUtils.copyProperties(dto, tempUITO);
            subUITOList.add(tempUITO);
        });

        return subUITOList;
    }

    @Override
    public SubUITO getSub(SubUITO subUITO) {
        SubDTO dto = subRepo.findSubDTOBySubName(subUITO.getSubName());
        SubUITO uito = new SubUITO();

        BeanUtils.copyProperties(dto, uito);
        return uito;
    }

    @Override
    public SubUITO saveSub(SubUITO subUITO) {
        SubDTO dto = new SubDTO();
        dto.setSubID(subUITO.getSubID());
        dto.setSubName(subUITO.getSubName());
        dto.setEmailId(subUITO.getEmailId());
        if(subUITO.getSubID() == null) {
            subRepo.save(dto);
        } else {
            Optional<SubDTO> dbDto = subRepo.findById(subUITO.getSubID());
            SubDTO db = dbDto.get();
            db.setSubName(subUITO.getSubName());
            subRepo.save(db);
        }
        SubDTO dto2 = subRepo.findSubDTOBySubName(subUITO.getSubName());
        SubUITO uito = new SubUITO();

        BeanUtils.copyProperties(dto2, uito);
        return uito;

    }

    @Override
    public void deleteSub(SubUITO subUITO) {
        subRepo.deleteById(subUITO.getSubID());
    }
}
