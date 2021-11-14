package Viajes;

public class Viaje {
    private int codigoDest;
    private String destino;
    private int costo, diasViaje;

    public Viaje(String[] partes){
        this.codigoDest = Integer.parseInt(partes[1]);
        this.destino = partes[2];
        this.diasViaje = Integer.parseInt(partes[3]);
        this.costo = Integer.parseInt(partes[4]);
    }

    public Viaje(int codDestino, String nDestino, int nDiasViaje, int costo){
        this.codigoDest = codDestino;
        this.destino = nDestino;
        this.diasViaje = nDiasViaje;
        this.costo = costo;
    }
    
    public int getCosto(){return costo;}
    public String getDestino() { return destino; }
    public int getDiasViaje(){return diasViaje;}
    public int getCodigoDest(){return codigoDest;}
    
    

    @Override
    public String toString() {
        return "   Viaje{" +
                "codigoDest=" + codigoDest +
                ", destino='" + destino + '\'' +
                ", costo=" + costo +
                ", diasViaje=" + diasViaje +
                '}';
    }
}
