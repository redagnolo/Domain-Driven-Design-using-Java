public enum Operacao {
    SOMA,
    SUBTRACAO,
    MULTIPLICACAO,
    DIVISAO,
    POTENCIACAO,
    RESTO,
    MAXIMO,
    MINIMO,
    MEDIA;

    public static Operacao porSimbolo(String simbolo) {
        return switch (simbolo) {
            case "+" -> SOMA;
            case "-" -> SUBTRACAO;
            case "*" -> MULTIPLICACAO;
            case "/" -> DIVISAO;
            case "pow" -> POTENCIACAO;
            case "%" -> RESTO;
            case "max" -> MAXIMO;
            case "min" -> MINIMO;
            case "avg" -> MEDIA;
            default -> null;
        };
    }
}
