package mnj.mfg.model.server.client;

import mnj.mfg.model.server.common.AppModule;

import oracle.jbo.client.remote.ApplicationModuleImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Mar 30 12:54:20 PKT 2016
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class AppModuleClient extends ApplicationModuleImpl implements AppModule {
    /**
     * This is the default constructor (do not remove).
     */
    public AppModuleClient() {
    }

    public String getUnitName(String orgId) {
        Object _ret =
            this.riInvokeExportedMethod(this,"getUnitName",new String [] {"java.lang.String"},new Object[] {orgId});
        return (String)_ret;
    }

    public void setSessionValues(String orgId, String userId, String respId,
                                 String respAppl) {
        Object _ret =
            this.riInvokeExportedMethod(this,"setSessionValues",new String [] {"java.lang.String","java.lang.String","java.lang.String","java.lang.String"},new Object[] {orgId, userId, respId, respAppl});
        return;
    }
}
