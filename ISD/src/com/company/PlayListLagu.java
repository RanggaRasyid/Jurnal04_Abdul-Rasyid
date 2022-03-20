package com.company;

public class PlayListLagu {
    private String JudulLagu;
    private String singer;

    public PlayListLagu(String JudulLagu, String singer){
        this.JudulLagu = JudulLagu;
        this.singer = singer;
    }
    public String getNamaLagu() {
        return this.JudulLagu;
    }
    @Override
    public String toString() {
        return JudulLagu +" ~ "+ singer;
    }
}