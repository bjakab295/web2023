package com.example.web2023.utils;

import com.example.web2023.service.SubService;
import com.example.web2023.uito.SubUITO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@Service
public class SubConverter implements Converter {

    @Autowired
    private SubService subService;

    private static final Logger LOG = LoggerFactory.getLogger(SubConverter.class.getName());

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        LOG.info("getAsObject: " + subService);
        SubUITO subUITO = new SubUITO();
        subUITO.setSubName(s);
        subUITO.setEmailId(s);
        subUITO = subService.getSub(subUITO);
        System.out.println(subUITO.toString());
        return subUITO;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        LOG.info("getAsString obj class: " + o.getClass().getName());
        if (o instanceof SubUITO) {
            SubUITO sub = (SubUITO) o;
            LOG.info("getAsString def name: " + sub.getSubName());
            return sub.getSubName();
        } else {
            throw new ClassCastException("The object of class " + o.getClass().getName() + " is not of SubUITO");
        }
    }
}
