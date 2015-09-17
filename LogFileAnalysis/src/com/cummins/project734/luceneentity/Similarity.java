package com.cummins.project734.luceneentity;

public interface Similarity extends java.io.Serializable
{
    /* Calculates similarity value between two sets. Each set is represented by array of strings.
     *  Arrays can have different length.*/
    public double similarity(String [] x, String [] y,int index);
}