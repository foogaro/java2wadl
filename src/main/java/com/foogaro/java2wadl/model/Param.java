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
import javax.xml.bind.annotation.XmlID;
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
    "option",
    "link",
    "any"
})
@XmlRootElement(name = "param")
public class Param {

    protected List<Doc> doc;
    protected List<Option> option;
    protected Link link;
    @XmlAnyElement(lax = true)
    protected List<Object> any;
    @XmlAttribute(name = "href")
    @XmlSchemaType(name = "anyURI")
    protected String href;
    @XmlAttribute(name = "name")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String name;
    @XmlAttribute(name = "style")
    protected ParamStyle style;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "type")
    protected QName type;
    @XmlAttribute(name = "default")
    protected String _default;
    @XmlAttribute(name = "required")
    protected Boolean required;
    @XmlAttribute(name = "repeating")
    protected Boolean repeating;
    @XmlAttribute(name = "fixed")
    protected String fixed;
    @XmlAttribute(name = "path")
    protected String path;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    public List<Doc> getDoc() {
        if (doc == null) {
            doc = new ArrayList<Doc>();
        }
        return this.doc;
    }

    public List<Option> getOption() {
        if (option == null) {
            option = new ArrayList<Option>();
        }
        return this.option;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link value) {
        this.link = value;
    }

    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<Object>();
        }
        return this.any;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String value) {
        this.href = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public ParamStyle getStyle() {
        return style;
    }

    public void setStyle(ParamStyle value) {
        this.style = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    public QName getType() {
        if (type == null) {
            return new QName("http://www.w3.org/2001/XMLSchema", "string", "xs");
        } else {
            return type;
        }
    }

    public void setType(QName value) {
        this.type = value;
    }

    public String getDefault() {
        return _default;
    }

    public void setDefault(String value) {
        this._default = value;
    }

    public boolean isRequired() {
        if (required == null) {
            return false;
        } else {
            return required;
        }
    }

    public void setRequired(Boolean value) {
        this.required = value;
    }

    public boolean isRepeating() {
        if (repeating == null) {
            return false;
        } else {
            return repeating;
        }
    }

    public void setRepeating(Boolean value) {
        this.repeating = value;
    }

    public String getFixed() {
        return fixed;
    }

    public void setFixed(String value) {
        this.fixed = value;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String value) {
        this.path = value;
    }

    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

}
