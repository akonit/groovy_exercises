package exercises.script.samples;

import groovy.lang.Binding;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyShell;
import groovy.lang.Script;
import java.io.File;

public class JavaScriptCaller {
    
    public static void main(String[] args) {
        try {
            GroovyShell shell = new GroovyShell();
            Script script = shell.parse(
                    new File("src/main/java/exercises/script/samples/GroovyScriptCaller.groovy"));

            Binding binding = new Binding();
            script.setBinding(binding);

            Class scriptClass = new GroovyClassLoader().parseClass( new File( "src/main/java/exercises/script/samples/GroovyScriptCaller.groovy" ) ) ;
            Object scriptInstance = scriptClass.newInstance() ;
            scriptClass.getDeclaredMethod( "callScript", new Class[] {Object.class} ).invoke( scriptInstance, new Object[] {13} ) ;
            scriptClass.getDeclaredMethod( "callScript", new Class[] {Object.class} ).invoke( scriptInstance, new Object[] {228} ) ;  
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
