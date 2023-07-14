package project;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

public class CityFromWikipedia {
    private final String url = "https://uk.wikipedia.org/wiki/%D0%9C%D1%96%D1%81%D1%82%D0%B0_%D0%A3%D0%BA%D1%80%D0%B0%D1%97%D0%BD%D0%B8_(%D0%B7%D0%B0_%D0%B0%D0%BB%D1%84%D0%B0%D0%B2%D1%96%D1%82%D0%BE%D0%BC)";
    private Map<Character,List<String>> cities;
    private Elements citiFromWiki() throws IOException {
        Document city = Jsoup.connect(url).get();
        return city.select("table td");
    }

    public Map<Character, List<String>> getCities() throws IOException {
        if(cities == null){
            cities = new LinkedHashMap<>();
            feelCities();
        }
        return cities;
    }

    private void feelCities() throws IOException {
        for (Element el : citiFromWiki()) {
            String s = el.text().replaceAll("[0-9. ]", "");
            if (el.text().length() == s.length()) {
                if (el.text().length() == 0) {
                    continue;
                }
                char firstLetter = el.text().charAt(0);
                cities.computeIfAbsent(firstLetter, k -> new ArrayList<>());
                cities.get(firstLetter).add(el.text());
            }
        }
    }
}
