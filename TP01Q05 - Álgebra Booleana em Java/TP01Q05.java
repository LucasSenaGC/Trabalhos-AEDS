
class TP01Q05{
    /* Crie um metodo iterativo que recebe uma string contendo uma
    expressao booleana e o valor de suas entradas e retorna um booleano indicando se a expressao
    e verdadeira ou falsa. Cada string de entrada eh composta por um numero inteiro n indicando
    o numero de entradas da expressao booleana corrente. Em seguida, a string contem n valores
    binarios (um para cada entrada) e a expressao booleana. Na sa?da padrao, para cada linha
    de entrada, escreva uma linha de sa?da com SIM / NAO indicando se a expressao corrente eh
    verdadeira ou falsa.
 */



        //tirar todos os espacos da string
    public static String TirarEspaco(String str){
        String strSemEspaco = "";
        for(int i = 0; i < str.length(); i++){
            //se encontrar um espaco andamos um char pra frente
            if(str.charAt(i) != ' '){
                strSemEspaco = strSemEspaco + str.charAt(i);
            }
        }
        return strSemEspaco;
    }

    //Devolve uma String que substitui os caracteres A B C por Numeros
    public static String ColocarNumeros(String equacao, char qntleitura){
        String novastr = "";
        char A = ' ', B = ' ', C = ' ';
        //Atribuir os valores de A,B e C dependendo da situacao e fazer uma nova String substituindo as letras por numeros
        if(qntleitura == '1'){
            A = equacao.charAt(1);

            for(int i = 2; i < equacao.length(); i++){
                if(equacao.charAt(i) == 'A'){
                    novastr = novastr + A;
                }else if(equacao.charAt(i) == 'B'){
                    novastr = novastr + B;
                }else if(equacao.charAt(i) == 'C'){
                    novastr = novastr + C;
                }else{
                    novastr = novastr + equacao.charAt(i);
                }
            }

        }else if(qntleitura == '2'){
            A = equacao.charAt(1);
            B = equacao.charAt(2);

            for(int i = 3; i < equacao.length(); i++){
                if(equacao.charAt(i) == 'A'){
                    novastr = novastr + A;
                }else if(equacao.charAt(i) == 'B'){
                    novastr = novastr + B;
                }else{
                    novastr = novastr + equacao.charAt(i);
                }
            }

        }else if(qntleitura == '3'){
            A = equacao.charAt(1);
            B = equacao.charAt(2);
            C = equacao.charAt(3);

            for(int i = 4; i < equacao.length(); i++){
                if(equacao.charAt(i) == 'A'){
                    novastr = novastr + A;
                }else if(equacao.charAt(i) == 'B'){
                    novastr = novastr + B;
                }else if(equacao.charAt(i) == 'C'){
                    novastr = novastr + C;
                }else{
                    novastr = novastr + equacao.charAt(i);
                }
            }
        }
        return novastr;
    }
    
