package com.example.web2023.service;

import com.example.web2023.uito.SubUITO;

import java.util.List;

public interface SubService {

    List<SubUITO> getAllSub();

    SubUITO getSub(SubUITO subUITO);

    SubUITO saveSub(SubUITO subUITO);

    void deleteSub(SubUITO subUITO);
}
