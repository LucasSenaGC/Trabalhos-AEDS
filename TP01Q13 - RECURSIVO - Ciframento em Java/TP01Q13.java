//CIFRAMENTO RECURSIVO
class TP01Q13{
    //verifica se a palavra inserida eh = FIM
    public static boolean IsFIM(String frase){
        return (frase.charAt(0) == 'F' && frase.charAt(1) == 'I' && frase.charAt(2) == 'M');
    }

    //Metodo recursivo para o ciframento de cesar
    public static String ReqCifra(String frase, String FraseCesar, int i, int tamanho){
        //condicao de parada eh: quando percorrer toda a string frase ou seja
        // i = tamanho(frase.lengh()-1) paramos de chamar recursivamente o metodo e para o ultimo caracter
        // adicionamos +3 em seu numero ASCII, formando assim a frase Cifrada
        if(i == tamanho){
            FraseCesar = FraseCesar + (char) (frase.charAt(i) + 3);
        // se o i nao for igual ao tamanho, ou seja, ainda nao percorremos toda a string, temos q adicionar +3
        // para os caracteres do valor de i e passar isso como paramatro para frase de cesar    
        }else{
            FraseCesar = ReqCifra(frase, FraseCesar + (char) (frase.charAt(i) + 3), ++i, tamanho);
        }
        
        return FraseCesar;
        
    }
    public static void main(String[] args){
        String frase = "";
        String fraseCesar = "";
        frase = MyIO.readLine();
        while(IsFIM(frase) == false){
            fraseCesar = ReqCifra(frase, fraseCesar, 0, frase.length() - 1);
            frase = MyIO.readLine();
            MyIO.println(fraseCesar);
            fraseCesar = "";
        }

    }
}