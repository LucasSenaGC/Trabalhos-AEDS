#include <stdio.h>
#include <string.h>

int IsFim(char frase[]){
    if(frase[0] == 'F' && frase[1] == 'I' && frase[2] == 'M' && frase[3] == '\n'){
        return 1;
    }else{
        return 0;
    }
}

int IsPalindromo(char frase[]){
    int j = strlen(frase) - 2;
    int resp = 0;
    for(int i = 0; i < strlen(frase) - 2; i++){
        if(frase[i] == frase[j]){
            j--;
            resp = 1;
        }else{
            i = strlen(frase);
            resp = 0;
        }
    }
    return resp;
}

int main(){
    char frase[100] = "";
    fgets(frase, 100, stdin);
    while(IsFim(frase) == 0){
        if(IsPalindromo(frase) == 1){
            printf("SIM\n");
        }else{
            printf("NAO\n");
        }
        fgets(frase, 100, stdin);
    }
    return 0;
}