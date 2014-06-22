package com.thesischecker.comparator;
import java.util.LinkedList;
/**
 * Created by Viciu on 2014-06-20.
 */

public class AnalysisHTMLConverter
{
    private Analysis anal;
    private String left;
    private String right;

    public AnalysisHTMLConverter()
    {

    }

    public void setAnalysis(Analysis analysis)
    {
        this.anal = analysis;
        generateHTMLs();
    }

    public String getLeft()
    {
        return left;
    }

    public String getRight()
    {
        return right;
    }

    private static final String EQUAL_TAG_START = "<div class=\"equal\">";
    private static final String EQUAL_TAG_END = "</div><br>";
    private static final String INSERT_TAG_START = "<div class=\"insert\">";
    private static final String INSERT_TAG_END = "</div><br>";
    private static final String DELETE_TAG_START = "<div class=\"delete\">";
    private static final String DELETE_TAG_END = "</div><br>";
    private static final String EMPTY_LINE = "<br>";
    private static final String MORE_LINES = " more lines...";
    //TODO test line splitting on different platforms
    private static final String LINE_DELIMITER = "\r\n";

    private void generateHTMLs()
    {
        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder();
        LinkedList<Diff> diffs = anal.getDiffs();
        int leftLines = 0;
        int rightLines = 0;
        for (Diff diff : diffs)
        {
            String[] lines = splitLines(diff.getText(), LINE_DELIMITER);
            switch (diff.getOperation())
            {
                case EQUAL:
                    // fill difference with empty lines
                    for (; leftLines < rightLines; leftLines++)
                        left.append(EMPTY_LINE);
                    for (; rightLines < leftLines; rightLines++)
                        right.append(EMPTY_LINE);
                    for (String line : lines)
                    {
                        left.append(EQUAL_TAG_START);
                        left.append(line);
                        left.append(EQUAL_TAG_END);
                        right.append(EQUAL_TAG_START);
                        right.append(line);
                        right.append(EQUAL_TAG_END);
                    }
                    leftLines += lines.length;
                    rightLines += lines.length;
                    break;
                case INSERT:
                {
                    if (lines.length < 4)
                    {
                        for (String line : lines)
                        {
                            right.append(INSERT_TAG_START);
                            right.append(line);
                            right.append(INSERT_TAG_END);
                        }
                        rightLines += lines.length;
                    }
                    else
                    {
                        right.append(INSERT_TAG_START);
                        right.append(lines[0]);
                        right.append(INSERT_TAG_END);
                        right.append(INSERT_TAG_START);
                        right.append(lines.length - 2);
                        right.append(MORE_LINES);
                        right.append(INSERT_TAG_END);
                        right.append(INSERT_TAG_START);
                        right.append(lines[lines.length - 1]);
                        right.append(INSERT_TAG_END);
                        rightLines+=3;
                    }
                }
                break;
                case DELETE:
                {
                    if (lines.length < 4)
                    {
                        for (String line : lines)
                        {
                            left.append(DELETE_TAG_START);
                            left.append(line);
                            left.append(DELETE_TAG_END);
                        }
                        leftLines += lines.length;
                    }
                    else
                    {
                        left.append(DELETE_TAG_START);
                        left.append(lines[0]);
                        left.append(DELETE_TAG_END);
                        left.append(DELETE_TAG_START);
                        left.append(lines.length - 2);
                        left.append(MORE_LINES);
                        left.append(DELETE_TAG_END);
                        left.append(DELETE_TAG_START);
                        left.append(lines[lines.length - 1]);
                        left.append(DELETE_TAG_END);
                        leftLines+=3;
                    }
                }
                break;
                default:
                    break;
            }
        }
        // fill difference with empty lines
        for (; leftLines < rightLines; leftLines++)
            left.append(EMPTY_LINE);
        for (; rightLines < leftLines; rightLines++)
            right.append(EMPTY_LINE);
        this.left = left.toString();
        this.right = right.toString();
    }

    private static String[] splitLines(String text, String delimiter)
    {
        return text.split(delimiter);
    }
}

