package md2html;

import java.io.IOException;

public class Tag implements StringExpression {
    StringExpression f;
    String tag;
    StringExpression link, description;
    Md2HtmlSource source;

    Tag(StringExpression a, String name, Md2HtmlSource x) {
        f = a;
        tag = name;
        source = x;
    }

    Tag(StringExpression a, String name, StringExpression l, StringExpression d, Md2HtmlSource x) {
        f = a;
        link = l;
        tag = name;
        description = d;
        source = x;
    }

    Tag(StringExpression a, String name, StringExpression l, Md2HtmlSource x) {
        f = a;
        tag = name;
        link = l;
        source = x;
    }

    public boolean isEmpty() {
        return f != null;
    }

    public void evaluate() throws IOException {
        if (description == null) {
            source.writeString("<" + tag);
            if (link != null) {
                source.writeString(" href='");
                link.evaluate();
                source.writeString("'>");
            } else {
                source.writeChar('>');
            }
            f.evaluate();
            source.writeString("</" + tag + ">");
        } else {
            source.writeString("<img alt='");
            description.evaluate();
            source.writeString("' src='");
            link.evaluate();
            source.writeString("'>");
        }
    }
}
