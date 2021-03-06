package md2html;

import java.io.IOException;

public class Concatenate implements StringExpression {
    StringExpression f, s;

    Concatenate(StringExpression a, StringExpression b) {
        f = a;
        s = b;
    }

    public void evaluate() throws IOException {
        f.evaluate();
        s.evaluate();
    }

    @Override
    public boolean isEmpty() {
        return f == null && s == null;
    }
}
