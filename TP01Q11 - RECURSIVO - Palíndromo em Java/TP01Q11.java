//-----------------------RECURSIVO-------------------------------------
/*Crie um metodo iterativo que recebe uma string como parametro e
retorna true se essa e um palindromo. Na sa?da padrao, para cada linha de entrada, escreva
uma linha de saida com SIM/NAO indicando se a linha e um palindromo. Destaca-se que uma
linha de entrada pode ter caracteres nao letras. A entrada termina com a leitura de FIM. */
public class TP01Q11 {
    //metodo que retorna se a frase inserida eh FIM ou nao
    public static boolean IsFim(String frase){
        return (frase.charAt(0) == 'F' && frase.charAt(1) == 'I' && frase.charAt(2) == 'M');
    }  

    //Forma recursiva para verificar se uma palavra eh palindromo
    //recebe a frase, posicao final do caracter e a inicial
    public static boolean RecIsPalindromo(String frase, int posInicial, int posFinal){
        boolean resp = false;
        //se a posicao final nao estiver chegado na final, ou seja ainda nao comparamos todas as letras
        if(posInicial < posFinal){
            //se as letras equidistantes(no caso se a palavra for realmente um palindromo) forem iguais
            // a resp eh = true, avancamos a posicao inicial em uma unidade e diminuimos um para posFinal
            // assim podemos comparar os caracteres da frase atraves de uma chamada recursiva
            if(frase.charAt(posInicial) == frase.charAt(posFinal)){
                resp = true;
                RecIsPalindromo(frase, ++posInicial, --posFinal);
            }else{
                resp = false;
                return resp;
            }
        }
        return resp;
    }
    public static void main(String[] args){
        String frase = "";
        frase = MyIO.readLine();
        boolean resp = IsFim(frase);
        while(resp == false){
            if(RecIsPalindromo(frase, 0, frase.length() - 1) == true){
                MyIO.println("SIM");
            }else{
                MyIO.println("NAO");
            }
            frase = MyIO.readLine();
            resp = IsFim(frase);
        }
    }
}
