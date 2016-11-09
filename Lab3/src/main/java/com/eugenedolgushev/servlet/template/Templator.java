package com.eugenedolgushev.servlet.template;

import com.eugenedolgushev.servlet.models.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Templator {
    private List<String> mParsedTemplate;
    private static Logger log = Logger.getLogger(Templator.class.getName());

    public Templator(final String fileName) throws IOException {

        mParsedTemplate = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                in.close();
            }
        } catch(IOException e) {
            log.severe(e.getMessage());
        }

        String readFile = sb.toString();
        String result = "";
        boolean isDollar = false;
        for (int i = 0; i < readFile.length(); ++i) {
            if (readFile.charAt(i) == '$') {
                isDollar = !isDollar;
            } else {
                if (readFile.charAt(i) == '{' && isDollar) {
                    mParsedTemplate.add(result);
                    result = "";
                } else {
                    if (readFile.charAt(i) == '}') {
                        isDollar = !isDollar;
                        mParsedTemplate.add(result);
                        result = "";
                    } else {
                        result += readFile.charAt(i);
                    }
                }
            }
        }
        mParsedTemplate.add(result);
    }

    public final void setBooksByTag(final String tagName, List<Book> books) {
        StringBuilder allBooks = new StringBuilder();
        for (Book book : books) {
            allBooks.append(book.toHTML());
            allBooks.append("\n");
        }

        setValueByTag(tagName, allBooks.toString());
    }

    public final void setValueByTag(final String tagName, final String value) {
        for (int i = 0; i < mParsedTemplate.size(); ++i) {
            if (tagName.equals(mParsedTemplate.get(i))) {
                mParsedTemplate.set(i, value);
                break;
            }
        }
    }

    public final String getHTML() {
        StringBuilder result = new StringBuilder();
        for (String templatePart : mParsedTemplate) {
            result.append(templatePart);
        }

        return result.toString();
    }
}
