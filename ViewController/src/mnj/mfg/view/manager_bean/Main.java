package mnj.mfg.view.manager_bean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import java.sql.SQLException;

import java.util.HashMap;
import java.util.StringTokenizer;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.faces.event.ValueChangeEvent;

import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCDataControl;
import oracle.adf.view.rich.component.rich.data.RichColumn;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputFile;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.adf.view.rich.util.ResetUtils;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;
import oracle.jbo.domain.Number;

import oracle.jdbc.OracleTypes;

import org.apache.myfaces.trinidad.model.UploadedFile;

public class Main {
    private RichInputText style;
    private RichInputText customerBuyerID;
    private RichInputText yds;
    private RichInputText markerwidth;
    private RichInputText markerefficiency;
    private RichInputText functionalarea;
    private RichInputText inches;
    private RichInputText markerId;
    private RichInputText meter;
    private RichInputText markerWidthMeter;
    private RichInputText markerAreaInch;
    private RichTable markerDetail;
    
    public Main() {
        super();
    }
    
    
    public void setCustomerIdS(RichInputText id){
        
        FacesContext fctx = FacesContext.getCurrentInstance();
        ExternalContext ectx = fctx.getExternalContext();
        HttpSession userSession = (HttpSession) ectx.getSession(false);
        userSession.setAttribute("CustomerIdS", id.getValue());    
    }


    public void setStyle(RichInputText style) {
        this.style = style;
        FacesContext fctx = FacesContext.getCurrentInstance();
        ExternalContext ectx = fctx.getExternalContext();
        HttpSession userSession = (HttpSession)ectx.getSession(false);
        userSession.setAttribute("style", style.getValue());
        //System.out.println("Session style-->"+style.getValue());
    }

    public RichInputText getStyle() {
        return style;
    }


    public void setCustomerBuyerID(RichInputText customerBuyerID) {
        this.customerBuyerID = customerBuyerID;
        setCustomerIdS(customerBuyerID);
    }

    public RichInputText getCustomerBuyerID() {
        return customerBuyerID;
    }

    public void setYds(RichInputText yds) {
        this.yds = yds;
    }

    public RichInputText getYds() {
        return yds;
    }

    public void setMarkerwidth(RichInputText markerwidth) {
        this.markerwidth = markerwidth;
    }

    public RichInputText getMarkerwidth() {
        return markerwidth;
    }

    public void setMarkerefficiency(RichInputText markerefficiency) {
        this.markerefficiency = markerefficiency;
    }

    public RichInputText getMarkerefficiency() {
        return markerefficiency;
    }

    public void setFunctionalarea(RichInputText functionalarea) {
        this.functionalarea = functionalarea;
    }

    public RichInputText getFunctionalarea() {
        return functionalarea;
    }

