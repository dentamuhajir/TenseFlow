package com.tenseflow.PartOfSpeech;

import com.tenseflow.npl.standford.Pipeline;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;
import org.springframework.core.io.ClassPathResource;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.springframework.stereotype.Service;

import java.util.*;

// https://stanfordnlp.github.io/CoreNLP/api.html

@Service
public class PartOfSpeechService {

    void analyzePOS(String word) {
        StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();
        String text = word;
        CoreDocument coreDocument = new CoreDocument(text);
        stanfordCoreNLP.annotate(coreDocument);
        List<CoreLabel> coreLabelList = coreDocument.tokens();

        for(CoreLabel coreLabel: coreLabelList){
            String pos = coreLabel.get(CoreAnnotations.PartOfSpeechAnnotation.class);
            System.out.println(coreLabel.originalText() + " = " + pos);
            POSTagger(pos);
        }

    }

    public Map<String, String> generatePartOfSpeech(String sentence) {
        StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();
        CoreDocument coreDocument = new CoreDocument(sentence);
        stanfordCoreNLP.annotate(coreDocument);
        List<CoreLabel> coreLabelList = coreDocument.tokens();

        Map<String, String> partOfSpeech = new LinkedHashMap<>();

        for(CoreLabel coreLabel: coreLabelList){
            String pos = coreLabel.get(CoreAnnotations.PartOfSpeechAnnotation.class);
            partOfSpeech.put(coreLabel.originalText(), pos);
        }

        return partOfSpeech;
    }

