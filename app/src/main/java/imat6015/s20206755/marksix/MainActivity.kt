package imat6015.s20206755.marksix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var nextbtn: Button
    lateinit var clearbtn: Button
    lateinit var tv1: TextView
    lateinit var tv2: TextView
    lateinit var tv3: TextView
    lateinit var tv4: TextView
    lateinit var tv5: TextView
    lateinit var tv6: TextView
    lateinit var tv7: TextView
    lateinit var tv8: TextView


    val tvList = mutableListOf<TextView>()
    var numList = (1..49).toMutableList()
    var drawnNums = mutableListOf<Int>()
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nextbtn = findViewById(R.id.nextbtn)
        clearbtn = findViewById(R.id.clearbtn)
        tv1 = findViewById(R.id.tv1)
        tv2 = findViewById(R.id.tv2)
        tv3 = findViewById(R.id.tv3)
        tv4 = findViewById(R.id.tv4)
        tv5 = findViewById(R.id.tv5)
        tv6 = findViewById(R.id.tv6)
        tv7 = findViewById(R.id.tv7)
        tv8 = findViewById(R.id.tv8)

        tvList.addAll(listOf(tv1, tv2, tv3, tv4, tv5, tv6, tv7))
        nextbtn.setOnClickListener{
            nextNum()
        }

        clearbtn.setOnClickListener{
            reset()
        }
    }

    fun getNum(): Int {
        val index = (0 until numList.size).random()
        return numList.removeAt(index)
    }



    fun nextNum() {

        var newNum = getNum()
        tvList[count].text = newNum.toString()
        count++
        if (count == 7 ){
            nextbtn.isEnabled = false
            Handler().postDelayed({
                drawnNums.sort()
                for (i in 0..5) {
                    tvList[i].text = drawnNums[i].toString()
                    if (i == 5){
                        tv8.visibility = View.VISIBLE
                    }
                }

            }, 1000)
        }else{
            drawnNums.add(newNum)
        }
    }



    fun reset(){
        for (i in 0..6){
            tvList[i].text = "?"
        }
        nextbtn.isEnabled = true
        count = 0
        numList = (1..49).toMutableList()
        drawnNums.clear()
        tv8.visibility = View.INVISIBLE
    }


}