    public void valueChanger(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        double Yds = Double.parseDouble((getYds().getValue().toString()));
        double Inches = Double.parseDouble((getInches().getValue().toString()));
        double Markerwidth = Double.parseDouble((getMarkerwidth().getValue().toString()));
        double Markerefficiency = Double.parseDouble((getMarkerefficiency().getValue().toString()));
        double Markerwithinches = Double.parseDouble((getMarkerwidth().getValue().toString()));
       // double Markerwithmeter = Double.parseDouble((getMarkerWidthMeter().getValue().toString()));
       // double Meter = Double.parseDouble((getMeter().getValue().toString()));
        double ff = 0.0,gg = 0.0, ee = 0.0,  hh = 0.0,  MWM = 0.0, NN =0.0; 
        
        /// 17-05-2016 Sabih
        
   //     int val = Integer.parseInt(valueChangeEvent.getNewValue().toString()) ;
   //     System.out.println("RollLengthListenerInchesFabInsp");
   //     System.out.println(val);
        
        if( Inches  > 35 ){
            FacesContext context = FacesContext.getCurrentInstance();
            FacesMessage message = new FacesMessage("Can't Enter Value Greate than 35");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(valueChangeEvent.getComponent().getClientId(context), message);
            
            // Reset inputFile component after upload
            ResetUtils.reset(valueChangeEvent.getComponent());
        }else{
        ///
        
        ff = (Yds * 36);
        ee = ff + Inches ;
        gg = ((ee * Markerwidth) * Markerefficiency) / 100;
        hh = ee/39.37 ;
        MWM = Markerwithinches * 0.0254 ;
      //  NN = Inches * Markerwidth;
        
      NN = ee * Markerwidth;
        
        System.out.println("Yds "+Yds);
        System.out.println("ff "+ff);
        System.out.println("Inches "+Inches);
        System.out.println("ee "+ee);
        System.out.println("Markerwidth "+Markerwidth);
        System.out.println("Markerefficiency "+Markerefficiency);
        
        System.out.println("ABC "+gg);
       functionalarea.setValue(gg);   
        AdfFacesContext.getCurrentInstance().addPartialTarget(functionalarea);

        try {
            markerAreaInch.setValue(new oracle.jbo.domain.Number(NN));
            
        } catch (SQLException e) 
        {
            
        }

        try {
            markerWidthMeter.setValue(new oracle.jbo.domain.Number(MWM));
            markerAreaInch.setValue(new oracle.jbo.domain.Number(NN));
                    
        } catch (Exception e) {
            // TODO: Add catch code
        }   
         AdfFacesContext.getCurrentInstance().addPartialTarget(markerWidthMeter);
        AdfFacesContext.getCurrentInstance().addPartialTarget(markerAreaInch);

        try {
            meter.setValue(new oracle.jbo.domain.Number(hh));
            
        } catch (SQLException e) {
            
       } 
            
        }
        
        AdfFacesContext.getCurrentInstance().addPartialTarget(meter);
      
         
       // System.out.println("inch --->"+ff);
//System.out.println("after plus --->"+ee);
       // System.out.println("func area --->"+gg);
       // System.out.println("Meter calculate ---------->"+hh);
       // System.out.println("Marker Area Inches ---------->"+NN);
    }
    public static double numeric(RichInputText ob) {
             
             
             try{
             if (ob != null)
                 return Double.parseDouble(String.valueOf(ob.getValue()));
             else
                 return 0;
             }catch(Exception e){
                 ;    
             }
             
             return 0;
         }
    
      
        public static Number toNumber(double n){


              try {
                  return new Number(n);
              } catch (SQLException e) {
                  ;
              }
              return new Number(0);
          }
        
        

    public void setInches(RichInputText inches) {
        this.inches = inches;
    }

    public RichInputText getInches() {
        return inches;
    }

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public String Save() {
        BindingContext bindingContext = BindingContext.getCurrent();
        DCDataControl dc =bindingContext.findDataControl("AppModuleDataControl"); //
        ApplicationModule am = dc.getApplicationModule();
        ViewObject LiveVo =am.findViewObject("LinesVO1");//ImpSaleContractDetailEOView1
        LiveVo.clearCache();
        getAllCalculations();
        
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("Commit");
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
        return null;
        
    }

    public void setMarkerId(RichInputText markerId) {
        this.markerId = markerId;
    }

    public RichInputText getMarkerId() {
        return markerId;
    }

    public void setMeter(RichInputText meter) {
        this.meter = meter;
    }

    public RichInputText getMeter() {
        return meter;
    }

    public void setMarkerWidthMeter(RichInputText markerWidthMeter) {
        this.markerWidthMeter = markerWidthMeter;
    }

    public RichInputText getMarkerWidthMeter() {
        return markerWidthMeter;
    }

    public void setMarkerAreaInch(RichInputText markerAreaInch) {
        this.markerAreaInch = markerAreaInch;
    }

    public RichInputText getMarkerAreaInch() {
        return markerAreaInch;
    }

  
    public void fileUploadMarker(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        //System.out.println("Roll Upload");
        
       
      //  System.out.println("Buyer Description --->" + getBuyerDescription(2112));
                            
        
        UploadedFile file = (UploadedFile)valueChangeEvent.getNewValue();
        try {

            parseFile(file.getInputStream());
            AdfFacesContext.getCurrentInstance().addPartialTarget(markerDetail);

        } catch (IOException e) {
            // TODO add more
        }
    }


