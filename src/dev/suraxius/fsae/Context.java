package dev.suraxius.fsae;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.Map;
import java.util.Observable;

class Context {
    private static int counter = 0;
    private boolean saved = false;
    private String title;
    private StateMachine stateMachine = new StateMachine();
    
    public Context() {
        counter++;
        title = "Untitled " + Integer.toString(counter);
    }

    public String getTitle() { return title; }

    public static class ContextHandler extends Observable {
        private Context activeContext;
        private List<Context> contexts = new ArrayList<>();

        public Context getActiveContext() { return activeContext; }
        public List<Context> getAllContexts() { return contexts; }
        public void addContext(Context c) { contexts.add(c); }
    }

    static class StateMachine {
        private TreeMap alphabet = new TreeMap();
        private ArrayList<State> states = new ArrayList<>();
        private ArrayList<State> acceptingStates = new ArrayList<>();;
        private State startState;
    }

    static class State {
        private TreeMap transitions = new TreeMap();
    }
}
