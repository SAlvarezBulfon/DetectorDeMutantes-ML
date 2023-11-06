import java.lang.reflect.Array;
import java.util.ArrayList;

public class DetectorDeMutantes {
    public static boolean isMutant(String[] dna) {
        int contador = 0;
        if (dna == null || dna.length != 6 ) {
            return false;
        }
        for (String row: dna){
            if (row.length() != 6){
                return false;
            }
        }

        int n = dna.length;


            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // Horizontalmente
                    if (j + 3 < n && dna[i].charAt(j) == dna[i].charAt(j + 1)
                            && dna[i].charAt(j) == dna[i].charAt(j + 2) && dna[i].charAt(j) == dna[i].charAt(j + 3)) {
                        contador++;
                    }
                    // Verticalmente
                    if (i + 3 < n && dna[i].charAt(j) == dna[i + 1].charAt(j)
                            && dna[i].charAt(j) == dna[i + 2].charAt(j) && dna[i].charAt(j) == dna[i + 3].charAt(j)) {
                        contador++;
                    }
                    // Diagonal (Izquierda a Derecha)
                    if (i + 3 < n && j + 3 < n && dna[i].charAt(j) == dna[i + 1].charAt(j + 1)
                            && dna[i].charAt(j) == dna[i + 2].charAt(j + 2) && dna[i].charAt(j) == dna[i + 3].charAt(j + 3)) {
                        contador++;
                    }
                    // Diagonal (Derecha a Izquierda)
                    if (i + 3 < n && j - 3 >= 0 && dna[i].charAt(j) == dna[i + 1].charAt(j - 1)
                            && dna[i].charAt(j) == dna[i + 2].charAt(j - 2) && dna[i].charAt(j) == dna[i + 3].charAt(j - 3)) {
                        contador++;
                    }
                    // Diagonal (Abajo Derecha a Izquierda)
                    if (i - 3 >= 0 && j + 3 < n && dna[i].charAt(j) == dna[i - 1].charAt(j + 1)
                            && dna[i].charAt(j) == dna[i - 2].charAt(j + 2) && dna[i].charAt(j) == dna[i - 3].charAt(j + 3)) {
                        contador++;
                    }
                    // Diagonal (Abajo Izquierda a Derecha)
                    if (i - 3 >= 0 && j - 3 >= 0 && dna[i].charAt(j) == dna[i - 1].charAt(j - 1)
                            && dna[i].charAt(j) == dna[i - 2].charAt(j - 2) && dna[i].charAt(j) == dna[i - 3].charAt(j - 3)) {
                        contador++;
                    }
                }
            }


        if(contador>=2){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        String[] dna = {
                "ATGCAA",
                "CAGTGC",
                "TTATAT",
                "AGAAGG",
                "GTCCCC",
                "TCACTG"
        };

        String[] dna1 = {
                "ATGCGA",
                "CAGTGC",
                "TTATTT",
                "AGACGG",
                "GCGTCA",
                "TCACTG"
        };

        String[] dna2 = {
                "ATTCCC",
                "CAATGC",
                "TTATTT",
                "AGAAGG",
                "GCGTAA",
                "TCCCCG"
        };

        String[] dna3 = {
                "ATTCCC",
                "CCGTCC",
                "TTACTT",
                "AGCAGG",
                "GCGTAA",
                "TBBBBG"
        };

        String[] dna4 = {
                "TTGCGA",
                "AAGTGC",
                "TTATTT",
                "AGATGG",
                "GCGTCA",
                "TCACTG"
        };

        String[] dna5 = {
                "TTGCGT",
                "AAGTGT",
                "TTATTT",
                "AGAAGT",
                "GCGTAA",
                "TCACTA"
        };
        String[] dna6 = {
                "TTGCGT",
                "AAGTGT",
                "TTATTT",
                "AGAAGT",
                "GCGTAA",
                "TCACTA"
        };
        String[] dna7 = {
                "TTGCGT",
                "AAGTGT",
                "TTACTT",
                "AGCAGT",
                "GCGTCA",
                "CCACTA"
        };

        String[] dna8 = {
                "TTGCGC",
                "GAGTGA",
                "TTACTT",
                "AGAGGT",
                "GCGTCA",
                "CCACTA"
        };

        String[] dna9 = {
                "TTGCGC",
                "GAGTGT",
                "TTACTT",
                "AGAAGT",
                "GCGTAT",
                "CCCCTA"
        };
        String[] dna10 = {
                "TTGCGC",
                "GAGTGT",
                "TTACTT",
                "AGAGGC",
                "GCGTAT",
                "CCCCTA"
        };


        if (isMutant(dna1)){
            System.out.println("MUTANTE");
        }else{
            System.out.println("NO MUTANTE");
        }
    }


}
