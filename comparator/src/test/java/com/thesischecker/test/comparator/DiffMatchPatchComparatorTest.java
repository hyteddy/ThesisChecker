package com.thesischecker.test.comparator;

import com.thesischecker.comparator.Analysis;
import com.thesischecker.comparator.Diff;
import com.thesischecker.comparator.DiffMatchPatchComparator;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class DiffMatchPatchComparatorTest
{
    String[] testStrings =
            {
                    "Line 1\nLine 2\nLine 3\nLine 4\nLine 5\nLine 6\nLine 7\nLine 8\nLine 9\nLine 10\n",
                    "Line 2\nLine 3 with changes\nLine 4\nLine 5 with changes\na new line\nLine 6\nnew Line 6.1\nLine 7\nLine 8\nLine 9\nLine 10 with changes\n",
                    ""
            };

    /**
     * Maximum allowed distance for equal at 1%
     */
    private final static double EPSILON = 0.01;

    @Test
    public void testEqual()
    {
        DiffMatchPatchComparator dmpc = new DiffMatchPatchComparator();
        for (int i = 0; i < testStrings.length; i++)
        {
            Analysis analysis = dmpc.compare(testStrings[i], testStrings[i]);
            // assert 100% similarity
            assertEquals(1.0, analysis.getSimilarityRate(), EPSILON);
            LinkedList<Diff> diffs = analysis.getDiffs();
            // assert all in one Diff
            assertEquals(1, diffs.size());
            // assert Diff states EQUALITY
            assertEquals(Diff.Operation.EQUAL, diffs.get(0).getOperation());
        }
    }

    @Test
    public void testNonEqual()
    {
        DiffMatchPatchComparator dmpc = new DiffMatchPatchComparator();
        for (int i = 0; i < testStrings.length; i++)
        {
            for (int j = i + 1; j < testStrings.length; j++)
            {
                Analysis analysis = dmpc
                        .compare(testStrings[i], testStrings[j]);
                // assert normalized similarity between 0 and 1 , and not 1
                double similarity = analysis.getSimilarityRate();
                assertTrue(similarity >= 0. && similarity < 1.);
                LinkedList<Diff> diffs = analysis.getDiffs();
                // assert at least one diff
                assertTrue(diffs.size() >= 1);
                // assert that at least one diff marks inequality
                boolean equal = true;
                for (Diff diff : diffs)
                {
                    if (diff.getOperation().equals(Diff.Operation.DELETE)
                            || diff.getOperation()
                            .equals(Diff.Operation.INSERT))
                        equal = false;
                }
                assertFalse(equal);
            }
        }
    }

    @Test
    public void testSpecific()
    {
        DiffMatchPatchComparator dmpc = new DiffMatchPatchComparator();
        Analysis analysis = dmpc.compare(testStrings[0], testStrings[1]);
        double similarity = analysis.getSimilarityRate();
        assertEquals(0.042, similarity, EPSILON);
    }

}

