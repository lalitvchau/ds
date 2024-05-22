package ds.stack;

public class ProblemExpressionSymbolBracktes {

    static boolean symbolBalancing(String symbols) {
        StackLinkedList<Character> store = new StackLinkedList<>();
        for (char symbol : symbols.toCharArray()) {
            if (store.isEmpty()) {
                store.push(symbol);
            } else {
                boolean isMatch = false;
                char storedSymbol = store.top();
                switch (symbol) {
                    case ')': {
                        isMatch = storedSymbol == '(';
                        break;
                    }
                    case '}': {
                        isMatch = storedSymbol == '{';
                        break;
                    }
                    case ']': {
                        isMatch = storedSymbol == '[';
                        break;
                    }
                }
                if (isMatch) {
                    store.pop();
                } else {
                    store.push(symbol);
                }
            }
        }

        return store.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(symbolBalancing("([])[][]{}{{}}"));
    }
}
