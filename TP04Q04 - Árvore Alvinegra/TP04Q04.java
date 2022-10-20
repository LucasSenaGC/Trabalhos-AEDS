import java.text.SimpleDateFormat;
import java.util.Date;

class Filme{
    SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
    private String nome;  
    private String tituloOriginal; 
    private Date datalancamento; 
    private int duracao; 
    private String genero; 
    private String idiomaOriginal; 
    private String situacao;
    private float orcamento; 
    private String[] palavrasChave; 

    Filme(){
        nome = "";
        tituloOriginal = "";
        datalancamento = null;
        duracao = 0;
        genero = "";
        idiomaOriginal = "";
        situacao = "";
        orcamento = 0;
        palavrasChave = null;
    }

    Filme(String nome, String tituloOriginal, Date datalancamento, int duracao, String genero, String idiomaOriginal, String situacao
        , float orcamento, String[] palavrasChave){
        this.nome = nome;
        this.tituloOriginal = tituloOriginal;
        this.datalancamento = datalancamento;
        this.duracao = duracao;
        this.genero = genero;
        this.idiomaOriginal = idiomaOriginal;
        this.situacao = situacao;
        this.orcamento = orcamento;
        this.palavrasChave = palavrasChave;
    }

    //------------------------------------------------------CLONE---------------------------------------------------------------

    public Filme clone(){
        Filme copia = new Filme(this.nome, this.tituloOriginal, this.datalancamento, this.duracao, this.genero, this.idiomaOriginal
        , this.situacao, this.orcamento, this.palavrasChave);
        
        return copia;
    }

    //--------------------------------------------------------GET--------------------------------------------------------------------
    public Date getDatalancamento() {
        return datalancamento;
    }

    public int getDuracao() {
        return duracao;
    }

    public String getGenero() {
        return genero;
    }

    public String getIdiomaOriginal() {
        return idiomaOriginal;
    }

    public String getNome() {
        return nome;
    }

    public float getOrcamento() {
        return orcamento;
    }

    public String[] getPalavrasChave() {
        return palavrasChave;
    }

    public String getSituacao() {
        return situacao;
    }
    

    public String getTituloOriginal() {
        return tituloOriginal;
    }

