/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TPO_02;

/**
 *
 * @author Corrales Ulises
 */
public class Jaula {
    private final Hamaca hamaca;
    private final Plato plato;
    private final Rueda rueda;

    public Jaula() {
        this.hamaca = new Hamaca();
        this.plato = new Plato();
        this.rueda = new Rueda();
    }

    public Hamaca getH() {
        return hamaca;
    }

    public Plato getP() {
        return plato;
    }

    public Rueda getR() {
        return rueda;
    }
    
    
}
