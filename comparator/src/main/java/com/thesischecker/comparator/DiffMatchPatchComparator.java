package com.thesischecker.comparator;

import java.util.Iterator;
import java.util.LinkedList;

import com.sksamuel.diffpatch.DiffMatchPatch;

/**
 * Class Implementing IComparator interface using google DiffMatchPatch.
 * 
 * @author Viciu
 * 
 */
public class DiffMatchPatchComparator implements IComparator {
    private DiffMatchPatch dmp = new DiffMatchPatch();

    /**
     * Creates new default instance of DiffMatchPatchComparator
     */
    public DiffMatchPatchComparator() {
        setTimeout(0);
        setMatchDistance(4000);
    }

    /*
     * (non-Javadoc)
     * 
     * @see IComparator#compare(java.lang.String, java.lang.String)
     */
    public Analysis compare(String s1, String s2) {
        Analysis analysis = new Analysis();
        if (s1.length() == 0 && s2.length() == 0) {
            analysis.setSimilarityRate(1.);
            analysis.getDiffs().add(new Diff(Diff.Operation.EQUAL, s1));
            return analysis;
        } else if (s1.length() == 0 || s2.length() == 0) {
            analysis.setSimilarityRate(0.);
            if (s1.length() > s2.length()) {
                analysis.getDiffs().add(new Diff(Diff.Operation.DELETE, s1));
            } else {
                analysis.getDiffs().add(new Diff(Diff.Operation.INSERT, s2));
            }
            return analysis;
        }

        LinkedList<DiffMatchPatch.Diff> diff_main = dmp.diff_main(s1, s2);
        dmp.diff_cleanupEfficiency(diff_main);
        dmp.diff_cleanupSemantic(diff_main);

        double levenshtein = dmp.diff_levenshtein(diff_main);
        int length = s1.length();
        analysis.setSimilarityRate(1 - levenshtein / length);

        analysis.getDiffs().addAll(convertDiffList(diff_main));

        return analysis;
    }

    /**
     * Converts googleDiffMatchPatch Diff list into out implementation.
     * 
     * @param diff_main
     *            google DMP diff list
     * @return our diff list
     */
    private LinkedList<Diff> convertDiffList(
            LinkedList<DiffMatchPatch.Diff> diff_main) {
        LinkedList<Diff> list = new LinkedList<Diff>();
        for (Iterator<DiffMatchPatch.Diff> iterator = diff_main.iterator(); iterator
                .hasNext();) {
            DiffMatchPatch.Diff diff = iterator.next();
            switch (diff.operation) {
            case EQUAL:
                list.add(new Diff(Diff.Operation.EQUAL, diff.text));
                break;
            case INSERT:
                list.add(new Diff(Diff.Operation.INSERT, diff.text));
                break;
            case DELETE:
                list.add(new Diff(Diff.Operation.DELETE, diff.text));
                break;
            }
        }
        return list;
    }

    /**
     * Returns matching distance.
     * 
     * @return matching distance
     */
    public int getMatchDistance() {
        return dmp.Match_Distance;
    }

    /**
     * Returns currently set timeout for diff operations
     * 
     * @return currently set timeout for diff operations
     */
    public float getTimeout() {
        return dmp.Diff_Timeout;
    }

    /**
     * Sets matching distance. How far to search for a match (0 = exact
     * location, 1000+ = broad match).
     * 
     * @param distance
     */
    public void setMatchDistance(int distance) {
        dmp.Match_Distance = distance;
    }

    /**
     * Sets Timeout in seconds for Diff operations, If Diff operation takes more
     * than that value it returns results obtained thus far. <br>
     * Value of 0 or lower will give infinite time for operation.
     * 
     * @param seconds
     *            timeout value in seconds
     */
    public void setTimeout(float seconds) {
        dmp.Diff_Timeout = seconds;
    }

}
