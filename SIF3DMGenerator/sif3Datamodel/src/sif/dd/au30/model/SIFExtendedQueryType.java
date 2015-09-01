
package sif.dd.au30.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 *             SIF's default query mechanism for SIF_Request, SIF_Query, has several limitations that limit its usefulness when creating reporting applications
 *             that process data from a SIF zone.  SIF_Query is limited to matching only one object type per query, requiring applications to
 *             manually join together results as needed for reporting and general data processing.  SIF_ExtendedQuery is designed to allow for joins on
 *             object identifiers/RefIds and to allow retrieval of data in a row/column fashion similar to SQL.  Each returned column may contain hierarchical XML elements/objects.
 *             Providers and Responders in a Zone may support SIF_ExtendedQuery
 *             in addition to SIF_Query.  Support for SIF_ExtendedQuery can be declared in and retrieved from the Zone is various Infrastructure
 *             messages and objects.
 *           
 * 
 * <p>Java class for SIF_ExtendedQueryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SIF_ExtendedQueryType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SIF_DestinationProvider" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/>
 *         &lt;element name="SIF_Select">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="SIF_Element" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>normalizedString">
 *                           &lt;attribute name="Alias">
 *                             &lt;simpleType>
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}normalizedString">
 *                                 &lt;maxLength value="64"/>
 *                               &lt;/restriction>
 *                             &lt;/simpleType>
 *                           &lt;/attribute>
 *                           &lt;attribute name="ObjectName" use="required" type="{http://www.sifassociation.org/au/datamodel/1.4}ObjectNameType" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="Distinct" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                 &lt;attribute name="RowCount" use="required">
 *                   &lt;simpleType>
 *                     &lt;union memberTypes=" {http://www.w3.org/2001/XMLSchema}positiveInteger">
 *                       &lt;simpleType>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *                           &lt;enumeration value="All"/>
 *                         &lt;/restriction>
 *                       &lt;/simpleType>
 *                     &lt;/union>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="SIF_From">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="SIF_Join" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="SIF_JoinOn" maxOccurs="unbounded">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="SIF_LeftElement">
 *                                         &lt;complexType>
 *                                           &lt;simpleContent>
 *                                             &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>normalizedString">
 *                                               &lt;attribute name="ObjectName" use="required" type="{http://www.sifassociation.org/au/datamodel/1.4}ObjectNameType" />
 *                                             &lt;/extension>
 *                                           &lt;/simpleContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="SIF_RightElement">
 *                                         &lt;complexType>
 *                                           &lt;simpleContent>
 *                                             &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>normalizedString">
 *                                               &lt;attribute name="ObjectName" use="required" type="{http://www.sifassociation.org/au/datamodel/1.4}ObjectNameType" />
 *                                             &lt;/extension>
 *                                           &lt;/simpleContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                           &lt;attribute name="Type" use="required">
 *                             &lt;simpleType>
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *                                 &lt;enumeration value="Inner"/>
 *                                 &lt;enumeration value="LeftOuter"/>
 *                                 &lt;enumeration value="RightOuter"/>
 *                                 &lt;enumeration value="FullOuter"/>
 *                               &lt;/restriction>
 *                             &lt;/simpleType>
 *                           &lt;/attribute>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="ObjectName" use="required" type="{http://www.sifassociation.org/au/datamodel/1.4}ObjectNameType" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="SIF_Where" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="SIF_ConditionGroup">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="SIF_Conditions" maxOccurs="unbounded">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="SIF_Condition" maxOccurs="unbounded">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="SIF_Element">
 *                                                   &lt;complexType>
 *                                                     &lt;simpleContent>
 *                                                       &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>normalizedString">
 *                                                         &lt;attribute name="ObjectName" use="required" type="{http://www.sifassociation.org/au/datamodel/1.4}ObjectNameType" />
 *                                                       &lt;/extension>
 *                                                     &lt;/simpleContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="SIF_Operator">
 *                                                   &lt;simpleType>
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *                                                       &lt;enumeration value="EQ"/>
 *                                                       &lt;enumeration value="LT"/>
 *                                                       &lt;enumeration value="GT"/>
 *                                                       &lt;enumeration value="LE"/>
 *                                                       &lt;enumeration value="GE"/>
 *                                                       &lt;enumeration value="NE"/>
 *                                                     &lt;/restriction>
 *                                                   &lt;/simpleType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="SIF_Value" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                     &lt;attribute name="Type" use="required">
 *                                       &lt;simpleType>
 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *                                           &lt;enumeration value="And"/>
 *                                           &lt;enumeration value="Or"/>
 *                                           &lt;enumeration value="None"/>
 *                                         &lt;/restriction>
 *                                       &lt;/simpleType>
 *                                     &lt;/attribute>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                           &lt;attribute name="Type" use="required">
 *                             &lt;simpleType>
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *                                 &lt;enumeration value="And"/>
 *                                 &lt;enumeration value="Or"/>
 *                                 &lt;enumeration value="None"/>
 *                               &lt;/restriction>
 *                             &lt;/simpleType>
 *                           &lt;/attribute>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="SIF_OrderBy" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="SIF_Element" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>normalizedString">
 *                           &lt;attribute name="ObjectName" use="required" type="{http://www.sifassociation.org/au/datamodel/1.4}ObjectNameType" />
 *                           &lt;attribute name="Ordering" use="required">
 *                             &lt;simpleType>
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *                                 &lt;enumeration value="Ascending"/>
 *                                 &lt;enumeration value="Descending"/>
 *                               &lt;/restriction>
 *                             &lt;/simpleType>
 *                           &lt;/attribute>
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SIF_ExtendedQueryType", namespace = "http://www.sifassociation.org/au/datamodel/1.4", propOrder = {
    "sifDestinationProvider",
    "sifSelect",
    "sifFrom",
    "sifWhere",
    "sifOrderBy"
})
public class SIFExtendedQueryType {

