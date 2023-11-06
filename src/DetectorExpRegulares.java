import java.util.regex.Pattern;
/// ----------- PRACTICA CON EXPRESIONES REGULARES -----------


public class DetectorExpRegulares {
    public static boolean isMutant(String[] dna) {
        int cont = 0;
        if (dna == null || dna.length != 6) {
            return false;
        }

        for (String row : dna) {
            if (row.length() != 6) {
                return false;
            }
        }

        String dnaConcatenado = String.join("", dna);
        // Expresion regular para buscar secuencia de 4 letras iguales en cualquier dirección
        Pattern pattern = Pattern.compile("([ACTG])\\1{3}");

        // Horizontal y vertical
        for (int i = 0; i < dna.length; i++) {
            String row = dna[i];
            String col = "";
            for (int j = 0; j < dna.length; j++) {
                col += dna[j].charAt(i);
            }
            if (pattern.matcher(row).find() || pattern.matcher(col).find()) {
                cont++;
            }
        }

        // Diagonales
        if (pattern.matcher(dnaConcatenado).find()) {
            cont++;
        }

        // Diagonales inversas (de derecha a izquierda)
        for (int i = 0; i < dna.length; i++) {
            String diagonal = "";
            String reverseDiagonal = "";
            for (int j = 0; j < dna.length; j++) {
                if (i + j < dna.length) {
                    diagonal += dna[i + j].charAt(j);
                    reverseDiagonal += dna[i + j].charAt(dna.length - 1 - j);
                }
            }
            if (pattern.matcher(diagonal).find() || pattern.matcher(reverseDiagonal).find()) {
                cont++;
            }
        }

        return cont > 1;
    }

    public static void main(String[] args) {
        String[] dna = {
                "ATGCAG",
                "CAGTGG",
                "TTAGAA",
                "AGGAGT",
                "GTCCTC",
                "TCCCCA"
        };
        String[] dna1 = {
                "ATGCGA",
                "CAGTGC",
                "TTATTT",
                "AGACGG",
                "GCGTCA",
                "TCACTG"
        };
          if (isMutant(dna1)){
             System.out.println("MUTANTE");
          }else{
             System.out.println("NO MUTANTE");
          }
    }
}