    public void parseFile(java.io.InputStream file) {


        System.out.println("Parse File --->" + file);

        BufferedReader reader =
            new BufferedReader(new InputStreamReader(file));
        String strLine = "";
        StringTokenizer st = null;
        int lineNumber = 0, tokenNumber = 0;
        Row hrw = null, lineRow = null;

        HashMap map = new HashMap();
        BindingContext bindingContext = BindingContext.getCurrent();
        DCDataControl dc =
            bindingContext.findDataControl("AppModuleDataControl");
        ApplicationModule am = dc.getApplicationModule();

        ViewObject lineVo = am.findViewObject("LinesVO1");


        try {
            while ((strLine = reader.readLine()) != null) {
                lineNumber++;
                st = new StringTokenizer(strLine, ",");
                System.out.println("Line No --->" + lineNumber);
                if (lineNumber > 1) {
                    hrw = lineVo.createRow();
                    hrw.setNewRowState(Row.STATUS_INITIALIZED);
                    lineVo.insertRow(hrw);
                }
/*  */


                double ff = 0.0,gg = 0.0, ee = 0.0,  hh = 0.0,  
                       MWM = 0.0, NN =0.0,vYds =0.0,vInches =0.0,
                     vMarkerwidth=0.0 ,vMarkerefficiency=0.0 ; 

                while (st.hasMoreTokens()) 
                {
                    //display csv values
                    tokenNumber++;


                    String theToken = st.nextToken();

                    
                    if (lineNumber > 1)
                    {
                      
                      System.out.println
                          (
                           "Line No Case ---> " + lineNumber +
                           " tokenNumber ---> " + tokenNumber +
                           " theToken ---> "    + theToken
                           );
                      
                       switch (tokenNumber) 
                        {
                        case 1:
                            hrw.setAttribute("Season",theToken);
                            break ;
                        case 2:
                                hrw.setAttribute("StyleName",theToken);
                                break ;
                        case 3:
                            hrw.setAttribute("Attribute1", theToken);
                         break ;
                        case 4:
                            hrw.setAttribute("Brand", theToken);
                            break ;
                        case 5:
                            hrw.setAttribute("MarkerPlanNumber", theToken);
                            break ;
                        
                        case 6:
                            hrw.setAttribute("MarkerId", theToken);
                            break ;
                        case 7:
                            hrw.setAttribute("Yds", theToken);
                            break ;
                        case 8:
                            
                            hrw.setAttribute("Inch", theToken);
                           
                            break ;
                        case 9:
                            hrw.setAttribute("MarkerWidth", theToken);
                           break ;
                        case 10:
                            hrw.setAttribute("MarkerEfficiency", theToken);
                        
                            break ;
                        case 11:
                            hrw.setAttribute("ShrinkagePattern", theToken);
                        break;
                        case 12:
                            hrw.setAttribute("Remarks", theToken);
                         break ;
                            
                        }

                    }  
                }
                
  /*
                System.out.println("Before --->" + vMarkerefficiency);
                System.out.println("Before 1 --->" + vYds);
                           
                ff = (vYds * 36);
                ee = ff + vInches ;
                gg = ((ee * vMarkerwidth) * vMarkerefficiency) / 100;
                hh = ee/39.37 ;
                MWM = vMarkerwidth * 0.0254 ;
                NN = vInches * vMarkerwidth;
                
                System.out.println("after --->" +ff +ee+gg+hh);
                System.out.println("after 2 --->" +MWM +NN);
                
                
                hrw.setAttribute("MarkerAreaInch", NN);
                hrw.setAttribute("MarkerWidthMeter", MWM);
                hrw.setAttribute("FunctionalArea", gg);
                
                System.out.println("after --->" +ff +ee+gg+hh);
                System.out.println("after 2 --->" +MWM +NN);
                
                AdfFacesContext.getCurrentInstance().addPartialTarget(functionalarea);
                AdfFacesContext.getCurrentInstance().addPartialTarget(markerWidthMeter);
                AdfFacesContext.getCurrentInstance().addPartialTarget(markerAreaInch);
                
*/

                tokenNumber = 0;
            }
            map = null;
            reader = null;

        } catch (Exception e) {
            FacesContext fctx = FacesContext.getCurrentInstance();
            fctx.addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Data Error in Uploaded file",
                                             e.getMessage()));

        }

    } 


    /*****************
     * File uploading Code
     * *****************************/
    public void setMarkerDetail(RichTable markerDetail) {
        this.markerDetail = markerDetail;
    }

    public RichTable getMarkerDetail() {
        return markerDetail;
    }

