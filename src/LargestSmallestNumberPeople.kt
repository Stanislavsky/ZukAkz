class LargestSmallestNumberPeople
{
    fun finding(students: List<Student>)
    {

        if (students.isEmpty())
        {
            println("Список студентов пуст")
        }
        else
        {
            var counterLaboratoryWork = mutableListOf(0,0,0,0,0,0,0)
            var counterTest = mutableListOf(0,0,0)

            val operation:(Student) -> Unit = {
                if (it.allowancePoint == "недопуск") {
                    if (it.laboratoryWork[0] != "") {
                        counterLaboratoryWork[0] += 1
                    }
                    if (it.laboratoryWork[1] != "") {
                        counterLaboratoryWork[1] += 1
                    }
                    if (it.laboratoryWork[2] != "") {
                        counterLaboratoryWork[2] += 1
                    }
                    if (it.laboratoryWork[3] != "") {
                        counterLaboratoryWork[3] += 1
                    }
                    if (it.laboratoryWork[4] != "") {
                        counterLaboratoryWork[4] += 1
                    }
                    if (it.laboratoryWork[5] != "") {
                        counterLaboratoryWork[5] += 1
                    }
                    if (it.laboratoryWork[6] != "") {
                        counterLaboratoryWork[6] += 1
                    }
                    if (it.test[0] != "-") {
                        counterTest[0] += 1
                    }
                    if (it.test[1] != "-") {
                        counterTest[1] += 1
                    }
                    if (it.test[2] != "-") {
                        counterTest[2] += 1
                    }
                }
            }

            val myFor = MyCycle(students)
            myFor.pushThroughFor(operation)

            val lrWhichCompletedLargestNumber = counterLaboratoryWork.indexOf(counterLaboratoryWork.maxOrNull())
            val krWhichCompletedLargestNumber = counterTest.indexOf(counterTest.maxOrNull())
            println("Лабораторная работа которую выполнило наибольшее количество человек, не получившие допуск: ${lrWhichCompletedLargestNumber + 1}")
            println("Контрольная работа которую выполнило наименьшее количество человек, не получившие допуск: ${krWhichCompletedLargestNumber + 1}")
        }
    }
}