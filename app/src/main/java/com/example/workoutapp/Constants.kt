package com.example.workoutapp

object Constants {

    const val addedExercise: String = "added"

    fun defaultExercisesList(): ArrayList<ExerciseModel>{
        val exerciseList = ArrayList<ExerciseModel>()
        val jumpingJacks = ExerciseModel(
            1,
            "Jumping Jacks",
            R.drawable.exercises,
            false,
            false
        )
        exerciseList.add(jumpingJacks)

        val pushups = ExerciseModel(
            2,
            "Pushups",
            R.drawable.exercises,
            false,
            false
        )
        exerciseList.add(pushups)

        val squads = ExerciseModel(
            3,
            "Squads",
            R.drawable.exercises,
            false,
            false
        )
        exerciseList.add(squads)

        return exerciseList
    }

}