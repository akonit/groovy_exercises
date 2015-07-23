import java.util.LinkedHashMap;

def parse (rules) {
    return rules
}

def check (input, rules) {
    //def result = parse(rules).gt(input).eval(2).lt(input).eval(19).summarize("error 10!!!")
    def error10 = parse rules gt input eval 6 lt input eval 19 summarize "error 10!!!"
    println error10
}
