package calculadora;

public class removerParenteses {

    public int[] verifica(char[] entrada, int posicao, String pilha) {
        int[] range = new int[2];

        if (posicao == entrada.length) {
            return range;
        }

        char atual = entrada[posicao];

        if (atual == '(') {
            range[0] = posicao;
            return verifica(entrada, posicao + 1, pilha + atual);
        }

        if (atual == ')') {
            if (pilha.isEmpty()) return range;

            char topo = pilha.charAt(pilha.length() - 1);

            if (topo == '(') {
                range[1] = posicao;
                return verifica(entrada, posicao + 1, pilha.substring(0, pilha.length() - 1));
            } else {
                return range;
            }
        }

        return verifica(entrada, posicao + 1, pilha);
    }

    char[] remover(char[] dados, int inicio, int fim){

        char[] resposta = new char[dados.length-2];
        int j=0;

        for(int i=0; i < dados.length;i++){

            if(dados[i] != '(' && dados[i] != ')'){
                resposta[j] = dados[i];

                j = j+1;
            }
        }

        return resposta;
    }

}
