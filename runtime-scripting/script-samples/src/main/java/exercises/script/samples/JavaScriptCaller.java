package exercises.script.samples;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import groovy.lang.Script;
import java.io.File;

public class JavaScriptCaller {
    
    public static void main(String[] args) {
        try {
            GroovyShell shell = new GroovyShell();
            Script script = shell.parse(
                    new File("/home/ann/jet/NSPK/groovy_exercises/runtime-scripting/script-samples/outer_conf/SimpleScript.groovy"));

            Binding binding = new Binding();
            script.setBinding(binding);

            script.invokeMethod("greet", "owl");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
