import java.io.IOException;
import java.util.Scanner;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.io.PrintWriter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class mega {

  final static String CPU_MEGA_PAGE_URL = 
    "https://www.cpubenchmark.net/CPU_mega_page.html";

  private static String readStringFromURL(String requestURL) throws IOException {
    System.out.println("Downloading mega page...");

    String s =  "";
    long startTime = System.currentTimeMillis();

    try (Scanner scanner = new Scanner(new URL(requestURL).openStream(),
            StandardCharsets.UTF_8.toString()))
    {
        scanner.useDelimiter("\\A");
        s =  scanner.hasNext() ? scanner.next() : "";
       
        long stopTime = System.currentTimeMillis();
        showDownloadStats(stopTime - startTime, s.length());
    }
    return s;
  }

  private static void showDownloadStats(long ms, long len) {
    float secs = (float)ms/1000;
    float mb = (float)len/1000000;
    float kb = (float)len/1000;
    float kbps = kb/secs;
    System.out.println(String.format(
      "Downloaded %.1f Mb in %.1f seconds @ %.1f Kb/sec", 
      mb, secs, kbps));
  }

  public static String extractCpuInfo(String page) {
    System.out.println("Creating json data...");

    String js = "[\n";
    String regex = "cpu_lookup.*?>(.*?)</a></td><td>.*?</td><td>(.*?)</td><td>.*?</td><td>(.*?)</td><td>.*?" +
      "</td><td>(.*?)</td><td>(.*?)</td><td>(.*?)</td><td>.*?</td><td>(.*?)</td></tr>" +
      ".*?No\\sof\\sCores</span>:\\s(.*?)</div>";

    Pattern pattern = Pattern.compile(regex);

    Matcher m = pattern.matcher(page);
    int count=0;
    while(m.find()) {

      int singleThreadMark = 0;
      int tdp = 0;
      int powerPerf = 0;
      int cpuMark = 0;

      try { singleThreadMark = Integer.parseInt(m.group(3)); } catch (NumberFormatException e) {}
      try { tdp = Integer.parseInt(m.group(4)); } catch (NumberFormatException e) {}
      try { powerPerf = Integer.parseInt(m.group(5)); } catch (NumberFormatException e) {}
      try { cpuMark = Integer.parseInt(m.group(2)); } catch (NumberFormatException e) {}

      js += count>0 ? ",\n{\n" : "{\n";
      js += String.format("\"name\" : \"%s\",\n", m.group(1));
      js += String.format("\"cores\" : \"%s\",\n", m.group(8));
      js += String.format("\"type\" : \"%s\",\n", m.group(7));
      js += String.format("\"cpuMark\" : \"%d\",\n", cpuMark);
      js += String.format("\"singleThreadMark\" : \"%d\",\n", singleThreadMark);
      js += String.format("\"tdp\" : \"%d\",\n", tdp);
      js += String.format("\"powerPerf\" : \"%d\",\n", powerPerf);
      js += String.format("\"releaseDate\" : \"%s\"", m.group(6));
      js += "\n}";
      count++;
    }
    if(count > 1){
      js+="\n]";
      System.out.println("Number of CPUs: " + Integer.toString(count));  
      return js;
    }
    else {
      return "";
    }
  }

  public static void createJsFile(String js) {
    try {
      System.out.println("Writing data to cpus.json...");
      PrintWriter pw = new PrintWriter("cpus.json");
      pw.println(js);
      pw.close();
    } catch (IOException e) {
     System.out.println("Exception while writing cpus.js: " + e.toString()); 
    }
  }

  public static void main(String[] args) {
    try{
      String s = readStringFromURL(CPU_MEGA_PAGE_URL);
      String js = extractCpuInfo(s.replace("\n", ""));
      if(js.length()>0) {
      	createJsFile(js);
      }
    }
    catch(IOException ex){
      System.out.println("Couldn't read mega page: " + ex.toString());
    }
  }
}