    void POSTagger(String tagCode) {
        String tag = "";
        String description = "description in english";
        String descriptionID = "description in indonesia";
        switch(tagCode) {
            case "CC":
                tag = "Coordinating Conjunction";
                description = "Connects words, phrases, or clauses of equal importance (e.g., and, but, or).";
                descriptionID = "Menghubungkan kata, frasa, atau klausa yang setara (contoh: dan, tetapi, atau).";
                break;
            case "CD":
                tag = "Cardinal Number";
                description = "Used for numbers that show quantity (e.g., one, two, three).";
                descriptionID = "Digunakan untuk angka yang menunjukkan jumlah (contoh: satu, dua, tiga).";
                break;
            case "DT":
                tag = "Determiner";
                description = "Introduces a noun and limits its meaning (e.g., the, a, some).";
                descriptionID = "Memperkenalkan kata benda dan membatasi maknanya (contoh: si, sebuah, beberapa).";
                break;
            case "EX":
                tag = "Existential There";
                description = "Indicates the existence of something (e.g., there is, there are).";
                descriptionID = "Menunjukkan keberadaan sesuatu (contoh: ada).";
                break;
            case "FW":
                tag = "Foreign Word";
                description = "A word from a foreign language included in English text.";
                descriptionID = "Kata dari bahasa asing yang digunakan dalam teks bahasa Inggris.";
                break;
            case "IN":
                tag = "Preposition or Subordinating Conjunction";
                description = "Links nouns/pronouns to other words or connects clauses (e.g., in, on, because).";
                descriptionID = "Menghubungkan kata benda/pronomina ke kata lain atau klausa (contoh: di, pada, karena).";
                break;
            case "JJ":
                tag = "Adjective";
                description = "Describes a noun or pronoun (e.g., big, red, quick).";
                descriptionID = "Menjelaskan kata benda atau kata ganti (contoh: besar, merah, cepat).";
                break;
            case "JJR":
                tag = "Adjective, Comparative";
                description = "Compares two things (e.g., bigger, faster).";
                descriptionID = "Membandingkan dua hal (contoh: lebih besar, lebih cepat).";
                break;
            case "JJS":
                tag = "Adjective, Superlative";
                description = "Describes the extreme or highest degree (e.g., biggest, fastest).";
                descriptionID = "Menjelaskan tingkat paling tinggi atau ekstrem (contoh: paling besar, paling cepat).";
                break;
            case "LS":
                tag = "List Item Marker";
                description = "Marks items in a list (e.g., 1., a., i.).";
                descriptionID = "Menandai item dalam daftar (contoh: 1., a., i.).";
                break;
            case "MD":
                tag = "Modal";
                description = "Helps express mood or tense (e.g., can, will, must).";
                descriptionID = "Membantu menyatakan suasana atau waktu (contoh: bisa, akan, harus).";
                break;
            case "NN":
                tag = "Noun, Singular or Mass";
                description = "Refers to a person, place, thing, or idea (e.g., book, car, love).";
                descriptionID = "Mengacu pada orang, tempat, benda, atau ide (contoh: buku, mobil, cinta).";
                break;
            case "NNS":
                tag = "Noun, Plural";
                description = "Refers to more than one noun (e.g., books, cars).";
                descriptionID = "Mengacu pada lebih dari satu kata benda (contoh: buku-buku, mobil-mobil).";
                break;
            case "NNP":
                tag = "Proper Noun, Singular";
                description = "Refers to a specific name (e.g., John, London).";
                descriptionID = "Mengacu pada nama khusus (contoh: John, Jakarta).";
                break;
            case "NNPS":
                tag = "Proper Noun, Plural";
                description = "Plural form of proper noun (e.g., Americans, Indonesians).";
                descriptionID = "Bentuk jamak dari kata benda khusus (contoh: orang Amerika, orang Indonesia).";
                break;
            case "PDT":
                tag = "Predeterminer";
                description = "Comes before a determiner (e.g., all the, both the).";
                descriptionID = "Muncul sebelum determiner (contoh: semua si, kedua si).";
                break;
            case "POS":
                tag = "Possessive Ending";
                description = "Shows possession (e.g., 's in John's book).";
                descriptionID = "Menunjukkan kepemilikan (contoh: -nya dalam buku John).";
                break;
            case "PRP":
                tag = "Personal Pronoun";
                description = "Refers to people or things (e.g., I, you, he, it).";
                descriptionID = "Mengacu pada orang atau benda (contoh: saya, kamu, dia, itu).";
                break;
            case "PRP$":
                tag = "Possessive Pronoun";
                description = "Shows ownership (e.g., my, your, his).";
                descriptionID = "Menunjukkan kepemilikan (contoh: milikku, milikmu, miliknya).";
                break;
            case "RB":
                tag = "Adverb";
                description = "Modifies a verb, adjective, or other adverb (e.g., quickly, very).";
                descriptionID = "Menjelaskan kata kerja, kata sifat, atau kata keterangan lain (contoh: dengan cepat, sangat).";
                break;
            case "RBR":
                tag = "Adverb, Comparative";
                description = "Compares two actions or qualities (e.g., faster, better).";
                descriptionID = "Membandingkan dua aksi atau kualitas (contoh: lebih cepat, lebih baik).";
                break;
            case "RBS":
                tag = "Adverb, Superlative";
                description = "Describes the highest degree (e.g., fastest, best).";
                descriptionID = "Menjelaskan tingkat paling tinggi (contoh: paling cepat, terbaik).";
                break;
            case "RP":
                tag = "Particle";
                description = "A small word that adds meaning to a verb (e.g., up, off, out).";
                descriptionID = "Kata kecil yang menambah makna pada kata kerja (contoh: ke atas, keluar, mati).";
                break;
            case "SYM":
                tag = "Symbol";
                description = "Mathematical or other symbol (e.g., +, %, $).";
                descriptionID = "Simbol matematika atau lainnya (contoh: +, %, $).";
                break;
            case "TO":
                tag = "To";
                description = "The word 'to' (e.g., to go, to play).";
                descriptionID = "Kata 'to' yang sering digunakan sebelum kata kerja (contoh: untuk pergi, untuk bermain).";
                break;
            case "UH":
                tag = "Interjection";
                description = "Expresses emotion (e.g., oh, wow, oops).";
                descriptionID = "Mengungkapkan emosi atau reaksi (contoh: oh, wow, ups).";
                break;
            case "VB":
                tag = "Verb, Base Form";
                description = "Base form of a verb (e.g., go, eat, run).";
                descriptionID = "Bentuk dasar kata kerja (contoh: pergi, makan, lari).";
                break;
            case "VBD":
                tag = "Verb, Past Tense";
                description = "Verb in past tense (e.g., went, ate, ran).";
                descriptionID = "Kata kerja bentuk lampau (contoh: pergi, makan, berlari).";
                break;
            case "VBG":
                tag = "Verb, Gerund/Present Participle";
                description = "Verb ending in -ing (e.g., going, eating).";
                descriptionID = "Kata kerja bentuk -ing (contoh: sedang pergi, sedang makan).";
                break;
            case "VBN":
                tag = "Verb, Past Participle";
                description = "Used in perfect tenses (e.g., gone, eaten).";
                descriptionID = "Digunakan dalam tense sempurna (contoh: telah pergi, telah makan).";
                break;
            case "VBP":
                tag = "Verb, Non-3rd Person Singular Present";
                description = "Present tense verb for I/we/you/they (e.g., go, eat).";
                descriptionID = "Kata kerja present untuk I/we/you/they (contoh: pergi, makan).";
                break;
            case "VBZ":
                tag = "Verb, 3rd Person Singular Present";
                description = "Present tense verb for he/she/it (e.g., goes, eats).";
                descriptionID = "Kata kerja present untuk he/she/it (contoh: pergi, makan).";
                break;
            case "WDT":
                tag = "Wh-Determiner";
                description = "Determiner used in wh-questions (e.g., which, what).";
                descriptionID = "Determiner dalam pertanyaan (contoh: yang mana, apa).";
                break;
            case "WP":
                tag = "Wh-Pronoun";
                description = "Pronoun used in wh-questions (e.g., who, what).";
                descriptionID = "Kata ganti dalam pertanyaan (contoh: siapa, apa).";
                break;
            case "WP$":
                tag = "Possessive Wh-Pronoun";
                description = "Shows ownership in a wh-question (e.g., whose).";
                descriptionID = "Menunjukkan kepemilikan dalam pertanyaan (contoh: milik siapa).";
                break;
            case "WRB":
                tag = "Wh-Adverb";
                description = "Adverb used in wh-questions (e.g., where, when, why).";
                descriptionID = "Kata keterangan dalam pertanyaan (contoh: di mana, kapan, mengapa).";
                break;
            default:
                tag = "Unknown";
                description = "Not a recognized POS tag.";
                descriptionID = "Bukan tag bagian dari ucapan yang dikenal.";
        }

        System.out.println("Tag: " + tag);
        System.out.println("Description (EN): " + description);
        System.out.println("Description (ID): " + descriptionID);
        System.out.println("=============================================");
    }


