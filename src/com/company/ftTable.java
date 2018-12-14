package com.company;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class ftTable {
    private String [] operations;
    public boolean [] tt;
    public boolean [] tf;
    public boolean [] ft;
    public boolean [] ff;

    public ftTable(String [] b) throws ScriptException {
        operations = new String [b.length];
        operations = b;
        tt = new boolean[b.length];
        tf = new boolean[b.length];
        ft = new boolean[b.length];
        ff = new boolean[b.length];

        tt[0] = true;
        tt[1] = true;
        tf[0] = true;
        ft[1] = true;

        for (int i = 2; i < operations.length; i++) {
            tt[i] = constructExpression(tt, operations[i]);
            tf[i] = constructExpression(tf, operations[i]);
            ft[i] = constructExpression(ft, operations[i]);
            ff[i] = constructExpression(ff, operations[i]);
        }

    }

    public static boolean constructExpression(boolean [] t, String boolA) throws ScriptException {
        String s = boolA;
        if (t[0]) {
            s = s.replace("A", "true");
        }
        else if (!t[0]) {
            s = s.replace("A", "false");
        }
        if (t[1]) {
            s = s.replace("B", "true");
        }
        else if (!t[1]) {
            s = s.replace("B", "false");
        }
        return evaluate(s);
    }

    public String [] constructTable(boolean [] b) {
        String [] tf = new String[operations.length];
        for (int i = 0; i < operations.length; i++) {
            if (b[i]) {
                tf[i] = "T";
            }
            else {
                tf[i] = "F";
            }
        }
        return tf;
    }

    public static boolean evaluate(String s) throws ScriptException {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        return Boolean.valueOf((Boolean)engine.eval(s.toLowerCase()));
    }


}
