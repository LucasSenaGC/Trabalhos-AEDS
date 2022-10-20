/*O Imperador Julio Cesar foi um dos principais nomes do
Imperio Romano. Entre suas contribuicoes, temos um algoritmo de criptografia chamado ?Ciframento de Cesar?. 
Segundo os historiadores, Cesar utilizava esse algoritmo para criptografar as
mensagens que enviava aos seus generais durante as batalhas. A ideia basica eh um simples deslocamento de caracteres. 
Assim, por exemplo, se a chave utilizada para criptografar as mensagens
for 3, todas as ocorrencias do caractere ?a? sao substitu?das pelo caractere ?d?, as do ?b? por ?e?,
e assim sucessivamente. Crie um metodo iterativo que recebe uma string como parametro e
retorna outra contendo a entrada de forma cifrada. Neste exerc?cio, suponha a chave de ciframento tres. Na sa?da padrao, para cada linha de entrada, 
escreva uma linha com a mensagem criptografada.
 */
class TP01Q03{
    public static boolean isFIM(String frase){
        return (frase.charAt(0) == 'F' && frase.charAt(1) == 'I' && frase.charAt(2) == 'M');
    }

    public static void Cifra(String frase){
        String FraseCesar = "";
        int aux = 0;
        for(int i = 0; i < frase.length(); i++){
            aux = ((int) frase.charAt(i)) + 3;
            FraseCesar = FraseCesar + (char) aux;
        }
        MyIO.println(FraseCesar);
    }
    public static void main(String[] args){
        String frase = "";
        frase = MyIO.readLine();
        while(isFIM(frase) == false){
            Cifra(frase);
            frase = MyIO.readLine();
        }

    }
}