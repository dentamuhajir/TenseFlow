package com.tenseflow.spell;

import java.util.Map;

public class IPAService {
    // ARPAbet to IPA mapping
    private static final Map<String, String> ARPABET_TO_IPA = Map.ofEntries(
            Map.entry("AA", "ɑ"), Map.entry("AE", "æ"), Map.entry("AH", "ʌ"),
            Map.entry("AO", "ɔ"), Map.entry("AW", "aʊ"), Map.entry("AY", "aɪ"),
            Map.entry("B", "b"), Map.entry("CH", "tʃ"), Map.entry("D", "d"),
            Map.entry("DH", "ð"), Map.entry("EH", "ɛ"), Map.entry("ER", "ɝ"),
            Map.entry("EY", "eɪ"), Map.entry("F", "f"), Map.entry("G", "ɡ"),
            Map.entry("HH", "h"), Map.entry("IH", "ɪ"), Map.entry("IY", "iː"),
            Map.entry("JH", "dʒ"), Map.entry("K", "k"), Map.entry("L", "l"),
            Map.entry("M", "m"), Map.entry("N", "n"), Map.entry("NG", "ŋ"),
            Map.entry("OW", "oʊ"), Map.entry("OY", "ɔɪ"), Map.entry("P", "p"),
            Map.entry("R", "r"), Map.entry("S", "s"), Map.entry("SH", "ʃ"),
            Map.entry("T", "t"), Map.entry("TH", "θ"), Map.entry("UH", "ʊ"),
            Map.entry("UW", "uː"), Map.entry("V", "v"), Map.entry("W", "w"),
            Map.entry("Y", "j"), Map.entry("Z", "z"), Map.entry("ZH", "ʒ")
    );
}
