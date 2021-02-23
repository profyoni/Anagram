package edu.touro.cs;

// TODO : Replace this file with your code
public class AnagrammedWord implements Comparable<AnagrammedWord> {
    String word;
    String canonForm;

    @Override
    public int compareTo(AnagrammedWord that) {
        int cmp = this.canonForm.compareTo(that.canonForm);
        if (cmp != 0)
            return cmp;

        cmp = this.word.compareToIgnoreCase(that.word);
        return cmp;
    }
}
