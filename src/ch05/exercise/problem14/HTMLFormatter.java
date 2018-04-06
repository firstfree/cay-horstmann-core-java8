package ch05.exercise.problem14;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class HTMLFormatter extends Formatter {
	@Override
	public String format(LogRecord record) {
		StringBuilder sb = new StringBuilder();
		sb.append("<html>\n");
		sb.append("  <head>\n");
		sb.append("    <meta charset=\"UTF-8\">");
		sb.append("    <title>");
		sb.append(record.getLoggerName());
		sb.append("</title>\n");
		sb.append("  </head>\n");
		sb.append("  <body>\n");
		sb.append("    <span>date:");
		sb.append(LocalDateTime.ofInstant(Instant.ofEpochMilli(record.getMillis()), ZoneId.systemDefault()));
		sb.append("</span><br>\n");
		sb.append("    <span>millis:");
		sb.append(record.getMillis());
		sb.append("</span><br>\n");
		sb.append("    <span>sequence:");
		sb.append(record.getSequenceNumber());
		sb.append("</span><br>\n");
		sb.append("    <span>logger:");
		sb.append(record.getLoggerName());
		sb.append("</span><br>\n");
		sb.append("    <span>level:");
		sb.append(record.getLevel());
		sb.append("</span><br>\n");
		sb.append("    <span>class:");
		sb.append(record.getSourceClassName());
		sb.append("</span><br>\n");
		sb.append("    <span>method:");
		sb.append(record.getSourceMethodName());
		sb.append("</span><br>\n");
		sb.append("    <span>method:");
		sb.append(record.getThreadID());
		sb.append("</span><br>\n");
		sb.append("    <span>message:");
		sb.append(formatMessage(record));
		sb.append("</span>\n");
		sb.append("  </body>\n");
		sb.append("</html>");
		
		return sb.toString();
	}
}
