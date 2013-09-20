package org.owller.CubeWorld.Logging;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CubeLogger {
    public CubeLogger() {}
    
    public String getPrefix() {
        Date now = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return "[" + format.format(now) + "] ";
    }
    
    private void log(String prefix, Object... o) {
        if(o.length < 1) return;
        String m = o[0].toString();
        if(o.length > 1) {
            for(int i = 1; i < o.length; i++) {
                m = m.replaceAll("\\{\\" + i + "\\}", o[i].toString());
            }
        }
        
        System.out.println(this.getPrefix() + prefix + m);
    }
    
    public void info(Object... o) {this.log("[INFO] ", o);}
    public void debug(Object... o) {this.log("[DEBUG] ", o);}
    public void warn(Object... o) {this.log("[WARNING] ", o);}
}
