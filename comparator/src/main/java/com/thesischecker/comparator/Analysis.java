package com.thesischecker.comparator;

/**
 * Created by Viciu on 2014-05-15.
 */


import java.util.LinkedList;

/**
 * Class representing Analysis of two compared texts.
 *
 * @author Viciu
 *
 */
public class Analysis
{
    /**
     * Normalized similarity Rate. Can hold value of 0 to 1 inclusively
     */
    private double similarityRate;

    private final LinkedList<Diff> diffs = new LinkedList<Diff>();

    public LinkedList<Diff> getDiffs()
    {
        return diffs;
    }

    public double getSimilarityRate()
    {
        return similarityRate;
    }

    public void setSimilarityRate(double similarityRate)
    {
        this.similarityRate = similarityRate;
    }

    @Override
    public String toString()
    {
        return String.format("Similarity rate = %.1f%%", similarityRate * 100);
    }
}
