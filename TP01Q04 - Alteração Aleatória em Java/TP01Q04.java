import java.util.Random;

/* Alteracao Aleatoria em Java - Crie um metodo iterativo que recebe uma string, sorteia
duas letras minusculas aleatorias (codigo ASCII ? ?a? e ? ?z?), substitui todas as ocorrencias da
primeira letra na string pela segunda e retorna a string com as alteracoes efetuadas. Na sa?da
padrao, para cada linha de entrada, execute o metodo desenvolvido nesta questao e mostre a
string retornada como uma linha de sa?da. Abaixo, observamos um exemplo de entrada supondo
que para a primeira linha as letras sorteados foram o ?a? e o ?q?. Para a segunda linha, foram o
?e? e o ?k?.
A classe Random do Java gera numeros (ou letras) aleatorios e o exemplo abaixo mostra uma
letra minuscula na tela. Em especial, destacamos que: i) seed eh a semente para geracao de
numeros aleatorios; ii) nesta questao, por causa da correcao automatica, a seed sera quatro; iii)
a disciplina de Estat?stica e Probabilidade faz uma discussao sobre ?aleatorio?.*/

class TP01Q04{
    //metodo que recebe uma string e verifica se ela eh a palavra "FIM".
    public static boolean IsFim(String frase){
        return(frase.charAt(0) == 'F' && frase.charAt(1) == 'I' && frase.charAt(2) == 'M');
    }
    

    
    /*Metodo que recebe uma String e dois char para trocar todas as ocorrencias de um do char recebido 
    por um outro obtido aleatoriamente e retorna a String modificada */
    public static String TrocaDeLetraAleatoria(String frase, char substituir, char letranova){
        String novaFrase = ""; 
        //MyIO.println("Frase = " + frase); usado para teste 
        
        /*percorrer toda string em busca da ocorrencia da Letra que recebemos no paramentro("substituir")
            -Caso a letra na posicao i da string "frase" seja = a letra selecionada para fazer a substituicao, 
            selecionamos outra letra aleatoria e fazemos a troca
            -Caso a condicao nao seja verdadeira, mantem a letra da String original(frase)
        */
        for(int i = 0; i < frase.length(); i++){
            if(frase.charAt(i) == substituir){ 
                //MyIO.println("substituir = " + substituir); //testes
                //MyIO.println("letranova = " + letranova);
                novaFrase = novaFrase + letranova; 
            } else{
                novaFrase = novaFrase + frase.charAt(i);
            }
        }        
        return novaFrase;
    }
    public static void main(String[] args){
        String frase = "";
        char letranova;
        char substituir;
        int i = 0;
        Random gerador = new Random();
        gerador.setSeed(4); 
        do{
            frase = MyIO.readLine();
            if(IsFim(frase) == false){
                substituir = ((char) ('a' + (Math.abs(gerador.nextInt()% 26))));//letra que sera substituida em caso de ocorrencia na String frase 
                letranova = ((char) ('a' + (Math.abs(gerador.nextInt()% 26))));
                MyIO.println(TrocaDeLetraAleatoria(frase, substituir, letranova));
                //TrocaDeLetraAleatoria(frase, substituir, letranova); // teste a entrada e saida
                //i++; usado para testar a entrada
            }
        }while(IsFim(frase) == false);//(i < 7);
    }
}