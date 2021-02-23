package edu.touro.cs;

import java.util.*;

public class Anagram {
    public static String canonicalForm(String s)
    {
        char [] letters = s.replace(" ","").
                toUpperCase().toCharArray();
        Arrays.sort( letters );
        return new String(letters);
    }

    public static List< List<String> > FindAllAnagrams(List<String> wordList)
    {
        if (wordList == null)
            throw new NullPointerException("wordList is null");
        List< List<String> > ret = new ArrayList<>();
        List<AnagrammedWord> aList = new ArrayList<>();
        for(String s: wordList)
        {

            if (s == null)
                throw new NullPointerException("wordList contains a null value");
            AnagrammedWord aw = new AnagrammedWord();
            aw.word = s;
            aw.canonForm = canonicalForm(s);
            aList.add(aw);
        }
        // sort by canonForm, word
        Collections.sort(aList);
        String previousCf = "";
        List<String> anagramList = null;
        for(AnagrammedWord aw : aList)
        {
            if ( ! aw.canonForm.equals(previousCf))
            {
                previousCf = aw.canonForm;
                if (anagramList != null && anagramList.size() > 1)
                    ret.add(anagramList);
                // new CF
                anagramList = new ArrayList<>();
            }
            anagramList.add( aw.word );
        }
        if (anagramList.size() > 1)
            ret.add(anagramList);

        Collections.sort(ret, new ListComp());
        return ret;
    }

    private static class ListComp implements Comparator<List<String> >{
        @Override
        public int compare(List<String> o1, List<String> o2) {
            return o1.get(0).compareTo(o2.get(0));
        }
    }
}
