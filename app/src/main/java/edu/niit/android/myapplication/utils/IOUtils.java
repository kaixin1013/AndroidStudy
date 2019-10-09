package edu.niit.android.myapplication.utils;

import android.util.Xml;

import com.alibaba.fastjson.JSON;

import org.xmlpull.v1.XmlPullParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import edu.niit.android.myapplication.adapter.Exercise;
import edu.niit.android.myapplication.entity.ExerciseDetail;

public class IOUtils {
    public static  String convert(InputStream is, Charset encode){
        try{
            String line;
            StringBuilder builder=new StringBuilder();
            BufferedReader reader=new BufferedReader(new InputStreamReader(is,encode));
            while((line=reader.readLine())!=null){
                builder.append(line);
            }
            reader.close();
            return  builder.toString();
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
    public static <T> List<T> convert(String json,Class<T> cls){
        return JSON.parseArray(json,cls);
    }
    public static List<Exercise> getXmlContents(InputStream is) throws Exception{
        List<ExerciseDetail> details=null;
        XmlPullParser parser= Xml.newPullParser();
        parser.setInput(is, StandardCharsets.UTF_8.toString());
        int eventType = parser.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT){
            String nodeName = parser.getName();
            switch (eventType){
                case XmlPullParser.START_TAG:
                if ("infos".equals(nodeName)){
                    details=new ArrayList<>();
                }else if("exercise".equals(nodeName)){
                    details= (List<ExerciseDetail>) new ExerciseDetail();
                    String ids = parser.getAttributeValue(0);
                    details.setSubjectId(Integer.parseInt(ids));
                }else if("subject".equals(nodeName)){
                    details.setSubject(parser.nextText());
                }else if ()
            }
        }

    }
}
