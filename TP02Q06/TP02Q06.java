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
    
    //metodo que verifica se a String que contem tempo possui horas
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
        int resp = 0;
        int m = 0; // minutos
        int h = 0; // horas
        int i = 0; //indice
        String horas = "";
        String minutos = "";
        boolean temmin = temMinutos(str);
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
            
            if(temmin == true){
                i++;
                while(str.charAt(i) != 'm'){
                    minutos = minutos + str.charAt(i);
                    i++;
                }
                
                m = Integer.parseInt(minutos);
                h = Integer.parseInt(horas);

            }else{
                h = Integer.parseInt(horas);
            }

            
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
        
        
        
        Arq.close();
    }

    
}
//------------------------------------------------------------------------
//                                 FILA
//------------------------------------------------------------------------
class Fila {
    private Filme[] array;
    private int primeiro; // Remove do indice "primeiro".
    private int ultimo; // Insere no indice "ultimo".
 
 
    /**
     * Construtor da classe.
     */
    public Fila () {
       this(6);
    }
 
 
    /**
     * Construtor da classe.
     * @param tamanho Tamanho da fila.
     */
    public Fila (int tamanho){
       array = new Filme[tamanho+1];
       primeiro = ultimo = 0;
    }
 
 
    /**
     * Insere um elemento na ultima posicao da fila.
     * @param x Filme elemento a ser inserido.
     * @throws Exception Se a fila estiver cheia.
     */
    public void inserir(Filme x) throws Exception {
 
       //validar insercao
       if (((ultimo + 1) % array.length) == primeiro) {
          throw new Exception("Erro ao inserir!");
       }
 
       array[ultimo] = x;
       ultimo = (ultimo + 1) % array.length;
    }
 
 
    /**
     * Remove um elemento da primeira posicao da fila e movimenta 
     * os demais elementos para o primeiro da mesma.
     * @return resp filme elemento a ser removido.
     * @throws Exception Se a fila estiver vazia.
     */
    public Filme remover() throws Exception {
 
       //validar remocao
       if (primeiro == ultimo) {
          throw new Exception("Erro ao remover!");
       }
 
       Filme resp = array[primeiro];
       primeiro = (primeiro + 1) % array.length;
       return resp;
    }
 
 
    /**
     * Mostra o array
     */
    public void mostrar (){
       int count = 0;
 
       for(int i = ultimo-1; i != primeiro - 1; i = ((i - 1) % array.length)) {
            MyIO.print("[" + count++ + "] ");
            array[i].imprimir();
       }
 
    }
 
 
    public void mostrarRec(){
        System.out.print("[ ");
        mostrarRec(primeiro);
        System.out.println("]");
     }
  
     public void mostrarRec(int i){
        if(i != ultimo){
            MyIO.print("[" + i + "] ");
            array[i].imprimir();
            mostrarRec((i + 1) % array.length);
        }
     }
    /**
     * Retorna um boolean indicando se a fila esta vazia
     * @return boolean indicando se a fila esta vazia
     */
    public boolean isVazia() {
       return (primeiro == ultimo); 
    }
}


//------------------------------------------------------------------------
//                                   PILHA
//------------------------------------------------------------------------

class Fila2Pilha{

    private Fila f1, f2;
 
    public Fila2Pilha(){
      f1 = new Fila(6);
      f2 = new Fila(6);
    }
 
    public Fila2Pilha(int tamanho){
      f1 = new Fila (tamanho);
      f2 = new Fila (tamanho);
    }
 
    public void empilhar(Filme elemento) throws Exception {
      while(!f1.isVazia()){
        f2.inserir(f1.remover());
      }
 
      f1.inserir(elemento);
 
      while(!f2.isVazia()){
        f1.inserir(f2.remover());
      }
    }
 
    public Filme desempilhar() throws Exception {
      return f1.remover();
    }
 
    public void mostrar(){
      f1.mostrar();
    }
 
    public boolean isVazia(){
      return f1.isVazia();
    }
}

class TP02Q06{
    public static boolean isFim(String str){
        return(str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M');
    }

    //retorna a string sem os 3 chars iniciais
    public static String removerTresChars(String str){
        String resp = "";
        for(int i = 3; i < str.length(); i++){
            resp = resp + str.charAt(i);
        }

        return resp;
    }

    //retorna a string sem os 2 chars iniciais
    public static String removerDoisChars(String str){
        String resp = "";
        for(int i = 2; i < str.length(); i++){
            resp = resp + str.charAt(i);
        }

        return resp;
    }

    //Faz a leitura da String ate encontrar um espaco em branco
    public static String lerAteEspaco(String str){
        String resp = "";
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ' '){
                i = str.length();
            }else{
                resp = resp + str.charAt(i);
            }
        }
        return resp;
    }

    //Retorna apenas o endereco do filme
    public static String apenasEnderecoFilme(String str){
        String resp = "";
        int count = 0; //contar espacos em branco e so salvar em resp se count >= 1 (Ou seja depois do primeiro espaco)
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ' '){
                count++;
                if(count == 1){
                    i++;//Pular o caractere do primeiro espaco
                }
            }

            if(count >= 1){
                resp = resp + str.charAt(i);
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
        Filme[] filmes = new Filme[200];
        Filme replica = new Filme();
        Fila2Pilha pilha = new Fila2Pilha(200);
        for(int i = 0; i<count; i++){
            filmes[i] = new Filme();
            filmes[i].ler(entradas[i]);
            replica = filmes[i].clone();
            pilha.empilhar(replica);
        }

        //Segunda parte

        int n = 0;
        String segundaEntrada = "";
        int pos = 0;
        Filme removido = new Filme();

        n = MyIO.readInt();
        
        for(int i = 0; i < n; i++){
            segundaEntrada = MyIO.readLine();
            if(segundaEntrada.charAt(0) == 'I'){
                
                segundaEntrada = removerDoisChars(segundaEntrada);
                
                filmes[++count] = new Filme();
                filmes[count].ler(segundaEntrada);
                replica = filmes[count].clone();
                 
                pilha.empilhar(replica);

            }else{
                
                removido = pilha.desempilhar();
                MyIO.println("(R) " + removido.getNome());
            }
        }
            

        pilha.mostrar();
           
    }
}
