package com.example.hw22

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), OnItemClickListener {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var myList = mutableListOf(
            DataSource("Android",
                "Android is a mobile operating system based on a modified version of the Linux " +
                        "kernel and other open source software, designed primarily for touchscreen " +
                        "mobile devices such as smartphones and tablets. Android is developed by a " +
                        "consortium of developers known as the Open Handset Alliance and commercially" +
                        "sponsored by Google. It was unveiled in November 2007, with the first commercial " +
                        "Android device, the HTC Dream, being launched in September 2008.",
                "https://cdn.pixabay.com/photo/2018/05/03/21/49/android-3372580_960_720.png"),

            DataSource("iOS",
            "iOS (formerly iPhone OS or iPhone Operating System[citation needed]) is a mobile operating " +
                    "system created and developed by Apple Inc. exclusively for its hardware. It is the " +
                    "operating system that powers many of the company's mobile devices, including the iPhone;" +
                    " the term also included the versions running on iPads until iPadOS was introduced in 2019," +
                    " as well as on the iPod Touch devices, which were discontinued in mid-2022.[12] It is the " +
                    "world's second-most widely installed mobile operating system, after Android.",
            "https://tabletzona.es/wp-content/uploads/2021/10/iOS-Apple.jpg"),

            DataSource("Kotlin",
                "Kotlin  is a cross-platform, statically typed," +
                        " general-purpose programming language with type inference. Kotlin is designed to " +
                        "interoperate fully with Java, and the JVM version of Kotlin's standard library depends " +
                        "on the Java Class Library, but type inference allows its syntax to be more concise",
                "https://cms-assets.tutsplus.com/uploads/users/1499/posts/29328/preview_image/kotlin.jpg"),

            DataSource("Swift", "Swift is a general-purpose, multi-paradigm, compiled programming" +
                    " language developed by Apple Inc. and the open-source community. First released in 2014," +
                    " Swift was developed as a replacement for Apple's earlier programming language Objective-C," +
                    " as Objective-C had been largely unchanged since the early 1980s and lacked modern language features",
            "https://seeklogo.com/images/S/swift-logo-F41F53A22D-seeklogo.com.png"),

            DataSource("Xamarin", "With a C#-shared codebase, developers can use Xamarin tools " +
                    "to write native Android, iOS, and Windows apps with native user interfaces and share code " +
                    "across multiple platforms, including Windows, macOS, and Linux. According to Xamarin, over " +
                    "1.4 million developers were using Xamarin's products in 120 countries around the world as of April 2017.",
            "https://avatars.githubusercontent.com/u/790012?s=280&v=4"),

           DataSource("Flutter", "Flutter is an open-source UI software development kit created" +
                   " by Google. It is used to develop cross platform applications for Android, iOS, Linux, macOS," +
                   " Windows, Google Fuchsia, and the web from a single codebase",
               "https://play-lh.googleusercontent.com/5e7z5YCt7fplN4qndpYzpJjYmuzM2WSrfs35KxnEw-Ku1sClHRWHoIDSw3a3YS5WpGcI")
        )

        val adapter = Adapter(myList, this)
        val myRecyclerView:RecyclerView = findViewById(R.id.recyclerView)
        myRecyclerView.adapter = adapter
        myRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter.notifyItemInserted(myList.size - 1)





    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this,"Item ${position} clicked", Toast.LENGTH_SHORT).show()

    }


}