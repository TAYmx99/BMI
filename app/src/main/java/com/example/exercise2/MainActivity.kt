package com.example.exercise2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalc.setOnClickListener()
        {
            try {

                val height: Double = Height.text.toString().toDouble();
                val weight: Double = Weight.text.toString().toDouble();
                ;
                val heights: Double = height / 100;
                val bmi = weight / (heights * heights);
                // weight / Math.pow(heights,2.0);
                val status: String;

                if (bmi < 18.5) {
                    image.setImageResource(R.drawable.under)
                    status = "Under"
                } else if (bmi >= 18.5 && bmi <= 24.9) {
                    image.setImageResource(R.drawable.normal)
                    status = "Normal"
                } else {
                    image.setImageResource(R.drawable.over)
                    status = "Over"
                }
                //when {
                //bmi < 18.5 -> image.setImageResource(R.drawable.under)
                //bmi <24.9 -> image.setImageResource(R.drawable.normal)
                //else ->  image.setImageResource(R.drawable.over)

                BMI.text = "BMI: %.2f (%s)".format(bmi, status)
            }catch (ex:Exception){
                val toast:Toast = Toast.makeText(this, "Weight and Height cannot be empty!", Toast.LENGTH_SHORT)
                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.show()
            }
            }

        Reset.setOnClickListener()
        {
            Height.text = null;
            Weight.text = null;
            BMI.text = null;
            image.setImageResource(R.drawable.empty);
        }
    }

}
