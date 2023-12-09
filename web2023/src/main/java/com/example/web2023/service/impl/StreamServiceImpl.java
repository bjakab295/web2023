package com.example.web2023.service.impl;

import com.example.web2023.entity.SubDTO;
import com.example.web2023.entity.StreamDTO;
import com.example.web2023.repo.StreamRepo;
import com.example.web2023.service.StreamService;
import com.example.web2023.uito.StreamUITO;
import com.example.web2023.uito.SubUITO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class StreamServiceImpl implements StreamService {

    @Autowired
    StreamRepo streamRepo;

    @Override
    public List<StreamUITO> getAllStream() {
        List<StreamDTO> dtoList = streamRepo.findAll();
        List<StreamUITO> uitoList = new ArrayList<>();
        dtoList.forEach(dto -> {
            StreamUITO tempUito = new StreamUITO();
            BeanUtils.copyProperties(dto, tempUito);
            dtoToUito(tempUito, dto);
            uitoList.add(tempUito);
        });
        return uitoList;
    }

    @Override
    public StreamUITO getStream(StreamUITO streamUITO) {
        if(null != streamUITO.getStreamName()) {
            StreamDTO streamDTO = new StreamDTO();
            BeanUtils.copyProperties(streamUITO, streamDTO);
            streamDTO = streamRepo.getReferenceById(streamDTO.getStreamID());
            BeanUtils.copyProperties(streamDTO, streamUITO);
        }
        return streamUITO;
    }

    @Override
    @Transactional(readOnly = false)
    public StreamUITO saveStream(StreamUITO streamUITO) {
        StreamDTO dto = UiToToDto(streamUITO);
        dto = streamRepo.save(dto);
        BeanUtils.copyProperties(dto, streamUITO);
        dtoToUito(streamUITO, dto);
        return streamUITO;
    }

    @Override
    @Transactional
    public void deleteStream(StreamUITO streamUITO) {
        streamRepo.deleteById(streamUITO.getStreamID());
    }

    private void dtoToUito(StreamUITO streamUITO, StreamDTO dto) {
        SubUITO uitTO = new SubUITO();
        BeanUtils.copyProperties(dto.getSubDTO(), uitTO);
        streamUITO.setSubUITO(uitTO);
    }

    private StreamDTO UiToToDto(StreamUITO streamUITO) {
        StreamDTO dto = new StreamDTO();
        SubDTO subDTO = new SubDTO();
        BeanUtils.copyProperties(streamUITO, dto);
        BeanUtils.copyProperties(streamUITO.getSubUITO(), subDTO);
        dto.setSubDTO(subDTO);
        List<StreamDTO> lst = new ArrayList<>();
        lst.add(dto);
        subDTO.getStreamDTOList().addAll(lst);
        return dto;
    }
}
