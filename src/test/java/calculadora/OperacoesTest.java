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
}