package DAO;

import BEAN.TrabajadorBean;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;
import java.sql.*;
import org.eclipse.jdt.internal.compiler.apt.util.ArchiveFileObject;

public class TrabajadorDAO {
  
    File archivo=null;// variable de tipo archivo
    FileWriter escribir;
    PrintWriter linea;    
    FileReader fr;
    BufferedReader br;
   
    ArrayList<TrabajadorBean> listaTrab=new ArrayList<>();

    public void EscribeFichero(TrabajadorBean objRegionBean) {
        archivo = new File("C:\\archivo\\archivo.txt");
        if (!archivo.exists())
        {
            try
            {
                archivo.createNewFile();
                escribir = new FileWriter(archivo, true);// true si ya existe, escribe al final, sirve para escribir en una sola liena de texto
                linea = new PrintWriter(escribir);// sirve para escribir en varias lineas de texto
                // escribimos en el archivo.
                linea.println(objRegionBean.getCODTRABAJADOR()+ ";"
                        + objRegionBean.getNOMBTRABAJADOR()+ ";" + objRegionBean.getSUELDOTRABAJADOR());
                linea.close();
                escribir.close();

            } catch (Exception e)
            {
            }
        } else
        {// si es que existe ya no se crea el archivo.createNewFile();
            try
            {

                escribir = new FileWriter(archivo,true);
                
                linea = new PrintWriter(escribir);
                // escribimos en el archivo.
                linea.println(objRegionBean.getCODTRABAJADOR()+ ";"
                        + objRegionBean.getNOMBTRABAJADOR()+ ";" + objRegionBean.getSUELDOTRABAJADOR());
                linea.close();
                escribir.close();                
            } catch (Exception e)
            {
            }
        }

    }

    public ArrayList<TrabajadorBean> LeeFichero() {
       
       // File archivo;              
        try
        {
            archivo = new File("C:\\archivo\\archivo.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String  linea = "";
           
            String cod;
            String nombre;
            String estado;
            while ((linea=br.readLine()) !=null)               
            {
                
                    String []info=linea.split(";");
                    cod=  info[0];
                    nombre=info[1];
                    estado=info[2];
                    int codIn=Integer.parseInt(cod);
                    TrabajadorBean obj=new TrabajadorBean(codIn,nombre,estado);
                    listaTrab.add(obj);                    
            }
             br.close();
             fr.close();
        } catch (Exception e)
        {
        }
        return listaTrab;
    }

}
