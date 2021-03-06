package mnj.mfg.model.lovs;

import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Jan 29 18:58:40 PKT 2016
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class employLOVRowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        LastName {
            public Object get(employLOVRowImpl obj) {
                return obj.getLastName();
            }

            public void put(employLOVRowImpl obj, Object value) {
                obj.setLastName((String)value);
            }
        }
        ,
        Segment2 {
            public Object get(employLOVRowImpl obj) {
                return obj.getSegment2();
            }

            public void put(employLOVRowImpl obj, Object value) {
                obj.setSegment2((String)value);
            }
        }
        ,
        EmployeeNumber {
            public Object get(employLOVRowImpl obj) {
                return obj.getEmployeeNumber();
            }

            public void put(employLOVRowImpl obj, Object value) {
                obj.setEmployeeNumber((String)value);
            }
        }
        ,
        Name {
            public Object get(employLOVRowImpl obj) {
                return obj.getName();
            }

            public void put(employLOVRowImpl obj, Object value) {
                obj.setName((String)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(employLOVRowImpl object);

        public abstract void put(employLOVRowImpl object, Object value);

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


    public static final int LASTNAME = AttributesEnum.LastName.index();
    public static final int SEGMENT2 = AttributesEnum.Segment2.index();
    public static final int EMPLOYEENUMBER = AttributesEnum.EmployeeNumber.index();
    public static final int NAME = AttributesEnum.Name.index();

    /**
     * This is the default constructor (do not remove).
     */
    public employLOVRowImpl() {
    }

    /**
     * Gets the attribute value for the calculated attribute LastName.
     * @return the LastName
     */
    public String getLastName() {
        return (String) getAttributeInternal(LASTNAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute LastName.
     * @param value value to set the  LastName
     */
    public void setLastName(String value) {
        setAttributeInternal(LASTNAME, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Segment2.
     * @return the Segment2
     */
    public String getSegment2() {
        return (String) getAttributeInternal(SEGMENT2);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Segment2.
     * @param value value to set the  Segment2
     */
    public void setSegment2(String value) {
        setAttributeInternal(SEGMENT2, value);
    }

    /**
     * Gets the attribute value for the calculated attribute EmployeeNumber.
     * @return the EmployeeNumber
     */
    public String getEmployeeNumber() {
        return (String) getAttributeInternal(EMPLOYEENUMBER);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute EmployeeNumber.
     * @param value value to set the  EmployeeNumber
     */
    public void setEmployeeNumber(String value) {
        setAttributeInternal(EMPLOYEENUMBER, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Name.
     * @return the Name
     */
    public String getName() {
        return (String) getAttributeInternal(NAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Name.
     * @param value value to set the  Name
     */
    public void setName(String value) {
        setAttributeInternal(NAME, value);
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
