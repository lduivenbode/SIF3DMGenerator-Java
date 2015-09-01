
package sif.dd.au30.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StaffCollectionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StaffCollectionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="StaffPersonal" type="{http://www.sifassociation.org/au/datamodel/1.4}StaffPersonalType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StaffCollectionType", namespace = "http://www.sifassociation.org/au/datamodel/1.4", propOrder = {
    "staffPersonal"
})
public class StaffCollectionType {

    @XmlElement(name = "StaffPersonal", namespace = "http://www.sifassociation.org/au/datamodel/1.4")
    protected List<StaffPersonalType> staffPersonal;

    /**
     * Gets the value of the staffPersonal property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the staffPersonal property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStaffPersonal().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StaffPersonalType }
     * 
     * 
     */
    public List<StaffPersonalType> getStaffPersonal() {
        if (staffPersonal == null) {
            staffPersonal = new ArrayList<StaffPersonalType>();
        }
        return this.staffPersonal;
    }

}
