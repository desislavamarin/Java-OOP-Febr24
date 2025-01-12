package Ex05_Polymorphism.P03_Word;

public class CutTransform implements TextTransform{
    private StringBuilder lastCut = new StringBuilder();

    public StringBuilder getLastCut() {
        return lastCut;
    }

    @Override
    public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
        this.lastCut.append(text.substring(startIndex, endIndex));
        text.delete(startIndex, endIndex);
    }
}
