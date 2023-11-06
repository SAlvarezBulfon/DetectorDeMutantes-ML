import java.util.regex.Pattern;

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
        //Expresion regular para buscar secuencia de 4 letras iguales en cualquier dirección
        Pattern pattern = Pattern.compile("([ACTG])⧵⧵1{3}");
        //Horizontal y vertical
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

        //Diagonales
        if (pattern.matcher(dnaConcatenado).find()) {
            cont++;
        }

        if (cont > 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String[] dna = {
                "ATGCAT",
                "CAGTGT",
                "TTATAT",
                "AGAAGT",
                "GTCCAC",
                "TCCCCA"
        };
          if (isMutant(dna)){
             System.out.println("MUTANTE");
          }else{
             System.out.println("NO MUTANTE");
          }
    }
}
