class Points {
    fun finding(students: List<Student>) {
        val mW = MyCycle(students)
        val myFor = MyCycle(students)

        if (students.isEmpty()) {
            println("Список студентов пуст")
        } else {
            var currentGroup: String? = null

            val operation: (Student) -> Unit = { student ->
                if (currentGroup != student.group) {
                    println()
                    currentGroup = student.group
                }
                print(student.name)


                var attendanceTwo: Double = 0.0
                var dp = 0.0
                var result = 0.0
                var kr = 0.0
                var lr = 0.0
                var ap = 0.0

                val averageLr = student.attendanceLectures.toDouble() / 12 * 5
                val averagePr = student.attendancePractitioner.toDouble() / 12 * 5
                val attendanceOne = averageLr + averagePr

                if (attendanceOne < 4) {
                    attendanceTwo = 0.0
                } else if (attendanceOne < 6) {
                    attendanceTwo = 4.0
                } else if (attendanceOne < 7.5) {
                    attendanceTwo = 6.0
                } else if (attendanceOne < 9) {
                    attendanceTwo = 8.0
                } else {
                    attendanceTwo = 10.0
                }
                dp += attendanceTwo
                print(" Посещаемость: $attendanceTwo")

                val operationMyWhile7: (Int) -> Unit = { index ->
                    if (student.laboratoryWork[index] == "+") {
                        lr += 0.5
                    } else if (student.laboratoryWork[index] == "++") {
                        lr += 1.0
                    } else if (student.laboratoryWork[index] == "д") {
                        lr += 2.0
                    } else if (student.laboratoryWork[index] == "3") {
                        lr += 3.0
                    } else if (student.laboratoryWork[index] == "4") {
                        lr += 4.0
                    } else if (student.laboratoryWork[index] == "5") {
                        lr += 5.0
                    } else {
                        lr += 0.0
                    }

                }

                mW.myWhile(operationMyWhile7, "<", 0, student.laboratoryWork.size)
                dp += lr

                val operationMyWhile5: (Int) -> Unit = { index ->

                    if (student.individualProject[index] == "+") {
                        ap += 2
                    } else if (student.individualProject[index] == "3") {
                        ap += 3
                    } else if (student.individualProject[index] == "4") {
                        ap += 4
                    } else if (student.individualProject[index] == "5") {
                        ap += 5
                    } else {
                        ap += 0
                    }

                }

                mW.myWhile(operationMyWhile5, "<", 0, student.individualProject.size)
                result += ap

                val operationMyWhile3: (Int) -> Unit = { index ->

                    if (student.test[index] == "д") {
                        kr += 4
                    } else if (student.test[index] == "3") {
                        kr += 6
                    } else if (student.test[index] == "4") {
                        kr += 8
                    } else if (student.test[index] == "5") {
                        kr += 10
                    } else {
                        kr += 0
                    }
                }

                mW.myWhile(operationMyWhile3, "<", 0, student.test.size)
                dp += kr
                result += dp
                result += student.extraPoints

                print(" ЛР: $lr")
                print(" ЭП: $ap")
                print(" КР: $kr")
                println(" ИТОГ: $result")
            }
            myFor.pushThroughFor(operation)
        }
    }
}