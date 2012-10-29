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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
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
@XmlRootElement(name = "link")
public class Link {

    protected List<Doc> doc;
    @XmlAnyElement(lax = true)
    protected List<Object> any;
    @XmlAttribute(name = "resource_type")
    @XmlSchemaType(name = "anyURI")
    protected String resourceType;
    @XmlAttribute(name = "rel")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String rel;
    @XmlAttribute(name = "rev")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String rev;
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

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String value) {
        this.resourceType = value;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String value) {
        this.rel = value;
    }

    public String getRev() {
        return rev;
    }

    public void setRev(String value) {
        this.rev = value;
    }

    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

}
