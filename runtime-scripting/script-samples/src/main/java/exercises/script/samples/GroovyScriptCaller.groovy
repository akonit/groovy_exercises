package exercises.script.samples

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import groovy.lang.Script;

class GroovyScriptCaller {
    
    def callScript (input) {
        
        def rules = [            
            "gt" : {
                selfLink -> {
                        param -> 
                        [
                            "eval" : {
                                restriction ->
                                def result = param > restriction
                                selfLink.updateResult(result)
                                return selfLink
                            }
                        ]
                }
            },

            "lt" : {
                selfLink -> {
                        param -> 
                        [
                            "eval" : {
                                restriction ->
                                def result = param < restriction
                                selfLink.updateResult(result)
                                return selfLink
                            }
                        ]
                }
            }
        ]
        
        def rulesExt = new ExtendedMap(rules)
        
        def shell = new GroovyShell()
        def script = shell.parse(new File('/home/ann/jet/NSPK/groovy_exercises/runtime-scripting/script-samples/outer_conf/SimpleScript.groovy'))
        def binding = new Binding();
        script.setBinding(binding);
            
        script.check(input, rulesExt)
    }
    
    class ExtendedMap<K,V> extends LinkedHashMap<K,V> implements Map<K,V> {
        
        def result
        
        public ExtendedMap(map) {
            super()
            result = true
            map.each { key, value -> put(key, value)}
        }
        
        @Override
        public V get(Object key) {
            V value = super.get(key)
            return value.call(this)
        }
        
        public void updateResult(result) {
            this.result = this.result && result
        }
        
        public Object summarize(msg) {
            if (result) {
                "OK"
            } else {
                msg
            }
        }
    }
}

