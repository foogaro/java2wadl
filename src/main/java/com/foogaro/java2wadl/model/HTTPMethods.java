package com.foogaro.java2wadl.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * @author foogaro
 */
@XmlType(name = "HTTPMethods")
@XmlEnum
public enum HTTPMethods {

    GET,
    POST,
    PUT,
    HEAD,
    DELETE;

    public String value() {
        return name();
    }

    public static HTTPMethods fromValue(String v) {
        return valueOf(v);
    }

}