    //------------------------------------------------------SET----------------------------------------------------------------------
    public void setDatalancamento(Date datalancamento) {
        this.datalancamento = datalancamento;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setIdiomaOriginal(String idiomaOriginal) {
        this.idiomaOriginal = idiomaOriginal;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setOrcamento(float orcamento) {
        this.orcamento = orcamento;
    }

    public void setPalavrasChave(String[] palavrasChave) {
        this.palavrasChave = palavrasChave;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public void setTituloOriginal(String tituloOriginal) {
        this.tituloOriginal = tituloOriginal;
    }

    //---------------------------------------------------------------------------------------------------------------------------------
            /*nome tituloOriginal dataLancamento duracao genero idiomaOriginal situacao orcamento [palavrasChave] */
    public void imprimir(){
        MyIO.print(this.nome + " " + this.tituloOriginal + " " + sdf.format(this.datalancamento) + " " + this.duracao  + " " + this.genero  + " " +
        this.idiomaOriginal + " " + this.situacao + " " + this.orcamento + " " );
        mostrarPalavraschaves();
    }

    public void mostrarPalavraschaves(){
        if(this.palavrasChave[0].contains("[") == false){
            MyIO.print("[");
            for(int i = 0; i < this.palavrasChave.length; i++){
                if(i < this.palavrasChave.length - 1){
                    MyIO.print(this.palavrasChave[i] + "," + " ");
                }else{
                    MyIO.println(this.palavrasChave[i] + "]");
                }
            }
        }else{
            MyIO.println(this.palavrasChave[0]);
        }
        
    }


    //Remove as tags presentes na String
    public String semtags(String str){
        String resp = "";
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '<'){
                while(str.charAt(i) != '>'){
                    i++;
                }
                
            }else{
                resp = resp + str.charAt(i);
            }
                
        }
        return resp;
    }

    //remove caracteres indesejados entre ',' e ';' e coloca um espaco
    public String RemoverEntreVirgulas(String str){
        String resp = "";
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ','){
                while(str.charAt(i) != ';'){
                    i++;
                }
                resp = resp + " ";
            }else{
                resp = resp + str.charAt(i);
            }
        }  
        return resp;
        
    }

    //Retorna o conteudo da String ate a abertura de um parenteses
    public String parentesesStop(String str){
        String resp = "";
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '('){
                i = str.length();
            }else{
                resp = resp + str.charAt(i);
            }
        }
        return resp;
    }

    //Remove o conteudo da String que apartir do & ate chegar no ;
    public String ecomercialRemove(String str){
        String resp = "";
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '&'){
                while(str.charAt(i) != ';')i++;
                i++;
            }else{
                resp = resp + str.charAt(i);
            }
        }
        return resp;
    }

    //Remove os espacos em branco entre as frases da String
    public String removeEspaco(String str){
        String resp = "";
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) != ' '){
                resp = resp + str.charAt(i);
            }
        }
        return resp;
    }

    //Troca os espacos em branco por virgulas
    public String trocaEspacoPorVirgula(String str){
        String resp = "";
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ' '){
                resp = resp + ',';
            }else{
                resp = resp + str.charAt(i);
            }
        }
        return resp;
    }



    //metodo que verifica se a String que contem tempo possui horas
    public boolean temHoras(String str){
        boolean resp = false;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == 'h'){
                resp = true;
                i = str.length();
            }
        }
        return resp;
    }

    //metodo que verifica se a String que contem tempo possui minutos
    public boolean temMinutos(String str){
        boolean resp = false;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == 'm'){
                resp = true;
                i = str.length();
            }
        }
        return resp;
    }
    //converte o tempo obtido em uma String(SEM ESPACO) para minutos e devolve esse resultado em um inteiro
    public int tempoEmMinutos(String str){
        //MyIO.println("STRING PRA TEMPO = " + str);
        int resp = 0;
        int m = 0; // minutos
        int h = 0; // horas
        int i = 0; //indice
        String horas = "";
        String minutos = "";
        if(temHoras(str) == false){
            
            while(str.charAt(i) != 'm'){
                minutos = minutos + str.charAt(i);
                i++;
            }
            
            resp = Integer.parseInt(minutos);
        
        }else{
            
            while(str.charAt(i) != 'h'){
                horas = horas + str.charAt(i);
                i++;
            }

            i++;
            if(temMinutos(str) == true){
                while(str.charAt(i) != 'm'){
                    minutos = minutos + str.charAt(i);
                    i++;
                }
            }else{
                minutos = "0";
            }
            

            //MyIO.println("CONVERTER M = " + minutos);
            //MyIO.println("CONVERTER H = " + horas);
            m = Integer.parseInt(minutos);
            h = Integer.parseInt(horas);
            resp = (h*60) + m;
        }
        
        return resp;
    }

    //verifica se a string possui titulo Original escrito;
    public boolean temTituloOriginal(String str){
        boolean resp = false;
        if(str.contains("tulo original")){
            resp = true;
        }

        return resp;
    }

    //remove Titulo original da String
    public String removeTituloOriginal(String str){
        String resp = "";
        if(temTituloOriginal(str) == true){
            for(int i = 17; i < str.length(); i++){
                resp = resp + str.charAt(i);
            }
        }else{
            resp = str;
        }
        return resp;
    }

    //verifica se a string possui Situacao escrito;
    public boolean temSituacao(String str){
        boolean resp = false;
        if(str.contains("Situa")){
            resp = true;
        }
        return resp;
    }

    //remove Situacao da String;
    public String removeSituacao(String str){
        String resp = "";
        if(temSituacao(str) == true){
            for(int i = 10; i < str.length(); i++){
                resp = resp + str.charAt(i);
            }
        }else{
            resp = str;
        }
        return resp;
    }
    
    //remove Idioma Original da String;
    public String removeIdiomaOriginal(String str){
        String resp = "";
        for(int i = 16; i < str.length(); i++){
            resp = resp + str.charAt(i);
        }

        return resp;
    }

    //remove Orcamento da String;
    public String removeOrcamento(String str){
        String resp = "";
        for(int i = 10; i < str.length(); i++){
            resp = resp + str.charAt(i);
        }

        return resp;
    }

    //remove $ da String;
    public String removeCifrao(String str){
        String resp = "";
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) != '$'){
                resp = resp + str.charAt(i);
            }
        }
        return resp;
    }

    //remove virgula da String;
    public String removeVirgula(String str){
        String resp = "";
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) != ','){
                resp = resp + str.charAt(i);
            }
        }
        return resp;
    }

    //converte a String para um valor float, caso o valor seja '-' o orcamento eh zero
    public float converterOrcamentoParaValor(String str){
        float resp;
        if(str.contains("-")){
            resp = 0;
        }else{
            resp = Float.parseFloat(str);
        }
        return resp;
    }

    public void ler(String entrada) throws Exception{
        //Abrir o Arquivo para leitura
        Arq.openRead("/tmp/filmes/"+entrada);
        String linha = " ";
        linha = Arq.readLine();
        
        //------------------------------------NOME-----------------------------------
        //ler ate <title> para obter o nome
        while(!linha.contains("<title>")){
            linha = Arq.readLine();
        }
        //remover () & e tags e espaco caso seja necessario e dar set no nome
        linha = ecomercialRemove(parentesesStop(semtags(linha))).trim();
        setNome(linha);

        //---------------------------------DATA-------------------------------------
        //ler ate <span class="release"> para obter data
        while(!linha.contains("<span class=\"release\">")){
            linha = Arq.readLine();
        }
        linha = parentesesStop(Arq.readLine().trim());
        setDatalancamento(sdf.parse(linha));

        //------------------------------GENERO--------------------------------------
        //ler ate <a href= para obter genero
        while(!linha.contains("<a href=")){
            linha = Arq.readLine();
        }
        linha = trocaEspacoPorVirgula(ecomercialRemove(RemoverEntreVirgulas(semtags(linha).trim())));
        setGenero(linha);

        //---------------------------DURACAO----------------------------------------
        //ler ate <span class="runtime"> para obter duracao
        int tempo = 0;
        while(!linha.contains("<span class=\"runtime\">")){
            linha = Arq.readLine();
        }
        String aux = linha;
        while(!aux.contains("</span>")){
            if(aux.contains("h") || aux.contains("m")){
                linha = aux.trim();
                aux = Arq.readLine();
            }else{
                aux = Arq.readLine();
            }
        }
        //transformar a String obtida de tempo em minutos(tipo int)
        tempo = tempoEmMinutos(removeEspaco(linha));
        setDuracao(tempo);

        //------------------------------TITULO ORIGINAL-------------------------------------------------------//
        //ler ate a primeira tag strong
        while(!linha.contains("<strong>")){
            linha = Arq.readLine();
        }
        
        //como existem html que nao possui titulo original, eh necessario verificar 
        //se nao tem estamos na linha de situacao e o titulo original eh o proprio nome
        if(linha.contains("original")){
            linha = semtags(linha).trim();
            aux = removeTituloOriginal(linha);
            setTituloOriginal(aux);
        }else{
            setTituloOriginal(getNome());
        }

        //-----------------------------------------SITUACAO--------------------------------------------------//
        //verifica se estamos na linha que contem titulo original ou na linha que ja esta em situacao
        //caso seja na linha do titulo original, caminhamos ate a linha que contem situacao
        if(linha.contains("original")){
            while(!linha.contains("Situa")){
                linha = Arq.readLine();
            }
            linha = semtags(linha).trim();
            linha = removeSituacao(linha).trim();
        //caso nao, ja estamos na linha certa, basta tratar
        }else{
            linha = semtags(linha).trim();
            linha = removeSituacao(linha).trim();
        }
        setSituacao(linha);

        //------------------------------------------IDIOMA ORIGINAL-------------------------------------------//
        //ir ate a linha que contem idioma original e tratar
        while(!linha.contains("Idioma original")){
            linha = Arq.readLine();
        }
        linha = semtags(linha).trim();
        linha = removeIdiomaOriginal(linha).trim();
        setIdiomaOriginal(linha);

        //------------------------------------------- ORCAMENTO -------------------------------------
        //a proxima linha eh orcamento
        float valor = 0;
        linha = Arq.readLine();
        linha = semtags(linha).trim();
        linha = removeVirgula(removeCifrao(removeOrcamento(linha))).trim();
        valor = converterOrcamentoParaValor(linha);
        setOrcamento(valor);
        
        //------------------------------------------PALAVRAS CHAVES----------------------------------

        //ler ate Palavras-chave e depois ate </ul> pegando apenas as linhas que contem <li>
        String[] temp = new String[100];
        int count = 0;
        //ir ate a linha Palavras-chave
        while(!linha.contains("Palavras-chave")){
            linha = Arq.readLine();
        }
        linha = Arq.readLine();
        linha = Arq.readLine();
        //ir pegar apenas as linhas que tem <li>
        if(linha.contains("Nenhuma palavra-chave foi adicionada")){
            temp[count] = "[]";
            setPalavrasChave(temp);
            
        }else{
            while(!linha.contains("</ul>")){
                if(linha.contains("<li>")){
                    temp[count] = semtags(linha).trim();
                    linha = Arq.readLine();
                    count++;
                }else{
                    linha = Arq.readLine();
                }
            }
            String[] pchave = new String[count];
            for(int i = 0; i < count; i++){
                pchave[i] = temp[i];
            }
            setPalavrasChave(pchave);
        }
        //MyIO.println("FILME SETADO = " + getNome());
        
        
        Arq.close();
    }

    
}

