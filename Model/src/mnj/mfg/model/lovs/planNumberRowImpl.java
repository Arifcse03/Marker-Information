package mnj.mfg.model.lovs;

import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Jan 29 19:59:29 PKT 2016
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class planNumberRowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        CutNo {
            public Object get(planNumberRowImpl obj) {
                return obj.getCutNo();
            }

            public void put(planNumberRowImpl obj, Object value) {
                obj.setCutNo((String)value);
            }
        }
        ,
        RatioplanNumber {
            public Object get(planNumberRowImpl obj) {
                return obj.getRatioplanNumber();
            }

            public void put(planNumberRowImpl obj, Object value) {
                obj.setRatioplanNumber((String)value);
            }
        }
        ,
        Style {
            public Object get(planNumberRowImpl obj) {
                return obj.getStyle();
            }

            public void put(planNumberRowImpl obj, Object value) {
                obj.setStyle((String)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(planNumberRowImpl object);

        public abstract void put(planNumberRowImpl object, Object value);

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


    public static final int CUTNO = AttributesEnum.CutNo.index();
    public static final int RATIOPLANNUMBER = AttributesEnum.RatioplanNumber.index();
    public static final int STYLE = AttributesEnum.Style.index();

    /**
     * This is the default constructor (do not remove).
     */
    public planNumberRowImpl() {
    }

    /**
     * Gets the attribute value for the calculated attribute CutNo.
     * @return the CutNo
     */
    public String getCutNo() {
        return (String) getAttributeInternal(CUTNO);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute CutNo.
     * @param value value to set the  CutNo
     */
    public void setCutNo(String value) {
        setAttributeInternal(CUTNO, value);
    }

    /**
     * Gets the attribute value for the calculated attribute RatioplanNumber.
     * @return the RatioplanNumber
     */
    public String getRatioplanNumber() {
        return (String) getAttributeInternal(RATIOPLANNUMBER);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute RatioplanNumber.
     * @param value value to set the  RatioplanNumber
     */
    public void setRatioplanNumber(String value) {
        setAttributeInternal(RATIOPLANNUMBER, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Style.
     * @return the Style
     */
    public String getStyle() {
        return (String) getAttributeInternal(STYLE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Style.
     * @param value value to set the  Style
     */
    public void setStyle(String value) {
        setAttributeInternal(STYLE, value);
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
