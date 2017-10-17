/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productsstream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author oracle
 */
public class Productsstream {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
    File directorio = new File("/home/oracle/NetBeansProjects/productsstream/archivos");
    File archivo = new File("/home/oracle/NetBeansProjects/productsstream/archivos/productos.txt");
    
    product po1 = new product("cod1","arandelas",3.0);
    product po2 = new product("cod2","parafusos",4.0);
    product po3 = new product();
 
    escritura(po1,archivo,true);
    escritura(po2,archivo,false);
    lectura(po3,archivo);
    }    
    
    static void carpeta(File directorio){
        
        if(directorio.exists())
            System.out.println("Directorio existente "+directorio.getPath());
        else
            directorio.mkdir();
    }
    
    static void archivo(File archivo) throws IOException{
        
        if(archivo.exists())
            System.out.println("Archivo de texto existente "+archivo.getPath());
        else
            archivo.createNewFile();

    }
    
    static void escritura(product po, File archivo, boolean añadir) throws FileNotFoundException, IOException{
        try (DataOutputStream grabar = new DataOutputStream (new BufferedOutputStream(new FileOutputStream(archivo, añadir)))) {
            grabar.writeUTF(po.getCodigo());
            grabar.writeUTF(po.getDescripcion());
            grabar.writeDouble(po.getPrezo());
        }
            System.out.println(""+po);
    }
    
    static void lectura(product por,File archivo) throws FileNotFoundException, IOException{
        DataInputStream lectura = new DataInputStream (new BufferedInputStream(new FileInputStream(archivo)));
        product po3 = new product();
        for(int i=0;i<2;i++){
            while(lectura.available()!=0){
                po3.setCodigo(lectura.readUTF());
                po3.setDescripcion(lectura.readUTF());
                po3.setPrezo(lectura.readDouble());
                System.out.println("Código:"+po3.getCodigo()+"Descripcion:"+po3.getDescripcion()+"Prezo: "+po3.getPrezo());
        
            }
        }
        
        
        
        
  
    }

        
        
} 

    

