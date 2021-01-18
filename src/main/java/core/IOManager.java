package core;

import java.io.*;

public class IOManager {
    private InputListener listener;
    private InputStream is;
    private PrintWriter pw;

    public IOManager() {
        this(System.in, System.out);
    }

    public IOManager(InputStream is, PrintStream ps) {
        this.is = is;
        this.pw = new PrintWriter(ps);
    }


    public void setListener(InputListener listener) {
        this.listener = listener;
    }

    /**
     * The main input loop.
     */
    public void run() {

        try (var br = new BufferedReader(new InputStreamReader(this.is))) {
            while (true) {
                String s = br.readLine();
                if (s.equalsIgnoreCase("bye")) {
                    // exit condition
                    pw.println("bye");
                    break;
                } else {
                    pw.println(s);
                }
                pw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
