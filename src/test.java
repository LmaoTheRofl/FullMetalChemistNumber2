public class test {
    public static void main(String[] args) {
        String b = "propane";
        String[] RADICALS = {"meth", "eth", "prop"};
        System.out.println(ParseHer.findIndexInArray(RADICALS, "meth"));
        System.out.println(ParseHer.parse(b));
    }
}
