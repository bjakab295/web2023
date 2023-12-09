package com.example.web2023.uito;

import java.io.Serializable;
import java.util.List;

public class SubUITO implements Serializable {

    private Long subID;

    private String subName;

    private String emailId;

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    private List<StreamUITO> streamUITOList;

    public Long getSubID() {
        return subID;
    }

    public void setSubID(Long subID) {
        this.subID = subID;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public List<StreamUITO> getStreamUITOList() {
        return streamUITOList;
    }

    public void setStreamUITOList(List<StreamUITO> streamUITOList) {
        this.streamUITOList = streamUITOList;
    }
}
