package com.example.web2023.utils;

import com.example.web2023.service.SubService;
import com.example.web2023.uito.StreamUITO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@Service
public class StreamConverter implements Converter {

    @Autowired
    private SubService subService;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        return ((StreamUITO) o).getStreamName();
    }
}
