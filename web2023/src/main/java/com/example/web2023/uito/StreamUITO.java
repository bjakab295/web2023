package com.example.web2023.uito;

import java.io.Serializable;

public class StreamUITO implements Serializable {

private Long streamID;

private String streamName;

private Integer price;

private SubUITO subUITO;

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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public SubUITO getSubUITO() {
        return subUITO;
    }

    public void setSubUITO(SubUITO subUITO) {
        this.subUITO = subUITO;
    }

    @Override
    public String toString() {
        return "StreamUITO [streamId=" + streamID + ", streamName=" + streamName + ", price=" + price + " subUITO=" + subUITO + "]";
    }
}
