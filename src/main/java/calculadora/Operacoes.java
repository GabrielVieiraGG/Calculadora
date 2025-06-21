package calculadora;

public class Operacoes {

    //Chama a classe que cuida somente dos parênteses.
    Parenteses parenteses = new Parenteses();

    //Variáveis.
    String[] dados = new String[20];
    int[] range = new int[2];
    int cont = 1;

    public void valor(char[] dados) {

        while(temOperacao(dados,0,0,false)) {

            //Verifica sinal e outras incosistências para corrigir.
            dados = substituir(dados);

            //Verifica se existe parênteses no vetor de dados.
            if(parenteses.existe(dados)){
                range = parenteses.localiza(dados);

                if(range[0] == -1 && range[1] != -1){
                    System.out.println("Syntaxe incorreta!");
                }else if(range[0] != -1 && range[1] == -1){
                    System.out.println("Syntaxe incorreta!");
                }
            }else{
                range[0] = 0;
                range[1] = dados.length-1;
            }

            //Verifica se existe parênteses no vetor de dados.
            dados = verificaOperacao(dados, range[0], range[1]);

            if(parenteses.existe(dados)){

                range = parenteses.localiza(dados);

                if(!temOperacao(dados,range[0], range[1], true)){
                    dados = parenteses.remover(dados, range[0], range[1]);
                }

            }
        }
        printDados(dados);
    }

    public char[] verificaOperacao(char[] dados, int inicio, int fim) {

        int i=0;
        String numero1 = "", numero2 = "";
        int inicioRemocao = -1 , fimRemocao = -1, nivel = 0;
        char operacao='#', operacaoBuscada1 = '*', operacaoBuscada2 = '/';
        boolean dadosSalvos = false, num1Negativo = false;

		/*
		 GLOSSÁRIO

		 numero1 -> Variável onde eu salvo em STRING o primeiro número a ser operado.
		 numero2 -> Variável onde eu salvo em STRING o segundo número a ser operado.
		 respostaString -> Onde eu salvo o valor da resposta na forma de STRING.
		 num1 -> Variável onde é salvo o primeiro número em forma de float.
		 num2 -> Variável onde é salvo o segundo número em forma de float.
		 valor -> Variável onde é salvo a resposta da operação dos dois valores.
		 inicioRemocao -> Posição no vetor original onde começa o primeiro número.
		 fimRemocao -> Posição no vetor original onde termina o segundo número.
		 operacao -> Caractere da operação escolhida.

		 */

        //Começa a percorrer a expressão em busca das operações de multiplicação e divisão.
        for(i=inicio; i <= fim; i++) {

            if((dados[i] == operacaoBuscada1 || dados[i] == operacaoBuscada2) && dadosSalvos == false){

                operacao = dados[i];

                //Caso encontre uma operação ele começará a separar os números envolvidos, primeiro o da esquerda.
                for(int j=i-1; j >= inicio;j--) {

                    //Ao retroceder verifica se é número ou operação matemática.
                    if(dados[j] != '+' && dados[j] != '-' && dados[j] != '*' && dados[j] != '/') {

                        //Salva numa variável de controle os algarismos do número.
                        numero1 = dados[j] + numero1;

                    }else {
                        //Condição para caso o número à esquerda da divisão ou multiplicação seja negativo.
                        if(dados[j] == '-'){
                            numero1 = dados[j] + numero1;
                        }

                        //Salva o inicio da remoção.
                        inicioRemocao = j+1;

                        break;
                    }

                    //Salva o inicio da remoção.
                    inicioRemocao = j;
                }

                //Caso encontre uma operação ele começará a separar os números envolvidos, agora o da direita.
                for(int k=i+1; k <= fim;k++) {

                    //Condição para caso o número à direita da divisão ou multiplicação seja negativo.
                    if((operacaoBuscada1 == '*' || operacaoBuscada2 == '/') && (k==i+1) && (dados[k] == '-')){

                        numero2 =  numero2 + dados[k];

                        k = k+1;
                    }

                    //Ao avançar verifica se é número ou operação matemática.
                    if(dados[k] != '+' && dados[k] != '-' && dados[k] != '*' && dados[k] != '/') {

                        //Salva numa variável de controle os algarismos do número.
                        numero2 =  numero2 + dados[k];

                    }else {
                        //Salva o fim da remoção.
                        fimRemocao = k-1;

                        break; //ADICIONAR MENSAGEM DE ERRO!
                    }

                    //Salva o fim da remoção.
                    fimRemocao = k;

                }

                dadosSalvos = true;

            }

            //Caso ele não encontre as operações de multiplicação e divisão ele passa denovo pelo vetor atrás de outras operações.
            if(i == fim && !dadosSalvos && nivel == 0) {

                operacaoBuscada1 = '+';
                operacaoBuscada2 = '-';

                nivel = 1;

                i = inicio - 1;

                //Caso ele não encontre as operações de adição e subtração ele printa mensagem dizendo que está sem operações para calcular.
            }else if(i == fim && operacao == '#' && nivel == 1) {

                break;

            }else if(operacao != '#' && i == fim){

                dados = operar(numero1, numero2, operacao, inicioRemocao, fimRemocao, dados, num1Negativo);

            }

        }

        return dados;

    }

