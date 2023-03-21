package com.example.todoapp

class User{
    var toDaName: String = ""
    var toDoDescription:String = ""
    var degree: Flag? = null
    var toDoCreateDeadline:String = ""
    var toDoDeadline:String = ""

    var level: String = ""

    constructor(name: String, description: String, degree: Flag, createData: String, dedline: String, level: String) {
        this.toDaName = name
        this.toDoDescription = description
        this.degree = degree
        this.toDoCreateDeadline = createData
        this.toDoDeadline = dedline
        this.level = level
    }

    constructor()

    override fun toString(): String {
        return "TodoPlan(name='$toDaName', description='$toDoDescription', degree='$degree', createData='$toDoCreateDeadline', dedline='$toDoDeadline', level='$level')"
    }


}

object PlanObject{
    var toDoPlanList = ArrayList<User>()
}
