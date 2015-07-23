import java.util.LinkedHashMap;

def parse (rules) {
    return rules
}

def check (input, rules) {
    def error10 = parse rules greaterThen 6 lessThen 19 summarize "error 10!!!"
    println input + ": " + error10
}
