package mycode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Player {
    private String playerName;

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }
}

class Team {
    private String teamName;
    private List<Player> players;

    public Team(String teamName) {
        this.teamName = teamName;
        players = new ArrayList<>();
    }

    public String getTeamName() {
        return teamName;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public List<Player> getPlayers() {
        return players;
    }
}

class Tournament {
    private String tournamentName;
    private List<Team> teams;

    public Tournament(String tournamentName) {
        this.tournamentName = tournamentName;
        teams = new ArrayList<>();
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public void addTeam(Team team) {
        teams.add(team);
    }

    public List<Team> getTeams() {
        return teams;
    }
}

public class ESports {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the E-Sports Tournament Registration System");
        System.out.print("Enter the name of the tournament: ");
        String tournamentName = scanner.nextLine();
        Tournament tournament = new Tournament(tournamentName);

        while (true) {
            System.out.print("Enter team name: ");
            String teamName = scanner.nextLine();
            if (teamName.equalsIgnoreCase("done")) {
                break;
            }

            Team team = new Team(teamName);

            while (true) {
                System.out.print("Enter player name: ");
                String playerName = scanner.nextLine();
                if (playerName.equalsIgnoreCase("done")) {
                    break;
                }

                Player player = new Player(playerName);
                team.addPlayer(player);
            }

            tournament.addTeam(team);
        }

        System.out.println("\nTournament Information:");
        System.out.println("Tournament Name: " + tournament.getTournamentName());
        System.out.println("Teams Registered:");
        for (Team team : tournament.getTeams()) {
            System.out.println("Team Name: " + team.getTeamName());
            System.out.println("Players:");
            for (Player player : team.getPlayers()) {
                System.out.println("- " + player.getPlayerName());
            }
        }
    }
}


