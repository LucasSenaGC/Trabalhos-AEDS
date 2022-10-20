#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

/*Crie um metodo iterativo que recebe uma string e retorna true se a mesma eh
composta somente por vogais. Crie outro metodo iterativo que recebe uma string e retorna
true se a mesma eh composta somente por consoantes. Crie um terceiro metodo iterativo que
recebe uma string e retorna true se a mesma corresponde a um numero inteiro. Crie um quarto
metodo iterativo que recebe uma string e retorna true se a mesma corresponde a um numero
real. Na saida padrao, para cada linha de entrada, escreva outra de saida da seguinte forma X1
X2 X3 X4 onde cada Xi eh um booleano indicando se a eh entrada eh: composta somente por vogais
(X1); composta somente somente por consoantes (X2); um numero inteiro (X3); um numero real
(X4). Se Xi for verdadeiro, seu valor sera SIM, caso contrario, NAO. */

    //verifica se a string eh FIM
    bool IsFim(char recebida[]){
        return (recebida[0] == 'F' && recebida[1] == 'I' && recebida[2] == 'M');
    }
    //recebe um char e retorna se ele eh vogal ou nao
    bool IsVogal(char verificar){
        bool resp = false;
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
    bool IsConsoante(char verificar){
        bool resp = false;
        //se for uma letra e nao for vogal ela eh consoante
        if(((verificar >= 'a' && verificar <= 'z') || (verificar >= 'A' && verificar <= 'Z')) && IsVogal(verificar) == false){
            resp = true;
        }
        return resp;
    }

    //Verifica se toda a frase eh composta apenas por vogais
    bool FraseIsVogal(char recebida[]){
        bool resp = false;
        for(int i = 0; i < strlen(recebida) - 1; i++){
            //se a letra atual for vogal resp fica true
            if(IsVogal(recebida[i]) == true){
                resp = true;
            //se uma nao eh entao resp fica false e para de olhar a frase
            }else{
                resp = false;
                i = strlen(recebida);
            }
        }        

        return resp;
    }

    //Verifica se toda a frase eh composta apenas por consoantes
    bool FraseIsConsoante(char recebida[]){
        bool resp = false;
        for(int i = 0; i < strlen(recebida) - 1; i++){
            //se a letra atual for consoante resp fica true
            if(IsConsoante(recebida[i]) == true){
                resp = true;
            //se uma nao eh entao resp fica false e para de olhar a frase
            }else{
                resp = false;
                i = strlen(recebida);
            }
        }        
        return resp;
    }
    //verifica se o char eh um inteiro
    bool IsInteiro(char verificar){
        bool resp = false;
        //se for um numero retorna true
        if(verificar >= '0' && verificar <= '9'){
            resp = true;
        }else{
            resp = false;
        }
        return resp;
    }
    //verifica se a string eh composta apenas por inteiros
    bool FraseIsInteiro(char recebida[]){
        bool resp = false;
        //verifica se toda string eh composta apenas por numeros caso nao retorna false
        for(int i = 0; i < strlen(recebida) - 1; i++){
            if(IsInteiro(recebida[i]) == true){
                resp = true;
            }else{
                resp = false;
                i = strlen(recebida);
            }
        }
        return resp;
    }
    //verifica se um char eh um numero real(vale observar que nesse metodo os chars virgula e ponto sao considerados como condicao para ser um real)
    bool IsReal(char verificar){
        bool resp = false;
        //se for um numero inteiro ou um ponto ou uma virgula devemos por considerar q por enquanto ele eh um numero real
        if(IsInteiro(verificar) || verificar == ',' || verificar == '.'){
            resp = true;
        }
        return resp;
    }

    //Verifica se a frase eh composta apenas por numeros Real
    bool FraseIsReal(char recebida[]){
        bool resp = false;
        int count = 0;
        //se for apenas um char olhar se ele eh um numero interio, pq assim ele tbm sera real
        if(strlen(recebida) == 0){
            if(FraseIsInteiro(recebida) == true){
                resp = true;
            }
        }else{
            //se for maior que um, contar os pontos e verificar se todos os numeros recebidos pode ser classificados como reais
            if(strlen(recebida) > 0){
                for(int i = 0; i < strlen(recebida) - 1; i++){
                    if(recebida[i] == ',' || recebida[i] == '.'){
                        count++;
                    }
                    if(count <= 1 && IsReal(recebida[i]) == true){
                        resp = true;
                    }else{
                        resp = false;
                        i = strlen(recebida);
                    }
                }
            }
        }
        return resp;
        
    }

    int main(){
    char recebida[100];
    bool X1, X2, X3, X4;
    fgets(recebida, 100, stdin);
    if(IsFim(recebida) == false){
        do{
            X1 = FraseIsVogal(recebida);
            X2 = FraseIsConsoante(recebida);
            X3 = FraseIsInteiro(recebida);
            X4 = FraseIsReal(recebida);
            
            if(X1 == false){
                printf("NAO ");
            }else{
                printf("SIM ");
            }
            if(X2 == false){
                printf("NAO ");
            }else{
                printf("SIM ");
            }
            if(X3 == false){
                printf("NAO ");
            }else{
                printf("SIM ");
            }
            if(X4 == false){
                printf("NAO\n");
            }else{
                printf("SIM\n");
            }
            strcpy(recebida, "");
            fgets(recebida, 100, stdin);
        }while(IsFim(recebida) == false);
    }
    return 0;
    }
