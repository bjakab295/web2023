package com.example.web2023.controller;

import com.example.web2023.service.SubService;
import com.example.web2023.service.StreamService;
import com.example.web2023.uito.StreamUITO;
import com.example.web2023.uito.SubUITO;
import org.primefaces.PrimeFaces;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import java.util.ArrayList;
import java.util.List;

@Controller("streamController")
@SessionScope
public class StreamController {

    @Autowired
    private StreamService streamService;

    @Autowired
    private SubService subService;

    private String actionLabel;

    private StreamUITO streamUITO;

    private List<StreamUITO> streamUITOList;

    private List<SubUITO> subUITOList;

    public void saveInfoStream() {
        streamService.saveStream(this.streamUITO);
        getAllStream();
        this.setStreamUITO(new StreamUITO());
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Stream Details", "Stream Details added/Updated Successfully.");
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }

    @PostConstruct
    public void getAllStream() {
        if(!this.getStreamUITOList().isEmpty()) {
            this.getStreamUITOList().clear();
            this.getSubUITOList().clear();
        }
        this.getStreamUITOList().addAll(streamService.getAllStream());
        this.getSubUITOList().addAll(subService.getAllSub());
        this.setActionLabel("Add");
    }

    public void deleteStream(StreamUITO streamUITO) {
        streamService.deleteStream(streamUITO);
        getAllStream();
    }

    public void editStream(StreamUITO streamUITO) {
        this.setActionLabel("Update");
        BeanUtils.copyProperties(streamUITO, this.getStreamUITO());
    }

    public String getActionLabel() {
        return actionLabel;
    }

    public void setActionLabel(String actionLabel) {
        this.actionLabel = actionLabel;
    }

    public StreamUITO getStreamUITO() {
        if (streamUITO == null) {
            streamUITO = new StreamUITO();
        }
        return streamUITO;
    }

    public void setStreamUITO(StreamUITO streamUITO) {
        this.streamUITO = streamUITO;
    }

    public List<StreamUITO> getStreamUITOList() {
        if (streamUITOList == null) {
            streamUITOList = new ArrayList<>();
        }
        return streamUITOList;
    }

    public void setStreamUITOList(List<StreamUITO> streamUITOList) {
        this.streamUITOList = streamUITOList;
    }

    public List<SubUITO> getSubUITOList() {
        if (subUITOList == null) {
            subUITOList = new ArrayList<>();
        }
        return subUITOList;
    }

    public void setSubUITOList(List<SubUITO> subUITOList) {
        this.subUITOList = subUITOList;
    }
}