    //metodo recursivo para desenvolver a algebra booleana ate que a string possua 1 como tamanho
    //NADA EFETIVO! MUITAS COMPARACOES
    //sempre que chamada testa todas as possibilidades possiveis de equacoes(com ate 4 numeros) ate que todas estejam resolvidas
    public static String ResolverAlgebra(String x, int i, String resp){
        if(i == x.length()){
            //MyIO.println("final -> " + resp);
            if(resp.length() > 1){
                resp = ResolverAlgebra(resp, 0, "");
            }else{
                MyIO.println(resp);
                return resp;
            }
        }else{
            if(i+11 < x.length()){
                //and(1,1,1,1)
                if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '1' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '1' && x.charAt(i+7) == ',' && x.charAt(i+8) == '1' && x.charAt(i+9) == ',' && 
                x.charAt(i+10) == '1' && x.charAt(i+11) == ')'){
                    resp = resp + '1';
                    i+=12;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //and(0,0,0,0)
                }else if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '0' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '0' && x.charAt(i+7) == ',' && x.charAt(i+8) == '0' && x.charAt(i+9) == ',' && 
                x.charAt(i+10) == '0' && x.charAt(i+11) == ')'){
                    resp = resp + '0';
                    i+=12;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //and(0,0,0,1)
                }else if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '0' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '0' && x.charAt(i+7) == ',' && x.charAt(i+8) == '0' && x.charAt(i+9) == ',' && 
                x.charAt(i+10) == '1' && x.charAt(i+11) == ')'){
                    resp = resp + '0';
                    i+=12;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //and(0,0,1,0)
                }else if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '0' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '0' && x.charAt(i+7) == ',' && x.charAt(i+8) == '1' && x.charAt(i+9) == ',' && 
                x.charAt(i+10) == '0' && x.charAt(i+11) == ')'){
                    resp = resp + '0';
                    i+=12;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //and(0,0,1,1)
                }else if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '0' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '0' && x.charAt(i+7) == ',' && x.charAt(i+8) == '1' && x.charAt(i+9) == ',' && 
                x.charAt(i+10) == '1' && x.charAt(i+11) == ')'){
                    resp = resp + '0';
                    i+=12;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //and(0,1,0,0)
                }else if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '0' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '1' && x.charAt(i+7) == ',' && x.charAt(i+8) == '0' && x.charAt(i+9) == ',' && 
                x.charAt(i+10) == '0' && x.charAt(i+11) == ')'){
                    resp = resp + '0';
                    i+=12;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //and(0,1,0,1)
                }else if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '0' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '1' && x.charAt(i+7) == ',' && x.charAt(i+8) == '0' && x.charAt(i+9) == ',' && 
                x.charAt(i+10) == '1' && x.charAt(i+11) == ')'){
                    resp = resp + '0';
                    i+=12;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //and(0,1,1,0)
                }else if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '0' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '1' && x.charAt(i+7) == ',' && x.charAt(i+8) == '1' && x.charAt(i+9) == ',' && 
                x.charAt(i+10) == '0' && x.charAt(i+11) == ')'){
                    resp = resp + '0';
                    i+=12;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //and(0,1,1,1)
                }else if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '0' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '1' && x.charAt(i+7) == ',' && x.charAt(i+8) == '1' && x.charAt(i+9) == ',' && 
                x.charAt(i+10) == '1' && x.charAt(i+11) == ')'){
                    resp = resp + '0';
                    i+=12;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //and(1,0,0,0)
                }else if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '1' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '0' && x.charAt(i+7) == ',' && x.charAt(i+8) == '0' && x.charAt(i+9) == ',' && 
                x.charAt(i+10) == '0' && x.charAt(i+11) == ')'){
                    resp = resp + '0';
                    i+=12;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //and(1,0,0,1)
                }else if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '1' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '0' && x.charAt(i+7) == ',' && x.charAt(i+8) == '0' && x.charAt(i+9) == ',' && 
                x.charAt(i+10) == '1' && x.charAt(i+11) == ')'){
                    resp = resp + '0';
                    i+=12;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //and(1,0,1,0)
                }else if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '1' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '0' && x.charAt(i+7) == ',' && x.charAt(i+8) == '1' && x.charAt(i+9) == ',' && 
                x.charAt(i+10) == '0' && x.charAt(i+11) == ')'){
                    resp = resp + '0';
                    i+=12;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //and(1,0,1,1)
                }else if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '1' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '0' && x.charAt(i+7) == ',' && x.charAt(i+8) == '1' && x.charAt(i+9) == ',' && 
                x.charAt(i+10) == '1' && x.charAt(i+11) == ')'){
                    resp = resp + '0';
                    i+=12;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //and(1,1,0,0)
                }else if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '1' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '1' && x.charAt(i+7) == ',' && x.charAt(i+8) == '0' && x.charAt(i+9) == ',' && 
                x.charAt(i+10) == '0' && x.charAt(i+11) == ')'){
                    resp = resp + '0';
                    i+=12;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //and(1,1,0,1)
                }else if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '1' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '1' && x.charAt(i+7) == ',' && x.charAt(i+8) == '0' && x.charAt(i+9) == ',' && 
                x.charAt(i+10) == '1' && x.charAt(i+11) == ')'){
                    resp = resp + '0';
                    i+=12;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //and(1,1,1,0)
                }else if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '1' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '1' && x.charAt(i+7) == ',' && x.charAt(i+8) == '1' && x.charAt(i+9) == ',' && 
                x.charAt(i+10) == '0' && x.charAt(i+11) == ')'){
                    resp = resp + '0';
                    i+=12;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(0,0,0,0)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '0' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '0' && x.charAt(i+6) == ',' && x.charAt(i+7) == '0' && x.charAt(i+8) == ',' && x.charAt(i+9) == '0' && 
                x.charAt(i+10) == ')'){
                    resp = resp + '0';
                    i+=11;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(0,0,0,1)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '0' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '0' && x.charAt(i+6) == ',' && x.charAt(i+7) == '0' && x.charAt(i+8) == ',' && x.charAt(i+9) == '1' && 
                x.charAt(i+10) == ')'){
                    resp = resp + '1';
                    i+=11;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(0,0,1,0)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '0' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '0' && x.charAt(i+6) == ',' && x.charAt(i+7) == '1' && x.charAt(i+8) == ',' && x.charAt(i+9) == '0' && 
                x.charAt(i+10) == ')'){
                    resp = resp + '1';
                    i+=11;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(0,0,1,1)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '0' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '0' && x.charAt(i+6) == ',' && x.charAt(i+7) == '1' && x.charAt(i+8) == ',' && x.charAt(i+9) == '1' && 
                x.charAt(i+10) == ')'){
                    resp = resp + '1';
                    i+=11;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(0,1,0,0)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '0' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '1' && x.charAt(i+6) == ',' && x.charAt(i+7) == '0' && x.charAt(i+8) == ',' && x.charAt(i+9) == '0' && 
                x.charAt(i+10) == ')'){
                    resp = resp + '1';
                    i+=11;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(0,1,0,1)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '0' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '1' && x.charAt(i+6) == ',' && x.charAt(i+7) == '0' && x.charAt(i+8) == ',' && x.charAt(i+9) == '1' && 
                x.charAt(i+10) == ')'){
                    resp = resp + '1';
                    i+=11;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(0,1,1,0)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '0' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '1' && x.charAt(i+6) == ',' && x.charAt(i+7) == '1' && x.charAt(i+8) == ',' && x.charAt(i+9) == '0' && 
                x.charAt(i+10) == ')'){
                    resp = resp + '1';
                    i+=11;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(0,1,1,1)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '0' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '1' && x.charAt(i+6) == ',' && x.charAt(i+7) == '1' && x.charAt(i+8) == ',' && x.charAt(i+9) == '1' && 
                x.charAt(i+10) == ')'){
                    resp = resp + '1';
                    i+=11;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(1,0,0,0)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '1' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '0' && x.charAt(i+6) == ',' && x.charAt(i+7) == '0' && x.charAt(i+8) == ',' && x.charAt(i+9) == '0' && 
                x.charAt(i+10) == ')'){
                    resp = resp + '1';
                    i+=11;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(1,0,0,1)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '1' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '0' && x.charAt(i+6) == ',' && x.charAt(i+7) == '0' && x.charAt(i+8) == ',' && x.charAt(i+9) == '1' && 
                x.charAt(i+10) == ')'){
                    resp = resp + '1';
                    i+=11;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(1,0,1,0)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '1' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '0' && x.charAt(i+6) == ',' && x.charAt(i+7) == '1' && x.charAt(i+8) == ',' && x.charAt(i+9) == '0' && 
                x.charAt(i+10) == ')'){
                    resp = resp + '1';
                    i+=11;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(1,0,1,1)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '1' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '0' && x.charAt(i+6) == ',' && x.charAt(i+7) == '1' && x.charAt(i+8) == ',' && x.charAt(i+9) == '1' && 
                x.charAt(i+10) == ')'){
                    resp = resp + '1';
                    i+=11;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(1,1,0,0)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '1' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '1' && x.charAt(i+6) == ',' && x.charAt(i+7) == '0' && x.charAt(i+8) == ',' && x.charAt(i+9) == '0' && 
                x.charAt(i+10) == ')'){
                    resp = resp + '1';
                    i+=11;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(1,1,0,1)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '1' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '1' && x.charAt(i+6) == ',' && x.charAt(i+7) == '0' && x.charAt(i+8) == ',' && x.charAt(i+9) == '1' && 
                x.charAt(i+10) == ')'){
                    resp = resp + '1';
                    i+=11;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(1,1,1,0)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '1' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '1' && x.charAt(i+6) == ',' && x.charAt(i+7) == '1' && x.charAt(i+8) == ',' && x.charAt(i+9) == '0' && 
                x.charAt(i+10) == ')'){
                    resp = resp + '1';
                    i+=11;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(1,1,1,1)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '1' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '1' && x.charAt(i+6) == ',' && x.charAt(i+7) == '1' && x.charAt(i+8) == ',' && x.charAt(i+9) == '1' && 
                x.charAt(i+10) == ')'){
                    resp = resp + '1';
                    i+=11;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //and(1,1,1)
                }else if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '1' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '1' && x.charAt(i+7) == ',' && x.charAt(i+8) == '1' && x.charAt(i+9) == ')'){
                    resp = resp + '1';
                    i+=10;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //and(1,1,0)
                }else if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '1' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '1' && x.charAt(i+7) == ',' && x.charAt(i+8) == '0' && x.charAt(i+9) == ')'){
                    resp = resp + '0';
                    i+=10;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //and(1,0,1)
                }else if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '1' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '0' && x.charAt(i+7) == ',' && x.charAt(i+8) == '1' && x.charAt(i+9) == ')'){
                    resp = resp + '0';
                    i+=10;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //and(0,1,1)
                }else if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '0' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '1' && x.charAt(i+7) == ',' && x.charAt(i+8) == '1' && x.charAt(i+9) == ')'){
                    resp = resp + '0';
                    i+=10;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //and(0,0,1)
                }else if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '0' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '0' && x.charAt(i+7) == ',' && x.charAt(i+8) == '1' && x.charAt(i+9) == ')'){
                    resp = resp + '0';
                    i+=10;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //and(0,1,0)
                }else if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '0' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '1' && x.charAt(i+7) == ',' && x.charAt(i+8) == '0' && x.charAt(i+9) == ')'){
                    resp = resp + '0';
                    i+=10;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //and(1,0,0)
                }else if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '1' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '0' && x.charAt(i+7) == ',' && x.charAt(i+8) == '0' && x.charAt(i+9) == ')'){
                    resp = resp + '0';
                    i+=10;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //and(0,0,0)
                }else if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '0' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '0' && x.charAt(i+7) == ',' && x.charAt(i+8) == '0' && x.charAt(i+9) == ')'){
                    resp = resp + '0';
                    i+=10;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(0,0,0)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '0' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '0' && x.charAt(i+6) == ',' && x.charAt(i+7) == '0' && x.charAt(i+8) == ')'){
                    resp = resp + '0';
                    i+=9;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(1,0,0)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '1' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '0' && x.charAt(i+6) == ',' && x.charAt(i+7) == '0' && x.charAt(i+8) == ')'){
                    resp = resp + '1';
                    i+=9;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(0,1,0)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '0' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '1' && x.charAt(i+6) == ',' && x.charAt(i+7) == '0' && x.charAt(i+8) == ')'){
                    resp = resp + '1';
                    i+=9;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(0,0,1)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '0' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '0' && x.charAt(i+6) == ',' && x.charAt(i+7) == '1' && x.charAt(i+8) == ')'){
                    resp = resp + '1';
                    i+=9;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(1,1,0)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '1' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '1' && x.charAt(i+6) == ',' && x.charAt(i+7) == '0' && x.charAt(i+8) == ')'){
                    resp = resp + '1';
                    i+=9;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(0,1,1)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '0' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '1' && x.charAt(i+6) == ',' && x.charAt(i+7) == '1' && x.charAt(i+8) == ')'){
                    resp = resp + '1';
                    i+=9;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(1,0,1)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '1' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '0' && x.charAt(i+6) == ',' && x.charAt(i+7) == '1' && x.charAt(i+8) == ')'){
                    resp = resp + '1';
                    i+=9;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(1,1,1)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '1' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '1' && x.charAt(i+6) == ',' && x.charAt(i+7) == '1' && x.charAt(i+8) == ')'){
                    resp = resp + '1';
                    i+=9;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //and(1,1)
                }else if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '1' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '1' && x.charAt(i+7) == ')'){
                    resp = resp + '1';
                    i+=8;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //and(1,0)
                }else if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '1' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '0' && x.charAt(i+7) == ')'){
                    resp = resp + '0';
                    i+=8;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //and(0,1)
                }else if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '0' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '1' && x.charAt(i+7) == ')'){
                    resp = resp + '0';
                    i+=8;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //and(0,0)
                }else if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '0' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '0' && x.charAt(i+7) == ')'){
                    resp = resp + '0';
                    i+=8;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(0,0)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '0' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '0' && x.charAt(i+6) == ')'){
                    resp = resp + '0';
                    i+=7;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(1,1)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '1' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '1' && x.charAt(i+6) == ')'){
                    resp = resp + '1';
                    i+=7;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(1,0)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '1' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '0' && x.charAt(i+6) == ')'){
                    resp = resp + '1';
                    i+=7;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(0,1)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '0' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '1' && x.charAt(i+6) == ')'){
                    resp = resp + '1';
                    i+=7;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //not(0)
                }else if(x.charAt(i) == 'n' && x.charAt(i+1) == 'o' && x.charAt(i+2) == 't' && x.charAt(i+3) == '(' && x.charAt(i+4) == '0' && x.charAt(i+5) == ')'){
                    resp = resp + "1";
                    i+=6;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //not(1)
                }else if(x.charAt(i) == 'n' && x.charAt(i+1) == 'o' && x.charAt(i+2) == 't' && x.charAt(i+3) == '(' && x.charAt(i+4) == '1' && x.charAt(i+5) == ')'){
                    resp = resp + "0";
                    i+=6;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                }else{
                    resp = resp + x.charAt(i);
                    i++;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                }
            }else if(i+10 < x.length()){
                //or(0,0,0,0)
                if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '0' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '0' && x.charAt(i+6) == ',' && x.charAt(i+7) == '0' && x.charAt(i+8) == ',' && x.charAt(i+9) == '0' && 
                x.charAt(i+10) == ')'){
                    resp = resp + '0';
                    i+=11;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(0,0,0,1)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '0' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '0' && x.charAt(i+6) == ',' && x.charAt(i+7) == '0' && x.charAt(i+8) == ',' && x.charAt(i+9) == '1' && 
                x.charAt(i+10) == ')'){
                    resp = resp + '1';
                    i+=11;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(0,0,1,0)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '0' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '0' && x.charAt(i+6) == ',' && x.charAt(i+7) == '1' && x.charAt(i+8) == ',' && x.charAt(i+9) == '0' && 
                x.charAt(i+10) == ')'){
                    resp = resp + '1';
                    i+=11;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(0,0,1,1)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '0' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '0' && x.charAt(i+6) == ',' && x.charAt(i+7) == '1' && x.charAt(i+8) == ',' && x.charAt(i+9) == '1' && 
                x.charAt(i+10) == ')'){
                    resp = resp + '1';
                    i+=11;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(0,1,0,0)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '0' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '1' && x.charAt(i+6) == ',' && x.charAt(i+7) == '0' && x.charAt(i+8) == ',' && x.charAt(i+9) == '0' && 
                x.charAt(i+10) == ')'){
                    resp = resp + '1';
                    i+=11;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(0,1,0,1)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '0' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '1' && x.charAt(i+6) == ',' && x.charAt(i+7) == '0' && x.charAt(i+8) == ',' && x.charAt(i+9) == '1' && 
                x.charAt(i+10) == ')'){
                    resp = resp + '1';
                    i+=11;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(0,1,1,0)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '0' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '1' && x.charAt(i+6) == ',' && x.charAt(i+7) == '1' && x.charAt(i+8) == ',' && x.charAt(i+9) == '0' && 
                x.charAt(i+10) == ')'){
                    resp = resp + '1';
                    i+=11;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(0,1,1,1)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '0' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '1' && x.charAt(i+6) == ',' && x.charAt(i+7) == '1' && x.charAt(i+8) == ',' && x.charAt(i+9) == '1' && 
                x.charAt(i+10) == ')'){
                    resp = resp + '1';
                    i+=11;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(1,0,0,0)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '1' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '0' && x.charAt(i+6) == ',' && x.charAt(i+7) == '0' && x.charAt(i+8) == ',' && x.charAt(i+9) == '0' && 
                x.charAt(i+10) == ')'){
                    resp = resp + '1';
                    i+=11;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(1,0,0,1)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '1' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '0' && x.charAt(i+6) == ',' && x.charAt(i+7) == '0' && x.charAt(i+8) == ',' && x.charAt(i+9) == '1' && 
                x.charAt(i+10) == ')'){
                    resp = resp + '1';
                    i+=11;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(1,0,1,0)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '1' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '0' && x.charAt(i+6) == ',' && x.charAt(i+7) == '1' && x.charAt(i+8) == ',' && x.charAt(i+9) == '0' && 
                x.charAt(i+10) == ')'){
                    resp = resp + '1';
                    i+=11;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(1,0,1,1)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '1' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '0' && x.charAt(i+6) == ',' && x.charAt(i+7) == '1' && x.charAt(i+8) == ',' && x.charAt(i+9) == '1' && 
                x.charAt(i+10) == ')'){
                    resp = resp + '1';
                    i+=11;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(1,1,0,0)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '1' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '1' && x.charAt(i+6) == ',' && x.charAt(i+7) == '0' && x.charAt(i+8) == ',' && x.charAt(i+9) == '0' && 
                x.charAt(i+10) == ')'){
                    resp = resp + '1';
                    i+=11;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(1,1,0,1)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '1' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '1' && x.charAt(i+6) == ',' && x.charAt(i+7) == '0' && x.charAt(i+8) == ',' && x.charAt(i+9) == '1' && 
                x.charAt(i+10) == ')'){
                    resp = resp + '1';
                    i+=11;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(1,1,1,0)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '1' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '1' && x.charAt(i+6) == ',' && x.charAt(i+7) == '1' && x.charAt(i+8) == ',' && x.charAt(i+9) == '0' && 
                x.charAt(i+10) == ')'){
                    resp = resp + '1';
                    i+=11;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(1,1,1,1)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '1' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '1' && x.charAt(i+6) == ',' && x.charAt(i+7) == '1' && x.charAt(i+8) == ',' && x.charAt(i+9) == '1' && 
                x.charAt(i+10) == ')'){
                    resp = resp + '1';
                    i+=11;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //and(1,1,1)
                }else if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '1' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '1' && x.charAt(i+7) == ',' && x.charAt(i+8) == '1' && x.charAt(i+9) == ')'){
                    resp = resp + '1';
                    i+=10;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //and(1,1,0)
                }else if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '1' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '1' && x.charAt(i+7) == ',' && x.charAt(i+8) == '0' && x.charAt(i+9) == ')'){
                    resp = resp + '0';
                    i+=10;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //and(1,0,1)
                }else if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '1' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '0' && x.charAt(i+7) == ',' && x.charAt(i+8) == '1' && x.charAt(i+9) == ')'){
                    resp = resp + '0';
                    i+=10;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //and(0,1,1)
                }else if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '0' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '1' && x.charAt(i+7) == ',' && x.charAt(i+8) == '1' && x.charAt(i+9) == ')'){
                    resp = resp + '0';
                    i+=10;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //and(0,0,1)
                }else if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '0' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '0' && x.charAt(i+7) == ',' && x.charAt(i+8) == '1' && x.charAt(i+9) == ')'){
                    resp = resp + '0';
                    i+=10;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //and(0,1,0)
                }else if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '0' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '1' && x.charAt(i+7) == ',' && x.charAt(i+8) == '0' && x.charAt(i+9) == ')'){
                    resp = resp + '0';
                    i+=10;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //and(1,0,0)
                }else if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '1' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '0' && x.charAt(i+7) == ',' && x.charAt(i+8) == '0' && x.charAt(i+9) == ')'){
                    resp = resp + '0';
                    i+=10;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //and(0,0,0)
                }else if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '0' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '0' && x.charAt(i+7) == ',' && x.charAt(i+8) == '0' && x.charAt(i+9) == ')'){
                    resp = resp + '0';
                    i+=10;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(0,0,0)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '0' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '0' && x.charAt(i+6) == ',' && x.charAt(i+7) == '0' && x.charAt(i+8) == ')'){
                    resp = resp + '0';
                    i+=9;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(1,0,0)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '1' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '0' && x.charAt(i+6) == ',' && x.charAt(i+7) == '0' && x.charAt(i+8) == ')'){
                    resp = resp + '1';
                    i+=9;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(0,1,0)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '0' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '1' && x.charAt(i+6) == ',' && x.charAt(i+7) == '0' && x.charAt(i+8) == ')'){
                    resp = resp + '1';
                    i+=9;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(0,0,1)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '0' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '0' && x.charAt(i+6) == ',' && x.charAt(i+7) == '1' && x.charAt(i+8) == ')'){
                    resp = resp + '1';
                    i+=9;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(1,1,0)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '1' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '1' && x.charAt(i+6) == ',' && x.charAt(i+7) == '0' && x.charAt(i+8) == ')'){
                    resp = resp + '1';
                    i+=9;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(0,1,1)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '0' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '1' && x.charAt(i+6) == ',' && x.charAt(i+7) == '1' && x.charAt(i+8) == ')'){
                    resp = resp + '1';
                    i+=9;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(1,0,1)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '1' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '0' && x.charAt(i+6) == ',' && x.charAt(i+7) == '1' && x.charAt(i+8) == ')'){
                    resp = resp + '1';
                    i+=9;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(1,1,1)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '1' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '1' && x.charAt(i+6) == ',' && x.charAt(i+7) == '1' && x.charAt(i+8) == ')'){
                    resp = resp + '1';
                    i+=9;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //and(1,1)
                }else if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '1' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '1' && x.charAt(i+7) == ')'){
                    resp = resp + '1';
                    i+=8;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //and(1,0)
                }else if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '1' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '0' && x.charAt(i+7) == ')'){
                    resp = resp + '0';
                    i+=8;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //and(0,1)
                }else if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '0' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '1' && x.charAt(i+7) == ')'){
                    resp = resp + '0';
                    i+=8;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //and(0,0)
                }else if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '0' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '0' && x.charAt(i+7) == ')'){
                    resp = resp + '0';
                    i+=8;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(0,0)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '0' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '0' && x.charAt(i+6) == ')'){
                    resp = resp + '0';
                    i+=7;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(1,1)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '1' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '1' && x.charAt(i+6) == ')'){
                    resp = resp + '1';
                    i+=7;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(1,0)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '1' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '0' && x.charAt(i+6) == ')'){
                    resp = resp + '1';
                    i+=7;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(0,1)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '0' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '1' && x.charAt(i+6) == ')'){
                    resp = resp + '1';
                    i+=7;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //not(0)
                }else if(x.charAt(i) == 'n' && x.charAt(i+1) == 'o' && x.charAt(i+2) == 't' && x.charAt(i+3) == '(' && x.charAt(i+4) == '0' && x.charAt(i+5) == ')'){
                    resp = resp + "1";
                    i+=6;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //not(1)
                }else if(x.charAt(i) == 'n' && x.charAt(i+1) == 'o' && x.charAt(i+2) == 't' && x.charAt(i+3) == '(' && x.charAt(i+4) == '1' && x.charAt(i+5) == ')'){
                    resp = resp + "0";
                    i+=6;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                }else{
                    resp = resp + x.charAt(i);
                    i++;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                }
            }else if(i+9 < x.length()){
                //and(1,1,1)
                if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '1' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '1' && x.charAt(i+7) == ',' && x.charAt(i+8) == '1' && x.charAt(i+9) == ')'){
                    resp = resp + '1';
                    i+=10;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //and(1,1,0)
                }else if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '1' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '1' && x.charAt(i+7) == ',' && x.charAt(i+8) == '0' && x.charAt(i+9) == ')'){
                    resp = resp + '0';
                    i+=10;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //and(1,0,1)
                }else if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '1' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '0' && x.charAt(i+7) == ',' && x.charAt(i+8) == '1' && x.charAt(i+9) == ')'){
                    resp = resp + '0';
                    i+=10;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //and(0,1,1)
                }else if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '0' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '1' && x.charAt(i+7) == ',' && x.charAt(i+8) == '1' && x.charAt(i+9) == ')'){
                    resp = resp + '0';
                    i+=10;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //and(0,0,1)
                }else if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '0' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '0' && x.charAt(i+7) == ',' && x.charAt(i+8) == '1' && x.charAt(i+9) == ')'){
                    resp = resp + '0';
                    i+=10;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //and(0,1,0)
                }else if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '0' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '1' && x.charAt(i+7) == ',' && x.charAt(i+8) == '0' && x.charAt(i+9) == ')'){
                    resp = resp + '0';
                    i+=10;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //and(1,0,0)
                }else if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '1' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '0' && x.charAt(i+7) == ',' && x.charAt(i+8) == '0' && x.charAt(i+9) == ')'){
                    resp = resp + '0';
                    i+=10;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //and(0,0,0)
                }else if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '0' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '0' && x.charAt(i+7) == ',' && x.charAt(i+8) == '0' && x.charAt(i+9) == ')'){
                    resp = resp + '0';
                    i+=10;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(0,0,0)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '0' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '0' && x.charAt(i+6) == ',' && x.charAt(i+7) == '0' && x.charAt(i+8) == ')'){
                    resp = resp + '0';
                    i+=9;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(1,0,0)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '1' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '0' && x.charAt(i+6) == ',' && x.charAt(i+7) == '0' && x.charAt(i+8) == ')'){
                    resp = resp + '1';
                    i+=9;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(0,1,0)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '0' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '1' && x.charAt(i+6) == ',' && x.charAt(i+7) == '0' && x.charAt(i+8) == ')'){
                    resp = resp + '1';
                    i+=9;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(0,0,1)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '0' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '0' && x.charAt(i+6) == ',' && x.charAt(i+7) == '1' && x.charAt(i+8) == ')'){
                    resp = resp + '1';
                    i+=9;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(1,1,0)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '1' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '1' && x.charAt(i+6) == ',' && x.charAt(i+7) == '0' && x.charAt(i+8) == ')'){
                    resp = resp + '1';
                    i+=9;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(0,1,1)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '0' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '1' && x.charAt(i+6) == ',' && x.charAt(i+7) == '1' && x.charAt(i+8) == ')'){
                    resp = resp + '1';
                    i+=9;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(1,0,1)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '1' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '0' && x.charAt(i+6) == ',' && x.charAt(i+7) == '1' && x.charAt(i+8) == ')'){
                    resp = resp + '1';
                    i+=9;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(1,1,1)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '1' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '1' && x.charAt(i+6) == ',' && x.charAt(i+7) == '1' && x.charAt(i+8) == ')'){
                    resp = resp + '1';
                    i+=9;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //and(1,1)
                }else if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '1' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '1' && x.charAt(i+7) == ')'){
                    resp = resp + '1';
                    i+=8;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //and(1,0)
                }else if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '1' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '0' && x.charAt(i+7) == ')'){
                    resp = resp + '0';
                    i+=8;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //and(0,1)
                }else if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '0' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '1' && x.charAt(i+7) == ')'){
                    resp = resp + '0';
                    i+=8;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //and(0,0)
                }else if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '0' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '0' && x.charAt(i+7) == ')'){
                    resp = resp + '0';
                    i+=8;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(0,0)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '0' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '0' && x.charAt(i+6) == ')'){
                    resp = resp + '0';
                    i+=7;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(1,1)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '1' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '1' && x.charAt(i+6) == ')'){
                    resp = resp + '1';
                    i+=7;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(1,0)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '1' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '0' && x.charAt(i+6) == ')'){
                    resp = resp + '1';
                    i+=7;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(0,1)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '0' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '1' && x.charAt(i+6) == ')'){
                    resp = resp + '1';
                    i+=7;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //not(0)
                }else if(x.charAt(i) == 'n' && x.charAt(i+1) == 'o' && x.charAt(i+2) == 't' && x.charAt(i+3) == '(' && x.charAt(i+4) == '0' && x.charAt(i+5) == ')'){
                    resp = resp + "1";
                    i+=6;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //not(1)
                }else if(x.charAt(i) == 'n' && x.charAt(i+1) == 'o' && x.charAt(i+2) == 't' && x.charAt(i+3) == '(' && x.charAt(i+4) == '1' && x.charAt(i+5) == ')'){
                    resp = resp + "0";
                    i+=6;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                }else{
                    resp = resp + x.charAt(i);
                    i++;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                }
            }else if(i+8 < x.length()){
                //or(0,0,0)
                if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '0' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '0' && x.charAt(i+6) == ',' && x.charAt(i+7) == '0' && x.charAt(i+8) == ')'){
                    resp = resp + '0';
                    i+=9;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(1,0,0)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '1' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '0' && x.charAt(i+6) == ',' && x.charAt(i+7) == '0' && x.charAt(i+8) == ')'){
                    resp = resp + '1';
                    i+=9;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(0,1,0)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '0' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '1' && x.charAt(i+6) == ',' && x.charAt(i+7) == '0' && x.charAt(i+8) == ')'){
                    resp = resp + '1';
                    i+=9;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(0,0,1)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '0' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '0' && x.charAt(i+6) == ',' && x.charAt(i+7) == '1' && x.charAt(i+8) == ')'){
                    resp = resp + '1';
                    i+=9;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(1,1,0)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '1' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '1' && x.charAt(i+6) == ',' && x.charAt(i+7) == '0' && x.charAt(i+8) == ')'){
                    resp = resp + '1';
                    i+=9;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(0,1,1)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '0' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '1' && x.charAt(i+6) == ',' && x.charAt(i+7) == '1' && x.charAt(i+8) == ')'){
                    resp = resp + '1';
                    i+=9;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(1,0,1)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '1' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '0' && x.charAt(i+6) == ',' && x.charAt(i+7) == '1' && x.charAt(i+8) == ')'){
                    resp = resp + '1';
                    i+=9;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(1,1,1)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '1' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '1' && x.charAt(i+6) == ',' && x.charAt(i+7) == '1' && x.charAt(i+8) == ')'){
                    resp = resp + '1';
                    i+=9;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //and(1,1)
                }else if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '1' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '1' && x.charAt(i+7) == ')'){
                    resp = resp + '1';
                    i+=8;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //and(1,0)
                }else if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '1' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '0' && x.charAt(i+7) == ')'){
                    resp = resp + '0';
                    i+=8;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //and(0,1)
                }else if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '0' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '1' && x.charAt(i+7) == ')'){
                    resp = resp + '0';
                    i+=8;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //and(0,0)
                }else if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '0' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '0' && x.charAt(i+7) == ')'){
                    resp = resp + '0';
                    i+=8;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(0,0)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '0' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '0' && x.charAt(i+6) == ')'){
                    resp = resp + '0';
                    i+=7;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(1,1)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '1' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '1' && x.charAt(i+6) == ')'){
                    resp = resp + '1';
                    i+=7;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(1,0)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '1' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '0' && x.charAt(i+6) == ')'){
                    resp = resp + '1';
                    i+=7;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(0,1)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '0' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '1' && x.charAt(i+6) == ')'){
                    resp = resp + '1';
                    i+=7;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //not(0)
                }else if(x.charAt(i) == 'n' && x.charAt(i+1) == 'o' && x.charAt(i+2) == 't' && x.charAt(i+3) == '(' && x.charAt(i+4) == '0' && x.charAt(i+5) == ')'){
                    resp = resp + "1";
                    i+=6;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //not(1)
                }else if(x.charAt(i) == 'n' && x.charAt(i+1) == 'o' && x.charAt(i+2) == 't' && x.charAt(i+3) == '(' && x.charAt(i+4) == '1' && x.charAt(i+5) == ')'){
                    resp = resp + "0";
                    i+=6;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                }else{
                    resp = resp + x.charAt(i);
                    i++;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                }
            }else if(i+7 < x.length()){
                //and(1,1)
                if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '1' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '1' && x.charAt(i+7) == ')'){
                    resp = resp + '1';
                    i+=8;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //and(1,0)
                }else if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '1' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '0' && x.charAt(i+7) == ')'){
                    resp = resp + '0';
                    i+=8;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //and(0,1)
                }else if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '0' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '1' && x.charAt(i+7) == ')'){
                    resp = resp + '0';
                    i+=8;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //and(0,0)
                }else if(x.charAt(i) == 'a' && x.charAt(i+1) == 'n' && x.charAt(i+2) == 'd' && x.charAt(i+3) == '(' && x.charAt(i+4) == '0' &&
                x.charAt(i+5) == ',' && x.charAt(i+6) == '0' && x.charAt(i+7) == ')'){
                    resp = resp + '0';
                    i+=8;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(0,0)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '0' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '0' && x.charAt(i+6) == ')'){
                    resp = resp + '0';
                    i+=7;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(1,1)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '1' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '1' && x.charAt(i+6) == ')'){
                    resp = resp + '1';
                    i+=7;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(1,0)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '1' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '0' && x.charAt(i+6) == ')'){
                    resp = resp + '1';
                    i+=7;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(0,1)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '0' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '1' && x.charAt(i+6) == ')'){
                    resp = resp + '1';
                    i+=7;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //not(0)
                }else if(x.charAt(i) == 'n' && x.charAt(i+1) == 'o' && x.charAt(i+2) == 't' && x.charAt(i+3) == '(' && x.charAt(i+4) == '0' && x.charAt(i+5) == ')'){
                    resp = resp + "1";
                    i+=6;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //not(1)
                }else if(x.charAt(i) == 'n' && x.charAt(i+1) == 'o' && x.charAt(i+2) == 't' && x.charAt(i+3) == '(' && x.charAt(i+4) == '1' && x.charAt(i+5) == ')'){
                    resp = resp + "0";
                    i+=6;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                }else{
                    resp = resp + x.charAt(i);
                    i++;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                }
            }else if(i+6 < x.length()){
                //or(0,0)
                if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '0' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '0' && x.charAt(i+6) == ')'){
                    resp = resp + '0';
                    i+=7;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(1,1)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '1' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '1' && x.charAt(i+6) == ')'){
                    resp = resp + '1';
                    i+=7;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(1,0)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '1' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '0' && x.charAt(i+6) == ')'){
                    resp = resp + '1';
                    i+=7;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //or(0,1)
                }else if(x.charAt(i) == 'o' && x.charAt(i+1) == 'r' && x.charAt(i+2) == '(' && x.charAt(i+3) == '0' && x.charAt(i+4) == ',' &&
                x.charAt(i+5) == '1' && x.charAt(i+6) == ')'){
                    resp = resp + '1';
                    i+=7;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //not(0)
                }else if(x.charAt(i) == 'n' && x.charAt(i+1) == 'o' && x.charAt(i+2) == 't' && x.charAt(i+3) == '(' && x.charAt(i+4) == '0' && x.charAt(i+5) == ')'){
                    resp = resp + "1";
                    i+=6;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //not(1)
                }else if(x.charAt(i) == 'n' && x.charAt(i+1) == 'o' && x.charAt(i+2) == 't' && x.charAt(i+3) == '(' && x.charAt(i+4) == '1' && x.charAt(i+5) == ')'){
                    resp = resp + "0";
                    i+=6;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                }else{
                    resp = resp + x.charAt(i);
                    i++;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                }
            }else if(i+5 < x.length()){
                //not(0)
                if(x.charAt(i) == 'n' && x.charAt(i+1) == 'o' && x.charAt(i+2) == 't' && x.charAt(i+3) == '(' && x.charAt(i+4) == '0' && x.charAt(i+5) == ')'){
                    resp = resp + "1";
                    i+=6;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                //not(1)
                }else if(x.charAt(i) == 'n' && x.charAt(i+1) == 'o' && x.charAt(i+2) == 't' && x.charAt(i+3) == '(' && x.charAt(i+4) == '1' && x.charAt(i+5) == ')'){
                    resp = resp + "0";
                    i+=6;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                }else{
                    resp = resp + x.charAt(i);
                    i++;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                }
            }else{
                    resp = resp + x.charAt(i);
                    i++;
                    //MyIO.println(resp);
                    ResolverAlgebra(x, i, resp);
                }
        }
        return resp;
    }

    public static void main(String[] args){
        String algebra = "";
        char qntleitura = ' ';
        do{
            algebra = MyIO.readLine();
            qntleitura = algebra.charAt(0);
            if(qntleitura != '0'){
                algebra = TirarEspaco(algebra);
                algebra = ColocarNumeros(algebra, qntleitura);
                //MyIO.println(algebra);
                algebra = ResolverAlgebra(algebra, 0, "");
                
            }   
        }while(qntleitura != '0');
    }
}