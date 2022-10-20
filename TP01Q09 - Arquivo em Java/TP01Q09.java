/*Faca um programa que leia um numero inteiro n indicando o numero de
valores reais que devem ser lidos e salvos sequencialmente em um arquivo texto. Apos a leitura
dos valores, devemos fechar o arquivo. Em seguida, reabri-lo e fazer a leitura de tras para frente
usando os metodos getFilePointer e seek da classe RandomAccessFile e mostre todos os valores
lidos na tela. Nessa questao, voce nao pode usar, arrays, strings ou qualquer estrutura de dados.
A entrada padrao eh composta por um numero inteiro n e mais n numeros reais. A saida padrao
corresponde a n numeros reais mostrados um por linha de saida. */

class TP01Q09{
    // para printar de tras para frente basta fazer uma chamada recursiva
    public static void Inversoprint(int i, int num){
        double real = 0;
        //verifcar se o nosso i eh maior que o numero de vezes que temos q repitir
        //essa eh a condicao de parada da recursao
        if(i < num){
            real = Arq.readDouble();
            //o incremento deve vir antes (++i) senao a passagem de parametro nao funciona
            //quando i for > ou = a num os prints sao feitos de tras pra frente, ate fechar a recursao
            Inversoprint(++i, num);
            //para remover os ,000 devemos verificar antes se ele eh um inteiro
            // caso for devemos printar o numero inteiro para que a saida fique igual o pub.out
            if((int) real == real){
                MyIO.println((int)real);
            }else{
                MyIO.println(real);
            }

        }

    }
    public static void main(String[] args) throws Exception{
        int num;
        double real;
        //Abrir o arquivo output.txt para escrita
        Arq.openWrite("NumerosReais.txt");
        //ler o primeiro numero para saber quantos numeros devem ser lidos
        num = MyIO.readInt();
        //andar por todo arquivo printando os numeros reais
        for(int i = 0; i < num; i++){
            real = MyIO.readDouble();
            Arq.println(real);
        }
        //fechar o arquivo
        Arq.close();
        Arq.openRead("NumerosReais.txt");
        Inversoprint(0, num);
        

    }
}