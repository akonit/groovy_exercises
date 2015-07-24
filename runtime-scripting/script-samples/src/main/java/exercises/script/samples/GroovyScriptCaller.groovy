package exercises.script.samples

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import groovy.lang.Script;

class GroovyScriptCaller {
    
    def callScript (input) {        
        def shell = new GroovyShell()
        def script = shell.parse(new File('/home/ann/jet/NSPK/groovy_exercises/runtime-scripting/script-samples/outer_conf/SimpleScript.groovy'))
        def binding = new Binding();
        script.setBinding(binding);
            
        def engine = new RulesEngine(input)
        
        script.check(engine)
    }
}

