package com.project.ainurse.utils;

import javafx.animation.FadeTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;
import java.net.URL;

public class pagemanager {
    private static StackPane areaTengah;


    private static MediaPlayer bgPlayer;
    private static MediaView bgView;


    public static String halamanAktif = "";

    public static void setAreaTengah(StackPane area) {
        areaTengah = area;
    }


    private static void cekDanNyalakanVideo() {
        if (bgPlayer == null && areaTengah != null) {
            try {

                URL mediaUrl = pagemanager.class.getResource("/com/project/ainurse/bg1.mp4");
                if (mediaUrl != null) {
                    Media media = new Media(mediaUrl.toExternalForm());
                    bgPlayer = new MediaPlayer(media);
                    bgPlayer.setCycleCount(MediaPlayer.INDEFINITE);

                    bgView = new MediaView(bgPlayer);


                    bgView.fitWidthProperty().bind(areaTengah.widthProperty());
                    bgView.fitHeightProperty().bind(areaTengah.heightProperty());
                    bgView.setPreserveRatio(false);

                    bgPlayer.play();
                    System.out.println("SUKSES: Video Background Global Menyala!");
                } else {
                    System.out.println("GAGAL: File bg1.mp4 tidak ditemukan!");
                }
            } catch (Exception e) {
                System.out.println("Error memuat video: " + e.getMessage());
            }
        }
    }

    public static void pindahHalaman(String namaFileFxml) {
        try {

            halamanAktif = namaFileFxml;


            FXMLLoader loader = new FXMLLoader(pagemanager.class.getResource("/com/project/ainurse/" + namaFileFxml));
            Parent tampilanBaru = loader.load();


            tampilanBaru.setStyle("-fx-background-color: transparent;");


            boolean isMainMenu = namaFileFxml.equals("menuutama.fxml");

            if (isMainMenu) {

                cekDanNyalakanVideo();
                if (bgPlayer != null) {
                    bgPlayer.seek(Duration.ZERO);
                    bgPlayer.play();
                }
                areaTengah.setStyle("-fx-background-color: transparent;");
                areaTengah.getChildren().clear();
                if (bgView != null) {
                    areaTengah.getChildren().add(bgView);
                }
            } else {

                if (bgPlayer != null) {
                    bgPlayer.pause();
                }
                areaTengah.setStyle("-fx-background-color: #FAD5E6;");
                areaTengah.getChildren().clear();
            }


            areaTengah.getChildren().add(tampilanBaru);


            FadeTransition transisiMulus = new FadeTransition(Duration.millis(600), tampilanBaru);
            transisiMulus.setFromValue(0.0);
            transisiMulus.setToValue(1.0);
            transisiMulus.play();

        } catch (Exception e) {
            System.out.println("Gagal memuat halaman: " + namaFileFxml);
            e.printStackTrace();
        }
    }
}
