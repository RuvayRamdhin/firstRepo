package com.example.logicalop

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    //declaring variables

    private lateinit var edtName: EditText
    private lateinit var edtAge: EditText
    private lateinit var cbStaff: CheckBox
    private lateinit var cdITStudent: CheckBox
    private lateinit var cbBanned: CheckBox
    private lateinit var btnCheck: Button
    private lateinit var tvResult: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //Link the variables to the UI components using their ID's (typecasting)
        edtName = findViewById(R.id.edtName)
        edtAge = findViewById(R.id.edtAge)
        cbStaff = findViewById(R.id.cbStaff)
        cdITStudent = findViewById(R.id.cdITStudent)
        cbBanned = findViewById(R.id.cbBanned)
        btnCheck = findViewById(R.id.btnCheck)
        tvResult = findViewById(R.id.tvResult)


        //Button to run the code when it is pressed
        btnCheck.setOnClickListener {

            //get the user's name from the editText
            val name = edtName.text.toString()

            //convert the age entered into a number (int)
            val age = edtAge.text.toString().toInt()

            //check if checkBoxes are selected (true or false)
            val isITStudent = cdITStudent.isChecked
            val isStaff = cbStaff.isChecked
            val isBanned = cbBanned.isChecked

            if(((age >= 18 && isITStudent) || isStaff) && !isBanned){

                //if the condition above is true
                tvResult.text = "Congratulations $name! You qualify for the student tech discount"

            } else {

                tvResult.text = "Sorry $name, you do not qualify for the discount"

            }
            /*
            Logical condition explanation

                Step 1: (age >= 18 && isITStudent
                >= means greater than or equal to
                && means AND  (both conditions must be true)

                so this checks if the user is 18 or older and is an IT student

                Step 2:
                || means OR ( only one condition needs to be true)

                this means the person can qualify if they are a staff member even if they are not
                a IT student

                Step 3: && !isBanned
                ! means NOT (It reverses the value)
                !isBanned means the person must NOT be banned

                Example
                isBanned = false
                !false = true
             */


        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}