class NoAN {
    public boolean cor;
    public Filme elemento;
    public NoAN esq, dir;
  
    public NoAN() {
      this(new Filme());
    }
  
    public NoAN(Filme elemento) {
      this(elemento, false, null, null);
    }
  
    public NoAN(Filme elemento, boolean cor) {
      this(elemento, cor, null, null);
    }
  
    public NoAN(Filme elemento, boolean cor, NoAN esq, NoAN dir) {
      this.cor = cor;
      this.elemento = elemento;
      this.esq = esq;
      this.dir = dir;
    }
}


class Alvinegra {
    private NoAN raiz; // Raiz da arvore.
    private int comparacoes; 
    /**
     * Construtor da classe.
     */
    public Alvinegra() {
       raiz = null;
       comparacoes = 0;
    }
 
    /**
     * Metodo publico iterativo para pesquisar elemento.
     * 
     * @param elemento Elemento que sera procurado.
     * @return <code>true</code> se o elemento existir,
     *         <code>false</code> em caso contrario.
     */
    public boolean pesquisar(String elemento) {
        MyIO.print("raiz ");
        return pesquisar(elemento, raiz);
    }
 
    /**
     * Metodo privado recursivo para pesquisar elemento.
     * 
     * @param elemento Elemento que sera procurado.
     * @param i        NoAN em analise.
     * @return <code>true</code> se o elemento existir,
     *         <code>false</code> em caso contrario.
     */
    private boolean pesquisar(String elemento, NoAN i) {
        boolean resp;
        comparacoes++;
        if (i == null) {
            resp = false;
        }else if (elemento.compareTo(i.elemento.getTituloOriginal()) == 0) {
            resp = true;
            comparacoes++;
        }else if (elemento.compareTo(i.elemento.getTituloOriginal()) < 0) {
            MyIO.print("esq "); 
            resp = pesquisar(elemento, i.esq);
            comparacoes+=2;
        }else {
            MyIO.print("dir "); 
            resp = pesquisar(elemento, i.dir);    
        }
      return resp;
    }
 
