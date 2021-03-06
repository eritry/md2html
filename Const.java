package md2html;

import java.io.IOException;

public class Const implements StringExpression {
    String s;
    Md2HtmlSource source;
    Const(String x, Md2HtmlSource y) {
        s = x;
        source = y;
    }

    public void evaluate() throws IOException {
        source.writeString(s);
    }

    @Override
    public boolean isEmpty() {
        return s.isEmpty();
    }
}
