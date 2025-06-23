package calculadora;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OperacoesTest {

    Operacoes operacao = new Operacoes();

    @Test //Testa se a função reconhece a operação de adição.
    public void testTemOperacaoAdicao(){

        char[] dados = new char[]{'1', '2', '+', '2', '4'};

        boolean resultado = operacao.temOperacao(dados,1, 5, false);

        assertTrue(resultado);
    }

    @Test //Testa se a função reconhece a operação de subtração.
    public void testTemOperacaoSubtracao(){

        char[] dados = new char[]{'1', '2', '-', '2', '4'};

        boolean resultado = operacao.temOperacao(dados,1, 5, false);

        assertTrue(resultado);
    }

    @Test //Testa se a função reconhece a operação de multiplicação.
    public void testTemOperacaoMultiplicacao(){

        char[] dados = new char[]{'1', '2', '*', '2', '4'};

        boolean resultado = operacao.temOperacao(dados,1, 5, false);

        assertTrue(resultado);
    }

    @Test //Testa se a função reconhece a operação de divisão.
    public void testTemOperacaoDivisao(){

        char[] dados = new char[]{'1', '2', '/', '2', '4'};

        boolean resultado = operacao.temOperacao(dados,1, 5, false);

        assertTrue(resultado);
    }

    @Test //Testa se não ativa com número negativo somente.
    public void testTemOperacao(){

        char[] dados = new char[]{'-', '1', '2', '3', '4'};

        boolean resultado = operacao.temOperacao(dados,1, 5, false);

        assertFalse(resultado);
    }

    @Test //Testa se está operando corretamente com adição.
    public void testOperarAdicao(){

        char[] dados = new char[]{'2', '4', '+', '1', '2'};
        char[] resultado = new char[2];
        char[] esperado = new char[]{'3','6'};

        resultado = operacao.verificaOperacao(dados,0, 4);

        assertArrayEquals(esperado, resultado);
    }

    @Test //Testa se está operando corretamente com adição com 2º número negativo.
    public void testOperarAdicaoPN(){

        char[] dados = new char[]{'4', '+', '-', '2'};
        char[] resultado = new char[1];
        char[] esperado = new char[]{'2'};

        resultado = operacao.verificaOperacao(dados,0, 3);

        assertArrayEquals(esperado, resultado);
    }

    @Test //Testa se está operando corretamente com adição com 2º número negativo.
    public void testOperarAdicaoNP(){

        char[] dados = new char[]{'-','4', '+', '2'};
        char[] resultado = new char[1];
        char[] esperado = new char[]{'-','2'};

        resultado = operacao.verificaOperacao(dados,0, 3);

        assertArrayEquals(esperado, resultado);
    }

    @Test //Testa se está operando corretamente com adição com 2º número negativo.
    public void testOperarAdicaoNN(){

        char[] dados = new char[]{'-','4', '+', '-', '2'};
        char[] resultado = new char[2];
        char[] esperado = new char[]{'-','6'};

        resultado = operacao.verificaOperacao(dados,0, 4);

        assertArrayEquals(esperado, resultado);
    }

    @Test //Testa se está operando corretamente com subtração.
    public void testOperarSubtracao(){

        char[] dados = new char[]{'2', '4', '-', '1', '2'};
        char[] resultado = new char[2];
        char[] esperado = new char[]{'1','2'};

        resultado = operacao.verificaOperacao(dados,0, 4);

        assertArrayEquals(esperado, resultado);
    }

    @Test //Testa se está operando corretamente com multiplicação.
    public void testOperarMultiplicacao(){

        char[] dados = new char[]{'2', '*', '4'};
        char[] resultado = new char[1];
        char[] esperado = new char[]{'8'};

        resultado = operacao.verificaOperacao(dados,0, 2);

        assertArrayEquals(esperado, resultado);
    }

    @Test //Testa se está operando corretamente com multiplicação com 1ª número negativo.
    public void testOperarMultiplicacaoNP(){

        char[] dados = new char[]{'-','2', '*', '4'};
        char[] resultado = new char[2];
        char[] esperado = new char[]{'-','8'};

        resultado = operacao.verificaOperacao(dados,0, 3);

        assertArrayEquals(esperado, resultado);
    }

    @Test //Testa se está operando corretamente com multiplicação com 2ª número negativo.
    public void testOperarMultiplicacaoPN(){

        char[] dados = new char[]{'2','*','-','4'};
        char[] resultado = new char[2];
        char[] esperado = new char[]{'-','8'};

        resultado = operacao.verificaOperacao(dados,0, 3);

        assertArrayEquals(esperado, resultado);
    }

    @Test //Testa se está operando corretamente com multiplicação com os dois números negativos.
    public void testOperarMultiplicacaoNN(){

        char[] dados = new char[]{'-','2','*','-','4'};
        char[] resultado = new char[1];
        char[] esperado = new char[]{'8'};

        resultado = operacao.verificaOperacao(dados,0, 4);

        assertArrayEquals(esperado, resultado);
    }

    @Test //Testa se está operando corretamente com divisão.
    public void testOperarDivisao(){

        char[] dados = new char[]{'4', '/', '2'};
        char[] resultado = new char[1];
        char[] esperado = new char[]{'2'};

        resultado = operacao.verificaOperacao(dados,0, 2);

        assertArrayEquals(esperado, resultado);
    }

    @Test //Testa se está operando corretamente com divisão com 1ª número negativo.
    public void testOperarDivisaoNP(){

        char[] dados = new char[]{'-','4', '/', '2'};
        char[] resultado = new char[2];
        char[] esperado = new char[]{'-','2'};

        resultado = operacao.verificaOperacao(dados,0, 3);

        assertArrayEquals(esperado, resultado);
    }

    @Test //Testa se está operando corretamente com divisão com 2ª número negativo.
    public void testOperarDivisaoPN(){

        char[] dados = new char[]{'4', '/','-','2'};
        char[] resultado = new char[2];
        char[] esperado = new char[]{'-','2'};

        resultado = operacao.verificaOperacao(dados,0, 3);

        assertArrayEquals(esperado, resultado);
    }

    @Test //Testa se está operando corretamente com divisão com os dois números negativos.
    public void testOperarDivisaoNN(){

        char[] dados = new char[]{'-','4', '/','-','2'};
        char[] resultado = new char[1];
        char[] esperado = new char[]{'2'};

        resultado = operacao.verificaOperacao(dados,0, 4);

        assertArrayEquals(esperado, resultado);
    }

    @Test //Testa se está operando corretamente com divisão com resultado decimal.
    public void testOperarDivisaoDecimal(){

        char[] dados = new char[]{'2', '/', '4'};
        char[] resultado = new char[3];
        char[] esperado = new char[]{'0','.','5'};

        resultado = operacao.verificaOperacao(dados,0, 2);

        assertArrayEquals(esperado, resultado);
    }

    @Test //Testa se está operando corretamente com divisão com denominador zero.
    public void testOperarDivisaoZero(){

        char[] dados = new char[]{'2', '/', '0'};
        char[] resultado = new char[1];
        char[] esperado = new char[]{'I','n','f','i','n','i','t','y'};

        resultado = operacao.verificaOperacao(dados,0, 2);

        assertArrayEquals(esperado, resultado);
    }

    @Test
    public void testValor(){

        String[] entrada = new String[]{
                "(2+4)", "2+-4", "2+0", "2-4", "2--4", "2-0", "2*4", "2*-4", "2*0", "4/2", "-4/-2", "4/0"
        };

        String[] esperado = new String[]{
                "6", "-2", "2", "-2", "6", "2", "8", "-8", "0", "2", "-2", "Infinity"
        };

        for(int i=0; i<12;i++){

            String resposta = new String(operacao.valor(entrada[i].toCharArray()));

            assertEquals(esperado[i], resposta, "Posição do erro: " + i);
        }

    }


}