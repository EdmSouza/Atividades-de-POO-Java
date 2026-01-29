package genericsandcollections;

import java.util.*;

public class Votacao {

    public static Map<String, List<String>> registrarVotos(List<String[]> votos) {

        Map<String, List<String>> mapaVotos = new HashMap<>();

        for (String[] voto : votos) {
            String eleitor = voto[0];
            String candidato = voto[1];

            mapaVotos
                .computeIfAbsent(candidato, k -> new ArrayList<>())
                .add(eleitor);
        }

        return mapaVotos;
    }


    public static void imprimirVotos(Map<String, List<String>> votosPorCandidato) {

        for (String candidato : votosPorCandidato.keySet()) {
            IO.println("Os votos para " + candidato + " foram de:");
            for (String eleitor : votosPorCandidato.get(candidato)) {
                IO.println("   " + eleitor);
            }
        }
    }


    public static void imprimirPercentagens(Map<String, List<String>> votosPorCandidato) {

        int totalVotos = votosPorCandidato.values()
                .stream()
                .mapToInt(List::size)
                .sum();

        List<Map.Entry<String, List<String>>> lista =
                new ArrayList<>(votosPorCandidato.entrySet());

        lista.sort((e1, e2) ->
                Integer.compare(e2.getValue().size(), e1.getValue().size()));

        IO.println("\nPercentagens:");
        for (Map.Entry<String, List<String>> entry : lista) {
            double perc = (entry.getValue().size() * 100.0) / totalVotos;
            System.out.printf("%s %.0f%%\n", entry.getKey(), perc);
        }
    }


    public static void imprimirSemVotos(Set<String> todos, Set<String> candidatos) {
        Set<String> semVotos = new HashSet<>(todos);
        semVotos.removeAll(candidatos);

        IO.println("\nCPFs que não receberam votos:");
        for (String cpf : semVotos) {
            IO.println(cpf);
        }
    }


    public static void imprimirEleitores(Set<String> eleitores) {
        System.out.println("\nEleitores:");
        for (String e : eleitores) {
            System.out.println(e);
        }
    }


    public static void imprimirCandidatosQueNaoVotaram(
            Set<String> candidatos, Set<String> eleitores) {

        Set<String> resultado = new HashSet<>(candidatos);
        resultado.removeAll(eleitores);

        System.out.println("\nReceberam voto mas não votaram:");
        for (String cpf : resultado) {
            System.out.println(cpf);
        }
    }

    public static void main(String[] args) {

        // Cada voto: { eleitor, candidato }
        List<String[]> votos = List.of(
                new String[]{"89789709809", "97645323567"},
                new String[]{"09867865645", "97645323567"},
                new String[]{"98789798877", "97645323567"},
                new String[]{"89789709809", "76567734562"},
                new String[]{"09867865645", "76567734562"}
        );

        Set<String> eleitores = new HashSet<>();
        Set<String> candidatos = new HashSet<>();
        Set<String> todos = new HashSet<>();

        for (String[] v : votos) {
            eleitores.add(v[0]);
            candidatos.add(v[1]);
            todos.add(v[0]);
            todos.add(v[1]);
        }

        Map<String, List<String>> votosPorCandidato = registrarVotos(votos);

        imprimirVotos(votosPorCandidato);
        imprimirPercentagens(votosPorCandidato);
        imprimirSemVotos(todos, candidatos);
        imprimirEleitores(eleitores);
        imprimirCandidatosQueNaoVotaram(candidatos, eleitores);
    }
}