// All Calculation on Save Button
     // Sabih - 03-08-2016
    
     public void getAllCalculations() {

         BindingContext bindingContext = BindingContext.getCurrent();
         DCDataControl dc =bindingContext.findDataControl("AppModuleDataControl"); //
         ApplicationModule am = dc.getApplicationModule();
         ViewObject findViewObject =am.findViewObject("LinesVO1");//ImpSaleContractDetailEOView1
         
         RowSetIterator it = findViewObject.createRowSetIterator("tt");
         double val = 0.0, total = 0.0;
         while (it.hasNext())
         {
          Row r = it.next();
          try {
              
                  double Yds              = Double.parseDouble(r.getAttribute("Yds").toString());
                  double Inches           = Double.parseDouble(r.getAttribute("Inch").toString());
                  double Markerwidth      = Double.parseDouble(r.getAttribute("MarkerWidth").toString());
                  double Markerefficiency = Double.parseDouble(r.getAttribute("MarkerEfficiency").toString());
                  double Markerwithinches = Double.parseDouble(r.getAttribute("MarkerWidth").toString());
                  // double Markerwithmeter = Double.parseDouble((getMarkerWidthMeter().getValue().toString()));
                  // double Meter           = Double.parseDouble((getMeter().getValue().toString()));
                  double ff = 0.0,gg = 0.0, ee = 0.0,  hh = 0.0,  MWM = 0.0, NN =0.0; 
                  
                  /// 17-05-2016 Sabih
                  
                  //     int val = Integer.parseInt(valueChangeEvent.getNewValue().toString()) ;
                  //     System.out.println("RollLengthListenerInchesFabInsp");
                  //     System.out.println(val);
                  
                 
                  ///
                  
                  ff = (Yds * 36);
                  ee = ff + Inches ;
                  gg = ((ee * Markerwidth) * Markerefficiency) / 100;
                  hh = ee/39.37 ;
                  MWM = Markerwithinches * 0.0254 ;
                  //  NN = Inches * Markerwidth;
                  
                  NN = ee * Markerwidth;
                  
                  System.out.println("Yds "+Yds);
                  System.out.println("ff "+ff);
                  System.out.println("Inches "+Inches);
                  System.out.println("ee "+ee);
                  System.out.println("Markerwidth "+Markerwidth);
                  System.out.println("Markerefficiency "+Markerefficiency);
                  
                  System.out.println("ABC "+gg);
                  
                  r.setAttribute("FunctionalArea",gg);

                  try 
                  {
                      
                      r.setAttribute("MarkerAreaInch",NN);
                      
                                  
                      } catch (Exception e) {
                          // TODO: Add catch code
                          ;
                      } 

                  try
                  {
                      
                      r.setAttribute("MarkerWidthMeter",MWM);
                      r.setAttribute("MarkerAreaInch",NN);
                              
                  } catch (Exception e) {
                      // TODO: Add catch code
                      ;
                  }   

                  try 
                  {
                     r.setAttribute("Meter",hh);
                      
                      } catch (Exception e) {
                          // TODO: Add catch code
                          ;
                      }  
              
              }catch (Exception e ){;}
             
         } //end of while loop

         AdfFacesContext.getCurrentInstance().addPartialTarget(markerDetail);
         
         it.closeRowSetIterator();
     } 
    


}
