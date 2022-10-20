/*Faca um programa que leia um numero inteiro n indicando o numero de
valores reais que devem ser lidos e salvos sequencialmente em um arquivo texto. Apos a leitura
dos valores, devemos fechar o arquivo. Em seguida, reabri-lo e fazer a leitura de tras para frente
e mostre todos os valores lidos na tela. Nessa questao, voce nao pode usar, arrays, strings ou qualquer estrutura de dados.
A entrada padrao eh composta por um numero inteiro n e mais n numeros reais. A saida padrao
corresponde a n numeros reais mostrados um por linha de saida. */
#include <stdio.h>
//chamada recursiva que tem a utilidade de printar os numeros lidos ao contrario
void InversoPrint(int i, int num, FILE *fp2){
    double real = 0;
    if(i < num){
        fscanf(fp2, "%lf", &real);
        InversoPrint(++i, num, fp2);
        printf("%g\n", real);
    }
}

int main(){
    int num;
    double real;
    //abrir o arquivo para escrita
    FILE *fp = fopen("output.txt", "w");
    scanf("%d", &num);
    //escrever no arquivo os numeros lidos
    for(int i = 0; i < num; i++){
        scanf("%lf", &real);
        fprintf(fp, "%f\n", real);
    }
    fclose(fp);
    //abrir o arquivo para leitura
    FILE *fp2 = fopen("output.txt", "r");
    //fazer a chamada recursiva
    InversoPrint(0, num, fp2);
    fclose(fp2);
    return 0;
}