package com.tenseflow.npl.standford;

import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.util.Properties;

// https://www.youtube.com/watch?v=D0LcPg9Jy08
public class Pipeline {
    private static StanfordCoreNLP stanfordCoreNLP;
    private static Properties properties;
    private static String propertiesName = "tokenize,ssplit,pos";

    private Pipeline(){}

    static {
        properties = new Properties();
        properties.setProperty("annotators", propertiesName);
    }

    public static StanfordCoreNLP getPipeline() {
        if(stanfordCoreNLP == null) {
            stanfordCoreNLP = new StanfordCoreNLP(properties);
        }
        return stanfordCoreNLP;
    }

}