    void generateWord(){

        Integer randomNumber = (int) (Math.random() * 8) + 1;

        //System.out.println("random number" + randomNumber);
        HashMap<String, String> partOfSpeechMap = listPartOfSpeech();

        String getPartOfSpeech = "", getFile="";

        Integer index = 1;
        for (Map.Entry<String, String> entry : partOfSpeechMap.entrySet()) {
            //String partOfSpeech = entry.getKey();
            //String filename = entry.getValue();
            //System.out.println("index " +index+ " "  + partOfSpeech + " => " + filename);
            if(index.equals(randomNumber)){
              getPartOfSpeech = entry.getKey();
              getFile = entry.getValue();
              break;
            }

            index++;
        }

        //System.out.println("Random part of speech is " + getPartOfSpeech);

        List<String> listWord = readFile(getFile);

        int totalWord = listWord.size();
        Integer randomWord = (int) (Math.random() * totalWord) + 1;
        Integer indexWord = 1;
        String word = "";
        for(String list: listWord ){
            if(indexWord.equals(randomWord)) {
                word = list;
            }
            indexWord++;
            //System.out.println(list);
        }

        System.out.println("Word : " + word + " | " + getPartOfSpeech);
    }

    public List<String> readFile(String randomFile) {
        List<String> adjectives = new ArrayList<>();

        try {
            ClassPathResource resource = new ClassPathResource("dataset/kaggle/part_of_speech_collection/" + randomFile);
            InputStream inputStream = resource.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                adjectives.add(line.trim());
            }

            reader.close();
        } catch (Exception e) {
            e.printStackTrace(); // You can use proper logging
        }

        return adjectives;
    }

    HashMap<String, String> listPartOfSpeech() {
        HashMap<String, String> listDataset = new HashMap<>();
        listDataset.put("Adjective" , "adjective.txt");
        listDataset.put("Adverb", "adverb.txt");
        listDataset.put("Conjunction", "conjunction.txt");
        listDataset.put("Interjections", "Interjections.txt");
        listDataset.put("Noun", "noun.txt");
        listDataset.put("Preposition", "preposition.txt");
        listDataset.put("Pronoun", "pronoun.txt");
        listDataset.put("Verb", "verb.txt");
        return listDataset;
    }
}
