package mycode;

import java.util.Random;
import java.util.Scanner;

class MusicPlayer {
    private String[] emotions = {"Happy", "Sad", "Energetic", "Calm"};
    private String currentEmotion;

    public MusicPlayer() {
        currentEmotion = "Neutral";
    }

    public void playMusic() {
        System.out.println("Playing music for " + currentEmotion + " emotion...");
    
    }

    public void detectEmotion() {
        System.out.println("Simulating emotion detection...");
        Random random = new Random();
        int randomIndex = random.nextInt(emotions.length);
        currentEmotion = emotions[randomIndex];
    }
}

public class EmotionResponsiveMusicPlayer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MusicPlayer musicPlayer = new MusicPlayer();

        while (true) {
            System.out.println("1. Detect Emotion and Play Music");
            System.out.println("2. Stop");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    musicPlayer.detectEmotion();
                    musicPlayer.playMusic();
                    break;
                case 2:
                    System.out.println("Exiting Emotion-Responsive Music Player. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

