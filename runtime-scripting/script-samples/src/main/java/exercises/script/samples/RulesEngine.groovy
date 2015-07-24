package exercises.script.samples

class RulesEngine {
	
        def input
        def result
        
        public RulesEngine(input) {
            result = true
            this.input = input
        }
        
        public void updateResult(result) {
            this.result = this.result && result
        }
        
        public Object getInput() {
            input
        }
        
        public Object summarize(msg) {
            if (result) {
                "OK"
            } else {
                msg
            }
        }
        
        def greaterThen = {
            restriction ->
            def result = getInput() > restriction
            updateResult(result)
            return this
        }
        
        def lessThen = {
            restriction ->
            def result = getInput() < restriction
            updateResult(result)
            return this
        }
}

