public class Deporte {
    
    private String marca;
    private String modelo;
    private String material;
    private double talla;
    private double precio;

    public Deporte() {
    }

    public Deporte(String marca, String modelo, String material, double talla, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.material = material;
        this.talla = talla;
        this.precio = precio;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMaterial() {
        return this.material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getTalla() {
        return this.talla;
    }

    public void setTalla(double talla) {
        this.talla = talla;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Marca: " + getMarca() + "; " +
            "Modelo: " + getModelo() + "; " +
            "Material: " + getMaterial() + "; " +
            "Talla: " + getTalla() + "; " +
            "Precio: " + getPrecio() + " euros.";
    }

}
