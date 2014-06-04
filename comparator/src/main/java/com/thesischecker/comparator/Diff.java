package com.thesischecker.comparator;

/**
 * Class for representing part of text that is either:<br>
 * EQUAL - present in both compared texts<br>
 * DELETE - present in first text<br>
 * INSERT - present in second text<br>
 *
 * @author Viciu
 *
 */
public class Diff
{
    /**
     * Enumeration indicating type of Diff
     *
     * @author Viciu
     *
     */
    public enum Operation
    {
        EQUAL, DELETE, INSERT
    }

    /**
     * Field holding type of Diff
     */
    private final Operation operation;

    /**
     * Field holding text
     */
    private final String text;

    /**
     * Creates a Diff with given type and text
     *
     * @param operation
     *            - type of Diff
     * @param text
     *            - text
     */
    public Diff(Diff.Operation operation, String text)
    {
        this.operation = operation;
        this.text = text;
    }

    /**
     * Returns type of operation this Diff represents
     *
     * @return type of operation
     */
    public Operation getOperation()
    {
        return operation;
    }

    /**
     * Text this Diff represents
     *
     * @return text of Diff
     */
    public String getText()
    {
        return text;
    }

    @Override
    public String toString()
    {
        return operation + ": " + text;
    }

}

