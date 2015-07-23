import java.util.LinkedHashMap;

def parse (rules) {
    return rules
}

def check (input, rules) {
    //def result = parse(rules).gt.call(input).eval.call(2)
    def error10 = parse rules gt input eval 6
    println error10
}
