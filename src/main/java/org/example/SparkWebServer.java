package org.example;


import static spark.Spark.*;

public class SparkWebServer {

    public static void main(String... args){
        port(getPort());
        get("hello", (req,res) -> "Hello cesar!");
        get("calcular/sin", (req, res) -> {
            double angle = Double.parseDouble(req.queryParams("angle"));
            double resp = Math.sin(Math.toRadians(angle));
            String response = "<!DOCTYPE html>"
                    + "<html>\n"
                    + "<head>"
                    + "<style>"
                    + "body {"
                    + "    font-family: Arial, sans-serif;"
                    + "    background-color: rgb(255, 122, 89);"
                    + "    text-align: center;"
                    + "}"
                    + "h1 {"
                    + "    color: white;"
                    + "    font-size: 48px;"
                    + "    margin-top: 50px;"
                    + "}"
                    + "p {"
                    + "    color: white;"
                    + "    font-size: 48px;"
                    + "    margin-top: 50px;"
                    + "}"
                    + "</style>"
                    + "</head>"
                    + "<body>"
                    + "<h1>el resultado del SIN del angulo "+angle+" es: </h1>"
                    + "<p>" + resp + "<p>"
                    + "</body>"
                    + "</html>";

            return response;
        });

        get("/calcular/cos", (req,res) -> {
            double angle = Double.parseDouble(req.queryParams("angle"));
            double resp = Math.cos(Math.toRadians(angle));
            String response = "<!DOCTYPE html>"
                    + "<html>\n"
                    + "<head>"
                    + "<style>"
                    + "body {"
                    + "    font-family: Arial, sans-serif;"
                    + "    background-color: rgb(255, 122, 89);"
                    + "    text-align: center;"
                    + "}"
                    + "h1 {"
                    + "    color: white;"
                    + "    font-size: 48px;"
                    + "    margin-top: 50px;"
                    + "}"
                    + "p {"
                    + "    color: white;"
                    + "    font-size: 48px;"
                    + "    margin-top: 50px;"
                    + "}"
                    + "</style>"
                    + "</head>"
                    + "<body>"
                    + "<h1>el resultado del COS del angulo "+angle+" es: </h1>"
                    + "<p>" + resp + "<p>"
                    + "</body>"
                    + "</html>";
            return response;
        });

        get("/palindromo", (req,res) -> {
            String palabra = req.queryParams("palabra").toLowerCase();
            String word = palabra.replaceAll("[^a-z]", "");
            String resp = "";
            if (word.equals(new StringBuilder(word).reverse().toString())) {
                resp = "La palabra '"+palabra+"' es un palíndromo";
            } else {
                resp = "La palabra '"+palabra+"' no es un palíndromo";
            }
            String response = "<!DOCTYPE html>"
                    + "<html>\n"
                    + "<head>"
                    + "<style>"
                    + "body {"
                    + "    font-family: Arial, sans-serif;"
                    + "    background-color: rgb(255, 122, 89);"
                    + "    text-align: center;"
                    + "}"
                    + "h1 {"
                    + "    color: white;"
                    + "    font-size: 48px;"
                    + "    margin-top: 50px;"
                    + "}"
                    + "p {"
                    + "    color: white;"
                    + "    font-size: 48px;"
                    + "    margin-top: 50px;"
                    + "}"
                    + "</style>"
                    + "</head>"
                    + "<body>"
                    + "<h1>" + resp + "<h1>"
                    + "</body>"
                    + "</html>";
            return response;
        });

        get("/calcular/magnitud", (req,res) -> {
            double x = Double.parseDouble(req.queryParams("x"));
            double y = Double.parseDouble(req.queryParams("y"));
            double magnitud = Math.sqrt(x * x + y * y);
            String response = "<!DOCTYPE html>"
                    + "<html>\n"
                    + "<head>"
                    + "<style>"
                    + "body {"
                    + "    font-family: Arial, sans-serif;"
                    + "    background-color: rgb(255, 122, 89);"
                    + "    text-align: center;"
                    + "}"
                    + "h1 {"
                    + "    color: white;"
                    + "    font-size: 48px;"
                    + "    margin-top: 50px;"
                    + "}"
                    + "p {"
                    + "    color: white;"
                    + "    font-size: 48px;"
                    + "    margin-top: 50px;"
                    + "}"
                    + "</style>"
                    + "</head>"
                    + "<body>"
                    + "<h1> La magnitud del vector ( "+ x +" , " + y + ") es:  </h1>"
                    + "<p>" + magnitud + "<p>"
                    + "</body>"
                    + "</html>";

            return response;
        });
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

}