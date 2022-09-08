package com.smarthub.obvious.utils;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

public class Util {

    /**
     * read file stored in internal storage : android resources
     * @param rawResId
     * @param context
     * @return
     * @throws IOException
     */
    public static synchronized String readResFileContent(int rawResId, Context context) throws IOException {
        InputStream is = context.getResources().openRawResource(rawResId);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } finally {
            is.close();
        }
        String jsonString = writer.toString();
        return jsonString;
    }
}
