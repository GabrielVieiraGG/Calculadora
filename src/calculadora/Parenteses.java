package calculadora;

public class Parenteses {

    static int[] range = new int[2];

    //Remove os parênteses.
    char[] remover(char[] dados, int inicio, int fim){

        char[] resposta = new char[dados.length-2];
        int j=0;

        for(int i=0; i < dados.length;i++){

            if(i == inicio-1 || i == fim+1){
                if (i != dados.length-1){
                    i = i+1;
                }else{
                    break;
                }
            }

            resposta[j] = dados[i];

            j = j+1;
        }

        return resposta;
    }

    //Seleciona o início e o fim dos parênteses.
    public boolean verifica(char[] entrada, int posicao, String pilha) {

        if (posicao == entrada.length) {
            return false;
        }

        char atual = entrada[posicao];

        if (atual == '(') {
            range[0] = posicao+1;
            return verifica(entrada, posicao + 1, pilha + atual);
        }

        if (atual == ')') {
            if (pilha.isEmpty()) return false;

            char topo = pilha.charAt(pilha.length() - 1);

            if (topo == '(') {
                range[1] = posicao-1;
                return verifica(entrada, posicao + 1, pilha.substring(0, pilha.length() - 1));
            } else {
                return true;
            }
        }

        return verifica(entrada, posicao + 1, pilha);
    }

    //Retorna se existe ou não parênteses.
    public boolean existe(char[] dados){
        for(int i=0; i<dados.length;i++){
            if(dados[i] == '(' || dados[i]==')'){
                return true;
            }
        }

        return false;
    }

    //Localiza as posições dos parênteses.
    public int[] localiza(char[] dados){

        int[] range = new int[2];

        for(int i=0;i<dados.length;i++){
            if(dados[i] == '('){
                range[0] = i+1;
            }
        }

        for(int i=range[0]; i< dados.length;i++){
            if(dados[i] == ')'){
                range[1] = i-1;
                break;
            }

        }

        return range;
    }

}