    @XmlElement(name = "SIF_DestinationProvider", namespace = "http://www.sifassociation.org/au/datamodel/1.4")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String sifDestinationProvider;
    @XmlElement(name = "SIF_Select", namespace = "http://www.sifassociation.org/au/datamodel/1.4", required = true)
    protected SIFExtendedQueryType.SIFSelect sifSelect;
    @XmlElement(name = "SIF_From", namespace = "http://www.sifassociation.org/au/datamodel/1.4", required = true)
    protected SIFExtendedQueryType.SIFFrom sifFrom;
    @XmlElement(name = "SIF_Where", namespace = "http://www.sifassociation.org/au/datamodel/1.4")
    protected SIFExtendedQueryType.SIFWhere sifWhere;
    @XmlElement(name = "SIF_OrderBy", namespace = "http://www.sifassociation.org/au/datamodel/1.4")
    protected SIFExtendedQueryType.SIFOrderBy sifOrderBy;

    /**
     * Gets the value of the sifDestinationProvider property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSIFDestinationProvider() {
        return sifDestinationProvider;
    }

    /**
     * Sets the value of the sifDestinationProvider property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSIFDestinationProvider(String value) {
        this.sifDestinationProvider = value;
    }

    /**
     * Gets the value of the sifSelect property.
     * 
     * @return
     *     possible object is
     *     {@link SIFExtendedQueryType.SIFSelect }
     *     
     */
    public SIFExtendedQueryType.SIFSelect getSIFSelect() {
        return sifSelect;
    }

    /**
     * Sets the value of the sifSelect property.
     * 
     * @param value
     *     allowed object is
     *     {@link SIFExtendedQueryType.SIFSelect }
     *     
     */
    public void setSIFSelect(SIFExtendedQueryType.SIFSelect value) {
        this.sifSelect = value;
    }

    /**
     * Gets the value of the sifFrom property.
     * 
     * @return
     *     possible object is
     *     {@link SIFExtendedQueryType.SIFFrom }
     *     
     */
    public SIFExtendedQueryType.SIFFrom getSIFFrom() {
        return sifFrom;
    }

    /**
     * Sets the value of the sifFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link SIFExtendedQueryType.SIFFrom }
     *     
     */
    public void setSIFFrom(SIFExtendedQueryType.SIFFrom value) {
        this.sifFrom = value;
    }

    /**
     * Gets the value of the sifWhere property.
     * 
     * @return
     *     possible object is
     *     {@link SIFExtendedQueryType.SIFWhere }
     *     
     */
    public SIFExtendedQueryType.SIFWhere getSIFWhere() {
        return sifWhere;
    }

    /**
     * Sets the value of the sifWhere property.
     * 
     * @param value
     *     allowed object is
     *     {@link SIFExtendedQueryType.SIFWhere }
     *     
     */
    public void setSIFWhere(SIFExtendedQueryType.SIFWhere value) {
        this.sifWhere = value;
    }

