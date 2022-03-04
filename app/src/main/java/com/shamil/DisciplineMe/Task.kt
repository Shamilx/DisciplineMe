package com.shamil.DisciplineMe

import java.sql.Time

class Task {
    var taskName: String
    var taskDesc: String
    var taskTime: Time

    constructor(taskName: String, taskDesc: String, taskTime: Time) {
        this.taskName = taskName
        this.taskDesc = taskDesc
        this.taskTime = taskTime
    }
}