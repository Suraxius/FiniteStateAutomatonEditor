package com.svenluthi.fsae;

import java.util.LinkedList;

class Context {
    private static int counter = 0;
    private boolean saved = false;
    private String title;
    private LinkedList<String> regularLanguageExpression = new LinkedList<String>();

    public Context() {
        counter++;
        title = "Untitled " + counter;
    }
}