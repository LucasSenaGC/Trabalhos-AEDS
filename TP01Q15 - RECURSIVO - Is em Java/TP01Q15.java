/*Crie um metodo iterativo que recebe uma string e retorna true se a mesma eh
composta somente por vogais. Crie outro metodo iterativo que recebe uma string e retorna
true se a mesma eh composta somente por consoantes. Crie um terceiro metodo iterativo que
recebe uma string e retorna true se a mesma corresponde a um numero inteiro. Crie um quarto
metodo iterativo que recebe uma string e retorna true se a mesma corresponde a um numero
real. Na saida padrao, para cada linha de entrada, escreva outra de saida da seguinte forma X1
X2 X3 X4 onde cada Xi eh um booleano indicando se a eh entrada eh: composta somente por vogais
(X1); composta somente somente por consoantes (X2); um numero inteiro (X3); um numero real
(X4). Se Xi for verdadeiro, seu valor sera SIM, caso contrario, NAO. */
class TP01Q15{
    //verifica se a string eh FIM
    public static boolean IsFim(String recebida){
        return (recebida.length() == 3 && recebida.charAt(0) == 'F' && recebida.charAt(1) == 'I' && recebida.charAt(2) == 'M');
    }
    //recebe um char e retorna se ele eh vogal ou nao
    public static boolean IsVogal(char verificar){
        boolean resp = false;
            // verifica se a letra eh a e i o u OU A E I O U e caso qualquer uma dessas seja verdade retorna true
            if(verificar == 'a' || verificar == 'A' || verificar == 'e' || verificar == 'E' || verificar == 'i' || verificar == 'I' || verificar == 'o' ||
            verificar == 'O' || verificar == 'u' || verificar == 'U'){
                resp = true;
            }else{
                resp = false;
            } 
             return resp;
    }
    //Verifica se o char escolhido eh consoante
    public static boolean IsConsoante(char verificar){
        boolean resp = false;
        //se for uma letra e nao for vogal ela eh consoante
        if(((verificar >= 'a' && verificar <= 'z') || (verificar >= 'A' && verificar <= 'Z')) && IsVogal(verificar) == false){
            resp = true;
        }
        return resp;
    }

    //Verifica se toda a frase eh composta apenas por vogais.
    //Como a chamada eh recursiva passamos o inteiro i que recebe o valor do tamanho
    //da string recebida e na chamada recursiva sempre fazemos --i enquanto i for menor que zero
    //o resp boleano sera usado para as condicoes do if(interior) se tivermos qualquer letra
    // nao vogal ela se tornara falsa(no main, mandamos como parametro para o metodo FraseIsVogal
    // resp = true, ou seja, iniciamos sempre como true se caso nao obedecer a condicao uma vez
    //ela retronara falso);
    public static boolean ReqFraseIsVogal(String recebida, int i, boolean resp){
        if(i > 0){
            //se IsVogal for true fazemos a chamada recursiva
            //caso nao retornamos resp = false
            if(IsVogal(recebida.charAt(i)) == true){
                //fazemos a chamda recursiva ate verificar todos os caracteres
                //se nenhuma retorna false significa q a frase eh composta por vogais
                //e a resp = true ja que ela nao sera alterada
                if(ReqFraseIsVogal(recebida, --i, resp) == false){
                    resp = false;
                }
            }else{
                resp = false;
                return resp;
            }
        }
        return resp;
    }

    //Verifica se toda a frase eh composta apenas por consoantes
    //ah mesma ideia aplicada no metodo ReqFraseIsVogal eh aplicada aqui para fazer a recursao
    //porem agora os metodos chamados sao os: IsConsoante e ReqFraseIsConsoante(recursao)
    public static boolean ReqFraseIsConsoante(String recebida, int i, boolean resp){
        if(i > 0){
            if(IsConsoante(recebida.charAt(i)) == true){
                if(ReqFraseIsConsoante(recebida, --i, resp) == false){
                    resp = false;
                }
            }else{
                resp = false;
                return resp;
            }
        }       
        return resp;
    }

    //verifica se o char eh um inteiro
    public static boolean IsInteiro(char verificar){
        boolean resp = false;
        //se for um numero retorna true
        if(verificar >= '0' && verificar <= '9'){
            resp = true;
        }else{
            resp = false;
        }
        return resp;
    }

    //verifica se a string eh composta apenas por inteiros
    //tambem eh aplicada a mesma logica de recursao mas agora com os metodos
    //para verificar se os numeros sao inteiros
    public static boolean ReqFraseIsInteiro(String recebida, int i, boolean resp){
        if(i > 0 ){
            if(IsInteiro(recebida.charAt(i)) == true){ 
                if(ReqFraseIsInteiro(recebida, --i, resp) == false){
                    resp = false;
                } 
            }else{
                resp = false;
                return resp;  
            }
        }
        return resp;
    }
    //verifica se um char eh um numero real(vale observar que nesse metodo os chars virgula e ponto sao considerados como condicao para ser um real)
    public static boolean IsReal(char verificar){
        boolean resp = false;
        //se for um numero inteiro ou um ponto ou uma virgula devemos por considerar q por enquanto ele eh um numero real
        if(IsInteiro(verificar) || verificar == ',' || verificar == '.'){
            resp = true;
        }
        return resp;
    }

    //Verifica se a frase eh composta apenas por numeros Real
    //Tambem segue a mesma logica recursiva utilizada nos metodos anteriores
    public static boolean ReqFraseIsReal(String recebida, int i, boolean resp, int count){
        //se for apenas um char olhar se ele eh um numero interio, pq assim ele tbm sera real
        if(recebida.length() == 1){
            if(ReqFraseIsInteiro(recebida, i, resp) == true){
                resp = true;
            }
        }else{
            //se for maior que um, contar os pontos e verificar se todos os numeros recebidos pode ser classificados como reais
                if(i > 0){
                    if(recebida.charAt(i) == ',' || recebida.charAt(i) == '.'){
                        count++;
                    }
                    if(count <= 1 && IsReal(recebida.charAt(i)) == true){
                        if(ReqFraseIsReal(recebida, --i, resp, count) == false){
                            resp = false;
                        }    
                    }else{
                        resp = false;
                        return resp;
                    }
                }
            }
            return resp;
        }
        

    public static void main(String[] args){
        String recebida = "";
        String output = "";
        int i;
        boolean X1, X2, X3, X4, resp;
        resp = true;
        recebida = MyIO.readLine();
        i = recebida.length() - 1;
        while(IsFim(recebida) == false){
            X1 = ReqFraseIsVogal(recebida, i, resp);
            X2 = ReqFraseIsConsoante(recebida, i, resp);
            X3 = ReqFraseIsInteiro(recebida, i, resp);
            X4 = ReqFraseIsReal(recebida, i, resp, 0);
            if(X1 == false){
                output = output + "NAO ";
            }else{
                output = output + "SIM ";
            }
            if(X2 == false){
                output = output + "NAO ";
            }else{
                output = output + "SIM ";
            }
            if(X3 == false){
                output = output + "NAO ";
            }else{
                output = output + "SIM ";
            }
            if(X4 == false){
                output = output + "NAO";
            }else{
                output = output + "SIM";
            }
            MyIO.println(output);
            recebida = MyIO.readLine();
            i = recebida.length() - 1;
            output = "";
        }
    }
}