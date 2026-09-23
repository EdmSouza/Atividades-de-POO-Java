import java.util.*;

public abstract class Arquivo{
    private String nome;
    private double tamanhoMB;

    public Arquivo(String nome, double tamanhoMB) {
        this.nome = nome;
        this.tamanhoMB = tamanhoMB;
    }

    public String getNome() {
        return nome;
    }

    public abstract void abrir();

    public String getDetalhes() {
        return "Nome: " + nome + ", Tamanho: " + tamanhoMB + " MB";
    }

    static class PDF extends Arquivo{
        public PDF(String nome, double tamanhoMB){
            super(nome, tamanhoMB);
        }

        @Override
        public void abrir(){
            System.out.println("Abrindo documento PDF: " + getDetalhes());
        }
    }

    static class Imagem extends Arquivo{
        public Imagem(String nome, double tamanhoMB){
            super(nome, tamanhoMB);
        }

        @Override
        public void abrir() {
            System.out.println("Abrindo arquivo de imagem: " + getDetalhes());
        }
    }

    static class PastaSegura<T extends Arquivo>{
        List<T> historicodeAcesso;
        Map<String, T> arquivosporNome;
        Set<String> arquivosbloqueados;

        public PastaSegura(){
            this.historicodeAcesso = new ArrayList<>();
            this.arquivosporNome = new HashMap<>();
            this.arquivosbloqueados = new HashSet<>();
            arquivosbloqueados.add("Virus.pdf");
        }

        public void addArquivo(T arquivo){
            if(arquivosbloqueados.contains(arquivo.getNome())){
                System.out.println("Arquivo bloqueado: " + arquivo.getNome());
            } else {
                arquivosporNome.put(arquivo.getNome(), arquivo);
                System.out.println("Arquivo adicionado: " + arquivo.getNome());
            }
        }

        public void openArquivo(String nome){
            T arquivo = arquivosporNome.get(nome);
            if(arquivo != null){
                if(arquivosbloqueados.contains(nome)){
                    System.out.println("Arquivo bloqueado: " + nome);
                } else {
                    arquivo.abrir();
                    historicodeAcesso.add(arquivo);
                }
            }else{
                System.out.println("Arquivo não encontrado: " + nome);
            }
        }
    }

    public static void main(String[] args) {
        PastaSegura<PDF> pastaSeguraPDF = new PastaSegura<>();
        PDF doc1 = new PDF("TCC.pdf", 2.5);
        PDF doc2 = new PDF("Virus.pdf", 5.0);
        pastaSeguraPDF.addArquivo(doc1);
        pastaSeguraPDF.addArquivo(doc1);
        pastaSeguraPDF.addArquivo(doc2);
        pastaSeguraPDF.openArquivo("TCC.pdf");
        pastaSeguraPDF.openArquivo("Virus.pdf");
        for(Arquivo arquivo : pastaSeguraPDF.historicodeAcesso){
            System.out.println("Acessado: " + arquivo.getDetalhes());
        }
    }
}