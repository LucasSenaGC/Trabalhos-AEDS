/*Crie um metodo iterativo que recebe uma string e retorna true se a mesma eh
composta somente por vogais. Crie outro metodo iterativo que recebe uma string e retorna
true se a mesma eh composta somente por consoantes. Crie um terceiro metodo iterativo que
recebe uma string e retorna true se a mesma corresponde a um numero inteiro. Crie um quarto
metodo iterativo que recebe uma string e retorna true se a mesma corresponde a um numero
real. Na saida padrao, para cada linha de entrada, escreva outra de saida da seguinte forma X1
X2 X3 X4 onde cada Xi eh um booleano indicando se a eh entrada eh: composta somente por vogais
(X1); composta somente somente por consoantes (X2); um numero inteiro (X3); um numero real
(X4). Se Xi for verdadeiro, seu valor sera SIM, caso contrario, NAO. */
class TP01Q06{
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

    //Verifica se toda a frase eh composta apenas por vogais
    public static boolean FraseIsVogal(String recebida){
        boolean resp = false;
        for(int i = 0; i < recebida.length(); i++){
            //se a letra atual for vogal resp fica true
            if(IsVogal(recebida.charAt(i)) == true){
                resp = true;
            //se uma nao eh entao resp fica false e para de olhar a frase
            }else{
                resp = false;
                i = recebida.length();
            }
        }        

        return resp;
    }

    //Verifica se toda a frase eh composta apenas por consoantes
    public static boolean FraseIsConsoante(String recebida){
        boolean resp = false;
        for(int i = 0; i < recebida.length(); i++){
            //se a letra atual for consoante resp fica true
            if(IsConsoante(recebida.charAt(i)) == true){
                resp = true;
            //se uma nao eh entao resp fica false e para de olhar a frase
            }else{
                resp = false;
                i = recebida.length();
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
    public static boolean FraseIsInteiro(String recebida){
        boolean resp = false;
        //verifica se toda string eh composta apenas por numeros caso nao retorna false
        for(int i = 0; i < recebida.length(); i++){
            if(IsInteiro(recebida.charAt(i)) == true){
                resp = true;
            }else{
                resp = false;
                i = recebida.length();
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
    public static boolean FraseIsReal(String recebida){
        boolean resp = false;
        int count = 0;
        //se for apenas um char olhar se ele eh um numero interio, pq assim ele tbm sera real
        if(recebida.length() == 1){
            if(FraseIsInteiro(recebida) == true){
                resp = true;
            }
        }else{
            //se for maior que um, contar os pontos e verificar se todos os numeros recebidos pode ser classificados como reais
            if(recebida.length() > 1){
                for(int i = 0; i < recebida.length(); i++){
                    if(recebida.charAt(i) == ',' || recebida.charAt(i) == '.'){
                        count++;
                    }
                    if(count <= 1 && IsReal(recebida.charAt(i)) == true){
                        resp = true;
                    }else{
                        resp = false;
                        i = recebida.length();
                    }
                }
            }
        }
        return resp;
        
    }

    public static void main(String[] args){
        String recebida = "";
        String output = "";
        boolean X1, X2, X3, X4;
        recebida = MyIO.readLine();
        while(IsFim(recebida) == false){
            X1 = FraseIsVogal(recebida);
            X2 = FraseIsConsoante(recebida);
            X3 = FraseIsInteiro(recebida);
            X4 = FraseIsReal(recebida);
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
            output = "";
        }
    }
}