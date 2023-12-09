package com.example.web2023.service;

import com.example.web2023.uito.StreamUITO;

import java.util.List;

public interface StreamService {

    List<StreamUITO> getAllStream();

    StreamUITO getStream(StreamUITO streamUITO);

    StreamUITO saveStream(StreamUITO streamUITO);

    void deleteStream(StreamUITO streamUITO);
}
