class MyCycle(private val list: List<Student>) {

    private var operation: ((Student) -> Unit)? = null
    private var operationFromTo: ((Int) -> Unit)? = null
    private var operationMyWhile: ((Int) -> Unit)? = null
    var from = 0
    var to = 0

    private val operationsZ: Map<String, (Any?, Any?) -> Boolean> = mapOf(
        "<" to { a, b -> (a as Comparable<Any>) < (b as Comparable<Any>) },
        ">" to { a, b -> (a as Comparable<Any>) > (b as Comparable<Any>) },
        "==" to { a, b -> a == b },
        "!=" to { a, b -> a != b },
        "<=" to { a, b -> (a as Comparable<Any>) <= (b as Comparable<Any>) },
        ">=" to { a, b -> (a as Comparable<Any>) >= (b as Comparable<Any>) }
    )

    fun pushThroughFor(operation: (Student) -> Unit) {
        this.operation = operation

        for (student in list) {
            operation(student)
        }
    }

    fun pushThroughFromTo(operationFromTo: (Int) -> Unit, from: Int, to: Int) {
        this.from = from
        this.to = to
        this.operationFromTo = operationFromTo

        for (i in from..to) {
            operationFromTo(i)
        }

    }

    fun myWhile(operationMyWhile: (Int) -> Unit, condition: String, value1: Any, value2: Any) {
        val conditionFunction = operationsZ[condition]
            ?: throw IllegalArgumentException("Unsupported operation: $condition")

        var i = 0
        var index = value1
        while (conditionFunction(index, value2)) {

            if (index is Int) {
                operationMyWhile(index)
                index += 1
            }

        }
    }

}
