import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class ParseHer {

    final static private String[]
            RADICALS = {"meth", "eth", "prop", "but", "pent", "hex", "hept", "oct", "non", "dec", "undec", "dodec", "tridec", "tetradec", "pentadec", "hexadec", "heptadec", "octadec", "nonadec"},
            MULTIPLIERS = {"di", "tri",  "tetra", "penta", "hexa", "hepta", "octa", "nona", "deca", "undeca", "dodeca", "trideca", "tetradeca", "pentadeca", "hexadeca", "heptadeca", "octadeca", "nonadeca"},
            SUFFIXES = {"ol", "al", "one", "oic acid", "carboxylic acid", "oate", "ether", "amide", "amine", "imine", "benzene", "thiol", "phosphine", "arsine"},
            PREFIXES = {"cyclo", "hydroxy", "oxo", "carboxy", "oxycarbonyl", "anoyloxy", "formyl", "oxy", "amido", "amino", "imino", "phenyl", "mercapto", "phosphino", "arsino", "fluoro", "chloro", "bromo", "iodo"},
            ALKANES = {"ane"},
            ALKENES = {"ene"},
            ALKYNES = {"yne"},
            ALKYLES = {"yl"};

    public static int findIndexInArray(String[] a, String c) {
        return Arrays.asList(a).indexOf(c);
    }
    public ParseHer(String name) {

    }
    //Map<String,Integer>
    public static int parse(String name) {
        Map<String, Integer> map = new HashMap<>();
        for (String w: RADICALS) {
        int i = name.indexOf(w);
        if (i!=(-1)) {
            String s = name.substring(i, i+w.length());
            return findIndexInArray(RADICALS, s)+1;
        }
        }
        return -1;
        // Parse the name given as argument in the constructor and output the Map representing the raw formula
    }
}
