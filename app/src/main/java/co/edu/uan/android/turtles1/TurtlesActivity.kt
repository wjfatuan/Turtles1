package co.edu.uan.android.turtles1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class TurtlesActivity : AppCompatActivity() {

    val turtles = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        turtles.add("Leo")
        turtles.add("Don")

        val arrayAdapter = ArrayAdapter<String>(
            this, android.R.layout.simple_list_item_1, turtles
        )


        turtlesList.adapter = arrayAdapter

        turtlesList.setOnItemClickListener { list, view, position, id ->
            // view es de tipo View -> realmente es un TextView
            val textView = view as TextView
            Toast.makeText(this, "${textView.text}", Toast.LENGTH_LONG).show()
            changeTurtleList(textView.text.toString())
        }

        radioDon.setOnClickListener { view ->  changeTurtleList("don") }
        radioMike.setOnClickListener { view ->  changeTurtleList("mike") }
        radioLeo.setOnClickListener { view ->  changeTurtleList(view.tag.toString()) }
        radioRaph.setOnClickListener { view ->  changeTurtleList(view.tag.toString()) }
        buttonAdd.setOnClickListener { _ -> addTurtle(arrayAdapter) }

    }

    fun addTurtle(adapter: ArrayAdapter<String>) {
        turtles.add("Mike")
        Log.v("EJEMPLOTAG",turtles.toString())
        adapter.notifyDataSetChanged()
    }

    fun changeTurtleList(turtleName: String) {
        val filename = "tmnt"+turtleName.toLowerCase()
        val resourceId = resources.getIdentifier(filename, "drawable", this.packageName)
        turtleImage.setImageResource(resourceId)
        val radioId = resources.getIdentifier("radio"+turtleName.capitalize(), "id", this.packageName)
        val radio = findViewById<RadioButton>(radioId)
        radio.setChecked(true)
    }

    /**
     * 1. Un metodo por cada tortuga
     * 2. if
     * 3. arreglo
     * 4. leer lo q hay en la carpeta y pasar al siguiente
     */

    fun changeTurtle(v: View) {
        val filename = v.tag.toString()
        val resourceId = resources.getIdentifier(filename, "drawable", this.packageName)
        turtleImage.setImageResource(resourceId)
//        when (v) {
//            radioMike -> { // es el radio button de mike
//                turtleImage.setImageResource(R.drawable.tmntmike)
//            }
//            radioDon -> { // es el radio button de don
//                turtleImage.setImageResource(R.drawable.tmntdon)
//            }
//            radioRaph -> { // es el radio button de raph
//                turtleImage.setImageResource(R.drawable.tmntraph)
//            }
//            radioLeo -> { // es el radio button de eleo
//                turtleImage.setImageResource(R.drawable.tmntleo)
//            }
//            else -> {
//
//            }
//        }
    }

    fun changeTurtleMike(v: View) {
        val fileName = resources.getResourceName(R.drawable.tmntmike)
        Toast.makeText(this, "Changing turtle image to ${fileName}", Toast.LENGTH_LONG).show()
        turtleImage.setImageResource(R.drawable.tmntmike)
    }

    fun changeTurtleLeo(v: View) {
        val fileName = resources.getResourceName(R.drawable.tmntmike)
        Toast.makeText(this, "Changing turtle image to ${fileName}", Toast.LENGTH_LONG).show()
        turtleImage.setImageResource(R.drawable.tmntleo)
    }

    fun changeTurtleDon(v: View) {
        val fileName = resources.getResourceName(R.drawable.tmntmike)
        Toast.makeText(this, "Changing turtle image to ${fileName}", Toast.LENGTH_LONG).show()
        turtleImage.setImageResource(R.drawable.tmntdon)
    }

    fun changeTurtleRaph(v: View) {
        val fileName = resources.getResourceName(R.drawable.tmntmike)
        Toast.makeText(this, "Changing turtle image to ${fileName}", Toast.LENGTH_LONG).show()
        turtleImage.setImageResource(R.drawable.tmntraph)
    }
}