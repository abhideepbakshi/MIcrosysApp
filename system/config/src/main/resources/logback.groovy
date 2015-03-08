import java.util.logging.Logger;

import ch.qos.logback.classic.Level;

import ch.qos.logback.core.rolling.RollingFileAppender;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.core.rolling.FixedWindowRollingPolicy;
import ch.qos.logback.core.rolling.RollingFileAppender;
import ch.qos.logback.core.rolling.SizeBasedTriggeringPolicy;

import com.microsys.app.config.LogConfig;

LogConfig config = new LogConfig();
String rootLoglevel = config.getProperty("log.config.level.root");
String payrollLoglevel = config.getProperty("log.config.level.payroll");
String fileSize = config.getProperty("log.config.filesize");
String logPath = config.getProperty("log.config.path");

def String logPattern = "%d{dd:mm:yyyy'T'HH:mm:ss.SSS} | %class - %level | %message | %ex%n";
def String logFileSuffix = ".log";
def String archiveLog = "%d{dd:mm:yyyy}.zip";

appender("rootAppender", RollingFileAppender){
	file = logPath + "root"+ logFileSuffix;
	encoder(PatternLayoutEncoder) { pattern = logPattern; }
	rollingPolicy(FixedWindowRollingPolicy){
		maxIndex = 1;
		fileNamePattern = logPath+"/root-%i-"+archiveLog;
	}
	triggeringPolicy(SizeBasedTriggeringPolicy){ maxFileSize = fileSize}
}

appender("payrollAppender", RollingFileAppender){
	file = logPath + "payroll"+ logFileSuffix;
	encoder(PatternLayoutEncoder) { pattern = logPattern; }
	rollingPolicy(FixedWindowRollingPolicy){
		maxIndex = 1;
		fileNamePattern = logPath+"/payroll-%i-"+archiveLog;
	}
	triggeringPolicy(SizeBasedTriggeringPolicy){ maxFileSize = fileSize}
}

root(Level.valueOf(rootLoglevel), ["rootAppender"]);
logger("com.payroll",Level.valueOf(payrollLoglevel), ["payrollAppender"],false);