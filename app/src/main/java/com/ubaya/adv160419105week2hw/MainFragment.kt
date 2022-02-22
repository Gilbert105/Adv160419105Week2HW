package com.ubaya.adv160419105week2hw

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var num1 = (0..100).random()
        var num2 = (0..100).random()
        var score = 0
        textSoal.text = "$num1 + $num2"
        textTemp.text = "Your Score : $score"
        buttonSubmit.setOnClickListener {
            var answer = textInputAnswer.editText?.text.toString()
            if(answer != null){
                if(num1 + num2 == answer.toInt()){
                    num1 = (0..100).random()
                    num2 = (0..100).random()
                    textSoal.text = "$num1 + $num2"
                    score = score + 1
                    textTemp.text = "Your Score : $score"
                }
                else{
                    var action = MainFragmentDirections.actionMainFragmentToResultFragment(score)
                    Navigation.findNavController(it).navigate(action)
                }
            }
        }
    }
}