package com.framework.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FrontServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        String url = request.getRequestURL().toString();

        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"fr\">");
        out.println("<head>");
        out.println("  <meta charset=\"UTF-8\">\n  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
        out.println("  <title>Framework_S5 - FrontServlet</title>");
        out.println("  <style>\n" +
                "    :root{--bg:#0f172a;--panel:#111827;--text:#e5e7eb;--accent:#60a5fa;}\n" +
                "    body{margin:0;background:linear-gradient(135deg,#0b1020,#111827);color:var(--text);font-family:Inter,system-ui,-apple-system,Segoe UI,Roboto,Ubuntu,\"Helvetica Neue\",Arial,sans-serif;min-height:100vh;display:flex;align-items:center;justify-content:center;}\n" +
                "    .card{background:rgba(17,24,39,.72);backdrop-filter:blur(10px);border:1px solid rgba(148,163,184,.15);border-radius:16px;max-width:720px;width:92%;padding:28px 28px;box-shadow:0 10px 30px rgba(0,0,0,.35);}\n" +
                "    .title{display:flex;align-items:center;gap:10px;font-weight:700;letter-spacing:.3px;margin:0 0 10px 0;}\n" +
                "    .badge{display:inline-flex;align-items:center;gap:6px;font-size:12px;border:1px solid rgba(148,163,184,.25);border-radius:999px;padding:6px 10px;color:#cbd5e1;}\n" +
                "    .pill{background:rgba(96,165,250,.12);color:#93c5fd;border:1px solid rgba(96,165,250,.25);}\n" +
                "    .url{font-family:ui-monospace,SFMono-Regular,Menlo,Monaco,Consolas,\"Liberation Mono\",\"Courier New\",monospace;background:rgba(2,6,23,.75);border:1px solid rgba(148,163,184,.18);padding:12px 14px;border-radius:12px;color:#e2e8f0;word-break:break-all;margin:14px 0 6px 0;}\n" +
                "    .muted{color:#94a3b8;margin:0 0 18px 0;}\n" +
                "    .footer{display:flex;gap:10px;flex-wrap:wrap;align-items:center;opacity:.9;}\n" +
                "    .chip{font-size:12px;border-radius:999px;padding:6px 10px;border:1px solid rgba(148,163,184,.25);color:#cbd5e1;}\n" +
                "    .accent{border-color:rgba(96,165,250,.35);color:#bfdbfe;}\n" +
                "  </style>");
        out.println("</head>");
        out.println("<body>");
        out.println("  <div class=\"card\">\n" +
                "    <div class=\"title\"><span style=\"color:#93c5fd\">Framework_S5</span> · FrontServlet</div>\n" +
                "    <div class=\"badge pill\">Requête capturée par le FrontController</div>\n" +
                "    <pre class=\"url\">" + url + "</pre>\n" +
                "    <p class=\"muted\">Cette page est servie par <strong>com.framework.servlet.FrontServlet</strong> (Jakarta Servlet).\n" +
                "    Votre framework est correctement déployé.</p>\n" +
                "    <div class=\"footer\">\n" +
                "      <span class=\"chip accent\">Jakarta Servlet 5+</span>\n" +
                "      <span class=\"chip\">Tomcat</span>\n" +
                "      <span class=\"chip\">Java</span>\n" +
                "    </div>\n" +
                "  </div>");
        out.println("</body>");
        out.println("</html>");

        System.out.println("URL demandée: " + url);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        service(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        service(request, response);
    }
}
