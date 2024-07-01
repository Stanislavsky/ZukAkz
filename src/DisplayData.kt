class DisplayData() {
    fun displayStudents(students: List<Student>) {
        if (students.isEmpty()) {
            println("Список студентов пуст")
        } else {
            var prevGroup = ""

            val myFor = MyCycle(students)

            val operation:(Student) -> Unit = {

                if (it.group != prevGroup) {

                    println()
                    prevGroup = it.group
                }

                print("group: ${it.group}, ")
                print("ID: ${it.id}, ")
                print("name: ${it.name}, ")
                print("extraPoints: ${it.extraPoints}, ")
                print("git: ${it.git}, ")
                print("attendanceLectures: ${it.attendanceLectures}, ")
                print("attendancePractitioner: ${it.attendancePractitioner}, ")
                print("laboratoryWork: ${it.laboratoryWork}, ")
                print("individualProject: ${it.individualProject}, ")
                print("test: ${it.test}, ")
                print("allowancePoint: ${it.allowancePoint}, ")
                println("attendanceStudent: ${it.attendanceStudent}")
            }

            myFor.pushThroughFor(operation)

        }
    }
}
