import java.io.*;
import java.net.*;

/*Leia duas strings sendo que a primeira eh o nome de
uma pagina web e a segunda, seu endere¸co. Por exemplo, ?Pontif?cia Universidade Catolica de
Minas Gerais? e ?www.pucminas.br?. Em seguida, mostre na tela o numero de vogais (sem e
com acento), consoantes e dos padroes ?< br >? e ?< table >? que aparecem no codigo dessa
pagina. A entrada padrao eh composta por varias linhas. Cada uma contem varias strings sendo
que a primeira e um endereco web e as demais o nome dessa pagina web. A ultima linha da
entrada padrao contem a palavra ?FIM?. A sa?da padrao contem varias linhas sendo que cada
uma apresenta o numero de ocorrencia (valor xi entre par?enteses) de cada caractere ou string
solicitado. Cada linha de sa?da sera da seguinte forma: a(x1) e(x2) i(x3) o(x4) u(x5) ´a(x6) ´e(x7)
´?(x8) ´o(x9) ´u(x10) `a(x11) `e(x12) `?(x13) `o(x14) `u(x15) ?a(x16) ?o(x17) ?a(x19) ?e(x19) ??(x20) ?o(x21)
?u(x22) consoante(x23) < br >(x24) < table >(x25) nomepagina(x26). */
class TP01Q08{
    //Verifica se o nome = FIM
    public static boolean IsFim(String str){
        return (str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M');
    }

    //Verifica se uma letra eh consoante
    public static boolean IsConsoante(char x){
        boolean resp = false;
        // se for uma letra e nao for vogal eh consoante
        if((x >= 'A' && x <= 'Z' || x >= 'a' && x <= 'Z') && x != 'a' && x != 'A' && x != 'e' && x != 'E' 
            && x != 'i' && x != 'I' && x != 'o' && x != 'O' && x != 'u' && x != 'U'){
                resp =true;
            }
        return resp;
    }

    //adquirir o texto html
    public static String getHtml(String endereco){
      URL url;
      InputStream is = null;
      BufferedReader br;
      String resp = "", line;

      try {
        url = new URL(endereco);
        is = url.openStream();  // throws an IOException
        br = new BufferedReader(new InputStreamReader(is));

        while ((line = br.readLine()) != null) {
            resp += line + "\n";
        }
      } catch (MalformedURLException mue) {
        mue.printStackTrace();
      } catch (IOException ioe) {
        ioe.printStackTrace();
      } 

      try {
        is.close();
      } catch (IOException ioe) {
         // nothing to see here

      }

      return resp;
   }
    public static void main(String[] args){
        String endereco, nome, html;
        int x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12, x13, x14, x15, x16, x17, x18, x19, x20, x21, x22, x23,
        x24, x25;
        nome = MyIO.readLine();
        while(IsFim(nome) == false){
            x1 = 0; x2 = 0; x3 = 0; x4 = 0; x5 = 0; x6 = 0; x7 = 0; x8 = 0; x9 = 0; x10 = 0; x11 = 0; x12 = 0; x13 = 0; 
            x14 = 0; x15 = 0; x16 = 0; x17 = 0; x18 = 0; x19 = 0; x20 = 0; x21 = 0; x22 = 0; x23 = 0; x24 = 0; x25 = 0;
            endereco = MyIO.readLine();
            html = getHtml(endereco);
            //Ao fazer a leitura caracter por caracter verificamos se existe alguma das letras pedidas
            // caso essa condicao seja verdade somamos um
            for(int i = 0; i < html.length(); i++){
                if(html.charAt(i) == 'a'){
                    x1++;
                }else if(html.charAt(i) == 'e'){
                    x2++;
                }else if(html.charAt(i) == 'i'){
                    x3++;
                }else if(html.charAt(i) == 'o'){
                    x4++;
                }else if(html.charAt(i) == 'u'){
                    x5++;
                }else if(html.charAt(i) == (char)225){
                    x6++;
                }else if(html.charAt(i) == (char)233){
                    x7++;
                }else if(html.charAt(i) == (char)237){
                    x8++;
                }else if(html.charAt(i) == (char)243){
                    x9++;
                }else if(html.charAt(i) == (char)250){
                    x10++;
                }else if(html.charAt(i) == (char)224){
                    x11++;
                }else if(html.charAt(i) == (char)232){
                    x12++;
                }else if(html.charAt(i) == (char)236){
                    x13++;
                }else if(html.charAt(i) == (char)242){
                    x14++;
                }else if(html.charAt(i) == (char)249){
                    x15++;
                }else if(html.charAt(i) == (char)227){
                    x16++;
                }else if(html.charAt(i) == (char)245){
                    x17++;
                }else if(html.charAt(i) == (char)226){
                    x18++;
                }else if(html.charAt(i) == (char)234){
                    x19++;
                }else if(html.charAt(i) == (char)238){
                    x20++;
                }else if(html.charAt(i) == (char)244){
                    x21++;
                }else if(html.charAt(i) == (char)251){
                    x22++;
                }else if(IsConsoante(html.charAt(i)) == true){
                    x23++;
                }else if(i <= html.length() - 4){
                    if(html.charAt(i) == '<' && html.charAt(i+1) == 'b' && html.charAt(i+2) == 'r' && html.charAt(i+3) == '>'){
                        x24++;
                        i+=4;
                    }
                }else if(i < html.length() - 6){
                    if(html.charAt(i) == '<' && html.charAt(i+1) == 't' && html.charAt(i+2) == 'a' && html.charAt(i+3) == 'b' 
                        && html.charAt(i+4) == 'l' && html.charAt(i+5) == 'e' && html.charAt(i+6) == '>' ){
                        x25++;
                        i+=6;
                    }
                }
            }
            System.out.println("a("+ x1 + ")" + " " + "e(" + x2 + ")" + " " + "i(" + x3 + ")" + " " + 
                 "o(" + x4 + ")" + " " + "u(" + x5 + ")" + " " + (char)225 +  "(" + x6 + ")" + " " 
                 +(char)233 +  "(" + x7 + ")" + " " + (char)237 +  "(" + x8 + ")" + " " + (char)243 +  
                 "(" + x9 + ")" + " " + (char)250 +  "(" + x10 + ")" + " " + (char)224 +  "(" + x11 + ")"
                  + " " + (char)232 +  "(" + x12 + ")" + " " + (char)236 +  "(" + x13 + ")" + " " + 
                  (char)242 +  "(" + x14 + ")" + " " + (char)249 +  "(" + x15 + ")" + " " + (char)227 +  
                  "(" + x16 + ")" + " " + (char)245 +  "(" + x17 + ")" + " " + (char)226 +  "(" + x18 + ")" 
                  + " " + (char)234 +  "(" + x19 + ")" + " " + (char)238 +  "(" + x20 + ")" + " " 
                  + (char)244 +  "(" + x21 + ")" + " " + (char)251 +  "(" + x22 + ")" + " " 
                  + "consoante" +  "(" + x23 + ")" + " " + "<br>" +  "(" + x24 + ")" + " " 
              + "<table>" +  "(" + x25 + ")" + " " + nome);

            
              nome = MyIO.readLine();
        }
        
        
    }
}
