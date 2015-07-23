package exercises.script.samples

class GroovyScriptCaller {
    def binding = new Binding()

    def engine = new GroovyScriptEngine([tmpDir.toURI().toURL()] as URL[])
    
    def callScript = {
        def greeter = engine.run('/home/ann/jet/NSPK/groovy_exercises/runtime-scripting/script-samples/outer_conf/SimpleScript.groovy', binding)                   
        greeter greet()
    }
}