    /**
     * Metodo publico iterativo para exibir elementos.
     */
    public void caminharCentral() {
       System.out.print("[ ");
       caminharCentral(raiz);
       System.out.println("]");
    }
 
    /**
     * Metodo privado recursivo para exibir elementos.
     * 
     * @param i NoAN em analise.
     */
    private void caminharCentral(NoAN i) {
       if (i != null) {
          caminharCentral(i.esq); // Elementos da esquerda.
          System.out.print(i.elemento + ((i.cor) ? "(p) " : "(b) ")); // Conteudo do no.
          caminharCentral(i.dir); // Elementos da direita.
       }
    }
 
    /**
     * Metodo publico iterativo para exibir elementos.
     */
    public void caminharPre() {
       System.out.print("[ ");
       caminharPre(raiz);
       System.out.println("]");
    }
 
    /**
     * Metodo privado recursivo para exibir elementos.
     * 
     * @param i NoAN em analise.
     */
    private void caminharPre(NoAN i) {
       if (i != null) {
          System.out.print(i.elemento + ((i.cor) ? "(p) " : "(b) ")); // Conteudo do no.
          caminharPre(i.esq); // Elementos da esquerda.
          caminharPre(i.dir); // Elementos da direita.
       }
    }
 
    /**
     * Metodo publico iterativo para exibir elementos.
     */
    public void caminharPos() {
       System.out.print("[ ");
       caminharPos(raiz);
       System.out.println("]");
    }
 
