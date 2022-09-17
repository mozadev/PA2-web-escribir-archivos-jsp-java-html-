
package BEAN;

public class TrabajadorBean {
   
    int CODTRABAJADOR;
    String NOMBTRABAJADOR;
    String SUELDOTRABAJADOR;

    public TrabajadorBean(int CODCARRERA, String NOMBCARRERA, String ESTADOCARRERA) {
        this.CODTRABAJADOR = CODCARRERA;
        this.NOMBTRABAJADOR = NOMBCARRERA;
        this.SUELDOTRABAJADOR = ESTADOCARRERA;
    }

    public int getCODTRABAJADOR() {
        return CODTRABAJADOR;
    }

    public void setCODTRABAJADOR(int CODTRABAJADOR) {
        this.CODTRABAJADOR = CODTRABAJADOR;
    }

    public String getNOMBTRABAJADOR() {
        return NOMBTRABAJADOR;
    }

    public void setNOMBTRABAJADOR(String NOMBTRABAJADOR) {
        this.NOMBTRABAJADOR = NOMBTRABAJADOR;
    }

    public String getSUELDOTRABAJADOR() {
        return SUELDOTRABAJADOR;
    }

    public void setSUELDOTRABAJADOR(String SUELDOTRABAJADOR) {
        this.SUELDOTRABAJADOR = SUELDOTRABAJADOR;
    }

}
