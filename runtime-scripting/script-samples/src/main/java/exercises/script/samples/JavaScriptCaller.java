package exercises.script.samples;

import groovy.lang.GroovyClassLoader;
import java.io.File;

public class JavaScriptCaller {
    
    public static void main(String[] args) {
        try {
            Class scriptClass = new GroovyClassLoader().parseClass( new File( "src/main/java/exercises/script/samples/GroovyScriptCaller.groovy" ) ) ;
            Object scriptInstance = scriptClass.newInstance() ;
            scriptClass.getDeclaredMethod( "callScript", new Class[] {Object.class} ).invoke( scriptInstance, new Object[] {13} ) ;
            scriptClass.getDeclaredMethod( "callScript", new Class[] {Object.class} ).invoke( scriptInstance, new Object[] {228} ) ;  
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
