import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class ParseHer {
static String name;
    final static private String[]
            RADICALS = {"meth", "eth", "prop", "but", "pent", "hex", "hept", "oct", "non", "dec", "undec", "dodec", "tridec", "tetradec", "pentadec", "hexadec", "heptadec", "octadec", "nonadec"},
            MULTIPLIERS = {"di", "tri",  "tetra", "penta", "hexa", "hepta", "octa", "nona", "deca", "undeca", "dodeca", "trideca", "tetradeca", "pentadeca", "hexadeca", "heptadeca", "octadeca", "nonadeca"},
            SUFFIXES = {"ol", "al", "one", "oic acid", "carboxylic acid", "oate", "ether", "amide", "amine", "imine", "benzene", "thiol", "phosphine", "arsine"},
            PREFIXES = {"cyclo", "hydroxy", "oxo", "carboxy", "oxycarbonyl", "anoyloxy", "formyl", "oxy", "amido", "amino", "imino", "phenyl", "mercapto", "phosphino", "arsino", "fluoro", "chloro", "bromo", "iodo"},
            ALKANES = {"ane"},
            ALKENES = {"ene"},
            ALKYNES = {"yne"},
            ALKYLES = {"yl"};

    public ParseHer(String name) {
this.name = name;
    }
    public static String parse() {
        Map<String, Integer> map = new HashMap<>();
        name = name.replaceAll("-", "");
        name = name.replaceAll("\\d+", "");
        int carboncounter = 0;
        int hydrocounter = 0;
        int oxycounter = 0;
        while(!name.isEmpty()) {
            String s = countAlkanes(name);
            int delimiterIndex = name.indexOf(s);
            if (delimiterIndex != -1) {
                String result = name.substring(0, delimiterIndex + s.length());
                carboncounter+=(Arrays.asList(RADICALS).indexOf(countAlkanes(result)) + 1)*countMultiplier(result);
                System.out.println(result);
                name = name.replaceFirst(result, "");
            }
        }
        if (carboncounter != 0) {
            map.put("C", carboncounter);
        }if (hydrocounter != 0) {
        map.put("H", hydrocounter);}
        if (oxycounter != 0) {
        map.put("O", oxycounter); }
            return map.toString();

    }
public static String countAlkanes(String x) {
    String s = "";

    for (String wr1 : MULTIPLIERS) {
        x = x.replace(wr1, "");
    }
    for (String wr2 : PREFIXES) {
        x = x.replace(wr2, "");
    }
    for (String w1 : RADICALS) {
      //  int i = x.indexOf(w1);
      //  if (i != (-1)) {
        if(x.startsWith(w1)) {
       //     String s = x.substring(i, i + w1.length());
            s = w1;
            break;
        }
    }
    return s;
}

    public static int countYLEnd(String x) {
        for (String w1 : ALKYLES) {
            int i = x.indexOf(w1);
            if (i != (-1)) {
                return 2;
            }
        }
        return 0;
    }
    public static int countMultiplier(String x) {
        for (String w1 : MULTIPLIERS) {
            int i = x.indexOf(w1);
            if (i != (-1)) {
                String s = x.substring(i, i + w1.length());
                return (Arrays.asList(MULTIPLIERS).indexOf(s) + 2);
            }
        }
        return 1;
    }

}
