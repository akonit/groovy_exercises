def parse (engine) {
    return engine
}

def check (engine) {
    def error10 = parse engine greaterThen 6 lessThen 19 summarize "error 10!!!"
    println engine.input + ": " + error10
}
