package com.example.line

import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_chat_room.*
import kotlin.random.Random


data class Msgdata(val FROM:Int, val msg:String?,val photo:Int)

class MessageData {

    companion object{
        //val messageList = mutableListOf<Msgdata>()

        val msgList= mutableListOf(
            //"hi,how are you?",
            "son of a bitch!",
            "fuck you",
            "shut up",
            "are you kidding me?",
            "What the hell is wrong with you?",
            "what's your problem?",
            "you are a dick",
            //"good to see you!",
            //"happy birthday!",
            //"be free my friend",
            //"come on baby!",
            //
            // "what are you talking about?",
            "I don't give a shit",
            "What a stupid idiot!",
            "you're a piece of shit",
            " I wish I had never met you",
            "You make me sick",
            " You piss me off",
            "How dare you!",
            " I can’t take it anymore",
            "Don’t talk to me like that!",
            "I hate you!",
            "How can you say that?",
            "Fuck off",
            " You’re nothing to me"
            )







    }
}