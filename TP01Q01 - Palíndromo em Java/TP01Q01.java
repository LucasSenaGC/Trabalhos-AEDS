/*Crie um metodo iterativo que recebe uma string como parametro e
retorna true se essa e um palindromo. Na sa?da padrao, para cada linha de entrada, escreva
uma linha de sa?da com SIM/NAO indicando se a linha e um pal?ndromo. Destaca-se que uma
linha de entrada pode ter caracteres nao letras. A entrada termina com a leitura de FIM. */
class TP01Q01{
    public static boolean isFim(String frase){
        return (frase.charAt(0) == 'F' && frase.charAt(1) == 'I' && frase.charAt(2) == 'M');
    }

    public static boolean isPalindromo(String frase){
        boolean resp = false;
        int j = frase.length() - 1;
        for(int i = 0; i < frase.length(); i++){
            if(frase.charAt(i) == frase.charAt(j)){
                j--;
                resp = true;
            }else{
                resp = false;
                i = frase.length();
            }
        }
        return resp;
    }

    public static void main(String[] args){
        String frase = "";
        frase = MyIO.readLine();
        boolean resp = isFim(frase);
        while(resp == false){
            if(isPalindromo(frase) == true ){
                MyIO.println("SIM");
            }else{
                MyIO.println("NAO");                
            }
            frase = MyIO.readLine();
            resp = isFim(frase);

        }


    }
}