void main() {
    var caminhao = new Transporte(
    "Caminhao Volvo Modelo X",
    "GFZ6D90",
    600,
    600);

    caminhao.setCapacidadeEmKg(-600);

    IO.println(caminhao.getCapacidadeEmKg());
}