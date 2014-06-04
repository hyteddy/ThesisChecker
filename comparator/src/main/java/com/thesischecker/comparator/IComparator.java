package com.thesischecker.comparator;

/**
 * Created by Viciu on 2014-05-15.
 */
public interface IComparator
{
    /**
     * Method comparing two Strings
     *
     * @param s1
     *            first string
     * @param s2
     *            second string
     * @return Analysis of both strings, with similarity rate and list of Diffs
     */
    public Analysis compare(String s1, String s2);
}