    public char[] operar(String numero1, String numero2, char operacao, int inicioRemocao, int fimRemocao, char[] dados, boolean num1Negativo) {

        int i=0;
        String respostaString="";
        float num1 = 0, num2 = 0, valor=0;

        //Converte as strings para números (float).
        num1 = Float.parseFloat(numero1);
        num2 = Float.parseFloat(numero2);

        if(num1Negativo){
            //Verifica qual a operação e a efetua.
            switch(operacao) {
                case '+':
                        valor = num2 - num1;

                    break;
                case '-':
                    valor = num1 + num2;

                    break;
            }
        }else{
            //Verifica qual a operação e a efetua.
            switch(operacao) {
                case '+':
                    valor = num1 + num2;

                    break;
                case '-':
                    valor = num1 - num2;

                    break;
                case '*':
                    valor = num1 * num2;

                    break;
                case '/':
                    valor = num1 / num2;

                    break;
            }
        }

        //Verifica se a resposta é inteira ou decimal.
        if(valor == (int)valor) {

            // Converte o float, como int, para string.
            respostaString = Integer.toString((int)valor);
        } else {
            // Converte o float para string.
            respostaString = Float.toString(valor);
        }

        int tamanho = 0, range = fimRemocao-inicioRemocao + 1;

        //Define o tamanho do novo vetor com base na resposta obtida.
        if(range == respostaString.length()) {

            tamanho = dados.length;

        }else if(range < respostaString.length()){

            tamanho = (dados.length + (respostaString.length() - range));

        }else {

            tamanho = ( dados.length - ( (range) - respostaString.length() ) );

        }

        if(num1Negativo){
            tamanho = tamanho-1;
        }

        //Cria o novo vetor da expressão numérica.
        char[] resposta = new char[tamanho];

        // Copia os caracteres da string para o vetor char a partir da posição desejada
        for (i = 0; i < tamanho; i++) {

            //Quando chegar na parte alterada ele vai começar a inserir os novos dados.
            if((i == inicioRemocao && !num1Negativo) || (i == inicioRemocao-1 && num1Negativo)) {
                for(int l=0; l<respostaString.length();l++){

                    resposta[i] = respostaString.charAt(l);

                    i = i + 1;

                }

                i = i - 1;

            }else if( i > inicioRemocao){

                fimRemocao = fimRemocao + 1;

                if(fimRemocao >= dados.length) {
                    break;
                }else {
                    resposta[i] = dados[fimRemocao];
                }

            }else {
                resposta[i] = dados[i];
            }

        }


        System.out.print("Resultado da operação " + cont + ": ");

        cont = cont+1;

        for( i=0; i<resposta.length;i++){
            System.out.print(resposta[i] + " ");
        }

        System.out.println("");

        return resposta;

    }

    public boolean temOperacao(char[] dados, int inicio, int fim, boolean inteiro) {

        if(!inteiro){
            for(int i=0; i< dados.length;i++){
                if(dados[i] == '+' || (dados[i] == '-' && i != 0) || dados[i] == '*' || dados[i] == '/') {
                    return true;
                }
            }
        }else {
            for (int i = inicio; i < fim + 1; i++) {
                if (dados[i] == '+' || (dados[i] == '-' && i != inicio) || dados[i] == '*' || dados[i] == '/') {
                    return true;
                }
            }
        }

        return false;
    }

    public void printDados(char[] dados) {

        System.out.println();

        System.out.print("Resposta final: ");

        for (char dado : dados) {
            System.out.print(dado);
        }
    }

    public char[] substituir(char[] dados){
        char[] resposta = new char[dados.length];

        int j=0;

        for(int i=0;i< dados.length;i++){
            //Caso haja sinal de + e - juntos ele converte em um de -.
            if(dados[i] == '+' && dados[i+1] == '-'){
                i=i+1;
                resposta[j] = dados[i];

            //Caso haja sinal de - e - juntos ele converte em um de +.
            }else if(dados[i] == '-' && dados[i+1] == '-') {
                i=i+1;
                resposta[j] = '+';
            }else{
                resposta[j] = dados[i];
            }
            j = j+1;
        }
        return resposta;
    }


}