    /**
     * Metodo privado recursivo para exibir elementos.
     * 
     * @param i NoAN em analise.
     */
    private void caminharPos(NoAN i) {
       if (i != null) {
          caminharPos(i.esq); // Elementos da esquerda.
          caminharPos(i.dir); // Elementos da direita.
          System.out.print(i.elemento + ((i.cor) ? "(p) " : "(b) ")); // Conteudo do no.
       }
    }
 
    /**
     * Metodo publico iterativo para inserir elemento.
     * 
     * @param elemento Elemento a ser inserido.
     * @throws Exception Se o elemento existir.
     */
    public void inserir(Filme elemento) throws Exception {
       // Se a arvore estiver vazia
       if (raiz == null) {
          raiz = new NoAN(elemento);
          //System.out.println("Antes, zero elementos. Agora, raiz(" + raiz.elemento + ").");
 
       // Senao, se a arvore tiver um elemento
       } else if (raiz.esq == null && raiz.dir == null) {
          if (elemento.getTituloOriginal().compareTo(raiz.elemento.getTituloOriginal()) < 0) {
             raiz.esq = new NoAN(elemento);
             //System.out.println("Antes, um elemento. Agora, raiz(" + raiz.elemento + ") e esq(" + raiz.esq.elemento + ").");
          } else {
             raiz.dir = new NoAN(elemento);
             //System.out.println("Antes, um elemento. Agora, raiz(" + raiz.elemento + ") e dir(" + raiz.dir.elemento + ").");
          }
 
       // Senao, se a arvore tiver dois elementos (raiz e dir)
       } else if (raiz.esq == null) {
          if (elemento.getTituloOriginal().compareTo(raiz.elemento.getTituloOriginal()) < 0) {
             raiz.esq = new NoAN(elemento);
             //System.out.println("Antes, dois elementos(A). Agora, raiz(" + raiz.elemento + "), esq (" + raiz.esq.elemento + ") e dir(" + raiz.dir.elemento + ").");
 
          } else if (elemento.getTituloOriginal().compareTo(raiz.dir.elemento.getTituloOriginal()) < 0) {
             raiz.esq = new NoAN(raiz.elemento);
             raiz.elemento = elemento;
             //System.out.println("Antes, dois elementos(B). Agora, raiz(" + raiz.elemento + "), esq (" + raiz.esq.elemento + ") e dir(" + raiz.dir.elemento + ").");
 
          } else {
             raiz.esq = new NoAN(raiz.elemento);
             raiz.elemento = raiz.dir.elemento;
             raiz.dir.elemento = elemento;
             //System.out.println("Antes, dois elementos(C). Agora, raiz(" + raiz.elemento + "), esq (" + raiz.esq.elemento + ") e dir(" + raiz.dir.elemento + ").");
          }
          raiz.esq.cor = raiz.dir.cor = false;
 
       // Senao, se a arvore tiver dois elementos (raiz e esq)
       } else if (raiz.dir == null) {
          if (elemento.getTituloOriginal().compareTo(raiz.elemento.getTituloOriginal()) > 0) {
             raiz.dir = new NoAN(elemento);
             //System.out.println("Antes, dois elementos(D). Agora, raiz(" + raiz.elemento + "), esq (" + raiz.esq.elemento + ") e dir(" + raiz.dir.elemento + ").");
 
          } else if (elemento.getTituloOriginal().compareTo(raiz.esq.elemento.getTituloOriginal()) > 0) {
             raiz.dir = new NoAN(raiz.elemento);
             raiz.elemento = elemento;
             //System.out.println("Antes, dois elementos(E). Agora, raiz(" + raiz.elemento + "), esq (" + raiz.esq.elemento + ") e dir(" + raiz.dir.elemento + ").");
 
          } else {
             raiz.dir = new NoAN(raiz.elemento);
             raiz.elemento = raiz.esq.elemento;
             raiz.esq.elemento = elemento;
             //System.out.println("Antes, dois elementos(F). Agora, raiz(" + raiz.elemento + "), esq (" + raiz.esq.elemento + ") e dir(" + raiz.dir.elemento + ").");
          }
          raiz.esq.cor = raiz.dir.cor = false;
 
       // Senao, a arvore tem tres ou mais elementos
       } else {
          //System.out.println("Arvore com tres ou mais elementos...");
          inserir(elemento, null, null, null, raiz);
       }
       raiz.cor = false;
    }
 
