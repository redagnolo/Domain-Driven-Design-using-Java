void main() {
    var historicoDeOperacoes = new ArrayList<String>();

    interface Calculo {
        float executar(float a, float b);
    }

    var operacoes = new EnumMap<Operacao, Calculo>(Operacao.class);
    operacoes.put(Operacao.SOMA, (a, b) -> a + b);
    operacoes.put(Operacao.SUBTRACAO, (a, b) -> a - b);
    operacoes.put(Operacao.MULTIPLICACAO, (a, b) -> a * b);
    operacoes.put(Operacao.DIVISAO, (a, b) -> a / b);
    operacoes.put(Operacao.POTENCIACAO, (a, b) -> (float) Math.pow(a, b));
    operacoes.put(Operacao.RESTO, (a, b) -> a % b);
    operacoes.put(Operacao.MAXIMO, (a, b) -> Math.max(a, b));
    operacoes.put(Operacao.MINIMO, (a, b) -> Math.min(a, b));
    operacoes.put(Operacao.MEDIA, (a, b) -> (a + b) / 2);

    while (true) {
        IO.println("""
                Calculadora v1.0, digite .exit para sair, -h para ver o histórico ou enter para continuar.
                """);
        var comando = IO.readln();

        if (comando.equals(".exit")) {
            System.exit(0);
        } else if (comando.equals("-h")) {
            IO.println("Histórico: ");
            for (var operacao : historicoDeOperacoes) {
                IO.println(operacao);
            }
        } else if (comando.isEmpty()) {

            // Proteção com try-catch: Jontex do usuário
            try {
                IO.println("Digite o primeiro número:");
                var n1 = IO.readln();
                var num1 = Float.parseFloat(n1);

                IO.println("Digite o segundo número:");
                var n2 = IO.readln();
                var num2 = Float.parseFloat(n2);

                IO.println("""
                          Digite a operação desejada:
                          +   | soma
                          -   | subtração
                          *   | multiplicação
                          /   | divisão
                        pow   | elevação
                          %   | resto
                        max   | maior valor
                        min   | menor valor
                        avg   | média
                        """);
                var simbolo = IO.readln();

                var op = Operacao.porSimbolo(simbolo);

                if (op == null) {
                    IO.println("Operação inválida!");
                    continue;
                }

                if ((op == Operacao.DIVISAO || op == Operacao.RESTO) && num2 == 0) {
                    IO.println("Divisão por zero é inválida!");
                    continue;
                }

                var calculo = operacoes.get(op);
                var resultado = calculo.executar(num1, num2);

                if (resultado % 1 == 0) {
                    IO.println(Math.round(resultado));
                } else {
                    IO.println(resultado);
                }

                historicoDeOperacoes.add(num1 + " " + simbolo + " " + num2 + " = " + resultado);

            } catch (NumberFormatException e) {
                IO.println("Erro: Por favor, digite apenas números reais!");
            }
        }
    }
}