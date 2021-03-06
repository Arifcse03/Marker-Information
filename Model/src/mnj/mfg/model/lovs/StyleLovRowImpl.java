package mnj.mfg.model.lovs;

import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Jan 29 15:01:23 PKT 2016
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class StyleLovRowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        StyleName {
            public Object get(StyleLovRowImpl obj) {
                return obj.getStyleName();
            }

            public void put(StyleLovRowImpl obj, Object value) {
                obj.setStyleName((String)value);
            }
        }
        ,
        Season {
            public Object get(StyleLovRowImpl obj) {
                return obj.getSeason();
            }

            public void put(StyleLovRowImpl obj, Object value) {
                obj.setSeason((String)value);
            }
        }
        ,
        BuyerD {
            public Object get(StyleLovRowImpl obj) {
                return obj.getBuyerD();
            }

            public void put(StyleLovRowImpl obj, Object value) {
                obj.setBuyerD((Number)value);
            }
        }
        ,
        CustomerName {
            public Object get(StyleLovRowImpl obj) {
                return obj.getCustomerName();
            }

            public void put(StyleLovRowImpl obj, Object value) {
                obj.setCustomerName((String)value);
            }
        }
        ,
        StyleDescription {
            public Object get(StyleLovRowImpl obj) {
                return obj.getStyleDescription();
            }

            public void put(StyleLovRowImpl obj, Object value) {
                obj.setStyleDescription((String)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(StyleLovRowImpl object);

        public abstract void put(StyleLovRowImpl object, Object value);

        public int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        public static int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        public static AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }


    public static final int STYLENAME = AttributesEnum.StyleName.index();
    public static final int SEASON = AttributesEnum.Season.index();
    public static final int BUYERD = AttributesEnum.BuyerD.index();
    public static final int CUSTOMERNAME = AttributesEnum.CustomerName.index();
    public static final int STYLEDESCRIPTION = AttributesEnum.StyleDescription.index();

    /**
     * This is the default constructor (do not remove).
     */
    public StyleLovRowImpl() {
    }

    /**
     * Gets the attribute value for the calculated attribute StyleName.
     * @return the StyleName
     */
    public String getStyleName() {
        return (String) getAttributeInternal(STYLENAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute StyleName.
     * @param value value to set the  StyleName
     */
    public void setStyleName(String value) {
        setAttributeInternal(STYLENAME, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Season.
     * @return the Season
     */
    public String getSeason() {
        return (String) getAttributeInternal(SEASON);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Season.
     * @param value value to set the  Season
     */
    public void setSeason(String value) {
        setAttributeInternal(SEASON, value);
    }

    /**
     * Gets the attribute value for the calculated attribute BuyerD.
     * @return the BuyerD
     */
    public Number getBuyerD() {
        return (Number) getAttributeInternal(BUYERD);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute BuyerD.
     * @param value value to set the  BuyerD
     */
    public void setBuyerD(Number value) {
        setAttributeInternal(BUYERD, value);
    }

    /**
     * Gets the attribute value for the calculated attribute CustomerName.
     * @return the CustomerName
     */
    public String getCustomerName() {
        return (String) getAttributeInternal(CUSTOMERNAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute CustomerName.
     * @param value value to set the  CustomerName
     */
    public void setCustomerName(String value) {
        setAttributeInternal(CUSTOMERNAME, value);
    }

    /**
     * Gets the attribute value for the calculated attribute StyleDescription.
     * @return the StyleDescription
     */
    public String getStyleDescription() {
        return (String) getAttributeInternal(STYLEDESCRIPTION);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute StyleDescription.
     * @param value value to set the  StyleDescription
     */
    public void setStyleDescription(String value) {
        setAttributeInternal(STYLEDESCRIPTION, value);
    }

    /**
     * getAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param attrDef the attribute

     * @return the attribute value
     * @throws Exception
     */
    protected Object getAttrInvokeAccessor(int index,
                                           AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            return AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].get(this);
        }
        return super.getAttrInvokeAccessor(index, attrDef);
    }

    /**
     * setAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param value the value to assign to the attribute
     * @param attrDef the attribute

     * @throws Exception
     */
    protected void setAttrInvokeAccessor(int index, Object value,
                                         AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].put(this, value);
            return;
        }
        super.setAttrInvokeAccessor(index, value, attrDef);
    }
}
