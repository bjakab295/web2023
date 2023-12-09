package com.example.web2023.entity;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "STREAM_MASTER")
@NamedQuery(name = "StreamDTO.findAll", query = "SELECT a FROM StreamDTO a")
public class StreamDTO implements Serializable {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "STREAM_ID")
private Long streamID;

@Column(name = "STREAM_NAME")
private String streamName;

@Column(name = "PRICE")
private Integer price;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "SUB_ID")
private SubDTO subDTO;

    public SubDTO getSubDTO() {
        return subDTO;
    }

    public void setSubDTO(SubDTO subDTO) {
        this.subDTO = subDTO;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Long getStreamID() {
        return streamID;
    }

    public void setStreamID(Long streamID) {
        this.streamID = streamID;
    }

    public String getStreamName() {
        return streamName;
    }

    public void setStreamName(String streamName) {
        this.streamName = streamName;
    }
}
