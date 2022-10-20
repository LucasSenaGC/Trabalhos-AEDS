//----------------------------RECURSIVO_EM_C------------------------------------
/*Crie um metodo iterativo que recebe uma string como parametro e
retorna true se essa e um palindromo. Na saida padrao, para cada linha de entrada, escreva
uma linha de saida com SIM/NAO indicando se a linha e um palindromo. Destaca-se que uma
linha de entrada pode ter caracteres nao letras. A entrada termina com a leitura de FIM. */
#include <stdio.h>
#include <string.h>
//metodo que retorna se a frase inserida eh FIM ou nao
int IsFim(char frase[]){
    if(frase[0] == 'F' && frase[1] == 'I' && frase[2] == 'M'){
        return 1;
    }else{
        return 0;
    }
}
//Forma recursiva para verificar se uma palavra eh palindromo
//recebe a frase, posicao final do caracter e a inicial
int RecIsPalindromo(char frase[], int posInicial, int posFinal){
    int resp = 0;
    //se a posicao final nao estiver chegado na final, ou seja, ainda nao comparamos todas as letras(posInicial < posFinal)
    if(posInicial < posFinal){
        //se as letras que estao equidistantes(no caso se a palavra for realmente um palindromo) forem iguais
        // a reso eh = 1, avancamos a posicao inicial em uma unidade e diminuimos uma para posFinal
        // assim podemos comparar os caracteres da frase atraves de uma chamada recursiva
        if(frase[posInicial] == frase[posFinal]){
            resp = 1;
            RecIsPalindromo(frase, ++posInicial, --posFinal);
        }else{
            resp = 0;
            return resp;
        }
    }
    return resp;
}

int main(){
    char frase[500] = "";
    fgets(frase, 500, stdin);
    while(IsFim(frase) == 0){
        if(RecIsPalindromo(frase, 0, strlen(frase) - 2) == 1){
            printf("SIM\n");
        }else{
            printf("NAO\n");
        }
        fgets(frase, 500, stdin);
    }
    return 0;
}