    private void balancear(NoAN bisavo, NoAN avo, NoAN pai, NoAN i) {
       // Se o pai tambem e preto, reequilibrar a arvore, rotacionando o avo
       if (pai.cor == true) {
          // 4 tipos de reequilibrios e acoplamento
          if (pai.elemento.getTituloOriginal().compareTo(avo.elemento.getTituloOriginal()) > 0) { // rotacao a esquerda ou direita-esquerda
             if (i.elemento.getTituloOriginal().compareTo(pai.elemento.getTituloOriginal()) > 0) {
                avo = rotacaoEsq(avo);
             } else {
                avo = rotacaoDirEsq(avo);
             }
          } else { // rotacao a direita ou esquerda-direita
             if (i.elemento.getTituloOriginal().compareTo(pai.elemento.getTituloOriginal()) < 0) {
                avo = rotacaoDir(avo);
             } else {
                avo = rotacaoEsqDir(avo);
             }
          }
          if (bisavo == null) {
             raiz = avo;
          } else if (avo.elemento.getTituloOriginal().compareTo(bisavo.elemento.getTituloOriginal()) < 0) {
             bisavo.esq = avo;
          } else {
             bisavo.dir = avo;
          }
          // reestabelecer as cores apos a rotacao
          avo.cor = false;
          avo.esq.cor = avo.dir.cor = true;
          //System.out.println("Reestabeler cores: avo(" + avo.elemento + "->branco) e avo.esq / avo.dir("
          //      + avo.esq.elemento + "," + avo.dir.elemento + "-> pretos)");
       } // if(pai.cor == true)
    }
 
    /**
     * Metodo privado recursivo para inserir elemento.
     * 
     * @param elemento Elemento a ser inserido.
     * @param avo      NoAN em analise.
     * @param pai      NoAN em analise.
     * @param i        NoAN em analise.
     * @throws Exception Se o elemento existir.
     */
    private void inserir(Filme elemento, NoAN bisavo, NoAN avo, NoAN pai, NoAN i) throws Exception {
       if (i == null) {
          if (elemento.getTituloOriginal().compareTo(pai.elemento.getTituloOriginal()) < 0) {
             i = pai.esq = new NoAN(elemento, true);
          } else {
             i = pai.dir = new NoAN(elemento, true);
          }
          if (pai.cor == true) {
             balancear(bisavo, avo, pai, i);
          }
       } else {
          // Achou um 4-no: eh preciso fragmeta-lo e reequilibrar a arvore
          if (i.esq != null && i.dir != null && i.esq.cor == true && i.dir.cor == true) {
             i.cor = true;
             i.esq.cor = i.dir.cor = false;
             if (i == raiz) {
                i.cor = false;
             } else if (pai.cor == true) {
                balancear(bisavo, avo, pai, i);
             }
          }
          if (elemento.getTituloOriginal().compareTo(i.elemento.getTituloOriginal()) < 0) {
             inserir(elemento, avo, pai, i, i.esq);
          } else if (elemento.getTituloOriginal().compareTo(i.elemento.getTituloOriginal()) > 0) {
             inserir(elemento, avo, pai, i, i.dir);
          } else {
             throw new Exception("Erro inserir (elemento repetido)!");
          }
       }
    }
 
