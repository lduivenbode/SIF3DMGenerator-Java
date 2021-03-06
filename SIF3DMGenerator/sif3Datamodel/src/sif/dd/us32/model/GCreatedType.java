
package sif.dd.us32.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for gCreatedType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="gCreatedType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dateTimeCreated" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="creatorList" type="{http://www.sifassociation.org/datamodel/na/3.2}gCreatorList" minOccurs="0"/>
 *         &lt;any namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "gCreatedType", namespace = "http://www.sifassociation.org/datamodel/na/3.2", propOrder = {
    "dateTimeCreated",
    "creatorList",
    "any"
})
public class GCreatedType {

    @XmlElement(namespace = "http://www.sifassociation.org/datamodel/na/3.2", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateTimeCreated;
    @XmlElement(namespace = "http://www.sifassociation.org/datamodel/na/3.2")
    protected GCreatorList creatorList;
    @XmlAnyElement(lax = true)
    protected List<Object> any;

    /**
     * Gets the value of the dateTimeCreated property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateTimeCreated() {
        return dateTimeCreated;
    }

    /**
     * Sets the value of the dateTimeCreated property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateTimeCreated(XMLGregorianCalendar value) {
        this.dateTimeCreated = value;
    }

    /**
     * Gets the value of the creatorList property.
     * 
     * @return
     *     possible object is
     *     {@link GCreatorList }
     *     
     */
    public GCreatorList getCreatorList() {
        return creatorList;
    }

    /**
     * Sets the value of the creatorList property.
     * 
     * @param value
     *     allowed object is
     *     {@link GCreatorList }
     *     
     */
    public void setCreatorList(GCreatorList value) {
        this.creatorList = value;
    }

    /**
     * Gets the value of the any property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the any property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAny().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<Object>();
        }
        return this.any;
    }

}
