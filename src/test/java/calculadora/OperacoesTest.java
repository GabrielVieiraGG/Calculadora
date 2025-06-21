package calculadora;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OperacoesTest {

    @Test
    public void testTemOperacao(){

        char[] dados = new char[]{'1', '2', '-', '2', '4'};

        Operacoes operacao = new Operacoes();

        boolean resultado = operacao.temOperacao(dados,1, 5, false);

        assertTrue(resultado);
    }

    @Test //Testa se a função reconhece a operação de subtração.
    public void testTemOperacaoSubtracao(){

        char[] dados = new char[]{'1', '2', '-', '2', '4'};

        Operacoes operacao = new Operacoes();

        boolean resultado = operacao.temOperacao(dados,1, 5, false);

        assertTrue(resultado);
    }

    @Test //Testa se a função reconhece a operação de multiplicação.
    public void testTemOperacaoMultiplicacao(){

        char[] dados = new char[]{'1', '2', '*', '2', '4'};

        Operacoes operacao = new Operacoes();

        boolean resultado = operacao.temOperacao(dados,1, 5, false);

        assertTrue(resultado);
    }

    @Test //Testa se a função reconhece a operação de divisão.
    public void testTemOperacaoDivisao(){

        char[] dados = new char[]{'1', '2', '/', '2', '4'};

        Operacoes operacao = new Operacoes();

        boolean resultado = operacao.temOperacao(dados,1, 5, false);

        assertTrue(resultado);
    }

    @Test //Testa se não ativa com número negativo somente.
    public void testTemOperacao(){

        char[] dados = new char[]{'-', '1', '2', '3', '4'};

        Operacoes operacao = new Operacoes();

        boolean resultado = operacao.temOperacao(dados,1, 5, false);

        assertFalse(resultado);
    }

}