package com.example.xmlformatassignment

import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserException
import org.xmlpull.v1.XmlPullParserFactory
import java.io.IOException
import java.io.InputStream

class XmlPullParserHandler {
    private val students = ArrayList<Student>()
    private var text: String? = null
    private var id = 0
    private var stuName = ""
    private var stuMarks = 0

    fun parse(inputStream: InputStream): List<Student> {
        try {


            val factory = XmlPullParserFactory.newInstance()
            val parser = factory.newPullParser()
            parser.setInput(inputStream, null)
            var eventType = parser.eventType
            while (eventType != XmlPullParser.END_DOCUMENT) {
                val tagName = parser.name
                when (eventType) {
                    XmlPullParser.TEXT -> text = parser.text
                    XmlPullParser.END_TAG -> when {
                        tagName.equals("id", ignoreCase = true) -> {
                            id = text.toString().toInt()
                        }
                        tagName.equals("name", ignoreCase = true) -> {
                            stuName = text.toString()
                        }
                        tagName.equals("marks", ignoreCase = true) -> {
                            stuMarks = text.toString().toInt()
                        }
                        else -> students.add(Student(id, stuName, stuMarks))
                    }
                    else -> {
                    }
                }
                eventType = parser.next()
            }

        } catch (e: XmlPullParserException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return students
    }
}