package com.project.ainurse.utils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class geminiservice {

    private static final String API_KEY = "CREATE_API_BY_YOUR_OWN";

    private static final String API_URL = "https://api.groq.com/openai/v1/chat/completions";

    private static final String MODEL_NAME = "openai/gpt-oss-120b";

    public static String tanyaAI(String prompt) {
        try {
            JSONObject systemMessage = new JSONObject();
            systemMessage.put("role", "system");
            systemMessage.put("content", "Anda adalah perawat triase IGD profesional dan cerdas. Tugas Anda adalah MENGKLASIFIKASIKAN status pasien secara dinamis berdasarkan tingkat keparahan, konteks, dan potensi bahaya, BUKAN sekadar mencocokkan kata kunci keluhan.\n" +
                    "- MERAH (Kritis / Mengancam Nyawa): Kondisi yang butuh tindakan instan. (Contoh: sesak napas berat, nyeri dada menjalar, pendarahan aktif, nyeri kepala ekstrem/tiba-tiba, hilang kesadaran).\n" +
                    "- KUNING (Darurat / Sakit Berat): Pasien butuh pertolongan segera tapi kondisi masih stabil. (Contoh: demam sangat tinggi, nyeri hebat tapi pasien sadar penuh, muntah hebat berulang).\n" +
                    "- HIJAU (Ringan / Tidak Gawat): Keluhan umum dengan intensitas ringan-sedang. (Contoh: pusing biasa, batuk/pilek, demam ringan).\n" +
                    "Gunakan nalar medis Anda. Jika pasien menyebut gejala ringan (seperti pusing atau sakit perut) NAMUN intensitasnya sangat parah, durasinya lama, atau disertai gejala penyerta yang bahaya, NAIKKAN prioritasnya menjadi Kuning atau Merah.\n" +
                    "Berikan analisis medis singkat (maksimal 2 kalimat), lalu WAJIB diakhiri dengan format persis seperti ini: [STATUS: MERAH] atau [STATUS: KUNING] atau [STATUS: HIJAU]");

            JSONObject userMessage = new JSONObject();
            userMessage.put("role", "user");
            userMessage.put("content", prompt);

            JSONArray messages = new JSONArray();
            messages.put(systemMessage);
            messages.put(userMessage);

            JSONObject requestBody = new JSONObject();
            requestBody.put("model", MODEL_NAME);
            requestBody.put("messages", messages);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + API_KEY)
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody.toString()))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JSONObject jsonResponse = new JSONObject(response.body());

            if (jsonResponse.has("error")) {
                return "Error API: " + jsonResponse.getJSONObject("error").getString("message");
            }

            return jsonResponse.getJSONArray("choices")
                    .getJSONObject(0)
                    .getJSONObject("message")
                    .getString("content");

        } catch (Exception e) {
            e.printStackTrace();
            return "Maaf, sistem AI sedang bermasalah. Cek console IntelliJ untuk detailnya.";
        }
    }

    public static String chatKlinis(String prompt) {
        try {
            JSONObject systemMessage = new JSONObject();
            systemMessage.put("role", "system");
            systemMessage.put("content", "Anda adalah asisten AI medis senior yang cerdas, ramah, dan sangat membantu. Tugas Anda adalah membantu perawat IGD dalam menjawab pertanyaan klinis, dosis obat umum, atau SOP keperawatan. Jawablah dengan bahasa Indonesia yang profesional, ringkas, dan mudah dipahami.");

            JSONObject userMessage = new JSONObject();
            userMessage.put("role", "user");
            userMessage.put("content", prompt);

            JSONArray messages = new JSONArray();
            messages.put(systemMessage);
            messages.put(userMessage);

            JSONObject requestBody = new JSONObject();
            requestBody.put("model", MODEL_NAME);
            requestBody.put("messages", messages);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + API_KEY)
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody.toString()))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JSONObject jsonResponse = new JSONObject(response.body());

            if (jsonResponse.has("error")) {
                return "Error API: " + jsonResponse.getJSONObject("error").getString("message");
            }

            return jsonResponse.getJSONArray("choices")
                    .getJSONObject(0)
                    .getJSONObject("message")
                    .getString("content");

        } catch (Exception e) {
            e.printStackTrace();
            return "Maaf, koneksi ke AI sedang bermasalah.";
        }
    }
}