package Viajes;



public class Puerto {
	private int codigo;
    private String nombre;
    private String pais;

    //el constructor recibe el array de string de un csv
    public Puerto(String[] datos){
        this.codigo = Integer.parseInt(datos[0]);
        this.nombre = datos[1];
        this.pais = datos[2];
    }
    
    //constructor para agregar un puerto por consola
    public Puerto(int ncodigo, String nmombre, String nPais){
        this.codigo = ncodigo;
        this.nombre = nmombre;
        this.pais = nPais;
    }

    int getCodigo(){return this.codigo;}
    
    public String getNombre(){return this.nombre;}

    //pisamos el método toString para mostrar el puerto
    @Override
    public String toString() {
        return "Puerto{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}
