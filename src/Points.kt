class Points
{
    fun finding(students: List<Student>)
    {
        if (students.isEmpty())
        {
            println("Список студентов пуст")
        }
        else
        {
            var currentGroup: String? = null // Переменная для хранения текущей группы
            var attendanceOne: Double = 0.0
            var attendanceTwo: Double = 0.0



            var averageLr: Double = 0.0
            var averagePr: Double = 0.0


            for (i in students)
            {
                if (currentGroup != i.group)
                {
                    println()
                    currentGroup = i.group
                }
                print(i.name)
                var dp: Double = 0.0
                var result: Double = 0.0
                var kr: Double = 0.0
                var lr: Double = 0.0
                var ap: Double = 0.0
                var count = 0

                averageLr = i.attendanceLectures.toDouble() / 12 * 5

                averagePr = i.attendancePractitioner.toDouble() / 12 * 5
                attendanceOne = averageLr + averagePr

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
                print(" Посещаемость: " + attendanceTwo)

                while (count != 7) {

                    if (i.laboratoryWork[count] == "+") {
                        lr += 0.5
                    } else if (i.laboratoryWork[count] == "++") {
                        lr += 1
                    } else if (i.laboratoryWork[count] == "д") {
                        lr += 2
                    } else if (i.laboratoryWork[count] == "3") {
                        lr += 3
                    } else if (i.laboratoryWork[count] == "4") {
                        lr += 4
                    } else if (i.laboratoryWork[count] == "5") {
                        lr += 5
                    } else {
                        lr += 0
                    }
                    count += 1
                }
                dp += lr
                count = 0
                while (count != 5)
                {
                    if (i.individualProject[count] == "+") {
                        ap += 2
                    } else if (i.individualProject[count] == "3") {
                        ap += 3
                    } else if (i.individualProject[count] == "4") {
                        ap += 4
                    } else if (i.individualProject[count] == "5") {
                        ap += 5
                    } else {
                        ap += 0
                    }
                    count += 1
                }
                result += ap
                count = 0
                while (count != 3)
                {
                    if (i.test[count] == "д") {
                        kr += 4
                    } else if (i.test[count] == "3") {
                        kr += 6
                    } else if (i.test[count] == "4") {
                        kr += 8
                    } else if (i.test[count] == "5") {
                        kr += 10
                    } else {
                        kr += 0
                    }
                    count += 1
                }
                dp += kr
                result += dp
                result += i.extraPoints


                print(" ЛР: " + lr)
                print(" ЭП: " + ap)
                print(" Kр: " + kr)
                println(" ИТОГ: " + result)

            }
        }
    }
}