    private NoAN rotacaoDir(NoAN no) {
       //System.out.println("Rotacao DIR(" + no.elemento + ")");
       NoAN noEsq = no.esq;
       NoAN noEsqDir = noEsq.dir;
 
       noEsq.dir = no;
       no.esq = noEsqDir;
 
       return noEsq;
    }
 
    private NoAN rotacaoEsq(NoAN no) {
       //System.out.println("Rotacao ESQ(" + no.elemento + ")");
       NoAN noDir = no.dir;
       NoAN noDirEsq = noDir.esq;
 
       noDir.esq = no;
       no.dir = noDirEsq;
       return noDir;
    }
 
    private NoAN rotacaoDirEsq(NoAN no) {
       no.dir = rotacaoDir(no.dir);
       return rotacaoEsq(no);
    }
 
    private NoAN rotacaoEsqDir(NoAN no) {
       no.esq = rotacaoEsq(no.esq);
       return rotacaoDir(no);
    }

    /**
     * Retorna o tempo em que esse metodo foi chamado.
     */
    public long now(){
        return new Date().getTime();
    }

    /**
    * Cria um arquivo com a matricula, tempo de execucao e o numero de comparacoes.
    */
    public void makeLog(long inicio, long fim){
        Arq.openWrite("matricula avinegra.txt");
        Arq.println("Matricula: 735102\tTempo de execucao: " + (fim-inicio)/1000.0 + "s.\t" + "Comparacoes: " + Integer.toString(comparacoes));
        Arq.close();
        
    }

    boolean isNoTipo4(NoAN i){
        return (i.esq != null && i.dir != null && i.esq.cor == true && i.dir.cor == true);
     }
     


}
 








class TP04Q04{
    public static boolean isFim(String str){
        return(str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M');
    }
    
    public static String lerPosEspaco(String str){
        String resp = "";
        int count = 0;
        for(int i = 0; i < str.length(); i++){
            if(count > 0){
                resp = resp + str.charAt(i);    
            }

            if(str.charAt(i) == ' '){
                count++;
            }
        }
        return resp;
    }
    
    public static void main(String[] args) throws Exception{

        //ler a entrada e salvar em um vetor de Strings de tamanho 100
        String temp[] = new String[100];
        int count = 0;
        temp[0] = MyIO.readLine();
        while(isFim(temp[count]) == false){
            temp[++count] = MyIO.readLine();
            
        }
        
        //salvar em uma String de tamanho fixo = count
        String entradas[] = new String[count];
        for(int i = 0; i < count; i++){
            if(temp[i].contains("Zack Snyder.html")){
                entradas[i] = "Liga da Justica de Zack Snyder.html";
            }else{
                entradas[i] = temp[i];
            }
        }
        /*Criar um array de filmes e fazer a leitura de cada html, fazendo sets em seus atributos e criar uma lista 
        inserindo objetos no final da mesma*/
        Filme[] filmes = new Filme[count];
        Filme replica = new Filme();
        Alvinegra arvore = new Alvinegra();
        for(int i = 0; i<count; i++){
            filmes[i] = new Filme();
            filmes[i].ler(entradas[i]);
            replica = filmes[i].clone();
            arvore.inserir(replica);
        }

        //arvore.caminharCentral();

 
        //Segunda Parte
        String aux = "";
        long inicio, fim;
        boolean test = false;
        inicio = arvore.now();
        do{
            aux = MyIO.readLine();
            if(isFim(aux) == false){
                MyIO.println(aux);
                test = arvore.pesquisar(aux);
                if(test == true){
                    MyIO.println("SIM");
                }else{
                    MyIO.println("NAO");
                }
            }
        }while(isFim(aux) == false);
        fim = arvore.now();
        arvore.makeLog(inicio, fim);
        
    }
}