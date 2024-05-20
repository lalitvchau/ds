package java17;

public class PatternInSwitch {
    public static void main(String[] args) {
        System.out.println(objectCheck("I am String"));
        System.out.println(objectCheck(2));
        System.out.println(objectCheck(2.3));
        System.out.println(objectCheck(new Object()));
    }

    public static String objectCheck(Object object){
        return switch(object){
            case String str -> "This is a String object";
            case Integer num -> "This is a Integer object";
            case Double dub -> "This is a Double object";
            default -> "Object does not match";
        };
    }
}
