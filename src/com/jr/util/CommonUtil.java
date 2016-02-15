package com.jr.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by JIANGRAN on 2016/2/15.
 */
public class CommonUtil {
    public String getTrace(Throwable t)
    {

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        t.printStackTrace(writer);
        StringBuffer buffer = new StringBuffer();
        buffer.append(stringWriter.getBuffer());
        return buffer.toString();
    }
}
