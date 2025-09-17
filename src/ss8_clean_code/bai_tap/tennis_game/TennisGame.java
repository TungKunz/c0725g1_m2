package ss8_clean_code.bai_tap.tennis_game;

public class TennisGame {

    private static final String LOVE = "Love";
    private static final String FIFTEEN = "Fifteen";
    private static final String THIRTY = "Thirty";
    private static final String FORTY = "Forty";

    private static final String LOVE_ALL = "Love-All";
    private static final String FIFTEEN_ALL = "Fifteen-All";
    private static final String THIRTY_ALL = "Thirty-All";
    private static final String FORTY_ALL = "Forty-All";
    private static final String DEUCE = "Deuce";

    public static String getScore(String player1Name, String player2Name, int player1Score, int player2Score) {
        if (player1Score == player2Score) {
            return getEqualScore(player1Score);
        } else if (player1Score >= 4 || player2Score >= 4) {
            return getAdvantageOrWin(player1Score, player2Score);
        } else {
            return getRunningScore(player1Score, player2Score);
        }
    }

    private static String getEqualScore(int score) {
        switch (score) {
            case 0: return LOVE_ALL;
            case 1: return FIFTEEN_ALL;
            case 2: return THIRTY_ALL;
            case 3: return FORTY_ALL;
            default: return DEUCE;
        }
    }

    private static String getAdvantageOrWin(int player1Score, int player2Score) {
        int scoreDifference = player1Score - player2Score;
        if (scoreDifference == 1) return "Advantage player1";
        else if (scoreDifference == -1) return "Advantage player2";
        else if (scoreDifference >= 2) return "Win for player1";
        else return "Win for player2";
    }

    private static String getRunningScore(int player1Score, int player2Score) {
        return getScoreName(player1Score) + "-" + getScoreName(player2Score);
    }

    private static String getScoreName(int score) {
        switch (score) {
            case 0: return LOVE;
            case 1: return FIFTEEN;
            case 2: return THIRTY;
            case 3: return FORTY;
            default: throw new IllegalArgumentException("Invalid score: " + score);
        }
    }
}
