class DisplayData() {
    fun displayStudents(students: List<Student>) {
        if (students.isEmpty()) {
            println("Список студентов пуст")
        } else {
            var prevGroup = ""
            for (student in students) {

                if (student.group != prevGroup) {

                    println()
                    prevGroup = student.group
                }

                print("group: ${student.group}, ")
                print("ID: ${student.id}, ")
                print("name: ${student.name}, ")
                print("extraPoints: ${student.extraPoints}, ")
                print("git: ${student.git}, ")
                print("attendanceLectures: ${student.attendanceLectures}, ")
                print("attendancePractitioner: ${student.attendancePractitioner}, ")
                print("laboratoryWork: ${student.laboratoryWork}, ")
                print("individualProject: ${student.individualProject}, ")
                print("test: ${student.test}, ")
                print("allowancePoint: ${student.allowancePoint}, ")
                println("attendanceStudent: ${student.attendanceStudent}")
            }
        }
    }
}