    /**
     * Gets the value of the sifOrderBy property.
     * 
     * @return
     *     possible object is
     *     {@link SIFExtendedQueryType.SIFOrderBy }
     *     
     */
    public SIFExtendedQueryType.SIFOrderBy getSIFOrderBy() {
        return sifOrderBy;
    }

    /**
     * Sets the value of the sifOrderBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link SIFExtendedQueryType.SIFOrderBy }
     *     
     */
    public void setSIFOrderBy(SIFExtendedQueryType.SIFOrderBy value) {
        this.sifOrderBy = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="SIF_Join" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="SIF_JoinOn" maxOccurs="unbounded">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="SIF_LeftElement">
     *                               &lt;complexType>
     *                                 &lt;simpleContent>
     *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>normalizedString">
     *                                     &lt;attribute name="ObjectName" use="required" type="{http://www.sifassociation.org/au/datamodel/1.4}ObjectNameType" />
     *                                   &lt;/extension>
     *                                 &lt;/simpleContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                             &lt;element name="SIF_RightElement">
     *                               &lt;complexType>
     *                                 &lt;simpleContent>
     *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>normalizedString">
     *                                     &lt;attribute name="ObjectName" use="required" type="{http://www.sifassociation.org/au/datamodel/1.4}ObjectNameType" />
     *                                   &lt;/extension>
     *                                 &lt;/simpleContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *                 &lt;attribute name="Type" use="required">
     *                   &lt;simpleType>
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
     *                       &lt;enumeration value="Inner"/>
     *                       &lt;enumeration value="LeftOuter"/>
     *                       &lt;enumeration value="RightOuter"/>
     *                       &lt;enumeration value="FullOuter"/>
     *                     &lt;/restriction>
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="ObjectName" use="required" type="{http://www.sifassociation.org/au/datamodel/1.4}ObjectNameType" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "sifJoin"
    })
    public static class SIFFrom {

        @XmlElement(name = "SIF_Join", namespace = "http://www.sifassociation.org/au/datamodel/1.4")
        protected List<SIFExtendedQueryType.SIFFrom.SIFJoin> sifJoin;
        @XmlAttribute(name = "ObjectName", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        protected String objectName;

        /**
         * Gets the value of the sifJoin property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the sifJoin property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSIFJoin().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link SIFExtendedQueryType.SIFFrom.SIFJoin }
         * 
         * 
         */
        public List<SIFExtendedQueryType.SIFFrom.SIFJoin> getSIFJoin() {
            if (sifJoin == null) {
                sifJoin = new ArrayList<SIFExtendedQueryType.SIFFrom.SIFJoin>();
            }
            return this.sifJoin;
        }

        /**
         * Gets the value of the objectName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getObjectName() {
            return objectName;
        }

        /**
         * Sets the value of the objectName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setObjectName(String value) {
            this.objectName = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="SIF_JoinOn" maxOccurs="unbounded">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="SIF_LeftElement">
         *                     &lt;complexType>
         *                       &lt;simpleContent>
         *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>normalizedString">
         *                           &lt;attribute name="ObjectName" use="required" type="{http://www.sifassociation.org/au/datamodel/1.4}ObjectNameType" />
         *                         &lt;/extension>
         *                       &lt;/simpleContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                   &lt;element name="SIF_RightElement">
         *                     &lt;complexType>
         *                       &lt;simpleContent>
         *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>normalizedString">
         *                           &lt;attribute name="ObjectName" use="required" type="{http://www.sifassociation.org/au/datamodel/1.4}ObjectNameType" />
         *                         &lt;/extension>
         *                       &lt;/simpleContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *       &lt;attribute name="Type" use="required">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
         *             &lt;enumeration value="Inner"/>
         *             &lt;enumeration value="LeftOuter"/>
         *             &lt;enumeration value="RightOuter"/>
         *             &lt;enumeration value="FullOuter"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "sifJoinOn"
        })
        public static class SIFJoin {

            @XmlElement(name = "SIF_JoinOn", namespace = "http://www.sifassociation.org/au/datamodel/1.4", required = true)
            protected List<SIFExtendedQueryType.SIFFrom.SIFJoin.SIFJoinOn> sifJoinOn;
            @XmlAttribute(name = "Type", required = true)
            @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
            protected String type;

            /**
             * Gets the value of the sifJoinOn property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the sifJoinOn property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getSIFJoinOn().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link SIFExtendedQueryType.SIFFrom.SIFJoin.SIFJoinOn }
             * 
             * 
             */
            public List<SIFExtendedQueryType.SIFFrom.SIFJoin.SIFJoinOn> getSIFJoinOn() {
                if (sifJoinOn == null) {
                    sifJoinOn = new ArrayList<SIFExtendedQueryType.SIFFrom.SIFJoin.SIFJoinOn>();
                }
                return this.sifJoinOn;
            }

            /**
             * Gets the value of the type property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getType() {
                return type;
            }

            /**
             * Sets the value of the type property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setType(String value) {
                this.type = value;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="SIF_LeftElement">
             *           &lt;complexType>
             *             &lt;simpleContent>
             *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>normalizedString">
             *                 &lt;attribute name="ObjectName" use="required" type="{http://www.sifassociation.org/au/datamodel/1.4}ObjectNameType" />
             *               &lt;/extension>
             *             &lt;/simpleContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *         &lt;element name="SIF_RightElement">
             *           &lt;complexType>
             *             &lt;simpleContent>
             *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>normalizedString">
             *                 &lt;attribute name="ObjectName" use="required" type="{http://www.sifassociation.org/au/datamodel/1.4}ObjectNameType" />
             *               &lt;/extension>
             *             &lt;/simpleContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "sifLeftElement",
                "sifRightElement"
            })
            public static class SIFJoinOn {

                @XmlElement(name = "SIF_LeftElement", namespace = "http://www.sifassociation.org/au/datamodel/1.4", required = true)
                protected SIFExtendedQueryType.SIFFrom.SIFJoin.SIFJoinOn.SIFLeftElement sifLeftElement;
                @XmlElement(name = "SIF_RightElement", namespace = "http://www.sifassociation.org/au/datamodel/1.4", required = true)
                protected SIFExtendedQueryType.SIFFrom.SIFJoin.SIFJoinOn.SIFRightElement sifRightElement;

                /**
                 * Gets the value of the sifLeftElement property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link SIFExtendedQueryType.SIFFrom.SIFJoin.SIFJoinOn.SIFLeftElement }
                 *     
                 */
                public SIFExtendedQueryType.SIFFrom.SIFJoin.SIFJoinOn.SIFLeftElement getSIFLeftElement() {
                    return sifLeftElement;
                }

                /**
                 * Sets the value of the sifLeftElement property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link SIFExtendedQueryType.SIFFrom.SIFJoin.SIFJoinOn.SIFLeftElement }
                 *     
                 */
                public void setSIFLeftElement(SIFExtendedQueryType.SIFFrom.SIFJoin.SIFJoinOn.SIFLeftElement value) {
                    this.sifLeftElement = value;
                }

                /**
                 * Gets the value of the sifRightElement property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link SIFExtendedQueryType.SIFFrom.SIFJoin.SIFJoinOn.SIFRightElement }
                 *     
                 */
                public SIFExtendedQueryType.SIFFrom.SIFJoin.SIFJoinOn.SIFRightElement getSIFRightElement() {
                    return sifRightElement;
                }

                /**
                 * Sets the value of the sifRightElement property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link SIFExtendedQueryType.SIFFrom.SIFJoin.SIFJoinOn.SIFRightElement }
                 *     
                 */
                public void setSIFRightElement(SIFExtendedQueryType.SIFFrom.SIFJoin.SIFJoinOn.SIFRightElement value) {
                    this.sifRightElement = value;
                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;simpleContent>
                 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>normalizedString">
                 *       &lt;attribute name="ObjectName" use="required" type="{http://www.sifassociation.org/au/datamodel/1.4}ObjectNameType" />
                 *     &lt;/extension>
                 *   &lt;/simpleContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "value"
                })
                public static class SIFLeftElement {

                    @XmlValue
                    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
                    @XmlSchemaType(name = "normalizedString")
                    protected String value;
                    @XmlAttribute(name = "ObjectName", required = true)
                    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
                    protected String objectName;

                    /**
                     * Gets the value of the value property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getValue() {
                        return value;
                    }

                    /**
                     * Sets the value of the value property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setValue(String value) {
                        this.value = value;
                    }

                    /**
                     * Gets the value of the objectName property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getObjectName() {
                        return objectName;
                    }

                    /**
                     * Sets the value of the objectName property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setObjectName(String value) {
                        this.objectName = value;
                    }

                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;simpleContent>
                 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>normalizedString">
                 *       &lt;attribute name="ObjectName" use="required" type="{http://www.sifassociation.org/au/datamodel/1.4}ObjectNameType" />
                 *     &lt;/extension>
                 *   &lt;/simpleContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "value"
                })
                public static class SIFRightElement {

                    @XmlValue
                    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
                    @XmlSchemaType(name = "normalizedString")
                    protected String value;
                    @XmlAttribute(name = "ObjectName", required = true)
                    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
                    protected String objectName;

                    /**
                     * Gets the value of the value property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getValue() {
                        return value;
                    }

                    /**
                     * Sets the value of the value property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setValue(String value) {
                        this.value = value;
                    }

                    /**
                     * Gets the value of the objectName property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getObjectName() {
                        return objectName;
                    }

                    /**
                     * Sets the value of the objectName property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setObjectName(String value) {
                        this.objectName = value;
                    }

                }

            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="SIF_Element" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>normalizedString">
     *                 &lt;attribute name="ObjectName" use="required" type="{http://www.sifassociation.org/au/datamodel/1.4}ObjectNameType" />
     *                 &lt;attribute name="Ordering" use="required">
     *                   &lt;simpleType>
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
     *                       &lt;enumeration value="Ascending"/>
     *                       &lt;enumeration value="Descending"/>
     *                     &lt;/restriction>
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "sifElement"
    })
    public static class SIFOrderBy {

        @XmlElement(name = "SIF_Element", namespace = "http://www.sifassociation.org/au/datamodel/1.4", required = true)
        protected List<SIFExtendedQueryType.SIFOrderBy.SIFElement> sifElement;

        /**
         * Gets the value of the sifElement property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the sifElement property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSIFElement().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link SIFExtendedQueryType.SIFOrderBy.SIFElement }
         * 
         * 
         */
        public List<SIFExtendedQueryType.SIFOrderBy.SIFElement> getSIFElement() {
            if (sifElement == null) {
                sifElement = new ArrayList<SIFExtendedQueryType.SIFOrderBy.SIFElement>();
            }
            return this.sifElement;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>normalizedString">
         *       &lt;attribute name="ObjectName" use="required" type="{http://www.sifassociation.org/au/datamodel/1.4}ObjectNameType" />
         *       &lt;attribute name="Ordering" use="required">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
         *             &lt;enumeration value="Ascending"/>
         *             &lt;enumeration value="Descending"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class SIFElement {

            @XmlValue
            @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
            @XmlSchemaType(name = "normalizedString")
            protected String value;
            @XmlAttribute(name = "ObjectName", required = true)
            @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
            protected String objectName;
            @XmlAttribute(name = "Ordering", required = true)
            @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
            protected String ordering;

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Gets the value of the objectName property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getObjectName() {
                return objectName;
            }

            /**
             * Sets the value of the objectName property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setObjectName(String value) {
                this.objectName = value;
            }

            /**
             * Gets the value of the ordering property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getOrdering() {
                return ordering;
            }

            /**
             * Sets the value of the ordering property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setOrdering(String value) {
                this.ordering = value;
            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="SIF_Element" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>normalizedString">
     *                 &lt;attribute name="Alias">
     *                   &lt;simpleType>
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}normalizedString">
     *                       &lt;maxLength value="64"/>
     *                     &lt;/restriction>
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
     *                 &lt;attribute name="ObjectName" use="required" type="{http://www.sifassociation.org/au/datamodel/1.4}ObjectNameType" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="Distinct" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="RowCount" use="required">
     *         &lt;simpleType>
     *           &lt;union memberTypes=" {http://www.w3.org/2001/XMLSchema}positiveInteger">
     *             &lt;simpleType>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
     *                 &lt;enumeration value="All"/>
     *               &lt;/restriction>
     *             &lt;/simpleType>
     *           &lt;/union>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "sifElement"
    })
    public static class SIFSelect {

        @XmlElement(name = "SIF_Element", namespace = "http://www.sifassociation.org/au/datamodel/1.4", required = true)
        protected List<SIFExtendedQueryType.SIFSelect.SIFElement> sifElement;
        @XmlAttribute(name = "Distinct", required = true)
        protected boolean distinct;
        @XmlAttribute(name = "RowCount", required = true)
        protected String rowCount;

        /**
         * Gets the value of the sifElement property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the sifElement property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSIFElement().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link SIFExtendedQueryType.SIFSelect.SIFElement }
         * 
         * 
         */
        public List<SIFExtendedQueryType.SIFSelect.SIFElement> getSIFElement() {
            if (sifElement == null) {
                sifElement = new ArrayList<SIFExtendedQueryType.SIFSelect.SIFElement>();
            }
            return this.sifElement;
        }

        /**
         * Gets the value of the distinct property.
         * 
         */
        public boolean isDistinct() {
            return distinct;
        }

        /**
         * Sets the value of the distinct property.
         * 
         */
        public void setDistinct(boolean value) {
            this.distinct = value;
        }

        /**
         * Gets the value of the rowCount property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRowCount() {
            return rowCount;
        }

        /**
         * Sets the value of the rowCount property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRowCount(String value) {
            this.rowCount = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>normalizedString">
         *       &lt;attribute name="Alias">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}normalizedString">
         *             &lt;maxLength value="64"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *       &lt;attribute name="ObjectName" use="required" type="{http://www.sifassociation.org/au/datamodel/1.4}ObjectNameType" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class SIFElement {

            @XmlValue
            @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
            @XmlSchemaType(name = "normalizedString")
            protected String value;
            @XmlAttribute(name = "Alias")
            @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
            protected String alias;
            @XmlAttribute(name = "ObjectName", required = true)
            @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
            protected String objectName;

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Gets the value of the alias property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAlias() {
                return alias;
            }

            /**
             * Sets the value of the alias property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAlias(String value) {
                this.alias = value;
            }

            /**
             * Gets the value of the objectName property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getObjectName() {
                return objectName;
            }

            /**
             * Sets the value of the objectName property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setObjectName(String value) {
                this.objectName = value;
            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="SIF_ConditionGroup">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="SIF_Conditions" maxOccurs="unbounded">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="SIF_Condition" maxOccurs="unbounded">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="SIF_Element">
     *                                         &lt;complexType>
     *                                           &lt;simpleContent>
     *                                             &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>normalizedString">
     *                                               &lt;attribute name="ObjectName" use="required" type="{http://www.sifassociation.org/au/datamodel/1.4}ObjectNameType" />
     *                                             &lt;/extension>
     *                                           &lt;/simpleContent>
     *                                         &lt;/complexType>
     *                                       &lt;/element>
     *                                       &lt;element name="SIF_Operator">
     *                                         &lt;simpleType>
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
     *                                             &lt;enumeration value="EQ"/>
     *                                             &lt;enumeration value="LT"/>
     *                                             &lt;enumeration value="GT"/>
     *                                             &lt;enumeration value="LE"/>
     *                                             &lt;enumeration value="GE"/>
     *                                             &lt;enumeration value="NE"/>
     *                                           &lt;/restriction>
     *                                         &lt;/simpleType>
     *                                       &lt;/element>
     *                                       &lt;element name="SIF_Value" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                     &lt;/sequence>
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                           &lt;/sequence>
     *                           &lt;attribute name="Type" use="required">
     *                             &lt;simpleType>
     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
     *                                 &lt;enumeration value="And"/>
     *                                 &lt;enumeration value="Or"/>
     *                                 &lt;enumeration value="None"/>
     *                               &lt;/restriction>
     *                             &lt;/simpleType>
     *                           &lt;/attribute>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *                 &lt;attribute name="Type" use="required">
     *                   &lt;simpleType>
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
     *                       &lt;enumeration value="And"/>
     *                       &lt;enumeration value="Or"/>
     *                       &lt;enumeration value="None"/>
     *                     &lt;/restriction>
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "sifConditionGroup"
    })
    public static class SIFWhere {

        @XmlElement(name = "SIF_ConditionGroup", namespace = "http://www.sifassociation.org/au/datamodel/1.4", required = true)
        protected SIFExtendedQueryType.SIFWhere.SIFConditionGroup sifConditionGroup;

        /**
         * Gets the value of the sifConditionGroup property.
         * 
         * @return
         *     possible object is
         *     {@link SIFExtendedQueryType.SIFWhere.SIFConditionGroup }
         *     
         */
        public SIFExtendedQueryType.SIFWhere.SIFConditionGroup getSIFConditionGroup() {
            return sifConditionGroup;
        }

        /**
         * Sets the value of the sifConditionGroup property.
         * 
         * @param value
         *     allowed object is
         *     {@link SIFExtendedQueryType.SIFWhere.SIFConditionGroup }
         *     
         */
        public void setSIFConditionGroup(SIFExtendedQueryType.SIFWhere.SIFConditionGroup value) {
            this.sifConditionGroup = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="SIF_Conditions" maxOccurs="unbounded">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="SIF_Condition" maxOccurs="unbounded">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="SIF_Element">
         *                               &lt;complexType>
         *                                 &lt;simpleContent>
         *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>normalizedString">
         *                                     &lt;attribute name="ObjectName" use="required" type="{http://www.sifassociation.org/au/datamodel/1.4}ObjectNameType" />
         *                                   &lt;/extension>
         *                                 &lt;/simpleContent>
         *                               &lt;/complexType>
         *                             &lt;/element>
         *                             &lt;element name="SIF_Operator">
         *                               &lt;simpleType>
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
         *                                   &lt;enumeration value="EQ"/>
         *                                   &lt;enumeration value="LT"/>
         *                                   &lt;enumeration value="GT"/>
         *                                   &lt;enumeration value="LE"/>
         *                                   &lt;enumeration value="GE"/>
         *                                   &lt;enumeration value="NE"/>
         *                                 &lt;/restriction>
         *                               &lt;/simpleType>
         *                             &lt;/element>
         *                             &lt;element name="SIF_Value" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                           &lt;/sequence>
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                 &lt;/sequence>
         *                 &lt;attribute name="Type" use="required">
         *                   &lt;simpleType>
         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
         *                       &lt;enumeration value="And"/>
         *                       &lt;enumeration value="Or"/>
         *                       &lt;enumeration value="None"/>
         *                     &lt;/restriction>
         *                   &lt;/simpleType>
         *                 &lt;/attribute>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *       &lt;attribute name="Type" use="required">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
         *             &lt;enumeration value="And"/>
         *             &lt;enumeration value="Or"/>
         *             &lt;enumeration value="None"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "sifConditions"
        })
        public static class SIFConditionGroup {

            @XmlElement(name = "SIF_Conditions", namespace = "http://www.sifassociation.org/au/datamodel/1.4", required = true)
            protected List<SIFExtendedQueryType.SIFWhere.SIFConditionGroup.SIFConditions> sifConditions;
            @XmlAttribute(name = "Type", required = true)
            @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
            protected String type;

            /**
             * Gets the value of the sifConditions property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the sifConditions property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getSIFConditions().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link SIFExtendedQueryType.SIFWhere.SIFConditionGroup.SIFConditions }
             * 
             * 
             */
            public List<SIFExtendedQueryType.SIFWhere.SIFConditionGroup.SIFConditions> getSIFConditions() {
                if (sifConditions == null) {
                    sifConditions = new ArrayList<SIFExtendedQueryType.SIFWhere.SIFConditionGroup.SIFConditions>();
                }
                return this.sifConditions;
            }

            /**
             * Gets the value of the type property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getType() {
                return type;
            }

            /**
             * Sets the value of the type property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setType(String value) {
                this.type = value;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="SIF_Condition" maxOccurs="unbounded">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="SIF_Element">
             *                     &lt;complexType>
             *                       &lt;simpleContent>
             *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>normalizedString">
             *                           &lt;attribute name="ObjectName" use="required" type="{http://www.sifassociation.org/au/datamodel/1.4}ObjectNameType" />
             *                         &lt;/extension>
             *                       &lt;/simpleContent>
             *                     &lt;/complexType>
             *                   &lt;/element>
             *                   &lt;element name="SIF_Operator">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
             *                         &lt;enumeration value="EQ"/>
             *                         &lt;enumeration value="LT"/>
             *                         &lt;enumeration value="GT"/>
             *                         &lt;enumeration value="LE"/>
             *                         &lt;enumeration value="GE"/>
             *                         &lt;enumeration value="NE"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="SIF_Value" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                 &lt;/sequence>
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *       &lt;/sequence>
             *       &lt;attribute name="Type" use="required">
             *         &lt;simpleType>
             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
             *             &lt;enumeration value="And"/>
             *             &lt;enumeration value="Or"/>
             *             &lt;enumeration value="None"/>
             *           &lt;/restriction>
             *         &lt;/simpleType>
             *       &lt;/attribute>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "sifCondition"
            })
            public static class SIFConditions {

                @XmlElement(name = "SIF_Condition", namespace = "http://www.sifassociation.org/au/datamodel/1.4", required = true)
                protected List<SIFExtendedQueryType.SIFWhere.SIFConditionGroup.SIFConditions.SIFCondition> sifCondition;
                @XmlAttribute(name = "Type", required = true)
                @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
                protected String type;

                /**
                 * Gets the value of the sifCondition property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the sifCondition property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getSIFCondition().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link SIFExtendedQueryType.SIFWhere.SIFConditionGroup.SIFConditions.SIFCondition }
                 * 
                 * 
                 */
                public List<SIFExtendedQueryType.SIFWhere.SIFConditionGroup.SIFConditions.SIFCondition> getSIFCondition() {
                    if (sifCondition == null) {
                        sifCondition = new ArrayList<SIFExtendedQueryType.SIFWhere.SIFConditionGroup.SIFConditions.SIFCondition>();
                    }
                    return this.sifCondition;
                }

                /**
                 * Gets the value of the type property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getType() {
                    return type;
                }

                /**
                 * Sets the value of the type property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setType(String value) {
                    this.type = value;
                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *       &lt;sequence>
                 *         &lt;element name="SIF_Element">
                 *           &lt;complexType>
                 *             &lt;simpleContent>
                 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>normalizedString">
                 *                 &lt;attribute name="ObjectName" use="required" type="{http://www.sifassociation.org/au/datamodel/1.4}ObjectNameType" />
                 *               &lt;/extension>
                 *             &lt;/simpleContent>
                 *           &lt;/complexType>
                 *         &lt;/element>
                 *         &lt;element name="SIF_Operator">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
                 *               &lt;enumeration value="EQ"/>
                 *               &lt;enumeration value="LT"/>
                 *               &lt;enumeration value="GT"/>
                 *               &lt;enumeration value="LE"/>
                 *               &lt;enumeration value="GE"/>
                 *               &lt;enumeration value="NE"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="SIF_Value" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *       &lt;/sequence>
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "sifElement",
                    "sifOperator",
                    "sifValue"
                })
                public static class SIFCondition {

                    @XmlElement(name = "SIF_Element", namespace = "http://www.sifassociation.org/au/datamodel/1.4", required = true)
                    protected SIFExtendedQueryType.SIFWhere.SIFConditionGroup.SIFConditions.SIFCondition.SIFElement sifElement;
                    @XmlElement(name = "SIF_Operator", namespace = "http://www.sifassociation.org/au/datamodel/1.4", required = true)
                    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
                    protected String sifOperator;
                    @XmlElement(name = "SIF_Value", namespace = "http://www.sifassociation.org/au/datamodel/1.4", required = true)
                    protected String sifValue;

                    /**
                     * Gets the value of the sifElement property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link SIFExtendedQueryType.SIFWhere.SIFConditionGroup.SIFConditions.SIFCondition.SIFElement }
                     *     
                     */
                    public SIFExtendedQueryType.SIFWhere.SIFConditionGroup.SIFConditions.SIFCondition.SIFElement getSIFElement() {
                        return sifElement;
                    }

                    /**
                     * Sets the value of the sifElement property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link SIFExtendedQueryType.SIFWhere.SIFConditionGroup.SIFConditions.SIFCondition.SIFElement }
                     *     
                     */
                    public void setSIFElement(SIFExtendedQueryType.SIFWhere.SIFConditionGroup.SIFConditions.SIFCondition.SIFElement value) {
                        this.sifElement = value;
                    }

                    /**
                     * Gets the value of the sifOperator property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getSIFOperator() {
                        return sifOperator;
                    }

                    /**
                     * Sets the value of the sifOperator property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setSIFOperator(String value) {
                        this.sifOperator = value;
                    }

                    /**
                     * Gets the value of the sifValue property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getSIFValue() {
                        return sifValue;
                    }

                    /**
                     * Sets the value of the sifValue property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setSIFValue(String value) {
                        this.sifValue = value;
                    }


                    /**
                     * <p>Java class for anonymous complex type.
                     * 
                     * <p>The following schema fragment specifies the expected content contained within this class.
                     * 
                     * <pre>
                     * &lt;complexType>
                     *   &lt;simpleContent>
                     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>normalizedString">
                     *       &lt;attribute name="ObjectName" use="required" type="{http://www.sifassociation.org/au/datamodel/1.4}ObjectNameType" />
                     *     &lt;/extension>
                     *   &lt;/simpleContent>
                     * &lt;/complexType>
                     * </pre>
                     * 
                     * 
                     */
                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "", propOrder = {
                        "value"
                    })
                    public static class SIFElement {

                        @XmlValue
                        @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
                        @XmlSchemaType(name = "normalizedString")
                        protected String value;
                        @XmlAttribute(name = "ObjectName", required = true)
                        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
                        protected String objectName;

                        /**
                         * Gets the value of the value property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getValue() {
                            return value;
                        }

                        /**
                         * Sets the value of the value property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setValue(String value) {
                            this.value = value;
                        }

                        /**
                         * Gets the value of the objectName property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getObjectName() {
                            return objectName;
                        }

                        /**
                         * Sets the value of the objectName property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setObjectName(String value) {
                            this.objectName = value;
                        }

                    }

                }

            }

        }

    }

}
