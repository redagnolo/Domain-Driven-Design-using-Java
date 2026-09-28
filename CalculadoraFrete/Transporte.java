public class Transporte {
    private String modal;
    private String placa;
    private int capacidadeEmL;
    private int capacidadeEmKg;

    public Transporte(String modal, String placa, int capacidadeEmL, int capacidadeEmKg) {
        if(capacidadeEmKg < 0 || capacidadeEmL < 0)
            throw new IllegalArgumentException();

        this.modal = modal;
        this.placa = placa;
        this.capacidadeEmL = capacidadeEmL;
        this.capacidadeEmKg = capacidadeEmKg;
    }

    public String getModal() {
        return modal;
    }

    public void setModal(String modal) {
        this.modal = modal;
    }

    public String getPlaca() {
        return placa + "-";
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getCapacidadeEmL() {
        return capacidadeEmL;
    }

    public void setCapacidadeEmL(int capacidadeEmL) {
        if(capacidadeEmKg < 0 || capacidadeEmL < 0)
            throw new IllegalArgumentException();
        this.capacidadeEmL = capacidadeEmL;
    }

    public int getCapacidadeEmKg() {
        if(capacidadeEmKg < 0 || capacidadeEmL < 0)
            throw new IllegalArgumentException();
        return capacidadeEmKg;
    }

    public void setCapacidadeEmKg(int capacidadeEmKg) {
        this.capacidadeEmKg = capacidadeEmKg;
    }

    @Override
    public String toString() {
        return "Transporte{" +
                "modal='" + modal + '\'' +
                ", placa='" + placa + '\'' +
                ", capacidadeEmL=" + capacidadeEmL +
                ", capacidadeEmKg=" + capacidadeEmKg +
                '}';
    }
}