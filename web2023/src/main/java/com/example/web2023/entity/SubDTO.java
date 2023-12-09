package com.example.web2023.entity;

import javax.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "SUB_MASTER")
public class SubDTO implements Serializable {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "SUB_ID")
private Long subID;

@Column(name = "SUB_NAME")
private String subName;

public String getEmailId() {
    return emailId;
}

public void setEmailId(String emailId) {
    this.emailId = emailId;
}

@Column(name = "EMAIL_ID")
private String emailId;

@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "subDTO")
private List<StreamDTO> streamDTOList;

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

    public List<StreamDTO> getStreamDTOList() {
        if(null == streamDTOList) {
            return streamDTOList = new ArrayList<>();
        }
        return streamDTOList;
    }

    public void setStreamDTOList(List<StreamDTO> streamDTOList) {
        this.streamDTOList = streamDTOList;
    }
}
