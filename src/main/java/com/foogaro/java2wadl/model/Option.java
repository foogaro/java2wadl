package com.foogaro.java2wadl.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import org.w3c.dom.Element;


/**
 * @author foogaro
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "doc",
    "any"
})
@XmlRootElement(name = "option")
public class Option {

    protected List<Doc> doc;
    @XmlAnyElement(lax = true)
    protected List<Object> any;
    @XmlAttribute(name = "value", required = true)
    protected String value;
    @XmlAttribute(name = "mediaType")
    protected String mediaType;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    public List<Doc> getDoc() {
        if (doc == null) {
            doc = new ArrayList<Doc>();
        }
        return this.doc;
    }

    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<Object>();
        }
        return this.any;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String value) {
        this.mediaType = value;
    }

    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

}
