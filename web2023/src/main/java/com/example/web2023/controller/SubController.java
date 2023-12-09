package com.example.web2023.controller;

import com.example.web2023.service.SubService;
import com.example.web2023.service.StreamService;
import com.example.web2023.uito.SubUITO;
import com.example.web2023.uito.StreamUITO;
import org.primefaces.PrimeFaces;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import java.util.ArrayList;
import java.util.List;

@Controller("subController")
@SessionScope
public class SubController {

    @Autowired
    private StreamService streamService;

    @Autowired
    private SubService subService;

    private String actionLabel;

    private StreamUITO streamUITO;

    private SubUITO subUITO;

    private List<StreamUITO> streamUITOList;

    private List<SubUITO> subUITOList;

    public void saveInfoSub() {
        subService.saveSub(this.subUITO);
        getAllSub();
        this.setSubUITO(new SubUITO());
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sub Details", "Sub Details added/Updated Successfully.");
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }

    @PostConstruct
    public void getAllSub() {
        if(!this.getStreamUITOList().isEmpty()) {
                this.getStreamUITOList().clear();
                this.getSubUITOList().clear();
        }
        this.getStreamUITOList().addAll(streamService.getAllStream());
        this.getSubUITOList().addAll(subService.getAllSub());
        this.setActionLabel("Add");
    }

    public void deleteSub(SubUITO subUITO) {
            subService.deleteSub(subUITO);
            getAllSub();
    }

    public void editSub(SubUITO subUITO) {
        this.setActionLabel("Update");
        BeanUtils.copyProperties(subUITO, this.getSubUITO());
        System.out.println(this.getSubUITO());
    }

    public String getActionLabel() {
        return actionLabel;
    }

    public void setActionLabel(String actionLabel) {
        this.actionLabel = actionLabel;
    }

    public StreamUITO getStreamUITO() {
        if(streamUITO == null) {
            streamUITO = new StreamUITO();
        }
        return streamUITO;
    }

    public void setStreamUITO(StreamUITO streamUITO) {
        this.streamUITO = streamUITO;
    }

    public SubUITO getSubUITO() {
        if(subUITO == null) {
            subUITO = new SubUITO();
        }
        return subUITO;
    }

    public void setSubUITO(SubUITO subUITO) {
        this.subUITO = subUITO;
    }

    public List<StreamUITO> getStreamUITOList() {
        if(streamUITOList == null) {
            streamUITOList = new ArrayList<>();
        }
        return streamUITOList;
    }

    public void setStreamUITOList(List<StreamUITO> streamUITOList) {
        this.streamUITOList = streamUITOList;
    }

    public List<SubUITO> getSubUITOList() {
        if(subUITOList == null ) {
            subUITOList = new ArrayList<>();
        }
        return subUITOList;
    }

    public void setSubUITOList(List<SubUITO> subUITOList) {
        this.subUITOList = subUITOList;
    }
}
