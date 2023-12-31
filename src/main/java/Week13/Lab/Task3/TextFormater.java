package Week13.Lab.Task3;

interface TextFormatter {
    void formatText(String text);
}

class UpperCaseFormatter implements TextFormatter{
    @Override
    public void formatText(String text) {
        String formatted = text.toUpperCase();
        System.out.println(formatted);
    }
}

class LowerCaseFormatter implements TextFormatter{
    @Override
    public void formatText(String text) {
        String formatted = text.toLowerCase();
        System.out.println(formatted);
    }
}

class CamelCaseFormatter implements TextFormatter{
    @Override
    public void formatText(String text) {
        String formatted = "neZnamNapravitCamelCase";
        System.out.println(formatted);
    }
}

class TextEditor {
    private TextFormatter formatter;

    public void setFormatter(TextFormatter formatter) {
        this.formatter = formatter;
    }

    public void formatText(String text) {
        formatter.formatText(text);
    }
}

class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        editor.setFormatter(new CamelCaseFormatter());
        editor.formatText("cao");

        editor.setFormatter(new UpperCaseFormatter());
        editor.formatText("hello world");
    }
}
