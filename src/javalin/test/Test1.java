package javalin.test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import io.javalin.Javalin;

public class Test1 {

	public final static int PORT = 8089;

	public static String getContentPage(boolean withTime) {
		String htmlPage = "<!DOCTYPE> <html><head><title>Message with timestamp</title></head><body>";

		htmlPage += "<h2>" + (withTime? LocalDateTime.now() : LocalDate.now()) + "</h2>";
		htmlPage += "</body></html>";
		
		return htmlPage;
	}

	public static void main(String[] args) {

		Javalin app = Javalin.create().start(PORT);

		app.get("/date", ctx -> ctx.html(getContentPage(false)));
		app.get("/datetime", ctx -> ctx.html(getContentPage(true)));
	}
}
