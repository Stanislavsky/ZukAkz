import java.io.File

fun fillStudent(): List<Student> {
    val students = mutableListOf<Student>()
    val myFor = MyCycle(students)

    var operationFromTo:(Int) -> Unit = {
        var file = File("");

        if (it == 0)
        {
            file = File("36_1.csv")
        }
        else if (it == 1)
        {
            file = File("36_2.csv")
        }
        else
        {
            file = File("39.csv")
        }

        if (file.exists()) {
            file.bufferedReader().useLines { lines ->
                var lineCount = 0
                lines.drop(2).forEach { line ->
                    lineCount++

                    if (lineCount > 17 && file.name == "36_1.csv")
                    {
                        return@useLines
                    }
                    else if (lineCount > 16 && (file.name == "36_2.csv" || file.name == "39.csv"))
                    {
                        return@useLines
                    }

                    val tokens = line.split(",")
//                println(tokens)
                    val student = Student()

                    if (file.name == "36_1.csv")
                    {
                        student.group = "36_1"
                    }
                    else if (file.name == "36_2.csv")
                    {
                        student.group = "36_2"
                    }
                    else
                    {
                        student.group = "39"
                    }


                    student.id = tokens[0].toIntOrNull() ?: 0
                    student.name = tokens[1]
                    student.extraPoints = tokens[2].toIntOrNull() ?: 0
                    student.git = tokens[3]

                    var count: Int = 0;

                    var operationFromTo:(Int) -> Unit =
                        {
                            if (tokens[it] == "+")
                            {
                                count++
                            }
                        }

                    myFor.pushThroughFromTo(operationFromTo,4, 15)

                    student.attendanceLectures = count
                    count = 0

                    myFor.pushThroughFromTo(operationFromTo,16, 27)

                    student.attendancePractitioner = count;

                    var listLaboratoryWork = tokens.slice(28..34)
                    student.laboratoryWork = listLaboratoryWork


                    var listIndividualProject = tokens.slice(35..39)
                    student.individualProject = listIndividualProject

                    var listTest = tokens.slice(40..42)
                    student.test = listTest

                    student.allowancePoint = tokens[79];

                    student.attendanceStudent = tokens[78]

                    students.add(student)
                }
            }
        }
        else
        {
            println("Файл не найден")
        }

    }

    myFor.pushThroughFromTo(operationFromTo,0, 2)

    return students
}