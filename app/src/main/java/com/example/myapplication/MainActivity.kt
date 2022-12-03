package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ClickListener
{
    private lateinit var activityMainBinding : ActivityMainBinding
    lateinit var buttonList : ArrayList<ButtonModel>
    lateinit var buttonAdapter : ButtonAdapter

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        buttonList = arrayListOf()

        val button1 = ButtonModel()
        button1.text = "Çok İyi"
        button1.isPressed = false
        buttonList.add(button1)

        val button2 = ButtonModel()
        button2.text = "İyi"
        button2.isPressed = false
        buttonList.add(button2)

        val button3 = ButtonModel()
        button3.text = "Eh İşte"
        button3.isPressed = false
        buttonList.add(button3)

        val button4 = ButtonModel()
        button4.text = "Kötü"
        button4.isPressed = false
        buttonList.add(button4)

        val button5 = ButtonModel()
        button5.text = "Çok Kötü"
        button5.isPressed = false
        buttonList.add(button5)

        buttonAdapter = ButtonAdapter(this, buttonList, this)
        activityMainBinding.rvButonlar.layoutManager = LinearLayoutManager(this)
        activityMainBinding.rvButonlar.adapter = buttonAdapter
    }

    override fun onClick(position: Int)
    {
        for (buttonModel in buttonList)
        {
            buttonModel.isPressed = false
        }
        buttonList[position].isPressed = true
        buttonAdapter.notifyItemRangeChanged(0, buttonList.size)
    }
}