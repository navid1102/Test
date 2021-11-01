package com.petroiranco.test.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "USER_TABLE")
class User (

    @ColumnInfo(name="name")var name:String,
    @ColumnInfo(name="age") var age:Int,
) {
    @PrimaryKey(autoGenerate = true)
    var id:Int=0
}